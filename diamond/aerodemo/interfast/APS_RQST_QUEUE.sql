--------------------------------------------------------
--  DDL for Table APS_RQST_QUEUE
--------------------------------------------------------

  CREATE TABLE "APS_RQST_QUEUE" 
   (	"ITEM_NBR" NUMBER(9,0), 
	"DMD_OO_FLG" VARCHAR2(1), 
	"DMD_FC_FLG" VARCHAR2(1), 
	"DMD_WO_FLG" VARCHAR2(1), 
	"SPLY_OH_FLG" VARCHAR2(1), 
	"SPLY_PO_FLG" VARCHAR2(1), 
	"SPLY_WO_FLG" VARCHAR2(1), 
	"RQST_TM" DATE DEFAULT sysdate, 
	"APS_EXCEPTION" VARCHAR2(2048), 
	"ITEM_PRTY" NUMBER(1,0) DEFAULT 9, 
	"DISPATCH_TM" DATE, 
	"RQST_SRC" VARCHAR2(61) DEFAULT 'UNKNOWN'
   ) ;
