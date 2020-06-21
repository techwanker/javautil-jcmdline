package com.pacificdataservices.diamond.planning.services;

import java.math.BigDecimal;
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
public class TableBasedSequenceService extends DiamondDataServices {
	Logger logger = LoggerFactory.getLogger(getClass());

	@SuppressWarnings("unchecked")
	public int getSequenceNumber(int qty,String sequenceName) {  // TODO put all in one tabl3
		// TODO report stats
		
		Session session = getSession();
	    String qstr = "select nextval from " + sequenceName + " for update";
		Query q = session.createSQLQuery(qstr);
		List<BigDecimal> qdata = q.list();
		BigDecimal bd = qdata.get(0);
		int retval = bd.intValue();
	    
	    String ustr = "update " + sequenceName + " set nextval = nextval + :qty";
		Query u = session.createSQLQuery(ustr);
		u.setInteger("qty", qty);
		u.executeUpdate();
	    return retval;
	    
	}
}
