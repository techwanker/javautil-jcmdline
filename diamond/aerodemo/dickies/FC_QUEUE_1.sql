--------------------------------------------------------
--  DDL for Table FC_QUEUE
--------------------------------------------------------

  CREATE TABLE "FC_QUEUE" 
   (	"FC_ITEM_MAST_NBR" NUMBER(9,0), 
	"RQST_STAT_ID" VARCHAR2(1) DEFAULT 'Q'
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 589824 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
