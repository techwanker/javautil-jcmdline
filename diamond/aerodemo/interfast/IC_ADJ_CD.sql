--------------------------------------------------------
--  DDL for Table IC_ADJ_CD
--------------------------------------------------------

  CREATE TABLE "IC_ADJ_CD" 
   (	"ADJ_CD" VARCHAR2(8), 
	"ADJ_CD_DESCR" VARCHAR2(60), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"INCR_DECR_ID" VARCHAR2(1), 
	"ADJ_CD_STAT_ID" VARCHAR2(1) DEFAULT 'A'
   ) ;
