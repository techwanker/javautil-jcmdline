package com.pacificdataservices.diamond.planning.services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.javautil.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.pacificdataservices.diamond.models.ApsPlanGrp;
import com.pacificdataservices.diamond.models.ApsResultDtlDmd;
import com.pacificdataservices.diamond.planning.Allocator;
import com.pacificdataservices.diamond.planning.PlanningDataException;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.webservices.PlanningResults;

@Component
@Repository
@EnableAutoConfiguration
public class ExportPlanningResult {

	@Autowired
	private PlanningDataService pds;

	@Autowired
	private PlanGroupRepository pgr;

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private PlanningResults pr = new PlanningResults();

	public ExportPlanningResult() {
	}

	public void exportAll(File directory) throws IOException, SQLException {
		LinkedHashMap<Integer,Exception> exceptions = new LinkedHashMap<Integer,Exception>();
		for (ApsPlanGrp apg : pgr.getAll()) { // TODO need to get distinct
			int planGroupNumber = apg.getPlanGrpNbr();
			try {
				PlanningData pd = pds.getPlanningDataForGroup(planGroupNumber);
				Allocator engine = new Allocator(pd);
				engine.allocate();
		//		pr.toConcurrentModel(pd);
				// TODO Fix
				pd.setApsResultDtlDmds(new ArrayList<ApsResultDtlDmd>());
		//		pd.populateApsResultDtlDmds();
				String result = pr.toJson(pd);
				File f = new File(directory.getAbsoluteFile() +  "/" + "planGroup." + planGroupNumber + ".json");
				IOUtils.writeString(f,result);
			} catch (PlanningDataException e) {
				String message = e.getMessage();
				File f = new File(directory.getAbsoluteFile() +  "/" + "planGroup." + apg.getPlanGrpNbr() + ".log");
				FileWriter fw = new FileWriter(f);
				fw.write("processing " + apg.getPlanGrpNbr() + "\n");
				fw.write(message);
				fw.write("\n");
				fw.close();
				exceptions.put(apg.getPlanGrpNbr(),e);
			}
		}
		for (Entry<Integer, Exception> e : exceptions.entrySet()) {
			logger.error("while processing {} got {}", e.getKey(), e.getValue().getMessage());
		}
	}

//	public void exportPlanningGroup(int groupNumber, File directory) throws IOException {
//		logger.info("exporting plan group {}", groupNumber, directory.getAbsoluteFile());
//		PlanningData pd = pds.getPlanningDataForGroup(groupNumber);
//		File f = new File(directory.getAbsoluteFile() +  "/" + "planGroup." + groupNumber + ".json");
//		exportPlanningData(pd,f);
//	}
//
//	public void exportPlanningData(PlanningData pd, File file) throws IOException {
//		if (file == null)  {
//			throw new IllegalArgumentException("file is null");
//		}
//		PlanningDataMarshallable pdm = new PlanningDataMarshallable(pd);
//		pdm.writeToFile(file);
//	}
}
