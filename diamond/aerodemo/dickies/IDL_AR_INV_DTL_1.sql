--------------------------------------------------------
--  DDL for Table IDL_AR_INV_DTL
--------------------------------------------------------

  CREATE TABLE "IDL_AR_INV_DTL" 
   (	"AR_INV_DTL_NBR" NUMBER(9,0), 
	"INV_CD" VARCHAR2(16), 
	"ORD_CD" VARCHAR2(16), 
	"ORD_TYPE_CD" VARCHAR2(3), 
	"ORG_CD_CUST" VARCHAR2(16), 
	"CUST_PO_CD" VARCHAR2(16), 
	"TERM_CD" VARCHAR2(8), 
	"SHIP_VIA_CD" VARCHAR2(8), 
	"FOB_CD" VARCHAR2(8), 
	"CURR_CD" VARCHAR2(3), 
	"SALES_TERR_CD" VARCHAR2(8), 
	"INV_LINE_NBR" NUMBER(5,0), 
	"ORD_LINE_NBR" NUMBER(5,0), 
	"ITEM_CD_SHIP" VARCHAR2(32), 
	"ITEM_CD_CUST" VARCHAR2(32), 
	"QTY_SHIP" NUMBER(17,5), 
	"UNIT_PRICE_DENOM" NUMBER(17,5), 
	"SELL_UM" VARCHAR2(3), 
	"SHIP_FROM_FACILITY" VARCHAR2(8), 
	"INV_DT" DATE, 
	"SHIP_DT" DATE, 
	"RQST_DT" DATE, 
	"PROM_DT" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
