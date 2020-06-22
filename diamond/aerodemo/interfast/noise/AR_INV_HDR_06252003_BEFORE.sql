--------------------------------------------------------
--  DDL for Table AR_INV_HDR_06252003_BEFORE
--------------------------------------------------------

  CREATE TABLE "AR_INV_HDR_06252003_BEFORE" 
   (	"INV_CD" VARCHAR2(20), 
	"INV_DT" DATE, 
	"INV_STAT_ID" VARCHAR2(1), 
	"ORG_NBR_CUST" NUMBER(9,0), 
	"ORG_NM_CUST" VARCHAR2(60), 
	"OE_ORD_HDR_NBR" NUMBER(9,0), 
	"ORD_CD" VARCHAR2(20), 
	"CUST_PO_CD" VARCHAR2(30), 
	"CURR_CD" VARCHAR2(3), 
	"SHIP_DT" DATE, 
	"BILL_TO_ADDR_NBR" NUMBER(9,0), 
	"BILL_TO_ADDR_CD" VARCHAR2(8), 
	"BILL_TO_ADDR_DESCR" VARCHAR2(60), 
	"BILL_TO_ADDR_1" VARCHAR2(30), 
	"BILL_TO_ADDR_2" VARCHAR2(30), 
	"BILL_TO_ADDR_3" VARCHAR2(30), 
	"BILL_TO_CITY" VARCHAR2(25), 
	"BILL_TO_STATE_CD" VARCHAR2(5), 
	"BILL_TO_POSTAL_CD" VARCHAR2(10), 
	"BILL_TO_CNTRY_CD" VARCHAR2(3), 
	"SHIP_TO_ADDR_NBR" NUMBER(9,0), 
	"SHIP_TO_ADDR_CD" VARCHAR2(8), 
	"SHIP_TO_ADDR_DESCR" VARCHAR2(60), 
	"SHIP_TO_ADDR_1" VARCHAR2(30), 
	"SHIP_TO_ADDR_2" VARCHAR2(30), 
	"SHIP_TO_ADDR_3" VARCHAR2(30), 
	"SHIP_TO_CITY" VARCHAR2(25), 
	"SHIP_TO_STATE_CD" VARCHAR2(5), 
	"SHIP_TO_POSTAL_CD" VARCHAR2(10), 
	"SHIP_TO_CNTRY_CD" VARCHAR2(3), 
	"SHIP_VIA_CD" VARCHAR2(8), 
	"TERM_CD" VARCHAR2(10), 
	"GROSS_INV_VALUE" NUMBER(17,5), 
	"WGHT" NUMBER(10,3), 
	"CTN_CNT" NUMBER(7,0), 
	"FRGT_CHARGE" NUMBER(11,2), 
	"NET_INV_VALUE" NUMBER(17,5), 
	"WAYBILL_CD" VARCHAR2(20), 
	"TRD_FLG" VARCHAR2(1), 
	"AR_INV_BATCH_NBR" NUMBER(9,0), 
	"FOB_CD" VARCHAR2(8), 
	"ORG_CD_CUST" VARCHAR2(15), 
	"SALES_TERR_CD" VARCHAR2(8), 
	"SELL_INDIV_NBR" NUMBER(9,0), 
	"AR_SUMMARY_INV_NBR" NUMBER(9,0), 
	"GL_TAX_GRP_NBR" NUMBER(9,0), 
	"PRINT_FLG" VARCHAR2(1), 
	"INV_PRINT_DT_ORIG" DATE, 
	"INV_PRINT_DT_LAST" DATE, 
	"UT_USER_NBR_PRINT" NUMBER(9,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;