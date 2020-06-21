package com.pacificdataservices.diamond.models;

import java.math.BigDecimal;
import java.util.Date;

public interface AllocOnhand {

	WhFacilityTransOnhand getWhFacilityTransOnhand();

	void setWhFacilityTransOnhand(WhFacilityTransOnhand whFacilityTransOnhand);

	IcItemMast getIcItemMast();

	void setIcItemMast(IcItemMast icItemMast);

	int getLotNbr();

	void setLotNbr(int lotNbr);

	BigDecimal getAllocQty();

	void setAllocQty(BigDecimal allocQty);

	int getApsSplySubPoolNbr();

	void setApsSplySubPoolNbr(int apsSplySubPoolNbr);

	String getFacilityRqst();

	void setFacilityRqst(String facilityRqst);

	String getFacilityAct();

	void setFacilityAct(String facilityAct);

	void setAllocTypeId(String allocTypeId);

	Date getAvailDt();

	void setAvailDt(Date availDt);

}