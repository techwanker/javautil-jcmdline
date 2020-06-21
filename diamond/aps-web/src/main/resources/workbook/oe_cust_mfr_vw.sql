create or replace view oe_cust_mfr_vw as
select 
 ocm.item_nbr,
 iim.item_cd,
 ocm.org_nbr_cust,
 cust.org_cd org_cd_cust,
 ocm.org_nbr_mfr,
 mfr.org_cd org_cd_mfr,
 ocm.eff_dt_beg,
 ocm.eff_dt_end,
 ocm.mfr_restrict_id
from oe_cust_mfr ocm,
     ic_item_mast iim,
     na_org mfr,
     na_org cust
where
   ocm.item_nbr = iim.item_nbr and
   ocm.org_nbr_cust = cust.org_nbr and
   ocm.org_nbr_mfr = mfr.org_nbr;
