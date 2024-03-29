--------------------------------------------------------
--  DDL for Table FC_DTL_TMP
--------------------------------------------------------

  CREATE TABLE "FC_DTL_TMP" 
   (	"FC_ITEM_MAST_NBR" NUMBER(9,0), 
	"ITEM_NBR" NUMBER(9,0), 
	"ITEM_CD" VARCHAR2(50), 
	"USER_FLD_1" VARCHAR2(20), 
	"USER_FLD_2" VARCHAR2(20), 
	"USER_FLD_3" VARCHAR2(20), 
	"RAW_FCST_TOT" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 524288 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
