--------------------------------------------------------
--  DDL for Table TMP_ITEM
--------------------------------------------------------

  CREATE GLOBAL TEMPORARY TABLE "TMP_ITEM" 
   (	"ITEM_NBR" NUMBER(9,0), 
	"ITEM_REL_ID" VARCHAR2(1)
   ) ON COMMIT DELETE ROWS ;
