--------------------------------------------------------
--  DDL for Table APS_CTL
--------------------------------------------------------

  CREATE TABLE "APS_CTL" 
   (	"PIPE_NM" VARCHAR2(80), 
	"PIPE_NM_SYNCH" VARCHAR2(80), 
	"LOCK_PICK" VARCHAR2(1), 
	"PUSH_WINDOW_DY" NUMBER(3,0), 
	"PUSH_LIMIT_COST" NUMBER(8,0), 
	"PUSH_LIMIT_PCT" NUMBER(3,0), 
	"PULL_WINDOW_DY" NUMBER(3,0), 
	"PULL_LIMIT_PCT" NUMBER(3,0), 
	"ASYNCH_NOTIFY_PIPE_NM" VARCHAR2(80)
   ) ;
