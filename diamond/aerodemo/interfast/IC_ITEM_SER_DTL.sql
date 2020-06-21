--------------------------------------------------------
--  DDL for Table IC_ITEM_SER_DTL
--------------------------------------------------------

  CREATE TABLE "IC_ITEM_SER_DTL" 
   (	"SERIAL_CD" VARCHAR2(20), 
	"LOT_NBR" NUMBER(9,0), 
	"QTY_PER" NUMBER(13,5), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"BOX_CD" VARCHAR2(20), 
	"FACILITY" VARCHAR2(16), 
	"APS_SPLY_SUB_POOL_NBR" NUMBER(9,0), 
	"LOT_COST_LANDED_CURR" NUMBER(17,6)
   ) ;
