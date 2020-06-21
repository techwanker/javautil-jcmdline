--------------------------------------------------------
--  DDL for Table IC_ITEM_VND_COST_MATRIX
--------------------------------------------------------

  CREATE TABLE "IC_ITEM_VND_COST_MATRIX" 
   (	"ITEM_NBR" NUMBER(9,0), 
	"ORG_NBR_VND" NUMBER(9,0), 
	"PKG_QTY" NUMBER(7,0), 
	"QTY_ORD" NUMBER(13,5), 
	"UNIT_COST" NUMBER(17,6), 
	"UNIT_COST_CURR_CD" VARCHAR2(3), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) ;
