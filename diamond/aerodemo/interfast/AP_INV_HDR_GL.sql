--------------------------------------------------------
--  DDL for Table AP_INV_HDR_GL
--------------------------------------------------------

  CREATE TABLE "AP_INV_HDR_GL" 
   (	"AP_INV_HDR_NBR" NUMBER(9,0), 
	"GL_ACCT_CD" VARCHAR2(8), 
	"GL_TRANS_AMT" NUMBER(17,6), 
	"DISTRIB_TYPE" NUMBER(3,0), 
	"CURR_CD" VARCHAR2(3), 
	"GL_TRANS_DESCR" VARCHAR2(255)
   ) ;
