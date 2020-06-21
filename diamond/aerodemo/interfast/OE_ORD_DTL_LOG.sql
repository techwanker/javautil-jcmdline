--------------------------------------------------------
--  DDL for Table OE_ORD_DTL_LOG
--------------------------------------------------------

  CREATE TABLE "OE_ORD_DTL_LOG" 
   (	"OE_ORD_DTL_NBR" NUMBER(9,0), 
	"OE_ORD_HDR_NBR" NUMBER(9,0), 
	"ORG_NBR_CUST" NUMBER(9,0), 
	"LINE_NBR" NUMBER(3,0), 
	"CUST_LINE_CD" VARCHAR2(5), 
	"ITEM_NBR_RQST" NUMBER(9,0), 
	"ITEM_NBR_ORD" NUMBER(9,0), 
	"QTY_ORD" NUMBER(12,5), 
	"QTY_ORD_STK_UM" NUMBER(12,5), 
	"SELL_UM" VARCHAR2(3), 
	"RQST_DT" DATE, 
	"SHIP_TO_ADDR_NBR" NUMBER(9,0), 
	"PROM_DT_ORIG" DATE, 
	"PROM_DT_CURR" DATE, 
	"UNIT_PRICE_SELL_UM" NUMBER(17,6), 
	"UNIT_PRICE_DENOM_SELL_UM" NUMBER(17,6), 
	"UNIT_PRICE_STK_UM" NUMBER(17,6), 
	"UNIT_PRICE_DENOM_STK_UM" NUMBER(17,6), 
	"TIE_CD" VARCHAR2(1), 
	"LINE_STAT_ID" VARCHAR2(1), 
	"ITEM_CD_CUST" VARCHAR2(50), 
	"APS_SRC_RULE_SET_NBR" NUMBER(9,0), 
	"ORG_NBR_MFR_RQST" NUMBER(9,0), 
	"LOT_NOT_EXPIRE_BEFORE_DT" DATE, 
	"LOT_MANUFACTURE_AFTER_DT" DATE, 
	"CNTRY_CD_ORIGIN" VARCHAR2(3), 
	"REV_LVL" VARCHAR2(5), 
	"SHIP_VIA_CD" VARCHAR2(8), 
	"CONTRACT_CD" VARCHAR2(8), 
	"CUST_BIN_CD" VARCHAR2(40), 
	"PKG_QTY" NUMBER(7,0), 
	"PICK_PRTY_CUST" NUMBER(3,0), 
	"PICK_PRTY_RQST" NUMBER(2,0), 
	"PICK_PRTY_PAST_DUE_MULT" NUMBER(2,0), 
	"QTY_SHIP" NUMBER(12,5), 
	"QTY_SHIP_STK_UM" NUMBER(13,5), 
	"QTY_ALLOC" NUMBER(13,5), 
	"QTY_ALLOC_STK_UM" NUMBER(13,5), 
	"PART_MISMATCH_REASON_CD" VARCHAR2(8), 
	"CUST_REF" VARCHAR2(20), 
	"SHIP_FROM_FACILITY" VARCHAR2(16), 
	"SHIP_CMPLT_FLG" VARCHAR2(1), 
	"HOT_FLG" VARCHAR2(1), 
	"SHIP_LINE_PCT" NUMBER(3,0), 
	"CANCEL_CD" VARCHAR2(8), 
	"CANCEL_DT" DATE, 
	"UT_USER_NBR_CANCEL" NUMBER(9,0), 
	"CLOSE_REASON_CD" VARCHAR2(8), 
	"CLOSE_DT" DATE, 
	"UT_USER_NBR_CLOSE" NUMBER(9,0), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"ACTION" VARCHAR2(6), 
	"UT_USER_NBR_ACTION" NUMBER(9,0), 
	"ACTION_TM" DATE
   ) ;
