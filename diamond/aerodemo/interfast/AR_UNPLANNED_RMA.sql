--------------------------------------------------------
--  DDL for Table AR_UNPLANNED_RMA
--------------------------------------------------------

  CREATE TABLE "AR_UNPLANNED_RMA" 
   (	"AR_UNPLANNED_RMA_NBR" NUMBER(9,0), 
	"RCPT_DT" DATE, 
	"RMA_CD" VARCHAR2(20), 
	"RMA_LINE_NBR" NUMBER(3,0), 
	"ITEM_NBR" NUMBER(9,0), 
	"QTY_RECEIVED" NUMBER(13,5), 
	"RMA_UM" VARCHAR2(3), 
	"BIN_NBR_STAGE" NUMBER(9,0), 
	"RMA_COMMENTS" VARCHAR2(255), 
	"RMA_STAT_ID" VARCHAR2(1), 
	"PROCESS_DT" DATE, 
	"UT_USER_NBR_RECV" NUMBER(9,0), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) ;
