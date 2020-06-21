--------------------------------------------------------
--  DDL for Table IC_ATTR
--------------------------------------------------------

  CREATE TABLE "IC_ATTR" 
   (	"IC_ATTR_NBR" NUMBER(9,0), 
	"ATTR_NM" VARCHAR2(16), 
	"ATTR_DESCR" VARCHAR2(60), 
	"ATTR_SEQ" NUMBER(3,0), 
	"REQR_FLG" VARCHAR2(1), 
	"ATTR_CONSTR_FLG" VARCHAR2(1), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) ;
