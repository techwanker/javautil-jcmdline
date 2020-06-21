
alter table plan_po alter column  unit_cost type numeric(18,6);
alter table vq_na_org alter column  calendar type varchar(6);
alter table ic_lot_mast alter column box_qty type numeric(12,5);
alter table fc_ctl alter column aquis_cost type numeric(12,5);
alter table fc_item_dflt alter column aquis_cost type numeric(12,5);
alter table fc_item_dflt alter column aquis_cost type numeric(12,5);
drop table databasechangelog;
