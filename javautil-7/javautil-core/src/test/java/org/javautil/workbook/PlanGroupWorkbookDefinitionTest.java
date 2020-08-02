package org.javautil.workbook;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.io.FileUtils;
import org.javautil.text.YamlUtils;
import org.javautil.workbook.WorkbookDefinition;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class PlanGroupWorkbookDefinitionTest {
	private final Logger logger               = LoggerFactory.getLogger(getClass());
	private final String definitionsDirectory = WorkbookTestConstants.definitionsDirectory;

	@Ignore
	@Test
	public void planGroup10DefinitionTest() throws IllegalAccessException,
	    IllegalArgumentException, InvocationTargetException, IOException {
		File file = new File("src/test/resources/workbook/PlanGroupWorkbook.yaml");
		logger.info("processing file: '{}'", file.getAbsoluteFile());
		String def = FileUtils.readFileToString(file);
		logger.info("f\n{}", def);
		logger.info("reading file {}", file.getCanonicalPath());

		WorkbookDefinition wd = WorkbookDefinition.getWorkbookDefinition(file);
		logger.info("input file: {}\n{}", file.getAbsoluteFile(), wd.getFileAsString());
		logger.info("WorkbookDefinition asYaml:\n{}", YamlUtils.asYaml(wd));
	}
}
