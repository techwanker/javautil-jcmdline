package com.pacificdataservices.diamond.planning.container;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.pacificdataservices.diamond.models.ApsSplySubPool;

public class ApsSplySubPools {
	private Map<Integer,ApsSplySubPool> byId = new HashMap<Integer,ApsSplySubPool>();
	
	public void setApsSubPools(Collection<ApsSplySubPool> subPools) {
		byId.clear();
		for (ApsSplySubPool subPool : subPools) {
			byId.put(subPool.getApsSplySubPoolNbr(), subPool);
			
		}
	}
	
	public ApsSplySubPool getApsSplySubPool(Integer id) {
		ApsSplySubPool retval = byId.get(id);
		if (retval == null) {
			throw new IllegalArgumentException("no such subpool " + id);
		}
		return retval;
	}
}