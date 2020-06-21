--------------------------------------------------------
--  DDL for Table IC_BOM
--------------------------------------------------------

  CREATE TABLE "IC_BOM" 
   (	"ITEM_NBR" NUMBER(9,0), 
	"ITEM_NBR_PARENT" NUMBER(9,0), 
	"CHILD_QTY" NUMBER(13,6), 
	"CHILD_UM" VARCHAR2(3), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"MIX_MFR_LOT_FLG" VARCHAR2(1), 
	"PRINT_BAG_LBL_FLG" VARCHAR2(1), 
	"REV_LVL" VARCHAR2(5), 
	"ORG_NBR_MFR_RQST" NUMBER(9,0), 
	"MANDATORY_ITEM_FLG" VARCHAR2(1) DEFAULT 'N'
   ) ;
