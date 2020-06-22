--------------------------------------------------------
--  DDL for Table NA_ORG_ADDR
--------------------------------------------------------

  CREATE TABLE "NA_ORG_ADDR" 
   (	"ADDR_NBR" NUMBER(9,0), 
	"ORG_NBR" NUMBER(9,0), 
	"ADDR_TYPE_ID" VARCHAR2(4), 
	"ADDR_1" VARCHAR2(30), 
	"ADDR_2" VARCHAR2(30), 
	"ADDR_3" VARCHAR2(30), 
	"CITY" VARCHAR2(25), 
	"STATE_CD" VARCHAR2(5), 
	"CNTRY_CD" VARCHAR2(3), 
	"ADDR_CD" VARCHAR2(8), 
	"ADDR_DESCR" VARCHAR2(60), 
	"ROLE_NM" VARCHAR2(30), 
	"PICK_PRTY" NUMBER(3,0), 
	"PICK_PRTY_PAST_DUE_MULT" NUMBER(2,0), 
	"GL_TAX_GRP_NBR" NUMBER(9,0), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"POSTAL_CD" VARCHAR2(10), 
	"ADDR_ACTIVE_ID" VARCHAR2(1), 
	"APS_SRC_RULE_SET_NBR" NUMBER(9,0), 
	"CALENDAR" VARCHAR2(8), 
	"PHN_NBR_DFLT" VARCHAR2(20), 
	"FAX_NBR_DFLT" VARCHAR2(20), 
	"INDIV_NBR_CONTACT_DFLT" NUMBER(9,0), 
	"SHIP_VIA_CD_DFLT" VARCHAR2(8), 
	"WH_SHIP_PRTY_NBR_DFLT" NUMBER(5,0), 
	"PAYMENT_METHOD_CD_DFLT" VARCHAR2(3)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 16777216 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;