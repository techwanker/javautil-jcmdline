--------------------------------------------------------
--  DDL for Table APS_ALLOC_REPLEN_FC
--------------------------------------------------------

  CREATE TABLE "INTERFAST"."APS_ALLOC_REPLEN_FC" 
   (	"APS_ALLOC_REPLEN_FC_NBR" NUMBER(9,0), 
	"FC_FCST_NBR" NUMBER(9,0), 
	"PO_LINE_DTL_NBR" NUMBER(9,0), 
	"ALLOC_QTY" NUMBER(13,5), 
	"SUBST_ID" VARCHAR2(1 BYTE), 
	"FACILITY_RQST" VARCHAR2(16 BYTE), 
	"FACILITY_ACT" VARCHAR2(16 BYTE), 
	"ITEM_NBR_RQST" NUMBER(9,0), 
	"ALLOC_TYPE_ID" VARCHAR2(1 BYTE) DEFAULT 'U', 
	"WH_FACILITY_TRANS_REPLEN_NBR" NUMBER(9,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  STORAGE(INITIAL 16777216 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;

   COMMENT ON COLUMN "INTERFAST"."APS_ALLOC_REPLEN_FC"."SUBST_ID" IS 'G-Global Substitute Allocated,
		C-Customer Specified Subsitute allocated';
   COMMENT ON COLUMN "INTERFAST"."APS_ALLOC_REPLEN_FC"."ALLOC_TYPE_ID" IS 'R-Reuested for Bind,
		B_Bound Allocation, U-Unbound Allocation';