--------------------------------------------------------
--  DDL for Table WH_CONTAINER
--------------------------------------------------------

  CREATE TABLE "WH_CONTAINER" 
   (	"WH_CONTAINER_NBR" NUMBER(9,0), 
	"WH_CONTAINER_NM" VARCHAR2(20), 
	"WH_CONTAINER_NBR_PARENT" NUMBER(9,0), 
	"BIN_NBR_PLACED_IN" NUMBER(9,0), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
