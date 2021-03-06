create view sq_qte_vw_xl 
as
 SELECT sq_qte_hdr_nbr,
    sq_qte_cd,
    org_nbr_cust,
    curr_cd_qte,
    sq_qte_eff_dt,
    sq_qte_exp_dt,
    org_nm_cust,
    item_nbr_qte,
    item_cd_qte,
    item_cd_cust,
    qte_qty,
    qte_price_stk_um,
    org_nbr_mfr_rqst,
    rqst_dt,
    lead_tm_wk_prom,
    prom_dt,
    sq_lost_cd
    -- oe_ord_dtl_nbr,
    --sq_qte_dtl_nbr,
    -- cust_qte_ref_cd,
    -- transmit_flg,
    -- qte_um,
    -- qte_qty_stk_um,
    -- qte_price,
    -- qte_price_denom,
    -- qte_price_denom_stk_um,
    -- indiv_nm_spoken_to,
    -- rev_lvl,
    -- qte_price_basis_id,
    -- qte_price_basis_key,
    -- qte_price_basis_cost,
    -- sq_qte_indiv_nbr,
    -- indiv_phn_nbr,
    -- indiv_fax_nbr,
    -- indiv_email_addr,
    -- ut_user_nbr AS ut_user_nbr_hdr,
    -- last_mod_dt AS last_mod_dt_hdr
   FROM sq_qte_vw;


