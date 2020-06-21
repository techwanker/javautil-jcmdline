--------------------------------------------------------
--  DDL for Table IC_TRANS_GL_INTEGRATION_LOG
--------------------------------------------------------

  CREATE TABLE "IC_TRANS_GL_INTEGRATION_LOG" 
   (	"IC_TRANS_GL_NBR" NUMBER(9,0), 
	"POST_DT" DATE, 
	"ERR_MSG" VARCHAR2(1024)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE( INITIAL 65536
  FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
