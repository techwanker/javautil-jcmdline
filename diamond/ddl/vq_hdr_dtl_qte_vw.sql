drop view vq_qte_hdr_dtl_vw;

create or replace view vq_qte_hdr_dtl_vw as
select
 h.VQ_QTE_HDR_NBR,
 h.VQ_QTE_CD,
 h.ORG_NBR_VND,
 v.org_cd,
 v.org_nm,
 h.VQ_QTE_DT,
 h.CURR_CD_QTE,
 h.INDIV_NM_SPOKEN_TO,
 h.INDIV_PHN_NBR,
 h.INDIV_FAX_NBR,
 h.INDIV_EMAIL_ADDR,
 h.VQ_QTE_EFF_DT,
 h.VQ_QTE_EXP_DT,
 h.VND_QTE_REF_CD,
 h.VQ_QTE_INDIV_NBR,
 h.TRANSMIT_FLG,
 d.VQ_QTE_DTL_NBR,
 d.ITEM_NBR_QTE,
 d.ITEM_CD_QTE,
 d.ITEM_CD_VND,
 d.QTE_UM,
 d.QTE_QTY,
 d.QTE_QTY_STK_UM,
 d.QTE_COST,
 d.QTE_COST_DENOM,
 d.QTE_COST_STK_UM,
 d.QTE_COST_DENOM_STK_UM,
 d.ORG_NBR_MFR_RQST,
 d.REV_LVL,
 d.RQST_DT,
 d.LEAD_TM_WK_PROM,
 d.PROM_DT,
 d.VQ_LOST_CD,
 i.item_cd,
 i.item_descr 
from
  vq_qte_hdr h,
  vq_qte_dtl d,
  ic_item_mast i,
  na_org v
where h.vq_qte_hdr_nbr = d.vq_qte_hdr_nbr and
  i.item_nbr = d.item_nbr_qte and 
  v.org_nbr = h.org_nbr_vnd;
;--
