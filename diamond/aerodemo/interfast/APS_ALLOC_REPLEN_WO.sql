--------------------------------------------------------
--  DDL for Table APS_ALLOC_REPLEN_WO
--------------------------------------------------------

  CREATE TABLE "APS_ALLOC_REPLEN_WO" 
   (	"APS_ALLOC_REPLEN_WO_NBR" NUMBER(9,0), 
	"WO_DTL_NBR" NUMBER(9,0), 
	"PO_LINE_DTL_NBR" NUMBER(9,0), 
	"ALLOC_QTY" NUMBER(13,5), 
	"FACILITY_RQST" VARCHAR2(16), 
	"FACILITY_ACT" VARCHAR2(16), 
	"ITEM_NBR_RQST" NUMBER(9,0), 
	"ALLOC_TYPE_ID" VARCHAR2(1) DEFAULT 'U', 
	"WH_FACILITY_TRANS_REPLEN_NBR" NUMBER(9,0)
   ) ;

   COMMENT ON COLUMN "APS_ALLOC_REPLEN_WO"."ALLOC_TYPE_ID" IS 'R-Reuested for Bind,
		B_Bound Allocation, U-Unbound Allocation';
