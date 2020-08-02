package com.pacificdataservices.diamond.planning.services;

import java.util.List;

import javax.transaction.Transactional;

import org.javautil.util.Timer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.pacificdataservices.diamond.models.ApsRqstQueue;


@Component
@Repository
@EnableAutoConfiguration
@Transactional
@EnableTransactionManagement

public class RequestPopulateService extends DiamondDataServices {
	 
	    private final String deleteSql =  "DELETE FROM aps_rqst_queue ";
	    
	    private final String insertSql = 
	    "INSERT INTO aps_rqst_queue (\n" + 
	    "			item_nbr, dmd_oo_flg, dmd_fc_flg, dmd_wo_flg, sply_oh_flg, sply_po_flg,\n" + 
	    "			sply_wo_flg )\n" + 
	    "		SELECT	item_nbr, dmd_oo_flg, dmd_fc_flg, dmd_wo_flg, sply_oh_flg,\n" + 
	    "				sply_po_flg, sply_wo_flg\n" + 
	    "		FROM	aps_rqst_grp\n" + 
	    "		WHERE 	dmd_oo_flg = 'Y' OR dmd_fc_flg = 'Y' OR dmd_wo_flg = 'Y' OR\n" + 
	    "				sply_oh_flg = 'Y' OR sply_po_flg = 'Y' OR sply_wo_flg = 'Y'";

		private  Logger logger = LoggerFactory.getLogger(getClass());

	    private List<ApsRqstQueue> apsRqstQueue;
	  
	    public RequestPopulateService() {
	    
	    }
	    
	    public void process() {
	    	Timer processTimer = new Timer();
	    	int deleteCount = getSession().createSQLQuery(deleteSql).executeUpdate();
	    	logger.info("deleted aps_rqst_queue {}", deleteCount);
	    	System.out.println("deleted aps_rqst_queue: " +  deleteCount);
	    	int insertCount = getSession().createSQLQuery(insertSql).executeUpdate();
	    	logger.info("inserted aps_rqst_queue{}", insertCount);
	    	System.out.println("inserted aps_rqst_queue: " +  insertCount);
	    	apsRqstQueue = getSession().createQuery("from ApsRqstQueue").list();
	    	logger.info("process elapsed millis: {}", processTimer.getElapsedMillis());
	    }
	    
		public List<ApsRqstQueue> getApsRqstQueue() {
			return apsRqstQueue;
		}
}
