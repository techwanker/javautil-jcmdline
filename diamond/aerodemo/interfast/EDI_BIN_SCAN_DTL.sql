--------------------------------------------------------
--  DDL for Table EDI_BIN_SCAN_DTL
--------------------------------------------------------

  CREATE TABLE "EDI_BIN_SCAN_DTL" 
   (	"EDI_BIN_SCAN_DTL_NBR" NUMBER(9,0), 
	"EDI_BIN_SCAN_BATCH_NBR" NUMBER(9,0), 
	"CUST_BIN_CD" VARCHAR2(40), 
	"QTY_ORD" NUMBER(9,0), 
	"PROCESS_STAT_ID" VARCHAR2(1) DEFAULT 'N', 
	"PROCESS_DT" DATE, 
	"ERR_CD" VARCHAR2(10), 
	"OE_ORD_HDR_NBR" NUMBER(9,0), 
	"OE_ORD_DTL_NBR" NUMBER(9,0), 
	"ORG_NBR_CUST" NUMBER(9,0), 
	"IGNORE_DUP_SCAN_FLG" VARCHAR2(1) DEFAULT 'N', 
	"BIN_SCAN_DELETE_REASON" VARCHAR2(128)
   ) ;

   COMMENT ON COLUMN "EDI_BIN_SCAN_DTL"."PROCESS_STAT_ID" IS 'N-New, ready to be processed,
	E-Error Processing, F-Fixed Errors,Ready for processing again, P-Processed,
	X-Cancelled';
