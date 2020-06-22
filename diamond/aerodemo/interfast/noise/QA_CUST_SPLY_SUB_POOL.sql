--------------------------------------------------------
--  DDL for Table QA_CUST_SPLY_SUB_POOL
--------------------------------------------------------

  CREATE TABLE "QA_CUST_SPLY_SUB_POOL" 
   (	"ORG_NBR_CUST" NUMBER(9,0), 
	"APS_SPLY_SUB_POOL_NBR" NUMBER(9,0), 
	"FACILITY" VARCHAR2(16), 
	"TEST_EXEMPT_FLG" VARCHAR2(1)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE( INITIAL 65536
  FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;