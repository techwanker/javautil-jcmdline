alter table ic_bom add constraint icb_iim_fk 
foreign key (item_nbr) references ic_item_mast;
