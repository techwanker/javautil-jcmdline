            select
                facility,              
                aps_sply_sub_pool_nbr,
                org_nbr_mfr,
                org_cd_mfr,
                org_nbr_vnd,
                org_cd_vend,
                lot_nbr,
                lot_um,
                item_nbr,
                item_cd,
                item_descr,
                avail_dt,
                gross_avail_qty,
                rev_lvl,
                pk_supply,
                sply_identifier,
                lot_cost,
                cntry_cd_origin,
                mfr_date,
                expire_dt,
                rcpt_dt,
                avail_dt_id
            from 
                aps_avail_onhand_vw 
            where 
                item_nbr in (
                    select item_nbr
                    from aps_plan_grp 
                    where plan_grp_nbr = 10
                ) 
