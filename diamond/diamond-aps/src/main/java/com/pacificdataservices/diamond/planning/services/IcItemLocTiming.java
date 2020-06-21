package com.pacificdataservices.diamond.planning.services;

import java.beans.PropertyVetoException;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//https://stackoverflow.com/questions/25063995/spring-boot-handle-to-hibernate-sessionfactory
//https://stackoverflow.com/questions/1657557/spring-hibernate-unknown-entity

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Query;
//import org.hibernate.Query;
import org.hibernate.Session;
import org.javautil.core.misc.Timer;
import org.javautil.core.sql.Binds;
import org.javautil.core.sql.DataSourceFactory;
import org.javautil.core.sql.SqlStatement;
import org.javautil.util.ListOfNameValue;
import org.javautil.util.NameValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.pacificdataservices.diamond.models.IcLotMast;
import com.pacificdataservices.diamond.models.TmpItem;
import com.pacificdataservices.diamond.planning.data.PlanningData;

@Component
@Repository
@EnableAutoConfiguration
@Transactional
@EnableTransactionManagement

public class IcItemLocTiming extends DiamondDataServices {
	Logger logger = LoggerFactory.getLogger(getClass());
	private Logger analytics = LoggerFactory.getLogger("analytics");

	/**
	 * If true, sourcing rules not used are delete, but this is an expensive
	 * operation and should be done another way should this be used in production
	 * TOOD
	 */
	private boolean trimSourcingRules = false;

	@SuppressWarnings("unchecked")
	public PlanningData getPlanningData(Collection<Integer> itemNumbers) {
	//	logger.debug("\n***********\ngetting {}\n************", itemNumbers);
		PlanningData pd = new PlanningData();
		Timer getPlanningDataTimer = new Timer();
		String logMessage = null;
		Session session = getSession();

		//analytics.debug("getPlanningData for " + itemNumbers.toString());
		populateTmpItemJpa(itemNumbers, session);

		pd.setIcLotMasts(getTableDataItemNbr("IcLotMast", session));

		long fetchTime = getPlanningDataTimer.getElapsedMicros();
		logMessage = String.format("***\ngetPlanningData fetch Micros %d totalMicros %d\n***", fetchTime,
				getPlanningDataTimer.getElapsedMicros());
		logger.info(logMessage);
		analytics.debug(logMessage);

		return pd;
	}

	@SuppressWarnings("unchecked")
	public PlanningData getPlanningDataJDBC(Collection<Integer> itemNumbers)
			throws PropertyVetoException, SQLException, IllegalAccessException, InvocationTargetException, IOException {
		DataSourceFactory factory = new DataSourceFactory();
	//	logger.info("about to getDataSource");
		DataSource ds = factory.getDatasource("aps19");
		Connection conn = ds.getConnection();
		logger.info("conn is " + conn);
	//	logger.info("got connection");
		 
		
		Statement stmt = conn.createStatement();
		stmt.execute("delete from tmp_item");
		SqlStatement ss = new SqlStatement(conn, "insert into tmp_item(item_nbr) values ( :item_nbr )");
		Binds binds = new Binds();
		for (Integer itemNbr : itemNumbers) {
			binds.put("item_nbr", itemNbr);
			ss.executeUpdate(binds);
		}
		ss.close();

		Timer getPlanningDataTimer = new Timer();

		List<IcLotMast> lotMasts = new ArrayList<IcLotMast>();

		String sql = "select * from ic_lot_mast where item_nbr in (select item_nbr from tmp_item)";
		ss = new SqlStatement(conn, sql);
		ListOfNameValue lonv = ss.getListOfNameValue(new Binds());
		//logger.info("got {} records",lonv.size());
		for (NameValue nv : lonv) {
			IcLotMast ilm = new IcLotMast();
			BeanUtils.populate(ilm, nv);
			int lotNbr = nv.getInteger("lot_nbr");
			ilm.setLotNbr(lotNbr);
			lotMasts.add(ilm);
		}
		long elapsedMicros = getPlanningDataTimer.getElapsedMicros();
		logger.info("jdbc micros {}", elapsedMicros);

		PlanningData pd = new PlanningData();
		pd.setIcLotMasts(lotMasts);
		conn.close();
		((Closeable)ds).close();
		return pd;

	}

	public Set<Integer> populateTmpItemSql(Collection<Integer> itemNumbers, Session session) {
		session.beginTransaction();
		Query q = session.createSQLQuery("delete from tmp_item");
		int count = q.executeUpdate();
		//logger.debug("deleted " + count + " from tmp_item");

		Query ins = session.createSQLQuery("insert into tmp_item (item_nbr) values (:item_nbr)");
		for (Integer itemNumber : itemNumbers) {
			ins.setParameter("item_nbr", itemNumber);
			int rowCount = ins.executeUpdate();
		//	logger.debug("Inserted " + itemNumber + " rows " + rowCount);
		}

		session.flush();
		q = session.createSQLQuery("select count(*) cnt from tmp_item"); // TODO there is nothing here
		@SuppressWarnings("unchecked")
		List<BigDecimal> results = q.list();
		BigDecimal cnt = results.get(0);
		String message = "tmp_item row count = " + cnt;

		q = session.createQuery("from TmpItem");
		List<TmpItem> rows = q.list();
		Set<Integer> itemsInTmpItem = new HashSet<Integer>();
		for (TmpItem row : rows) {
			itemsInTmpItem.add(row.getItemNbr());
		}
		System.out.print(message);
		//logger.debug(message);
		if (itemsInTmpItem.size() != itemNumbers.size()) {
			logger.error("expected " + itemNumbers + " but got " + itemsInTmpItem);
		}

		return itemsInTmpItem;

	}

	public Set<Integer> populateTmpItemJpa(Collection<Integer> itemNumbers, Session session) {
		Query q = session.createSQLQuery("delete from tmp_item");
		int count = q.executeUpdate();
		//logger.debug("deleted " + count + " from tmp_item");

		for (Integer itemNumber : itemNumbers) {
			TmpItem ti = new TmpItem();
			ti.setItemNbr(itemNumber);
			//logger.debug("inserting " + itemNumber);
			session.persist(ti);
		}

		//logger.debug("about to flush");
		session.flush();
		//logger.debug("flushed");
		q = session.createSQLQuery("select count(*) cnt from tmp_item"); // TODO there is nothing here
		@SuppressWarnings("unchecked")
		List<Number> results = q.list();
		Number cnt = results.get(0);
		String message = "tmp_item row count = " + cnt;

		q = session.createQuery("from TmpItem");
		List<TmpItem> rows = q.list();
		Set<Integer> itemsInTmpItem = new HashSet<Integer>();
		for (TmpItem row : rows) {
			itemsInTmpItem.add(row.getItemNbr());
		}
		//logger.debug(message);
		if (itemsInTmpItem.size() != itemNumbers.size()) {
			logger.error("expected " + itemNumbers + " but got " + itemsInTmpItem);
		}
		return itemsInTmpItem;

	}

	public boolean isTrimSourcingRules() {
		return trimSourcingRules;
	}

	public void setTrimSourcingRules(boolean trimSourcingRules) {
		this.trimSourcingRules = trimSourcingRules;
	}

}
