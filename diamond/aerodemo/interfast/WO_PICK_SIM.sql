--------------------------------------------------------
--  DDL for Table WO_PICK_SIM
--------------------------------------------------------

  CREATE TABLE "WO_PICK_SIM" 
   (	"WO_RELEASE_NBR" NUMBER(9,0), 
	"WO_DTL_NBR" NUMBER(9,0), 
	"IC_ITEM_LOC_NBR" NUMBER(9,0), 
	"PICKABLE_BIN_FLG" VARCHAR2(1), 
	"ALLOC_LOT_FLG" VARCHAR2(1), 
	"IC_WHSE_ZONE_GRP_FLG" VARCHAR2(1), 
	"WH_PICK_RULE_WO_CD" VARCHAR2(16), 
	"BOX_CD" VARCHAR2(20), 
	"BOX_STAT_OK_FLG" VARCHAR2(1), 
	"QTY_IN_PICK_WO" NUMBER(12,5)
   ) ;
