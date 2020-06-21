--------------------------------------------------------
--  DDL for Table PO_MISC_CHG
--------------------------------------------------------

  CREATE TABLE "PO_MISC_CHG" 
   (	"CHARGE_CD" VARCHAR2(10), 
	"CHARGE_DESCR" VARCHAR2(60), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"CHARGE_CD_STAT_ID" VARCHAR2(1) DEFAULT 'A'
   ) ;
