--------------------------------------------------------
--  DDL for Table FC_FCST_MDL
--------------------------------------------------------

  CREATE TABLE "FC_FCST_MDL" 
   (	"FC_FCST_MDL_NBR" NUMBER(3,0), 
	"CLASS_NAME" VARCHAR2(255), 
	"ALPHA_1" NUMBER(4,2), 
	"ALPHA_2" NUMBER(4,2), 
	"ALPHA_3" NUMBER(4,2), 
	"FCST_MDL_DESCR" VARCHAR2(60), 
	"MDL_INTVL_CNT_MIN" NUMBER(2,0), 
	"MDL_INTVL_CNT_MAX" NUMBER(2,0), 
	"MIN_NON_ZERO_INTVL_PREV_CYCLE" NUMBER(2,0), 
	"MDL_STAT_ID" VARCHAR2(1) DEFAULT 'A'
   ) ;

   COMMENT ON COLUMN "FC_FCST_MDL"."MDL_STAT_ID" IS 'A-Active, I-Inactive';
