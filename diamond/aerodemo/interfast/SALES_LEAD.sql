--------------------------------------------------------
--  DDL for Table SALES_LEAD
--------------------------------------------------------

  CREATE TABLE "SALES_LEAD" 
   (	"SALES_LEAD_NBR" NUMBER(9,0), 
	"SALES_LEAD_REF" VARCHAR2(50), 
	"ORG_NBR_LEAD_SRC" NUMBER(9,0), 
	"LEAD_RECV_DT" DATE, 
	"INDIV_NBR_LEAD_RECV" NUMBER(9,0), 
	"INDIV_NBR_LEAD_ASSIGN" NUMBER(9,0), 
	"LEAD_ASSIGN_DT" DATE
   ) ;
