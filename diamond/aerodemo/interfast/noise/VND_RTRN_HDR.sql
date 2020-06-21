--------------------------------------------------------
--  DDL for Table VND_RTRN_HDR
--------------------------------------------------------

  CREATE TABLE "VND_RTRN_HDR" 
   (	"VND_RTRN_HDR_NBR" NUMBER(9,0), 
	"VND_RTRN_CREATE_DT" DATE, 
	"ORG_NBR_VND" NUMBER(9,0), 
	"CURR_CD" VARCHAR2(3), 
	"RMA_CD_VND" VARCHAR2(20), 
	"VND_RMA_RECV_DT" DATE, 
	"SHIP_TO_ADDR_NBR" NUMBER(9,0), 
	"VND_RTRN_STAT_ID" VARCHAR2(1), 
	"VND_RTRN_POST_DT" DATE, 
	"UT_USER_NBR_CREATE" NUMBER(9,0), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"ORG_CD_VND" VARCHAR2(16), 
	"SHIP_TO_ADDR_CD" VARCHAR2(8), 
	"SHIP_TO_ADDR_DESCR" VARCHAR2(60), 
	"SHIP_TO_ADDR_1" VARCHAR2(30), 
	"SHIP_TO_ADDR_2" VARCHAR2(30), 
	"SHIP_TO_ADDR_3" VARCHAR2(30), 
	"SHIP_TO_CITY" VARCHAR2(25), 
	"SHIP_TO_STATE_CD" VARCHAR2(5), 
	"SHIP_TO_POSTAL_CD" VARCHAR2(10), 
	"SHIP_TO_CNTRY_CD" VARCHAR2(3), 
	"INV_CD_VND" VARCHAR2(20), 
	"VND_SHIP_VIA_ACCT_CD" VARCHAR2(20)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 196608 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;

   COMMENT ON COLUMN "VND_RTRN_HDR"."VND_RTRN_STAT_ID" IS 'N - New,
	W - Review Pending, R - Ready for Post, P - Posted,
	T - Transferred to Accounting';
