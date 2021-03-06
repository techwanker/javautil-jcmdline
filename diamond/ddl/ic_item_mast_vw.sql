create view ic_item_mast_vw
as 
select
  iim.item_cd,
  iim.item_nbr,
  iim.item_descr,
  iim.stk_um,
  iim.sell_um,
  iim.std_cost,
  iim.list_price,
  iim.upc_cd,
  iim.ean,
  iim.qty_per_box,
  iim.box_per_ctn,
  iim.sls_qty_min,
  iim.sls_qty_incr,
  iim.replen_qty_min,
  iim.replen_qty_incr,
  iim.ic_category_nbr,
  ic.ic_category_nm,
  iim.non_stk_flg,
  iim.ser_nbr_reqr_flg,
  iim.mfr_ser_nbr_reqr_flg,
  iim.inspect_reqr_flg,
  iim.mfr_lot_ctrl_flg,
  iim.kit_flg,
  iim.price_chg_flg,
  iim.ut_user_nbr,
  iim.last_mod_dt,
  iim.sell_flg,
  iim.harmonized_cd,
  iim.plan_bucket_sz,
  iim.curr_cd,
  iim.reqr_mfr_flg,
  iim.shelf_life_dy,
  iim.lead_tm_dy,
  iim.indiv_nbr_buyer,
  buyer.sort_nm,
  iim.stat_id,
  iim.pick_scan_id,
  iim.intro_dt,
  iim.split_at_bin_flg,
  iim.label_nm_box,
  iim.ic_recv_rule_cd,
  iim.cycle_cnt_rule_cd,
  iim.fifo_dt_id,
  iim.replen_type_id,
  iim.item_nbr_primary,
  iim.item_nbr_supersede,
  iim.sched_qty_optimal,
  iim.img_image_set_hdr_nbr,
  iim.item_wght,
  iim.ctn_volume,
  iim.user_fld_1,
  iim.user_fld_2,
  iim.user_fld_3,
  iim.user_fld_4,
  iim.user_fld_5,
  iim.user_fld_6,
  iim.user_fld_7,
  iim.user_fld_8,
  iim.user_fld_9
  from ic_item_mast iim,
       ic_category  ic,
       na_indiv     buyer
  where iim.ic_category_nbr = ic.ic_category_nbr and
        iim.indiv_nbr_buyer = buyer.indiv_nbr;
