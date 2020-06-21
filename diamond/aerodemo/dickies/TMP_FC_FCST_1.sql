--------------------------------------------------------
--  DDL for Table TMP_FC_FCST
--------------------------------------------------------

  CREATE GLOBAL TEMPORARY TABLE "TMP_FC_FCST" 
   (	"FC_ITEM_MAST_NBR" NUMBER(9,0), 
	"FC_FCST_DT" DATE, 
	"ADJ_FCST" NUMBER
   ) ON COMMIT PRESERVE ROWS ;
