--------------------------------------------------------
--  DDL for Table CAL_DT
--------------------------------------------------------

  CREATE TABLE "CAL_DT" 
   (	"CAL_DT" DATE, 
	"CALENDAR" VARCHAR2(6), 
	"CYCLE" NUMBER(4,0), 
	"INTVL" NUMBER(2,0), 
	"INTVL_PCT" NUMBER(6,3), 
	"WORK_DAY_FLG" VARCHAR2(1), 
	"PRD_START_DT" DATE, 
	"CAL_QTR" NUMBER(1,0), 
	"WORK_DAY_NBR" NUMBER(6,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 983040 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;

   COMMENT ON COLUMN "CAL_DT"."CAL_DT" IS 'The relevent date.';
   COMMENT ON COLUMN "CAL_DT"."CALENDAR" IS 'The business calendar associated with this date.';
   COMMENT ON COLUMN "CAL_DT"."WORK_DAY_FLG" IS 'W - Work Day
N  - Non Work Day
H  - Holiday (non work day that would normally be a work day based on the day of the week';
   COMMENT ON COLUMN "CAL_DT"."CAL_QTR" IS 'The calendar quarter associated with this date.';
   COMMENT ON COLUMN "CAL_DT"."WORK_DAY_NBR" IS 'A relative work day number within the calendar.  System generated for calculated elapsed work days between two dates, finding a date ''x'' work days in the future, etc.';
