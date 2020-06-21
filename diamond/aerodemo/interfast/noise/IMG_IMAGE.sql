--------------------------------------------------------
--  DDL for Table IMG_IMAGE
--------------------------------------------------------

  CREATE TABLE "IMG_IMAGE" 
   (	"IMG_IMAGE_NBR" NUMBER(9,0), 
	"IMG_IMAGE_PATH" VARCHAR2(255), 
	"IMG_IMAGE_FILE_NM" VARCHAR2(128), 
	"IMAGE_DESCR" VARCHAR2(60)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
