`Getting Started <#GettingStarted>`__ \| `QuickStart <#QuickStart>`__ \|
`Semantics <#Semantics>`__ \| `Parameters Bean <#ParametersBean>`__ \|
`Example Parameters Bean <#ExampleParametersBean>`__ \|
`main <#mainP>`__ \| `Properties <#Properties>`__

javautil-commandline
====================

Create command line arguments by creating an annotated commandline bean

Getting Started
---------------

Clone this repository and *mvn clean install*

`[toc] <#ttoc>`__

Quick Start
===========

Using the *javautil-jcmdline* requires the following steps:

-  Define the option and argument parameters the command will accept by
   annotating an *Argument Bean*
-  Create a properties file that describes the program and parameters
-  Call the **getArguments** method on the Arguments Bean

`[toc] <#ttoc>`__

Semantics
---------

Throughout this document, the following semantics are used:

-  **option** A command line **option** is comprised of an identifying
   "tag", typically preceded by a dash or two, and optionally requires a
   value. A typical *option* might be "``-outfile /tmp/myfile``\ ".
-  **argument** A command line *argument* is specified on the command
   line after all of the options and their values.
-  **parameter** A command line *parameter* is an *option* or an
   *argument*.

`[toc] <#ttoc>`__

Parameters Bean
---------------

The *parameters bean* will hold all of the specified options and
parameters.

Each member has one or more `annotations <#Annotations>`__ that describe
the requirements for the parameter and affect the parsing response to
user input and validation.

After the arguments are parsed and validated the argument bean members
will be populated and are accessed using the *get* and *is* accessors;
the receiving program has no dependency or awareness of how the bean was
populated.

`[toc] <#ttoc>`__

Example Parameters Bean
~~~~~~~~~~~~~~~~~~~~~~~

::

    package org.javautil.poi.workbook;

    import java.io.File;
    import java.util.ArrayList;
    import java.util.Collection;

    import org.javautil.commandline.CommandLineHandler;
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

        @Required
        private File definition;
        
        @Required
        private String dataSourceName;
        
        @Required
        private File outfile;
        
        @Optional
        @Argument
        @MultiValue(type = ParamType.STRING)
        private ArrayList<String> bindPair;
        
        private Binds binds;


        private static final transient Logger logger  = LoggerFactory.getLogger(WorkbookWriterArguments.class);
        


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

`[toc] <#ttoc>`__

main
~~~~

::

    public static void main(String[] args) Exception {
        WorkbookWriterArguments arguments = WorkbookWriterArguments.processArguments(args);
        new WorkbookWriter().process(arguments);
    }

`[toc] <#ttoc>`__

Properties
----------

Create a properties file in the appropriate resource directory.

For example, using default Maven directory structure the bean class
WorkbookWriterArguments in package *org.javautil.poi.workbook* would be
in
*src/main/resources/org/javautil/poi/workbook/WorkbookWriterArguments.properties*

Properties files for other locales should be appropriately named.

-  ``application.name generally`` the classname of the program
   containing the main

-  ``application.HelpText`` text on program description and usage

-  ``parameter.description`` description of the parameter one per per
   parameter with same name as the annotated bean members

::

    application.name=WorkbookWriter
    application.HelpText=Creates Excel workbook
    datasourceName.description=JNDI or connections.yaml datasource name
    definition.description=Workbook definition .yaml file
    outfile.description=The name of the file to be created

`[toc] <#ttoc>`__

Annotations
-----------

`@AcceptableValues <#AcceptableValues>`__ \| `@Argument <#Argument>`__
\| `@DependentField <#DependentField>`__ \|
`@DirectoryExists <#DirectoryExists>`__
`@DirectoryReadable <#DirectoryReadable>`__ \|
`@DirectoryWritable <#DirectoryWritable>`__ \|
`@Exclusive <#Exclusive>`__ \| `@FileExists <#FileExists>`__ \|
`@FileReadable <#FileReadable>`__ \| `@FileWritable <#FileWritable>`__
\| `@Hidden <#Hidden>`__ \| `@MultiValue <#MultiValue>`__ \|
`@Optional <#Optional>`__ \| `@Required <#Required>`__ \|
`@RequiredUnless <#RequiredUnless>`__ \| `@Requires <#Requires>`__

Parameters
----------

-  Every parameter must have one of

   -  **`@Optional <#Optional>`__** Options
   -  **`@Required <#Required>`__** Options
   -  **`@Argument <#Argument>`__** Arguments

-  Files

   -  **`@FileExists <#FileExists>`__** File must exist
   -  **`@FileReadable <#FileReadable>`__** File must exist and be
      readable
   -  **`@FileWritable <#FileWritable>`__** does it need to exist

-  Directories

   -  **`@DirectoryExists <#DirectoryExists>`__**
   -  **`@DirectoryReadable <#DirectoryReadable>`__**
   -  **`@DirectoryWritable <#DirectoryWritable>`__**

-  Inter parameter dependencies

   -  **`@Exclusive <#Exclusive>`__**
   -  **`@Requires <#Requires>`__**

-  Other

   -  **`@AcceptableValues <#AcceptableValues>`__**
   -  **`@DependentField <#DependentField>`__**
   -  **`@Hidden <#Hidden>`__**

`[toc] <#TOCa>`__

@AcceptableValues
-----------------

Annotation type to indicate a list of values that may be assumed by a
String,

::

    @AcceptableValues(values = {"a", "b"}) private String text;

`[toc] <#TOCa>`__

@Argument
---------

Annotation type to indicate a parameter should be treated as argument.

::

    @Optional
    @Argument
    @MultiValue(type = ParamType.STRING)
    private ArrayList<String> bindPair;

`[toc] <#TOCa>`__

@DependentField
---------------

Annotation type to indicate a parameter is required by another
parameter. The argument property should be set to a string with the name
of the property on the same class that requires it.

example:

The property "schemaName" is required by the property "xsd"

code:

::

    @Requires("schemaName") String xsd;

`[toc] <#TOCa>`__

@DirectoryExists
----------------

Annotation type to indicate a directory must exist.

code:

::

    @DirectoryExists private File inputDirectory;

`[toc] <#TOCa>`__

@DirectoryReadable
------------------

Annotation type to indicate a directory must be readable. By definition
it must exist.

code:

::

    @DirectoryReadable
    private File databaseDirectory;

`[toc] <#TOCa>`__

@DirectoryWritable
------------------

Annotation type to indicate a directory must be writable.

code:

::

    @DirectoryWriteable
    private File databaseDirectory;

`[toc] <#TOCa>`__

@Exclusive
----------

Annotation type to indicate a parameter is exclusive to another
parameter.

The annotation may be on either of the mutually exclusive fields. Having
on both fields is not an error, but is redundant.

example:

If parameter 'input' is specified 'workbookLoadId' may not be specified
and vice versa.

code:

::

    @Exclusive(property = "input") Long workbookLoadId = null;

`[toc] <#TOCa>`__

@FileExists
-----------

Annotation type to indicate a file must exist.

code:

::

    @FileExists
    private File outputFile;

`[toc] <#TOCa>`__

@FileReadable
-------------

Annotation type to indicate a file must be readable.

code:

::

    @FileReadable
    private File definition;

`[toc] <#TOCa>`__

@FileWritable
-------------

Annotation type to indicate a file must be writable

code:

::

    @FileWritable
    private File definitionOutput;

`[toc] <#TOCa>`__

@Hidden
-------

Annotation type to indicate that an argument is hidden; that is, not
displayed on help messages.

::

    @Optional
    @Hidden
    private String hiddenParameter;

`[toc] <#TOCa>`__

@MultiValue
-----------

Annotation type to indicate a parameter is accepted multiple times. This
annotation is mutually exclusive to the FieldValue annotation.

example:

The property "downloadUrls" is to be multiple urls to download

code:

::

     @MultiValue(type=ParamType.STRING) ArrayList<String>  downloadUrls;

`[toc] <#TOCa>`__

@Optional
---------

Annotation type to indicate a parameter should be treated as optional.
This annotation is mutually exclusive to the Required annotation.

code:

::

    @Optional
    private String breed;

`[toc] <#TOCa>`__

@Required
---------

Annotation type to indicate a parameter should be treated is mandatory.
This annotation is mutually exclusive to the Optional annotation.

Required options are better self documenting than positional arguments

::

    @Required
    @AcceptableValues(values = {"a", "b"}) 
    private String abba;

`[toc] <#TOCa>`__

@RequiredUnless
---------------

Annotation type to indicate a parameter should be treated as required
unless another parameter is specified.

::

    @RequiredUnless(property = "toad")
    private String frog;

    @Optional
    private String toad;

`[toc] <#TOCa>`__

@Requires
---------

Annotation type to indicate a parameter is required by another
parameter. The argument property should be set to a string with the name
of the property on the same class that requires it.

example:

The property "schemaName" is required by the property "xsd"'

::

    @Requires("schemaName") String xsd;

`[toc] <#TOCa>`__

--------------

`[toc] <#ttoc>`__

--------------

jcmdline Package User Guide Release 3.0.0
=========================================

| `Introduction <#Introduction>`__
|  `Obtaining this Document <#ObtainingthisDocument>`__
|  `Some Semantics <#SomeSemantics>`__
|  `Quick Start <#QuickStart>`__
|             `Define The Parameters <#DefineTheParameters>`__
|             `Create a CmdLineHandler <#CreateaCmdLineHandler>`__
|             `Parse the Command Line <#ParsetheCommandLine>`__
|             `Access the Processed
Parameters <#AccesstheProcessedParameters>`__
|  `Parameters <#Parameters>`__
|             `When Supplied Parameters Are Not
Adequate <#WhenSuppliedParametersAreNotAdequate>`__
|                         `Post-processing
Parameters <#PostprocessingParameters>`__
|                         `Creating Custom Parameter
Classes <#CreatingCustomParameterClasses>`__
|  `Command Line Handlers <#CommandLineHandlers>`__
|             `Parsers <#Parsers>`__
|                         `The
PosixCmdLineParser <#ThePosixCmdLineParser>`__
|                         `Usage Formatters <#UsageFormatters>`__
|             `CmdLineHandler Decorators <#CmdLineHandlerDecorators>`__
|             `Writing CmdLineHandler
Decorators <#WritingCmdLineHandlerDecorators>`__
|  `Best Practices Suggestions <#BestPracticesSuggestions>`__
| 

Introduction
============

The *jcmdline* package contains classes used to parse and process
command line options and arguments from a Java program. This package was
written with the following goals:

-  Simplify processing of command line options and parameters.
-  Encourage uniformity of command line conventions and usage display
   throughout a project.
-  Make it difficult to add a command line option without its being
   documented in the command usage.

`[toc] <#toc>`__

Obtaining this Document
=======================

The most current version of this user guide is supplied in the
*doc-files* directory for the jcmdline package. It is accessible from a
link in the ***Description*** section of the package summary of the
jcmdline API javadoc and/or may be downloaded with the source files.

`[toc] <#toc>`__

Some Semantics
==============

Throughout this document, the following semantics are used.

option
    A command line *option* is comprised of an identifying "tag",
    typically preceded by a dash or two, and optionally requires a
    value. A typical *option* might be "``-outfile /tmp/myfile``\ ".
argument
    A command line *argument* is specified on the command line after all
    of the options and their values.
parameter
    A command line *parameter* is an *option* or an *argument*.

For instance:

::

        javadoc -d /home/html -sourcepath /home/src java.awt
                \__________          _____________/ \      /
                             options                arguments
                \______________             _______________/
                                 parameters

`[toc] <#toc>`__

Quick Start
===========

Using the *jcmdline* package requires the following steps:

-  Define the option and argument `Parameters <#Parameters>`__ the
   command will accept.
-  Create a `CmdLineHandler <#CommandLineHandlers>`__ using the defined
   options and arguments.
-  Call the ``parse()`` method of the CmdLineHandler.
-  Access the values that have been set in the parameters.

`[toc] <#toc>`__

Define The Parameters
---------------------

For this example, set up some parameters for a program that will work
sort of like the Unix "grep" command:

::

    public static void main(String[] args) {

        // command line arguments
        StringParam patternArg =
            new StringParam("pattern", "the pattern to match",
                            StringParam.REQUIRED);
        FileParam filesArg =
            new FileParam("file",
                          "a file to be processed - defaults to stdin",
                          FileParam.IS_FILE & FileParam.IS_READABLE,
                          FileParam.OPTIONAL,
                          FileParam.MULTI_VALUED);

        // command line options
        BooleanParam ignorecaseOpt =
            new BooleanParam("ignoreCase", "ignore case while matching");
        BooleanParam listfilesOpt = 
            new BooleanParam("listFiles", "list filenames containing pattern");

        // a help text because we will use a HelpCmdLineHandler so our
        // command will display verbose help with the -help option
        String helpText = "This command prints to stdout all lines within " +
                          "the specified files that contain the specified " +
                          "pattern.\n\n" + 
                          "Optionally, the matching may be done without " +
                          "regard to case (using the -ignorecase option).\n\n" +                          
                          "If the -listFiles option is specified, only the " + 
                          "names of the files containing the pattern will be " +                 
                          "listed.  In this case, files to process must be " +
                          "specified on the command line";

`[toc] <#toc>`__

Create a CmdLineHandler
-----------------------

Next a ``CmdLineHandler`` is instantiated to process the command line:

::

    CmdLineHandler cl =
        new VersionCmdLineHandler("V 5.2",
        new HelpCmdLineHandler(helpText,
            "kindagrep",
            "find lines in files containing a specified pattern",
            new Parameter[] { ignorecaseOpt, listfilesOpt },
            new Parameter[] { patternArg, filesArg } ));

The ``CmdLineHandler`` used here uses some supplied
`Decorators <#decorators>`__ to provide some typical options. The
options supported by this ``CmdLineHandler``, in addition to those
defined by the program itself are:
``-h, -?, -h!, -help, -help!, -version`` (see the information on `hidden
parameters <#hidden>`__ for the h! and help! options)..

`[toc] <#toc>`__

Parse the Command Line
----------------------

Now parse the command line:

::

    cl.parse(args);

The ``parse()`` method will not return if the command line does not
validate - instead the command usage and an error message will be
displayed and the program will exit with exit status = 1 (an option may
be specified to the ``CmdLineHandler`` to modify this behavior to throw
an exception instead, if desired).

The usage and error message displayed when a non-existent file is
specified is:

::

    kindagrep - find lines in files containing a specified pattern

    Usage: kindagrep [options] pattern [file],[file]...

    where:

    pattern = the pattern to match (required)
    file    = a file to be processed - defaults to stdin (optional)

    and options are:

    -?           prints usage to stdout; exits (optional)
    -h           prints usage to stdout; exits (optional)
    -help        displays verbose help information (optional)
    -ignoreCase  ignore case while matching (optional)
    -listFiles   list filenames containing pattern (optional)
    -version     displays command's version (optional)

    Option tags are not case sensitive, and may be truncated as long as they remain
    unambiguous.  Option tags must be separated from their corresponding values by
    whitespace, or by an equal sign.  Boolean options (options that require no
    associated value) may be specified alone (=true), or as 'tag=value' where value
    is 'true' or 'false'.

    ERROR: Invalid name (nosuchfile) specified for <file>, must be an existing,
           readable, file.

`[toc] <#toc>`__

Access the Processed Parameters
-------------------------------

Following the call to the ``CmdLineHandler``, it can be assumed that:

-  All **REQUIRED** options and arguments have values.
-  All parameters with a restricted set of acceptable values are set to
   one of the specified values.
-  Any type-specific validation for a particular parameter type has been
   performed. For instance, in the above example, it can be counted on
   that any ``File`` object returned by the ``getFiles()`` call to
   parameter ``filesArg`` will, in fact, represent an existing, readable
   file.

The program can now access the processed parameters and their values:

::

    // this can't be check by CmdLineHandler
    if (listfilesOpt.isTrue() && ! filesArg.isSet()) {
        cl.exitUsageError(
            "filename(s) must be specified with -listFiles option");
    }
     String pattern = patternArg.getValue();

    if (filesArg.isSet()) {
        for (File f : filesArg.getValues()) { 
            findPattern(pattern, new FileInputStream(f), listfilesOpt.isTrue());
        }
    } else {
        findPattern(pattern, System.in, false);
    }

Note that the relationship between the ``listfilesOpt`` and ``filesArg``
is not checked by the ``CmdLineHandler``, but must be checked
explicitly. The ``exitUsageError()`` method of the ``CmdLineHandler`` is
then used to display the usage and error message in case of error.

`[toc] <#toc>`__

Parameters
----------

All command line options and arguments are represented by
`Parameter <http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/Parameter.html>`__
objects. All parameters support the following characteristics:

+--------------------------+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| **tag**                  | The *tag* is used to identify the parameter. For options, the *tag* indicates how the option is specified, for instance, a *tag* of "outfile" indicates an option specified like "-outfile /tmp/myfile". For command line arguments, the tag is typically used by the usage display formatter to identify the argument.   |
+--------------------------+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| **description**          | The *description* is used by the usage display formatter to describe a parameter.                                                                                                                                                                                                                                         |
+--------------------------+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| **optional indicator**   | The *optional indicator* indicates whether a parameter is optional or required. If a parameter is configured to be required, the `CmdLineHandler <http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/CmdLineHandler.html>`__ will reject the command line if the parameter is not specified.                           |
+--------------------------+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| **multi-valued**         | A parameter that is *multi-valued* can be specified more than once. This is frequently used with the final command line argument when the command accepts multiple instances.                                                                                                                                             |
+--------------------------+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+

The *jcmdline* package comes with ``Parameter`` classes to handle
several types of common parameters. See the list of subclasses for
`AbstractParameter <http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/AbstractParameter.html>`__
for a complete list. As of this writing, the following ``Parameter``
classes are available:

+------------------------------------------------------------------------------------------------+--------------------------------------------------------------------------------------------------------------------+
| `StringParam <http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/StringParam.html>`__       | handles generic string parameters - can be used for any parameter for which a more specific class does not exist   |
+------------------------------------------------------------------------------------------------+--------------------------------------------------------------------------------------------------------------------+
| `FileParam <http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/FileParam.html>`__           | handles filename parameters                                                                                        |
+------------------------------------------------------------------------------------------------+--------------------------------------------------------------------------------------------------------------------+
| `IntParam <http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/IntParam.html>`__             | handles numeric integer parameters                                                                                 |
+------------------------------------------------------------------------------------------------+--------------------------------------------------------------------------------------------------------------------+
| `BooleanParam <http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/BooleanParam.html>`__     | handles boolean parameters                                                                                         |
+------------------------------------------------------------------------------------------------+--------------------------------------------------------------------------------------------------------------------+
| `DateTimeParam <http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/DateTimeParam.html>`__   | handles parameters consisting of a date and time                                                                   |
+------------------------------------------------------------------------------------------------+--------------------------------------------------------------------------------------------------------------------+
| `DateParam <http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/DateParam.html>`__           | handles parameters consisting of a date only                                                                       |
+------------------------------------------------------------------------------------------------+--------------------------------------------------------------------------------------------------------------------+
| `TimeParam <http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/TimeParam.html>`__           | handles parameters consisting of a time only                                                                       |
+------------------------------------------------------------------------------------------------+--------------------------------------------------------------------------------------------------------------------+

If an application supports several different commands, more than one of
which accepts a new and different type of Parameter, it is strongly
suggested that a new subclass of
`AbstractParameter <http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/AbstractParameter.html>`__
be written to handle that type. This will provide greater consistency
amongst the commands in the application.

`[toc] <#toc>`__

When Supplied Parameters Are Not Adequate
-----------------------------------------

It may sometimes be the case that the Parameter classes supplied by the
*jcmdline* package cannot completely validate a parameter. For instance,
perhaps a command line parameter must not only be a readable file, but
it must also be a file whose name ends in ".html". For cases where the
supplied parameters just don't quite do it, there are a couple of
options:

-  Post process the parameter after the ``parse()`` call
-  Create a new Parameter class to handle the validation

`[toc] <#toc>`__

Post-processing Parameters
~~~~~~~~~~~~~~~~~~~~~~~~~~

The
`CmdLineHandler <http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/CmdLineHandler.html>`__
interface supports a method, ``exitUsageError()``, that can be used to
exit the program, displaying the usage, just as it would have been
exited if an error had been detected during the parse. This method
should be called if there is an error when a parameter is
post-processed.

The following code snippet demonstrates use of the ``exitUsageError()``
method when a filename parameter is validated to end with ".html" after
the command line is parsed by the ``CmdLineHandler``:

::

    cl.parse(args);
    if (! myfile.getFile().getPath().endsWith(".html")) {
        cl.exitUsageError("Filename specified for '" +
                          myfile.getTag() + "' must end with '.html'");
    }

`[toc] <#toc>`__

Creating Custom Parameter Classes
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

If an application requires custom parameter validation in more than one
place, it would be better to create a custom Parameter class to handle
the validation. A template type of class,
`AbstractParameter <http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/AbstractParameter.html>`__,
has been provided to make this easier. Instructions for how to use this
class to create a custom Parameter class are in the
`javadoc <http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/AbstractParameter.html>`__
for the class.

`[toc] <#toc>`__

Command Line Handlers
=====================

The CmdLineHandler classes control the parsing and validation of command
line parameters. This package comes with one basic CmdLineHandler,
named, coincidentally,
`BasicCmdLineHandler <http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/BasicCmdLineHandler>`__
.

Although the ``BasicCmdLineHandler`` is, technically, the only "real"
command line handler supplied by this package, there are several
"`decorator <#decorators>`__\ " command line handlers that can be used
to add functionality. Typically, a program will use one or more of these
"decorator" classes when making use of this package.

The CmdLineHandler performs the following functions:

-  Accepts the setup information defining the command name (which is
   frequently different from the name of the class that implements the
   command), command description, and the options and arguments the
   command will accept.
-  Supports a ``parse()`` method that:

   -  Calls its parser to parse and set the command line options and
      arguments.
   -  Verifies that all required parameters have been set with values.
   -  Takes appropriate action if the command line is in error. The
      "standard" appropriate action in case of error is to display the
      command's usage statement and exit.

`[toc] <#toc>`__

Parsers
-------

A ``CmdLineHandler`` uses a
`CmdLineParser <http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/CmdLineParser.html>`__
to perform the actual parsing of the command line. There is only one
``CmdLineParser`` that comes with the *jcmdline* package - the
`PosixCmdLineParser <http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/PosixCmdLineParser.html>`__,
but the capability exists for a user to create and use their own parser.

`[toc] <#toc>`__

The PosixCmdLineParser
~~~~~~~~~~~~~~~~~~~~~~

The ``PosixCmdLineParser``, basically, accepts options preceded by
either a '-', or a '--', that may, optionally, have an associated value
separated from the option "tag" by a space or an '='. Command line
options end with the first parameter that does **not** start with a '-'
or a '--', or when a '--' appears by itself as a parameter. A '--' must
be used alone to signal the end of options when the first command line
argument starts with a '-'.

Option tags are parsed in a case insensitive manner. Truncated option
tags are accepted as long as the tag remains un-ambiguous (execpt for
hidden options, whose tags must be fully specified).

A BooleanParam may be specified either without a value (in which case it
is set to ``true``), or with an '=' followed by its value. If a
BooleanParam is specified more than once, the final specification takes
precedence.

Using the ``PosixCmdLineParser``, the following command lines are all
equivalent:

::

    java Concat -delete -out myoutfile infile1 infile2
    java Concat -d -o myoutfile infile1 infile2
    java Concat -delete=true -o myoutfile infile1 infile2
    java Concat -d=true -o=myoutfile infile1 infile2
    java Concat -Delete -OUT myoutfile infile1 infile2

See the
`API <http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/PosixCmdLineParser.html>`__
for ``PosixCmdLineParser`` for a more complete description.

`[toc] <#toc>`__

Usage Formatters
~~~~~~~~~~~~~~~~

A ``CmdLineParser`` is configured with a
`UsageFormatter <http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/UsageFormatter.html>`__
that it uses to format command usage and error messages. The only
``UsageFormatter`` that comes with the *jcmdline* package is the
`TextUsageFormatter <http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/TextUsageFormatter.html>`__,
but the option is there for a user to define their own.

`[toc] <#toc>`__

CmdLineHandler Decorators
-------------------------

A Decorator, or Wrapper, pattern has been set up to facilitate the
implementation of options whose processing can take place entirely at
option parse time. This pattern was chosen in order that programmers can
mix and match options that seem useful to their particular applications.
It works, basically, as follows:

-  Each "decorator" class implements the
   `CmdLineHandler <http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/CmdLineHandler.html>`__
   interface.
-  An object of type ``CmdLineHandler`` is passed to the constructor of
   the "decorator" class (some have constructors that will generate
   their own underlying ``CmdLineHandler``).
-  By default, all methods pass through to the underlying
   ``CmdLineHandler``. Functionality is added by the addition of
   processing during selected method calls.

Because each "decorator" class implements the ``CmdLineHandler``
interface, and each accepts a ``CmdLineHandler`` as its base handler at
construction, "decorator" classes can be "nested".

``CmdLineHandler`` decorator classes that are supplied with the
*jcmdline* package include the following. All of these classes take
their option tags from a resource bundle. The values defined for English
are used in the descriptions.

+----------------------------------------------------------------------------------------------------------------+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| `DefaultCmdLineHandler <http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/DefaultCmdLineHandler.html>`__   | A ``CmdLineHandler`` that implements options that will cause command usage to be displayed. The option tags are "-h" or "-?" to display regular usage, "-h!" to display a usage that includes hidden parameters.                                                                                                                                   |
+----------------------------------------------------------------------------------------------------------------+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| `HelpCmdLineHandler <http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/HelpCmdLineHandler.html>`__         | A ``CmdLineHandler`` that implements options that will cause command usage and a more verbose help message to be displayed. The option tags are "-help" to display regular help and "-help!" to display a help text that includes hidden parameters.                                                                                               |
+----------------------------------------------------------------------------------------------------------------+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| `VersionCmdLineHandler <http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/VersionCmdLineHandler.html>`__   | A ``CmdLineHandler`` that implements an option that will cause the command version to be displayed. The option tag is "-version".                                                                                                                                                                                                                  |
+----------------------------------------------------------------------------------------------------------------+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| `LoggerCmdLineHandler <http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/LoggerCmdLineHandler.html>`__     | A ``CmdLineHandler`` that implements an option that supports setting the logging level for the root logger and adds a StreamHandler to the root logger to manage the messages. See the java.util.logging package for information on java logging. The option tag is "-log" and it requires a value that is a valid, localized, ``Level`` string.   |
+----------------------------------------------------------------------------------------------------------------+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+

These classes may be used separately, or together. For instance, to use
a ``CmdLineHandler`` that supports the "-h", "-?", "-h!", "-help",
"-help!", and "-version" command line options, as well as any command
specific options and arguments, the following would work:

::

    public static void main(String args) {
        // define options and arguments
        .
        CmdLineHandler clh = 
            new HelpCmdLineHandler(helpText,
            new VersionCmdLineHandler(myVersion,
            new DefaultCmdLineHandler(cmdName,
                                      cmdDescription,
                                      options,
                                      args)));
        clh.parse(args);
        .
        .

Writing CmdLineHandler Decorators
---------------------------------

The class
`AbstractHandlerDecorator <http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/AbstractHandlerDecorator.html>`__
is supplied with the *jcmdline* package to facilitate the writing of
``CmdLineHandler`` decorator classes. This class implements all methods
of the
`CmdLineHandler <http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/CmdLineHandler.html>`__
interface by, for the most part, delegating to a "contained"
``CmdLineHandler`` object. Using this class, a new decorator class can
be created by implementing a single method and the required
constructors.

The best instructions for using this class are to be found in the
`javadoc <http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/AbstractHandlerDecorator.html>`__
for ``AbstractHandlerDecorator``, so they will not be repeated here.

`[toc] <#toc>`__

Best Practices Suggestions
==========================

Following are suggestions from the author of this package for how to get
the best results, particularly when your application includes multiple
executables.

-  If several of the executables take the same type of parameter, and
   there is not already a parameter tailored for it, create a new
   subclass of
   `AbstractParameter <http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/AbstractParameter.html>`__
   to manage it. For instance, if several of your commands take an email
   address parameter, it would be useful to create an ``EmailParam``
   that would accept and validate the passed email address.
-  Create your own ``CmdLineHandler``, based on a preferred collection
   of existing
   `AbstractHandlerDecorator <http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/doc-files/AbstractHandlerDecorator.html>`__
   classes and what ever other options that might be desirable. This has
   a couple of advantages:

   -  All commands share the same core command line options (like
      -version, -h, -help...), so behave in a consistent manner.
   -  Help documentation for common options can be written once.
   -  It makes it easy to add support for new common options to all
      commands.

   The basis for an application specific ``CmdLineHandler`` class that
   demonstrates this can be found
   `here <http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/doc-files/MyappCmdLineHandler.java.txt>`__.

`[toc] <#toc>`__
