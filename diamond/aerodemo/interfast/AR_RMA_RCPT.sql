--------------------------------------------------------
--  DDL for Table AR_RMA_RCPT
--------------------------------------------------------

  CREATE TABLE "AR_RMA_RCPT" 
   (	"AR_RMA_RCPT_NBR" NUMBER(9,0), 
	"RCPT_DT" DATE, 
	"AR_RMA_DTL_NBR" NUMBER(9,0), 
	"ORG_NBR_CUST" NUMBER(9,0), 
	"ITEM_NBR" NUMBER(9,0), 
	"QTY_RECEIVED" NUMBER(13,5), 
	"QTY_RECEIVED_STK_UM" NUMBER(13,5), 
	"QTY_ACCEPTED" NUMBER(13,5), 
	"QTY_ACCEPTED_STK_UM" NUMBER(13,5), 
	"RMA_UM" VARCHAR2(3), 
	"BIN_NBR_STAGE" NUMBER(9,0), 
	"RMA_COMMENTS" VARCHAR2(255), 
	"RCPT_STAT_ID" VARCHAR2(1), 
	"LOT_NBR_RECV" NUMBER(9,0), 
	"FACILITY_RECV" VARCHAR2(16), 
	"APS_SPLY_SUB_POOL_NBR_RECV" NUMBER(9,0), 
	"UT_USER_NBR_RECV" NUMBER(9,0), 
	"UT_USER_NBR_INSPECT" NUMBER(9,0), 
	"PROCESS_DT" DATE, 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"LOT_COST_LANDED" NUMBER(13,6), 
	"IC_TRANS_GL_NBR" NUMBER(9,0)
   ) ;

   COMMENT ON COLUMN "AR_RMA_RCPT"."AR_RMA_RCPT_NBR" IS 'Primary Key for the Table';
   COMMENT ON COLUMN "AR_RMA_RCPT"."RCPT_DT" IS 'The Date the Parts were received from the customer';
   COMMENT ON COLUMN "AR_RMA_RCPT"."AR_RMA_DTL_NBR" IS 'Foreign key back to the AR_RMA_DTL header';
   COMMENT ON COLUMN "AR_RMA_RCPT"."ITEM_NBR" IS 'The Part that was received';
   COMMENT ON COLUMN "AR_RMA_RCPT"."QTY_RECEIVED" IS 'The Quantity that was received';
   COMMENT ON COLUMN "AR_RMA_RCPT"."QTY_ACCEPTED" IS 'The Quantity that was accepted after inspection';
   COMMENT ON COLUMN "AR_RMA_RCPT"."RMA_UM" IS 'The Unit of Measure of the Parts received';
   COMMENT ON COLUMN "AR_RMA_RCPT"."BIN_NBR_STAGE" IS 'The Bin where the Parts received were put in temporarily';
   COMMENT ON COLUMN "AR_RMA_RCPT"."RCPT_STAT_ID" IS 'This is the Status. O - Open, C - Closed';
   COMMENT ON COLUMN "AR_RMA_RCPT"."UT_USER_NBR_RECV" IS 'The Person who received the RMA';
   COMMENT ON COLUMN "AR_RMA_RCPT"."UT_USER_NBR_INSPECT" IS 'The person who inspected the Parts Received';
   COMMENT ON COLUMN "AR_RMA_RCPT"."PROCESS_DT" IS 'The Date the RMA was Processed';
   COMMENT ON TABLE "AR_RMA_RCPT"  IS 'This table stores the details of all the RMA''s Receipts.
Once the Parts have been inspected and accepted, this table ties thd Receipt to
the RMA issued and ties things up';
