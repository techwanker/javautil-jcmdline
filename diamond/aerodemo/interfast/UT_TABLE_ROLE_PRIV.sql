--------------------------------------------------------
--  DDL for Table UT_TABLE_ROLE_PRIV
--------------------------------------------------------

  CREATE TABLE "UT_TABLE_ROLE_PRIV" 
   (	"TABLE_NM" VARCHAR2(30), 
	"ROLE_NM" VARCHAR2(16), 
	"SELECT_ALLOW_FLG" VARCHAR2(1), 
	"INSERT_ALLOW_FLG" VARCHAR2(1), 
	"UPDATE_ALLOW_FLG" VARCHAR2(1), 
	"DELETE_ALLOW_FLG" VARCHAR2(1), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) ;
