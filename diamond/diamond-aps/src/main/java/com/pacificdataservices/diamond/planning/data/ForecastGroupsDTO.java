package com.pacificdataservices.diamond.planning.data;

import java.util.ArrayList;
import java.util.List;

import org.javautil.containers.Buckets;

import com.google.gson.Gson;
import com.pacificdataservices.diamond.planning.demand.ForecastGroups;

public class ForecastGroupsDTO {

	private List<String> bucketNames;
	
	private List<PipelineLineDTO> forecastGroupLines = new ArrayList<>();
	
	public ForecastGroupsDTO(ForecastGroups groups) {
		 this.bucketNames = groups.getBucketNames();
		 List<Buckets<Double>> bucketsList = groups.getListOfBuckets();
		 for (Buckets<Double> buckets : bucketsList) {
			 PipelineLineDTO dto = new PipelineLineDTO(buckets);
			 forecastGroupLines.add(dto);
		 }
		 
	}

	/**
	 * @return the bucketNames
	 */
	public List<String> getBucketNames() {
		return bucketNames;
	}

	/**
	 * @return the forecastGroupLines
	 */
	public List<PipelineLineDTO> getForecastGroupLines() {
		return forecastGroupLines;
	}

	public String toJson(Gson dillon) {
		return dillon.toJson(this);
	}

}
