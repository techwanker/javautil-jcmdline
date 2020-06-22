--------------------------------------------------------
--  DDL for Table SALES_CALL_SUMMARY
--------------------------------------------------------

  CREATE TABLE "SALES_CALL_SUMMARY" 
   (	"SALES_CALL_DTL_NBR" NUMBER(9,0), 
	"SUMMARY" VARCHAR2(2048)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;