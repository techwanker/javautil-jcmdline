--------------------------------------------------------
--  DDL for Table DN_AR_DTL
--------------------------------------------------------

  CREATE TABLE "DN_AR_DTL" 
   (	"DN_AR_CD" VARCHAR2(20), 
	"DN_AR_DTL_NBR" NUMBER(9,0), 
	"DN_AR_LINE_NBR" NUMBER(3,0), 
	"DN_REASON_CD" VARCHAR2(8), 
	"DN_AR_LINE_DESCR" VARCHAR2(1024), 
	"DN_AR_AMT" NUMBER(17,6), 
	"DN_AR_AMT_DENOM" NUMBER(17,6), 
	"GL_TAX_GRP_NBR" NUMBER(9,0), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) ;
