--------------------------------------------------------
--  DDL for Table TMP_IC_ITEM_MAST_ATTR
--------------------------------------------------------

  CREATE GLOBAL TEMPORARY TABLE "TMP_IC_ITEM_MAST_ATTR" 
   (	"ITEM_NBR" NUMBER(9,0), 
	"USER_FLD_1" VARCHAR2(20), 
	"USER_FLD_2" VARCHAR2(20), 
	"USER_FLD_3" VARCHAR2(20), 
	"USER_FLD_4" VARCHAR2(20), 
	"USER_FLD_5" VARCHAR2(20), 
	"USER_FLD_6" VARCHAR2(20), 
	"USER_FLD_7" VARCHAR2(20), 
	"USER_FLD_8" VARCHAR2(20), 
	"ATTR_STRING" VARCHAR2(200)
   ) ON COMMIT PRESERVE ROWS ;
