package org.javautil.poi.workbook;

import java.io.File;

import org.javautil.commandline.annotations.FileExists;
import org.javautil.commandline.annotations.Optional;
import org.javautil.commandline.annotations.Required;

public class WorkbookDefinitionEnhancerArguments {

	@Required
	@FileExists
	private File infile;
	
	@Required
	private String datasourceName;
	
	@Optional 
	private File outfile;

	public File getInfile() {
		return infile;
	}

	public void setInfile(File infile) {
		this.infile = infile;
	}

	public String getDatasourceName() {
		return datasourceName;
	}

	public void setDatasourceName(String datasourceName) {
		this.datasourceName = datasourceName;
	}

	public File getOutfile() {
		return outfile;
	}

	public void setOutfile(File outfile) {
		this.outfile = outfile;
	}
}
