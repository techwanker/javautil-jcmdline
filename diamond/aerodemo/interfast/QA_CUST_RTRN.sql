--------------------------------------------------------
--  DDL for Table QA_CUST_RTRN
--------------------------------------------------------

  CREATE TABLE "QA_CUST_RTRN" 
   (	"QA_CUST_RTRN_NBR" NUMBER(8,0), 
	"OE_ORD_HDR_NBR" NUMBER(9,0), 
	"OE_ORD_DTL_NBR" NUMBER(9,0), 
	"ITEM_NBR" NUMBER(9,0), 
	"ORG_NBR_MFR" NUMBER(9,0), 
	"MFR_LOT_CD" VARCHAR2(20), 
	"RTRN_REASON_CD" VARCHAR2(5), 
	"DT_INIT" DATE, 
	"ORG_NBR_CUST" NUMBER(9,0), 
	"LOT_NBR" NUMBER(9,0), 
	"ORG_NBR_VND" NUMBER(9,0), 
	"DISP_CD" VARCHAR2(3), 
	"DT_CLOSED" DATE, 
	"UT_USER_NBR_INIT" NUMBER(9,0), 
	"QTY_RTRN_FROM_CUST" NUMBER(8,0), 
	"QTY_RTRN_TO_VND" NUMBER(8,0), 
	"BAD_LOT_FLG" VARCHAR2(1), 
	"REJECT_CD" VARCHAR2(8)
   ) ;
