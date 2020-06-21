package com.pacificdataservices.diamond.planning.supply;

import com.pacificdataservices.diamond.models.ApsAvailReplen;
import com.pacificdataservices.diamond.planning.SupplyType;

public class SupplyReplen extends AbstractSupply implements Supply {

	private int poLineDtlNbr;

	public SupplyReplen(ApsAvailReplen supply) {
		setSupplyIdentifier(supply.getSplyIdentifier());
		setFacility(supply.getFacility());
		setApsSplySubPoolNbr(supply.getApsSplySubPoolNbr());
		setOrgNbrMfr(supply.getOrgNbrMfr());
		setOrgNbrVnd(supply.getOrgNbrVnd());
		setItemNbr(supply.getItemNbr());
		setAvailDt(supply.getAvailDt());
		setGrossAvailQty(supply.getGrossAvailQty());
		setRevLvl(supply.getRevLvl());
		setCntryCdOrigin(supply.getCntryCdOrigin());
		setLotCost(supply.getUnitCostStkUm());
		this.poLineDtlNbr = supply.getPoLineDtlNbr();
	}

	public int getPoLineDtlNbr() {
		return poLineDtlNbr;
	}

	public SupplyType getSupplyType() {
		return SupplyType.PURCHASE;
	}

	@Override
	public String toString() {
		return "SupplyReplen [getSupplyType()=" + getSupplyType() + ", getAdjustedAvailDate()=" + getAdjustedAvailDate()
				+ ", getCertValue()=" + getCertValue() 
	            + ", poLineDtlNbr()=" + getPoLineDtlNbr()			
				+ ", getApsSplyPool()=" + getApsSplyPool().getApsSplyPoolCd() 
				+ ", getManufacturerCode()=" + getManufacturerCode()
				+ ", getEffectiveDate()=" + getEffectiveDate() 
				+ ", getFacility()=" + getFacility() 
				+ ", getOrgNbrMfr()=" + getOrgNbrMfr() 
				+ ", getOrgNbrVnd()=" + getOrgNbrVnd() 
				+ ", getRevLvl()=" + getRevLvl() 
				+ ", getCntryCdOrigin()=" + getCntryCdOrigin()
				+ ", getRcptDt()=" + getRcptDt() 
				+ ", getDateOfManufacture()=" + getDateOfManufacture()
			//	+ ", getIdentifierString()=" + getIdentifierString() +
				+ ", getAvailDate()=" + getAvailDate()
				+ ", getSupplyIdentifier()=" + getSupplyIdentifier()
				+ ", getSplyIdentifier()=" + getSplyIdentifier();
	}


	

}
