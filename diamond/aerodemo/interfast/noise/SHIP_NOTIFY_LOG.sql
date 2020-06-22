--------------------------------------------------------
--  DDL for Table SHIP_NOTIFY_LOG
--------------------------------------------------------

  CREATE TABLE "SHIP_NOTIFY_LOG" 
   (	"LOG_NBR" NUMBER, 
	"NOTIFY_EMAIL_ADDR" VARCHAR2(200), 
	"SHIP_DT" DATE, 
	"LOG_DT" DATE DEFAULT sysdate, 
	"ORG_NBR_CUST" NUMBER, 
	"EXPIRY_DT" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 196608 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;