--------------------------------------------------------
--  DDL for Table IC_ATTR_VAL
--------------------------------------------------------

  CREATE TABLE "IC_ATTR_VAL" 
   (	"IC_ATTR_NBR" NUMBER(9,0), 
	"ATTR_VAL" VARCHAR2(20), 
	"ATTR_VAL_DESCR" VARCHAR2(60), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"SORT_SEQ" NUMBER(3,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;

   COMMENT ON COLUMN "IC_ATTR_VAL"."IC_ATTR_NBR" IS 'Surrogate primary key for IC_ATTR_NBR';
   COMMENT ON COLUMN "IC_ATTR_VAL"."ATTR_VAL" IS 'Attribute value.';
   COMMENT ON COLUMN "IC_ATTR_VAL"."UT_USER_NBR" IS 'Surrogate primary key for UT_USER';
