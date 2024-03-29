--------------------------------------------------------
--  DDL for Table APS_SUMMARY_DAT_AMT
--------------------------------------------------------

  CREATE TABLE "APS_SUMMARY_DAT_AMT" 
   (	"APS_SUMMARY_DAT_AMT_NBR" NUMBER(9,0), 
	"ITEM_NBR" NUMBER(9,0), 
	"STK_UM" VARCHAR2(3), 
	"FACILITY" VARCHAR2(16), 
	"APS_SPLY_POOL_CD" VARCHAR2(16), 
	"BUCKET_START_DT" DATE, 
	"TOT_PO_AT_PO_COST" NUMBER(17,6), 
	"TOT_PO_AT_STD_COST" NUMBER(17,6), 
	"TOT_PO_AT_LIST_PRICE" NUMBER(17,6), 
	"TOT_OO_AT_OO_UNIT_PRICE" NUMBER(17,6), 
	"TOT_OO_AT_STD_COST" NUMBER(17,6), 
	"TOT_OO_AT_LIST_PRICE" NUMBER(17,6), 
	"TOT_WO_SPLY_AT_STD_COST" NUMBER(17,6), 
	"TOT_WO_SPLY_AT_LIST_PRICE" NUMBER(17,6), 
	"TOT_WO_DMD_AT_STD_COST" NUMBER(17,6), 
	"TOT_WO_DMD_AT_LIST_PRICE" NUMBER(17,6), 
	"TOT_FCST_AT_STD_COST" NUMBER(17,6), 
	"TOT_FCST_AT_LIST_PRICE" NUMBER(17,6), 
	"TOT_SS_AT_STD_COST" NUMBER(17,6), 
	"TOT_SS_AT_LIST_PRICE" NUMBER(17,6), 
	"TOT_UNALLOC_AT_STD_COST" NUMBER(17,6), 
	"TOT_UNALLOC_AT_LIST_PRICE" NUMBER(17,6), 
	"TOT_RESCHED_AT_STD_COST" NUMBER(17,6), 
	"TOT_RESCHED_AT_LIST_PRICE" NUMBER(17,6), 
	"TOT_PROJ_POS_AT_STD_COST" NUMBER(17,6), 
	"TOT_PROJ_POS_AT_LIST_PRICE" NUMBER(17,6), 
	"TOT_SHORTFALL_AT_STD_COST" NUMBER(17,6), 
	"TOT_SHORTFALL_AT_LIST_PRICE" NUMBER(17,6), 
	"SUMMARY_TYPE_ID" NUMBER
   ) ;
