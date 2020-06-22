--------------------------------------------------------
--  DDL for Table FC_ITEM_FCST_MDL
--------------------------------------------------------

  CREATE TABLE "FC_ITEM_FCST_MDL" 
   (	"FC_ITEM_FCST_MDL_NBR" NUMBER, 
	"FC_ITEM_MAST_NBR" NUMBER, 
	"FC_FCST_MDL_NBR" NUMBER, 
	"STD_DEV" NUMBER, 
	"MEAN_ABS_DEV" NUMBER, 
	"RVW_CNT" NUMBER, 
	"SAFETY_STK_RAW" NUMBER, 
	"FCST_MDL_DESCR" NUMBER, 
	"SAFETY_STK_ADJ" NUMBER, 
	"ECON_ORD_QTY" NUMBER, 
	"ORD_QTY_ADJ" NUMBER, 
	"SAFETY_STK_MIN_DAYS" NUMBER, 
	"SAFETY_STK_MAX_DAYS" NUMBER, 
	"SAFETY_STK_MIN_UNITS" NUMBER, 
	"SAFETY_STK_MAX_UNITS" NUMBER, 
	"LEAD_TIME_FCST" NUMBER, 
	"RUN_NBR" NUMBER, 
	"CHOSEN_FLG" VARCHAR2(1), 
	"THIEL" NUMBER, 
	"LEAD_TIME_HIST" NUMBER, 
	"ERROR_RATIO" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 32505856 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;

   COMMENT ON COLUMN "FC_ITEM_FCST_MDL"."FC_ITEM_FCST_MDL_NBR" IS 'Surrogate primary key for';
   COMMENT ON COLUMN "FC_ITEM_FCST_MDL"."FC_ITEM_MAST_NBR" IS 'Surrogate primary key for FC_ITEM_MAST.';