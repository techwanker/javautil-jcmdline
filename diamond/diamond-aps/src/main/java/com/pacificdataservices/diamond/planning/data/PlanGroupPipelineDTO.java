package com.pacificdataservices.diamond.planning.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.gson.Gson;

public class PlanGroupPipelineDTO {

	private List<String> bucketNames;
	
	private List<PipelineLineDTO> supplyLines = new ArrayList<>();
	private List<PipelineLineDTO> demandLines = new ArrayList<>();
	
	public PlanGroupPipelineDTO(PlanGroupPipeline pipeline) {
		setBucketNames(pipeline.getBucketNames());
		setLines(pipeline.getSupplyLines(),supplyLines);
		setLines(pipeline.getDemandLines(),demandLines);
	}
	
	public PlanGroupPipelineDTO setBucketNames(Collection<String> bucketNames) {
		this.bucketNames = new ArrayList<String>();
		this.bucketNames.addAll(bucketNames);
		return this;
	}
	

	public PlanGroupPipelineDTO setLines(List<PipelineLine> lines, List<PipelineLineDTO> target) {
		for (PipelineLine line : lines) {
			target.add(new PipelineLineDTO(line));
		}
		return this;
	}
	
	String toJson(Gson gson) {
		return gson.toJson(this);
	}
	
}
