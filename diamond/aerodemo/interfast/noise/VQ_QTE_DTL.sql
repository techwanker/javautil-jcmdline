--------------------------------------------------------
--  DDL for Table VQ_QTE_DTL
--------------------------------------------------------

  CREATE TABLE "VQ_QTE_DTL" 
   (	"VQ_QTE_DTL_NBR" NUMBER(9,0), 
	"VQ_QTE_HDR_NBR" NUMBER(9,0), 
	"ITEM_NBR_QTE" NUMBER(9,0), 
	"ITEM_CD_QTE" VARCHAR2(50), 
	"ITEM_CD_VND" VARCHAR2(50), 
	"QTE_UM" VARCHAR2(3), 
	"QTE_QTY" NUMBER(13,5), 
	"QTE_QTY_STK_UM" NUMBER(13,5), 
	"QTE_COST" NUMBER(17,6), 
	"QTE_COST_DENOM" NUMBER(17,6), 
	"QTE_COST_STK_UM" NUMBER(17,6), 
	"QTE_COST_DENOM_STK_UM" NUMBER(17,6), 
	"ORG_NBR_MFR_RQST" NUMBER(9,0), 
	"REV_LVL" VARCHAR2(5), 
	"RQST_DT" DATE, 
	"LEAD_TM_WK_PROM" NUMBER(3,0), 
	"PROM_DT" DATE, 
	"VQ_LOST_CD" VARCHAR2(8), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 117440512 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
