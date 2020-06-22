--------------------------------------------------------
--  DDL for Table FC_BUILD_RATE
--------------------------------------------------------

  CREATE TABLE "FC_BUILD_RATE" 
   (	"FC_BUILD_RATE_GRP_CD" VARCHAR2(10), 
	"BUILD_RATE_EFF_DT" DATE, 
	"BUILD_RATE_UNITS" NUMBER(5,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE( INITIAL 65536
  FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;