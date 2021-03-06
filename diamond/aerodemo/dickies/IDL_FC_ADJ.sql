--------------------------------------------------------
--  DDL for Table IDL_FC_ADJ
--------------------------------------------------------

  CREATE TABLE "IDL_FC_ADJ" 
   (	"FC_ITEM_MAST_NBR" NUMBER(9,0), 
	"ITEM_CD" VARCHAR2(50), 
	"FCST_GRP" VARCHAR2(8), 
	"MNTH_1_ADJ" NUMBER, 
	"MNTH_2_ADJ" NUMBER, 
	"MNTH_3_ADJ" NUMBER, 
	"MNTH_4_ADJ" NUMBER, 
	"MNTH_5_ADJ" NUMBER, 
	"MNTH_6_ADJ" NUMBER, 
	"MNTH_7_ADJ" NUMBER, 
	"MNTH_8_ADJ" NUMBER, 
	"MNTH_9_ADJ" NUMBER, 
	"MNTH_10_ADJ" NUMBER, 
	"MNTH_11_ADJ" NUMBER, 
	"MNTH_12_ADJ" NUMBER, 
	"PROD_LINE" VARCHAR2(20), 
	"STYLE" VARCHAR2(20), 
	"COLOR" VARCHAR2(20), 
	"SZ" VARCHAR2(20), 
	"STATUS_ID" VARCHAR2(10)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 262144 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
