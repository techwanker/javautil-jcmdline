create or replace view aps_avail_onhand_dtl_multi_vw 
as 
 SELECT 
    facility,
    'N' multi_cert_flg,
    aps_sply_pool_cd,
    aps_sply_sub_pool_cd,
    sply_pool_type_id, 
    org_cd,
    org_nbr_vnd,
    lot_nbr,
    lot_um,
    item_cd,
    item_nbr,
    avail_dt,
    onhand_qty,
    rev_lvl,
    pk_supply,
    lot_cost,
    cntry_cd_origin,
    mfr_date,
    expire_dt,
    rcpt_dt,
    avail_dt_id
   FROM aps_avail_onhand_dtl_vw
 union
 SELECT 
    aaodv.facility,
    'Y' multi_cert_flg,
    aaodv.aps_sply_pool_cd,
    aaodv.aps_sply_sub_pool_cd,
    aaodv.sply_pool_type_id, 
    aaodv.org_cd,
    aaodv.org_nbr_vnd,
    aaodv.lot_nbr,
    aaodv.lot_um,
    aaodv.item_cd,
    aaodv.item_nbr,
    aaodv.avail_dt,
    aaodv.onhand_qty,
    aaodv.rev_lvl,
    aaodv.pk_supply,
    aaodv.lot_cost,
    aaodv.cntry_cd_origin,
    aaodv.mfr_date,
    aaodv.expire_dt,
    aaodv.rcpt_dt,
    aaodv.avail_dt_id
   FROM aps_avail_onhand_dtl_vw aaodv,
      ic_multiple_cert imc,
      ic_item_mast     iim
   where imc.lot_nbr = aaodv.lot_nbr and
      iim.item_nbr = aaodv.item_nbr;

