    truncate ic_item_stat;

    insert into ic_item_stat (item_nbr)
           select item_nbr from ic_item_mast;
    update ic_item_stat stat
           set distinct_cust_open_order_count =
           ( select count(distinct (org_nbr_cust ))
             from oe_ord_hdr_dtl_vw ord
             where ord.item_nbr_ord = stat.item_nbr
           );
    update ic_item_stat 
           set distinct_org_cust_qte = (
           select count(distinct(org_nbr_cust))
           from sq_qte_vw
           where sq_qte_vw.item_nbr_qte = ic_item_stat.item_nbr
           );
