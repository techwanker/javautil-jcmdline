--------------------------------------------------------
--  DDL for Table PO_LINE_CHARGE
--------------------------------------------------------

  CREATE TABLE "PO_LINE_CHARGE" 
   (	"PO_LINE_HDR_NBR" NUMBER(9,0), 
	"CHARGE_CD" VARCHAR2(10), 
	"CHARGE_AMT" NUMBER(10,2), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"CHARGE_AMT_DENOM" NUMBER(17,5), 
	"RECUR_FLG" VARCHAR2(1), 
	"TAXABLE_FLG" VARCHAR2(1) DEFAULT 'N', 
	"AP_INV_DTL_CHARGE_NBR" NUMBER(9,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 131072 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
