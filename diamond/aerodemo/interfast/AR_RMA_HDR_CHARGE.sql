--------------------------------------------------------
--  DDL for Table AR_RMA_HDR_CHARGE
--------------------------------------------------------

  CREATE TABLE "AR_RMA_HDR_CHARGE" 
   (	"RMA_CD" VARCHAR2(20), 
	"CHARGE_CD" VARCHAR2(8), 
	"CHARGE_AMT" NUMBER(10,2), 
	"CHARGE_AMT_DENOM" NUMBER(10,2), 
	"TAXABLE_FLG" VARCHAR2(1), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) ;
