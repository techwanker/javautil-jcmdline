--------------------------------------------------------
--  DDL for Table AR_INV_DTL_CHARGE
--------------------------------------------------------

  CREATE TABLE "AR_INV_DTL_CHARGE" 
   (	"AR_INV_DTL_CHARGE_NBR" NUMBER(9,0), 
	"AR_INV_DTL_NBR" NUMBER(9,0), 
	"CHARGE_CD" VARCHAR2(10), 
	"CHARGE_AMT" NUMBER(9,2), 
	"CHARGE_AMT_DENOM" NUMBER(10,2), 
	"TAXABLE_FLG" VARCHAR2(1) DEFAULT 'N'
   ) ;
