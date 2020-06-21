--------------------------------------------------------
--  DDL for Table FC_ITEM_ATTR
--------------------------------------------------------

  CREATE TABLE "FC_ITEM_ATTR" 
   (	"FC_ITEM_MAST_NBR" NUMBER(9,0), 
	"FC_ATTR_NBR" NUMBER(9,0), 
	"ATTR_VAL" VARCHAR2(20)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 0 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
