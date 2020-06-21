--------------------------------------------------------
--  DDL for Table OE_HOLD_REL_LINE
--------------------------------------------------------

  CREATE TABLE "OE_HOLD_REL_LINE" 
   (	"OE_HOLD_REL_NBR" NUMBER(9,0), 
	"OE_ORD_DTL_NBR" NUMBER(9,0), 
	"HOLD_NBR" NUMBER(9,0), 
	"INDIV_NBR_REL" NUMBER(9,0), 
	"REL_TM" DATE, 
	"REL_COMM" VARCHAR2(255), 
	"STAT_ID" VARCHAR2(1), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) ;
