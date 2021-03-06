--------------------------------------------------------
--  DDL for Table QA_VND_REJECT
--------------------------------------------------------

  CREATE TABLE "QA_VND_REJECT" 
   (	"QA_PROJ_CD" VARCHAR2(16), 
	"ORG_NBR_VND" NUMBER(9,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE( INITIAL 65536
  FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
