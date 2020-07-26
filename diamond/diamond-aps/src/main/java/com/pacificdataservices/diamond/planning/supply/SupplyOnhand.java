package com.pacificdataservices.diamond.planning.supply;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.diamond.models.ApsAvailOnhand;
import com.pacificdataservices.diamond.models.IcItemMast;
import com.pacificdataservices.diamond.planning.SupplyType;

/**
 * TODO review should this extend Supply or decorate it?
 * TODO why do I need a special one for this and not for any other type of supply
 * @author jjs
 *
 */
public class SupplyOnhand extends AbstractSupply implements Supply {

	private Logger logger =  LoggerFactory.getLogger(getClass());
	 public SupplyOnhand(ApsAvailOnhand supply) {
		 setSupplyIdentifier(supply.getSplyIdentifier());
	     setFacility(supply.getFacility());
	     setApsSplySubPoolNbr(supply.getApsSplySubPoolNbr());
	     setOrgNbrMfr(supply.getOrgNbrMfr());
	     setOrgNbrVnd(supply.getOrgNbrVnd());
	     setLotNbr(supply.getLotNbr());
	     setLotUm(supply.getLotUm());
	     setItemNbr(supply.getItemNbr());
	     setAvailDt(supply.getAvailDt());
	     setGrossAvailQty(supply.getGrossAvailQty());
	     setRevLvl(supply.getRevLvl());
	     setPkSupply(supply.getPkSupply());
	     setLotCost(supply.getLotCost());
	     setCntryCdOrigin(supply.getCntryCdOrigin());
	     setMfrDate(supply.getMfrDate());
	     setExpireDt(supply.getExpireDt());
	     setRcptDt(supply.getRcptDt());
	     setAvailDtId(supply.getAvailDtId());
	 }
	 
//	public static String getId(Integer lotNbr, Integer apsSplySubPoolNbr, String facility, Date availDate) {
//		String	id = lotNbr + "~" + apsSplySubPoolNbr + "~" +
//			 facility + "~" + 
//			availDate;
//		return id;
//	}

	public void setIcItemMastByItemCd(Map<Integer,IcItemMast> iimByItemNbr, Map<Integer, ArrayList<Integer>> map) {
		logger.debug("setIcItemMastByItemCd: supply:  {}, itemNbrsByLotNbr: {} ", getIdentifierString(), map);
		TreeMap<String,IcItemMast> w = new TreeMap<>();
		w.put(getIcItemMast().getItemCd(),getIcItemMast());
		List<Integer> itemNbrs =  map.get(getLotNbr());
	     if(itemNbrs != null) {
	    	 for (Integer itemNbr : itemNbrs) {
	    		 	IcItemMast iim = iimByItemNbr.get(itemNbr);
	    		 	if(iim == null) {
	    		 		throw new IllegalStateException("cannot find item " + itemNbr);
	    		 	}
	    		 	w.put(iim.getItemCd(),iim);
	    	 }
	     }
		setIcItemMastByItemCd(w);
		logger.debug("setIcItemMastByItemCd: supply:  {}, itemNbrsByLotNbr: {} ", getIdentifierString(), w.keySet());
	}
	
	public SupplyType getSupplyType() {
		return SupplyType.ONHAND;
	}

	@Override
	public String toString() {
		return "SupplyOnhand ["
				+ ", facility=" + getFacility()  
				+ ", apsSplySubPoolNbr=" + getApsSplySubPoolNbr()
				+ ", getOrgNbrMfr()=" + getOrgNbrMfr() 
				+ ", orgNbrVnd=" + getOrgNbrVnd() 
				+ ", lotNbr=" + getLotNbr() 
				+ ", lotUm=" + getLotUm() 
				+ ", itemNbr=" + getItemNbr() 
				+ ", availDt=" + getAvailDt()  
				+ ", grossAvailQty=" + getGrossAvailQty()  
				+ ", revLvl=" + getRevLvl()
				+ ", pkSupply()=" + getPkSupply() 
				+ ", lotCost()=" + getLotCost() 
				+ ", cntryCdOrigin()=" + getCntryCdOrigin() 
				+ ", expireDt()=" + getExpireDt() 
				+ ", rcptDt()=" + getRcptDt()
				+ ", availDtId=" + getAvailDtId() 
				+ ", dateOfManufacture()=" + getDateOfManufacture()
				+ ", lotExpirationDate=" + LotExpirationDate() 
				+ ", supplyIdentifier" + getSupplyIdentifier()
				+ ", availDate=" + getAvailDate() 
				+ "]";
	}



	
}
