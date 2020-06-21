select distinct org_nbr_vnd 
from ar_inv_dtl 
where org_nbr_vnd not in 
(
	select org_nbr_vnd from po_mfr_mast
);
