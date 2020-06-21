--------------------------------------------------------
--  DDL for Table OE_SALES_TERR
--------------------------------------------------------

  CREATE TABLE "OE_SALES_TERR" 
   (	"SALES_TERR_CD" VARCHAR2(8), 
	"SALES_TERR_DESCR" VARCHAR2(60), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"SALES_TERR_CD_STAT_ID" VARCHAR2(1) DEFAULT 'A'
   ) ;
