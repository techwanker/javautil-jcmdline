--------------------------------------------------------
--  DDL for Table OE_HOLD_AUTO_REL
--------------------------------------------------------

  CREATE TABLE "OE_HOLD_AUTO_REL" 
   (	"HOLD_NBR" NUMBER(9,0), 
	"HOLD_NBR_REL" NUMBER(9,0), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE( INITIAL 65536
  FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
