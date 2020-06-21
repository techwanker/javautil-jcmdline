--------------------------------------------------------
--  DDL for Table GL_TAX_GRP_DTL
--------------------------------------------------------

  CREATE TABLE "GL_TAX_GRP_DTL" 
   (	"GL_TAX_GRP_DTL_NBR" NUMBER(9,0), 
	"GL_TAX_GRP_NBR" NUMBER(9,0), 
	"TAX_CD" VARCHAR2(16), 
	"CALC_SEQ_NBR" NUMBER(3,0), 
	"GL_ACCT_CD" VARCHAR2(50), 
	"TAX_PCT" NUMBER(5,2), 
	"TAX_ON_TAX_FLG" VARCHAR2(1), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) ;
