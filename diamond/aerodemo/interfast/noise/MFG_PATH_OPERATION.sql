--------------------------------------------------------
--  DDL for Table MFG_PATH_OPERATION
--------------------------------------------------------

  CREATE TABLE "MFG_PATH_OPERATION" 
   (	"MFG_PATH_CD" VARCHAR2(16), 
	"OPERATION_CD" VARCHAR2(16), 
	"OPERATION_SEQ_NBR" NUMBER(3,0), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
