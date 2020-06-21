--------------------------------------------------------
--  DDL for Table APS_SPLY_POOL
--------------------------------------------------------

  CREATE TABLE "APS_SPLY_POOL" 
   (	"APS_SPLY_POOL_CD" VARCHAR2(20), 
	"APS_SPLY_POOL_DESCR" VARCHAR2(60), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"APS_SPLY_POOL_STAT_ID" VARCHAR2(1) DEFAULT 'A'
   ) ;
