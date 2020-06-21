--------------------------------------------------------
--  DDL for Table FC_CAT_ADJ
--------------------------------------------------------

  CREATE TABLE "FC_CAT_ADJ" 
   (	"FC_CAT_ADJ_NBR" NUMBER(9,0), 
	"IC_CATEGORY_NBR" NUMBER(9,0), 
	"IC_SPLY_TREE_NBR" NUMBER(9,0), 
	"CYCLE" NUMBER(4,0), 
	"INTVL" NUMBER(2,0), 
	"ADJ_AMT" NUMBER(10,0), 
	"ADJ_COMM" VARCHAR2(80), 
	"ADJ_INDIV" VARCHAR2(30), 
	"ADJ_TM" DATE, 
	"ADJ_ID" VARCHAR2(2)
   ) ;
