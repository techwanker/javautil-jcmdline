--------------------------------------------------------
--  DDL for Table DEMO_PRODUCT_INFO
--------------------------------------------------------

  CREATE TABLE "DEMO_PRODUCT_INFO" 
   (	"PRODUCT_ID" NUMBER, 
	"PRODUCT_NAME" VARCHAR2(50), 
	"PRODUCT_DESCRIPTION" VARCHAR2(2000), 
	"CATEGORY" VARCHAR2(30), 
	"PRODUCT_AVAIL" VARCHAR2(1), 
	"LIST_PRICE" NUMBER(8,2), 
	"IMAGE_ID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;