--------------------------------------------------------
--  DDL for Table WH_PICK_RULE_COP
--------------------------------------------------------

  CREATE TABLE "WH_PICK_RULE_COP" 
   (	"WH_PICK_RULE_COP_CD" VARCHAR2(16), 
	"PICK_RULE_FACILITY" VARCHAR2(16), 
	"PICK_RULE_WHSE_ZONE_GRP_NBR" NUMBER(9,0), 
	"LINE_CNT_TARGET" NUMBER(5,0), 
	"LINE_CNT_MAX" NUMBER(5,0), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) ;