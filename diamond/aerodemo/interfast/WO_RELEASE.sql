--------------------------------------------------------
--  DDL for Table WO_RELEASE
--------------------------------------------------------

  CREATE TABLE "WO_RELEASE" 
   (	"WO_RELEASE_NBR" NUMBER(9,0), 
	"WO_HDR_NBR" NUMBER(9,0), 
	"QTY_RELEASE" NUMBER(7,0), 
	"RELEASE_STAT_ID" VARCHAR2(1), 
	"QTY_FILL" NUMBER(7,0), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"RELEASE_FILL_DT" DATE
   ) ;
