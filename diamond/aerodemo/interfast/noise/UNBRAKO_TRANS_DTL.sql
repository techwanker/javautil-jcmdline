--------------------------------------------------------
--  DDL for Table UNBRAKO_TRANS_DTL
--------------------------------------------------------

  CREATE TABLE "UNBRAKO_TRANS_DTL" 
   (	"WH_FACILITY_TRANS_BATCH_NBR" NUMBER, 
	"WH_FACILITY_TRANS_LOG_NBR" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 196608 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;