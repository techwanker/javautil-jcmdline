--------------------------------------------------------
--  DDL for Table APS_ALLOC_ONHAND_FC
--------------------------------------------------------

  CREATE TABLE "APS_ALLOC_ONHAND_FC" 
   (	"APS_ALLOC_ONHAND_FC_NBR" NUMBER(9,0), 
	"FC_FCST_NBR" NUMBER(9,0), 
	"LOT_NBR" NUMBER(9,0), 
	"ALLOC_QTY" NUMBER(13,5), 
	"APS_SPLY_SUB_POOL_NBR" NUMBER(9,0), 
	"SUBST_ID" VARCHAR2(1), 
	"FACILITY_RQST" VARCHAR2(16), 
	"FACILITY_ACT" VARCHAR2(16), 
	"ITEM_NBR_RQST" NUMBER(9,0), 
	"ALLOC_TYPE_ID" VARCHAR2(1) DEFAULT 'U', 
	"WH_FACILITY_TRANS_ONHAND_NBR" NUMBER(9,0), 
	"AVAIL_DT" DATE DEFAULT NULL, 
	"AVAIL_DT_TYPE_ID" VARCHAR2(1) DEFAULT NULL
   ) ;

   COMMENT ON COLUMN "APS_ALLOC_ONHAND_FC"."SUBST_ID" IS 'G-Global Substitute Allocated,
		C-Customer Specified Subsitute allocated';
   COMMENT ON COLUMN "APS_ALLOC_ONHAND_FC"."ALLOC_TYPE_ID" IS 'R-Reuested for Bind,
		B_Bound Allocation, U-Unbound Allocation';
