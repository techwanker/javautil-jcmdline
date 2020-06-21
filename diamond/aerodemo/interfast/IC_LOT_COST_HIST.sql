--------------------------------------------------------
--  DDL for Table IC_LOT_COST_HIST
--------------------------------------------------------

  CREATE TABLE "IC_LOT_COST_HIST" 
   (	"IC_LOT_COST_HIST_NBR" NUMBER(9,0), 
	"LOT_NBR" NUMBER(9,0), 
	"LOT_COST_LANDED_OLD" NUMBER(17,6), 
	"LOT_COST_LANDED_NEW" NUMBER(17,6), 
	"UT_USER_NBR_CHANGE" NUMBER(9,0), 
	"CHANGE_DT" DATE, 
	"LOT_QTY_ON_HAND" NUMBER(12,5), 
	"ADJ_CD" VARCHAR2(8)
   ) ;
