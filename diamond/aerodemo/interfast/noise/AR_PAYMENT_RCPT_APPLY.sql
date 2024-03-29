--------------------------------------------------------
--  DDL for Table AR_PAYMENT_RCPT_APPLY
--------------------------------------------------------

  CREATE TABLE "AR_PAYMENT_RCPT_APPLY" 
   (	"AR_PAYMENT_RCPT_APPLY_NBR" NUMBER(9,0), 
	"AR_PAYMENT_RCPT_NBR" NUMBER(9,0), 
	"INV_CD" VARCHAR2(20), 
	"GL_ACCT_NBR" NUMBER(9,0), 
	"APPLY_AMT" NUMBER(15,2), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_TM" DATE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE( INITIAL 65536
  FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
