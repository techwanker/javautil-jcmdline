--------------------------------------------------------
--  DDL for Table IDL_MFR_MFG_CAP
--------------------------------------------------------

  CREATE TABLE "IDL_MFR_MFG_CAP" 
   (	"IDL_MFR_MFG_CAP_NBR" NUMBER(9,0), 
	"ORG_CD_MFR" VARCHAR2(16), 
	"DAILY_CAP" NUMBER, 
	"IC_CATEGORY_NM" VARCHAR2(16)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;

   COMMENT ON COLUMN "IDL_MFR_MFG_CAP"."IDL_MFR_MFG_CAP_NBR" IS 'Surrogate key for internal purposes.';
   COMMENT ON COLUMN "IDL_MFR_MFG_CAP"."ORG_CD_MFR" IS 'Identifier for the manufacturer.';
   COMMENT ON COLUMN "IDL_MFR_MFG_CAP"."DAILY_CAP" IS 'Daily capacity of this manufacturer for this product category.';
   COMMENT ON COLUMN "IDL_MFR_MFG_CAP"."IC_CATEGORY_NM" IS 'The category associated with the capacity for this manufacturer.';
   COMMENT ON TABLE "IDL_MFR_MFG_CAP"  IS 'Interface table for manufacturing capacity constraints.';
