--------------------------------------------------------
--  DDL for Table PO_LINE_MULTIPLE_CERT
--------------------------------------------------------

  CREATE TABLE "PO_LINE_MULTIPLE_CERT" 
   (	"PO_LINE_HDR_NBR" NUMBER(9,0), 
	"ITEM_NBR" NUMBER(9,0), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	 CONSTRAINT "PO_LINE_MULTIPLE_CERT_PPK" PRIMARY KEY ("ITEM_NBR", "PO_LINE_HDR_NBR") ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  ORGANIZATION INDEX NOCOMPRESS PCTFREE 10 INITRANS 2 MAXTRANS 255 LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" 
 PCTTHRESHOLD 50;
