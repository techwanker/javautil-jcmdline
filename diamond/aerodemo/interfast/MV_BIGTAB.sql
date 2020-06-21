--------------------------------------------------------
--  DDL for Table MV_BIGTAB
--------------------------------------------------------

  CREATE TABLE "MV_BIGTAB" 
   (	"UM_ID" VARCHAR2(3), 
	"UM_ID_DESCR" VARCHAR2(30), 
	"UM_FAMILY" VARCHAR2(8), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"UM_PRECISION" NUMBER(1,0)
   ) ;

   COMMENT ON TABLE "MV_BIGTAB"  IS 'snapshot table for snapshot DIAMOND9.MV_BIGTAB';
