package com.pacificdataservices.diamond.planning.data;

import java.util.ArrayList;
import java.util.List;

import org.javautil.containers.Buckets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PipelineLineDTO {

	private transient final Logger logger = LoggerFactory.getLogger(getClass());
	
	private List<String> identifiers;
	private List<Double> values;

	
	public PipelineLineDTO(PipelineLine line) {
		identifiers = new ArrayList<String>();
		identifiers.add(line.getGroup());
		identifiers.add(line.getName());
		this.values = line.getValues();
	}
	
    public PipelineLineDTO(Buckets<Double> buckets) {
		identifiers = buckets.getIdentifiers().asStringList();
		this.values = buckets.getValues();
	}

	public List<String> getIdentifiers() {
    	return identifiers;
    }

	/**
	 * @return the values
	 */
	public List<Double> getValues() {
		return values;
	}
}
	