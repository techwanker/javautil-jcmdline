package com.pacificdataservices.pdssr;

import java.io.File;

import org.javautil.commandline.annotations.Optional;
import org.javautil.commandline.annotations.Required;

public class CdsDataLoaderArgs {
	

	@Required
	private File inputFile;
	
	@Required
	private String dataSourceName;
	
	@Required 
	private String distributorCode;
	
	public File getInputFile() {
		return inputFile;
	}

	public void setInputFile(File inputFile) {
		this.inputFile = inputFile;
	}

	public String getDataSourceName() {
		return dataSourceName;
	}

	public void setDataSourceName(String dataSourceName) {
		this.dataSourceName = dataSourceName;
	}

	public String getDistributorCode() {
		return distributorCode;
	}

	public void setDistributorCode(String distributorCode) {
		this.distributorCode = distributorCode;
	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	@Optional
	private boolean validate = false;

	
}
