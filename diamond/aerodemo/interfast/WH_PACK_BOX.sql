--------------------------------------------------------
--  DDL for Table WH_PACK_BOX
--------------------------------------------------------

  CREATE TABLE "WH_PACK_BOX" 
   (	"BIN_NBR_PACK_BOX" NUMBER(9,0), 
	"BIN_NBR_PLACED_IN" NUMBER(9,0), 
	"PLACED_TM" DATE, 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"WAYBILL_CD" VARCHAR2(20), 
	"SHIP_FLG" VARCHAR2(1) DEFAULT 'N', 
	"WGHT_LBS" NUMBER(8,2), 
	"FRGHT_CHG" NUMBER(10,2), 
	"PICKED_UP_FLG" VARCHAR2(1) DEFAULT 'N', 
	"CTN_CNT" NUMBER(3,0)
   ) ;
