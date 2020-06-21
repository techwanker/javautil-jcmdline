--------------------------------------------------------
--  DDL for Table UT_NOTE
--------------------------------------------------------

  CREATE TABLE "UT_NOTE" 
   (	"NOTE_NBR" NUMBER(9,0), 
	"TABLE_ID" VARCHAR2(8), 
	"TABLE_KEY" NUMBER(9,0), 
	"NOTE" VARCHAR2(2048), 
	"UT_USER_NBR_ENTER" NUMBER(9,0), 
	"ENTRY_DT" DATE, 
	"ENTRY_TM" VARCHAR2(5), 
	"UT_USER_NBR_MOD" NUMBER(9,0), 
	"ACTION_DT" DATE, 
	"ACTION_FLG" VARCHAR2(1), 
	"LAST_MOD_DT" DATE, 
	"LAST_MOD_TM" VARCHAR2(7), 
	"NOTE_TYPE_CD" VARCHAR2(8)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 166723584 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
