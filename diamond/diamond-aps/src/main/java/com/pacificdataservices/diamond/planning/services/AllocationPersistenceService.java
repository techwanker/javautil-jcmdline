package com.pacificdataservices.diamond.planning.services;

import java.io.File;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.pacificdataservices.diamond.planning.StringBean;
import com.pacificdataservices.diamond.planning.data.PlanningData;

@Component
@Repository
@EnableAutoConfiguration
@Transactional
@EnableTransactionManagement
// TODO only get ApsSrcRuleSets used in demand
public class AllocationPersistenceService extends DiamondDataServices {
	Logger logger = LoggerFactory.getLogger(getClass());
	private StringBean stringBean = new StringBean();
	private Logger analytics = LoggerFactory.getLogger("analytics");
	private PlanningData pd;
	//@Autowired
	/** 
	 * If true, sourcing rules not used are delete, but this is an 
	 * expensive operation and should be done another way should this be
	 * used in production TOOD
	 */
	private boolean trimSourcingRules = false;
	private File marshallFile;

	public void assertNotNull(Object o) {
		if (o == null) {
			throw new IllegalStateException("null found");
		}
	}

	public void persist(PlanningData planningData) {
		int planGrpNbr  = planningData.getPlanGrpNbr();
		deleteOldAllocations(planGrpNbr);
		insertAllocations(planningData);
	}

	public void deleteAllocationsFromTable(String tableName, int planGrpNbr)	{
		Query q =getSession().createSQLQuery("delete from " + tableName +  " where item_nbr_rqst in " +
                "select item_nbr from aps_plan_grp where plan_grp_nbr = :plan_grp_nbr");
		q.setParameter("plan_grp_nbr",planGrpNbr);
		q.executeUpdate();
    }

	public void deleteOldAllocations(int planGrpNbr) {
	      deleteAllocationsFromTable("APS_ALLOC_ONHAND_FC",planGrpNbr);
	      deleteAllocationsFromTable("APS_ALLOC_ONHAND_OO" ,planGrpNbr);
	      deleteAllocationsFromTable("APS_ALLOC_ONHAND_SS",planGrpNbr);
	      deleteAllocationsFromTable("APS_ALLOC_ONHAND_WO",planGrpNbr);
	      deleteAllocationsFromTable("APS_ALLOC_REPLEN_FC",planGrpNbr);
	      deleteAllocationsFromTable("APS_ALLOC_REPLEN_OO",planGrpNbr);
	      deleteAllocationsFromTable("APS_ALLOC_REPLEN_SS",planGrpNbr);
	      deleteAllocationsFromTable("APS_ALLOC_REPLEN_WO",planGrpNbr);
	      deleteAllocationsFromTable("APS_ALLOC_WO_FC",planGrpNbr);
	      deleteAllocationsFromTable("APS_ALLOC_WO_OO",planGrpNbr);
	      deleteAllocationsFromTable("APS_ALLOC_WO_SS",planGrpNbr);
	      deleteAllocationsFromTable("APS_ALLOC_WO_WO",planGrpNbr);
	}

   private void insertAllocations(PlanningData planningData) {
		
	}

}
