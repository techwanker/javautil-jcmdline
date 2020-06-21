

alter table plan_po alter column type  unit_cost numeric(18,6);
alter table idl_ar_inv_dtl alter column type  cust_po_cd varchar(30);
alter table fc_fcst_mdl alter column type  fc_fcst_mdl_nbr smallint;
alter table fc_item_fcst_mdl alter column type  fc_fcst_mdl_nbr smallint;
drop table y;
drop table jhi_authority cascade constraints;
drop table jhi_persistent_audit_evt_data cascade constraints;
alter table idl_so_hist_dtl alter column unit_price type numeric(17,6);
alter table po_ord_dtl alter column unit_cost type numeric(17,6);
alter table po_line_hdr alter column unit_cost type numeric(17,6);
alter table plan_po alter column unit_cost type numeric(17,6);
alter table idl_po_ord_dtl alter column unit_cost type numeric(17,6);
alter table ic_item_vnd_cost_matrix alter column unit_cost type numeric(17,6);
alter table ic_item_cost alter column unit_cost type numeric(17,6);
alter table ut_table alter column table_name type varchar(64);
alter table ut_table alter column table_name type varchar(64);


alter table idl_so_hist_dtl alter column type  unit_cost_stk_um numeric(17,6);
alter table plan_po alter column  type unit_cost_stk_um numeric(17,6);
alter table fc_item_mast  alter column  unit_cost_stk_um type numeric(17,6);
alter table fim_attr alter column  unit_cost_stk_um type numeric(17,6);
alter table fc_item_fcst_mdl alter column  safety_stk_max_unit type numeric(17,6);
alter table fc_item_mast alter column  safety_stk_max_unit type numeric(17,6);
alter table fc_item_dflt alter column  safety_stk_max_unit type numeric(17,6);
alter table fim_attr alter column  safety_stk_max_unit type numeric(17,6);

alter table fc_item_mast alter column  safety_stk_min_unit type numeric(17,6);
alter table fc_item_dflt alter column  safety_stk_min_unit type numeric(17,6);
alter table fim_attr alter column  safety_stk_min type numeric(17,6);
alter table idl_oe_ord_dtl alter column  ship_from_facility type varchar(16);
alter table idl_oe_ord_dtl alter column  ship_via_cd type varchar(8);

