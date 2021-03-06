--------------------------------------------------------
--  DDL for Table IC_VND_ONHAND
--------------------------------------------------------

  CREATE TABLE "IC_VND_ONHAND" 
   (	"IC_VND_ONHAND_NBR" NUMBER(9,0), 
	"ITEM_NBR" NUMBER(9,0), 
	"ITEM_CD_VND" VARCHAR2(50), 
	"ORG_NBR_VND" NUMBER(9,0), 
	"LOAD_DT" DATE, 
	"QTY_ON_HAND" NUMBER(13,5), 
	"STK_UM" VARCHAR2(3), 
	"UNIT_PRICE" NUMBER(17,6)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 67108864 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
