--------------------------------------------------------
--  DDL for Table TMP_APS_RESULT_DTL_SPLY
--------------------------------------------------------

  CREATE GLOBAL TEMPORARY TABLE "TMP_APS_RESULT_DTL_SPLY" 
   (	"APS_RESULT_DTL_DMD_NBR" NUMBER(9,0), 
	"SPLY_IDENTIFIER" VARCHAR2(20), 
	"LOT_NBR_SPLY" NUMBER(9,0), 
	"FACILITY_SPLY" VARCHAR2(16), 
	"APS_SPLY_SUB_POOL_NBR_SPLY" NUMBER(9,0), 
	"APS_SPLY_POOL_CD_SPLY" VARCHAR2(20), 
	"APS_SPLY_SUB_POOL_CD_SPLY" VARCHAR2(20), 
	"PO_LINE_DTL_NBR" NUMBER(9,0), 
	"WO_HDR_NBR" NUMBER(9,0), 
	"SPLY_QTY" NUMBER(13,5), 
	"SPLY_QTY_ALLOC" NUMBER(13,5), 
	"AVAIL_DT" DATE, 
	"ORG_NBR_MFR_SPLY" NUMBER(9,0), 
	"ORG_NM_MFR_SPLY" VARCHAR2(60), 
	"ORG_NBR_VND_SPLY" NUMBER(9,0), 
	"ORG_NM_VND_SPLY" VARCHAR2(60), 
	"APS_AVAIL_DT" DATE, 
	"WH_FACILITY_TRANS_ONHAND_NBR" NUMBER(9,0), 
	"WH_FACILITY_TRANS_REPLEN_NBR" NUMBER(9,0), 
	"WH_FACILITY_TRANS_WO_NBR" NUMBER(9,0), 
	"SRC_RULE_FLG" VARCHAR2(1), 
	"SPLY_CERT_TO_DEMAND_FLG" VARCHAR2(1), 
	"EXPLICIT_MFR_FLG" VARCHAR2(1), 
	"APPRV_MFR_FLG" VARCHAR2(1), 
	"ATTRIBUTE_CERT_FLG" VARCHAR2(1), 
	"REV_LVL_FLG" VARCHAR2(1), 
	"LOT_DT_FLG" VARCHAR2(1), 
	"CNTRY_OF_ORIGIN_FLG" VARCHAR2(1), 
	"EQUIV_FLG" VARCHAR2(1), 
	"CUST_SUBST_FLG" VARCHAR2(1), 
	"GLOBAL_SUBST_FLG" VARCHAR2(1), 
	"AVAIL_DT_TYPE_ID" VARCHAR2(1)
   ) ON COMMIT DELETE ROWS ;
