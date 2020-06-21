--------------------------------------------------------
--  DDL for Table UT_FACILITY
--------------------------------------------------------

  CREATE TABLE "UT_FACILITY" 
   (	"FACILITY" VARCHAR2(16), 
	"PRIMARY_ADDR_NBR" NUMBER(9,0), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"CALENDAR" VARCHAR2(6), 
	"FACILITY_STAT_ID" VARCHAR2(1) DEFAULT 'A', 
	"UT_FACILITY_NBR" NUMBER(9,0)
   ) ;
