--------------------------------------------------------
--  DDL for Table FC_ADJ_OLD
--------------------------------------------------------

  CREATE TABLE "FC_ADJ_OLD" 
   (	"FC_ADJ_NBR" NUMBER(9,0), 
	"FC_ITEM_MAST_NBR" NUMBER(9,0), 
	"CYCLE" NUMBER(4,0), 
	"INTVL" NUMBER(2,0), 
	"PRD" NUMBER(2,0), 
	"ADJ_ID" VARCHAR2(2), 
	"ADJ_AMT" NUMBER(10,2), 
	"ADJ_COMM" VARCHAR2(80), 
	"INDIV_NBR_ADJ" NUMBER(9,0), 
	"ADJ_TM" DATE
   ) ;
