--------------------------------------------------------
--  DDL for Table IC_LOT_MAST_CERT_LOG
--------------------------------------------------------

  CREATE TABLE "IC_LOT_MAST_CERT_LOG" 
   (	"LOT_NBR" NUMBER(9,0), 
	"CERT_CD" VARCHAR2(8), 
	"CERT_RCPT_DT" DATE, 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"MOD_ACTION" VARCHAR2(1), 
	"UT_USER_NBR_MOD" NUMBER(9,0), 
	"MOD_TM" DATE
   ) ;

   COMMENT ON COLUMN "IC_LOT_MAST_CERT_LOG"."MOD_ACTION" IS 'I - Insert, U - Update, D - Delete';
