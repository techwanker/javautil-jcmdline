--------------------------------------------------------
--  DDL for Table DN_REASON_CODES
--------------------------------------------------------

  CREATE TABLE "DN_REASON_CODES" 
   (	"DN_REASON_CD" VARCHAR2(8), 
	"DN_REASON_DESCR" VARCHAR2(60), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"DN_REASON_CD_STAT_ID" VARCHAR2(1) DEFAULT 'A'
   ) ;
