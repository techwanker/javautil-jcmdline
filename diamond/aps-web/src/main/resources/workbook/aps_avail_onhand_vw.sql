create or replace view aps_avail_onhand_vw as
select
 a.facility,              
 a.aps_sply_sub_pool_nbr,
 a.org_nbr_mfr,
 mfr.org_cd org_cd_mfr,
 a.org_nbr_vnd,
 vorg.org_cd org_cd_vend,
 a.lot_nbr,
 a.lot_um,
 a.item_nbr,
 iim.item_cd,
 iim.item_descr,
 a.avail_dt,
 a.gross_avail_qty,
 a.rev_lvl,
 a.pk_supply,
 a.sply_identifier,
 a.lot_cost,
 a.cntry_cd_origin,
 a.mfr_date,
 a.expire_dt,
 a.rcpt_dt,
 a.avail_dt_id
from 
    aps_avail_onhand a,
    ic_item_mast iim,
    na_org vorg,
    na_org mfr
where a.item_nbr = iim.item_nbr and
  vorg.org_nbr = a.org_nbr_vnd and
  mfr.org_nbr = a.org_nbr_mfr 
