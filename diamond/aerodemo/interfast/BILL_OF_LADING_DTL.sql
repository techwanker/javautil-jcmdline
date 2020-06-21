--------------------------------------------------------
--  DDL for Table BILL_OF_LADING_DTL
--------------------------------------------------------

  CREATE TABLE "BILL_OF_LADING_DTL" 
   (	"BILL_OF_LADING_NBR" NUMBER(9,0), 
	"CONTAINER_TYPE_ID" VARCHAR2(1), 
	"CONTAINER_CNT" NUMBER(5,0), 
	"CONTAINER_WGHT" NUMBER(10,2), 
	"CONTAINER_WGHT_UM" VARCHAR2(3), 
	"HARMONIZED_CD" VARCHAR2(20), 
	"FRGHT_RATE_CD" VARCHAR2(5), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_TM" DATE
   ) ;

   COMMENT ON COLUMN "BILL_OF_LADING_DTL"."CONTAINER_TYPE_ID" IS 'C-Crate, B-Box, P-Pallet, O-Container';
