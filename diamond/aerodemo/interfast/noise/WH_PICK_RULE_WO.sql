--------------------------------------------------------
--  DDL for Table WH_PICK_RULE_WO
--------------------------------------------------------

  CREATE TABLE "WH_PICK_RULE_WO" 
   (	"WH_PICK_RULE_WO_CD" VARCHAR2(16), 
	"PICK_RULE_FACILITY" VARCHAR2(16), 
	"LINE_CNT_TARGET" NUMBER(5,0), 
	"LINE_CNT_MAX" NUMBER(5,0), 
	"PICK_RULE_WHSE_ZONE_GRP_NBR" NUMBER(9,0), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;