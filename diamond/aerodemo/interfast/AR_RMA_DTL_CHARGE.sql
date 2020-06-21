--------------------------------------------------------
--  DDL for Table AR_RMA_DTL_CHARGE
--------------------------------------------------------

  CREATE TABLE "AR_RMA_DTL_CHARGE" 
   (	"AR_RMA_DTL_NBR" NUMBER(9,0), 
	"CHARGE_CD" VARCHAR2(8), 
	"CHARGE_AMT" NUMBER(10,2), 
	"CHARGE_AMT_DENOM" NUMBER(10,2), 
	"TAXABLE_FLG" VARCHAR2(1) DEFAULT 'N', 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) ;
