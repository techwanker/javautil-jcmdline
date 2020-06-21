--------------------------------------------------------
--  DDL for Table FC_ITEM_FCST_MDL
--------------------------------------------------------

  CREATE TABLE "FC_ITEM_FCST_MDL" 
   (	"FC_ITEM_FCST_MDL_NBR" NUMBER(9,0), 
	"FC_ITEM_MAST_NBR" NUMBER(9,0), 
	"FC_FCST_MDL_NBR" NUMBER(3,0), 
	"STD_DEV" NUMBER(17,5), 
	"MEAN_ABS_DEV" NUMBER(17,5), 
	"RVW_CNT" NUMBER(3,0), 
	"SAFETY_STK_RAW" NUMBER(17,5), 
	"FCST_MDL_DESCR" VARCHAR2(60)
   ) ;
