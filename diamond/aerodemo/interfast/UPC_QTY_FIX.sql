--------------------------------------------------------
--  DDL for Table UPC_QTY_FIX
--------------------------------------------------------

  CREATE TABLE "UPC_QTY_FIX" 
   (	"LOT_NBR" NUMBER(9,0), 
	"FACILITY" VARCHAR2(16), 
	"APS_SPLY_SUB_POOL_NBR" NUMBER(9,0), 
	"QTY_START" NUMBER(13,5), 
	"QTY_RECV" NUMBER(13,5), 
	"QTY_ADJUST_IN" NUMBER(13,5), 
	"QTY_ADJUST_OUT" NUMBER(13,5), 
	"QTY_SHIP" NUMBER(13,5), 
	"QTY_FAC_TRANS_IN" NUMBER(13,5), 
	"QTY_FAC_TRANS_OUT" NUMBER(13,5), 
	"QTY_ON_HAND" NUMBER(13,5)
   ) ;
