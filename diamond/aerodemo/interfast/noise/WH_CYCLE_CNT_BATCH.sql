--------------------------------------------------------
--  DDL for Table WH_CYCLE_CNT_BATCH
--------------------------------------------------------

  CREATE TABLE "WH_CYCLE_CNT_BATCH" 
   (	"WH_CYCLE_CNT_BATCH_NBR" NUMBER(9,0), 
	"CYCLE_CNT_RULE_CD" VARCHAR2(16), 
	"CYCLE_CNT_BATCH_CREATE_TM" DATE, 
	"UT_USER_NBR_ASSIGN" NUMBER(9,0), 
	"CYCLE_CNT_BATCH_STAT_ID" VARCHAR2(1), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MODT_DT" DATE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE( INITIAL 65536
  FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;

   COMMENT ON COLUMN "WH_CYCLE_CNT_BATCH"."CYCLE_CNT_BATCH_STAT_ID" IS 'Q - Queued, P - In Progess, C - Completed, X - Cancelled';
