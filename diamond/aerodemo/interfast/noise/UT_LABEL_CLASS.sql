--------------------------------------------------------
--  DDL for Table UT_LABEL_CLASS
--------------------------------------------------------

  CREATE TABLE "UT_LABEL_CLASS" 
   (	"LABEL_NM" VARCHAR2(20), 
	"LABEL_TYPE_CD" VARCHAR2(10), 
	"LABEL_CLASS_NM" VARCHAR2(255), 
	"LABEL_DESCR" VARCHAR2(60)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
