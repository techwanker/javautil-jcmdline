--------------------------------------------------------
--  DDL for Table IDL_IC_ITEM_MAST
--------------------------------------------------------

  CREATE TABLE "IDL_IC_ITEM_MAST" 
   (	"IDL_IC_ITEM_MAST_NBR" NUMBER(9,0), 
	"ITEM_CD" VARCHAR2(50), 
	"ITEM_DESCR" VARCHAR2(50), 
	"STK_UM" VARCHAR2(3), 
	"STD_COST" NUMBER, 
	"IC_CATEGORY_NM" VARCHAR2(16), 
	"INTRO_DT" DATE, 
	"LIST_PRICE" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 3145728 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;

   COMMENT ON COLUMN "IDL_IC_ITEM_MAST"."IDL_IC_ITEM_MAST_NBR" IS 'Surrogate key for internal purposes.';
   COMMENT ON COLUMN "IDL_IC_ITEM_MAST"."ITEM_CD" IS 'Product identifier.';
   COMMENT ON COLUMN "IDL_IC_ITEM_MAST"."ITEM_DESCR" IS 'Description of product.';
   COMMENT ON COLUMN "IDL_IC_ITEM_MAST"."STK_UM" IS 'ANSI X.12 stock keeping unit of measure.';
   COMMENT ON COLUMN "IDL_IC_ITEM_MAST"."STD_COST" IS 'Standard cost in base currency for the stock keeping unit of measure.';
   COMMENT ON COLUMN "IDL_IC_ITEM_MAST"."IC_CATEGORY_NM" IS 'The category associated with this product.';
   COMMENT ON COLUMN "IDL_IC_ITEM_MAST"."INTRO_DT" IS 'Introduction date.  The date the item became active.';
   COMMENT ON TABLE "IDL_IC_ITEM_MAST"  IS 'Interface table for minimal product definition.';
