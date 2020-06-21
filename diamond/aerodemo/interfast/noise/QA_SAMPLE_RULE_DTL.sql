--------------------------------------------------------
--  DDL for Table QA_SAMPLE_RULE_DTL
--------------------------------------------------------

  CREATE TABLE "QA_SAMPLE_RULE_DTL" 
   (	"QA_SAMPLE_RULE_CD" VARCHAR2(16), 
	"POP_SIZE_MIN" NUMBER(9,0), 
	"SAMPLE_SIZE" NUMBER(9,0), 
	"SAMPLE_SIZE_PCT" NUMBER(3,0), 
	"SAMPLE_SIZE_UM" VARCHAR2(3)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
