--------------------------------------------------------
--  DDL for Table QA_TST_RSLT
--------------------------------------------------------

  CREATE TABLE "QA_TST_RSLT" 
   (	"QA_TST_RSLT_NBR" NUMBER(9,0), 
	"QA_PROJ_CD" VARCHAR2(16), 
	"QA_TST_CD" VARCHAR2(16), 
	"ORG_NBR_MFR" NUMBER(9,0), 
	"ORG_NBR_VND" NUMBER(9,0), 
	"ITEM_NBR" NUMBER(9,0), 
	"TST_RSLT" VARCHAR2(1), 
	"QTY_ON_HAND" NUMBER(15,5), 
	"SAMPLE_SIZE" NUMBER(5,0), 
	"SAMPLE_SIZE_UM" VARCHAR2(3), 
	"MFR_LOT_CD" VARCHAR2(20), 
	"ORG_NBR_CUST" NUMBER(9,0), 
	"LOT_NBR" NUMBER(9,0), 
	"RECV_INDICATOR" VARCHAR2(1), 
	"IC_ATTR_NBR" NUMBER(9,0), 
	"ATTR_VAL" VARCHAR2(20), 
	"TEST_LAB" VARCHAR2(5), 
	"SENT_TO_TST_FACILITY_DT" DATE, 
	"RECV_FROM_TST_FACILITY_DT" DATE, 
	"TST_INVOICED_FLG" VARCHAR2(1), 
	"TEST_COST" NUMBER(7,2), 
	"QA_TST_STE_CD" VARCHAR2(16), 
	"PLAN_NBR" NUMBER(9,0), 
	"PLAN_LINE_NBR" NUMBER(3,0), 
	"RCPT_CNT" NUMBER(5,0), 
	"CYCLE_CNT" NUMBER(5,0), 
	"SKIP_FLG" VARCHAR2(1), 
	"TST_CRE_DT" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 67108864 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
