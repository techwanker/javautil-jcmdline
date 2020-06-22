--------------------------------------------------------
--  DDL for Table VQ_QTE_TEST
--------------------------------------------------------

  CREATE TABLE "VQ_QTE_TEST" 
   (	"ORG_CD" VARCHAR2(15), 
	"ORG_NM" VARCHAR2(60), 
	"CURR_CD_QTE" VARCHAR2(9), 
	"VQ_QTE_CD" VARCHAR2(20), 
	"VQ_QTE_DT" DATE, 
	"ITEM_CD_QTE" VARCHAR2(50), 
	"LEAD_TM_WK_PROM" NUMBER(3,0), 
	"QTE_QTY" NUMBER(13,5), 
	"QTE_COST_DENOM" NUMBER(17,6)
   ) ;