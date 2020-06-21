--------------------------------------------------------
--  DDL for Table OE_CONTRACT_ITEM_LOG
--------------------------------------------------------

  CREATE TABLE "OE_CONTRACT_ITEM_LOG" 
   (	"ORG_NBR_CUST" NUMBER(9,0), 
	"CONTRACT_CD" VARCHAR2(8), 
	"ITEM_CD_CUST" VARCHAR2(50), 
	"ITEM_NBR" NUMBER(9,0), 
	"ITEM_NBR_SUPERSEDE" NUMBER(9,0), 
	"EFF_DT_BEG" DATE, 
	"EFF_DT_END" DATE, 
	"TOT_CONTRACT_QTY" NUMBER(9,0), 
	"UT_USER_NBR_MOD" NUMBER(9,0), 
	"MOD_DT" DATE
   ) ;
