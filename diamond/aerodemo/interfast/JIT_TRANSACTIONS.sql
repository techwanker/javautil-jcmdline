--------------------------------------------------------
--  DDL for Table JIT_TRANSACTIONS
--------------------------------------------------------

  CREATE TABLE "JIT_TRANSACTIONS" 
   (	"JIT_TRANS_BATCH_NBR" NUMBER(9,0), 
	"JIT_TRANSACTION_NBR" NUMBER(9,0), 
	"CUST_BIN_CD" VARCHAR2(30), 
	"CUST_BIN_GRP" VARCHAR2(8), 
	"ITEM_CD_CUST" VARCHAR2(50), 
	"ITEM_CD" VARCHAR2(50), 
	"USE_BIN_GRP_FLG" VARCHAR2(1), 
	"TRANS_QTY" NUMBER(13,5), 
	"TRANS_ID" VARCHAR2(1), 
	"LOAD_SEQ" NUMBER(9,0), 
	"TRANS_STAT_ID" VARCHAR2(1), 
	"JIT_ERR_CD" VARCHAR2(8)
   ) ;

   COMMENT ON COLUMN "JIT_TRANSACTIONS"."TRANS_ID" IS 'I - Increment, D - Decrement, S - Set';
   COMMENT ON COLUMN "JIT_TRANSACTIONS"."TRANS_STAT_ID" IS 'N - New, P - Processed, E - Errored';
