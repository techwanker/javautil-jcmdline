--------------------------------------------------------
--  DDL for Table WH_PICK_BATCH_COP
--------------------------------------------------------

  CREATE TABLE "WH_PICK_BATCH_COP" 
   (	"WH_PICK_BATCH_COP_NBR" NUMBER(9,0), 
	"WH_PICK_RULE_COP_CD" VARCHAR2(16), 
	"UT_USER_NBR_ASSIGN" NUMBER(9,0), 
	"WH_PICK_BATCH_CREATE_TM" DATE, 
	"WH_PICK_BATCH_START_TM" DATE, 
	"COP_PICK_BATCH_PRTY" NUMBER(3,0), 
	"COP_BATCH_STAT_ID" VARCHAR2(1) DEFAULT 'Q', 
	"SERVICE_RQST_NBR" NUMBER(9,0), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"NEED_BOX_CD_DEST_LBL" VARCHAR2(1) DEFAULT 'N', 
	"BOX_CD_DEST_LBL_PRINT_FLG" VARCHAR2(1) DEFAULT 'N', 
	"FACILITY" VARCHAR2(16)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 2097152 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
