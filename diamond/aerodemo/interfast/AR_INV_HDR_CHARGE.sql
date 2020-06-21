--------------------------------------------------------
--  DDL for Table AR_INV_HDR_CHARGE
--------------------------------------------------------

  CREATE TABLE "AR_INV_HDR_CHARGE" 
   (	"AR_INV_HDR_CHARGE_NBR" NUMBER(9,0), 
	"INV_CD" VARCHAR2(20), 
	"CHARGE_CD" VARCHAR2(10), 
	"CHARGE_AMT" NUMBER(9,2), 
	"CHARGE_AMT_DENOM" NUMBER(10,2), 
	"TAXABLE_FLG" VARCHAR2(1) DEFAULT 'N'
   ) ;
