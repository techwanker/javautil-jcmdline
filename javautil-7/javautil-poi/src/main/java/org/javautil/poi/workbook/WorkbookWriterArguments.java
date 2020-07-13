package org.javautil.poi.workbook;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.javautil.commandline.CommandLineHandlerDelete;
import org.javautil.commandline.CommandLineOptionsAndArgumentsHandler;
import org.javautil.commandline.ParamType;
import org.javautil.commandline.annotations.Argument;
import org.javautil.commandline.annotations.MultiValue;
import org.javautil.commandline.annotations.Optional;
import org.javautil.commandline.annotations.Required;
import org.javautil.core.sql.Binds;
import org.javautil.text.BindsFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jcmdline.StringParam;


public class WorkbookWriterArguments {
	private static final transient Logger logger  = LoggerFactory.getLogger(WorkbookWriterArguments.class);
	
	@Required
	private File definition;
	
	@Required
	private String dataSourceName;
	
	@Optional
	private String loggerDataSourceName = null;
	

	@Required
	private File outfile;
	
	@Optional
	@Argument
	@MultiValue(type = ParamType.STRING)
	private ArrayList<String> bindPair;

	/**
	 * This is populated from the bindPair arguments which should be specially formatted
	 */
	private Binds binds;

	public File getDefinition() {
		return definition;
	}

	public void setDefinition(File definition) {
		this.definition = definition;
	}

	public String getDataSourceName() {
		return dataSourceName;
	}

	public void setDataSourceName(String dataSourceName) {
		this.dataSourceName = dataSourceName;
	}

	public File getOutfile() {
		return outfile;
	}

	public void setOutfile(File outfile) {
		this.outfile = outfile;
	}



	

	public ArrayList<String> getBindPair() {
		return bindPair;
	}

	public void setBindPair(ArrayList<String> bindPair) {
		this.bindPair = bindPair;
	}

	public Binds getBinds() {
		return binds;
	}

	public void setBinds(Binds binds) {
		this.binds = binds;
	}

	public String getLoggerDataSourceName() {
		return loggerDataSourceName;
	}

	public void setLoggerDataSourceName(String loggerDataSourceName) {
		this.loggerDataSourceName = loggerDataSourceName;
	}

	public static WorkbookWriterArguments processArguments(String [] args) {
		WorkbookWriterArguments argumentBean = new WorkbookWriterArguments();

		final CommandLineOptionsAndArgumentsHandler clh = new CommandLineOptionsAndArgumentsHandler(argumentBean);
		clh.setIgnoreUnrecognizedOptions(false);
		clh.setDieOnParseError(false);
		clh.evaluateArguments(args);
		BindsFactory bf = new BindsFactory();
		argumentBean.setBinds(bf.getStringParamBinds(argumentBean.bindPair));
		logger.info("binds {}", argumentBean.getBinds());
		//argumentBean.bindPair = clh.getArguments();
		return argumentBean;
	}


	
}
