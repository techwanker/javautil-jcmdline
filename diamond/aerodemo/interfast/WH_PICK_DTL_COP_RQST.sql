--------------------------------------------------------
--  DDL for Table WH_PICK_DTL_COP_RQST
--------------------------------------------------------

  CREATE TABLE "WH_PICK_DTL_COP_RQST" 
   (	"WH_PICK_DTL_COP_RQST_NBR" NUMBER(9,0), 
	"WH_PICK_BATCH_COP_NBR" NUMBER(9,0), 
	"IC_ITEM_LOC_NBR" NUMBER(9,0), 
	"BOX_CD" VARCHAR2(20), 
	"COP_PICK_QTY_RQST" NUMBER(13,5), 
	"COP_PICK_QTY_ACT" NUMBER(13,5), 
	"OE_ORD_DTL_NBR" NUMBER(9,0), 
	"APS_ALLOC_ONHAND_OO_NBR" NUMBER(9,0), 
	"WH_PICK_DTL_COP_RQST_NBR_SRC" NUMBER(9,0), 
	"BOX_CNT" NUMBER(5,0), 
	"BOX_CD_DEST" VARCHAR2(20), 
	"PICK_SCAN_CD" VARCHAR2(20)
   ) ;
