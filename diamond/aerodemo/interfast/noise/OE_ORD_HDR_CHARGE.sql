--------------------------------------------------------
--  DDL for Table OE_ORD_HDR_CHARGE
--------------------------------------------------------

  CREATE TABLE "OE_ORD_HDR_CHARGE" 
   (	"OE_ORD_HDR_NBR" NUMBER(9,0), 
	"CHARGE_CD" VARCHAR2(10), 
	"CHARGE_AMT" NUMBER(10,2), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"RECUR_FLG" VARCHAR2(1) DEFAULT 'N', 
	"AR_INV_HDR_CHARGE_NBR" NUMBER(9,0), 
	"TAXABLE_FLG" VARCHAR2(1) DEFAULT 'N', 
	"CHARGE_AMT_DENOM" NUMBER(10,2)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 196608 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
