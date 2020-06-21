--------------------------------------------------------
--  DDL for Table PLAN_PO
--------------------------------------------------------

  CREATE TABLE "PLAN_PO" 
   (	"PLAN_PO_NBR" NUMBER(9,0), 
	"AVAIL_TYPE_CD" VARCHAR2(1) DEFAULT 'P', 
	"ITEM_NBR" NUMBER(9,0), 
	"WHSE_ID" VARCHAR2(8), 
	"WHSE_AREA" VARCHAR2(18), 
	"ITEM_CD" VARCHAR2(50), 
	"MFR_CD" VARCHAR2(8), 
	"VNDR_CD" VARCHAR2(8), 
	"UNIT_COST" NUMBER(18,6), 
	"UNIT_COST_CURR_CD" VARCHAR2(3), 
	"UNIT_COST_DENOM" NUMBER(18,6), 
	"UNIT_COST_CURR_CD_DENOM" VARCHAR2(3), 
	"AVAIL_DT" DATE, 
	"GROSS_AVAIL_QTY" NUMBER(10,0), 
	"IC_SPLY_TREE_NBR" NUMBER(9,0), 
	"PO_LINE_DTL_NBR" NUMBER(9,0)
   ) ;
