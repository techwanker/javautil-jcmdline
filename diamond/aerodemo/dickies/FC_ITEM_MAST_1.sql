--------------------------------------------------------
--  DDL for Table FC_ITEM_MAST
--------------------------------------------------------

  CREATE TABLE "FC_ITEM_MAST" 
   (	"FC_ITEM_MAST_NBR" NUMBER(9,0), 
	"ITEM_NBR" NUMBER(9,0), 
	"SVC_LVL" NUMBER(5,2), 
	"TOT_LEAD_TIME" NUMBER(4,0), 
	"SAFETY_STK_MIN_PRD" NUMBER(3,1), 
	"SAFETY_STK_MAX_PRD" NUMBER(3,1), 
	"SAFETY_STK_MIN_UNIT" NUMBER(11,3), 
	"SAFETY_STK_MAX_UNIT" NUMBER(11,3), 
	"REPLEN_QTY_MIN_UNIT" NUMBER(8,0), 
	"REPLEN_QTY_MAX_UNIT" NUMBER(8,0), 
	"REPLEN_QTY_MIN_PRD" NUMBER(4,1), 
	"REPLEN_QTY_MAX_PRD" NUMBER(4,1), 
	"STORE_ALT_FCST_FLG" VARCHAR2(1), 
	"ARCH_ALT_FCST_FLG" VARCHAR2(1), 
	"CALENDAR" VARCHAR2(6), 
	"FCST_MDL_GRP" VARCHAR2(8), 
	"STAT_ID" VARCHAR2(1), 
	"APS_SRC_RULE_SET_NBR" NUMBER(9,0), 
	"SAFETY_STK_ADJ" NUMBER(8,0), 
	"FCST_TYPE_ID" VARCHAR2(1) DEFAULT 'I', 
	"ORG_NBR_CUST" NUMBER(9,0), 
	"REV_LVL" VARCHAR2(5), 
	"ORG_NBR_MFR_RQST" NUMBER(9,0), 
	"FCST_GRP" VARCHAR2(8), 
	"FC_ITEM_MAST_STAT_ID" VARCHAR2(1) DEFAULT 'A', 
	"FC_ITEM_MAST_DESCR" VARCHAR2(60), 
	"SAFETY_STK_ALLOC_QTY" NUMBER(8,0), 
	"FCST_END_DT" DATE, 
	"UNIT_COST_STK_UM" NUMBER(17,5), 
	"SAFETY_STK_CALC" NUMBER(10,2), 
	"SAFETY_STK_CONSTRAIN" NUMBER(10,2), 
	"CUST_REF_CD" VARCHAR2(40), 
	"SAFETY_STK_AVAIL_TO_SELL" VARCHAR2(1) DEFAULT 'N', 
	"HARD_ALLOC_FC_WITHIN_LEAD_TM" VARCHAR2(1) DEFAULT 'N', 
	"FC_BUILD_RATE_GRP_CD" VARCHAR2(10), 
	"DESCR" VARCHAR2(50), 
	"REPLEN_POLICY" NUMBER(9,0), 
	"FC_ITEM_MAST_NBR_REPLEN_POLICY" NUMBER(9,0), 
	"FACILITY" VARCHAR2(16), 
	"LIST_PRICE" NUMBER(17,6), 
	"TRC_FILE_NM_ABSOLUTE" VARCHAR2(255), 
	"FC_ITEM_ALLOC_POLICY_ID" VARCHAR2(1) DEFAULT 'F', 
	"FCST_AGGR_TYPE_ID" VARCHAR2(1) DEFAULT 'N', 
	"TRC_FCST_FLG" VARCHAR2(1) DEFAULT 'N'
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 8388608 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;

   COMMENT ON COLUMN "FC_ITEM_MAST"."FC_ITEM_MAST_NBR" IS 'Surrogate primary key.';
   COMMENT ON COLUMN "FC_ITEM_MAST"."ITEM_NBR" IS 'The surrogate key for the associated sku, if applicable.';
   COMMENT ON COLUMN "FC_ITEM_MAST"."SAFETY_STK_MIN_PRD" IS 'The minimum number of periods of safety stock that should be maintained based on the selected forecast model.';
   COMMENT ON COLUMN "FC_ITEM_MAST"."SAFETY_STK_MAX_PRD" IS 'The maximum number of periods of safety stock that should be maintained based on the selected forecast model.';
   COMMENT ON COLUMN "FC_ITEM_MAST"."SAFETY_STK_MIN_UNIT" IS 'The minimum number of periods of safety stock that should be maintained based on the selected forecast model.';
   COMMENT ON COLUMN "FC_ITEM_MAST"."SAFETY_STK_MAX_UNIT" IS 'The maximum number of periods of safety stock that should be maintained based on the selected forecast model.';
   COMMENT ON COLUMN "FC_ITEM_MAST"."REPLEN_QTY_MIN_PRD" IS 'The minimum periods of demand which should be replenished at one time.';
   COMMENT ON COLUMN "FC_ITEM_MAST"."REPLEN_QTY_MAX_PRD" IS 'The maximu periods of demand which should be replenished at one time.';
   COMMENT ON COLUMN "FC_ITEM_MAST"."STORE_ALT_FCST_FLG" IS 'If ''Y'' then alternate forecasts that were evaluated are stored in the database.';
   COMMENT ON COLUMN "FC_ITEM_MAST"."CALENDAR" IS 'The name of the calendar to be used for this entity.';
   COMMENT ON COLUMN "FC_ITEM_MAST"."FCST_MDL_GRP" IS 'The name of the forecast model group to be used for this entity.';
   COMMENT ON COLUMN "FC_ITEM_MAST"."ORG_NBR_CUST" IS 'Surrogate key that identifies the customer associated with this forecasting entity.';
   COMMENT ON COLUMN "FC_ITEM_MAST"."REV_LVL" IS 'The revision level of a SKU required to satisfy sourcing in advanced planning.';
   COMMENT ON COLUMN "FC_ITEM_MAST"."FCST_GRP" IS '???????????';
   COMMENT ON COLUMN "FC_ITEM_MAST"."FC_ITEM_MAST_STAT_ID" IS '?????????????????';
   COMMENT ON COLUMN "FC_ITEM_MAST"."FC_ITEM_MAST_DESCR" IS 'Description of this forecasting entity.';
   COMMENT ON COLUMN "FC_ITEM_MAST"."SAFETY_STK_ALLOC_QTY" IS '????????????????';
   COMMENT ON COLUMN "FC_ITEM_MAST"."CUST_REF_CD" IS '???????????????????';
   COMMENT ON COLUMN "FC_ITEM_MAST"."SAFETY_STK_AVAIL_TO_SELL" IS '??????????????????';
   COMMENT ON COLUMN "FC_ITEM_MAST"."HARD_ALLOC_FC_WITHIN_LEAD_TM" IS '??????????????????';
   COMMENT ON COLUMN "FC_ITEM_MAST"."FC_BUILD_RATE_GRP_CD" IS '????????????????';
   COMMENT ON COLUMN "FC_ITEM_MAST"."FC_ITEM_ALLOC_POLICY_ID" IS 'F - Forecast, S - Safety Stock, B - Both, N - None';
   COMMENT ON COLUMN "FC_ITEM_MAST"."FCST_AGGR_TYPE_ID" IS 'F - Forecast Aggregated Forecast, H - History Aggregated Forecast, N - Not Aggregated';
