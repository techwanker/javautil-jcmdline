delete from ic_vnd_onhand where org_nbr_vnd in
(
select distinct org_nbr_vnd from ic_vnd_onhand
except select org_nbr_vnd from po_vnd_mast
);
