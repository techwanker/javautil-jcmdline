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
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 16777216 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;

   COMMENT ON COLUMN "IC_TRANS_GL"."IC_TRANS_GL_STAT_ID" IS 'R-Ready for Post, P-Posted,
	T-Transferred to Accounting Package, F-Failed Accounting Integration';
   COMMENT ON COLUMN "IC_TRANS_GL"."IC_TRANS_GL_TYPE_ID" IS 'AD-Stock Adjustment, WO-Work Order Completion,
LT-Logical Transfer, RW-Rework Completion, ST-Trade Shipment, RT-Trade Receipt
FT-Facility Transfer, RM-RMA Receipts';
