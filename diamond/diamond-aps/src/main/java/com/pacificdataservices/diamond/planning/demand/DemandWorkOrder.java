package com.pacificdataservices.diamond.planning.demand;

import java.math.BigDecimal;
import java.util.Date;

import com.pacificdataservices.diamond.models.ApsDmdWo;

public  class DemandWorkOrder extends AbstractDemand implements Demand {
	
	@Override
	public String summaryString() {
		return String.format(
				"DemandWorkOrder [componentQtyPerUnit=%s, getGrossOpenQty()=%s, getDmdCd()=%s, getRqstDt()=%s]",
				componentQtyPerUnit, getGrossOpenQty(), getDmdCd(), getRqstDt());
	}

	private BigDecimal componentQtyPerUnit;
	private boolean isMixMfrLot;
	private int woDtlNbr;
	
    public DemandWorkOrder(ApsDmdWo demand) {
        setDmdCd(demand.getDmdCd());
        setDmdTypeCd(demand.getDmdTypeCd());
        setItemNbrDmd(demand.getItemNbrDmd());
        setApsSrcRuleSetNbr(demand.getApsSrcRuleSetNbr());
        setOrgNbrCust(demand.getOrgNbrCust());
        setOrgCdCust(demand.getOrgCdCust());
        setOpenQty(demand.getOpenQty());
        setOpenQtyAdj(demand.getOpenQtyAdj());
        setRevLvl(demand.getRevLvl());
        setOrgNbrMfrRqst(demand.getOrgNbrMfrRqst());
        setFcstGrp(demand.getFcstGrp());
        setComponentQtyPerUnit(demand.getComponentQtyPerUnit());
        woDtlNbr = demand.getWoDtlNbr();
        isMixMfrLot = "N".equals(demand.getMixMfrLotFlg());
        setRqstDt(demand.getNeedByDt());
    }

	@Override
	public Date getNeedByDate() {
		return getRqstDt();
	}

	public BigDecimal getComponentQtyPerUnit() {
		return componentQtyPerUnit;
	}

	public void setComponentQtyPerUnit(BigDecimal componentQtyPerUnit) {
		this.componentQtyPerUnit = componentQtyPerUnit;
	}

	@Override
	public boolean isMixMfrLot() {
		return isMixMfrLot;
	}

	public Integer getWoDtlNbr() {
		return woDtlNbr;
	}

	@Override
	public String getIdentifier() {
		// TODO Auto-generated method stub
		return "WO:" + this.getWoDtlNbr();
	}
	@Override
	public boolean isSafetyStockDemand() {
		return false;
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
		return true;
	}

	@Override
	public String getDemandIdentifier() {
		return getDmdCd();
	}
}
