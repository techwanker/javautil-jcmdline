--------------------------------------------------------
--  DDL for Table NA_ORG_ADDR_RPT
--------------------------------------------------------

  CREATE TABLE "NA_ORG_ADDR_RPT" 
   (	"ORG_NBR" NUMBER(9,0), 
	"ADDR_NBR" NUMBER(9,0), 
	"RPT_TYPE" VARCHAR2(3), 
	"RPT_FMT" VARCHAR2(8)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE( INITIAL 65536
  FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
