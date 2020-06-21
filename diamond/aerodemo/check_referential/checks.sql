select distinct org_nbr_vnd from ic_lot_mast 
except select org_nbr_vnd
 from po_vnd_mast;

select distinct org_nbr_vnd from ic_vnd_onhand
except select org_nbr_vnd from po_vnd_mast;
