package com.pacificdataservices.diamond.planning;

public enum SupplyType {
	ONHAND, WORK_ORDER, PURCHASE;

	public static SupplyType getSupplyType(String availType) {
		SupplyType retval = null;

		if ("OH".equals(availType)) return SupplyType.ONHAND;
		if ("WO".equals(availType)) return SupplyType.WORK_ORDER;
		if ("PO".equals(availType)) return SupplyType.PURCHASE;
		throw new IllegalStateException("unknown supply type:" + availType);

	}

	public String toString() {
		switch(this) {
		case ONHAND:
			return "OH";
		case WORK_ORDER:
			return "WO";
		case PURCHASE:
			return "PO";
		}
		throw new IllegalStateException();
	}

}
