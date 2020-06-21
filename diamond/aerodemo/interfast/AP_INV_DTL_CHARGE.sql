--------------------------------------------------------
--  DDL for Table AP_INV_DTL_CHARGE
--------------------------------------------------------

  CREATE TABLE "AP_INV_DTL_CHARGE" 
   (	"AP_INV_DTL_CHARGE_NBR" NUMBER(9,0), 
	"AP_INV_DTL_NBR" NUMBER(9,0), 
	"CHARGE_CD" VARCHAR2(10), 
	"CHARGE_AMT" NUMBER(9,2), 
	"CHARGE_AMT_DENOM" NUMBER(9,2), 
	"TAXABLE_FLG" VARCHAR2(1) DEFAULT 'N'
   ) ;
