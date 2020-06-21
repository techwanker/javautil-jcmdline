--------------------------------------------------------
--  DDL for Table FC_FCST
--------------------------------------------------------

  CREATE TABLE "FC_FCST" 
   (	"FC_FCST_NBR" NUMBER(9,0), 
	"FC_ITEM_MAST_NBR" NUMBER(9,0), 
	"CYCLE" NUMBER(4,0), 
	"INTVL" NUMBER(2,0), 
	"RAW_FCST" NUMBER(17,5), 
	"ADJ_FCST" NUMBER(17,5), 
	"FCST_CONSUMED_QTY" NUMBER(8,4), 
	"FC_ITEM_FCST_MDL_NBR" NUMBER(9,0), 
	"FCST_ALLOC_QTY" NUMBER(17,5), 
	"FC_FCST_DT" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 30408704 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
