--------------------------------------------------------
--  DDL for Table TMP_APS_ALLOC_ONHAND_OO
--------------------------------------------------------

  CREATE GLOBAL TEMPORARY TABLE "TMP_APS_ALLOC_ONHAND_OO" 
   (	"APS_ALLOC_ONHAND_OO_NBR" NUMBER(9,0), 
	"OE_ORD_DTL_NBR" NUMBER(9,0), 
	"LOT_NBR" NUMBER(9,0), 
	"ALLOC_QTY" NUMBER(13,5), 
	"APS_SPLY_SUB_POOL_NBR" NUMBER(9,0), 
	"SUBST_ID" VARCHAR2(1), 
	"FACILITY_RQST" VARCHAR2(16), 
	"FACILITY_ACT" VARCHAR2(16), 
	"ITEM_NBR_RQST" NUMBER(9,0), 
	"UNIT_PRICE_SELL_UM" NUMBER(17,6), 
	"UNIT_PRICE_DENOM_SELL_UM" NUMBER(17,6), 
	"UNIT_PRICE_STK_UM" NUMBER(17,6), 
	"UNIT_PRICE_DENOM_STK_UM" NUMBER(17,6), 
	"WH_FACILITY_TRANS_ONHAND_NBR" NUMBER(9,0), 
	"ALLOC_TYPE_ID" VARCHAR2(1)
   ) ON COMMIT DELETE ROWS ;
