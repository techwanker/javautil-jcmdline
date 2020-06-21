--------------------------------------------------------
--  DDL for Table IC_UM
--------------------------------------------------------

  CREATE TABLE "IC_UM" 
   (	"UM_ID" VARCHAR2(3), 
	"UM_ID_DESCR" VARCHAR2(30), 
	"UM_FAMILY" VARCHAR2(8), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"UM_PRECISION" NUMBER(1,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
