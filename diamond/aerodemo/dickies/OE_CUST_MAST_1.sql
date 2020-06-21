--------------------------------------------------------
--  DDL for Table OE_CUST_MAST
--------------------------------------------------------

  CREATE TABLE "OE_CUST_MAST" 
   (	"ORG_NBR_CUST" NUMBER(9,0), 
	"STAT_ID" VARCHAR2(1), 
	"CUST_PRICE_GRP" VARCHAR2(10), 
	"CUST_GRP" VARCHAR2(8), 
	"SIC_CD" VARCHAR2(8), 
	"REQR_PO_FLG" VARCHAR2(1), 
	"CONTRACT_CUST_FLG" VARCHAR2(1), 
	"PRICE_CHG_FLG" VARCHAR2(1), 
	"TRD_FLG" VARCHAR2(1), 
	"TRD_GL_ACCT" VARCHAR2(20), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"SELL_INDIV_NBR" NUMBER(9,0), 
	"INTRO_DT" DATE, 
	"VIRTUAL_CUST_FLG" VARCHAR2(1), 
	"SHIP_TO_ADDR_NBR_DFLT" NUMBER(9,0), 
	"BILL_TO_ADDR_NBR_DFLT" NUMBER(9,0), 
	"TERM_CD_DFLT" VARCHAR2(10), 
	"SHIP_VIA_CD_DFLT" VARCHAR2(8), 
	"FOB_CD_DFLT" VARCHAR2(8), 
	"CURR_CD_DFLT" VARCHAR2(3), 
	"SHIP_PCT_LINE_DFLT" NUMBER(5,2), 
	"SHIP_PCT_DOLLAR_DFLT" NUMBER(5,2), 
	"CUST_ALLOC_PRTY" NUMBER(3,0), 
	"ORD_TYPE_CD_DFLT" VARCHAR2(8), 
	"DUP_PO_ALLOW_FLG" VARCHAR2(1), 
	"CREDIT_LIMIT" NUMBER(12,2), 
	"CURR_AR_BAL" NUMBER(10,2), 
	"SALES_TERR_CD_DFLT" VARCHAR2(8), 
	"LABEL_NM_BAG" VARCHAR2(20), 
	"LABEL_NM_PACK_BOX" VARCHAR2(20), 
	"PACK_BOX_CONTENTS_RPT_NM" VARCHAR2(255), 
	"PACK_SLIP_RPT_NM" VARCHAR2(255), 
	"SHOW_PRICE_ON_PACK_SLIP_FLG" VARCHAR2(1) DEFAULT 'N', 
	"NBR_PACK_SLIP_COPIES" NUMBER(2,0) DEFAULT 1, 
	"ADD_ADDR_FLG" VARCHAR2(1) DEFAULT 'Y', 
	"FCST_GRP" VARCHAR2(8), 
	"SUMMARY_INV_RPT_NM" VARCHAR2(255), 
	"AVG_DAYS_TO_PAY" NUMBER(3,0), 
	"INDIV_NBR_CUST_CONTACT" NUMBER(9,0), 
	"NBR_INVOICE_COPIES" NUMBER(2,0) DEFAULT 1, 
	"AR_INTEGRATION_TM" DATE, 
	"SALES_REGION_CD_DFLT" VARCHAR2(8), 
	"SHIP_LINE_PCT_DFLT" NUMBER(3,0), 
	"AUTO_CLOSE_LINE_PCT_DFLT" NUMBER(3,0), 
	"MAX_SHIPMENTS_PER_LINE_DFLT" NUMBER(2,0), 
	"ORG_NBR_CUST_PARENT" NUMBER(9,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 524288 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DIAMOND" ;

   COMMENT ON COLUMN "OE_CUST_MAST"."ORG_NBR_CUST" IS 'Surrogate key that identifies this customer.';
   COMMENT ON COLUMN "OE_CUST_MAST"."PRICE_CHG_FLG" IS '?????????????';
   COMMENT ON COLUMN "OE_CUST_MAST"."TRD_GL_ACCT" IS 'The General Ledger account to be used to track the due/from due/to amount for the customer if the customer is a trading customer.';
   COMMENT ON COLUMN "OE_CUST_MAST"."SELL_INDIV_NBR" IS 'Identifies the individual that is the sales manager for this customer.';
   COMMENT ON COLUMN "OE_CUST_MAST"."INTRO_DT" IS 'The date this customer relationship was established.';
   COMMENT ON COLUMN "OE_CUST_MAST"."VIRTUAL_CUST_FLG" IS 'If ''Y'' this customer may be used for multiple customers.  Useful for cash and over the counter sales.';
   COMMENT ON COLUMN "OE_CUST_MAST"."SHIP_TO_ADDR_NBR_DFLT" IS 'Identifies the default ship to address for the customer.';
   COMMENT ON COLUMN "OE_CUST_MAST"."BILL_TO_ADDR_NBR_DFLT" IS 'Identifies the default bill to address for the customer.';
   COMMENT ON COLUMN "OE_CUST_MAST"."TERM_CD_DFLT" IS 'The default payment terms for the customer, used as a default when creating customer orders.';
   COMMENT ON COLUMN "OE_CUST_MAST"."SHIP_VIA_CD_DFLT" IS 'Identifier for default mechanism for shipping to this customer.';
   COMMENT ON COLUMN "OE_CUST_MAST"."CURR_CD_DFLT" IS 'The default currency code that the customer will use when placing orders.';
   COMMENT ON COLUMN "OE_CUST_MAST"."SHIP_PCT_LINE_DFLT" IS 'The default percentage of lines which must be fulfilled on the first shipment to this customer.';
   COMMENT ON COLUMN "OE_CUST_MAST"."SHIP_PCT_DOLLAR_DFLT" IS 'The default percentage of the value of the order which should be shipped to the customer on the first shipment.';
   COMMENT ON COLUMN "OE_CUST_MAST"."CUST_ALLOC_PRTY" IS 'The relative priority for this customer as demand when allocating inventory.';
   COMMENT ON COLUMN "OE_CUST_MAST"."ORD_TYPE_CD_DFLT" IS 'The type of order to be used as a default for this customer.';
   COMMENT ON COLUMN "OE_CUST_MAST"."DUP_PO_ALLOW_FLG" IS '''Y'' Allow multiple sales orders to this customer to have the same purchase order number.';
   COMMENT ON COLUMN "OE_CUST_MAST"."CREDIT_LIMIT" IS 'The maximum amount of credit allowed for this customer as open receivables before ???';
   COMMENT ON COLUMN "OE_CUST_MAST"."CURR_AR_BAL" IS 'The current receivables balance from this customer.';
   COMMENT ON COLUMN "OE_CUST_MAST"."SALES_TERR_CD_DFLT" IS 'The sales territory associated with this customer.';
   COMMENT ON COLUMN "OE_CUST_MAST"."LABEL_NM_BAG" IS 'The name of the label identifier to be used when creating custom labels on inner packing for the customer.';
   COMMENT ON COLUMN "OE_CUST_MAST"."LABEL_NM_PACK_BOX" IS 'The name of the label to be used on boxes packed for this customer.';
   COMMENT ON COLUMN "OE_CUST_MAST"."PACK_BOX_CONTENTS_RPT_NM" IS 'The name of the report to be used when generating a box contents report for this customer.';
   COMMENT ON COLUMN "OE_CUST_MAST"."PACK_SLIP_RPT_NM" IS 'The name of the report to be used when generating a packing slip for this customer.';
   COMMENT ON COLUMN "OE_CUST_MAST"."SHOW_PRICE_ON_PACK_SLIP_FLG" IS 'If ''Y'' show the price on the packing slip.';
   COMMENT ON COLUMN "OE_CUST_MAST"."NBR_PACK_SLIP_COPIES" IS 'The number of packing slips to be included with a shipment.';
   COMMENT ON COLUMN "OE_CUST_MAST"."ADD_ADDR_FLG" IS '''Y'' - allow new addresses to be created for this customer during the order entry process.';
   COMMENT ON COLUMN "OE_CUST_MAST"."FCST_GRP" IS 'The group to which this customer is to be aggregated when forecasting.';
   COMMENT ON COLUMN "OE_CUST_MAST"."SUMMARY_INV_RPT_NM" IS 'The name of the report which creates the summary invoice for this customer.';
   COMMENT ON COLUMN "OE_CUST_MAST"."AVG_DAYS_TO_PAY" IS 'Historical average days to pay';
   COMMENT ON COLUMN "OE_CUST_MAST"."INDIV_NBR_CUST_CONTACT" IS 'Identifies the primary sales contact for this customer.';
   COMMENT ON COLUMN "OE_CUST_MAST"."NBR_INVOICE_COPIES" IS 'The number of invoice copies that should be printed for this customer.';
   COMMENT ON COLUMN "OE_CUST_MAST"."AR_INTEGRATION_TM" IS 'Time the last Accounts Receivable integration run was made for this customer.';
   COMMENT ON COLUMN "OE_CUST_MAST"."SALES_REGION_CD_DFLT" IS 'The sales region to be used by default when creating new orders for this customer.';
   COMMENT ON COLUMN "OE_CUST_MAST"."SHIP_LINE_PCT_DFLT" IS 'The default percentage of lines that should be shippable for this customer on the first shipment.';
   COMMENT ON COLUMN "OE_CUST_MAST"."MAX_SHIPMENTS_PER_LINE_DFLT" IS 'The default maximum number of shipments for a line when creating new orders for this custoemr.';
   COMMENT ON COLUMN "OE_CUST_MAST"."ORG_NBR_CUST_PARENT" IS 'The customer that is the owning entity of this subsidiary.';
