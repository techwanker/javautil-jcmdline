--------------------------------------------------------
--  DDL for Table CM_AP_DTL_GL
--------------------------------------------------------

  CREATE TABLE "CM_AP_DTL_GL" 
   (	"CM_AP_DTL_NBR" NUMBER(9,0), 
	"GL_ACCT_CD" VARCHAR2(50), 
	"GL_TRANS_AMT" NUMBER(17,6), 
	"CURR_CD" VARCHAR2(3), 
	"DISTRIB_TYPE" NUMBER(3,0), 
	"GL_TRANS_DESCR" VARCHAR2(255)
   ) ;
