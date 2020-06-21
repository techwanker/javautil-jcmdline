--------------------------------------------------------
--  DDL for Table IC_MULTIPLE_CERT
--------------------------------------------------------

  CREATE TABLE "IC_MULTIPLE_CERT" 
   (	"LOT_NBR" NUMBER(9,0), 
	"ITEM_NBR" NUMBER(9,0), 
	"REV_LVL" VARCHAR2(5), 
	"INSPECTED_FLG" VARCHAR2(1) DEFAULT 'N', 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) ;
