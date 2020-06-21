--------------------------------------------------------
--  DDL for Table PO_VND_MAST
--------------------------------------------------------

  CREATE TABLE "PO_VND_MAST" 
   (	"ORG_NBR_VND" NUMBER(9,0), 
	"STAT_ID" VARCHAR2(1), 
	"BUY_INDIV_NBR" NUMBER(9,0), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"TRD_FLG" VARCHAR2(1), 
	"TRD_GL_ACCT" VARCHAR2(20), 
	"INTRO_DT" DATE, 
	"MAIL_TO_ADDR_NBR_DFLT" NUMBER(9,0), 
	"BILL_TO_ADDR_NBR_DFLT" NUMBER(9,0), 
	"TERM_CD_DFLT" VARCHAR2(10), 
	"SHIP_VIA_CD_DFLT" VARCHAR2(8), 
	"FOB_CD_DFLT" VARCHAR2(8), 
	"CURR_CD_DFLT" VARCHAR2(3), 
	"REPLEN_ALLOW_FLG" VARCHAR2(1), 
	"RECEIVE_ALLOW_FLG" VARCHAR2(1), 
	"ALLOC_SLIP_DY" NUMBER(5,0), 
	"INDIV_NBR_VND_CONTACT" NUMBER(9,0), 
	"WORK_ORDER_RPT_NM" VARCHAR2(255), 
	"VND_EIN_CD" VARCHAR2(20)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 2097152 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
