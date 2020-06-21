select
   VQ_QTE_HDR_NBR,
   VQ_QTE_CD,
   ORG_NBR_VND,
   org_cd,
   org_nm,
   VQ_QTE_DT,
   CURR_CD_QTE,
   INDIV_NM_SPOKEN_TO,
   INDIV_PHN_NBR,
   INDIV_FAX_NBR,
   INDIV_EMAIL_ADDR,
   VQ_QTE_EFF_DT,
   VQ_QTE_EXP_DT,
   VND_QTE_REF_CD,
   VQ_QTE_INDIV_NBR,
   TRANSMIT_FLG,
   VQ_QTE_DTL_NBR,
   ITEM_NBR_QTE,
   ITEM_CD_QTE,
   ITEM_CD_VND,
   QTE_UM,
   QTE_QTY,
   QTE_QTY_STK_UM,
   QTE_COST,
   QTE_COST_DENOM,
   QTE_COST_STK_UM,
   QTE_COST_DENOM_STK_UM,
   ORG_NBR_MFR_RQST,
   REV_LVL,
   RQST_DT,
   LEAD_TM_WK_PROM,
   PROM_DT,
   VQ_LOST_CD,
   item_cd,
   item_descr 
from
  vq_qte_hdr_dtl_vw 
where 
  item_nbr_qte in (
      select item_nbr 
      from aps_plan_grp
      where plan_grp_nbr = 10
  );
