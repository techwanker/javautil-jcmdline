--------------------------------------------------------
--  DDL for Table AR_PAYMENT_RCPT_APPLY
--------------------------------------------------------

  CREATE TABLE "AR_PAYMENT_RCPT_APPLY" 
   (	"AR_PAYMENT_RCPT_APPLY_NBR" NUMBER(9,0), 
	"AR_PAYMENT_RCPT_NBR" NUMBER(9,0), 
	"INV_CD" VARCHAR2(20), 
	"GL_ACCT_NBR" NUMBER(9,0), 
	"APPLY_AMT" NUMBER(15,2), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_TM" DATE
   ) ;
