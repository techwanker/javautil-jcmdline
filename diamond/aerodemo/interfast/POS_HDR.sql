--------------------------------------------------------
--  DDL for Table POS_HDR
--------------------------------------------------------

  CREATE TABLE "POS_HDR" 
   (	"POS_HDR_NBR" NUMBER(9,0), 
	"ORG_NBR_CUST" NUMBER(9,0), 
	"ORG_NM_CUST" VARCHAR2(60), 
	"CURR_CD" VARCHAR2(3), 
	"ORD_TYPE_CD" VARCHAR2(8), 
	"CUST_PO_CD" VARCHAR2(30), 
	"SHIP_TO_ADDR_NBR" NUMBER(9,0), 
	"BILL_TO_ADDR_NBR" NUMBER(9,0), 
	"SHIP_VIA_CD" VARCHAR2(8), 
	"TERM_CD" VARCHAR2(10), 
	"FOB_CD" VARCHAR2(8), 
	"SELL_INDIV_NBR" NUMBER(9,0), 
	"INDIV_NM_BUYER" VARCHAR2(45), 
	"BUYER_PHN_NBR" VARCHAR2(20), 
	"BUYER_FAX_NBR" VARCHAR2(20), 
	"BUYER_EMAIL_ADDR" VARCHAR2(40), 
	"POS_STAT_ID" VARCHAR2(1), 
	"OE_ORD_HDR_NBR" NUMBER(9,0), 
	"UT_USER_NBR_PROCESS" NUMBER(9,0), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) ;

   COMMENT ON COLUMN "POS_HDR"."POS_STAT_ID" IS 'O-Open, C-Closed, X-Cancelled';