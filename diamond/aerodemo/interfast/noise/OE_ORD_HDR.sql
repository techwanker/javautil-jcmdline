--------------------------------------------------------
--  DDL for Table OE_ORD_HDR
--------------------------------------------------------

  CREATE TABLE "OE_ORD_HDR" 
   (	"OE_ORD_HDR_NBR" NUMBER(9,0), 
	"ORD_DT" DATE, 
	"ORD_STAT_ID" VARCHAR2(1), 
	"ORG_NBR_CUST" NUMBER(9,0), 
	"BILL_TO_ADDR_NBR" NUMBER(9,0), 
	"SHIP_TO_ADDR_NBR_DFLT" NUMBER(9,0), 
	"CUST_PO_CD" VARCHAR2(30), 
	"CUST_PO_DT" DATE, 
	"RQST_DT_DFLT" DATE, 
	"CANCEL_DT" DATE, 
	"TERM_CD" VARCHAR2(10), 
	"SHIP_VIA_CD_DFLT" VARCHAR2(8), 
	"FOB_CD" VARCHAR2(8), 
	"CURR_CD" VARCHAR2(3), 
	"UT_USER_NBR_CANCEL" NUMBER(9,0), 
	"CANCEL_CD" VARCHAR2(8), 
	"ORD_PRTY" NUMBER(3,0), 
	"SELL_INDIV_NBR" NUMBER(9,0), 
	"TRD_FLG" VARCHAR2(1), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"SHIP_PCT_LINE" NUMBER(3,0), 
	"SHIP_PCT_DOLLAR" NUMBER(3,0), 
	"NEXT_LINE_NBR" NUMBER(4,0), 
	"ORG_NM_CUST" VARCHAR2(60), 
	"ORD_TYPE_CD" VARCHAR2(8), 
	"ORD_CD" VARCHAR2(20), 
	"BUYER_EMAIL_ADDR" VARCHAR2(40), 
	"INDIV_NM_BUYER" VARCHAR2(45), 
	"BUYER_PHN_NBR" VARCHAR2(20), 
	"SALES_TERR_CD" VARCHAR2(8), 
	"BUYER_FAX_NBR" VARCHAR2(20), 
	"TRANSMIT_FLG" VARCHAR2(1) DEFAULT 'Y', 
	"WH_SHIP_PRTY_NBR_DFLT" NUMBER(5,0), 
	"PAYMENT_METHOD_CD_DFLT" VARCHAR2(3)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 104857600 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
