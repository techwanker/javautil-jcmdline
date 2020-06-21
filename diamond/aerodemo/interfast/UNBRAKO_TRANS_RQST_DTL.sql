--------------------------------------------------------
--  DDL for Table UNBRAKO_TRANS_RQST_DTL
--------------------------------------------------------

  CREATE TABLE "UNBRAKO_TRANS_RQST_DTL" 
   (	"TRANS_DTL_NBR" NUMBER, 
	"TRANS_HDR_NBR" NUMBER, 
	"LINE_STAT_ID" VARCHAR2(1), 
	"ITEM_CD" VARCHAR2(50), 
	"QTY_RQST" NUMBER(13,5), 
	"QTY_SHIP" NUMBER, 
	"RQST_DT" DATE, 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE
   ) ;
