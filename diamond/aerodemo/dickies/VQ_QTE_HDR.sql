--------------------------------------------------------
--  DDL for Table VQ_QTE_HDR
--------------------------------------------------------

  CREATE TABLE "VQ_QTE_HDR" 
   (	"VQ_QTE_HDR_NBR" NUMBER(9,0), 
	"VQ_QTE_CD" VARCHAR2(20), 
	"ORG_NBR_VND" NUMBER(9,0), 
	"VQ_QTE_DT" DATE, 
	"CURR_CD_QTE" VARCHAR2(9), 
	"INDIV_NM_SPOKEN_TO" VARCHAR2(40), 
	"INDIV_PHN_NBR" VARCHAR2(20), 
	"INDIV_FAX_NBR" VARCHAR2(20), 
	"INDIV_EMAIL_ADDR" VARCHAR2(40), 
	"VQ_QTE_EFF_DT" DATE, 
	"VQ_QTE_EXP_DT" DATE, 
	"VND_QTE_REF_CD" VARCHAR2(20), 
	"VQ_QTE_INDIV_NBR" NUMBER(9,0), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"TRANSMIT_FLG" VARCHAR2(1) DEFAULT 'N'
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
