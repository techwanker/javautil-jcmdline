--------------------------------------------------------
--  DDL for Table APS_SPLY_FACILITY_ITEM
--------------------------------------------------------

  CREATE TABLE "APS_SPLY_FACILITY_ITEM" 
   (	"APS_SPLY_SUB_POOL_NBR" NUMBER(9,0), 
	"FACILITY" VARCHAR2(16), 
	"ITEM_NBR" NUMBER(9,0), 
	"UNALLOC_CUST_ORD_DT" DATE, 
	"ALLOC_LATE_CUST_ORD_DT" DATE, 
	"UNALLOC_FCST_DT" DATE, 
	"ALLOC_LATE_FCST_DT" DATE, 
	"UNALLOC_REPLEN_DT" DATE, 
	"RESCHED_REPLEN_IN_DAYS" NUMBER(3,0), 
	"RESCHED_REPLEN_OUT_DAYS" NUMBER(3,0), 
	"ONHAND_QTY" NUMBER(11,2)
   ) ;
