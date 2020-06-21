--------------------------------------------------------
--  DDL for Table EDI_BIN_SCAN_BATCH
--------------------------------------------------------

  CREATE TABLE "EDI_BIN_SCAN_BATCH" 
   (	"EDI_BIN_SCAN_BATCH_NBR" NUMBER(9,0), 
	"BATCH_LOAD_DT" DATE, 
	"BATCH_STAT_ID" VARCHAR2(1), 
	"BATCH_PROCESS_DT" DATE, 
	"UT_USER_NBR_PROCESS" NUMBER(9,0), 
	"BIN_SCAN_FILE_PATH" VARCHAR2(512), 
	"BIN_SCAN_FILE_ARCHIVE_PATH" VARCHAR2(512)
   ) ;

   COMMENT ON COLUMN "EDI_BIN_SCAN_BATCH"."BATCH_STAT_ID" IS 'O-Open, C-CLosed, E-Errors';
