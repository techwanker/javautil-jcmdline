--------------------------------------------------------
--  DDL for Table TD_TASK
--------------------------------------------------------

  CREATE TABLE "TD_TASK" 
   (	"TD_TASK_NBR" NUMBER(9,0), 
	"DESCR" VARCHAR2(60), 
	"DUE_DT" DATE, 
	"COMPLETE_DT" DATE, 
	"STATUS_CD" VARCHAR2(4), 
	"WHO_RESPONSIBLE" VARCHAR2(4)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;