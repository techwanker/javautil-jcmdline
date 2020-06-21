//package com.pacificdataservices.diamond.planning.services;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.EntityManagerFactory;
//
//import org.hibernate.HibernateException;
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.transform.Transformers;
//import org.javautil.core.sql.Binds;
//import org.javautil.core.sql.SqlStatement;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
//
//public class BaseDataJDBCServices {
//	private final Logger logger = LoggerFactory.getLogger(getClass());
//
//
//	private Connection connection;
//
//	public BaseDataJDBCServices(Connection connection) {
//		super();
//		this.connection = connection;
//	}
//
//	
//
//
//	protected void deleteAll(String tableName,Session session) {
//		 String hql = "delete from " + tableName;
//		  Query query = session.createQuery(hql);
//		  query.executeUpdate();
//	}
//	
//	protected List getAllSql(@SuppressWarnings("rawtypes") Class clazz, String sql)  {
//		ArrayList<? extends Object> retval = null;
//		SqlStatement ss = null;
//		try {
//			ss = new SqlStatement(connection,sql);
//			return ss.getListOfNameValue(new Binds(), true);
//		} catch (SQLException e) {
//			logger.error(e.getMessage());
//			throw new PlanningSQLException(e.getMessage());
//		} finally {
//			try {
//				ss.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch` block
//				e.printStackTrace();
//			}
//		}
//		throw new IllegalStateException();
//	}
//	/**
//	 * Returns all rows in the specified table.
//	 * 
//	 * @param tableName
//	 *            the classname for the table for example APS_SRC_RULE would be
//	 *            ApsSrcRule
//	 * @param session
//	 * @return
//	 */
//	@SuppressWarnings("rawtypes")
//	protected List getAll(String tableName) {
//		String queryText = "from " + tableName;
//		return getList(tableName, queryText);
//	}
//	
////	@SuppressWarnings("rawtypes")
////	protected <T> List<T> getAll(<T> Class clazz, Session session) {
////		String queryText = "from " + tableName;
////		return getList(tableName, queryText, session);
////	}
//	
//	/*
//	 * Returns all rows in the specified table sorted by order by
//	 * 
//	 * Example:
//	 *   getAllSorted("IcItemMast","ic_item_nbr",session)
//	 * 
//	 * @param tableName
//	 *            the classname for the table for example APS_SRC_RULE would be
//	 *            ApsSrcRule
//	 * @param session
//	 * @return
//	 */
//	@SuppressWarnings("rawtypes")
//	protected List getAllSorted(String tableName, String orderBy, Session session) {
//		String queryText = "from " + tableName + " order by "  + orderBy;
//		return getList(tableName, queryText);
//	}
//
//	@SuppressWarnings("rawtypes")
//	protected List getList(String tableName, String queryText) {
//		long start = System.nanoTime();
//		ArrayList<? extends Object> retval= null;
////		Query query = session.createQuery(queryText);
////		List result = query.list();
////		long end = System.nanoTime();
////		long millis = (end - start) / 1000000;
////		logger.debug("table: " + tableName + " millis " + millis + " rows:  " + result.size());
//		return retval;
//	}
//
//	protected void cleanTable(String tableName) {
//		throw new UnsupportedOperationException();
//	}
//}