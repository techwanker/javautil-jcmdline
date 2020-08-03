#############
javautil core
#############

Introduction
============

Javautil core provides classes used by all of the other javautil modules and has minimal dependencies 
specifically excluding frameworks like spring and hibernate.

Core has support for 

* Datasets
* Sql
  * Statements
  * Data Sources
  * Sqlrunner
* Rendering


Dataset
=======

javautil.org datasets are classes that can be viewed as a list of tuples
with metadata.

This is analagous to an in memory database table replete with data and metadata.

Creation
--------

List of Lists
List of Maps
Streaming ResultSet

Metadata
--------

::

    private String                 aggregateFunction;
    private String                 columnName;
    private Integer                columnIndex;
    private Integer                columnSize;
    private Integer                columnDisplaySize;
    private String                 columnTypeName;
    private Integer                columnType;
    private String                 comments;
    private DataType               dataType;
    private String                 dataTypeName;
    private boolean                externalFlag;
    private boolean                injectedGroupField = false;
    private Boolean                nullable;
    private Boolean                notNullable;
    private Integer                precision;
    private Integer                scale;
    // 
    private Boolean                definitelyNullable;
    private Boolean                unKnownNullable;

Labeling
~~~~~~~~
::

    private String                 groupName;
    private String                 heading;
    private String                 label;

Formatting
~~~~~~~~~~
::

    private SimpleDateFormat       inputDateFormat;
    private String                 inputDateFormatString;
    private String                 workbookFormula;
    private String                 javaFormat;
    private String                 excelFormat;
    private HorizontalAlignment    horizontalAlignment;

Other
~~~~~

::

    private String                 attributeName;

Rendering
---------

* json
* xml
* worksheet region
* database table

SqlRunner
=========

SqlRunner files can be processed by sqlplus or postgres.

This may be used to execute a series of SQL statements, be they DDL or DML except
that selects are not supported, use TODO to issue queries and get results


*--#<* are skipped as are all lines up to and including *--#>* 

This is easy to remember.  
The *--* is a sql comment so it is ignored by sqlplus *#* is the common comment marker and *<* is opening and *>* is closing

Directives
----------

- "--#  COMMENT_BLOCK_BEGIN
- "--#>" COMMENT_BLOCK_END
- "--#" SINGLE LINE COMMENT
- "--::<" MARKDOWN_BLOCK_BEGIN
- "--::>" MARKDOWN_BLOCK_END
- "--/<" PROCEDURE_BLOCK_START
- "--/>" PROCEDURE_BLOCK_END
- ";--" STATEMENT_END
- "--@NAME" name

Example
-------

::

    --#<
    set echo on
    --#>
    --# Single line comment
    --/<
     create or replace function  logger_message_formatter  (
          log_seq_nbr             in pls_integer,
          job_log_id    in   pls_integer,
          log_msg_id              in   varchar2,
          log_msg                 in   varchar2,
          log_level               in   pls_integer,
          caller_name             in   varchar2,
          line_number             in   pls_integer,
          call_stack              in   varchar2 DEFAULT NULL
       ) return varchar
       is
           my_log_msg  varchar2(32767) := REPLACE (log_msg, '"', '""');
           my_log_entry varchar2(32767);
       begin
          dbms_output.put_line('in format_log');

             my_log_entry :=
                    log_seq_nbr            || ','  ||
                    log_level              || ',"' ||
                    job_log_id   || ',"' ||
                    log_msg_id             || '",' ||
                    line_number            || ',' ||
                    to_char (current_timestamp, 'YYYY-MM-DD HH24:MI:SSXFF') || ',"' ||
                    my_log_msg             || '",' ||
                    caller_name            || '",' ||
                    call_stack;
         dbms_output.put_line('log entry: ' || my_log_entry);
             return my_log_entry;
    end;
    --/>
    --#<
    /
    show errors
    --#>

