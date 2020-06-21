--------------------------------------------------------
--  DDL for Table DN_AR_HDR
--------------------------------------------------------

  CREATE TABLE "DN_AR_HDR" 
   (	"DN_AR_CD" VARCHAR2(20), 
	"DN_AR_DT" DATE, 
	"INV_CD_REF" VARCHAR2(20), 
	"RMA_CD_REF" VARCHAR2(20), 
	"CURR_CD" VARCHAR2(3), 
	"ORG_NBR_CUST" NUMBER(9,0), 
	"ORG_CD_CUST" VARCHAR2(15), 
	"ORG_NM_CUST" VARCHAR2(60), 
	"DN_STAT_ID" VARCHAR2(1), 
	"DN_AR_COMM" VARCHAR2(1024), 
	"UT_USER_NBR_CREATE" NUMBER(9,0), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"BILL_TO_ADDR_NBR" NUMBER(9,0), 
	"BILL_TO_ADDR_CD" VARCHAR2(8), 
	"BILL_TO_ADDR_DESCR" VARCHAR2(60), 
	"BILL_TO_ADDR_1" VARCHAR2(30), 
	"BILL_TO_ADDR_2" VARCHAR2(30), 
	"BILL_TO_ADDR_3" VARCHAR2(30), 
	"BILL_TO_CITY" VARCHAR2(25), 
	"BILL_TO_STATE_CD" VARCHAR2(5), 
	"BILL_TO_POSTAL_CD" VARCHAR2(10), 
	"BILL_TO_CNTRY_CD" VARCHAR2(3), 
	"TERM_CD" VARCHAR2(10)
   ) ;

   COMMENT ON COLUMN "DN_AR_HDR"."DN_STAT_ID" IS 'N-New, W-Review Pending, 
	R-Ready for Post, E-Error Posting, P-Posted, 
	T-Transferred to Accounting Package, F-Failed Accounting Integration';
