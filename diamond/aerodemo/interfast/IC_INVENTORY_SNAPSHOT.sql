--------------------------------------------------------
--  DDL for Table IC_INVENTORY_SNAPSHOT
--------------------------------------------------------

  CREATE TABLE "IC_INVENTORY_SNAPSHOT" 
   (	"LOT_NBR" NUMBER(9,0), 
	"FACILITY" VARCHAR2(16), 
	"APS_SPLY_SUB_POOL_NBR" NUMBER(9,0), 
	"TOT_LOT_QTY" NUMBER(13,5), 
	"LOT_COST_LANDED_CURR" NUMBER(17,6), 
	"SNAPSHOT_TM" DATE
   ) ;
