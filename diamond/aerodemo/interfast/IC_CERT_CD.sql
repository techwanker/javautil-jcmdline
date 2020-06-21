--------------------------------------------------------
--  DDL for Table IC_CERT_CD
--------------------------------------------------------

  CREATE TABLE "IC_CERT_CD" 
   (	"CERT_CD" VARCHAR2(8), 
	"CERT_CD_DESCR" VARCHAR2(60), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"DOC_FLG" VARCHAR2(1), 
	"CERT_VALUE" NUMBER(3,0) DEFAULT 0, 
	"CERT_SRC_ID" VARCHAR2(1), 
	"STAT_ID" VARCHAR2(1)
   ) ;
