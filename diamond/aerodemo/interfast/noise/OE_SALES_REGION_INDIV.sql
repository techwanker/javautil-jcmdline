--------------------------------------------------------
--  DDL for Table OE_SALES_REGION_INDIV
--------------------------------------------------------

  CREATE TABLE "OE_SALES_REGION_INDIV" 
   (	"SALES_REGION_CD" VARCHAR2(8), 
	"INDIV_NBR" NUMBER(9,0), 
	"ORD_NOTIFY_THRESHOLD" NUMBER(7,0), 
	"QTE_NOTIFY_THRESHOLD" NUMBER(7,0), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_TM" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
