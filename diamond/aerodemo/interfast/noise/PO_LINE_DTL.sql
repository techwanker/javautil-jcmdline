--------------------------------------------------------
--  DDL for Table PO_LINE_DTL
--------------------------------------------------------

  CREATE TABLE "PO_LINE_DTL" 
   (	"PO_LINE_DTL_NBR" NUMBER(9,0), 
	"PO_LINE_HDR_NBR" NUMBER(9,0), 
	"SCHED_QTY" NUMBER(13,5), 
	"RECV_QTY" NUMBER(13,5), 
	"REPLEN_RQST_SHIP_DT" DATE, 
	"REPLEN_EST_SHIP_DT" DATE, 
	"REPLEN_CURR_EST_DT" DATE, 
	"SHIP_TO_ADDR_NBR" NUMBER(9,0), 
	"SHIP_VIA_CD" VARCHAR2(8), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"APS_SPLY_SUB_POOL_NBR" NUMBER(9,0), 
	"FACILITY" VARCHAR2(16), 
	"CANCEL_CD" VARCHAR2(8), 
	"CANCEL_DT" DATE, 
	"UT_USER_NBR_CANCEL" NUMBER(9,0), 
	"SCHED_QTY_STK_UM" NUMBER(13,5), 
	"RECV_QTY_STK_UM" NUMBER(13,5), 
	"APS_AVAIL_DT" DATE, 
	"CANNOT_RESCHED_FLG" VARCHAR2(1) DEFAULT 'N', 
	"BUY_REASON_CD" VARCHAR2(8)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 67108864 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
