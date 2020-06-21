--------------------------------------------------------
--  DDL for Table IC_TRANS_GL
--------------------------------------------------------

  CREATE TABLE "IC_TRANS_GL" 
   (	"IC_TRANS_GL_NBR" NUMBER(9,0), 
	"IC_TRANS_GL_DESCR" VARCHAR2(255), 
	"IC_TRANS_GL_DT" DATE, 
	"IC_TRANS_GL_STAT_ID" VARCHAR2(1), 
	"UT_USER_NBR" NUMBER(9,0), 
	"IC_TRANS_GL_TYPE_ID" VARCHAR2(2)
   ) ;

   COMMENT ON COLUMN "IC_TRANS_GL"."IC_TRANS_GL_STAT_ID" IS 'R-Ready for Post, P-Posted,
	T-Transferred to Accounting Package, F-Failed Accounting Integration';
   COMMENT ON COLUMN "IC_TRANS_GL"."IC_TRANS_GL_TYPE_ID" IS 'AD-Stock Adjustment, WO-Work Order Completion,
LT-Logical Transfer, RW-Rework Completion, ST-Trade Shipment, RT-Trade Receipt
FT-Facility Transfer, RM-RMA Receipts';
