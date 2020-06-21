--------------------------------------------------------
--  DDL for Table SHIP_NOTIFY_ERROR
--------------------------------------------------------

  CREATE TABLE "SHIP_NOTIFY_ERROR" 
   (	"ORG_NBR_CUST" NUMBER, 
	"NOTIFY_EMAIL_ADDR" VARCHAR2(200), 
	"SHIP_DT" DATE, 
	"ERROR_MSG" VARCHAR2(2000), 
	"ERROR_DT" DATE DEFAULT SYSDATE, 
	"UT_USER_NBR" NUMBER, 
	"COMM" VARCHAR2(1000)
   ) ;
