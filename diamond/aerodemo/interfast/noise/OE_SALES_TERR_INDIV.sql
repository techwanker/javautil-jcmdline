--------------------------------------------------------
--  DDL for Table OE_SALES_TERR_INDIV
--------------------------------------------------------

  CREATE TABLE "OE_SALES_TERR_INDIV" 
   (	"SALES_TERR_CD" VARCHAR2(8), 
	"INDIV_NBR" NUMBER(9,0), 
	"ORD_NOTIFY_THRESHOLD" NUMBER(7,0), 
	"QTE_NOTIFY_THRESHOLD" NUMBER(7,0), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_TM" DATE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE( INITIAL 65536
  FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
