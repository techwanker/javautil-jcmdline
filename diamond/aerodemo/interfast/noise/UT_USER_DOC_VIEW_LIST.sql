--------------------------------------------------------
--  DDL for Table UT_USER_DOC_VIEW_LIST
--------------------------------------------------------

  CREATE TABLE "UT_USER_DOC_VIEW_LIST" 
   (	"UT_USER_NBR" NUMBER, 
	"DOC_TYPE_ID" VARCHAR2(1), 
	"DOC_KEY" VARCHAR2(20)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
