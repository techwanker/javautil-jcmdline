alter table ic_item_cost
add constraint
iic_iim_fk foreign key
(item_nbr) references ic_item_mast;
