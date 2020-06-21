--------------------------------------------------------
--  DDL for Table OE_HOLD_CD_LOG
--------------------------------------------------------

  CREATE TABLE "OE_HOLD_CD_LOG" 
   (	"HOLD_NBR" NUMBER(9,0), 
	"HOLD_CD" VARCHAR2(3), 
	"HOLD_CD_DESCR" VARCHAR2(80), 
	"AUTO_HOLD_FLG" VARCHAR2(1), 
	"USER_DEF_HOLD_FLG" VARCHAR2(1), 
	"SUPPRESS_HOLD_FLG" VARCHAR2(1), 
	"ALLOW_RELEASE_FLG" VARCHAR2(1), 
	"NEED_AUTH_TO_RELEASE_FLG" VARCHAR2(1), 
	"MOD_ACTION" VARCHAR2(6), 
	"UT_USER_NBR_MOD" NUMBER(9,0), 
	"MOD_TM" DATE
   ) ;
