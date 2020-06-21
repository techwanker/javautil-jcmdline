--------------------------------------------------------
--  DDL for Table IDL_PO_ORD_DTL
--------------------------------------------------------

  CREATE TABLE "IDL_PO_ORD_DTL" 
   (	"IDL_PO_ORD_DTL_NBR" NUMBER(9,0), 
	"PO_CD" VARCHAR2(20), 
	"CURR_CD" VARCHAR2(3), 
	"PO_DT" DATE, 
	"ORG_CD_VND" VARCHAR2(16), 
	"PO_LINE_NBR" VARCHAR2(5), 
	"ITEM_CD" VARCHAR2(50), 
	"REPLEN_UM" VARCHAR2(3), 
	"UNIT_COST" NUMBER, 
	"REPLEN_QTY" NUMBER, 
	"REPLEN_CURR_EST_DT" DATE, 
	"DELIVERY_FACILITY" VARCHAR2(16), 
	"DELIVERY_SPLY_POOL_CD" VARCHAR2(20), 
	"RECV_QTY" NUMBER, 
	"OPEN_QTY" NUMBER, 
	"REPLEN_CURR_EST_DT_TXT" VARCHAR2(16), 
	"PO_DT_TXT" VARCHAR2(16)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 3145728 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;

   COMMENT ON COLUMN "IDL_PO_ORD_DTL"."IDL_PO_ORD_DTL_NBR" IS 'Surrogate key for internal purposes.';
   COMMENT ON COLUMN "IDL_PO_ORD_DTL"."PO_CD" IS 'Legacy purchase order code, identifies the purchase order.';
   COMMENT ON COLUMN "IDL_PO_ORD_DTL"."CURR_CD" IS 'The ANSI X.12 currency code associated with the unit cost.';
   COMMENT ON COLUMN "IDL_PO_ORD_DTL"."PO_DT" IS 'The date the purchase order was created.';
   COMMENT ON COLUMN "IDL_PO_ORD_DTL"."ORG_CD_VND" IS 'Identifies the organization from which this is being purchased.';
   COMMENT ON COLUMN "IDL_PO_ORD_DTL"."PO_LINE_NBR" IS 'Identifier for the line on the purchase order.';
   COMMENT ON COLUMN "IDL_PO_ORD_DTL"."ITEM_CD" IS 'The part identifier.';
   COMMENT ON COLUMN "IDL_PO_ORD_DTL"."REPLEN_UM" IS 'ANSI X.12 unit of measure.';
   COMMENT ON COLUMN "IDL_PO_ORD_DTL"."UNIT_COST" IS 'Cost per unit in the replenishment unit of measure and currency.';
   COMMENT ON COLUMN "IDL_PO_ORD_DTL"."REPLEN_QTY" IS 'Replenishment quantity in the replenishment unit of measure.';
   COMMENT ON COLUMN "IDL_PO_ORD_DTL"."REPLEN_CURR_EST_DT" IS 'Current estimated availability date of the schedule.';
   COMMENT ON COLUMN "IDL_PO_ORD_DTL"."DELIVERY_FACILITY" IS 'Identifier for  the facility to which the goods are to be delivered.';
   COMMENT ON COLUMN "IDL_PO_ORD_DTL"."DELIVERY_SPLY_POOL_CD" IS 'Identifier for the supply pool which is to be replenished.';
   COMMENT ON TABLE "IDL_PO_ORD_DTL"  IS 'Interface table for purchase orders to vendors, not to be used for purchase orders from customers.';
