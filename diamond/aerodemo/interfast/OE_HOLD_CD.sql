--------------------------------------------------------
--  DDL for Table OE_HOLD_CD
--------------------------------------------------------

  CREATE TABLE "OE_HOLD_CD" 
   (	"HOLD_NBR" NUMBER(9,0), 
	"HOLD_CD" VARCHAR2(3), 
	"HOLD_CD_DESCR" VARCHAR2(80), 
	"AUTO_HOLD_FLG" VARCHAR2(1), 
	"USER_DEF_HOLD_FLG" VARCHAR2(1), 
	"SUPPRESS_HOLD_FLG" VARCHAR2(1), 
	"ALLOW_RELEASE_FLG" VARCHAR2(1), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"NEED_AUTH_TO_RELEASE_FLG" VARCHAR2(1) DEFAULT 'Y', 
	"REL_INCREMENT_FLG" VARCHAR2(1)
   ) ;
