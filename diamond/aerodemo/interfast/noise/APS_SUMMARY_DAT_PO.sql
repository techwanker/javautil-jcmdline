--------------------------------------------------------
--  DDL for Table APS_SUMMARY_DAT_PO
--------------------------------------------------------

  CREATE TABLE "APS_SUMMARY_DAT_PO" 
   (	"APS_SUMMARY_DAT_NBR" NUMBER(9,0), 
	"PO_LINE_DTL_NBR" NUMBER(9,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE( INITIAL 65536
  FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;