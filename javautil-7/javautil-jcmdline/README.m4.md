changequote(`{{', `}}')
<a name="home"/>
# javautil-commandline

Create command line arguments by creating an annotated commandline bean

## Getting Started

clone this repository and *mvn clean install*

# Quick Start

Using the *javautil-jcmdline*  requires the following steps:

*   Define the option and argument [Parameters](#param) the command will
    accept by annotating an *Argument Bean* TODO
*   Create a properties file that describes the program and parameters TODO properties file 
*   Call the **getArguments** method on the Arguments Bean

TODO checks 
TODO better than 100 set methods not just for main
TODO validate a populated bean

## Semantics

Throughout this document, the following semantics are used:

* **option**    A command line **option** is comprised of an identifying "tag",
    typically preceded by a dash or two, and optionally requires a
    value. A typical *option* might be "`-outfile /tmp/myfile`".
* **argument**   A command line *argument* is specified on the command line after all
    of the options and their values.
* **parameter**  A command line *parameter* is an *option* or an *argument*.

<a name="ArgumentBean">
## Arguments Bean
</a>
The *argument bean* will hold all of the specified options and parameters.

Each member has one or more [annotations](#Annotations) that describe the requirements for
the parameter and affect the parsing response to user input and validation.

### Example Arguments Bean 

```
include({{md/WorkbookWriterArguments.java}})
```

	
### main	
```
	public static void main(String[] args) Exception {
		WorkbookWriterArguments arguments = WorkbookWriterArguments.processArguments(args);
		new WorkbookWriter().process(arguments);
	}
```

### Properties

Create a properties file in the appropriate resource directory.

For example, using default maven directory structure the bean

class WorkbookWriterArguments in package *org.javautil.poi.workbook* would be in 
src/main/resources/org/javautil/poi/workbook/WorkbookWriterArguments.properties

Properties files for other locales should be appropriately named.

* applicationl.name generally the classname of the program containing the main

* application.HelpText text on program desription and usage

* parameter.description description of the parameter one per per parameter with same name as the annotated bean members


application.name=WorkbookWriter
application.HelpText=Creates Excel workbook
datasourceName.description=JNDI or connections.yaml datasource name

```
include({{md/DataLoadWorkbookArguments.properties}})
```


### Prerequisites

What things you need to install the software and how to install them


Give examples


## Annotations
include({{md/DataLoadWorkbookArguments.properties}})


# jcmdline Package User Guide Release 3.0.0


<a name="toc"/>

[Introduction](#toc1)\
 [Obtaining this Document](#toc2)\
 [Some Semantics](#toc3)\
 [Quick Start](#toc4)\
       [Define The Parameters](#toc5)\
       [Create a CmdLineHandler](#toc6)\
       [Parse the Command Line](#toc7)\
       [Access the Processed Parameters](#toc8)\
 [Parameters](#toc9)\
       [When Supplied Parameters Are Not Adequate](#toc10)\
             [Post-processing Parameters](#toc11)\
             [Creating Custom Parameter Classes](#toc12)\
 [Command Line Handlers](#toc13)\
       [Parsers](#toc14)\
             [The PosixCmdLineParser](#toc15)\
             [Usage Formatters](#toc16)\
       [CmdLineHandler Decorators](#toc17)\
       [Writing CmdLineHandler Decorators](#toc18)\
 [Best Practices Suggestions](#toc19)\

[[toc]](#toc)

<a name="Introduction">
Introduction</a>

The *jcmdline* package contains classes used to parse and process
command line options and arguments from a Java program. This package was
written with the following goals:

-   Simplify processing of command line options and parameters.
-   Encourage uniformity of command line conventions and usage display
    throughout a project.
-   Make it difficult to add a command line option without its being
    documented in the command usage.

[[toc]](#toc)

# Obtaining this Document


The most current version of this user guide is supplied in the
*doc-files* directory for the jcmdline package. It is accessible from a
link in the ***Description*** section of the package summary of the
jcmdline API javadoc and/or may be downloaded with the source files.

[[toc]](#toc)

# Some Semantics

Throughout this document, the following semantics are used.

option
:   A command line *option* is comprised of an identifying "tag",
    typically preceded by a dash or two, and optionally requires a
    value. A typical *option* might be "`-outfile /tmp/myfile`".
argument
:   A command line *argument* is specified on the command line after all
    of the options and their values.
parameter
:   A command line *parameter* is an *option* or an *argument*.

For instance:

        javadoc -d /home/html -sourcepath /home/src java.awt
                \__________          _____________/ \      /
                             options                arguments
                \______________             _______________/
                                 parameters

[[toc]](#toc)

# Quick Start


Using the *jcmdline* package requires the following steps:

*   Define the option and argument [Parameters](#param) the command will
    accept.
*   Create a [CmdLineHandler](#clh) using the defined options and
    arguments.
*   Call the `parse()` method of the CmdLineHandler.
*   Access the values that have been set in the parameters.

[[toc]](#toc)

## Define The Parameters

For this example, set up some parameters for a program that will work
sort of like the Unix "grep" command:

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

[[toc]](#toc)

## Create a CmdLineHandler

Next a `CmdLineHandler` is instantiated to process the command line:

            CmdLineHandler cl =
                new VersionCmdLineHandler("V 5.2",
                new HelpCmdLineHandler(helpText,
                    "kindagrep",
                    "find lines in files containing a specified pattern",
                    new Parameter[] { ignorecaseOpt, listfilesOpt },
                    new Parameter[] { patternArg, filesArg } ));

The `CmdLineHandler` used here uses some supplied
[Decorators](#decorators) to provide some typical options. The options
supported by this `CmdLineHandler`, in addition to those defined by the
program itself are: `-h, -?, -h!, -help, -help!, -version` (see the
information on [hidden parameters](#hidden) for the h! and help!
options)..

[[toc]](#toc)

## Parse the Command Line

Now parse the command line:

            cl.parse(args);

The `parse()` method will not return if the command line does not
validate - instead the command usage and an error message will be
displayed and the program will exit with exit status = 1 (an option may
be specified to the `CmdLineHandler` to modify this behavior to throw an
exception instead, if desired).

The usage and error message displayed when a non-existent file is
specified is:

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

[[toc]](#toc)

## Access the Processed Parameters

Following the call to the `CmdLineHandler`, it can be assumed that:

-   All **REQUIRED** options and arguments have values.
-   All parameters with a restricted set of acceptable values are set to
    one of the specified values.
-   Any type-specific validation for a particular parameter type has
    been performed. For instance, in the above example, it can be
    counted on that any `File` object returned by the `getFiles()` call
    to parameter `filesArg` will, in fact, represent an existing,
    readable file.

The program can now access the processed parameters and their values:

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

Note that the relationship between the `listfilesOpt` and `filesArg` is
not checked by the `CmdLineHandler`, but must be checked explicitly. The
`exitUsageError()` method of the `CmdLineHandler` is then used to
display the usage and error message in case of error.

[[toc]](#toc)

## Parameters

All command line options and arguments are represented by
[Parameter](http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/Parameter.html)
objects. All parameters support the following characteristics:

+--------------------------------------+--------------------------------------+
| **tag**                              | The *tag* is used to identify the    |
|                                      | parameter.                           |
|                                      | For options, the *tag* indicates how |
|                                      | the option is specified, for         |
|                                      | instance, a *tag* of "outfile"       |
|                                      | indicates an option specified like   |
|                                      | "-outfile /tmp/myfile".              |
|                                      |                                      |
|                                      | For command line arguments, the tag  |
|                                      | is typically used by the usage       |
|                                      | display formatter to identify the    |
|                                      | argument.                            |
+--------------------------------------+--------------------------------------+
| **description**                      | The *description* is used by the     |
|                                      | usage display formatter to describe  |
|                                      | a parameter.                         |
+--------------------------------------+--------------------------------------+
| **optional indicator**               | The *optional indicator* indicates   |
|                                      | whether a parameter is optional or   |
|                                      | required. If a parameter is          |
|                                      | configured to be required, the       |
|                                      | [CmdLineHandler](http://jcmdline.sou |
|                                      | rceforge.net/jcmdline/api/jcmdline/C |
|                                      | mdLineHandler.html)                  |
|                                      | will reject the command line if the  |
|                                      | parameter is not specified.          |
+--------------------------------------+--------------------------------------+
| **multi-valued**                     | A parameter that is *multi-valued*   |
|                                      | can be specified more than once.     |
|                                      | This is frequently used with the     |
|                                      | final command line argument when the |
|                                      | command accepts multiple instances.  |





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

jcmdline Package User Guide Release 2.0.0
=========================================

[Introduction](#toc1)\
 [Obtaining this Document](#toc2)\
 [Some Semantics](#toc3)\
 [Quick Start](#toc4)\
       [Define The Parameters](#toc5)\
       [Create a CmdLineHandler](#toc6)\
       [Parse the Command Line](#toc7)\
       [Access the Processed Parameters](#toc8)\
 [Parameters](#toc9)\
       [When Supplied Parameters Are Not Adequate](#toc10)\
             [Post-processing Parameters](#toc11)\
             [Creating Custom Parameter Classes](#toc12)\
 [Command Line Handlers](#toc13)\
       [Parsers](#toc14)\
             [The PosixCmdLineParser](#toc15)\
             [Usage Formatters](#toc16)\
       [CmdLineHandler Decorators](#toc17)\
       [Writing CmdLineHandler Decorators](#toc18)\
 [Best Practices Suggestions](#toc19)\

[[toc]](#toc)

Introduction
============

The *jcmdline* package contains classes used to parse and process
command line options and arguments from a Java program. This package was
written with the following goals:

-   Simplify processing of command line options and parameters.
-   Encourage uniformity of command line conventions and usage display
    throughout a project.
-   Make it difficult to add a command line option without its being
    documented in the command usage.

[[toc]](#toc)

Obtaining this Document
=======================

The most current version of this user guide is supplied in the
*doc-files* directory for the jcmdline package. It is accessible from a
link in the ***Description*** section of the package summary of the
jcmdline API javadoc and/or may be downloaded with the source files.

[[toc]](#toc)

Some Semantics
==============

Throughout this document, the following semantics are used.

option
:   A command line *option* is comprised of an identifying "tag",
    typically preceded by a dash or two, and optionally requires a
    value. A typical *option* might be "`-outfile /tmp/myfile`".
argument
:   A command line *argument* is specified on the command line after all
    of the options and their values.
parameter
:   A command line *parameter* is an *option* or an *argument*.

For instance:

        javadoc -d /home/html -sourcepath /home/src java.awt
                \__________          _____________/ \      /
                             options                arguments
                \______________             _______________/
                                 parameters

[[toc]](#toc)

Quick Start
===========

Using the *jcmdline* package requires the following steps:

-   Define the option and argument [Parameters](#param) the command will
    accept.
-   Create a [CmdLineHandler](#clh) using the defined options and
    arguments.
-   Call the `parse()` method of the CmdLineHandler.
-   Access the values that have been set in the parameters.

[[toc]](#toc)

Define The Parameters
---------------------

For this example, set up some parameters for a program that will work
sort of like the Unix "grep" command:

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

[[toc]](#toc)

Create a CmdLineHandler
-----------------------

Next a `CmdLineHandler` is instantiated to process the command line:

            CmdLineHandler cl =
                new VersionCmdLineHandler("V 5.2",
                new HelpCmdLineHandler(helpText,
                    "kindagrep",
                    "find lines in files containing a specified pattern",
                    new Parameter[] { ignorecaseOpt, listfilesOpt },
                    new Parameter[] { patternArg, filesArg } ));

The `CmdLineHandler` used here uses some supplied
[Decorators](#decorators) to provide some typical options. The options
supported by this `CmdLineHandler`, in addition to those defined by the
program itself are: `-h, -?, -h!, -help, -help!, -version` (see the
information on [hidden parameters](#hidden) for the h! and help!
options)..

[[toc]](#toc)

Parse the Command Line
----------------------

Now parse the command line:

            cl.parse(args);

The `parse()` method will not return if the command line does not
validate - instead the command usage and an error message will be
displayed and the program will exit with exit status = 1 (an option may
be specified to the `CmdLineHandler` to modify this behavior to throw an
exception instead, if desired).

The usage and error message displayed when a non-existent file is
specified is:

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

[[toc]](#toc)

Access the Processed Parameters
-------------------------------

Following the call to the `CmdLineHandler`, it can be assumed that:

-   All **REQUIRED** options and arguments have values.
-   All parameters with a restricted set of acceptable values are set to
    one of the specified values.
-   Any type-specific validation for a particular parameter type has
    been performed. For instance, in the above example, it can be
    counted on that any `File` object returned by the `getFiles()` call
    to parameter `filesArg` will, in fact, represent an existing,
    readable file.

The program can now access the processed parameters and their values:

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

Note that the relationship between the `listfilesOpt` and `filesArg` is
not checked by the `CmdLineHandler`, but must be checked explicitly. The
`exitUsageError()` method of the `CmdLineHandler` is then used to
display the usage and error message in case of error.

[[toc]](#toc)

Parameters
==========

All command line options and arguments are represented by
[Parameter](http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/Parameter.html)
objects. All parameters support the following characteristics:

+--------------------------------------+--------------------------------------+
| **tag**                              | The *tag* is used to identify the    |
|                                      | parameter.                           |
|                                      | For options, the *tag* indicates how |
|                                      | the option is specified, for         |
|                                      | instance, a *tag* of "outfile"       |
|                                      | indicates an option specified like   |
|                                      | "-outfile /tmp/myfile".              |
|                                      |                                      |
|                                      | For command line arguments, the tag  |
|                                      | is typically used by the usage       |
|                                      | display formatter to identify the    |
|                                      | argument.                            |
+--------------------------------------+--------------------------------------+
| **description**                      | The *description* is used by the     |
|                                      | usage display formatter to describe  |
|                                      | a parameter.                         |
+--------------------------------------+--------------------------------------+
| **optional indicator**               | The *optional indicator* indicates   |
|                                      | whether a parameter is optional or   |
|                                      | required. If a parameter is          |
|                                      | configured to be required, the       |
|                                      | [CmdLineHandler](http://jcmdline.sou |
|                                      | rceforge.net/jcmdline/api/jcmdline/C |
|                                      | mdLineHandler.html)                  |
|                                      | will reject the command line if the  |
|                                      | parameter is not specified.          |
+--------------------------------------+--------------------------------------+
| **multi-valued**                     | A parameter that is *multi-valued*   |
|                                      | can be specified more than once.     |
|                                      | This is frequently used with the     |
|                                      | final command line argument when the |
|                                      | command accepts multiple instances.  |
|                                      | The above [example](#ex1)            |
|                                      | demonstrates this type of usage.     |
+--------------------------------------+--------------------------------------+
| **acceptable values**                | Most                                 |
|                                      | [Parameter](http://jcmdline.sourcefo |
|                                      | rge.net/jcmdline/api/jcmdline/Parame |
|                                      | ter.html)                            |
|                                      | types allow the programmer to        |
|                                      | specify a set of values that the     |
|                                      | parameter will accept. The command   |
|                                      | line is rejected if a user attempts  |
|                                      | to set the parameter to any          |
|                                      | non-specified value.                 |
+--------------------------------------+--------------------------------------+
| **hidden indicator**                 | The *hidden* indicator is used to    |
|                                      | indicate whether a parameter is      |
|                                      | hidden or public. By default, all    |
|                                      | paramters are public, meaning that   |
|                                      | they will be described in a regular  |
|                                      | usage statement.                     |
|                                      | Optionally, a parameter may be       |
|                                      | designated hidden, in which case it  |
|                                      | may still be specified by the user,  |
|                                      | but is not displayed in a normal     |
|                                      | usage statement. Who has not shipped |
|                                      | code supporting "debug" or "trace"   |
|                                      | options that might be performance    |
|                                      | impacting and thus not be suitable   |
|                                      | for publication to the casual user?  |
|                                      | This indicator is for that type of   |
|                                      | option.                              |
|                                      |                                      |
|                                      | Both the                             |
|                                      | [DefaultCmdLineHandler](http://jcmdl |
|                                      | ine.sourceforge.net/jcmdline/api/jcm |
|                                      | dline/DefaultCmdLineHandler.html)    |
|                                      | and                                  |
|                                      | [HelpCmdLineHandler](http://jcmdline |
|                                      | .sourceforge.net/jcmdline/api/jcmdli |
|                                      | ne/HelpCmdLineHandler.html)          |
|                                      | support (hidden) command line        |
|                                      | options that will cause hidden       |
|                                      | options and help to be displayed.    |
+--------------------------------------+--------------------------------------+

The *jcmdline* package comes with `Parameter` classes to handle several
types of common parameters. See the list of subclasses for
[AbstractParameter](http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/AbstractParameter.html)
for a complete list. As of this writing, the following `Parameter`
classes are available:

  ------------------------------------------------------------------------------------------- ------------------------------------------------------------------------------------------------------------------
  [StringParam](http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/StringParam.html)       handles generic string parameters - can be used for any parameter for which a more specific class does not exist
  [FileParam](http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/FileParam.html)           handles filename parameters
  [IntParam](http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/IntParam.html)             handles numeric integer parameters
  [BooleanParam](http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/BooleanParam.html)     handles boolean parameters
  [DateTimeParam](http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/DateTimeParam.html)   handles parameters consisting of a date and time
  [DateParam](http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/DateParam.html)           handles parameters consisting of a date only
  [TimeParam](http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/TimeParam.html)           handles parameters consisting of a time only
  ------------------------------------------------------------------------------------------- ------------------------------------------------------------------------------------------------------------------

If an application supports several different commands, more than one of
which accepts a new and different type of Parameter, it is strongly
suggested that a new subclass of
[AbstractParameter](http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/AbstractParameter.html)
be written to handle that type. This will provide greater consistency
amongst the commands in the application.

[[toc]](#toc)

When Supplied Parameters Are Not Adequate
-----------------------------------------

It may sometimes be the case that the Parameter classes supplied by the
*jcmdline* package cannot completely validate a parameter. For instance,
perhaps a command line parameter must not only be a readable file, but
it must also be a file whose name ends in ".html". For cases where the
supplied parameters just don't quite do it, there are a couple of
options:

-   Post process the parameter after the `parse()` call
-   Create a new Parameter class to handle the validation

[[toc]](#toc)

### Post-processing Parameters

The
[CmdLineHandler](http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/CmdLineHandler.html)
interface supports a method, `exitUsageError()`, that can be used to
exit the program, displaying the usage, just as it would have been
exited if an error had been detected during the parse. This method
should be called if there is an error when a parameter is
post-processed.

The following code snippet demonstrates use of the `exitUsageError()`
method when a filename parameter is validated to end with ".html" after
the command line is parsed by the `CmdLineHandler`:

        cl.parse(args);
        if (! myfile.getFile().getPath().endsWith(".html")) {
            cl.exitUsageError("Filename specified for '" +
                              myfile.getTag() + "' must end with '.html'");
        }

[[toc]](#toc)

### Creating Custom Parameter Classes

If an application requires custom parameter validation in more than one
place, it would be better to create a custom Parameter class to handle
the validation. A template type of class,
[AbstractParameter](http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/AbstractParameter.html),
has been provided to make this easier. Instructions for how to use this
class to create a custom Parameter class are in the
[javadoc](http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/AbstractParameter.html)
for the class.

[[toc]](#toc)

Command Line Handlers
=====================

The CmdLineHandler classes control the parsing and validation of command
line parameters. This package comes with one basic CmdLineHandler,
named, coincidentally,
[BasicCmdLineHandler](http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/BasicCmdLineHandler)
.

Although the `BasicCmdLineHandler` is, technically, the only "real"
command line handler supplied by this package, there are several
"[decorator](#decorators)" command line handlers that can be used to add
functionality. Typically, a program will use one or more of these
"decorator" classes when making use of this package.

The CmdLineHandler performs the following functions:

-   Accepts the setup information defining the command name (which is
    frequently different from the name of the class that implements the
    command), command description, and the options and arguments the
    command will accept.
-   Supports a `parse()` method that:
    -   Calls its parser to parse and set the command line options and
        arguments.
    -   Verifies that all required parameters have been set with values.
    -   Takes appropriate action if the command line is in error. The
        "standard" appropriate action in case of error is to display the
        command's usage statement and exit.

[[toc]](#toc)

Parsers
-------

A `CmdLineHandler` uses a
[CmdLineParser](http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/CmdLineParser.html)
to perform the actual parsing of the command line. There is only one
`CmdLineParser` that comes with the *jcmdline* package - the
[PosixCmdLineParser](http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/PosixCmdLineParser.html),
but the capability exists for a user to create and use their own parser.

[[toc]](#toc)

### The PosixCmdLineParser

The `PosixCmdLineParser`, basically, accepts options preceded by either
a '-', or a '--', that may, optionally, have an associated value
separated from the option "tag" by a space or an '='. Command line
options end with the first parameter that does **not** start with a '-'
or a '--', or when a '--' appears by itself as a parameter. A '--' must
be used alone to signal the end of options when the first command line
argument starts with a '-'.

Option tags are parsed in a case insensitive manner. Truncated option
tags are accepted as long as the tag remains un-ambiguous (execpt for
hidden options, whose tags must be fully specified).

A BooleanParam may be specified either without a value (in which case it
is set to `true`), or with an '=' followed by its value. If a
BooleanParam is specified more than once, the final specification takes
precedence.

Using the `PosixCmdLineParser`, the following command lines are all
equivalent:

    java Concat -delete -out myoutfile infile1 infile2
    java Concat -d -o myoutfile infile1 infile2
    java Concat -delete=true -o myoutfile infile1 infile2
    java Concat -d=true -o=myoutfile infile1 infile2
    java Concat -Delete -OUT myoutfile infile1 infile2

See the
[API](http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/PosixCmdLineParser.html)
for `PosixCmdLineParser` for a more complete description.

[[toc]](#toc)

### Usage Formatters

A `CmdLineParser` is configured with a
[UsageFormatter](http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/UsageFormatter.html)
that it uses to format command usage and error messages. The only
`UsageFormatter` that comes with the *jcmdline* package is the
[TextUsageFormatter](http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/TextUsageFormatter.html),
but the option is there for a user to define their own.

[[toc]](#toc)

CmdLineHandler Decorators
-------------------------

A Decorator, or Wrapper, pattern has been set up to facilitate the
implementation of options whose processing can take place entirely at
option parse time. This pattern was chosen in order that programmers can
mix and match options that seem useful to their particular applications.
It works, basically, as follows:

-   Each "decorator" class implements the
    [CmdLineHandler](http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/CmdLineHandler.html)
    interface.
-   An object of type `CmdLineHandler` is passed to the constructor of
    the "decorator" class (some have constructors that will generate
    their own underlying `CmdLineHandler`).
-   By default, all methods pass through to the underlying
    `CmdLineHandler`. Functionality is added by the addition of
    processing during selected method calls.

Because each "decorator" class implements the `CmdLineHandler`
interface, and each accepts a `CmdLineHandler` as its base handler at
construction, "decorator" classes can be "nested".

`CmdLineHandler` decorator classes that are supplied with the *jcmdline*
package include the following. All of these classes take their option
tags from a resource bundle. The values defined for English are used in
the descriptions.

  ----------------------------------------------------------------------------------------------------------- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  [DefaultCmdLineHandler](http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/DefaultCmdLineHandler.html)   A `CmdLineHandler` that implements options that will cause command usage to be displayed. The option tags are "-h" or "-?" to display regular usage, "-h!" to display a usage that includes hidden parameters.
  [HelpCmdLineHandler](http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/HelpCmdLineHandler.html)         A `CmdLineHandler` that implements options that will cause command usage and a more verbose help message to be displayed. The option tags are "-help" to display regular help and "-help!" to display a help text that includes hidden parameters.
  [VersionCmdLineHandler](http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/VersionCmdLineHandler.html)   A `CmdLineHandler` that implements an option that will cause the command version to be displayed. The option tag is "-version".
  [LoggerCmdLineHandler](http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/LoggerCmdLineHandler.html)     A `CmdLineHandler` that implements an option that supports setting the logging level for the root logger and adds a StreamHandler to the root logger to manage the messages. See the java.util.logging package for information on java logging. The option tag is "-log" and it requires a value that is a valid, localized, `Level` string.
  ----------------------------------------------------------------------------------------------------------- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

These classes may be used separately, or together. For instance, to use
a `CmdLineHandler` that supports the "-h", "-?", "-h!", "-help",
"-help!", and "-version" command line options, as well as any command
specific options and arguments, the following would work:

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

[[toc]](#toc)

Writing CmdLineHandler Decorators
---------------------------------

The class
[AbstractHandlerDecorator](http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/AbstractHandlerDecorator.html)
is supplied with the *jcmdline* package to facilitate the writing of
`CmdLineHandler` decorator classes. This class implements all methods of
the
[CmdLineHandler](http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/CmdLineHandler.html)
interface by, for the most part, delegating to a "contained"
`CmdLineHandler` object. Using this class, a new decorator class can be
created by implementing a single method and the required constructors.

The best instructions for using this class are to be found in the
[javadoc](http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/AbstractHandlerDecorator.html)
for `AbstractHandlerDecorator`, so they will not be repeated here.

[[toc]](#toc)

Best Practices Suggestions
==========================

Following are suggestions from the author of this package for how to get
the best results, particularly when your application includes multiple
executables.

-   If several of the executables take the same type of parameter, and
    there is not already a parameter tailored for it, create a new
    subclass of
    [AbstractParameter](http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/AbstractParameter.html)
    to manage it. For instance, if several of your commands take an
    email address parameter, it would be useful to create an
    `EmailParam` that would accept and validate the passed email
    address.
-   Create your own `CmdLineHandler`, based on a preferred collection of
    existing
    [AbstractHandlerDecorator](http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/doc-files/AbstractHandlerDecorator.html)
    classes and what ever other options that might be desirable. This
    has a couple of advantages:
    -   All commands share the same core command line options (like
        -version, -h, -help...), so behave in a consistent manner.
    -   Help documentation for common options can be written once.
    -   It makes it easy to add support for new common options to all
        commands.

    The basis for an application specific `CmdLineHandler` class that
    demonstrates this can be found
    [here](http://jcmdline.sourceforge.net/jcmdline/api/jcmdline/doc-files/MyappCmdLineHandler.java.txt).

* * * * *

*Last Updated on 10/29/02*

Lynne Lawrence\
 [lgl@visuallink.com](mailto:lgl@visuallink.com)\

