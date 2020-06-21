truncate_ic_item_stats:
    sql: > truncate table ic_item_stat
    description: delete all the rows from ic_item_stat
distinct_cust_open_order_count:
    sql: > update ic_item_stat
           set distinct_cust_open_order_count = 
           ( select count(distinct org_nbr_cst 
             from oe_ord_hdr_dtl_vw
           ) 
    description: distinct cust open order count
number_of_open_orders
    sql: >
    description: number of open orders
number_of_distinct_customer_quotes_last_three_months:
    sql: > update  ic_item_stats (
           select count(distinct(org_nbr_cst) 
           from sq_qte_vw 
    distinct_customer_quotes_prev_3_months 
    description: Count distinct customer quotes last three months
max_sales_price_last_three_months
    sql: >
    description: Max sales price last three months
quote_conversion_ratio:
    sql: >
    description: quote conversion ratio
dollars_open_orders:
    sql: >
    description: Dollar open orders
number_of_customers_open_orders:
    sql: > update  ic_item_stats (
           select count(distinct(org_nbr_cst) 
           from oe_ord_hdr_dtl_vw
           where ord_stat_id = 'O'
    description: number of distinct open order customers
abc_code:    
    sql> 
    description: Pareto code
    narrative: >
      A,B,C classification
      compute aggregate sum of dollars
      Basing on shipments does not reflect new items
      Basing on open orders the dollar totals will be low for new items
unallocated_order_qty:
    description: Unalloc ord qty
    sql: >
percent_of_open_orders_base_curr
    sql: >
    description: Percent of open orders for base currency
