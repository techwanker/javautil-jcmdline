--------------------------------------------------------
--  DDL for Table UT_COLUMN
--------------------------------------------------------

  CREATE TABLE "UT_COLUMN" 
   (	"COLUMN_NM" VARCHAR2(30), 
	"COLUMN_COMMENT" VARCHAR2(1024), 
	"COLUMN_COMMENT_HTML" VARCHAR2(1024)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 131072 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;