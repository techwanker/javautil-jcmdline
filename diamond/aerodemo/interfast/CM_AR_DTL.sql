--------------------------------------------------------
--  DDL for Table CM_AR_DTL
--------------------------------------------------------

  CREATE TABLE "CM_AR_DTL" 
   (	"CM_AR_CD" VARCHAR2(20), 
	"CM_AR_DTL_NBR" NUMBER(9,0), 
	"CM_AR_LINE_NBR" NUMBER(3,0), 
	"CM_REASON_CD" VARCHAR2(8), 
	"CM_AR_LINE_DESCR" VARCHAR2(1024), 
	"CM_AR_AMT" NUMBER(17,6), 
	"CM_AR_AMT_DENOM" NUMBER(17,6), 
	"GL_TAX_GRP_NBR" NUMBER(9,0), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) ;
