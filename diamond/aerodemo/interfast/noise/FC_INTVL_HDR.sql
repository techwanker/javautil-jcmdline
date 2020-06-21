--------------------------------------------------------
--  DDL for Table FC_INTVL_HDR
--------------------------------------------------------

  CREATE TABLE "FC_INTVL_HDR" 
   (	"CALENDAR" VARCHAR2(6), 
	"INTVL" NUMBER(2,0), 
	"INTVL_NAME" VARCHAR2(30)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE( INITIAL 65536
  FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
