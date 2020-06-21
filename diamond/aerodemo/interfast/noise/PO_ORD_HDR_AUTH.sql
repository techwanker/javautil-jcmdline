--------------------------------------------------------
--  DDL for Table PO_ORD_HDR_AUTH
--------------------------------------------------------

  CREATE TABLE "PO_ORD_HDR_AUTH" 
   (	"PO_ORD_HDR_AUTH_NBR" NUMBER(9,0), 
	"PO_ORD_HDR_NBR" NUMBER(9,0), 
	"INDIV_NBR_AUTH" NUMBER(9,0), 
	"AUTH_FLG" VARCHAR2(1), 
	"UNIT_COST_TOTAL" NUMBER(13,2), 
	"INDIV_AUTH_AMT" NUMBER(13,2), 
	"AUTH_DT" DATE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE( INITIAL 65536
  FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
