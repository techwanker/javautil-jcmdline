--------------------------------------------------------
--  DDL for Table FIM_ATTRS
--------------------------------------------------------

  CREATE GLOBAL TEMPORARY TABLE "FIM_ATTRS" 
   (	"FC_ITEM_MAST_NBR" NUMBER(9,0), 
	"ATTR_VAL_1" VARCHAR2(16), 
	"ATTR_VAL_2" VARCHAR2(16), 
	"ATTR_VAL_3" VARCHAR2(16), 
	"ATTR_VAL_4" VARCHAR2(16), 
	"ATTR_VAL_5" VARCHAR2(16), 
	"ATTR_VAL_6" VARCHAR2(16), 
	"ATTR_VAL_7" VARCHAR2(16), 
	"ATTR_VAL_8" VARCHAR2(16)
   ) ON COMMIT DELETE ROWS ;
