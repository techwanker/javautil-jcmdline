--------------------------------------------------------
--  DDL for Table IC_ITEM_COST
--------------------------------------------------------

  CREATE TABLE "IC_ITEM_COST" 
   (	"ITEM_NBR" NUMBER(9,0), 
	"COST_TYPE_CD" VARCHAR2(16), 
	"UNIT_COST" NUMBER(17,6), 
	"COST_CALC_DT" DATE, 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) ;
