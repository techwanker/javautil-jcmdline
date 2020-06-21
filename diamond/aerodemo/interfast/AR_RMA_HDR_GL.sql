--------------------------------------------------------
--  DDL for Table AR_RMA_HDR_GL
--------------------------------------------------------

  CREATE TABLE "AR_RMA_HDR_GL" 
   (	"RMA_CD" VARCHAR2(20), 
	"GL_ACCT_CD" VARCHAR2(50), 
	"GL_TRANS_AMT" NUMBER(17,6), 
	"DISTRIB_TYPE" NUMBER(3,0), 
	"CURR_CD" VARCHAR2(3), 
	"GL_TRANS_DESCR" VARCHAR2(255)
   ) ;
