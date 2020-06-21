--------------------------------------------------------
--  DDL for Table IDL_IC_ITEM_LOC
--------------------------------------------------------

  CREATE TABLE "IDL_IC_ITEM_LOC" 
   (	"IDL_IC_ITEM_LOC_NBR" NUMBER(9,0), 
	"ITEM_CD" VARCHAR2(50), 
	"ITEM_DESCR" VARCHAR2(50), 
	"STK_UM" VARCHAR2(3), 
	"QTY_ON_HAND" NUMBER, 
	"FACILITY" VARCHAR2(16), 
	"SPLY_POOL_CD" VARCHAR2(20), 
	"BIN_CD" VARCHAR2(16), 
	"RCPT_DT" DATE, 
	"ORG_CD_VND" VARCHAR2(16), 
	"ORG_CD_MFR" VARCHAR2(16), 
	"RCPT_DT_TXT" VARCHAR2(16)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 720896 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;

   COMMENT ON COLUMN "IDL_IC_ITEM_LOC"."IDL_IC_ITEM_LOC_NBR" IS 'Surrogate key for internal purposes.';
   COMMENT ON COLUMN "IDL_IC_ITEM_LOC"."ITEM_CD" IS 'Product Number - SKU';
   COMMENT ON COLUMN "IDL_IC_ITEM_LOC"."ITEM_DESCR" IS 'Description of the product';
   COMMENT ON COLUMN "IDL_IC_ITEM_LOC"."STK_UM" IS 'Stock Keeping Unit of Measure';
   COMMENT ON COLUMN "IDL_IC_ITEM_LOC"."QTY_ON_HAND" IS 'Quantity on Hand in stock keeping unit of measure.';
   COMMENT ON COLUMN "IDL_IC_ITEM_LOC"."FACILITY" IS 'The facility (e.g. warehouse) in which this inventory is located.';
   COMMENT ON COLUMN "IDL_IC_ITEM_LOC"."SPLY_POOL_CD" IS 'The supply pool associated with this inventory.';
   COMMENT ON COLUMN "IDL_IC_ITEM_LOC"."BIN_CD" IS 'The identifier for the location within the facility for this inventory.';
   COMMENT ON COLUMN "IDL_IC_ITEM_LOC"."RCPT_DT" IS 'The date this inventory was received.';
   COMMENT ON COLUMN "IDL_IC_ITEM_LOC"."ORG_CD_VND" IS 'Identifies the organization from which this inventory was purchased.';
   COMMENT ON COLUMN "IDL_IC_ITEM_LOC"."ORG_CD_MFR" IS 'Identifies the orgranization that manufactured the inventory.';
   COMMENT ON TABLE "IDL_IC_ITEM_LOC"  IS 'Interface table for onhand inventory quanities and location.';
