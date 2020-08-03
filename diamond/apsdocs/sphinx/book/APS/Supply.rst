Tables
======
ALL_SUPPLY and APS_SUPPLY
-------------------------

 Name		       Type
 ----------------- ------------
 SPLY_IDENTIFIER   VARCHAR2(61)
 AVAIL_TYPE_CD	   CHAR(1)
 LOT_NBR		   NUMBER
 ITEM_NBR		   NUMBER(9)
 FACILITY		   VARCHAR2(16)
 APS_SPLY_SUB_POOL NUMBER(9)
 _NBR
 ORG_NBR_MFR		    NUMBER
 ORG_NBR_VND		    NUMBER
 AVAIL_DT		    DATE
 GROSS_AVAIL_QTY	    NUMBER
 LOT_UM 		    VARCHAR2(3)
 REV_LVL		    VARCHAR2(5)
 PK_SUPPLY		    NUMBER(9)
 LOT_COST		    NUMBER
 CNTRY_CD_ORIGIN	    VARCHAR2(3)
 MFR_DATE		    DATE
 EXPIRE_DT		    DATE
 RCPT_DT		    DATE
 APS_AVAIL_DT		    DATE
 WO_ITEM_NBR		    NUMBER
 AVAIL_DT_ID		    VARCHAR2(1)  -   DECODE(iil.avail_dt, NULL, 'F', 'P')	avail_dt_id
 
 PO_LINE_HDR_NBR	    NUMBER

:: 

 SELECT sply_identifier,
  'O',
  lot_nbr,
  item_nbr,
  facility,
  aps_sply_sub_pool_nbr,
  org_nbr_mfr,
  org_nbr_vnd,
  avail_dt,
  gross_avail_qty,
  lot_um,
  rev_lvl,
  pk_supply,
  lot_cost,
  cntry_cd_origin,
  mfr_date,
  expire_dt,
  rcpt_dt,
  avail_dt,
  TO_NUMBER(NULL)     wo_item_nbr,
  avail_dt_id,
  to_number(null) po_line_hdr_nbr
 FROM
   aps_avail_onhand
 UNION ALL
 SELECT tar.sply_identifier,
  'R',
  TO_NUMBER(NULL),
  tar.item_nbr,
  tar.facility,
  tar.aps_sply_sub_pool_nbr,
  tar.org_nbr_mfr,
  tar.org_nbr_vnd,
  tar.avail_dt,
  tar.gross_avail_qty,
  tar.replen_um,
  tar.rev_lvl,
  tar.po_line_dtl_nbr,
  tar.unit_cost_stk_um,
  tar.cntry_cd_origin,
  tar.lot_manufacture_after_dt,
  tar.lot_not_expire_before_dt,
  TO_DATE(NULL),
  tar.aps_avail_dt,
  TO_NUMBER(NULL)      wo_item_nbr,
  NULL					avail_dt_id,
  tar.po_line_Hdr_Nbr
 FROM
  aps_avail_replen  tar
 UNION ALL
 SELECT /*+ use_nl(iii woh) index (woh) */
  TO_CHAR(woh.wo_hdr_nbr)     sply_identifier,
  'W',
  TO_NUMBER(NULL),
  woh.item_nbr_rqst,
  woh.facility,
  woh.aps_sply_sub_pool_nbr,
  TO_NUMBER(NULL),
  TO_NUMBER(NULL),
  woh.need_by_dt       avail_dt,
  woh.rqst_qty - NVL(woh.fill_qty,0)  gross_avail_qty,
  woh.wo_um,
  TO_CHAR(NULL)       rev_lvl,
  woh.wo_hdr_nbr,
  TO_NUMBER(NULL),
  TO_CHAR(NULL),
  TO_DATE(NULL),
  TO_DATE(NULL),
  TO_DATE(NULL),
  woh.need_by_dt,
  woh.item_nbr_rqst	 wo_item_nbr,
  NULL					avail_dt_id,
  to_number(null)
 FROM
   wo_hdr   woh
 WHERE
   woh.wo_stat_id  = 'O'
 
