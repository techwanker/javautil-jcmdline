package com.pacificdataservices.diamond.models;

import java.math.BigDecimal;

public interface AllocWo {

	int getWoHdrNbr();

	void setWoHdrNbr(int woHdr);

	IcItemMast getIcItemMast();

	void setIcItemMast(IcItemMast icItemMast);

	BigDecimal getAllocQty();

	void setAllocQty(BigDecimal allocQty);

	String getFacilityAct();

	void setFacilityAct(String facilityAct);

	Integer getWhFacilityTransWoNbr();

	void setWhFacilityTransWoNbr(Integer whFacilityTransWoNbr);

	void setAllocTypeId(String string);


	void setApsSplySubPoolNbr(Integer apsSplySubPoolNbr);

	int getApsSplySubPoolNbr();

}