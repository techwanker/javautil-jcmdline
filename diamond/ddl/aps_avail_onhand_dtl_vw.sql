drop view aps_avail_onhand_dtl_vw;
create or replace view aps_avail_onhand_dtl_vw 
as 
 SELECT 
    aaod.facility,
    assp.aps_sply_pool_cd,
    assp.aps_sply_sub_pool_cd,
    assp.sply_pool_type_id, 
    -- aps_sply_sub_pool_nbr,
    --org_nbr_mfr,
    om.org_cd,
    aaod.org_nbr_vnd,
    aaod.lot_nbr,
    aaod.lot_um,
    iim.item_cd,
    aaod.item_nbr,
    aaod.avail_dt,
    aaod.onhand_qty,
    aaod.rev_lvl,
    aaod.pk_supply,
    aaod.lot_cost,
    aaod.cntry_cd_origin,
    aaod.mfr_date,
    aaod.expire_dt,
    aaod.rcpt_dt,
    aaod.avail_dt_id
   FROM aps_avail_onhand_dtl aaod,
        aps_sply_sub_pool    assp,
        na_org               om,
        ic_item_mast         iim
  WHERE aaod.aps_sply_sub_pool_nbr = assp.aps_sply_sub_pool_nbr
     and om.org_nbr = aaod.org_nbr_mfr 
     and iim.item_nbr = aaod.item_nbr;
