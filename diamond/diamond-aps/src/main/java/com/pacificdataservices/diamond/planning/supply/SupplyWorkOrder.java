package com.pacificdataservices.diamond.planning.supply;

import com.pacificdataservices.diamond.models.ApsAvailWo;
import com.pacificdataservices.diamond.planning.SupplyType;

public class SupplyWorkOrder extends AbstractSupply implements Supply {

	private int woHdrNbr;
	public SupplyWorkOrder(ApsAvailWo supply) {
		 setSupplyIdentifier(supply.getSplyIdentifier());
	     setFacility(supply.getFacility());
	     setApsSplySubPoolNbr(supply.getApsSplySubPoolNbr());
	     setLotUm(supply.getWoUm());
	     setItemNbr(supply.getItemNbr());
	     setAvailDt(supply.getAvailDt());
	     setGrossAvailQty(supply.getGrossAvailQty());
	     setAvailDt(supply.getAvailDt());
	     woHdrNbr = supply.getWoHdrNbr();
	}

	public SupplyType getSupplyType() {
		return SupplyType.WORK_ORDER;
	}

	public int getWoHdrNbr() {
		return woHdrNbr;
	}
}
