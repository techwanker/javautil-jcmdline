--------------------------------------------------------
--  DDL for Table CM_AR_HDR
--------------------------------------------------------

  CREATE TABLE "CM_AR_HDR" 
   (	"CM_AR_CD" VARCHAR2(20), 
	"CM_AR_DT" DATE, 
	"INV_CD_REF" VARCHAR2(20), 
	"RMA_CD_REF" VARCHAR2(20), 
	"CURR_CD" VARCHAR2(3), 
	"ORG_NBR_CUST" NUMBER(9,0), 
	"ORG_CD_CUST" VARCHAR2(15), 
	"ORG_NM_CUST" VARCHAR2(60), 
	"CM_STAT_ID" VARCHAR2(1), 
	"CM_AR_COMM" VARCHAR2(1024), 
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
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 2097152 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;

   COMMENT ON COLUMN "CM_AR_HDR"."CM_STAT_ID" IS 'N-New, W-Review Pending,
	R-Ready for Post, E-Error Posting, P-Posted,
	T-Transferred to Accounting Package, F-Failed Accounting Integration';
