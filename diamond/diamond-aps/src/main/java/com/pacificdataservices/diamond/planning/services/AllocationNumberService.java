package com.pacificdataservices.diamond.planning.services;

import java.util.List;

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

@Component
@Repository
@EnableAutoConfiguration
@Transactional
@EnableTransactionManagement
// TODO only get ApsSrcRuleSets used in demand
public class AllocationNumberService extends DiamondDataServices {
	Logger logger = LoggerFactory.getLogger(getClass());

	@SuppressWarnings("unchecked")
	public int getAllocationNumber(int nbrAllocations) {
		// TODO report stats
		
		Session session = getSession();
	    String qstr = "select nextval from aps_alloc_nbr for update";
		Query q = session.createSQLQuery(qstr);
		List<Integer> qdata = q.list();
		Integer bd = qdata.get(0);
		int retval = bd.intValue();
	    
	    String ustr = "update aps_alloc_nbr set nextval = nextval + :qty_allocations";
		Query u = session.createSQLQuery(ustr);
		u.setInteger("qty_allocations", nbrAllocations);
		u.executeUpdate();
	    return retval;
	    
	}
}
