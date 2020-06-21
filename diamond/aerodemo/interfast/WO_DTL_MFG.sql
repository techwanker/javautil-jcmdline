--------------------------------------------------------
--  DDL for Table WO_DTL_MFG
--------------------------------------------------------

  CREATE TABLE "WO_DTL_MFG" 
   (	"WO_DTL_MFG_NBR" NUMBER(9,0), 
	"WO_HDR_NBR" NUMBER(9,0), 
	"OPERATION_CD" VARCHAR2(16), 
	"OPERATION_SEQ_NBR" NUMBER(3,0), 
	"WORK_STATION_CD" VARCHAR2(16), 
	"ORG_NBR_VND" NUMBER(9,0), 
	"WO_MFG_CHARGE_CD" VARCHAR2(8), 
	"QTY_ISSUED" NUMBER(13,5), 
	"QTY_YIELD" NUMBER(13,5), 
	"EST_COMPLETE_DT" DATE, 
	"ACT_COMPLETE_DT" DATE, 
	"OPERATION_COST" NUMBER(8,2), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"FACILITY" VARCHAR2(16)
   ) ;
