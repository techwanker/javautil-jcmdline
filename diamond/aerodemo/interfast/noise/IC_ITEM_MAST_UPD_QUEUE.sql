--------------------------------------------------------
--  DDL for Table IC_ITEM_MAST_UPD_QUEUE
--------------------------------------------------------

  CREATE TABLE "IC_ITEM_MAST_UPD_QUEUE" 
   (	"ITEM_NBR" NUMBER(9,0), 
	"LEAD_TM_DY_NEW" NUMBER(5,0), 
	"UT_USER_NBR_UPD" NUMBER(9,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE( INITIAL 65536
  FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
