package org.javautil.dataset;

import java.io.File;
import java.util.ArrayList;

import org.javautil.commandline.CommandLineOptionsAndArgumentsHandler;
import org.javautil.commandline.ParamType;
import org.javautil.commandline.annotations.Argument;
import org.javautil.commandline.annotations.FileExists;
import org.javautil.commandline.annotations.MultiValue;
import org.javautil.commandline.annotations.Optional;
import org.javautil.commandline.annotations.Required;
import org.javautil.sql.Binds;
import org.javautil.text.BindsFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 

public class DatasetsDefinitionEnhancerArguments {
	
	private static final transient Logger logger = LoggerFactory.getLogger(DatasetsDefinitionEnhancerArguments.class);
	@Required
	@FileExists
	private File infile;
	
	@Required
	private String datasourceName;
	
	@Optional 
	private File outfile;
	
	@Optional
	@Argument
	@MultiValue(type = ParamType.STRING)
	private ArrayList<String> bindPair;
	
	@Optional
	private int verbosity = 2;
	
	/**
	 * This is populated from the bindPair arguments which should be specially formatted
	 */
	private Binds binds;
	
	public Binds getBinds() {
		return binds;
	}

	public void setBinds(Binds binds) {
		this.binds = binds;
	}

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

	public ArrayList<String> getBindPair() {
		return bindPair;
	}

	public void setBindPair(ArrayList<String> bindPair) {
		this.bindPair = bindPair;
	}

	public static DatasetsDefinitionEnhancerArguments processArguments(String [] args) {
		DatasetsDefinitionEnhancerArguments argumentBean = new DatasetsDefinitionEnhancerArguments();

		final CommandLineOptionsAndArgumentsHandler clh = new CommandLineOptionsAndArgumentsHandler(argumentBean);
		clh.setIgnoreUnrecognizedOptions(false);
		clh.setDieOnParseError(false);
		clh.evaluateArguments(args);
		BindsFactory bf = new BindsFactory();
	    Binds binds = bf.getStringParamBinds(argumentBean.bindPair);
	    logger.info("Binds are {}",binds);
		argumentBean.setBinds(binds);
		return argumentBean;
	}

	public int getVerbosity() {
		return verbosity;
	}
}
