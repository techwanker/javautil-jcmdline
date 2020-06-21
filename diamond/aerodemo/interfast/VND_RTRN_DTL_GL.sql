--------------------------------------------------------
--  DDL for Table VND_RTRN_DTL_GL
--------------------------------------------------------

  CREATE TABLE "VND_RTRN_DTL_GL" 
   (	"VND_RTRN_DTL_NBR" NUMBER(9,0), 
	"GL_ACCT_CD" VARCHAR2(50), 
	"DISTRIB_TYPE" NUMBER(3,0), 
	"GL_TRANS_AMT" NUMBER(17,6), 
	"CURR_CD" VARCHAR2(3), 
	"GL_TRANS_DESCR" VARCHAR2(255), 
	"USER_CHG_ACCT_CD_FLG" VARCHAR2(1) DEFAULT 'N', 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) ;
