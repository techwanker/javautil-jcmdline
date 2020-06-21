package com.pacificdataservices.diamond.planning;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.diamond.planning.data.PlanGroupSnapshot;
import com.pacificdataservices.diamond.planning.data.PlanningData;

public class PlanXmlSnapshot {

	private File traceDirectory;
	private Logger logger = LoggerFactory.getLogger(getClass());;

	public PlanXmlSnapshot(File traceDirectory) {
		this.traceDirectory = traceDirectory;
	}

	public  void generateTrace(Long traceId, PlanningData pd) throws IOException {

		String fullPathName = traceDirectory + "/" + traceId + ".xml";
		File fullPath = new File(fullPathName);
		String dirPath = fullPath.getParent();
		File dirMaker = new File(dirPath);
		dirMaker.mkdirs();
		PlanGroupSnapshot planGroupSnapshot = new PlanGroupSnapshot(pd);
		OutputFormat format = OutputFormat.createPrettyPrint();

		FileWriter fw = new FileWriter(fullPathName);
		BufferedWriter fwb = new BufferedWriter(fw);
		XMLWriter writer = new XMLWriter(fwb, format);
		Document doc = planGroupSnapshot.getXmlDocument();
		writer.write(doc);
		writer.close();
		fwb.close();
		logger.info("logged to '" + fullPathName);
	}

}
