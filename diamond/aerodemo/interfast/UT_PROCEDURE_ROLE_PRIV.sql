--------------------------------------------------------
--  DDL for Table UT_PROCEDURE_ROLE_PRIV
--------------------------------------------------------

  CREATE TABLE "UT_PROCEDURE_ROLE_PRIV" 
   (	"PROCEDURE_NM" VARCHAR2(70), 
	"ROLE_NM" VARCHAR2(16), 
	"EXEC_ALLOW_FLG" VARCHAR2(1), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) ;
