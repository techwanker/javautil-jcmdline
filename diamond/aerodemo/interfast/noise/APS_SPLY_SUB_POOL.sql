--------------------------------------------------------
--  DDL for Table APS_SPLY_SUB_POOL
--------------------------------------------------------

  CREATE TABLE "APS_SPLY_SUB_POOL" 
   (	"APS_SPLY_SUB_POOL_NBR" NUMBER(9,0), 
	"APS_SPLY_POOL_CD" VARCHAR2(20), 
	"APS_SPLY_SUB_POOL_CD" VARCHAR2(20), 
	"SPLY_POOL_TYPE_ID" VARCHAR2(1), 
	"APS_SPLY_SUB_POOL_DESCR" VARCHAR2(60), 
	"ORG_NBR_VND" NUMBER(9,0), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"APS_SPLY_SUB_POOL_STAT_ID" VARCHAR2(1) DEFAULT 'A', 
	"AVAIL_FLG" VARCHAR2(1) DEFAULT 'Y'
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
