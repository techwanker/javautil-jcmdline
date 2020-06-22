--------------------------------------------------------
--  DDL for Table UNBRAKO_ORD_HDR
--------------------------------------------------------

  CREATE TABLE "UNBRAKO_ORD_HDR" 
   (	"ORD_NBR" NUMBER, 
	"ORG_CD_CUST" VARCHAR2(15), 
	"ORG_NM_CUST" VARCHAR2(60), 
	"ORD_DT" DATE, 
	"CUST_PO_CD" VARCHAR2(30), 
	"INDIV_NM_BUYER" VARCHAR2(45), 
	"BUYER_PHN_NBR" VARCHAR2(45), 
	"BUYER_FAX_NBR" VARCHAR2(45), 
	"UT_USER_NBR" NUMBER, 
	"LAST_MOD_DT" DATE, 
	"ORD_STAT_ID" VARCHAR2(1) DEFAULT 'O', 
	"BUYER_EMAIL_ADDR" VARCHAR2(40), 
	"SHIP_TO_ADDR_NBR" NUMBER, 
	"SHIP_VIA_CD" VARCHAR2(8), 
	"BILL_TO_ADDR_NBR" NUMBER, 
	"ORD_SHIP_NOTE" VARCHAR2(4000)
   ) ;