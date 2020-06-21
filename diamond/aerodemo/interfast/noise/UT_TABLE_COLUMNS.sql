--------------------------------------------------------
--  DDL for Table UT_TABLE_COLUMNS
--------------------------------------------------------

  CREATE TABLE "UT_TABLE_COLUMNS" 
   (	"TABLE_ID" VARCHAR2(8), 
	"COLUMN_NM" VARCHAR2(30), 
	"COLUMN_COMMENTS" VARCHAR2(1024)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
