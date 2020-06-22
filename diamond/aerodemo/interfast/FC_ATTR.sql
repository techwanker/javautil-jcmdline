--------------------------------------------------------
--  DDL for Table FC_ATTR
--------------------------------------------------------

  CREATE TABLE "FC_ATTR" 
   (	"FC_ATTR_NBR" NUMBER(9,0), 
	"ATTR_NM" VARCHAR2(16), 
	"ATTR_DESCR" VARCHAR2(60), 
	"ATTR_SEQ" NUMBER(3,0), 
	"REQR_FLG" VARCHAR2(1), 
	"ATTR_CONSTR_FLG" VARCHAR2(1), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) ;