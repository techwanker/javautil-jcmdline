package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * PoReschedVw generated by hbm2java
 */
@Entity
@Table(name="PO_RESCHED_VW"
)
public class PoReschedVw  implements java.io.Serializable {


     private PoReschedVwId id;

    public PoReschedVw() {
    }

    public PoReschedVw(PoReschedVwId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="poLineDtlNbr", column=@Column(name="PO_LINE_DTL_NBR", precision=9, scale=0) ), 
        @AttributeOverride(name="reschedDt", column=@Column(name="RESCHED_DT", length=7) ), 
        @AttributeOverride(name="reschedQty", column=@Column(name="RESCHED_QTY", precision=13, scale=5) ), 
        @AttributeOverride(name="orgNbrVnd", column=@Column(name="ORG_NBR_VND", precision=9, scale=0) ), 
        @AttributeOverride(name="poLineHdrNbr", column=@Column(name="PO_LINE_HDR_NBR", precision=9, scale=0) ), 
        @AttributeOverride(name="poLineNbr", column=@Column(name="PO_LINE_NBR", precision=3, scale=0) ), 
        @AttributeOverride(name="itemNbr", column=@Column(name="ITEM_NBR", precision=9, scale=0) ), 
        @AttributeOverride(name="itemCd", column=@Column(name="ITEM_CD", length=50) ), 
        @AttributeOverride(name="itemDescr", column=@Column(name="ITEM_DESCR", length=50) ), 
        @AttributeOverride(name="stkUm", column=@Column(name="STK_UM", length=3) ), 
        @AttributeOverride(name="replenUm", column=@Column(name="REPLEN_UM", length=3) ), 
        @AttributeOverride(name="unitCostStkUm", column=@Column(name="UNIT_COST_STK_UM", precision=17, scale=6) ), 
        @AttributeOverride(name="schedQtyStkUm", column=@Column(name="SCHED_QTY_STK_UM", precision=13, scale=5) ), 
        @AttributeOverride(name="recvQtyStkUm", column=@Column(name="RECV_QTY_STK_UM", precision=13, scale=5) ), 
        @AttributeOverride(name="openQty", column=@Column(name="OPEN_QTY", precision=22, scale=0) ), 
        @AttributeOverride(name="totalCost", column=@Column(name="TOTAL_COST", precision=22, scale=0) ), 
        @AttributeOverride(name="replenRqstShipDt", column=@Column(name="REPLEN_RQST_SHIP_DT", length=7) ), 
        @AttributeOverride(name="replenEstShipDt", column=@Column(name="REPLEN_EST_SHIP_DT", length=7) ), 
        @AttributeOverride(name="replenCurrEstDt", column=@Column(name="REPLEN_CURR_EST_DT", length=7) ), 
        @AttributeOverride(name="facility", column=@Column(name="FACILITY", length=16) ), 
        @AttributeOverride(name="apsSplySubPoolNbr", column=@Column(name="APS_SPLY_SUB_POOL_NBR", precision=9, scale=0) ), 
        @AttributeOverride(name="apsSplyPoolCd", column=@Column(name="APS_SPLY_POOL_CD", length=20) ), 
        @AttributeOverride(name="apsSplySubPoolCd", column=@Column(name="APS_SPLY_SUB_POOL_CD", length=20) ), 
        @AttributeOverride(name="buyReasonCd", column=@Column(name="BUY_REASON_CD", length=8) ), 
        @AttributeOverride(name="cannotReschedFlg", column=@Column(name="CANNOT_RESCHED_FLG", length=1) ), 
        @AttributeOverride(name="poCd", column=@Column(name="PO_CD", length=20) ), 
        @AttributeOverride(name="poDt", column=@Column(name="PO_DT", length=7) ), 
        @AttributeOverride(name="orgCdVnd", column=@Column(name="ORG_CD_VND", length=15) ), 
        @AttributeOverride(name="orgNmVnd", column=@Column(name="ORG_NM_VND", length=60) ), 
        @AttributeOverride(name="buyerNm", column=@Column(name="BUYER_NM", length=44) ) } )
    public PoReschedVwId getId() {
        return this.id;
    }
    
    public void setId(PoReschedVwId id) {
        this.id = id;
    }




}


