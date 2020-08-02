package com.pacificdataservices.pdssr;

import org.javautil.commandline.annotations.Required;

public class PostArgs {
	

	@Required
	private Integer fileNbr;
	
	@Required
	private String dataSourceName;
	


	public String getDataSourceName() {
		return dataSourceName;
	}

	public void setDataSourceName(String dataSourceName) {
		this.dataSourceName = dataSourceName;
	}




	public Integer getFileNbr() {
		return fileNbr;
	}

	public void setFileNbr(Integer fileNbr) {
		this.fileNbr = fileNbr;
	}

	
	
}
