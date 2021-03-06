--------------------------------------------------------
--  DDL for Table QA_CALIBRATE
--------------------------------------------------------

  CREATE TABLE "QA_CALIBRATE" 
   (	"INSPECTOR_NBR" NUMBER(2,0), 
	"TOOL_CD" VARCHAR2(16), 
	"CALIBRATE_DT_NXT" DATE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE( INITIAL 65536
  FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
