--------------------------------------------------------
--  DDL for Table APS_RESULT_DTL_DMD
--------------------------------------------------------

  CREATE TABLE "APS_RESULT_DTL_DMD" 
   (	"APS_RESULT_DTL_DMD_NBR" NUMBER(9,0), 
	"ITEM_NBR_RQST" NUMBER(9,0), 
	"DMD_IDENTIFIER" VARCHAR2(20), 
	"OE_ORD_DTL_NBR" NUMBER(9,0), 
	"WO_DTL_NBR" NUMBER(9,0), 
	"FC_FCST_NBR" NUMBER(9,0), 
	"FC_ITEM_MAST_NBR" NUMBER(9,0), 
	"DMD_QTY" NUMBER(13,5), 
	"DMD_QTY_ADJ" NUMBER(13,5), 
	"ALLOC_QTY" NUMBER(13,5), 
	"RQST_DT_ALLOC_QTY" NUMBER(13,5), 
	"RQST_DT" DATE, 
	"PROM_DT_CURR" DATE, 
	"AVAIL_DT" DATE, 
	"APS_SRC_RULE_SET_NBR_DMD" NUMBER(9,0), 
	"FACILITY_DMD" VARCHAR2(16), 
	"ORG_NBR_CUST" NUMBER(9,0), 
	"ORG_NBR_MFR_RQST" NUMBER(9,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 83886080 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
