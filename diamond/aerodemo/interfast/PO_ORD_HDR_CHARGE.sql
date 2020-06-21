--------------------------------------------------------
--  DDL for Table PO_ORD_HDR_CHARGE
--------------------------------------------------------

  CREATE TABLE "PO_ORD_HDR_CHARGE" 
   (	"PO_ORD_HDR_NBR" NUMBER(9,0), 
	"CHARGE_CD" VARCHAR2(10), 
	"CHARGE_AMT" NUMBER(10,2), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"CHARGE_AMT_DENOM" NUMBER(17,5), 
	"RECUR_FLG" VARCHAR2(1), 
	"TAXABLE_FLG" VARCHAR2(1) DEFAULT 'N', 
	"AP_INV_HDR_CHARGE_NBR" NUMBER(9,0)
   ) ;
