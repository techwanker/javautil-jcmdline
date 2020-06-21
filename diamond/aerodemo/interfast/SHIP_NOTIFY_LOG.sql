--------------------------------------------------------
--  DDL for Table SHIP_NOTIFY_LOG
--------------------------------------------------------

  CREATE TABLE "SHIP_NOTIFY_LOG" 
   (	"LOG_NBR" NUMBER, 
	"NOTIFY_EMAIL_ADDR" VARCHAR2(200), 
	"SHIP_DT" DATE, 
	"LOG_DT" DATE DEFAULT sysdate, 
	"ORG_NBR_CUST" NUMBER, 
	"EXPIRY_DT" DATE
   ) ;
