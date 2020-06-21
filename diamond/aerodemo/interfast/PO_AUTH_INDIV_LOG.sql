--------------------------------------------------------
--  DDL for Table PO_AUTH_INDIV_LOG
--------------------------------------------------------

  CREATE TABLE "PO_AUTH_INDIV_LOG" 
   (	"INDIV_NBR" NUMBER(9,0), 
	"INDIV_AMT_AUTH_OLD" NUMBER(13,2), 
	"INDIV_AMT_AUTH_NEW" NUMBER(13,2), 
	"MOD_ACTION" VARCHAR2(6), 
	"UT_USER_NBR_MOD" NUMBER(9,0), 
	"LAST_MOD_TM" DATE
   ) ;
