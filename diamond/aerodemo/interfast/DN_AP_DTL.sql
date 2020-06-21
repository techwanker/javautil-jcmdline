--------------------------------------------------------
--  DDL for Table DN_AP_DTL
--------------------------------------------------------

  CREATE TABLE "DN_AP_DTL" 
   (	"DN_AP_CD" VARCHAR2(20), 
	"DN_AP_DTL_NBR" NUMBER(9,0), 
	"DN_AP_LINE_NBR" NUMBER(3,0), 
	"DN_REASON_CD" VARCHAR2(8), 
	"DN_AP_LINE_DESCR" VARCHAR2(1024), 
	"DN_AP_AMT" NUMBER(17,6), 
	"DN_AP_AMT_DENOM" NUMBER(17,6), 
	"GL_TAX_GRP_NBR" NUMBER(9,0), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) ;
