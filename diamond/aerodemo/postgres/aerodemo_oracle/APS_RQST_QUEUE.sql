--------------------------------------------------------
--  DDL for Table APS_RQST_QUEUE
--------------------------------------------------------

  CREATE TABLE "INTERFAST"."APS_RQST_QUEUE" 
   (	"ITEM_NBR" NUMBER(9,0), 
	"DMD_OO_FLG" VARCHAR2(1 BYTE), 
	"DMD_FC_FLG" VARCHAR2(1 BYTE), 
	"DMD_WO_FLG" VARCHAR2(1 BYTE), 
	"SPLY_OH_FLG" VARCHAR2(1 BYTE), 
	"SPLY_PO_FLG" VARCHAR2(1 BYTE), 
	"SPLY_WO_FLG" VARCHAR2(1 BYTE), 
	"RQST_TM" DATE DEFAULT sysdate, 
	"APS_EXCEPTION" VARCHAR2(2048 BYTE), 
	"ITEM_PRTY" NUMBER(1,0) DEFAULT 9, 
	"DISPATCH_TM" DATE, 
	"RQST_SRC" VARCHAR2(61 BYTE) DEFAULT 'UNKNOWN'
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  STORAGE(INITIAL 3145728 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;