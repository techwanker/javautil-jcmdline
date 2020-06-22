--------------------------------------------------------
--  DDL for Table QA_TST_GRP_DTL
--------------------------------------------------------

  CREATE TABLE "QA_TST_GRP_DTL" 
   (	"QA_TST_GRP_CD" VARCHAR2(16), 
	"QA_TST_CD" VARCHAR2(16), 
	"QA_SAMPLE_RULE_CD" VARCHAR2(16), 
	"DESTROY_GRP" VARCHAR2(3)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;