--------------------------------------------------------
--  DDL for Table WO_HDR
--------------------------------------------------------

  CREATE TABLE "WO_HDR" 
   (	"WO_HDR_NBR" NUMBER(9,0), 
	"WO_DESCR" VARCHAR2(100), 
	"ITEM_NBR_RQST" NUMBER(9,0), 
	"RQST_QTY" NUMBER(7,0), 
	"WO_UM" VARCHAR2(3), 
	"RELEASE_QTY" NUMBER(7,0), 
	"FILL_QTY" NUMBER(7,0), 
	"NEED_BY_DT" DATE, 
	"APS_SPLY_SUB_POOL_NBR" NUMBER(9,0), 
	"FACILITY" VARCHAR2(16), 
	"APS_SRC_RULE_SET_NBR" NUMBER(9,0), 
	"ORG_NBR_CUST" NUMBER(9,0), 
	"UT_USER_NBR_RQST" NUMBER(9,0), 
	"OE_ORD_DTL_NBR" NUMBER(9,0), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"WO_STAT_ID" VARCHAR2(1)
   ) ;
