--------------------------------------------------------
--  DDL for Table AR_PAYMENT_RCPT
--------------------------------------------------------

  CREATE TABLE "AR_PAYMENT_RCPT" 
   (	"AR_PAYMENT_RCPT_NBR" NUMBER(9,0), 
	"AR_PAYMENT_RCPT_TM" DATE, 
	"ORG_NBR_CUST" NUMBER(9,0), 
	"PAYMENT_AMT" NUMBER(15,2), 
	"CURR_CD" VARCHAR2(3), 
	"PAYMENT_MODE_ID" VARCHAR2(4), 
	"PAYMENT_DOC_NBR" VARCHAR2(20), 
	"EXP_MM" VARCHAR2(2), 
	"EXP_YY" VARCHAR2(4), 
	"MEMO" VARCHAR2(255), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_TM" DATE
   ) ;

   COMMENT ON COLUMN "AR_PAYMENT_RCPT"."PAYMENT_MODE_ID" IS 'ACH-ACH, CASH-Cash,
 CC-Credit Card, CHK-Check, MO-Money Order, WIRE-Wire Transfer ';
