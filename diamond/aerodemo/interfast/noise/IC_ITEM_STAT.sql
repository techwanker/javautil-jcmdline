--------------------------------------------------------
--  DDL for Table IC_ITEM_STAT
--------------------------------------------------------

  CREATE TABLE "IC_ITEM_STAT" 
   (	"ITEM_NBR" NUMBER(9,0), 
	"DISTINCT_CUST_OPEN_ORDER_COUNT" NUMBER(9,0), 
	"DISTINCT_ORG_CUST_QTE" NUMBER(9,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "DIAMOND" ;
