--------------------------------------------------------
--  DDL for Table NA_INDIV_ADDR
--------------------------------------------------------

  CREATE TABLE "NA_INDIV_ADDR" 
   (	"ADDR_NBR" NUMBER(9,0), 
	"INDIV_NBR" NUMBER(9,0), 
	"ADDR_TYPE_ID" VARCHAR2(4), 
	"ADDR_1" VARCHAR2(30), 
	"ADDR_2" VARCHAR2(30), 
	"ADDR_3" VARCHAR2(30), 
	"CITY" VARCHAR2(25), 
	"STATE_CD" VARCHAR2(5), 
	"CNTRY_CD" VARCHAR2(3), 
	"CNTRY_MAIL_CD" VARCHAR2(10), 
	"ADDR_CD" VARCHAR2(8), 
	"ADDR_DESCR" VARCHAR2(30), 
	"ROLE_NM" VARCHAR2(30), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"POSTAL_CD" VARCHAR2(10), 
	"ADDR_ACTIVE_ID" VARCHAR2(1)
   ) ;