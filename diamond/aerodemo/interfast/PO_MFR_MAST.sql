--------------------------------------------------------
--  DDL for Table PO_MFR_MAST
--------------------------------------------------------

  CREATE TABLE "PO_MFR_MAST" 
   (	"ORG_NBR_MFR" NUMBER(9,0), 
	"STAT_ID" VARCHAR2(1), 
	"INTRO_DT" DATE, 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"MAIL_TO_ADDR_NBR_DFLT" NUMBER(9,0), 
	"BILL_TO_ADDR_NBR_DFLT" NUMBER(9,0), 
	"MFR_CAGE_CD" VARCHAR2(10), 
	"CNTRY_CD_ORIGIN" VARCHAR2(3)
   ) ;
