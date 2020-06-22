--------------------------------------------------------
--  DDL for Table IC_CATEGORY
--------------------------------------------------------

  CREATE TABLE "IC_CATEGORY" 
   (	"IC_CATEGORY_NBR" NUMBER(9,0), 
	"IC_CATEGORY_NBR_PARENT" NUMBER(9,0), 
	"IC_CATEGORY_NM" VARCHAR2(16), 
	"IC_CATEGORY_DESCR" VARCHAR2(30), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"PO_VND_SET_HDR_NBR" NUMBER(9,0), 
	"IC_CATEGORY_COLLATE_NBR" NUMBER(4,0), 
	"PRINT_MFR_FLG" VARCHAR2(1)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;