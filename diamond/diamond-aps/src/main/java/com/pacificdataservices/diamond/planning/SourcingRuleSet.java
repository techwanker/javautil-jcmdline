package com.pacificdataservices.diamond.planning;

import java.util.List;
import java.util.TreeMap;

import com.pacificdataservices.diamond.models.ApsSrcRule;
import com.pacificdataservices.diamond.models.ApsSrcRuleSet;

public class SourcingRuleSet {
	
	private ApsSrcRuleSet apsSrcRuleSet;
	
	private TreeMap<Integer,ApsSrcRule> apsSrcRuleById = new TreeMap<Integer,ApsSrcRule>();
	
//	private 
	
	
	public SourcingRuleSet(ApsSrcRuleSet ruleSet, List<ApsSrcRule> rules) {
		if (ruleSet == null) {
			throw new IllegalArgumentException("rule is null");
		}
		if (rules == null ) {
			throw new IllegalArgumentException("rules is null");
		}
		this.apsSrcRuleSet = ruleSet;
		
//		for (ApsSrcRule rule: rules) {
//			if (rule.get)
//		}
		
	}

}
