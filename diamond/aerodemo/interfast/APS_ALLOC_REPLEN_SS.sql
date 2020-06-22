--------------------------------------------------------
--  DDL for Table APS_ALLOC_REPLEN_SS
--------------------------------------------------------

  CREATE TABLE "APS_ALLOC_REPLEN_SS" 
   (	"APS_ALLOC_REPLEN_SS_NBR" NUMBER(9,0), 
	"PO_LINE_DTL_NBR" NUMBER(9,0), 
	"ALLOC_QTY" NUMBER(13,5), 
	"SUBST_ID" VARCHAR2(1), 
	"FACILITY_RQST" VARCHAR2(16), 
	"FACILITY_ACT" VARCHAR2(16), 
	"ITEM_NBR_RQST" NUMBER(9,0), 
	"ALLOC_TYPE_ID" VARCHAR2(1) DEFAULT 'U', 
	"WH_FACILITY_TRANS_REPLEN_NBR" NUMBER(9,0), 
	"FC_ITEM_MAST_NBR" NUMBER(9,0)
   ) ;

   COMMENT ON COLUMN "APS_ALLOC_REPLEN_SS"."SUBST_ID" IS 'G-Global Substitute Allocated,
		C-Customer Specified Subsitute allocated';
   COMMENT ON COLUMN "APS_ALLOC_REPLEN_SS"."ALLOC_TYPE_ID" IS 'R-Reuested for Bind,
		B_Bound Allocation, U-Unbound Allocation';