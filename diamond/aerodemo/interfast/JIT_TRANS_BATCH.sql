--------------------------------------------------------
--  DDL for Table JIT_TRANS_BATCH
--------------------------------------------------------

  CREATE TABLE "JIT_TRANS_BATCH" 
   (	"JIT_TRANS_BATCH_NBR" NUMBER(9,0), 
	"ORG_NBR_CUST" NUMBER(9,0), 
	"BATCH_LOAD_DT" DATE, 
	"BATCH_STAT_ID" VARCHAR2(1), 
	"BATCH_PROCESS_DT" DATE, 
	"UT_USER_NBR_PROCESS" NUMBER(9,0)
   ) ;

   COMMENT ON COLUMN "JIT_TRANS_BATCH"."BATCH_STAT_ID" IS 'O - Open, E - Errors,
			C - Closed';
