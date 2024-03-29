--------------------------------------------------------
--  DDL for Table AR_FRGHT_TERM
--------------------------------------------------------

  CREATE TABLE "AR_FRGHT_TERM" 
   (	"FRGHT_TERM_CD" VARCHAR2(8), 
	"FRGHT_TERM_DESCR" VARCHAR2(60), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE( INITIAL 65536
  FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
