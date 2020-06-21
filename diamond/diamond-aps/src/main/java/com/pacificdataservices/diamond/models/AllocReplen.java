package com.pacificdataservices.diamond.models;

import java.math.BigDecimal;

public interface AllocReplen {

	WhFacilityTransReplen getWhFacilityTransReplen();

	void setWhFacilityTransReplen(WhFacilityTransReplen whFacilityTransReplen);

	IcItemMast getIcItemMast();

	void setIcItemMast(IcItemMast icItemMast);

	BigDecimal getAllocQty();

	void setAllocQty(BigDecimal allocQty);

	String getFacilityRqst();

	void setFacilityRqst(String facilityRqst);

	void setFacilityAct(String facility);

	void setPoLineDtlNbr(int poLineDtlNbr);

	void setAllocTypeId(String string);

	void setApsSplySubPoolNbr(Integer apsSplySubPoolNbr);

}