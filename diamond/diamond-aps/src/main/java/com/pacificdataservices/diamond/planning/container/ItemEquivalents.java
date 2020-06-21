package com.pacificdataservices.diamond.planning.container;

import java.util.Collection;
import java.util.Set;

import com.pacificdataservices.diamond.models.IcItemMastEquiv;



public interface ItemEquivalents {
	
	
	public void initialize (); 
	
	
	/**
	 * Returns a list of ApsItemGlobalSubst for which the arg is the item or the substitute.
	 * @return
	 */
	public Set<IcItemMastEquiv> getSubstitutes(Integer itemNbr);


	public Collection<IcItemMastEquiv> getAll(); 

}

