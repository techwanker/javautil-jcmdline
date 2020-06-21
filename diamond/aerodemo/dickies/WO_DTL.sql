--------------------------------------------------------
--  DDL for Table WO_DTL
--------------------------------------------------------

  CREATE TABLE "WO_DTL" 
   (	"WO_DTL_NBR" NUMBER(9,0), 
	"WO_HDR_NBR" NUMBER(9,0), 
	"ITEM_NBR_COMPONENT" NUMBER(9,0), 
	"COMPONENT_UM" VARCHAR2(2), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"COMPONENT_QTY_PER_UNIT" NUMBER(13,5), 
	"REV_LVL" VARCHAR2(5), 
	"ORG_NBR_MFR_RQST" NUMBER(9,0), 
	"QTY_ALLOC" NUMBER(13,5), 
	"QTY_ALLOC_STK_UM" NUMBER(13,5), 
	"MIX_MFR_LOT_FLG" VARCHAR2(1) DEFAULT 'Y', 
	"MANDATORY_ITEM_FLG" VARCHAR2(1) DEFAULT 'N', 
	"PRINT_BAG_LBL_FLG" VARCHAR2(1) DEFAULT 'Y'
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
