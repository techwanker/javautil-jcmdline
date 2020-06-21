--------------------------------------------------------
--  DDL for Table APS_ALLOC_ONHAND_OO
--------------------------------------------------------

  CREATE TABLE "APS_ALLOC_ONHAND_OO" 
   (	"APS_ALLOC_ONHAND_OO_NBR" NUMBER(9,0), 
	"OE_ORD_DTL_NBR" NUMBER(9,0), 
	"LOT_NBR" NUMBER(9,0), 
	"ALLOC_QTY" NUMBER(13,5), 
	"APS_SPLY_SUB_POOL_NBR" NUMBER(9,0), 
	"SUBST_ID" VARCHAR2(1), 
	"FACILITY_RQST" VARCHAR2(16), 
	"FACILITY_ACT" VARCHAR2(16), 
	"ITEM_NBR_RQST" NUMBER(9,0), 
	"UNIT_PRICE_SELL_UM" NUMBER(17,6), 
	"UNIT_PRICE_DENOM_SELL_UM" NUMBER(17,6), 
	"UNIT_PRICE_STK_UM" NUMBER(17,6), 
	"UNIT_PRICE_DENOM_STK_UM" NUMBER(17,6), 
	"ALLOC_TYPE_ID" VARCHAR2(1) DEFAULT 'U', 
	"WH_FACILITY_TRANS_ONHAND_NBR" NUMBER(9,0), 
	"AVAIL_DT" DATE DEFAULT NULL, 
	"AVAIL_DT_TYPE_ID" VARCHAR2(1) DEFAULT NULL
   ) ;

   COMMENT ON COLUMN "APS_ALLOC_ONHAND_OO"."APS_SPLY_SUB_POOL_NBR" IS 'A foreign key to the subset of inventory, within this lot that was allocated to this demand.';
   COMMENT ON COLUMN "APS_ALLOC_ONHAND_OO"."SUBST_ID" IS 'G-Global Substitute Allocated,
		C-Customer Specified Subsitute allocated';
   COMMENT ON COLUMN "APS_ALLOC_ONHAND_OO"."FACILITY_RQST" IS 'The primary facility from which this demand should be allocated based on the sourcing rules in effect at the time the allocation was made.';
   COMMENT ON COLUMN "APS_ALLOC_ONHAND_OO"."FACILITY_ACT" IS 'The actual facility that had the inventory that was allocated to this demand.';
   COMMENT ON COLUMN "APS_ALLOC_ONHAND_OO"."ALLOC_TYPE_ID" IS 'R-Reuested for Bind,
		B_Bound Allocation, U-Unbound Allocation';
