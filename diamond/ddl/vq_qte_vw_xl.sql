drop view vq_qte_vw_xl;
create view vq_qte_vw_xl as
sELECT 
    item_cd_qte,
    org_nm,
    vq_qte_eff_dt,
    qte_qty_stk_um,
    qte_cost,
    qte_cost_stk_um,
    qte_cost_denom,
    vq_qte_dt,
    vq_qte_cd,
    rqst_dt,
    prom_dt,
    vq_qte_exp_dt,
    --vnd_qte_ref_cd,
    --transmit_flg,
    qte_cost_denom_stk_um,
    rev_lvl,
    lead_tm_wk_prom,
    vq_lost_cd,
    --item_cd_vnd,
    item_nbr_qte
    --org_cd,
    -- vq_qte_hdr_nbr,
    -- org_nbr_mfr_rqst,
    --curr_cd_qte,
    --vq_qte_indiv_nbr,
    --indiv_nm_spoken_to,
    --indiv_phn_nbr,
    --indiv_fax_nbr,
    --indiv_email_addr,
    -- qte_um,
    -- qte_qty,
    -- org_nbr_vnd,
    -- qte_cost,
    -- qte_cost_denom,
    --vq_qte_dtl_nbr,
   FROM vq_qte_vw
   where qte_cost is not null
   order by  
    item_cd_qte,
    org_nm,
    vq_qte_eff_dt,
    qte_qty_stk_um;

