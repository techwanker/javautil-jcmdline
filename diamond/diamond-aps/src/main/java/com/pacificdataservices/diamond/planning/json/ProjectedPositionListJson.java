package com.pacificdataservices.diamond.planning.json;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

import org.javautil.containers.DoubleBuckets;
import org.javautil.containers.MultiKey;
import org.javautil.containers.MultiKeyHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.diamond.buckets.SupplyBuckets;


public class ProjectedPositionListJson {
	private transient Logger logger = LoggerFactory.getLogger(getClass());
	private List<Date> bucketDates;
	private List<ProjectedPositionJson> positions = new ArrayList<ProjectedPositionJson>();

	public ProjectedPositionListJson() {
	}
	
	public ProjectedPositionListJson( MultiKeyHashMap<DoubleBuckets> groupedBy) {

		logger.info("entering");
		if (groupedBy == null) {
			throw new IllegalArgumentException("groupedBy is null");
		}
		for (Entry<MultiKey, DoubleBuckets> r : groupedBy.entrySet()) {
			if (bucketDates == null) {
				bucketDates = new ArrayList<Date>();
				logger.info("about to copy from dates");
				for (Date date : r.getValue().getDateMap().keySet()) {
					logger.info("adding date: {}" + date);
					bucketDates.add(date);
				}
			}
			positions.add(new ProjectedPositionJson(r.getKey(), r.getValue()));
		}
	}
	
	public ProjectedPositionListJson addPositions( MultiKeyHashMap<SupplyBuckets> detail) {
		logger.info("entering");
		if (detail == null) {
			throw new IllegalArgumentException("detail is null");
		}
		for (Entry<MultiKey, SupplyBuckets> r : detail.entrySet()) {
			if (bucketDates == null) {
				bucketDates = new ArrayList<Date>();
				for (Date date : r.getValue().getDateMap().keySet()) {
					bucketDates.add(date);
				}
			}
			positions.add(new ProjectedPositionJson(r.getKey(), r.getValue()));
		}
		return this;
	}

}
