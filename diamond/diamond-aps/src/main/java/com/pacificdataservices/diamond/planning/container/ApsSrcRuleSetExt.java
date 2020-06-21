/**
 * 
 */
package com.pacificdataservices.diamond.planning.container;

import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.diamond.models.ApsSrcRule;
import com.pacificdataservices.diamond.models.ApsSrcRuleSet;
import com.pacificdataservices.diamond.planning.PlanningDataException;

/**
 * @author jjs
 *
 */
public class ApsSrcRuleSetExt extends ApsSrcRuleSet {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private ApsSrcRule primaryRule;

	private TreeMap<String,ApsSrcRule> prioritizedRules = new TreeMap<>();
	/**
	 * 
	 */
	public ApsSrcRuleSetExt() {
		super();
	}

	public ApsSrcRuleSetExt(ApsSrcRuleSet dto) {
		super.setApsSrcRuleSetNbr(dto.getApsSrcRuleSetNbr());
		super.setApsSplyPool(dto.getApsSplyPool());
		super.setApsSrcRuleSetCd(dto.getApsSrcRuleSetCd());
		super.setApsSrcRuleSetDescr(dto.getApsSrcRuleSetDescr());
		super.setUtUserNbr(dto.getUtUserNbr());
		super.setLastModDt(dto.getLastModDt());
		super.setSrcRuleSetStatId(dto.getSrcRuleSetStatId());
		super.setApsSrcRules(dto.getApsSrcRules());
		super.setFcItemMasts(dto.getFcItemMasts());
		for (ApsSrcRule asr  : dto.getApsSrcRules()) {
			String key = String.format("%03d-%s-%s-%5d",asr.getSrcPrty(),asr.getSplyTypeId(),asr.getFacility(),asr.getApsSplySubPoolNbr());
			ApsSrcRule old = prioritizedRules.put(key,asr);
			if (old != null)  {
			String message = "Duplicate key for rule:\n" + asr.toString() +  "\n"  + old.toString() +  "\n" +
					"key " + key;
			logger.error(message);
			throw new PlanningDataException(message);
			}
		}
	}
	/**
	 * @return the prioritizedRules
	 */
	public TreeMap<String, ApsSrcRule> getPrioritizedRules() {
		return prioritizedRules;
	}

	/**
	 * @param prioritizedRules the prioritizedRules to set
	 */
	public void setPrioritizedRules(TreeMap<String, ApsSrcRule> prioritizedRules) {
		this.prioritizedRules = prioritizedRules;
	}

	/**
	 * @return the primaryRule
	 */
	public ApsSrcRule getPrimaryRule() {
		if (primaryRule == null) {
			throw new PlanningDataException("primaryRule is null for " + getApsSrcRuleSetNbr());
		}
		return primaryRule;
	}

	/**
	 * @param primaryRule the primaryRule to set
	 */
	public void setPrimaryRule(ApsSrcRule primaryRule) {
		if (primaryRule == null) {
			throw new IllegalArgumentException("attempt to set primary rule to null for " + getApsSrcRuleSetNbr());
		}
		this.primaryRule = primaryRule;
	}

}
