select
  item_cd, 
  item_descr, 
  stk_um, 
  sell_um,
  std_cost, 
  list_price, 
  kit_flg,
  sell_flg,
  harmonized_cd,
  reqr_mfr_flg,
  shelf_life_dy,
  lead_tm_dy,
  sort_nm,
  stat_id,
  pick_scan_id,
  intro_dt,
  ic_recv_rule_cd,
  fifo_dt_id,
  replen_type_id,
  sched_qty_optimal,
  user_fld_1,
  user_fld_2,
  user_fld_3,
  user_fld_4,
  user_fld_5,
  user_fld_6,
  user_fld_7,
  user_fld_8,
  user_fld_9
  /*
  item_nbr,
  ic_category_nbr,
  upc_cd, ean,
  qty_per_box, box_per_ctn, sls_qty_min, sls_qty_incr,
  replen_qty_min, replen_qty_incr, ic_category_nm, non_stk_flg,
  ser_nbr_reqr_flg,
  mfr_ser_nbr_reqr_flg,
  inspect_reqr_flg,
  mfr_lot_ctrl_flg,
  price_chg_flg,
  ut_user_nbr,
  last_mod_dt,
  plan_bucket_sz,
  curr_cd,
  indiv_nbr_buyer,
  cycle_cnt_rule_cd,
  img_image_set_hdr_nbr,
  item_wght,
  ctn_volume,
  item_nbr_primary,
  item_nbr_supersede,
  split_at_bin_flg,
  label_nm_box
  */
from ic_item_mast_vw
