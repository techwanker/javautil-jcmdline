package com.pacificdataservices.diamond.planning.services;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Component
@Repository
@EnableAutoConfiguration
@Transactional
@EnableTransactionManagement

public class PrepareRunService extends DiamondDataServices {
	    
	    private  Logger logger = LoggerFactory.getLogger(getClass());

	    public PrepareRunService() {

	    }

	    
	    public void prepareRun(boolean isBatchMode)  {
//	        String cmd = null;
//	        try {
//	        runStmt(conn,cmd = "alter table aps_alloc_onhand_fc disable constraint aaof_ff_fk");
//	        } catch (SQLException s) {
//	            logger.warning("while running " + cmd + " " + s.getMessage());
//	        }
//	        try {
//	        runStmt(conn,cmd = "alter table aps_alloc_replen_fc disable constraint aarf_ff_fk");
//	        } catch (SQLException s) {
//	            logger.warning("while running " + cmd + " " + s.getMessage());
//	        }

	        cleanTable("aps_alloc_onhand_oo");
	        cleanTable("aps_alloc_onhand_fc");
	        cleanTable("aps_alloc_onhand_ss");
	        cleanTable("aps_alloc_onhand_wo");
	        cleanTable("aps_alloc_replen_oo");
	        cleanTable("aps_alloc_replen_fc");
	        cleanTable("aps_alloc_replen_ss");
	        cleanTable("aps_alloc_replen_wo");
	        cleanTable("aps_alloc_wo_oo");
	        cleanTable( "aps_alloc_wo_fc");
	        cleanTable("aps_alloc_wo_ss");
	        cleanTable( "aps_alloc_wo_wo");
	        cleanTable("aps_result_dtl_dmd");
	        cleanTable("aps_result_dtl_sply");
	        cleanTable("po_resched");
	        cleanTable("po_requisition");
//	        try {
//	        runStmt(conn,cmd = "alter table aps_alloc_onhand_fc enable constraint aaof_ff_fk");
//	        } catch (SQLException s) {
//	            logger.warning("while running " + cmd + " " + s.getMessage());
//	        }
//	        try {
//	        runStmt(conn,cmd = "alter table aps_alloc_replen_fc enable constraint aarf_ff_fk");
//	        } catch (SQLException s) {
//	            logger.warning("while running " + cmd + " " + s.getMessage());
//	        }
	    }
	   
}
