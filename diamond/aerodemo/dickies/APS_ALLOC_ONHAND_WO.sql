--------------------------------------------------------
--  DDL for Table APS_ALLOC_ONHAND_WO
--------------------------------------------------------

  CREATE TABLE "APS_ALLOC_ONHAND_WO" 
   (	"APS_ALLOC_ONHAND_WO_NBR" NUMBER(9,0), 
	"ITEM_NBR_RQST" NUMBER(9,0), 
	"WO_DTL_NBR" NUMBER(9,0), 
	"LOT_NBR" NUMBER(9,0), 
	"APS_SPLY_SUB_POOL_NBR" NUMBER(9,0), 
	"FACILITY_RQST" VARCHAR2(16), 
	"FACILITY_ACT" VARCHAR2(16), 
	"ALLOC_QTY" NUMBER(13,5), 
	"ALLOC_TYPE_ID" VARCHAR2(1), 
	"WH_FACILITY_TRANS_ONHAND_NBR" NUMBER(9,0), 
	"AVAIL_DT" DATE, 
	"AVAIL_DT_TYPE_ID" VARCHAR2(1), 
	 CONSTRAINT "APS_ALLOC_ONHAND_WO_IOTPK" PRIMARY KEY ("ITEM_NBR_RQST", "APS_ALLOC_ONHAND_WO_NBR") ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  ORGANIZATION INDEX NOCOMPRESS PCTFREE 10 INITRANS 2 MAXTRANS 255 LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" 
 PCTTHRESHOLD 50;
