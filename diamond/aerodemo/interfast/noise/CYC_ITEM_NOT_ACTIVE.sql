--------------------------------------------------------
--  DDL for Table CYC_ITEM_NOT_ACTIVE
--------------------------------------------------------

  CREATE TABLE "CYC_ITEM_NOT_ACTIVE" 
   (	"IC_ITEM_LOC_NBR" NUMBER(9,0), 
	"BOX_CD" VARCHAR2(20), 
	"BOX_QTY" NUMBER(12,5), 
	"BOX_STAT_ID" VARCHAR2(3), 
	"MFR_SERIAL_CD" VARCHAR2(20), 
	"SERIAL_CD" VARCHAR2(20), 
	"LOC_CONFIRM_RQST_DT" DATE, 
	"LOC_CONFIRM_ACT_DT" DATE, 
	"UT_USER_NBR_LOC_CONFIRM" NUMBER(9,0), 
	"QTY_CONFIRM_RQST_DT" DATE, 
	"QTY_CONFIRM_ACT_DT" DATE, 
	"UT_USER_NBR_QTY_CONFIRM" NUMBER(9,0), 
	"QTY_CONFIRM_RQST_PRTY" NUMBER(1,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 4194304 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;