package com.pacificdataservices.diamond.planning.container;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.pacificdataservices.diamond.models.UtFacility;



public class Facilities {
	private Map<String,UtFacility> byId = new HashMap<String,UtFacility>();
	// TODO generic start for StringIdMap
	public void setData(Collection<UtFacility> records) {
		byId.clear();
		for (UtFacility record : records) {
			byId.put(record.getFacility(), record);
			
		}
	}
	
	public UtFacility getData(String id) {
		UtFacility retval = byId.get(id);
		if (retval == null) {
			throw new IllegalArgumentException("no such record " + id);
		}
		return retval;
	}
}
