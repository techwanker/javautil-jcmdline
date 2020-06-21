--------------------------------------------------------
--  DDL for Table FC_FCST_MDL
--------------------------------------------------------

  CREATE TABLE "FC_FCST_MDL" 
   (	"FC_FCST_MDL_NBR" NUMBER(3,0), 
	"CLASS_NAME" VARCHAR2(255), 
	"ALPHA_1" NUMBER(4,2), 
	"ALPHA_2" NUMBER(4,2), 
	"ALPHA_3" NUMBER(4,2), 
	"FCST_MDL_DESCR" VARCHAR2(60), 
	"MDL_INTVL_CNT_MIN" NUMBER(2,0), 
	"MDL_INTVL_CNT_MAX" NUMBER(2,0), 
	"MIN_NON_ZERO_INTVL_PREV_CYCLE" NUMBER(2,0), 
	"MDL_STAT_ID" VARCHAR2(1) DEFAULT 'A', 
	"MIN_SIM_CNT" NUMBER(2,0), 
	"TRACE_FLG" VARCHAR2(1) DEFAULT 'Y', 
	"IS_USER_DEFINED" VARCHAR2(1), 
	"SEASON_FLG" VARCHAR2(1), 
	"SHORT_FCST_MDL_DESCR" VARCHAR2(20), 
	"LONG_FCST_MDL_DESCR" VARCHAR2(60), 
	"MDL_INTVL_CNT" NUMBER(2,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
