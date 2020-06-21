drop table ic_item_stat;

create table ic_item_stat (
    item_nbr integer primary key references ic_item_mast,
    abc_cd  varchar(1),
    distinct_open_ord_cust_count integer,
    distinct_org_cust_qte          integer,
    distinct_cust_open_order_count integer
);

alter table ic_item_stat add(
	check (abc_cd in ('A','B','C')
);

