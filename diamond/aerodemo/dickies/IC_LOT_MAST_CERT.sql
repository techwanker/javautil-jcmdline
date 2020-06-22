--------------------------------------------------------
--  DDL for Table IC_LOT_MAST_CERT
--------------------------------------------------------

  CREATE TABLE "IC_LOT_MAST_CERT" 
   (	"LOT_NBR" NUMBER(9,0), 
	"CERT_CD" VARCHAR2(8), 
	"CERT_RCPT_DT" DATE, 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"CERT_STAT_ID" VARCHAR2(1), 
	 CONSTRAINT "SYS_IOT_TOP_54494" PRIMARY KEY ("LOT_NBR", "CERT_CD") ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  ORGANIZATION INDEX NOCOMPRESS PCTFREE 10 INITRANS 2 MAXTRANS 255 LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" 
 PCTTHRESHOLD 50;