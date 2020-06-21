--------------------------------------------------------
--  DDL for Table SQ_QTE_TEST
--------------------------------------------------------

  CREATE TABLE "SQ_QTE_TEST" 
   (	"ORG_CD" VARCHAR2(15), 
	"ORG_NM" VARCHAR2(60), 
	"CURR_CD_QTE" VARCHAR2(9), 
	"SQ_QTE_CD" VARCHAR2(20), 
	"SQ_QTE_DT" DATE, 
	"ITEM_CD_QTE" VARCHAR2(50), 
	"LEAD_TM_WK_PROM" NUMBER(3,0), 
	"QTE_QTY" NUMBER(13,5), 
	"QTE_PRICE_DENOM" NUMBER(17,6)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 1048576 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
