--------------------------------------------------------
--  DDL for Table FC_BUILD_RATE_GRP
--------------------------------------------------------

  CREATE TABLE "FC_BUILD_RATE_GRP" 
   (	"FC_BUILD_RATE_GRP_CD" VARCHAR2(10), 
	"FC_BUILD_RATE_GRP_DESCR" VARCHAR2(10), 
	"FC_BUILD_RATE_GRP_STAT_ID" VARCHAR2(1)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE( INITIAL 65536
  FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;