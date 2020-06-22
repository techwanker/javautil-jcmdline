--------------------------------------------------------
--  DDL for Table IC_ITEM_VND_COST_MATRIX
--------------------------------------------------------

  CREATE TABLE "IC_ITEM_VND_COST_MATRIX" 
   (	"ITEM_NBR" NUMBER(9,0), 
	"ORG_NBR_VND" NUMBER(9,0), 
	"PKG_QTY" NUMBER(7,0), 
	"QTY_ORD" NUMBER(13,5), 
	"UNIT_COST" NUMBER(17,6), 
	"UNIT_COST_CURR_CD" VARCHAR2(3), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 2097152 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;