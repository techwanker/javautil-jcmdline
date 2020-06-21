--------------------------------------------------------
--  DDL for Table CM_REASON_CODES
--------------------------------------------------------

  CREATE TABLE "CM_REASON_CODES" 
   (	"CM_REASON_CD" VARCHAR2(8), 
	"CM_REASON_DESCR" VARCHAR2(60), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"CM_REASON_CD_STAT_ID" VARCHAR2(1) DEFAULT 'A'
   ) ;
