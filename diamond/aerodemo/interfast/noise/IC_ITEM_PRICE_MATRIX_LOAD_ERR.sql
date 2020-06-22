--------------------------------------------------------
--  DDL for Table IC_ITEM_PRICE_MATRIX_LOAD_ERR
--------------------------------------------------------

  CREATE TABLE "IC_ITEM_PRICE_MATRIX_LOAD_ERR" 
   (	"ITEM_CD" VARCHAR2(60), 
	"COMM" VARCHAR2(100)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE( INITIAL 65536
  FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;