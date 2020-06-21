--------------------------------------------------------
--  DDL for Table NA_ORG_ATTR
--------------------------------------------------------

  CREATE TABLE "NA_ORG_ATTR" 
   (	"ORG_NBR" NUMBER(9,0), 
	"NA_ORG_ATTR_MAST_NBR" NUMBER(9,0), 
	"ATTR_VAL" VARCHAR2(200), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 2097152 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
