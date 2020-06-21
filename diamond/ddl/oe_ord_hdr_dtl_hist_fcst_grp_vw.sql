create view oe_ord_dtl_hist_fcst_grp_vw as
select 
 ooh.oe_ord_hdr_nbr,
 ooh.ord_dt,
 ooh.ord_stat_id,
 ooh.org_nbr_cust,
 ooh.org_cd_cust,
 ooh.curr_cd,
 ooh.ord_type_cd,
 ooh.ord_cd,
 ood.item_nbr_rqst,
 ood.item_nbr_ord,
 ood.qty_ord,
 ood.qty_ord_stk_um,
 ood.sell_um,
 ood.rqst_dt,
 to_char(rqst_dt,'YYYY-MM') rqst_mnth,
 ood.unit_price_sell_um,
 ood.unit_price_denom_sell_um,
 ood.unit_price_stk_um,
 ood.unit_price_denom_stk_um,
 ood.item_cd_cust,
 ood.aps_src_rule_set_nbr,
 ood.org_nbr_mfr_rqst,
 ood.lot_not_expire_before_dt,
 ood.lot_manufacture_after_dt,
 ood.cntry_cd_origin,
 ood.rev_lvl,
 ood.qty_ship
from oe_ord_dtl ood,
     oe_ord_hdr ooh
where ood.oe_ord_hdr_nbr = ooh.oe_ord_hdr_nbr;

