--------------------------------------------------------
--  DDL for Table AR_RMA_DTL
--------------------------------------------------------

  CREATE TABLE "AR_RMA_DTL" 
   (	"AR_RMA_DTL_NBR" NUMBER(9,0), 
	"RMA_CD" VARCHAR2(20), 
	"AR_RMA_LINE_NBR" NUMBER(3,0), 
	"RMA_REASON_CD" VARCHAR2(8), 
	"AR_INV_DTL_NBR" NUMBER(9,0), 
	"ITEM_NBR" NUMBER(9,0), 
	"ITEM_CD" VARCHAR2(50), 
	"ITEM_DESCR" VARCHAR2(50), 
	"SELL_UM" VARCHAR2(3), 
	"QTY_RTRN_AUTH" NUMBER(13,5), 
	"QTY_RTRN_AUTH_STK_UM" NUMBER(13,5), 
	"QTY_RECEIVED" NUMBER(13,5), 
	"QTY_RECEIVED_STK_UM" NUMBER(13,5), 
	"QTY_ACCEPTED" NUMBER(13,5), 
	"QTY_ACCEPTED_STK_UM" NUMBER(13,5), 
	"QTY_CREDITED" NUMBER(13,5), 
	"QTY_CREDITED_STK_UM" NUMBER(13,5), 
	"UNIT_PRICE_STK_UM" NUMBER(17,6), 
	"UNIT_PRICE_DENOM_STK_UM" NUMBER(17,6), 
	"UNIT_PRICE_SELL_UM" NUMBER(17,6), 
	"UNIT_PRICE_DENOM_SELL_UM" NUMBER(17,6), 
	"CREDIT_PRICE_DENOM" NUMBER(17,6), 
	"CREDIT_PRICE" NUMBER(17,6), 
	"UT_USER_NBR" NUMBER(9,0), 
	"LAST_MOD_DT" DATE, 
	"UNIT_COST_STK_UM" NUMBER(17,6), 
	"UNIT_COST_DENOM_STK_UM" NUMBER(17,6), 
	"UNIT_COST_SELL_UM" NUMBER(17,6), 
	"UNIT_COST_DENOM_SELL_UM" NUMBER(17,6)
   ) ;

   COMMENT ON COLUMN "AR_RMA_DTL"."AR_RMA_DTL_NBR" IS 'The surrogate primary key for this table.';
   COMMENT ON COLUMN "AR_RMA_DTL"."RMA_CD" IS 'Foreign key back to the AR_RMA_HDR header';
   COMMENT ON COLUMN "AR_RMA_DTL"."ITEM_NBR" IS 'A foreign key back to the item master.';
   COMMENT ON COLUMN "AR_RMA_DTL"."ITEM_CD" IS 'The Part Number that is being returned.
Subsequent changes to the the item code on the item master on not reflected here, to facilitate reprinting of RMAs.';
   COMMENT ON COLUMN "AR_RMA_DTL"."ITEM_DESCR" IS 'The description from the item master at the time the RMA was created';
   COMMENT ON COLUMN "AR_RMA_DTL"."SELL_UM" IS 'Selling unit of measure.';
   COMMENT ON COLUMN "AR_RMA_DTL"."UNIT_PRICE_STK_UM" IS 'cost per unit in the base currency for the stock keeping unit of measure';
   COMMENT ON COLUMN "AR_RMA_DTL"."UNIT_PRICE_DENOM_STK_UM" IS 'cost per unit in the denominated currency for the stock keeping unit of measure';
   COMMENT ON COLUMN "AR_RMA_DTL"."UNIT_PRICE_SELL_UM" IS 'cost per unit in the base currency for the selling unit of measure';
   COMMENT ON COLUMN "AR_RMA_DTL"."UNIT_PRICE_DENOM_SELL_UM" IS 'cost per unit in the denominated currency for the selling unit of measure';
   COMMENT ON COLUMN "AR_RMA_DTL"."CREDIT_PRICE_DENOM" IS 'Restocking Charge per unit in the Invoice currency';
   COMMENT ON COLUMN "AR_RMA_DTL"."CREDIT_PRICE" IS 'Restocking Charge per unit in the base currency';
   COMMENT ON TABLE "AR_RMA_DTL"  IS 'This table stores the details of all the RMA''s issued';
