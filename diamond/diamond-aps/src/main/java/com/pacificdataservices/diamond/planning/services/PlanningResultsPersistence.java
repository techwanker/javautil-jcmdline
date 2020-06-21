package com.pacificdataservices.diamond.planning.services;

import javax.transaction.Transactional;

import org.hibernate.Query;
//import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.pacificdataservices.diamond.models.ApsAllocOnhandFc;
import com.pacificdataservices.diamond.models.ApsAllocOnhandOo;
import com.pacificdataservices.diamond.models.ApsAllocOnhandSs;
import com.pacificdataservices.diamond.models.ApsAllocOnhandWo;
import com.pacificdataservices.diamond.models.ApsAllocReplenFc;
import com.pacificdataservices.diamond.models.ApsAllocReplenOo;
import com.pacificdataservices.diamond.models.ApsAllocReplenSs;
import com.pacificdataservices.diamond.models.ApsAllocReplenWo;
import com.pacificdataservices.diamond.models.ApsAllocWoFc;
import com.pacificdataservices.diamond.models.ApsAllocWoOo;
import com.pacificdataservices.diamond.models.ApsAllocWoSs;
import com.pacificdataservices.diamond.models.ApsAllocWoWo;
import com.pacificdataservices.diamond.models.ApsResultDtlDmd;
import com.pacificdataservices.diamond.planning.data.PlanningResult;

@Component
@Repository
@EnableAutoConfiguration
@Transactional
@EnableTransactionManagement
// TODO only get ApsSrcRuleSets used in demand
public class PlanningResultsPersistence extends DiamondDataServices {
	Logger logger = LoggerFactory.getLogger(getClass());

	@SuppressWarnings("unchecked")
	public void persistPlanningResult(PlanningResult pr) {
		nukeAllocations(pr);
		Session session = getSession();
		for (ApsAllocOnhandOo a : pr.getApsAllocOnhandOos()) {
			session.save(a);
		}
		for (ApsAllocOnhandFc a : pr.getApsAllocOnhandFcs()) {
			session.save(a);
		}
		for (ApsAllocOnhandSs a : pr.getApsAllocOnhandSss()) {
			session.save(a);
		}
		for (ApsAllocOnhandWo a : pr.getApsAllocOnhandWos()) {
			session.save(a);
		}
		for (ApsAllocReplenOo a : pr.getApsAllocReplenOos()) {
			session.save(a);
		}
		for (ApsAllocReplenFc a : pr.getApsAllocReplenFcs()) {
			session.save(a);
		}
		for (ApsAllocReplenSs a : pr.getApsAllocReplenSss()) {
			session.save(a);
		}
		for (ApsAllocReplenWo a : pr.getApsAllocReplenWos()) {
			session.save(a);
		}
		for (ApsAllocWoOo a : pr.getApsAllocWoOos()) {
			session.save(a);
		}
		for (ApsAllocWoFc a : pr.getApsAllocWoFcs()) {
			session.save(a);
		}
		for (ApsAllocWoSs a : pr.getApsAllocWoSss()) {
			session.save(a);
		}
		for (ApsAllocWoWo a : pr.getApsAllocWoWos()) {
			session.save(a);
		}
		nukeApsResultDmdDtl();
		for (ApsResultDtlDmd ardd : pr.getApsResultDtlDmds()) {
			session.save(ardd);
		}
	}

	private void nukeApsResultDmdDtl() {
		deleteForTmpItem("aps_result_dtl_dmd",getSession());
	}

	void nukeAllocations(PlanningResult pr) {
		Session session = getSession();
		PlanningDataService.populateTmpItemSql(pr.getItemNumbers(),session);
		deleteForTmpItem("aps_alloc_onhand_oo", session);
		deleteForTmpItem("aps_alloc_onhand_fc", session);
		deleteForTmpItem("aps_alloc_onhand_ss", session);
		deleteForTmpItem("aps_alloc_onhand_wo", session);
		deleteForTmpItem("aps_alloc_replen_oo", session);
		deleteForTmpItem("aps_alloc_replen_fc", session);
		deleteForTmpItem("aps_alloc_replen_ss", session);
		deleteForTmpItem("aps_alloc_replen_wo", session);
		deleteForTmpItem("aps_alloc_wo_oo", session);
		deleteForTmpItem("aps_alloc_wo_fc", session);
		deleteForTmpItem("aps_alloc_wo_ss", session);
		deleteForTmpItem("aps_alloc_wo_wo", session);
	}

	void deleteForTmpItem(String tableName, Session session) {
		String sqlText = "delete from " + tableName + " where item_nbr_rqst in "
				+ " (select item_Nbr from Tmp_Item)";
		Query q = session.createSQLQuery(sqlText);
		q.executeUpdate();
	}
}