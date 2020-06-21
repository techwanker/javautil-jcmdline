--------------------------------------------------------
--  DDL for Table AGING_INVT_SHIP_VAL
--------------------------------------------------------

  CREATE TABLE "INTERFAST"."AGING_INVT_SHIP_VAL" 
   (	"PRODUCT_CODE" VARCHAR2(16 BYTE), 
	"SOLD_COST_BEFORE_SEP_2002" NUMBER, 
	"SOLD_PRICE_BEFORE_SEP_2002" NUMBER, 
	"SOLD_COST_RCVD_IN_2003" NUMBER, 
	"SOLD_PRICE_RCVD_IN_2003" NUMBER, 
	"SOLD_COST_RCVD_IN_2004" NUMBER, 
	"SOLD_PRICE_RCVD_IN_2004" NUMBER, 
	"SOLD_COST_RCVD_IN_2005" NUMBER, 
	"SOLD_PRICE_RCVD_IN_2005" NUMBER, 
	"SOLD_COST_RCVD_IN_2006" NUMBER, 
	"SOLD_PRICE_RCVD_IN_2006" NUMBER, 
	"SOLD_COST_RCVD_IN_2007" NUMBER, 
	"SOLD_PRICE_RCVD_IN_2007" NUMBER, 
	"SOLD_COST_RCVD_IN_2008" NUMBER, 
	"SOLD_PRICE_RCVD_IN_2008" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 1048576 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
