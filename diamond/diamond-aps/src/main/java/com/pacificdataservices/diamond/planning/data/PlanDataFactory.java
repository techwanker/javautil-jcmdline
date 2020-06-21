package com.pacificdataservices.diamond.planning.data;

import java.io.File;
import java.io.IOException;

import com.pacificdataservices.diamond.planning.Allocator;
import com.pacificdataservices.diamond.planning.json.PlanningDataMarshallable;

public class PlanDataFactory {

	public static PlanningData getPlanningDataPlanned(File jsonFile) throws IOException {
		PlanningData pd = PlanningDataMarshallable.planningDataFromFile(jsonFile);
    	Allocator allocator = new Allocator(pd);
		allocator.allocate();
    	return pd;
	}
	
	public static PlanningData getPlanningData(File jsonFile) throws IOException {
		PlanningData pd = PlanningDataMarshallable.planningDataFromFile(jsonFile);
    	return pd;
	}

}
