--------------------------------------------------------
--  DDL for Table APS_ALLOC_ONHAND_FC
--------------------------------------------------------

  CREATE TABLE "APS_ALLOC_ONHAND_FC" 
   (	"APS_ALLOC_ONHAND_FC_NBR" NUMBER(9,0), 
	"ITEM_NBR_RQST" NUMBER(9,0), 
	"FC_FCST_NBR" NUMBER(9,0), 
	"LOT_NBR" NUMBER(9,0), 
	"APS_SPLY_SUB_POOL_NBR" NUMBER(9,0), 
	"FACILITY_RQST" VARCHAR2(16), 
	"FACILITY_ACT" VARCHAR2(16), 
	"ALLOC_QTY" NUMBER(13,5), 
	"SUBST_ID" VARCHAR2(1), 
	"ALLOC_TYPE_ID" VARCHAR2(1), 
	"WH_FACILITY_TRANS_ONHAND_NBR" NUMBER(9,0), 
	"AVAIL_DT" DATE, 
	"AVAIL_DT_TYPE_ID" VARCHAR2(1), 
	"FC_ITEM_MAST_NBR" NUMBER(9,0), 
	"FCST_DT" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 14680064 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
