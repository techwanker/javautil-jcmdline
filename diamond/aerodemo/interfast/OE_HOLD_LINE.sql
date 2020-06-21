--------------------------------------------------------
--  DDL for Table OE_HOLD_LINE
--------------------------------------------------------

  CREATE TABLE "OE_HOLD_LINE" 
   (	"OE_HOLD_NBR" NUMBER(9,0), 
	"OE_ORD_DTL_NBR" NUMBER(9,0), 
	"HOLD_NBR" NUMBER(9,0), 
	"HOLD_TM" DATE, 
	"HOLD_AMT" NUMBER(11,2), 
	"STAT_ID" VARCHAR2(1), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) ;
