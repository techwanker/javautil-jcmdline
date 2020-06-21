drop table ic_item_stat;

create table ic_item_stat (
    item_nbr number(9) primary key references ic_item_mast,
    distinct_cust_open_order_count number(9),
    distinct_org_cust_qte          number(9)
);

