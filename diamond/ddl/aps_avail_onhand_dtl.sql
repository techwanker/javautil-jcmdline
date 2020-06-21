create or replace view aps_avail_onhand_dtl as
SELECT ib.facility,
    iil.aps_sply_sub_pool_nbr,
    ilm.org_nbr_mfr,
    ilm.org_nbr_vnd,
    iil.lot_nbr,
    ilm.lot_cost_um AS lot_um,
    ilm.item_nbr,
    date_trunc('day'::text, COALESCE(iil.avail_dt, 'now'::text::timestamp without time zone)) AS avail_dt,
    iilb.box_qty AS onhand_qty,
    ilm.rev_lvl,
    ilm.lot_nbr AS pk_supply,
    iil.lot_nbr || '-' || iil.aps_sply_sub_pool_nbr || '-' || ib.facility || '-' || to_char(date_trunc('day', COALESCE(iil.avail_dt, 'now')),'YYYYMMDD')
    AS sply_identifier,
    ilm.lot_cost,
    ilm.cntry_cd_origin,
    ilm.mfr_date,
    ilm.expire_dt,
    ilm.rcpt_dt,
        CASE
            WHEN iil.avail_dt IS NULL THEN 'F'::text
            ELSE 'P'::text
        END AS avail_dt_id
   FROM ic_lot_mast ilm,
    ic_item_loc iil,
    ic_bin ib,
    ic_item_loc_box iilb
  WHERE ilm.qty_on_hand_flg::text = 'Y'::text AND 
	iil.ic_item_loc_nbr = iilb.ic_item_loc_nbr AND 
        iil.bin_nbr = ib.bin_nbr AND 
        ilm.lot_nbr = iil.lot_nbr AND 
        iilb.box_stat_id::text <> 'LST'::text;


