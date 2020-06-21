//package com.pacificdataservices.diamond.planning.data;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.TreeMap;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.pacificdataservices.diamond.planning.supply.Supply;
//
//public class PartsBucketIdentifier {
//
//	private final Logger logger = LoggerFactory.getLogger(getClass());
//	public static final String SUPPLY_POOL_CD = "supplyPool";
//	public static final String FACILITY = "facility";
//	public static final String ITEM_CD = "itemCd";
//
//	private TreeMap<String,String> identifierMap = new TreeMap<>();
//	private Supply supply;
//
//	public PartsBucketIdentifier(Supply supply) {
//		this.supply = supply;
//	}
//	
//	public PartsBucketIdentifier useSupplyPoolCd() {
//		identifierMap.put(SUPPLY_POOL_CD,supply.getApsSplyPool().getApsSplyPoolCd() +  "-"  +
//				supply.getApsSplySubPool().getApsSplySubPoolCd());
//		return this;
//	}
//	
//	public PartsBucketIdentifier useFacility() {
//		identifierMap.put(FACILITY,supply.getFacility());
//		return this;
//	}
//	
//	public PartsBucketIdentifier useItemCd(String itemCd) {
//		if (supply.getIcItemMastByItemCd().get(itemCd) == null) {
//			throw new IllegalArgumentException("is not " + itemCd);
//		}
//		identifierMap.put(ITEM_CD,itemCd);
//		return this;
//	}
//	
//	public TreeMap<String,String> getIdentifierMap() {
//		return identifierMap;
//	}
//	
//	public String[] getIdValues() {
//		Collection<String> values=  identifierMap.values();
//		ArrayList<String> valuesList = new ArrayList<String>();
//		valuesList.addAll(values);
//		int sz = valuesList.size();
//		String[] retval = new String[sz];
//		int i = 0;
//		for (String v : valuesList) {
//			retval[i++] = v;
//		}
//		return retval;
//	}
//	
//
//}
