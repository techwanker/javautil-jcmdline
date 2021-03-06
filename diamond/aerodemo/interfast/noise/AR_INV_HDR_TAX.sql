--------------------------------------------------------
--  DDL for Table AR_INV_HDR_TAX
--------------------------------------------------------

  CREATE TABLE "AR_INV_HDR_TAX" 
   (	"INV_CD" VARCHAR2(20), 
	"TAX_CD" VARCHAR2(16), 
	"TAX_AMT" NUMBER(11,2), 
	"TAX_AMT_DENOM" NUMBER(11,2)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 20971520 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
