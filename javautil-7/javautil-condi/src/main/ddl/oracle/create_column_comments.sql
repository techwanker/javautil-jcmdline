comment on column UT_AREA_RESP.UT_AREA_RESP_NBR is 'Surrogate primary key.';
comment on column UT_AREA_RESP.FUNC_AREA_CD is '  ';
comment on column UT_AREA_RESP.FUNC_SHORT_DESCR is '  ';
comment on column UT_AREA_RESP.FUNC_LONG_DESCR is '  ';
comment on column UT_DATA_LOCATION.SCHEMA is 'The schema that contains the table being queried  ';
comment on column UT_DATA_LOCATION.TABLE_NAME is 'The name of the table being checked. The primary key from this table is stored as a condition identifier  ';
comment on column UT_MEASURE.MEAS_NBR is 'Surrogate primary key.';
comment on column UT_MEASURE.MEAS_ID is '  ';
comment on column UT_MEASURE.SHORT_DESCR is '  ';
comment on column UT_MEASURE.LONG_DESCR is '  ';
comment on column UT_MEASURE.ENTRY_USER is '  ';
comment on column UT_MEASURE.ENTRY_TM is '  ';
comment on column UT_MEASURE.MOD_USER is '  ';
comment on column UT_MEASURE.MOD_TM is '  ';
comment on column UT_METRIC.METRIC_NBR is 'Surrogate primary key.';
comment on column UT_METRIC.METRIC_ID is '  ';
comment on column UT_METRIC.METRIC_DESCR is '  ';
comment on column UT_METRIC.METRIC_QRY is '  ';
comment on column UT_METRIC_THRESHOLD.UT_METRIC_THRESHOLD_NBR is '  ';
comment on column UT_METRIC_THRESHOLD.MEAS_NBR is '  ';
comment on column UT_METRIC_THRESHOLD.ORG_NBR_SRC is '  ';
comment on column UT_METRIC_THRESHOLD.FACT_TABLE_ID is '  ';
comment on column UT_METRIC_THRESHOLD.DIMEN_TABLE_ID is '  ';
comment on column UT_METRIC_THRESHOLD.DIMEN_PK is '  ';
comment on column UT_METRIC_THRESHOLD.THRESHOLD_VAL_LOWER_FATAL is '  ';
comment on column UT_METRIC_THRESHOLD.THRESHOLD_VAL_LOWER_SEVERE is '  ';
comment on column UT_METRIC_THRESHOLD.THRESHOLD_VAL_LOWER_WARN is '  ';
comment on column UT_METRIC_THRESHOLD.THRESHOLD_VAL_UPPER_WARN is '  ';
comment on column UT_METRIC_THRESHOLD.THRESHOLD_VAL_UPPER_SEVERE is '  ';
comment on column UT_METRIC_THRESHOLD.THRESHOLD_VAL_UPPER_FATAL is '  ';
comment on column UT_METRIC_THRESHOLD.THRESHOLD_ORDER is '  ';
comment on column UT_METRIC_THRESHOLD.ENTRY_USER is '  ';
comment on column UT_METRIC_THRESHOLD.ENTRY_TM is '  ';
comment on column UT_METRIC_THRESHOLD.MOD_USER is '  ';
comment on column UT_METRIC_THRESHOLD.MOD_TM is '  ';
comment on column UT_QUERY.UT_QUERY_NBR is 'Surrogate primary key.';
comment on column UT_QUERY.QUERY_NM is 'The natural name of the query  ';
comment on column UT_QUERY.QUERY_DESCR is 'Description of the SQL query,
describes the condition being identified.  ';
comment on column UT_QUERY.SCHEMA is 'The schema that contains the condition dattable  ';
comment on column UT_QUERY.TABLE_NAME is 'The table name from which the primary key is being extracted to identify the condition  ';
comment on column UT_QUERY.QUERY_TEXT is 'A SQL select statement. The statement must return an numeric primary key for the table and optionally a second
value which is descriptive text. Any other columns are silently ignored.  ';
comment on column UT_QUERY.APEX_RPT_HEADING is '  ';
comment on column UT_QUERY.TABLE_ID is '  ';
comment on column UT_RULE_GRP.UT_RULE_GRP_NM is '  ';
comment on column UT_RULE_GRP.UT_RULE_GRP_DESCR is '  ';
comment on column UT_RULE_GRP.UT_RULE_GRP_LONG_DESCR is '  ';
comment on column UT_RULE_GRP.UT_RULE_GRP_NBR is 'Surrogate primary key.';
comment on column UT_RULE_GRP.THREAD_CNT is '  ';
comment on column UT_RULE_GRP.MAX_QUERY_SEC_DFLT is '  ';
comment on column UT_RULE_GRP_DTL.UT_TABLE_RULE_NBR is '  ';
comment on column UT_RULE_GRP_DTL.UT_RULE_GRP_NBR is '  ';
comment on column UT_RULE_GRP_DTL.RUN_SEQ is '  ';
comment on column UT_RULE_GRP_RUN.UT_RULE_GRP_RUN_NBR is 'Surrogate primary key.';
comment on column UT_RULE_GRP_RUN.UT_RULE_GRP_NBR is '  ';
comment on column UT_RULE_GRP_RUN.UT_RUN_GRP_DESCR is '  ';
comment on column UT_RULE_GRP_RUN.LAST_RUN_TM is '  ';
comment on column UT_RULE_GRP_RUN.CTRL_PT_NBR is '  ';
comment on column UT_RULE_GRP_RUN.UT_PROCESS_STATUS_NBR is 'Surrogate primary key.';
comment on column UT_RULE_GRP_RUN_PARM.UT_RULE_GRP_RUN_NBR is '  ';
comment on column UT_RULE_GRP_RUN_PARM.PARM_NM is '  ';
comment on column UT_RULE_GRP_RUN_PARM.PARM_VALUE_STRING is '  ';
comment on column UT_RULE_GRP_RUN_PARM.PARM_VALUE_NUMBER is 'Surrogate primary key.';
comment on column UT_RULE_GRP_RUN_PARM.PARM_VALUE_DATE is '  ';
comment on column UT_SCHEMA.SCHEMA_NM is '  ';
comment on column UT_SCHEMA.SCHEMA_DESCR is '  ';
comment on column UT_SCHEMA_GRP.UT_SCHEMA_GRP_NBR is 'Surrogate primary key.';
comment on column UT_SCHEMA_GRP.SCHEMA_GRP_NM is '  ';
comment on column UT_SCHEMA_GRP.SCHEMA_GRP_DESCR is '  ';
comment on column UT_SCHEMA_GRP_DTL.UT_SCHEMA_GRP_NBR is '  ';
comment on column UT_SCHEMA_GRP_DTL.SCHEMA_NM is '  ';
comment on column UT_TABLE.TABLE_ID is 'Natural primary key';
comment on column UT_TABLE.TABLE_NAME is '  ';
comment on column UT_TABLE_MSG.UT_RULE_GRP_RUN_NBR is '  ';
comment on column UT_TABLE_MSG.UT_TABLE_RULE_NBR is '  ';
comment on column UT_TABLE_MSG.MSG is '  ';
comment on column UT_TABLE_ROW_DIMEN_MEASURE.FACT_TABLE_ID is '  ';
comment on column UT_TABLE_ROW_DIMEN_MEASURE.FACT_TABLE_PK is '  ';
comment on column UT_TABLE_ROW_DIMEN_MEASURE.DIMEN_PK is '  ';
comment on column UT_TABLE_ROW_DIMEN_MEASURE.MEAS_NBR is '  ';
comment on column UT_TABLE_ROW_DIMEN_MEASURE.MEAS is '  ';
comment on column UT_TABLE_ROW_MEASURE.FACT_TABLE_ID is '  ';
comment on column UT_TABLE_ROW_MEASURE.FACT_TABLE_PK is '  ';
comment on column UT_TABLE_ROW_MEASURE.MEAS_NBR is '  ';
comment on column UT_TABLE_ROW_MEASURE.MEAS is '  ';
comment on column UT_TABLE_ROW_MSG.PRIMARY_KEY is '  ';
comment on column UT_TABLE_ROW_MSG.MSG is '  ';
comment on column UT_TABLE_ROW_MSG.UT_TABLE_RULE_NBR is '  ';
comment on column UT_TABLE_ROW_MSG.UT_RULE_GRP_RUN_NBR is '  ';
comment on column UT_TABLE_ROW_MSG.UT_USER_NBR_ALLOW is '  ';
comment on column UT_TABLE_ROW_MSG.DISP_CD_ENUM is '  ';
comment on column UT_TABLE_ROW_MSG.UT_USER_NBR_DISP is '  ';
comment on column UT_TABLE_RULE.UT_TABLE_RULE_NBR is 'Surrogate primary key';
comment on column UT_TABLE_RULE.MSG_ID is '  ';
comment on column UT_TABLE_RULE.SQL_TEXT is '  ';
comment on column UT_TABLE_RULE.MSG_DESCR is '  ';
comment on column UT_TABLE_RULE.RULE_TYPE is '  ';
comment on column UT_TABLE_RULE.DATA_SRC_NM_SRC is '  ';
comment on column UT_TABLE_RULE.DATA_SRC_NM_DEST is '  ';
comment on column UT_TABLE_RULE.UT_QUERY_NBR is '  ';
comment on column UT_TABLE_RULE.SCHEMA is '  ';
comment on column UT_TABLE_RULE.TABLE_NAME is '  ';
comment on column UT_TABLE_RULE.MAX_QUERY_SEC is '  ';
comment on column UT_TABLE_RULE.SEVERE_RULE_FLG is '  ';
comment on column UT_TABLE_RULE.SHORT_DESCR is '  ';
comment on column UT_TABLE_RULE.EXCEPTION_TYPE_CD is '  ';
comment on column UT_TABLE_RULE.UT_TABLE_RULE_NBR_EXCLUDE is '  ';
comment on column UT_TABLE_RULE.DISP_CD_ENUM is '  ';
comment on column UT_TABLE_RULE.LOG_LVL is '  ';
comment on column UT_TABLE_RULE.UT_AREA_RESP_NBR is '  ';
comment on column UT_TABLE_RULE_HIST.UT_TABLE_RULE_HIST_NBR is '  ';
comment on column UT_TABLE_RULE_HIST.UT_TABLE_RULE_NBR is '  ';
comment on column UT_TABLE_RULE_HIST.MSG_ID is '  ';
comment on column UT_TABLE_RULE_HIST.SQL_TEXT is '  ';
comment on column UT_TABLE_RULE_HIST.MSG_DESCR is '  ';
comment on column UT_TABLE_RULE_HIST.RULE_TYPE is '  ';
comment on column UT_TABLE_RULE_HIST.DATA_SRC_NM_SRC is '  ';
comment on column UT_TABLE_RULE_HIST.DATA_SRC_NM_DEST is '  ';
comment on column UT_TABLE_RULE_HIST.UT_QUERY_NBR is '  ';
comment on column UT_TABLE_RULE_HIST.SCHEMA is '  ';
comment on column UT_TABLE_RULE_HIST.TABLE_NAME is '  ';
comment on column UT_TABLE_RULE_HIST.MAX_QUERY_SEC is '  ';
comment on column UT_TABLE_RULE_HIST.SEVERE_RULE_FLG is '  ';
comment on column UT_TABLE_RULE_HIST.SHORT_DESCR is '  ';
comment on column UT_TABLE_RULE_HIST.EXCEPTION_TYPE_CD is '  ';
comment on column UT_TABLE_RULE_HIST.UT_TABLE_RULE_NBR_EXCLUDE is '  ';
comment on column UT_TABLE_RULE_HIST.DISP_CD_ENUM is '  ';
comment on column UT_TABLE_RULE_HIST.LOG_LVL is '  ';
comment on column UT_TABLE_RULE_HIST.UT_AREA_RESP_NBR is '  ';
comment on column UT_TABLE_RULE_PARM.UT_TABLE_RULE_NBR is '  ';
comment on column UT_TABLE_RULE_PARM.PARM_NM is '  ';
comment on column UT_TABLE_RULE_PARM.PARM_DATA_TYPE is '  ';
comment on column UT_TABLE_RULE_RPT_SUM.UT_TABLE_RULE_RPT_SUM_NBR is '  ';
comment on column UT_TABLE_RULE_RPT_SUM.UT_TABLE_RULE_NBR is '  ';
comment on column UT_TABLE_RULE_RPT_SUM.RPT_DESCR is '  ';
comment on column UT_TABLE_RULE_RPT_SUM.APEX_PAGE_NBR is '  ';

164 rows selected.

