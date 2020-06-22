--------------------------------------------------------
--  DDL for Table NA_ORG_INDIV_ADDR
--------------------------------------------------------

  CREATE TABLE "NA_ORG_INDIV_ADDR" 
   (	"ORG_NBR" NUMBER(6,0), 
	"INDIV_NBR" NUMBER(6,0), 
	"ADDR_NBR" NUMBER(6,0), 
	"ADDR_DESCR" VARCHAR2(20), 
	"MOD_USER" VARCHAR2(30), 
	"MOD_DT" DATE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE( INITIAL 65536
  FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;