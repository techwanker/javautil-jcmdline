--------------------------------------------------------
--  DDL for Table WH_PICK_RULE_WO
--------------------------------------------------------

  CREATE TABLE "WH_PICK_RULE_WO" 
   (	"WH_PICK_RULE_WO_CD" VARCHAR2(16), 
	"PICK_RULE_FACILITY" VARCHAR2(16), 
	"LINE_CNT_TARGET" NUMBER(5,0), 
	"LINE_CNT_MAX" NUMBER(5,0), 
	"PICK_RULE_WHSE_ZONE_GRP_NBR" NUMBER(9,0), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) ;
