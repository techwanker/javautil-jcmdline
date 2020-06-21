--------------------------------------------------------
--  DDL for Table WH_PICK_SIM_COP
--------------------------------------------------------

  CREATE TABLE "WH_PICK_SIM_COP" 
   (	"OE_ORD_DTL_NBR" NUMBER(9,0), 
	"IC_ITEM_LOC_NBR" NUMBER(9,0), 
	"BOX_CD" VARCHAR2(20), 
	"PICKABLE_BIN_FLG" VARCHAR2(1), 
	"ALLOC_LOT_FLG" VARCHAR2(1), 
	"BOX_STAT_OK_FLG" VARCHAR2(1), 
	"NO_TIE_CD_FLG" VARCHAR2(1), 
	"FACILITY_OK_FLG" VARCHAR2(1), 
	"NO_LINE_HOLD_FLG" VARCHAR2(1), 
	"NO_ORD_HOLD_FLG" VARCHAR2(1), 
	"ACTIVE_SHIP_VIA_FLG" VARCHAR2(1), 
	"WITHIN_HORIZON_FLG" VARCHAR2(1), 
	"ORD_SHIP_PCT_OK_FLG" VARCHAR2(1) DEFAULT 'Y', 
	"LINE_SHIP_PCT_OK_FLG" VARCHAR2(1) DEFAULT 'Y', 
	"MAX_SHIPMENT_QTY_OK_FLG" VARCHAR2(1) DEFAULT 'Y'
   ) ;

   COMMENT ON COLUMN "WH_PICK_SIM_COP"."PICKABLE_BIN_FLG" IS 'A "Y" indicates that Lot allocated to the Order is in a Pickable Bin.
A "N" indicates that the Lot is not in a Pickable Bin';
   COMMENT ON COLUMN "WH_PICK_SIM_COP"."ALLOC_LOT_FLG" IS 'A "Y" indicates that the Order Line has an Allocation for it. A "N" indicates
 that there are no Allocatios for the Order ';
   COMMENT ON COLUMN "WH_PICK_SIM_COP"."BOX_STAT_OK_FLG" IS 'A "Y" indicates that the Box belonging to the Lot allocated to the Order Line
 has an acceptable picking status. A "N" indicates the the current Box Status
renders it unfit for picking ';
   COMMENT ON COLUMN "WH_PICK_SIM_COP"."NO_TIE_CD_FLG" IS 'A "Y" indicates that the Order Line has an Allocation for it. A "N" indicates
 that there are no Allocatios for the Order ';
   COMMENT ON COLUMN "WH_PICK_SIM_COP"."FACILITY_OK_FLG" IS 'A "Y" indicates that the Ship From Facility on the Order Line matches the
facility where the allocated stock is located. A "N" indicates that it is not';
   COMMENT ON COLUMN "WH_PICK_SIM_COP"."NO_LINE_HOLD_FLG" IS 'A "Y" indicates that there are no holds on the Order Line. A "N" indicates that
the Order Line is on Hold ';
   COMMENT ON COLUMN "WH_PICK_SIM_COP"."NO_ORD_HOLD_FLG" IS 'A "Y" indicates that there are no holds on the Order. A "N" indicates that
the Order is on Hold ';
   COMMENT ON COLUMN "WH_PICK_SIM_COP"."ACTIVE_SHIP_VIA_FLG" IS 'A "Y" indicates that the Ship Via Code is Active for the Facility the Order
Line will be Shipped from. A "N" indicates that Ship Via Code is not Active';
   COMMENT ON COLUMN "WH_PICK_SIM_COP"."WITHIN_HORIZON_FLG" IS 'A "Y" indicates that the Requested Ship Date on the Order Line is within the
Ship Horizon for the Ship Via Code and the Facility the Order Line will be
Shipped from. A "N" indicates that Requested Date is beyond the Horizon';
