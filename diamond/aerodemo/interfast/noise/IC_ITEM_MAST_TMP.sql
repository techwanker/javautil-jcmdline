--------------------------------------------------------
--  DDL for Table IC_ITEM_MAST_TMP
--------------------------------------------------------

  CREATE TABLE "IC_ITEM_MAST_TMP" 
   (	"PICK_SCAN_ID" CHAR(1), 
	"ITEM_CD" VARCHAR2(20), 
	"ITEM_DESCR" VARCHAR2(25), 
	"STAT_ID" VARCHAR2(1), 
	"STK_UM" VARCHAR2(2), 
	"SELL_UM" VARCHAR2(2), 
	"STD_COST" NUMBER, 
	"QTY_PER_BOX" NUMBER, 
	"BOX_PER_CTN" NUMBER, 
	"SLS_QTY_MIN" NUMBER, 
	"SLS_QTY_INCR" NUMBER, 
	"REPLEN_QTY_MIN" NUMBER, 
	"REPLEN_QTY_INCR" NUMBER, 
	"IC_CATEGORY_NBR" NUMBER(9,0), 
	"NON_STK_FLG" VARCHAR2(1), 
	"SER_NBR_REQR_FLG" CHAR(1), 
	"MFR_SER_NBR_REQR_FLG" CHAR(1), 
	"INSPECT_REQR_FLG" CHAR(1), 
	"MFR_LOT_CTRL_FLG" CHAR(1), 
	"KIT_FLG" CHAR(1), 
	"PRICE_CHG_FLG" CHAR(1), 
	"UT_USER_NBR" NUMBER, 
	"LAST_MOD_DT" VARCHAR2(11), 
	"SELL_FLG" CHAR(1), 
	"HARMONIZED_CD" CHAR(1), 
	"PLAN_BUCKET_SZ" NUMBER, 
	"CURR_CD" CHAR(3), 
	"REQR_MFR_FLG" CHAR(1), 
	"INTRO_DT" VARCHAR2(11), 
	"SPLIT_AT_BIN_FLG" CHAR(1), 
	"FIFO_DT_ID" CHAR(1), 
	"REPLEN_TYPE_ID" CHAR(1)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 16777216 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
