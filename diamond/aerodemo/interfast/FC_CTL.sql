--------------------------------------------------------
--  DDL for Table FC_CTL
--------------------------------------------------------

  CREATE TABLE "FC_CTL" 
   (	"RUN_DATE" DATE, 
	"PRD_PER_CYCLE" NUMBER(2,0), 
	"CYCLE" NUMBER(4,0), 
	"PRD" NUMBER(2,0), 
	"INTVL_PER_CYCLE" NUMBER(4,0), 
	"INTVL" NUMBER(2,0), 
	"NEXT_RUN_NBR" NUMBER(4,0), 
	"CYCLE_NM" VARCHAR2(6), 
	"INTVL_NM" VARCHAR2(6), 
	"PRD_NM" VARCHAR2(6), 
	"FC_REG_NBR" NUMBER(10,0), 
	"SAFETY_STK_LEAD_TM_FLG" VARCHAR2(1), 
	"CARRY_COST" NUMBER(3,3), 
	"AQUIS_COST" NUMBER(5,2), 
	"HIT_CNT_FORCE_MDL_OTHER" NUMBER(2,0), 
	"HIT_CNT_FORCE_MDL_UNDER" NUMBER(2,0), 
	"HIT_CNT_COST" NUMBER(7,2), 
	"HIT_CNT" NUMBER(2,0)
   ) ;
