--------------------------------------------------------
--  DDL for Table IDL_IC_ITEM_ATTR
--------------------------------------------------------

  CREATE TABLE "IDL_IC_ITEM_ATTR" 
   (	"IDL_IC_ITEM_ATTR_NBR" NUMBER(9,0), 
	"ITEM_CD" VARCHAR2(50), 
	"ATTR_1" VARCHAR2(20), 
	"ATTR_2" VARCHAR2(20), 
	"ATTR_3" VARCHAR2(20), 
	"ATTR_4" VARCHAR2(20), 
	"ATTR_5" VARCHAR2(20), 
	"ATTR_6" VARCHAR2(20), 
	"ATTR_7" VARCHAR2(20), 
	"ATTR_8" VARCHAR2(20), 
	"ATTR_9" VARCHAR2(20), 
	"ATTR_10" VARCHAR2(20)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;

   COMMENT ON COLUMN "IDL_IC_ITEM_ATTR"."IDL_IC_ITEM_ATTR_NBR" IS 'Surrogate key for internal purposes.';
   COMMENT ON COLUMN "IDL_IC_ITEM_ATTR"."ITEM_CD" IS 'Product identifier.';
   COMMENT ON COLUMN "IDL_IC_ITEM_ATTR"."ATTR_1" IS 'Attribute value.';
   COMMENT ON COLUMN "IDL_IC_ITEM_ATTR"."ATTR_2" IS 'Attribute value.';
   COMMENT ON COLUMN "IDL_IC_ITEM_ATTR"."ATTR_3" IS 'Attribute value.';
   COMMENT ON COLUMN "IDL_IC_ITEM_ATTR"."ATTR_4" IS 'Attribute value.';
   COMMENT ON COLUMN "IDL_IC_ITEM_ATTR"."ATTR_5" IS 'Attribute value.';
   COMMENT ON COLUMN "IDL_IC_ITEM_ATTR"."ATTR_6" IS 'Attribute value.';
   COMMENT ON COLUMN "IDL_IC_ITEM_ATTR"."ATTR_7" IS 'Attribute value.';
   COMMENT ON COLUMN "IDL_IC_ITEM_ATTR"."ATTR_8" IS 'Attribute value.';
   COMMENT ON COLUMN "IDL_IC_ITEM_ATTR"."ATTR_9" IS 'Attribute value.';
   COMMENT ON COLUMN "IDL_IC_ITEM_ATTR"."ATTR_10" IS 'Attribute value.';
   COMMENT ON TABLE "IDL_IC_ITEM_ATTR"  IS 'System interface table defining product attributes. 
 
At least one attribute is required if a record is present, but each item master does not require an attribute. 
 
Related attributes should be kept in the same attribute "bucket".';
