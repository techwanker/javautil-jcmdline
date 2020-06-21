--------------------------------------------------------
--  DDL for Table UNBRAKO_TRANS_BATCH
--------------------------------------------------------

  CREATE TABLE "UNBRAKO_TRANS_BATCH" 
   (	"TRANS_BATCH_NBR" NUMBER, 
	"TRANS_BATCH_DT" DATE, 
	"TRANS_HDR_NBR" NUMBER, 
	"FACILITY_SRC" VARCHAR2(16), 
	"FACILITY_DEST" VARCHAR2(16), 
	"LOT_NBR" NUMBER, 
	"ITEM_CD" VARCHAR2(50), 
	"BIN_CD" VARCHAR2(16), 
	"MFR_LOT_CD" VARCHAR2(20), 
	"BOX_CD" VARCHAR2(20), 
	"PICK_QTY" NUMBER, 
	"UT_USER_NBR" NUMBER, 
	"LAST_MOD_DT" DATE
   ) ;
