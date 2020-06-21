--------------------------------------------------------
--  DDL for Table OE_CONTRACT_PRICE
--------------------------------------------------------

  CREATE TABLE "OE_CONTRACT_PRICE" 
   (	"ORG_NBR_CUST" NUMBER(9,0), 
	"CONTRACT_CD" VARCHAR2(8), 
	"ITEM_CD_CUST" VARCHAR2(50), 
	"PRICE_TYPE_ID" VARCHAR2(2), 
	"UNIT_PRICE" NUMBER(17,6), 
	"MARKUP_PCT" NUMBER(5,2), 
	"EFF_DT_BEG" DATE, 
	"EFF_DT_END" DATE, 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"OE_CONTRACT_PRICE_NBR" NUMBER(9,0)
   ) ;
