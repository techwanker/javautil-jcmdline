--------------------------------------------------------
--  DDL for Table WH_FACILITY_TRANS_ONHAND
--------------------------------------------------------

  CREATE TABLE "WH_FACILITY_TRANS_ONHAND" 
   (	"WH_FACILITY_TRANS_ONHAND_NBR" NUMBER(9,0), 
	"RQST_STAT_ID" VARCHAR2(1), 
	"FACILITY_SRC" VARCHAR2(16), 
	"APS_SPLY_SUB_POOL_NBR_SRC" NUMBER(9,0), 
	"FACILITY_DEST" VARCHAR2(16), 
	"APS_SPLY_SUB_POOL_NBR_DEST" NUMBER(9,0), 
	"QTY_RQST" NUMBER(13,5), 
	"RQST_DT" DATE, 
	"LOT_NBR" NUMBER(9,0), 
	"UT_USER_NBR_RQST" NUMBER(9,0), 
	"UT_USER_NBR_CONFIRM" NUMBER(9,0), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"BOX_CD" VARCHAR2(20), 
	"AVAIL_DT" DATE
   ) ;

   COMMENT ON COLUMN "WH_FACILITY_TRANS_ONHAND"."RQST_STAT_ID" IS 'R - Requested,
	P - Planned. Only the Planned ones are looked at by Allocation,
	F - Firm. Ready to be Picked';
