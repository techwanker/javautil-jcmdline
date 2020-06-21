package com.pacificdataservices.diamond.planning.demand;

import java.util.Date;

import com.pacificdataservices.diamond.models.ApsDmdSs;

public class DemandSafetyStock extends AbstractDemand {
	
   
    
    // TODO strip out common fields from AbstractDemands
    public DemandSafetyStock(ApsDmdSs demand) {
        setDmdCd(demand.getDmdCd());
        setDmdTypeCd(demand.getDmdTypeCd());
        setItemNbrDmd(demand.getItemNbrDmd());
        setItemNbrAllocRqst(demand.getItemNbrAllocRqst());
        setFcItemMastNbr(demand.getFcItemMastNbr());
        setRqstDt(demand.getRqstDt());
        setApsSrcRuleSetNbr(demand.getApsSrcRuleSetNbr());
        setOrgNbrCust(demand.getOrgNbrCust());
        setOrgCdCust(demand.getOrgCdCust());
        setOpenQty(demand.getOpenQty());
        setOpenQtyAdj(demand.getOpenQtyAdj());
        setContractCustFlg(demand.getContractCustFlg());
        setCustAllocPrty(demand.getCustAllocPrty());
        setRevLvl(demand.getRevLvl());
        setOrgNbrMfrRqst(demand.getOrgNbrMfrRqst());
        setFcstGrp(demand.getFcstGrp());
     //  setIdentifier(demand.getIdentifier());
    }

//	@Override
//	public FcstGrp getDemandFcstGrp() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
	   /*
     * return the adjusted open quantity if it is not null, else the gross open quantity
     */
    public double getAdjustedOpenQty() {
        Double rc = null;
        rc = getOpenQtyAdj() != null ? getOpenQtyAdj().doubleValue() : getOpenQty().doubleValue();
        if (rc.doubleValue() == 0.0) {
            logger.trace(
                    "Demand.getOpenQty OpenQty: " + rc + " openQtyAdj " + getOpenQtyAdj() + " grossOpenQty " + getGrossOpenQty()
                            + " demand " + this);
        }
        return rc;
    }

	@Override
	public Date getNeedByDate() {
		return getRqstDt();
	}

	
	@Override
	public String summaryString() {
		return String.format("DemandSafetyStock [getFcItemMastNbr()=%s, getRqstDt()=%s, getOpenQty()=%s]",
				getFcItemMastNbr(), getRqstDt(), getOpenQty());
	}

	@Override
	public String getIdentifier() {
		return "SS:" + this.getFcItemMastNbr();
	}
	@Override
	public boolean isSafetyStockDemand() {
		return true;
	}

	@Override
	public boolean isCustomerDemand() {
		return false;
	}

	@Override
	public boolean isForecastDemand() {
		return false;
	}

	@Override
	public boolean isWorkOrderDemand() {
		return false;
	}

	@Override
	public String getDemandIdentifier() {
		return ("FcItemMastNbr: " + getFcItemMastNbr());
	}
}
