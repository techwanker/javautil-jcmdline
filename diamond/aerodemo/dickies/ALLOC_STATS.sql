--------------------------------------------------------
--  DDL for Table ALLOC_STATS
--------------------------------------------------------

  CREATE TABLE "ALLOC_STATS" 
   (	"NBR_OO_OLD" NUMBER(9,0), 
	"NBR_OO_NEW" NUMBER(9,0), 
	"NBR_WO_OLD" NUMBER(9,0), 
	"NBR_WO_NEW" NUMBER(9,0), 
	"NBR_SS_OLD" NUMBER(9,0), 
	"NBR_SS_NEW" NUMBER(9,0), 
	"NBR_FC_OLD" NUMBER(9,0), 
	"NBR_FC_NEW" NUMBER(9,0), 
	"NBR_OO_ALLOC_FULL_OLD" NUMBER(9,0), 
	"NBR_OO_ALLOC_FULL_NEW" NUMBER(9,0), 
	"NBR_WO_ALLOC_FULL_OLD" NUMBER(9,0), 
	"NBR_WO_ALLOC_FULL_NEW" NUMBER(9,0), 
	"NBR_SS_ALLOC_FULL_OLD" NUMBER(9,0), 
	"NBR_SS_ALLOC_FULL_NEW" NUMBER(9,0), 
	"NBR_FC_ALLOC_FULL_OLD" NUMBER(9,0), 
	"NBR_FC_ALLOC_FULL_NEW" NUMBER(9,0), 
	"NBR_OO_UNALLOC_OLD" NUMBER(9,0), 
	"NBR_OO_UNALLOC_NEW" NUMBER(9,0), 
	"NBR_WO_UNALLOC_OLD" NUMBER(9,0), 
	"NBR_WO_UNALLOC_NEW" NUMBER(9,0), 
	"NBR_SS_UNALLOC_OLD" NUMBER(9,0), 
	"NBR_SS_UNALLOC_NEW" NUMBER(9,0), 
	"NBR_FC_UNALLOC_OLD" NUMBER(9,0), 
	"NBR_FC_UNALLOC_NEW" NUMBER(9,0), 
	"NBR_OO_ALLOC_FULL_ONTIME_OLD" NUMBER(9,0), 
	"NBR_OO_ALLOC_FULL_ONTIME_NEW" NUMBER(9,0), 
	"NBR_WO_ALLOC_FULL_ONTIME_OLD" NUMBER(9,0), 
	"NBR_WO_ALLOC_FULL_ONTIME_NEW" NUMBER(9,0), 
	"NBR_SS_ALLOC_FULL_ONTIME_OLD" NUMBER(9,0), 
	"NBR_SS_ALLOC_FULL_ONTIME_NEW" NUMBER(9,0), 
	"NBR_FC_ALLOC_FULL_ONTIME_OLD" NUMBER(9,0), 
	"NBR_FC_ALLOC_FULL_ONTIME_NEW" NUMBER(9,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;
