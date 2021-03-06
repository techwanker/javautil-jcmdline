--------------------------------------------------------
--  DDL for Table CM_AP_HDR_INTEGRATION_LOG
--------------------------------------------------------

  CREATE TABLE "CM_AP_HDR_INTEGRATION_LOG" 
   (	"CM_AP_CD" VARCHAR2(20), 
	"POST_DT" DATE, 
	"ERR_MSG" VARCHAR2(1024)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE( INITIAL 65536
  FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
