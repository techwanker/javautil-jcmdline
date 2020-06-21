--------------------------------------------------------
--  DDL for Table UNBRAKO_ORD_DTL
--------------------------------------------------------

  CREATE TABLE "UNBRAKO_ORD_DTL" 
   (	"ORD_NBR" NUMBER, 
	"ORD_DTL_NBR" NUMBER, 
	"ITEM_CD_ORD" VARCHAR2(50), 
	"QTY_ORD_STK_UM" NUMBER, 
	"UNIT_PRICE_DENOM_STK_UM" NUMBER, 
	"QTY_SHIP_STK_UM" NUMBER, 
	"RQST_DT" DATE, 
	"UT_USER_NBR" NUMBER, 
	"LAST_MOD_DT" DATE, 
	"LINE_STAT_ID" VARCHAR2(1) DEFAULT 'O', 
	"ITEM_CD_CUST" VARCHAR2(50)
   ) ;
