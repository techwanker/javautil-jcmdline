--------------------------------------------------------
--  DDL for Table NA_ORG_ATTR_VAL
--------------------------------------------------------

  CREATE TABLE "NA_ORG_ATTR_VAL" 
   (	"NA_ORG_ATTR_MAST_NBR" NUMBER(9,0), 
	"ATTR_VAL" VARCHAR2(200), 
	"ATTR_VAL_DESCR" VARCHAR2(60), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;