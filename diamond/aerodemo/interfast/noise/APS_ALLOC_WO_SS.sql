--------------------------------------------------------
--  DDL for Table APS_ALLOC_WO_SS
--------------------------------------------------------

  CREATE TABLE "APS_ALLOC_WO_SS" 
   (	"APS_ALLOC_WO_SS_NBR" NUMBER(9,0), 
	"WO_HDR_NBR" NUMBER(9,0), 
	"FC_ITEM_MAST_NBR" NUMBER(9,0), 
	"ALLOC_QTY" NUMBER(13,5), 
	"FACILITY_RQST" VARCHAR2(16), 
	"FACILITY_ACT" VARCHAR2(16), 
	"ITEM_NBR_RQST" NUMBER(9,0), 
	"ALLOC_TYPE_ID" VARCHAR2(1) DEFAULT 'U', 
	"WH_FACILITY_TRANS_WO_NBR" NUMBER(9,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE( INITIAL 65536
  FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;

   COMMENT ON COLUMN "APS_ALLOC_WO_SS"."ALLOC_TYPE_ID" IS 'R-Reuested for Bind,
		B_Bound Allocation, U-Unbound Allocation';
