//package com.pacificdataservices.diamond.planning.services;
//
//import static org.junit.Assert.assertEquals;
//
//import java.io.File;
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Arrays;
//
////https://stackoverflow.com/questions/25063995/spring-boot-handle-to-hibernate-sessionfactory
////https://stackoverflow.com/questions/1657557/spring-hibernate-unknown-entity
//
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import javax.transaction.Transactional;
//
//import org.hibernate.Query;
////import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.transform.Transformers;
//import org.javautil.core.misc.Timer;
//import org.javautil.hibernate.HibernateMarshallerFactory;
//import org.javautil.io.IOUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import com.google.gson.Gson;
//import com.pacificdataservices.diamond.models.ApsAllocOnhandFc;
//import com.pacificdataservices.diamond.models.ApsAllocOnhandOo;
//import com.pacificdataservices.diamond.models.ApsAllocOnhandSs;
//import com.pacificdataservices.diamond.models.ApsAllocOnhandWo;
//import com.pacificdataservices.diamond.models.ApsAllocReplenFc;
//import com.pacificdataservices.diamond.models.ApsAllocReplenOo;
//import com.pacificdataservices.diamond.models.ApsAllocReplenSs;
//import com.pacificdataservices.diamond.models.ApsAllocReplenWo;
//import com.pacificdataservices.diamond.models.ApsAllocWoFc;
//import com.pacificdataservices.diamond.models.ApsAllocWoOo;
//import com.pacificdataservices.diamond.models.ApsAllocWoSs;
//import com.pacificdataservices.diamond.models.ApsAllocWoWo;
//import com.pacificdataservices.diamond.models.ApsAvailOnhand;
//import com.pacificdataservices.diamond.models.ApsAvailReplen;
//import com.pacificdataservices.diamond.models.ApsAvailWo;
////import com.pacificdataservices.diamond.models.ApsCustMfrVw;
//import com.pacificdataservices.diamond.models.ApsDmdFc;
//import com.pacificdataservices.diamond.models.ApsDmdOo;
//import com.pacificdataservices.diamond.models.ApsDmdSs;
//import com.pacificdataservices.diamond.models.ApsDmdWo;
//import com.pacificdataservices.diamond.models.ApsItemGlobalSubst;
//import com.pacificdataservices.diamond.models.ApsSplySubPool;
//import com.pacificdataservices.diamond.models.ApsSrcRule;
//import com.pacificdataservices.diamond.models.ApsSrcRuleSet;
//// import com.pacificdataservices.diamond.models.ApsSupply;
//import com.pacificdataservices.diamond.models.FcItemMast;
//import com.pacificdataservices.diamond.models.FcstGrp;
//import com.pacificdataservices.diamond.models.IcCertCd;
//import com.pacificdataservices.diamond.models.IcItemCustSubst;
//import com.pacificdataservices.diamond.models.IcItemMast;
//import com.pacificdataservices.diamond.models.IcItemMastEquiv;
//import com.pacificdataservices.diamond.models.OeCustMast;
//import com.pacificdataservices.diamond.models.OeCustMfr;
//import com.pacificdataservices.diamond.models.OeOrdDtl;
//import com.pacificdataservices.diamond.models.OeOrdDtlCert;
//import com.pacificdataservices.diamond.models.TmpItem;
//import com.pacificdataservices.diamond.planning.PlanningData;
//import com.pacificdataservices.diamond.planning.SourcingRules;
//import com.pacificdataservices.diamond.planning.marshall.PlanningDataMarshallable;
//import com.pacificdataservices.diamond.planning.marshall.SimpleGsonMarshaller;
//
//@Component
//@Repository
//@EnableAutoConfiguration
//@Transactional
//@EnableTransactionManagement
//
//public class SourcingRuleService extends DiamondDataServices {
//	Logger logger = LoggerFactory.getLogger(getClass());
//	private Logger analytics = LoggerFactory.getLogger("analytics");
//
//	
//	public void assertNotNull(Object o) {
//		if (o == null) {
//			throw new IllegalStateException("null found");
//		}
//	}
//	
//	public SourcingRules getSourcingRules() {
//		List<ApsSrcRuleSet> sourceRuleSets = getAll("ApsSrcRuleSet",getSession());
//		List<ApsSrcRule> sourceRules = getAll("ApsSrcRule",getSession());
//		ApsSrcRule rule1 = sourceRules.get(0);
//		int ruleNbr =  rule1.getApsSrcRuleNbr();
//		ApsSrcRuleSet set1 = rule1.getApsSrcRuleSet();
//		assertEquals(set1.getApsSrcRuleSetNbr(),ruleNbr);
//		SourcingRules sourcingRules = new SourcingRules(sourceRules,sourceRuleSets);
//		return sourcingRules;
//		
//	}
//
//}
