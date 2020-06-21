--------------------------------------------------------
--  DDL for Table EDI_INBOUND_CTL
--------------------------------------------------------

  CREATE TABLE "EDI_INBOUND_CTL" 
   (	"EDI_SRC_CD" VARCHAR2(20), 
	"EDI_FILE_PATH" VARCHAR2(255), 
	"EDI_FILE_MASK" VARCHAR2(127), 
	"EDI_PARSER_CLASSNAME" VARCHAR2(255), 
	"EDI_LOAD_PROCEDURE_NM" VARCHAR2(61), 
	"EDI_ORG_NBR_TRADING_PARTNER" NUMBER(9,0)
   ) ;
