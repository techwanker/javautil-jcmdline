# javautil-commandline

Create command line arguments by creating an annotated commandline bean

## Getting Started

clone this repository and *mvn clean install*

## Example

### Arguments Bean

```
package com.pacificdataservices.pdssr;

import java.io.File;
import java.sql.Connection;

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

```

### Evaluate

```
	public static CdsDataLoaderArgs processArguments(String [] args) {
	     CdsDataLoaderArgs arguments = new CdsDataLoaderArgs();
	       
	        final CommandLineHandler clh = new CommandLineHandler(arguments);
			clh.setDieOnParseError(false);
			clh.evaluateArguments(args);
			return arguments;
	}
```
	
### main	
```
	 public static void main(String[] args) throws Exception {

	        CdsDataLoaderArgs arguments = processArguments(args);
	        CdsDataLoader invocation = new CdsDataLoader();
	    
	        invocation.process(arguments);
	    }
```

### Properties
```
application.name=CdsDataLoader
application.HelpText=Reads a CDS reporting format file and populates Load table
datasourceName.description=JNDI or connections.yaml datasource name
distributorCode.description=The identifier for the reporting distributor 

```

### Prerequisites

What things you need to install the software and how to install them


Give examples


## Annotations


* AcceptableValues
* DependentField
* DirectoryArguments
* DirectoryExists
* DirectoryReadable
* DirectoryWritable
* ExclusiveArguments
* Exclusive
* FieldValue
* FileExists
* FileReadable
* FileWritable
* Hidden
* InheritenceArguments
* IntegerArguments
* MultiValueBean
* MultiValue
* Optional
* OptionalRequiredArguments
* Required
* RequiredUnlessArguments
* RequiredUnless
* RequiresArguments
* Requires
* StringSet

