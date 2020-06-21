--------------------------------------------------------
--  DDL for Table IC_TRANS_GL_ACCT_20031015
--------------------------------------------------------

  CREATE TABLE "IC_TRANS_GL_ACCT_20031015" 
   (	"IC_TRANS_GL_NBR" NUMBER(9,0), 
	"GL_ACCT_CD" VARCHAR2(50), 
	"GL_TRANS_AMT" NUMBER(17,6), 
	"DISTRIB_TYPE" NUMBER(3,0), 
	"CURR_CD" VARCHAR2(3), 
	"GL_TRANS_DESCR" VARCHAR2(255), 
	"IC_TRANS_HIST_NBR" NUMBER(9,0), 
	"USER_CHG_ACCT_CD_FLG" VARCHAR2(1), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) ;
