--------------------------------------------------------
--  DDL for Table UNBRAKO_ORD_HDR_CHARGE
--------------------------------------------------------

  CREATE TABLE "UNBRAKO_ORD_HDR_CHARGE" 
   (	"ORD_CHARGE_NBR" NUMBER, 
	"ORD_NBR" NUMBER, 
	"CHARGE_CD" VARCHAR2(10), 
	"UT_USER_NBR" NUMBER, 
	"LAST_MOD_DT" DATE, 
	"RECUR_FLG" VARCHAR2(1) DEFAULT 'N', 
	"AR_INV_HDR_CHARGE_NBR" NUMBER, 
	"TAXABLE_FLG" VARCHAR2(1) DEFAULT 'N', 
	"CHARGE_AMT_DENOM" NUMBER
   ) ;
