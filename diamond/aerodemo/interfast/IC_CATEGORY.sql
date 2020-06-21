--------------------------------------------------------
--  DDL for Table IC_CATEGORY
--------------------------------------------------------

  CREATE TABLE "IC_CATEGORY" 
   (	"IC_CATEGORY_NBR" NUMBER(9,0), 
	"IC_CATEGORY_NBR_PARENT" NUMBER(9,0), 
	"IC_CATEGORY_NM" VARCHAR2(16), 
	"IC_CATEGORY_DESCR" VARCHAR2(30), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"PO_VND_SET_HDR_NBR" NUMBER(9,0), 
	"IC_CATEGORY_COLLATE_NBR" NUMBER(4,0), 
	"PRINT_MFR_FLG" VARCHAR2(1)
   ) ;
