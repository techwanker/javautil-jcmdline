package com.pacificdataservices.diamond.planning.services;

import java.sql.SQLException;
import java.util.List;
import java.util.TreeMap;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.diamond.models.IcItemMast;

public class DiamondDataServices extends BaseDataServices {

	Logger logger = LoggerFactory.getLogger(getClass());
	private Logger analytics = LoggerFactory.getLogger("analytics");
	public DiamondDataServices() {
		super();
	}
	
    

	/**
	 * Used to fetch all of the rows in in a table where
	 * the item identifying column is item_nbr_rqst.
	 * 
	 * @param tableName the java Class Name generate by reveng.
	 * 
	 * For example APS_ALLOC_%.
	 * 
	 * The name refers to the fact that this is what was specified in the demand
	 * although through planning rules this is not necessarily what was allocated.
	 * @param session
	 * @return
	 * @throws SQLException 
	 */
	List getTableDataItemNbrRqst(String tableName, Session session) throws SQLException {
		long stepId = getJobLogger().insertStep(getJobToken(), 
				"getTableDataItemNbrRqst", 
				getClass(),
				tableName);
		  String queryText = "from " + tableName + " where item_nbr_rqst in "
		  		+ " (select itemNbr from TmpItem)";
		  List retval = getList(tableName, queryText, session);
		  analytics.debug("fetch for " + tableName + " returns rows: " + retval.size());
		  getJobLogger().finishStep(stepId);
		  return retval;
	  }
	
	
	/**
	 * Used to fetch all of the rows in in a table where
	 * the item identifying column is item_nbr.
	 * 
	 * @param tableName the java Class Name generate by reveng.
	 * 
	 * For example IC_ITEM_MAST would be specified as IcItemMast.
	 * 
	 * @param session
	 * @return
	 */
	List getTableDataItemNbr(String tableName, Session session) {
		  String queryText = "from " + tableName + " where item_nbr in "
		  		+ " (select itemNbr from TmpItem)";
		  
		  List retval = getList(tableName, queryText, session);
		  analytics.debug("fetch for " + tableName + " returns rows: " + retval.size());
		  return retval;
	  }
	
	/**
	 * Used to fetch all of the rows in in a table where
	 * the item identifying column is item_nbr.
	 * 
	 * @param tableName the java Class Name generate by reveng.
	 * 
	 * For example IC_ITEM_MAST would be specified as IcItemMast.
	 * 
	 * @param session
	 * @return
	 */
	List getTableDataItemNbrDmd(String tableName, Session session) {
		  String queryText = "from " + tableName + " where item_nbr_dmd in "
		  		+ " (select itemNbr from TmpItem)";
		  List retval = getList(tableName, queryText, session);
		  analytics.debug("fetch for " + tableName + " returns rows: " + retval.size());
		  return retval;
	  }
	
	public TreeMap<Integer,IcItemMast> getAllIcItemMasts() {
		Session session = getSession();
		List<IcItemMast> iimList =  getAllSorted("IcItemMast","item_nbr",session);
		TreeMap<Integer,IcItemMast> icItemMastByPk = new TreeMap<>();
		for (IcItemMast iim : iimList) {
			icItemMastByPk.put(iim.getItemNbr(),iim);	
			logger.info("adding icItemMast: {}", iim.getItemNbr());
		}
		return icItemMastByPk;
		
	}



}