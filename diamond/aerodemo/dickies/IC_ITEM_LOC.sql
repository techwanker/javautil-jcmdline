--------------------------------------------------------
--  DDL for Table IC_ITEM_LOC
--------------------------------------------------------

  CREATE TABLE "IC_ITEM_LOC" 
   (	"IC_ITEM_LOC_NBR" NUMBER(9,0), 
	"LOT_NBR" NUMBER(9,0), 
	"BIN_NBR" NUMBER(9,0), 
	"AVAIL_DT" DATE, 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"APS_SPLY_SUB_POOL_NBR" NUMBER(9,0), 
	"BOX_FIX_FLG" VARCHAR2(1) DEFAULT 'Y'
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 393216 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
