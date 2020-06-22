--------------------------------------------------------
--  DDL for Table AP_INV_DTL_GL
--------------------------------------------------------

  CREATE TABLE "AP_INV_DTL_GL" 
   (	"AP_INV_DTL_NBR" NUMBER(9,0), 
	"GL_ACCT_CD" VARCHAR2(50), 
	"GL_TRANS_AMT" NUMBER(17,6), 
	"DISTRIB_TYPE" NUMBER(3,0), 
	"CURR_CD" VARCHAR2(3), 
	"GL_TRANS_DESCR" VARCHAR2(255)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 67108864 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;