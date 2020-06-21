--------------------------------------------------------
--  DDL for Table OE_CLOSE_REASON
--------------------------------------------------------

  CREATE TABLE "OE_CLOSE_REASON" 
   (	"OE_CLOSE_REASON_CD" VARCHAR2(8), 
	"OE_CLOSE_REASON_DESCR" VARCHAR2(60), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_TM" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
