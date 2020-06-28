package com.pacificdataservices.diamond.planning.services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.pacificdataservices.diamond.models.ApsPlanGrp;
import com.pacificdataservices.diamond.planning.PlanningDataException;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.json.PlanningDataMarshallable;

@Component
@Repository
@EnableAutoConfiguration
public class ExportImport {

	@Autowired
	private PlanningDataService pds;

	@Autowired
	private PlanGroupRepository pgr;

	private Logger logger = LoggerFactory.getLogger(getClass());

	public ExportImport() {
		// TODO Auto-generated constructor stub
	}

	public void exportAll(File directory) throws IOException, SQLException {
		LinkedHashMap<Integer,Exception> exceptions = new LinkedHashMap<Integer,Exception>();
		for (ApsPlanGrp apg : pgr.getAll()) {
			try {
				exportPlanningGroup(apg.getPlanGrpNbr(),directory);
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

	public void exportPlanningGroup(int groupNumber, File directory) throws IOException, SQLException {
		logger.info("exporting plan group {}", groupNumber, directory.getAbsoluteFile());
		PlanningData pd = pds.getPlanningDataForGroup(groupNumber);
		File f = new File(directory.getAbsoluteFile() +  "/" + "planGroup." + groupNumber + ".json");
		exportPlanningData(pd,f);
	}

	public void exportPlanningData(PlanningData pd, File file) throws IOException {
		if (file == null)  {
			throw new IllegalArgumentException("file is null");
		}
		PlanningDataMarshallable pdm = new PlanningDataMarshallable(pd);
		pdm.writeToFile(file);
	}
}
