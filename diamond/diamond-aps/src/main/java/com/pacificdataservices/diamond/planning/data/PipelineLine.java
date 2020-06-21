package com.pacificdataservices.diamond.planning.data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PipelineLine {
	private transient final Logger logger = LoggerFactory.getLogger(getClass());
	
	private String group;
	private String name;
	private LinkedHashMap<String,Double> valueMap;

	
	public PipelineLine(String group, String name) {
		this.group = group;
		this.name = name;
		this.valueMap = new LinkedHashMap<String,Double> ();
		// logger.info("group: {} name: {}", group, name);
	}
	
	public PipelineLine(String group, String name, LinkedHashMap<String,Double> valueMap) {
		this.group = group;
		this.name = name;
		this.valueMap = valueMap;
	}
	
	public void put(String key, Double value) {
		valueMap.put(key, value);
	}
	

	@Override
	public String toString() {
		return "PipelineLine [" + group +  " " + name + " " + valueMap.values() + "]";
	}

	/**
	 * @return the group
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		// logger.info("Name: {}", name);
		return name;
	}

	/**
	 * @return the values
	 */
	public List<Double> getValues() {
		ArrayList<Double> values = new ArrayList<>();
		values.addAll(valueMap.values());
		return values;
	}
	
	public double sumValues() {
		double sum = 0.0;
		for (double v : getValues()) {
			sum += v;
		}
		return sum;
	}

}
