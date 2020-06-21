--------------------------------------------------------
--  DDL for Table WO_MFG_CHARGE
--------------------------------------------------------

  CREATE TABLE "WO_MFG_CHARGE" 
   (	"WO_MFG_CHARGE_CD" VARCHAR2(8), 
	"WO_MFG_CHARGE_DESCR" VARCHAR2(60), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"WO_MFG_CHARGE_CD_STAT_ID" VARCHAR2(1) DEFAULT 'A'
   ) ;
