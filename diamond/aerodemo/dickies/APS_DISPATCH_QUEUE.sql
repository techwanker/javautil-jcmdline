--------------------------------------------------------
--  DDL for Table APS_DISPATCH_QUEUE
--------------------------------------------------------

  CREATE TABLE "APS_DISPATCH_QUEUE" 
   (	"ITEM_NBR" NUMBER(9,0), 
	"DISPATCH_TIME" DATE, 
	"PLAN_GRP_NBR" NUMBER(9,0), 
	 CONSTRAINT "APS_DISPATCH_QUEUE_PK" PRIMARY KEY ("ITEM_NBR") ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  ORGANIZATION INDEX NOCOMPRESS PCTFREE 10 INITRANS 2 MAXTRANS 255 LOGGING
  STORAGE(INITIAL 262144 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" 
 PCTTHRESHOLD 50;
