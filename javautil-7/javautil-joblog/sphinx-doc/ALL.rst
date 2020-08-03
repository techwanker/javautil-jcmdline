

Logging to flat files
---------------------

Overview
~~~~~~~~

Logs messages using utl\_file to a directory on the database server
specified.

First the database directory is created and oracle is granted permission
to read and write it, then the ddl "create directory...." and "grant
read, write on directory..."

Examples
~~~~~~~~

log\_to\_file\_only.proc.sr.sql
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

Input
~~~~~
::

    set serveroutput on
    set echo on
    create or replace procedure log_to_file_only is 
           long_msg clob := 'this is an absurdly long message, ' || 
                    ' interesting stuff to say so I will just write meaningless ' ||
                    ' stuff for a little while. ' ||
                    ' The quick brown fox jumped over the lazy dog. '; 
        
        my_log_file_name varchar(4096); 
    begin
        my_log_file_name := pllogger.open_log_file('log_to_file_only.text');
        pllogger.set_filter_level(9); -- all messages should go to log file
        pllogger.info('anonymous',$$PLSQL_LINE,'begin loop');
        pllogger.info($$PLSQL_UNIT,$$PLSQL_LINE,long_msg); 
        for i in 1..3  
        loop
            pllogger.fine($$PLSQL_UNIT,$$PLSQL_LINE,'i is ' || to_char(i));
        end loop; 
        pllogger.close_log_file();
    exception when others then
            -- a severe condition is not necessarily fatal
        pllogger.severe($$PLSQL_UINIT,$$PLSQL_LINE,sqlerrm);
        pllogger.close_log_file();
        raise;
    end;
    /
    show errors

    exec log_to_file_only();

Output
~~~~~~

::

    "log_level","job_log_id","job_msg_id","line_number","timestamp","log_msg","caller_name","call_stack"
    4,,,17,"2019-10-26T17:19:52.885607","begin loop","anonymous",""
    4,,,18,"2019-10-26T17:19:52.886020","this is an absurdly long message,  exceeding the length of the log_msg field  this should be inserted into the log_msg_clob column.   This message is part of  a unit test of from sample_job_02 of the logging package.   I am running out of  interesting stuff to say so I will just write meaningless  stuff for a little while.  The quick brown fox jumped over the lazy dog. ","LOG_TO_FILE_ONLY",""
    7,,,22,"2019-10-26T17:19:52.886197","i is 1","LOG_TO_FILE_ONLY",""
    7,,,22,"2019-10-26T17:19:52.886357","i is 2","LOG_TO_FILE_ONLY",""
    7,,,22,"2019-10-26T17:19:52.886502","i is 3","LOG_TO_FILE_ONLY",""


Installation
============

Obtain the code
---------------

Install Oracle
==============

Download
--------

upload the jdbc drivers
~~~~~~~~~~~~~~~~~~~~~~~

go to
https://www.oracle.com/database/technologies/appdev/jdbc-ucp-19c-downloads.html
https://www.oracle.com/database/technologies/appdev/jdbc-ucp-19c-downloads.html#license-lightbox

Get the rdbms
~~~~~~~~~~~~~

go to
https://www.oracle.com/database/technologies/oracle-database-software-downloads.html
and select linux x86-64

save it in ~/Downloads/oracle19c

unfortunately this cannot be curled, so you have to use browser and then
upload it to amazon as you do not want to this every time you fire up an
instance save in an s3 container

or, just make things simpler upload it scp
~/Downloads/oracle19/LINUX.X64\_193000\_db\_home.zip
ec2-user@$amazon:~/Downloads

Time may vary from a few minutes to hours depending on your network
connection to upload 2.8 gb

Snap off your install

TODO create a base EC2 instance

https://docs.oracle.com/en/database/oracle/oracle-database/19/ladbi/index.html

Store in S3
-----------

Create a vault and upload the file

https://docs.aws.amazon.com/AmazonS3/latest/user-guide/upload-objects.html

Follow the directions

Create vault: oracle-licensed-code

Copy the files from s3 to your ecb
==================================

see https://n2ws.com/blog/how-to-guides/how-to-copy-data-from-s3-to-ebs
https://n2ws.com/blog/how-to-guides/how-to-copy-data-from-s3-to-ebs

aws create-access-key glacier

Installing
==========

Docs
----

https://docs.oracle.com/en/database/oracle/oracle-database/19/install-and-upgrade.html

Installing with Ansible
=======================

see
https://medium.com/oracledevs/devops-series-automate-oracle-19c-rdbms-installations-with-ansible-github-43cfdf344a4a

Create a user
https://console.aws.amazon.com/iam/home?region=us-east-1#/users

Create the pluggable container
==============================

cd ~/javautil-6/oracle/ddl sqlplus / as sysdba @
create\_sales\_reporting\_pdb

modify tnsnames
===============

Create and configure user
=========================

sqlplus system/tutorial@sales\_reporting @ create\_user

Database Logging 
================ 
included file

job\_tables
~~~~~~~~~~~

In the interest of expediency we have a quick listing of the job tables.

::

    SQL> describe job_log
     Name                                      Null?    Type
     ----------------------------------------- -------- ----------------------------
     JOB_LOG_ID                                NOT NULL NUMBER(9)
     SCHEMA_NAME                                        VARCHAR2(30)
     PROCESS_NAME                                       VARCHAR2(128)
     THREAD_NAME                                        VARCHAR2(128)
     STATUS_MSG                                         VARCHAR2(256)
     STATUS_TS                                          TIMESTAMP(9)
     END_TS                                             TIMESTAMP(9)
     ELAPSED_MILLIS                                     NUMBER(9)
     SID                                                NUMBER
     SERIAL_NBR                                         NUMBER
     IGNORE_FLG                                         VARCHAR2(1)
     MODULE_NAME                                        VARCHAR2(64)
     CLASSNAME                                          VARCHAR2(255)
     TRACEFILE_NAME                                     VARCHAR2(4000)
     TRACEFILE_DATA                                     CLOB
     TRACEFILE_JSON                                     CLOB
     ABORT_STACKTRACE                                   CLOB

    SQL> describe job_step
     Name                                      Null?    Type
     ----------------------------------------- -------- ----------------------------
     JOB_STEP_ID                               NOT NULL NUMBER(9)
     JOB_LOG_ID                                         NUMBER(9)
     STEP_NAME                                          VARCHAR2(64)
     CLASSNAME                                          VARCHAR2(256)
     STEP_INFO                                          VARCHAR2(2000)
     START_TS                                           TIMESTAMP(9)
     END_TS                                             TIMESTAMP(9)
     DBSTATS                                            CLOB
     STEP_INFO_JSON                                     CLOB
     CURSOR_INFO_RUN_ID                                 NUMBER(9)
     STACKTRACE                                         VARCHAR2(4000)

    SQL> describe job_msg;
     Name                                      Null?    Type
     ----------------------------------------- -------- ----------------------------
     JOB_MSG_ID                                         NUMBER(9)
     JOB_LOG_ID                                NOT NULL NUMBER(9)
     LOG_MSG_ID                                         VARCHAR2(8)
     LOG_MSG                                            VARCHAR2(256)
     LOG_MSG_CLOB                                       CLOB
     LOG_MSG_TS                                         TIMESTAMP(9)
     ELAPSED_TIME_MILLISECONDS                          NUMBER(9)
     LOG_SEQ_NBR                               NOT NULL NUMBER(18)
     CALLER_NAME                                        VARCHAR2(100)
     LINE_NBR                                           NUMBER(5)
     CALL_STACK                                         CLOB
     LOG_LEVEL                                          NUMBER(2)

Entity Relationship Diagram
~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. figure:: job_tables_erd.png


TODO run the python with the comments

Each job has one job\_log entry and one or more job\_steps.

Job steps may have associated log messages.


dblogger\_install\_tables
-------------------------

Creates the job and job step tables and views

sequences
^^^^^^^^^

cursor\_info\_run\_id\_seq; cursor\_info\_id\_seq; job\_log\_id\_seq;
job\_msg\_id\_seq; job\_step\_id\_seq;

tables
^^^^^^

-  cursor\_explain\_plan
-  cursor\_sql\_text
-  cursor\_info\_run
-  cursor\_info
-  cursor\_stat
-  job\_log
-  job\_msg
-  job\_step

views
^^^^^

-  cursor\_info\_vw
-  job\_step\_vw
-  job\_log\_vw

Job Logging
-----------

Logging information may be written to a text file, stored in a database
and written to the oracle trace file.

Steps start job logging.
~~~~~~~~~~~~~~~~~~~~~~~~

::

    public long sampleUsage(Dblogger dblogger, Connection appConnection) throws SqlSplitterException, Exception {
        dblogger.prepareConnection();
        final String processName = "Process Name";
        // Start the job

        final long logJobId = dblogger.startJobLogging(processName,getClass().getName(), null, null,  4);
        dblogger.setModule("SplitLoggerTest", "simple example");
        dblogger.setAction("Some work");
        dblogger.insertStep("Full join", "Meaningless busy work", getClass().getName());
        ConnectionUtil.exhaustQuery(appConnection, "select * from user_tab_columns, user_tables where rownum < 100");

        dblogger.setAction("Another set of work");
        ConnectionUtil.exhaustQuery(appConnection, "select count(*) from all_tab_columns");
        // End the job
        dblogger.endJob();
        return logJobId;
    }

job logging persistence has a bit of indirection

Installation
------------

Repositories
~~~~~~~~~~~~

RDBMS persistence support is provided for Oracle, H2 and postgresql

H2 is a lightweight database and may be used to eliminate the need for
support of another Oracle Database.

Postgresql is a high end database that requires minimimal installation
and administration.

You should probable not compound your problem with yet another Oracle
install, but if your DBA will allow you a schema in your database for
logging, you don't have to learn anything else.

The Oracle database could be the same instance as the application being
monitored, but this may raise some objections to the application DBA.

Oracle logging repository
~~~~~~~~~~~~~~~~~~~~~~~~~

If the logging data is to be persisted in Oracle, the tables must be
created and some packages created.

Job log tables
^^^^^^^^^^^^^^

1. job\_log
2. job\_msg
3. job step

| The granularity of job step is left to the invoker.
| As the overhead is very low, there is no reason to be parsimonious
with identification, it's a simple one line call in the user app.

These records can be reviewed for job sucess or failure and form a
historical basis of time elapsed by job and step.

This may be used as a starting pointing in locating "what processes are
using the time?"

Additionally they constitute a base performance metric from which
runtime degradation or periodic anomalous runs may be identified.

Data is committed by calls from java to the package logger, provided
here.

The package utilizes autonomous commits and hence may be safely called
using the same connection as the application.



Using in Java
#############

The javautil-dblogging.jar and its dependencies must be in your classpath.

Simply add a dependency to the maven co-ordinates specified in javautil-dblogging/pom.xml to your maven project.

The oracle jdbc driver must be in your maven repository.

Add dependencies
----------------

code-block:: 

    <dependency>
         <groupId>org.javautil</groupId>
         <artifactId>javautil-core</artifactId>
         <version>???</version>
    </dependency>
    <dependency>
        <groupId>org.javautil</groupId>
        <artifactId>javautil-dblogging</artifactId>
        <version>???</version>
    </dependency>

Specifying the appropriate version

Configure dblogger.properties
-----------------------------

TODO this should be externalized

code-block:: 

    dblogger.datasource.driver-class-name=org.h2.Driver
    dblogger.datasource.url=jdbc:h2:/tmp/dbloggerh2;AUTO_SERVER=TRUE;COMPRESS=TRUE
    dblogger.datasource.username=sr
    dblogger.datasource.password=tutorial

Trace Records
-------------

TODO provide reference for reading trace records 

see https://docs.oracle.com/cd/B10500_01/server.920/a96533/sqltrace.htm
TODO Oracle Trace File Analyzer https://docs.oracle.com/en/engineered-systems/health-diagnostics/trace-file-analyzer/tfaug/quick-start-guide.html#GUID-A1DBE3D4-6501-47D3-854E-E9978F19F7BA

Unfortunately I wrote the trace analyzer over a decade ago and I can't seem to find any documentation on the trace files.

You will have to look at the various parsers located in $JAVAUTIL_DBLOGGING/src/main/java/org/javautil/oracle/trace/record

The field names for the regular expression patterns are very descriptive.



Oracle Trace Analyzer
=====================

https://docs.oracle.com/en/engineered-systems/health-diagnostics/trace-file-analyzer/tfaug/quick-start-guide.html#GUID-41689DF9-F81D-4C8C-992F-78CF48F9B6DF

Modern applications frequently make use of micro-services.

Rather than having one connection to the database, services are called, each with it's own session.  Turning on oracle trace
results in many separate trace files being generated.

Oracle Trace Analyzer is essential to gather the trace information from these various files.

He we document how to use Oracle Trace Analyzer to populate the dblogger cursor tables.

V$SESSION
=========

TODO write more

V$SESSION contains very useful information.  

The V$SESSION information for your current connection is exposed through

https://docs.oracle.com/cd/B19306_01/appdev.102/b14258/d_appinf.htm#i999290

TODO document set

Trace Record Fields
===================

code-block::

                                           Cursor Operation 
               Type     Parsing ParseError Parse EXec Fetch Stat  Lobread Lobpgsize Close
    &#35;  cursorNumbe             X                X    X   X          
    ad     sgaAddress      X
    bytes  bytes                                                     X      X
    c      CpuMicroSec                        X     X    X           X      X         X
    card   cardinality
    cnt                                                      O
    cost   cost (optim
    cr     consistentR                        X     X    X           X      X
    cu     currentMode                        X     X    X           X      X
    dep    depth           X       X          X     X    X                            X
    e      elapsedMicr                        X     X    X           X      X         X
    err    oracleError             X
    hv     sqlHashValu     X
    id                                                       X
    len    sqlTeXtLeng     X       X
    lid                    X       X
    mis    libraryCach                        X     X    X
    obj    objectNumbe                                       X
    oct    oracleComma     X       X
    og     optimizerGo                        X     X    X
    op     operation                                           X
    p      physicalBlo                        X     X    X              X       X
    pid    processId                                           X
    plh                                       X     X    X
    pos    position (o                                         X
    pw     physicalWri                                         X
    r      rowCount                           X     X    X
    size                                                       O
    sqlid  sqlId           X
    str                                                                 X
    tim                                       X     X    X              X       X        X
    time
    type                                                                                                          X
    uid                    X      X


Damn authentication
===================

https://www.depesz.com/2007/10/04/ident/

change the pg\_hba.conf in /var/bli/data/pg\_hba.conf

