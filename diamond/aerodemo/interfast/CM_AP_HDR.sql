--------------------------------------------------------
--  DDL for Table CM_AP_HDR
--------------------------------------------------------

  CREATE TABLE "CM_AP_HDR" 
   (	"CM_AP_CD" VARCHAR2(20), 
	"CM_AP_DT" DATE, 
	"AP_INV_HDR_NBR_REF" NUMBER(9,0), 
	"CURR_CD" VARCHAR2(3), 
	"ORG_NBR_VND" NUMBER(9,0), 
	"ORG_CD_VND" VARCHAR2(15), 
	"ORG_NM_VND" VARCHAR2(60), 
	"CM_STAT_ID" VARCHAR2(1), 
	"CM_AP_COMM" VARCHAR2(1024), 
	"UT_USER_NBR_CREATE" NUMBER(9,0), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
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
	"TERM_CD" VARCHAR2(10)
   ) ;

   COMMENT ON COLUMN "CM_AP_HDR"."CM_STAT_ID" IS 'N-New, W-Review Pending,
	R-Ready for Post, E-Error Posting, P-Posted,
	T-Transferred to Accounting Package, F-Failed Accounting Integration';
