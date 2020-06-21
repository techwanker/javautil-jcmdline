package com.pacificdataservices.diamond.planning.services;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.pacificdataservices.diamond.models.ApsPlanGrp;
@Component
@Repository
@EnableAutoConfiguration
@EnableTransactionManagement
@Transactional
public class PlanGroupRepository extends DiamondDataServices{

		public List<ApsPlanGrp> getAll() {
			  List retval = getAll("ApsPlanGrp", getSession());
			  return retval;
		}
}
