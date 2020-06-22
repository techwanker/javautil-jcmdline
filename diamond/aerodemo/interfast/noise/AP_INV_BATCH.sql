--------------------------------------------------------
--  DDL for Table AP_INV_BATCH
--------------------------------------------------------

  CREATE TABLE "AP_INV_BATCH" 
   (	"AP_INV_BATCH_NBR" NUMBER(9,0), 
	"BATCH_POST_DT" DATE, 
	"UT_USER_NBR_POST" NUMBER(9,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 131072 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;