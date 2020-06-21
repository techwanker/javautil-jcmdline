--------------------------------------------------------
--  DDL for Table FC_FCST_MDL_GRP
--------------------------------------------------------

  CREATE TABLE "FC_FCST_MDL_GRP" 
   (	"FCST_MDL_GRP" VARCHAR2(16), 
	"FCST_MDL_NBR" NUMBER(3,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
