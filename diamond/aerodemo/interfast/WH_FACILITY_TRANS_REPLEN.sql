--------------------------------------------------------
--  DDL for Table WH_FACILITY_TRANS_REPLEN
--------------------------------------------------------

  CREATE TABLE "WH_FACILITY_TRANS_REPLEN" 
   (	"WH_FACILITY_TRANS_REPLEN_NBR" NUMBER(9,0), 
	"RQST_STAT_ID" VARCHAR2(1), 
	"PO_LINE_DTL_NBR" NUMBER(9,0), 
	"FACILITY_DEST" VARCHAR2(16), 
	"APS_SPLY_SUB_POOL_NBR_DEST" NUMBER(9,0), 
	"QTY_RQST" NUMBER(13,5), 
	"RQST_DT" DATE, 
	"UT_USER_NBR_RQST" NUMBER(9,0), 
	"UT_USER_NBR_CONFIRM" NUMBER(9,0), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) ;

   COMMENT ON COLUMN "WH_FACILITY_TRANS_REPLEN"."RQST_STAT_ID" IS 'R - Requested,
	P - Planned. Only the Planned ones are converted into On-hand Requests
	upon receipt of the PO';
