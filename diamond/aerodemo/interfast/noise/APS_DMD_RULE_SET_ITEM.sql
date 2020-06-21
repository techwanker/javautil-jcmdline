--------------------------------------------------------
--  DDL for Table APS_DMD_RULE_SET_ITEM
--------------------------------------------------------

  CREATE TABLE "APS_DMD_RULE_SET_ITEM" 
   (	"APS_DMD_RULE_SET_ITEM_NBR" NUMBER(9,0), 
	"APS_SRC_RULE_SET_NBR" NUMBER(9,0), 
	"ITEM_NBR" NUMBER(9,0), 
	"UNALLOC_CUST_ORD_DT" DATE, 
	"ALLOC_LATE_CUST_ORD_DT" DATE, 
	"UNALLOC_FCST_DT" DATE, 
	"ALLOC_LATE_FCST_DT" DATE, 
	"UNALLOC_SAFETY_STK_DT" DATE, 
	"ALLOC_LATE_SAFETY_STK_DT" DATE, 
	"UNALLOC_WORK_ORD_DT" DATE, 
	"ALLOC_LATE_WORK_ORD_DT" DATE, 
	"APS_RULE_WARN_FLG" VARCHAR2(1), 
	"CUST_ORD_QTY_TOT" NUMBER(9,2), 
	"CUST_ALLOC_QTY_TOT" NUMBER(9,2), 
	"ONHAND_QTY" NUMBER(11,5)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 16777216 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;

   COMMENT ON COLUMN "APS_DMD_RULE_SET_ITEM"."APS_DMD_RULE_SET_ITEM_NBR" IS 'surrogate key, assigned at insert time';
   COMMENT ON COLUMN "APS_DMD_RULE_SET_ITEM"."APS_SRC_RULE_SET_NBR" IS 'foreign key to APS_SRC_RULE_SET';
   COMMENT ON COLUMN "APS_DMD_RULE_SET_ITEM"."ITEM_NBR" IS 'foreign key to ic_item_mast';
   COMMENT ON COLUMN "APS_DMD_RULE_SET_ITEM"."UNALLOC_CUST_ORD_DT" IS 'the earliest requested ship date from a customer order that was not allocated';
   COMMENT ON COLUMN "APS_DMD_RULE_SET_ITEM"."ALLOC_LATE_CUST_ORD_DT" IS 'the earliest requested ship date from a customer order that had an allocation whose availability date was later than the requested ship date';
   COMMENT ON COLUMN "APS_DMD_RULE_SET_ITEM"."ALLOC_LATE_FCST_DT" IS 'the earliest forecast date from a forecast for this rule set  order that had an allocation whose availability date was later than the requested ship date';
   COMMENT ON COLUMN "APS_DMD_RULE_SET_ITEM"."CUST_ORD_QTY_TOT" IS 'The total quantity of customer orders for this item, using this rule set, outstanding at the time planning was done.';
   COMMENT ON COLUMN "APS_DMD_RULE_SET_ITEM"."CUST_ALLOC_QTY_TOT" IS 'The total quantity allocated to customers orders for this item, using this rule set';
