--------------------------------------------------------
--  DDL for Table IC_ITEM_REV_LVL
--------------------------------------------------------

  CREATE TABLE "IC_ITEM_REV_LVL" 
   (	"ITEM_NBR" NUMBER(9,0), 
	"REV_LVL" VARCHAR2(5), 
	"REV_LVL_EFF_DT" DATE, 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 2097152 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;