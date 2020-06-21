package com.pacificdataservices.diamond.planning.demand;

import java.util.Date;

import com.pacificdataservices.diamond.models.ApsDmdOo;

public class DemandCustomer extends AbstractDemand implements Demand{
	
	private Integer oeOrdDtlNbr;
	private String shipFromFacility;
	private String cntryCdOrigin;
    private Date promDtCurr;
    
	public DemandCustomer(ApsDmdOo demand) {
		oeOrdDtlNbr  = demand.getOeOrdDtlNbr();
        setDmdCd(demand.getDmdCd());
        setDmdTypeCd(demand.getDmdTypeCd());
        setItemNbrDmd(demand.getItemNbrDmd());
        //setItemNbrAllocRqst(demand.getItemNbrAllocRqst());
        setRqstDt(demand.getRqstDt());
        setApsSrcRuleSetNbr(demand.getApsSrcRuleSetNbr());
        setOrgNbrCust(demand.getOrgNbrCust());
        setOrgCdCust(demand.getOrgCdCust());
        setOpenQty(demand.getOpenQty());
        setOpenQtyAdj(demand.getOpenQtyAdj());
        setContractCustFlg(demand.getContractCustFlg());
        //setCustAllocPrty(demand.getCustAllocPrty());
        setRevLvl(demand.getRevLvl());
        setOrgNbrMfrRqst(demand.getOrgNbrMfrRqst());
        setFcstGrp(demand.getFcstGrp());
      // setIdentifier(demand.getIdentifier());
       setLotNotExpireBeforeDt (demand.getLotNotExpireBeforeDt());
       setShipFromFacility(demand.getShipFromFacility());
       setCntryCdOrigin(demand.getCntryCdOrigin());
       setPromDtCurr(demand.getPromDtCurr());
    }
	
	public DemandCustomer() {
	}

	public void setOeOrdDtlNbr(int oeOrdDtlNbr) {
		this.oeOrdDtlNbr = oeOrdDtlNbr;
	}
	
	public Integer getOeOrdDtlNbr() {
		return oeOrdDtlNbr;
	}

//	public void setLotNotExpireBeforeDt(Date lotNotExpireBeforeDt) {
//		this.lotNotExpireBeforeDt = lotNotExpireBeforeDt;
//		
//	}


//	public Date getLotNotExpireBeforeDt() {
//		return lotNotExpireBeforeDt;
//	}

	@Override
	public Date getNeedByDate() {
		return getRqstDt();
	}



	

	@Override
	public String summaryString() {
		return String.format("DemandCustomer [oeOrdDtlNbr=%s, getNeedByDate()=%s, getOpenQty()=%s]", oeOrdDtlNbr,
				getNeedByDate(), getOpenQty());
	}

	@Override
	public String getIdentifier() {
		return "oeOrdDtlNbr:" + oeOrdDtlNbr;
	}
	
	@Override
	public String toString() {
		return "DemandCustomer ["
				+ ", itemNbrDmd=" + getItemNbrDmd()
				+ ", orgCdCust=" + getOrgCdCust() 
				+ ", rqstDt=" + getRqstDt() 
				+ ", openQty=" + getOpenQty() 
				+ ", openQtyAdj=" + getOpenQtyAdj()
				+ ", lotNotExpireBeforeDt=" + getLotNotExpireBeforeDt() 
				+ ", oeOrdDtlNbr=" + oeOrdDtlNbr
			//	+ ", isMixMfrLot=" + isMixMfrLot()
				+ ", endLeadTime=" + getEndLeadTime() 
				+ ", itemNbrAllocRqst=" + getItemNbrAllocRqst() 
			//	+ ", fcItemMastNbr=" + getFcItemMastNbr()
				+ ", orgNbrCust=" + getOrgNbrCust() 
				+ ", contractCustFlg=" + getContractCustFlg() 
				+ ", custAllocPrty=" + getCustAllocPrty()
				+ ", revLvl=" + getRevLvl() 
				+ ", orgNbrMfrRqst()=" + getOrgNbrMfrRqst() 
				+ ", fcstGrp()=" + getFcstGrp() 
				+ ", demandPriority()=" + getDemandPriority() + ", getGrossOpenQty()=" + getGrossOpenQty() + "]";
	}

	@Override
	public boolean isSafetyStockDemand() {
		return false;
	}

	@Override
	public boolean isCustomerDemand() {
		return true;
	}

	@Override
	public boolean isForecastDemand() {
		return false;
	}

	@Override
	public boolean isWorkOrderDemand() {
		return false;
	}

    public String getPrimarySourcingFacility() {
    	return shipFromFacility;
    }

	public String getShipFromFacility() {
		return shipFromFacility;
	}

	public void setShipFromFacility(String shipFromFacility) {
		this.shipFromFacility = shipFromFacility;
	}

	@Override
	public String getDemandIdentifier() {
		String id = "CustomerDemand: " + getOeOrdDtlNbr();
		return id;
	}

	/**
	 * @return the cntryCdOrigin
	 */
	public String getCntryCdOrigin() {
		return cntryCdOrigin;
	}

	/**
	 * @param cntryCdOrigin the cntryCdOrigin to set
	 */
	public void setCntryCdOrigin(String cntryCdOrigin) {
		this.cntryCdOrigin = cntryCdOrigin;
	}

	/**
	 * @return the promDtCurr
	 */
	public Date getPromDtCurr() {
		return promDtCurr;
	}

	/**
	 * @param promDtCurr the promDtCurr to set
	 */
	public void setPromDtCurr(Date promDtCurr) {
		this.promDtCurr = promDtCurr;
	}

	
	
}
