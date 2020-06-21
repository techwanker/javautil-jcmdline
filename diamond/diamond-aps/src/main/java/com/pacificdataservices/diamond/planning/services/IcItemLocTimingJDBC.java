package com.pacificdataservices.diamond.planning.services;

import java.beans.PropertyVetoException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//https://stackoverflow.com/questions/25063995/spring-boot-handle-to-hibernate-sessionfactory
//https://stackoverflow.com/questions/1657557/spring-hibernate-unknown-entity

import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.beanutils.BeanUtils;
import org.javautil.core.misc.Timer;
import org.javautil.core.sql.Binds;
import org.javautil.core.sql.DataSourceFactory;
import org.javautil.core.sql.SqlStatement;
import org.javautil.util.ListOfNameValue;
import org.javautil.util.NameValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.diamond.models.IcLotMast;
import com.pacificdataservices.diamond.planning.data.PlanningData;



public class IcItemLocTimingJDBC {
	Logger logger = LoggerFactory.getLogger(getClass());
	private Logger analytics = LoggerFactory.getLogger("analytics");

	/**
	 * If true, sourcing rules not used are delete, but this is an expensive
	 * operation and should be done another way should this be used in production
	 * TOOD
	 */
	private boolean trimSourcingRules = false;

	@SuppressWarnings("unchecked")
	public PlanningData getPlanningDataJDBC(Collection<Integer> itemNumbers)
			throws PropertyVetoException, SQLException, IllegalAccessException, InvocationTargetException {
		DataSourceFactory factory = new DataSourceFactory();
		logger.info("about to getDataSource");
		DataSource ds = factory.getDatasource("aps19");
		Connection conn = ds.getConnection();
		logger.info("got connection");
		 
		
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
		logger.info("got {} records",lonv.size());
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

		return pd;

	}


}
