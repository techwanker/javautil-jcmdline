--------------------------------------------------------
--  DDL for Table WH_PICK_BATCH_WO
--------------------------------------------------------

  CREATE TABLE "WH_PICK_BATCH_WO" 
   (	"WH_PICK_BATCH_WO_NBR" NUMBER(9,0), 
	"UT_USER_NBR_ASSIGN" NUMBER(9,0), 
	"WH_PICK_BATCH_CREATE_TM" DATE, 
	"WH_PICK_BATCH_START_TM" DATE, 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"WH_PICK_RULE_WO_CD" VARCHAR2(16), 
	"WO_BATCH_PRTY" NUMBER(3,0) DEFAULT 500, 
	"WO_BATCH_STAT_ID" VARCHAR2(1) DEFAULT 'Q', 
	"SERVICE_RQST_NBR" NUMBER(9,0), 
	"NEED_BOX_CD_DEST_LBL" VARCHAR2(1) DEFAULT 'N', 
	"BOX_CD_DEST_LBL_PRINT_FLG" VARCHAR2(1) DEFAULT 'N', 
	"FACILITY" VARCHAR2(16)
   ) ;