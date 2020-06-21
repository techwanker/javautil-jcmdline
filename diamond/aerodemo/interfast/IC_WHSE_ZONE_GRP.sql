--------------------------------------------------------
--  DDL for Table IC_WHSE_ZONE_GRP
--------------------------------------------------------

  CREATE TABLE "IC_WHSE_ZONE_GRP" 
   (	"IC_WHSE_ZONE_GRP_NBR" NUMBER(9,0), 
	"FACILITY" VARCHAR2(16), 
	"WHSE_ZONE_GRP" VARCHAR2(8), 
	"WHSE_ZONE_GRP_DESCR" VARCHAR2(60), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"WH_PICK_RULE_CD" VARCHAR2(16), 
	"LINE_CNT_TARGET" NUMBER(5,0), 
	"LINE_CNT_MAX" NUMBER(5,0)
   ) ;
