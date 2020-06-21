package com.pacificdataservices.diamond.apswebservices;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.sql.DataSource;

import org.javautil.core.misc.DoubleBuckets;
import org.javautil.core.misc.MultiKeyHashMap;
import org.javautil.core.misc.MultiKeyHashMapOfLists;
import org.javautil.hibernate.HibernateMarshallerFactory;
import org.javautil.io.FileUtil;
import org.javautil.util.DateGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.pacificdataservices.diamond.buckets.SupplyBuckets;
import com.pacificdataservices.diamond.buckets.ProjectedPosition;
import com.pacificdataservices.diamond.planning.Allocator;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.json.PlanningDataMarshallable;
import com.pacificdataservices.diamond.planning.json.ProjectedPositionListJson;
import com.pacificdataservices.diamond.planning.supply.Supply;

@RestController
public class PlanDataController 
{

	private Logger logger = LoggerFactory.getLogger(getClass());
	private 	String jsonFile = "./src/test/resources/testdata/planGroup10.plandata.json";
	private 	File f = new File(jsonFile);
	@Autowired
	private DataSource datasource;

	@RequestMapping("/planData")
	public String  planData(
			@RequestParam(value="group") String groupNumber) 
					throws SQLException, IOException {
		logger.info("invoked with groupNumber {}",groupNumber);
		String requestFile = f.getCanonicalPath();
		logger.info("gettimg mock data '{}",requestFile);
		String retval = FileUtil.getAsString(f.getCanonicalPath());
		return retval;
	}

	PlanningData getFromFile(File f) throws IOException {
		String json = FileUtil.getAsString(f.getCanonicalPath());
		PlanningData pd = PlanningDataMarshallable.fromFile(f).toPlanningData();
		Allocator allocator = new Allocator(pd);
		allocator.allocate();
		return pd;
	}
	
	@RequestMapping("/projectedPosition")
	public  String
		//ArrayList<ProjectedPositionJson> 
		projectedPosition( @RequestParam(value="group") String groupNumber) throws IOException {
		logger.info("file is '{}'",f);
		logger.info("invoked with groupNumber {}",groupNumber);
		Gson dillon = HibernateMarshallerFactory.getHibernateGsonWithProxyDateFormatter();
		PlanningData pd = getFromFile(f);
		logger.info("Planning data is '{}'",pd);
		DateGenerator dateGenerator = pd.getDateGenerator();
		Collection<Supply>supplies = pd.getSuppliesById().values();
		ProjectedPosition projPos = new ProjectedPosition(supplies,dateGenerator);	
		logger.info("projPos is {}", projPos);
		ProjectedPositionListJson projPosList  = new ProjectedPositionListJson ().addPositions(projPos.getSupplyBucketsMap());
		//ProjectedPositionListJson projPosList  = new ProjectedPositionListJson (projPos.getSupplyBucketsMap());
		String response = dillon.toJson(projPosList);
		logger.info("response:\n" + response);
		return response;
						
	}
	
	@RequestMapping("/projectedPositionSum")
	public  String
		//ArrayList<ProjectedPositionJson>  
		projectedPositionSum( @RequestParam(value="group") String groupNumber) throws IOException {
		logger.info("invoked with groupNumber {}",groupNumber);
		Gson dillon = HibernateMarshallerFactory.getHibernateGsonWithProxyDateFormatter();
		PlanningData pd = getFromFile(f);
		DateGenerator dateGenerator = pd.getDateGenerator();
		Collection<Supply>supplies = pd.getSuppliesById().values();
		ProjectedPosition projPos = new ProjectedPosition(supplies,dateGenerator);	
		logger.info("projPos is {}", projPos);
		MultiKeyHashMapOfLists<SupplyBuckets> grouped = projPos.groupBy(0,1,2,3,5);
		MultiKeyHashMap<DoubleBuckets>summed = projPos.sum(grouped);
		ProjectedPositionListJson projPosList  = new ProjectedPositionListJson (summed);
		String response = dillon.toJson(projPosList);
		logger.info("response:\n" + response);
		return response;
						
	}
	
}
