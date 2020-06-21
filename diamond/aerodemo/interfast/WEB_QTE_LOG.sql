--------------------------------------------------------
--  DDL for Table WEB_QTE_LOG
--------------------------------------------------------

  CREATE TABLE "WEB_QTE_LOG" 
   (	"SQ_QTE_HDR_NBR" NUMBER, 
	"QTE_DT" DATE, 
	"ACTION_FLG" VARCHAR2(1) DEFAULT 'N', 
	"UT_USER_NBR" NUMBER, 
	"LAST_MOD_DT" DATE
   ) ;
