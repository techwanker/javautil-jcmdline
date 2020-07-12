package org.javautil.poi.workbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.javautil.commandline.CommandLineHandlerDelete;
import org.javautil.commandline.CommandLineOptionsAndArgumentsHandler;
import org.javautil.commandline.ParamType;
import org.javautil.commandline.annotations.AcceptableValues;
import org.javautil.commandline.annotations.Argument;
import org.javautil.commandline.annotations.DirectoryExists;
import org.javautil.commandline.annotations.DirectoryReadable;
import org.javautil.commandline.annotations.DirectoryWritable;
import org.javautil.commandline.annotations.Exclusive;
import org.javautil.commandline.annotations.FileExists;
import org.javautil.commandline.annotations.FileReadable;
import org.javautil.commandline.annotations.FileWritable;
import org.javautil.commandline.annotations.MultiValue;
import org.javautil.commandline.annotations.Optional;
import org.javautil.commandline.annotations.Required;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jcmdline.StringParam;


public class AllArguments {
	
	

//    @DependentField

//    @FieldValue
//
//    @FileWritable
//    @Hidden
//    @MultiValueBean
//    @MultiValue
//    @Optional
//    
//    @Required
//    @RequiredUnless
//    @Requires
//    @StringSet
//    private String toadlick;

   
    @Optional
     @AcceptableValues(values = {"a", "b"}) 
    
    private String acceptable;
    
    
	@FileReadable
	@FileExists
	@Required
	private File definition;
	
	@FileWritable
	@Required
	private File definitionOutput;

	
	@Required
	private String dataSourceName;
	
	@DirectoryReadable
	@DirectoryWriteable
	@DirectoryExists
	private File databaseDirectory;
	
	@Optional
	@Exclusive(property = "inputFile") Long workbookLoadId = null;
	
	@Optional
	File inputFile ;
	
	
	@FileWritable
	@Required
	private File outfile;
	
	@Optional
	@Argument
	@MultiValue(type = ParamType.STRING)
	private ArrayList<String> bindPair;


	private static final transient Logger logger  = LoggerFactory.getLogger(AllArguments.class);
	


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

	public static AllArguments processArguments(String [] args) throws IOException {
		AllArguments argumentBean = new AllArguments();

		final CommandLineOptionsAndArgumentsHandler clh = new CommandLineOptionsAndArgumentsHandler(argumentBean);
		clh.setIgnoreUnrecognizedOptions(false);
		clh.setDieOnParseError(false);
		clh.evaluateArguments(args);
		logger.info("binds {}", argumentBean.bindPair);
		//argumentBean.bindPair = clh.getArguments();
		return argumentBean;
	}
	
}
