--------------------------------------------------------
--  DDL for Table IC_LOT_MAST
--------------------------------------------------------

  CREATE TABLE "IC_LOT_MAST" 
   (	"ITEM_NBR" NUMBER(9,0), 
	"LOT_NBR" NUMBER(9,0), 
	"REV_LVL" VARCHAR2(5), 
	"MFR_LOT_CD" VARCHAR2(20), 
	"PO_ORD_HDR_NBR" NUMBER(9,0), 
	"PO_LINE_HDR_NBR" NUMBER(9,0), 
	"ORG_NBR_VND" NUMBER(9,0), 
	"ORG_NBR_MFR" NUMBER(9,0), 
	"RCPT_DT" DATE, 
	"LOT_COST_UM" VARCHAR2(3), 
	"LOT_COST" NUMBER(13,6), 
	"LOT_COST_CURR_CD" VARCHAR2(3), 
	"LOT_COST_DENOM" NUMBER(13,6), 
	"LOT_COST_CURR_CD_DENOM" VARCHAR2(3), 
	"LOT_STAT_ID" VARCHAR2(1), 
	"MFR_DATE" DATE, 
	"LOT_CRE_COMM" VARCHAR2(200), 
	"RECV_QTY" NUMBER, 
	"INSPECT_QTY" NUMBER(10,2), 
	"UT_USER_NBR_INSPECT" NUMBER(9,0), 
	"ACCEPT_QTY" NUMBER, 
	"INSPECT_DT" DATE, 
	"REJ_QTY" NUMBER(10,2), 
	"TRD_FLG" VARCHAR2(1), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"ITEM_CD_VND" VARCHAR2(50), 
	"CNTRY_CD_ORIGIN" VARCHAR2(3), 
	"LOT_NBR_ORIG" NUMBER(9,0), 
	"EXPIRE_DT" DATE, 
	"BOX_QTY" NUMBER(7,0), 
	"QTY_ON_HAND_FLG" VARCHAR2(1), 
	"REJECT_CD" VARCHAR2(8), 
	"LOT_COST_LANDED_ORIG" NUMBER(17,6), 
	"LOT_COST_LANDED_DENOM_ORIG" NUMBER(17,6), 
	"LOT_COST_LANDED_CURR" NUMBER(17,6), 
	"LOT_COST_LANDED_DENOM_CURR" NUMBER(17,6), 
	"PROCESSED_FOR_AP_FLG" VARCHAR2(1) DEFAULT 'N', 
	"LOT_CD" VARCHAR2(20), 
	"WO_HDR_NBR" NUMBER(9,0), 
	"WO_RELEASE_NBR" NUMBER(9,0), 
	"UT_USER_NBR_RECV" NUMBER(9,0)
   ) ;
