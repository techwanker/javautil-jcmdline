--------------------------------------------------------
--  DDL for Table APS_ALLOC_ONHAND_WO
--------------------------------------------------------

  CREATE TABLE "INTERFAST"."APS_ALLOC_ONHAND_WO" 
   (	"APS_ALLOC_ONHAND_WO_NBR" NUMBER(9,0), 
	"WO_DTL_NBR" NUMBER(9,0), 
	"LOT_NBR" NUMBER(9,0), 
	"ALLOC_QTY" NUMBER(13,5), 
	"APS_SPLY_SUB_POOL_NBR" NUMBER(9,0), 
	"FACILITY_RQST" VARCHAR2(16 BYTE), 
	"FACILITY_ACT" VARCHAR2(16 BYTE), 
	"ITEM_NBR_RQST" NUMBER(9,0), 
	"ALLOC_TYPE_ID" VARCHAR2(1 BYTE) DEFAULT 'U', 
	"WH_FACILITY_TRANS_ONHAND_NBR" NUMBER(9,0), 
	"AVAIL_DT" DATE DEFAULT NULL, 
	"AVAIL_DT_TYPE_ID" VARCHAR2(1 BYTE) DEFAULT NULL
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 2097152 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;

   COMMENT ON COLUMN "INTERFAST"."APS_ALLOC_ONHAND_WO"."ALLOC_TYPE_ID" IS 'R-Reuested for Bind,
		B_Bound Allocation, U-Unbound Allocation';
