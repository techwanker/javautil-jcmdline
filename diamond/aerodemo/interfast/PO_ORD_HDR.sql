--------------------------------------------------------
--  DDL for Table PO_ORD_HDR
--------------------------------------------------------

  CREATE TABLE "PO_ORD_HDR" 
   (	"PO_ORD_HDR_NBR" NUMBER(9,0), 
	"PO_CD" VARCHAR2(20), 
	"PO_DT" DATE, 
	"ORG_NBR_VND" NUMBER(9,0), 
	"ADDR_NBR_VND" NUMBER(9,0), 
	"CURR_CD" VARCHAR2(3), 
	"SHIP_TO_ADDR_NBR_DFLT" NUMBER(9,0), 
	"BILL_TO_ADDR_NBR" NUMBER(9,0), 
	"INDIV_NBR_BUY" NUMBER(9,0), 
	"NEXT_PO_LINE_NBR" NUMBER(3,0), 
	"ORD_STAT_ID" VARCHAR2(1), 
	"VNDR_ORD_CD" VARCHAR2(20), 
	"TERM_CD" VARCHAR2(10), 
	"FOB_CD" VARCHAR2(8), 
	"TRD_FLG" VARCHAR2(1), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"SHIP_VIA_CD_DFLT" VARCHAR2(8), 
	"CANCEL_CD" VARCHAR2(8), 
	"CANCEL_DT" DATE, 
	"UT_USER_NBR_CANCEL" NUMBER(9,0), 
	"INDIV_NM_SELLER" VARCHAR2(45), 
	"SELLER_PHN_NBR" VARCHAR2(20), 
	"SELLER_EMAIL_ADDR" VARCHAR2(40), 
	"ACK_FLG" VARCHAR2(1) DEFAULT 'N', 
	"SELLER_FAX_NBR" VARCHAR2(20), 
	"TRANSMIT_FLG" VARCHAR2(1) DEFAULT 'N', 
	"PO_TYPE_ID" VARCHAR2(1) DEFAULT 'R'
   ) ;
