--------------------------------------------------------
--  DDL for Table QA_ATTR_VAL_STATE
--------------------------------------------------------

  CREATE TABLE "QA_ATTR_VAL_STATE" 
   (	"QA_PROJ_CD" VARCHAR2(16), 
	"IC_ATTR_NBR" NUMBER(9,0), 
	"ATTR_VAL" VARCHAR2(20), 
	"QA_TST_STE_CD" VARCHAR2(16), 
	"PLAN_NBR" NUMBER(9,0), 
	"PLAN_LINE_NBR" NUMBER(3,0), 
	"RCPT_CNT" NUMBER(5,0), 
	"CYCLE_CNT" NUMBER(5,0), 
	"CYCLE_START_DT" DATE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE( INITIAL 65536
  FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;