--------------------------------------------------------
--  DDL for Table PO_REQUISITION_BAK2
--------------------------------------------------------

  CREATE TABLE "PO_REQUISITION_BAK2" 
   (	"ITEM_NBR" NUMBER(9,0), 
	"NEED_BY_DT" DATE, 
	"NEED_QTY" NUMBER(17,5), 
	"FACILITY" VARCHAR2(16)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 1048576 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;