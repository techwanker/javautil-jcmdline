package com.pacificdataservices.diamond.hibernate;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.diamond.models.ApsPlanGrp;

public class SessionHelper {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private Session session;
	
	public SessionHelper(Session session) {
		this.session = session;
	}
	
	public void save(ApsPlanGrp apg) {
//		if (apg.getIcItemMast() == null) {
//			String hql = "FROM IcItemMast iim WHERE iim.itemNbr = :itemNbr";
//			Query iimQuery = session.createQuery(hql);
//			iimQuery.setParameter("itemNbr",apg.getItemNbr());
//			List<IcItemMast> icItemMastList = iimQuery.list();
//			if (icItemMastList.size() != 1) {
//				String message = String.format("icItemMast count %d for itemNbr %d",icItemMastList.size(),apg.getItemNbr());
//				logger.error(message);
//				throw new IllegalStateException(message);
//			}
//            apg.setIcItemMast(icItemMastList.get(0));			
//		}
			session.save(apg);
	}
	public void save(Object o) {
		session.save(o);
	}
}
