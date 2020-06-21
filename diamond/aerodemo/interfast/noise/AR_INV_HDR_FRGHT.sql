--------------------------------------------------------
--  DDL for Table AR_INV_HDR_FRGHT
--------------------------------------------------------

  CREATE TABLE "AR_INV_HDR_FRGHT" 
   (	"INV_CD" VARCHAR2(20), 
	"PACK_BOX_CD" VARCHAR2(16), 
	"WAYBILL_CD" VARCHAR2(20), 
	"WGHT_LBS" NUMBER(10,2), 
	"FRGHT_CHG" NUMBER(10,2), 
	"BIN_NBR_PACK_BOX" NUMBER(9,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 16777216 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
