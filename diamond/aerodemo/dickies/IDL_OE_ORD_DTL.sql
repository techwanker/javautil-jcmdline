--------------------------------------------------------
--  DDL for Table IDL_OE_ORD_DTL
--------------------------------------------------------

  CREATE TABLE "IDL_OE_ORD_DTL" 
   (	"IDL_OE_ORD_DTL_NBR" VARCHAR2(9), 
	"ORD_CD" VARCHAR2(20), 
	"ORD_DT" DATE, 
	"ORD_TYPE_CD" VARCHAR2(8), 
	"ORG_CD_CUST" VARCHAR2(16), 
	"CUST_PO_CD" VARCHAR2(30), 
	"TERM_CD" VARCHAR2(10), 
	"SHIP_VIA_CD" VARCHAR2(16), 
	"FOB_CD" VARCHAR2(16), 
	"CURR_CD" VARCHAR2(3), 
	"SALES_TERR_CD" VARCHAR2(8), 
	"LINE_NBR" VARCHAR2(5), 
	"ITEM_CD" VARCHAR2(50), 
	"ITEM_CD_CUST" VARCHAR2(50), 
	"QTY_ORD" NUMBER, 
	"SELL_UM" VARCHAR2(3), 
	"RQST_DT" DATE, 
	"PROM_DT" DATE, 
	"SHIP_FROM_FACILITY" VARCHAR2(16), 
	"ORD_DT_TEXT" VARCHAR2(16), 
	"RQST_DT_TEXT" VARCHAR2(16), 
	"PROM_DT_TEXT" VARCHAR2(16)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 59768832 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;

   COMMENT ON COLUMN "IDL_OE_ORD_DTL"."IDL_OE_ORD_DTL_NBR" IS 'Surrogate key for internal purposes.';
   COMMENT ON COLUMN "IDL_OE_ORD_DTL"."ORD_CD" IS 'The sales order identifier for all lines on a particular sales order.';
   COMMENT ON COLUMN "IDL_OE_ORD_DTL"."ORD_DT" IS 'The date the order was placed.  May differ for every line.';
   COMMENT ON COLUMN "IDL_OE_ORD_DTL"."ORD_TYPE_CD" IS 'Identifier for the type of order, e.g. PHN - phone, EDI - X.12, FAX, MAIL, WEB, SOA - web service';
   COMMENT ON COLUMN "IDL_OE_ORD_DTL"."ORG_CD_CUST" IS 'Identifier for the customer that placed the order.';
   COMMENT ON COLUMN "IDL_OE_ORD_DTL"."CUST_PO_CD" IS 'The purchase order number for this line assigned by the customer.';
   COMMENT ON COLUMN "IDL_OE_ORD_DTL"."TERM_CD" IS 'Payment terms code.';
   COMMENT ON COLUMN "IDL_OE_ORD_DTL"."SHIP_VIA_CD" IS 'The shipment method, identifies the carrier and priority.';
   COMMENT ON COLUMN "IDL_OE_ORD_DTL"."FOB_CD" IS 'Free on Board code.  Identifies when the customer takes ownership of this inventory.';
   COMMENT ON COLUMN "IDL_OE_ORD_DTL"."CURR_CD" IS 'The X.12 currency associated with the price of this line.';
   COMMENT ON COLUMN "IDL_OE_ORD_DTL"."SALES_TERR_CD" IS 'The sales territory that gets credit for this sale.';
   COMMENT ON COLUMN "IDL_OE_ORD_DTL"."LINE_NBR" IS 'The line number on the sales order.';
   COMMENT ON COLUMN "IDL_OE_ORD_DTL"."ITEM_CD" IS 'The primary product code of the selling institution for this part.';
   COMMENT ON COLUMN "IDL_OE_ORD_DTL"."ITEM_CD_CUST" IS 'The part number the customer uses to identify this part.';
   COMMENT ON COLUMN "IDL_OE_ORD_DTL"."QTY_ORD" IS 'The quantity ordered';
   COMMENT ON COLUMN "IDL_OE_ORD_DTL"."SELL_UM" IS 'ANSI X.12 unit of measure associated with the quantity ordered.';
   COMMENT ON COLUMN "IDL_OE_ORD_DTL"."RQST_DT" IS 'The date the customer requests the item to be shipped.';
   COMMENT ON COLUMN "IDL_OE_ORD_DTL"."PROM_DT" IS 'The most recent promise date.';
   COMMENT ON COLUMN "IDL_OE_ORD_DTL"."SHIP_FROM_FACILITY" IS 'The facility from which this order line should preferably be shipped.';
   COMMENT ON TABLE "IDL_OE_ORD_DTL"  IS 'Interface table for customer order lines.';
