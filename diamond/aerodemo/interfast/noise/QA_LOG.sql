--------------------------------------------------------
--  DDL for Table QA_LOG
--------------------------------------------------------

  CREATE TABLE "QA_LOG" 
   (	"QA_RUN_NBR" NUMBER(9,0), 
	"SEQ_NBR" NUMBER(5,0), 
	"ACTION_DESC" VARCHAR2(200), 
	"ACTION_LVL" NUMBER(3,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 209715200 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
