--------------------------------------------------------
--  DDL for Table UT_FACILITY_PRINTER
--------------------------------------------------------

  CREATE TABLE "UT_FACILITY_PRINTER" 
   (	"FACILITY" VARCHAR2(16), 
	"PRINTER" VARCHAR2(50), 
	"PRINTER_MODEL" VARCHAR2(30), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"IP_ADDRESS" VARCHAR2(20), 
	"IP_PROTOCOL" VARCHAR2(255), 
	"IP_PORT" VARCHAR2(10), 
	"QUEUE_NM" VARCHAR2(10)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
