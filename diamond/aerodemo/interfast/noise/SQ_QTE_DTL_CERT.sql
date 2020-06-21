--------------------------------------------------------
--  DDL for Table SQ_QTE_DTL_CERT
--------------------------------------------------------

  CREATE TABLE "SQ_QTE_DTL_CERT" 
   (	"SQ_QTE_DTL_NBR" NUMBER(9,0), 
	"CERT_CD" VARCHAR2(8), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 67108864 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
