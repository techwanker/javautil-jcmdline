--------------------------------------------------------
--  DDL for Table UPC_ITEMS
--------------------------------------------------------

  CREATE TABLE "UPC_ITEMS" 
   (	"ITEM_NBR" NUMBER(9,0), 
	"ITEM_CD" VARCHAR2(50), 
	"SHIP_LINE_CNT" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;