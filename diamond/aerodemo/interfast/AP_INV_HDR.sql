--------------------------------------------------------
--  DDL for Table AP_INV_HDR
--------------------------------------------------------

  CREATE TABLE "AP_INV_HDR" 
   (	"AP_INV_HDR_NBR" NUMBER(9,0), 
	"AP_INV_BATCH_NBR" NUMBER(9,0), 
	"INV_DT" DATE, 
	"INV_STAT_ID" VARCHAR2(1), 
	"ORG_NBR_VND" NUMBER(9,0), 
	"ORG_CD_VND" VARCHAR2(16), 
	"ORG_NM_VND" VARCHAR2(60), 
	"PO_ORD_HDR_NBR" NUMBER(9,0), 
	"PO_CD" VARCHAR2(20), 
	"VNDR_ORD_CD" VARCHAR2(30), 
	"CURR_CD" VARCHAR2(3), 
	"MAIL_TO_ADDR_NBR" NUMBER(9,0), 
	"MAIL_TO_ADDR_CD" VARCHAR2(8), 
	"MAIL_TO_ADDR_DESCR" VARCHAR2(60), 
	"MAIL_TO_ADDR_1" VARCHAR2(30), 
	"MAIL_TO_ADDR_2" VARCHAR2(30), 
	"MAIL_TO_ADDR_3" VARCHAR2(30), 
	"MAIL_TO_CITY" VARCHAR2(25), 
	"MAIL_TO_STATE_CD" VARCHAR2(5), 
	"MAIL_TO_POSTAL_CD" VARCHAR2(10), 
	"MAIL_TO_CNTRY_CD" VARCHAR2(3), 
	"TERM_CD" VARCHAR2(10), 
	"GROSS_INV_VALUE" NUMBER(17,5), 
	"WGHT" NUMBER(10,3), 
	"CTN_CNT" NUMBER(7,0), 
	"FRGT_CHG" NUMBER(10,2), 
	"NET_INV_VALUE" NUMBER(17,5), 
	"TRD_DISC_AMT" NUMBER(17,5), 
	"WAYBILL_CD" VARCHAR2(20), 
	"FOB_CD" VARCHAR2(8), 
	"TRD_FLG" VARCHAR2(1)
   ) ;

   COMMENT ON COLUMN "AP_INV_HDR"."INV_STAT_ID" IS 'N-New, W-Review Pending, R-Ready for Post, E-Error Posting,
	P-Posted, T-Transferred to Accounting Package, F-Failed Accounting Integration';
   COMMENT ON TABLE "AP_INV_HDR"  IS 'This table stores the Payment Information for all the Account Payables';
