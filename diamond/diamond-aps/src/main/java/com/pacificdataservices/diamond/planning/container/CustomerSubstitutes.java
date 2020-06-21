package com.pacificdataservices.diamond.planning.container;

import java.util.Collection;

import com.pacificdataservices.diamond.models.IcItemCustSubst;
import com.pacificdataservices.diamond.planning.data.PlanningData;



public interface CustomerSubstitutes {
	

	
	public void initialize (PlanningData planningData);

	public Collection<IcItemCustSubst>getAll();

	public void setIcItemCustSubsts(Collection<IcItemCustSubst> substitutes);

	

}
