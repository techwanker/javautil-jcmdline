--------------------------------------------------------
--  DDL for Table AR_RMA_HDR
--------------------------------------------------------

  CREATE TABLE "AR_RMA_HDR" 
   (	"RMA_CD" VARCHAR2(20), 
	"RMA_DT" DATE, 
	"RMA_STAT_ID" VARCHAR2(1), 
	"INV_CD" VARCHAR2(20), 
	"ORG_NBR_CUST" NUMBER(9,0), 
	"ORG_CD_CUST" VARCHAR2(15), 
	"ORG_NM_CUST" VARCHAR2(60), 
	"CURR_CD" VARCHAR2(3), 
	"WAYBILL_CD" VARCHAR2(20), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"RMA_TYPE_ID" VARCHAR2(1), 
	"BILL_TO_ADDR_NBR" NUMBER(9,0), 
	"BILL_TO_ADDR_CD" VARCHAR2(8), 
	"BILL_TO_ADDR_DESCR" VARCHAR2(60), 
	"BILL_TO_ADDR_1" VARCHAR2(30), 
	"BILL_TO_ADDR_2" VARCHAR2(30), 
	"BILL_TO_ADDR_3" VARCHAR2(30), 
	"BILL_TO_CITY" VARCHAR2(25), 
	"BILL_TO_STATE_CD" VARCHAR2(5), 
	"BILL_TO_POSTAL_CD" VARCHAR2(10), 
	"BILL_TO_CNTRY_CD" VARCHAR2(3)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 2097152 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;

   COMMENT ON COLUMN "AR_RMA_HDR"."RMA_CD" IS 'Is the Primary Key for the RMA. Assigned by the System using AR_RMA_CD_SEQ';
   COMMENT ON COLUMN "AR_RMA_HDR"."RMA_DT" IS 'The Date the RMA was created. ';
   COMMENT ON COLUMN "AR_RMA_HDR"."RMA_STAT_ID" IS 'The Status of the Invoice. This can be one of N-New, W-Review Pending,
	R-Ready for Post, P-Posted, T-Transferred to Accounting, F-Failed Integration ';
   COMMENT ON COLUMN "AR_RMA_HDR"."INV_CD" IS 'This is the Invoice against which the RMA is being issued';
   COMMENT ON COLUMN "AR_RMA_HDR"."ORG_NBR_CUST" IS 'This is the Customer Number to which the RMA is being issued';
   COMMENT ON COLUMN "AR_RMA_HDR"."ORG_NM_CUST" IS 'This is the Customer Name to which the RMA is being issued';
   COMMENT ON COLUMN "AR_RMA_HDR"."WAYBILL_CD" IS 'The waybill code that the Customer will use to ship the parts to us';
   COMMENT ON COLUMN "AR_RMA_HDR"."RMA_TYPE_ID" IS 'Q-Quantity Adjustment, P-Price Adjustment';
   COMMENT ON TABLE "AR_RMA_HDR"  IS 'This table stores the information on all the RMA''s issued';
