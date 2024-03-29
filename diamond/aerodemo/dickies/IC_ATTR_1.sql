--------------------------------------------------------
--  DDL for Table IC_ATTR
--------------------------------------------------------

  CREATE TABLE "IC_ATTR" 
   (	"IC_ATTR_NBR" NUMBER(9,0), 
	"ATTR_NM" VARCHAR2(16), 
	"ATTR_DESCR" VARCHAR2(60), 
	"ATTR_SEQ" NUMBER(3,0), 
	"REQR_FLG" VARCHAR2(1), 
	"ATTR_CONSTR_FLG" VARCHAR2(1), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;

   COMMENT ON COLUMN "IC_ATTR"."IC_ATTR_NBR" IS 'Surrogate primary key for IC_ATTR_NBR';
   COMMENT ON COLUMN "IC_ATTR"."ATTR_NM" IS 'Attribute name.';
   COMMENT ON COLUMN "IC_ATTR"."ATTR_DESCR" IS 'Attribute description.';
   COMMENT ON COLUMN "IC_ATTR"."ATTR_SEQ" IS 'Attribute sequence.  Affects the order in which the attribute is displayed on certain screens.';
   COMMENT ON COLUMN "IC_ATTR"."UT_USER_NBR" IS 'Surrogate primary key for UT_USER';
