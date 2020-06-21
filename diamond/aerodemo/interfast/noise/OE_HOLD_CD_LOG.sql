--------------------------------------------------------
--  DDL for Table OE_HOLD_CD_LOG
--------------------------------------------------------

  CREATE TABLE "OE_HOLD_CD_LOG" 
   (	"HOLD_NBR" NUMBER(9,0), 
	"HOLD_CD" VARCHAR2(3), 
	"HOLD_CD_DESCR" VARCHAR2(80), 
	"AUTO_HOLD_FLG" VARCHAR2(1), 
	"USER_DEF_HOLD_FLG" VARCHAR2(1), 
	"SUPPRESS_HOLD_FLG" VARCHAR2(1), 
	"ALLOW_RELEASE_FLG" VARCHAR2(1), 
	"NEED_AUTH_TO_RELEASE_FLG" VARCHAR2(1), 
	"MOD_ACTION" VARCHAR2(6), 
	"UT_USER_NBR_MOD" NUMBER(9,0), 
	"MOD_TM" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
