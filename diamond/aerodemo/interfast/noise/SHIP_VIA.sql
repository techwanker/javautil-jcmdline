--------------------------------------------------------
--  DDL for Table SHIP_VIA
--------------------------------------------------------

  CREATE TABLE "SHIP_VIA" 
   (	"SHIP_VIA_CD" VARCHAR2(8), 
	"SHIP_VIA_DESCR" VARCHAR2(60), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"WAYBILL_FLG" VARCHAR2(1) DEFAULT 'Y', 
	"SHIP_VIA_STAT_ID" VARCHAR2(1) DEFAULT 'A', 
	"ORG_NBR_SHIP_VIA" NUMBER(9,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
