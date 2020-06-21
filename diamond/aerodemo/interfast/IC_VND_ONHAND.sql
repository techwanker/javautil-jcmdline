--------------------------------------------------------
--  DDL for Table IC_VND_ONHAND
--------------------------------------------------------

  CREATE TABLE "IC_VND_ONHAND" 
   (	"IC_VND_ONHAND_NBR" NUMBER(9,0), 
	"ITEM_NBR" NUMBER(9,0), 
	"ITEM_CD_VND" VARCHAR2(50), 
	"ORG_NBR_VND" NUMBER(9,0), 
	"LOAD_DT" DATE, 
	"QTY_ON_HAND" NUMBER(13,5), 
	"STK_UM" VARCHAR2(3), 
	"UNIT_PRICE" NUMBER(17,6)
   ) ;
