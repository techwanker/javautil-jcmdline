--------------------------------------------------------
--  DDL for Table FC_ITEM_DFLT
--------------------------------------------------------

  CREATE TABLE "FC_ITEM_DFLT" 
   (	"FC_ITEM_DFLT_NBR" NUMBER(9,0), 
	"ITEM_NBR" NUMBER(9,0), 
	"SVC_LVL" NUMBER(2,2), 
	"ORD_QTY_MIN" NUMBER(6,0), 
	"ORD_QTY_INCR" NUMBER(6,0), 
	"ORD_QTY_MAX" NUMBER(6,0), 
	"STK_CD" VARCHAR2(1), 
	"TOT_LEAD_TIME" NUMBER(4,2), 
	"LEAD_TIME_SHIP" NUMBER(4,2), 
	"SAFETY_STK_MIN_PRD" NUMBER(3,1), 
	"SAFETY_STK_MAX_PRD" NUMBER(3,1), 
	"SAFETY_STK_MIN_UNIT" NUMBER(8,0), 
	"SAFETY_STK_MAX_UNIT" NUMBER(8,0), 
	"INTRO_DT" DATE, 
	"SHELF_LIFE" NUMBER(4,0), 
	"WHSL_PRICE" NUMBER(13,5), 
	"FOB_COST" NUMBER(13,5), 
	"CURRENCY_CD" VARCHAR2(3), 
	"EX_WHSE_COST" NUMBER(13,5), 
	"LAND_COST" NUMBER(13,5), 
	"CARRY_COST" NUMBER(13,5), 
	"ORD_QTY_MIN_UNIT" NUMBER(8,0), 
	"ORD_QTY_MAX_UNIT" NUMBER(8,0), 
	"ORD_QTY_MIN_PRD" NUMBER(4,1), 
	"ORD_QTY_MAX_PRD" NUMBER(4,1), 
	"STORE_ALT_FCST_FLAG" VARCHAR2(1), 
	"ARCH_ALT_FCST_FLAG" VARCHAR2(1), 
	"CALENDAR" VARCHAR2(6), 
	"AQUIS_COST" NUMBER(9,2), 
	"DISTRIB_LEAD_TIME" NUMBER(2,0), 
	"FCST_MDL_GRP" VARCHAR2(8), 
	"RECV_COST" NUMBER(13,5), 
	"RESOURCE_UNITS_INIT" NUMBER(13,2), 
	"RESOURCE_UNITS_INCR" NUMBER(13,2), 
	"MAX_WORK_ORDER_QTY" NUMBER(13,2), 
	"REPLEN_LEAD_TIME" NUMBER(4,2), 
	"FCST_LEAD_TIME" NUMBER(4,2), 
	"STAT_ID" VARCHAR2(1), 
	"ECON_ORD_QTY" NUMBER(13,5)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE( INITIAL 65536
  FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;