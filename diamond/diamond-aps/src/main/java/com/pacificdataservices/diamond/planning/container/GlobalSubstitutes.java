package com.pacificdataservices.diamond.planning.container;

import java.util.Collection;
import java.util.Set;

import com.pacificdataservices.diamond.models.ApsItemGlobalSubst;
import com.pacificdataservices.diamond.planning.data.PlanningData;

public interface GlobalSubstitutes {
	

	
	public void initialize (PlanningData planningData);



	/**
	 * Returns a list of ApsItemGlobalSubst for which the arg is the item or the substitute.
	 * @return
	 */
	public Set<ApsItemGlobalSubst> getSubstitutes(Integer itemNbr);



	public Collection<ApsItemGlobalSubst> getAll();



	public void setApsItemGlobalSubsts(
			Collection<ApsItemGlobalSubst> apsItemGlobalSubsts);
	

}

