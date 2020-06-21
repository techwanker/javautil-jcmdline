demand_shortage:
   sql: >
   select * from 
           SELECT item_nbr_rqst,
           iim.item_cd,
           iim.item_descr,
           SUM(DECODE(oe_ord_dtl_nbr, NULL, 0, 1))       oo_cnt,
           SUM(DECODE(oe_ord_dtl_nbr, NULL, 0, dmd_qty)) tot_oo_dmd,
           SUM(DECODE(wo_dtl_nbr, NULL, 0, 1))           wo_cnt,
           SUM(DECODE(wo_dtl_nbr, NULL, 0, dmd_qty))     tot_wo_dmd,
           SUM(DECODE(fc_item_mast_nbr, NULL, 0, 
               decode(substr(dmd_identifier, 1, 2),' || '''' || 'SS' || ''' ||,1,0))) ss_cnt,
           SUM(DECODE(fc_item_mast_nbr, NULL, 0, 
               decode(substr(dmd_identifier, 1, 2),' || '''' || 'SS' || ''' ||,dmd_qty,0))) tot_ss_dmd,
           SUM(DECODE(fc_item_mast_nbr, NULL, 0, 
               decode(substr(dmd_identifier, 1, 2),' || '''' || 'FC' || ''' ||,1,0))) fc_cnt,
           SUM(DECODE(fc_item_mast_nbr, NULL, 0, 
               decode(substr(dmd_identifier, 1, 2),' || '''' || 'FC' || ''' ||,dmd_qty,0))) tot_fc_dmd,
           SUM(dmd_qty) tot_dmd_qty,
           (select sum(iilb.box_qty) 
           from ic_item_loc_box  iilb,
                 ic_item_loc      iil,
                 ic_lot_mast      ilm 
           where iil.ic_item_loc_nbr = iilb.ic_item_loc_nbr and 
                 iil.lot_nbr = ilm.lot_nbr and 
                 ilm.item_nbr = ardd.item_nbr_rqst and 
                 iilb.box_stat_id != ' || '''' || 'LST' || '''' || ') on_hand, 
           (SELECT SUM(sched_qty_stk_um - NVL(recv_qty_stk_um,0)) 
             FROM po_ord_Dtl 
             WHERE  item_nbr = ardd.item_nbr_rqst AND 
                   po_cancel_cd IS NULL AND 
                   line_cancel_cd IS NULL AND 
                   sched_cancel_cd IS NULL AND 
                   ord_stat_id = ' || '''' || 'O' || '''' || ' AND 
                   line_stat_Id = ' || '''' || 'O' || '''' || ' AND 
                   (sched_qty_stk_um - NVL(recv_qty_stk_um,0) > 0)) po_qty, 
           (SELECT SUM(rqst_qty - NVL(fill_qty,0)) 
            FROM WO_HDR 
            WHERE wo_stat_id = ' || '''' || 'O' || '''' || ' AND 
                  item_nbr_rqst = ardd.item_nbr_rqst) wo_qty, 
           min(decode(sign(dmd_qty - rqst_dt_alloc_qty),1,rqst_dt,null)) earliest_rqst_dt,
           min(decode(sign(dmd_qty - alloc_qty),1,rqst_dt,null)) earliest_unalloc_dt,
           (select min(note) 
             from ut_note 
             where table_id = get_table_id(' || '''' || 'IC_ITEM_MAST' || '''' || ') 
             and table_key = ardd.item_nbr_rqst 
             and note_type_cd = ' || '''' || 'AVL' || '''' || ' 
             and rownum = 1) item_note 
       FROM aps_result_dtl_dmd ardd, 
            ic_item_mast iim 
