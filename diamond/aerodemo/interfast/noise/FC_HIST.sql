--------------------------------------------------------
--  DDL for Table FC_HIST
--------------------------------------------------------

  CREATE TABLE "FC_HIST" 
   (	"FC_HIST_NBR" NUMBER(9,0), 
	"FC_ITEM_MAST_NBR" NUMBER(9,0), 
	"CYCLE" NUMBER(4,0), 
	"INTVL" NUMBER(4,0), 
	"DMD_ACT" NUMBER(9,2), 
	"DMD_ADJ" NUMBER(9,2)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 16777216 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;