--------------------------------------------------------
--  DDL for Table SERVICE_RQST
--------------------------------------------------------

  CREATE TABLE "SERVICE_RQST" 
   (	"SERVICE_RQST_CD" VARCHAR2(20), 
	"SERVICE_RQST_DESCR" VARCHAR2(60), 
	"CLASSNAME" VARCHAR2(255), 
	"PIPE_NM" VARCHAR2(255), 
	"VALIDATE_FLG" VARCHAR2(1) DEFAULT 'Y'
   ) ;
