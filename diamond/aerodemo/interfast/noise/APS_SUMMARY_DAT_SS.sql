--------------------------------------------------------
--  DDL for Table APS_SUMMARY_DAT_SS
--------------------------------------------------------

  CREATE TABLE "APS_SUMMARY_DAT_SS" 
   (	"APS_SUMMARY_DAT_NBR" NUMBER(9,0), 
	"FC_ITEM_MAST_NBR" NUMBER(9,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE( INITIAL 65536
  FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;