--------------------------------------------------------
--  DDL for Table OE_CUST_CONTRACT
--------------------------------------------------------

  CREATE TABLE "OE_CUST_CONTRACT" 
   (	"CONTRACT_CD" VARCHAR2(8), 
	"ORG_NBR_CUST" NUMBER(9,0), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"CONTRACT_CD_DESCR" VARCHAR2(60), 
	"BIN_GRP_REQR_FLG" VARCHAR2(1) DEFAULT 'N', 
	"FCST_GRP" VARCHAR2(8), 
	"ACCEPT_MULTI_SCAN_FOR_BIN_FLG" VARCHAR2(1) DEFAULT 'N', 
	"ORD_TURN_AROUND_DY" NUMBER(3,0)
   ) ;
