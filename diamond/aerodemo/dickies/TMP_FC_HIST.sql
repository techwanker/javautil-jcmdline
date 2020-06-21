--------------------------------------------------------
--  DDL for Table TMP_FC_HIST
--------------------------------------------------------

  CREATE GLOBAL TEMPORARY TABLE "TMP_FC_HIST" 
   (	"FC_ITEM_MAST_NBR" NUMBER(9,0), 
	"DMD_DT" DATE, 
	"DMD_ADJ" NUMBER
   ) ON COMMIT PRESERVE ROWS ;
