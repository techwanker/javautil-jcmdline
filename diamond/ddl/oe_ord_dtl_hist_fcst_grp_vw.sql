drop view oe_ord_dtl_hist_fcst_grp_vw;
create view oe_ord_dtl_hist_fcst_grp_vw as
select 
 ooh.oe_ord_hdr_nbr,
 ooh.ord_dt,
 ooh.ord_stat_id,
 ooh.org_nbr_cust,
 no.org_cd org_cd_cust,
 iim.item_cd,
 ocm.fcst_grp,
 ooh.curr_cd,
 ooh.ord_type_cd,
 ooh.ord_cd,
 ood.item_nbr_ord,
 ood.qty_ord_stk_um,
 ood.rqst_dt,
 to_char(rqst_dt,'YYYY-MM') rqst_mnth,
 ood.prom_dt_orig,
 ood.unit_price_sell_um,
 ood.unit_price_stk_um,
 ood.unit_price_denom_sell_um,
 ood.unit_price_denom_stk_um,
 ood.item_cd_cust,
 ood.sell_um,
 ood.aps_src_rule_set_nbr,
 ood.org_nbr_mfr_rqst,
 ood.lot_not_expire_before_dt,
 ood.lot_manufacture_after_dt,
 ood.cntry_cd_origin,
 ood.rev_lvl,
 ood.qty_ship,
 ood.item_nbr_rqst,
 ood.qty_ord
from oe_ord_dtl ood,
     oe_ord_hdr ooh,
     na_org     no,
     oe_cust_mast ocm,
     ic_item_mast iim
where ood.oe_ord_hdr_nbr = ooh.oe_ord_hdr_nbr and
      no.org_nbr = ooh.org_nbr_cust and
      no.org_nbr = ooh.org_nbr_cust and
      iim.item_nbr = ood.item_nbr_ord


