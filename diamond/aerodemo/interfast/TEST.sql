--------------------------------------------------------
--  DDL for Table TEST
--------------------------------------------------------

  CREATE TABLE "TEST" 
   (	"ITEM_NBR" NUMBER(9,0), 
	"DMD_OO_FLG" VARCHAR2(1), 
	"DMD_FC_FLG" VARCHAR2(1), 
	"DMD_WO_FLG" VARCHAR2(1), 
	"SPLY_OH_FLG" VARCHAR2(1), 
	"SPLY_PO_FLG" VARCHAR2(1), 
	"SPLY_WO_FLG" VARCHAR2(1), 
	"RQST_TM" DATE, 
	"APS_EXCEPTION" VARCHAR2(2048), 
	"ITEM_PRTY" NUMBER(1,0), 
	"DISPATCH_TM" DATE, 
	"RQST_SRC" VARCHAR2(61)
   ) ;