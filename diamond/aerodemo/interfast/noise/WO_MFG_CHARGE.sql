--------------------------------------------------------
--  DDL for Table WO_MFG_CHARGE
--------------------------------------------------------

  CREATE TABLE "WO_MFG_CHARGE" 
   (	"WO_MFG_CHARGE_CD" VARCHAR2(8), 
	"WO_MFG_CHARGE_DESCR" VARCHAR2(60), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"WO_MFG_CHARGE_CD_STAT_ID" VARCHAR2(1) DEFAULT 'A'
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
