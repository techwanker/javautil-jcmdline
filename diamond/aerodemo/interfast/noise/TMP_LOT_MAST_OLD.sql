--------------------------------------------------------
--  DDL for Table TMP_LOT_MAST_OLD
--------------------------------------------------------

  CREATE GLOBAL TEMPORARY TABLE "TMP_LOT_MAST_OLD" 
   (	"LOT_NBR" NUMBER(9,0), 
	"ITEM_NBR" NUMBER(9,0), 
	"REV_LVL" VARCHAR2(5), 
	"RCPT_DT" DATE, 
	"EXPIRE_DT" DATE, 
	"CNTRY_CD_ORIGIN" VARCHAR2(3), 
	"MFR_DATE" DATE, 
	"LOT_COST" NUMBER, 
	"LOT_COST_UM" VARCHAR2(3), 
	"ORG_NBR_VND" NUMBER(9,0), 
	"ORG_NBR_MFR" NUMBER(9,0)
   ) ON COMMIT DELETE ROWS ;
