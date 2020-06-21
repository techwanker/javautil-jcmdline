--------------------------------------------------------
--  DDL for Table IC_SUMMARY_DAT_PLAN
--------------------------------------------------------

  CREATE TABLE "IC_SUMMARY_DAT_PLAN" 
   (	"IC_SUMMARY_DAT_PLAN_NBR" NUMBER, 
	"SEQ_NBR" NUMBER, 
	"ITEM_CD" VARCHAR2(50), 
	"NODE" NUMBER, 
	"BUCKET_SZ" NUMBER, 
	"LABEL" VARCHAR2(20), 
	"FCST" NUMBER(10,0), 
	"OO" NUMBER(10,0), 
	"PO" NUMBER(10,0), 
	"RESCHED" NUMBER(10,0), 
	"UNALLOC" NUMBER(10,0), 
	"PROJ_POS" NUMBER(10,0), 
	"SHORTFALL" NUMBER(10,0)
   ) ;
