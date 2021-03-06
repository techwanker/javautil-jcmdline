--------------------------------------------------------
--  DDL for Table TMP_FACILITY_TRANS_DTL
--------------------------------------------------------

  CREATE GLOBAL TEMPORARY TABLE "TMP_FACILITY_TRANS_DTL" 
   (	"SPLY_TYPE_ID" VARCHAR2(1), 
	"SPLY_IDENTIFIER" VARCHAR2(20), 
	"LOT_NBR" NUMBER(9,0), 
	"PO_LINE_DTL_NBR" NUMBER(9,0), 
	"WO_HDR_NBR" NUMBER(9,0), 
	"ITEM_NBR_RQST" NUMBER(9,0), 
	"ITEM_CD" VARCHAR2(50), 
	"ITEM_DESCR" VARCHAR2(50), 
	"STK_UM" VARCHAR2(3), 
	"FACILITY_RQST" VARCHAR2(16), 
	"FACILITY_ACT" VARCHAR2(16), 
	"APS_SPLY_SUB_POOL_NBR" NUMBER(9,0), 
	"APS_SPLY_POOL_CD" VARCHAR2(20), 
	"APS_SPLY_SUB_POOL_CD" VARCHAR2(20), 
	"TOT_ALLOC_QTY" NUMBER(12,2), 
	"AVAIL_DT" DATE
   ) ON COMMIT PRESERVE ROWS ;
