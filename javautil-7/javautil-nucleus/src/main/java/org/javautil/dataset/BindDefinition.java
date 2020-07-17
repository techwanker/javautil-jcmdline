package org.javautil.dataset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BindDefinition {


	private transient final Logger logger = LoggerFactory.getLogger(getClass());

	private String                 bindTypeName;

	public BindDefinition(String bindTypeName) {
		super();
		this.bindTypeName = bindTypeName;
	}

	public String getBindTypeName() {
		return bindTypeName;
	}

	public void setBindTypeName(String bindTypeName) {
		this.bindTypeName = bindTypeName;
	}

	
}
