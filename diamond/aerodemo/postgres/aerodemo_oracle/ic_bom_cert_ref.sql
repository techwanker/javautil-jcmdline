alter table ic_bom_cert add constraint
ibc_iim_1_fk foreign key
(item_nbr) references ic_item_mast;

alter table ic_bom_cert add constraint
ibc_iim_2_fk foreign key
(item_nbr) references ic_item_mast;

