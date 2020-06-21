package com.pacificdataservices.diamond.planning.container;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.map.MultiKeyMap;

import com.pacificdataservices.diamond.models.IcItemCustSubst;
import com.pacificdataservices.diamond.planning.data.PlanningData;


public class CustomerSubstitutesImpl implements CustomerSubstitutes {
	
	private HashMap<Integer,HashMap<Integer,IcItemCustSubst>> byItemNbr = new HashMap<Integer,HashMap<Integer,IcItemCustSubst>>();
	

	private HashMap<Integer,HashMap<Integer,IcItemCustSubst>> bySubstituteNbr = new HashMap<Integer,HashMap<Integer,IcItemCustSubst>>();
	/**
	 * Key is customerNumber, itemNumber, substituteNumber
	 */
	
	private MultiKeyMap byIcItemCustSubstId = new MultiKeyMap();

	//private PlanningData planningData;
	
	private Collection<IcItemCustSubst> icItemCustSubsts;


	public CustomerSubstitutesImpl() {
		
	}
	
	@Override
	public void initialize (PlanningData planningData) {
//		if (planningData ==  null) {
//			throw new IllegalArgumentException("planningData is null");
//		}
//		this.planningData = planningData;
		clear();
		for (IcItemCustSubst custSubst :  icItemCustSubsts) {
			add(custSubst);
		}
	}

	public void clear() {
		byItemNbr.clear();
		bySubstituteNbr.clear();
		byIcItemCustSubstId.clear();
	}
	
	public void add(IcItemCustSubst subst) {
		HashMap<Integer,IcItemCustSubst> substitutes = null;
		// forward reference
		substitutes = byItemNbr.get(subst.getId().getItemNbr());
		if (substitutes == null) {
			substitutes = new HashMap<Integer,IcItemCustSubst>();
			byItemNbr.put(subst.getId().getItemNbr(), substitutes);
		}
		substitutes.put(subst.getId().getItemNbr(), subst);
		// reverse reference
		substitutes = bySubstituteNbr.get(subst.getId().getItemNbr());
		if (substitutes == null) {
			substitutes = new HashMap<Integer,IcItemCustSubst>();
			bySubstituteNbr.put(subst.getId().getItemNbr(), substitutes);
		}
		substitutes.put(subst.getId().getItemNbr(), subst);
		// fully qualified

		
		Integer customerNumber = subst.getId().getOrgNbrCust();
		Integer itemNumber = subst.getId().getItemNbr();
		Integer itemNumberSubstitute = subst.getId().getItemNbrSubst();
		byIcItemCustSubstId.put(customerNumber, itemNumber, itemNumberSubstitute, subst);		
	}
	
	public boolean exists (Integer customerNumber, Integer itemNumber, Integer substituteNumber) {
		IcItemCustSubst subst = (IcItemCustSubst) byIcItemCustSubstId.get(customerNumber, itemNumber, substituteNumber);
		return subst == null ? false : true;
	}
	
	public Set<IcItemCustSubst> getSubstitutes(Integer itemNbr) {
		Set<IcItemCustSubst> substitutes = new HashSet<IcItemCustSubst>();
		Map<Integer,IcItemCustSubst> substs = byItemNbr.get(itemNbr);
		if (substs != null) {
			substitutes.addAll(substs.values());
		}
		
		substs = bySubstituteNbr.get(itemNbr);
		if (substs != null) {
			substitutes.addAll(substs.values());
		}
		return substitutes;
	}

	@Override
	public Collection<IcItemCustSubst> getAll() {
		return icItemCustSubsts;
	}

	@Override
	public void setIcItemCustSubsts(Collection<IcItemCustSubst> substitutes) {
		icItemCustSubsts = substitutes;
	}

	

}
