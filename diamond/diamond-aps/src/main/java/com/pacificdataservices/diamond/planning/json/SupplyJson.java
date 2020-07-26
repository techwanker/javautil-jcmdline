package com.pacificdataservices.diamond.planning.json;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import org.javautil.containers.Buckets;

import com.pacificdataservices.diamond.models.IcCertCd;
import com.pacificdataservices.diamond.models.IcItemMast;
import com.pacificdataservices.diamond.planning.Allocation;
import com.pacificdataservices.diamond.planning.AllocationMode;
import com.pacificdataservices.diamond.planning.supply.Supply;


public class SupplyJson {

	private String supplyId;
	private String facility;
	private String apsSplyPoolCd;
	private String apsSplySubPoolCd; 

	private Map<String, IcCertCd> certCds;
	private String supplyTypeCd;
	private Date availDate;
	private String manufacturerCode;
	private Date dateOfManufacture;
	private String cntryCdOrigin;
	private Date lotExpirationDate;
	private Integer lotNbr;
	private Date minimumDemandDate;
	private double lotCost;
	private double qtyAllocatedFirstPass;
	private double qtyUnallocatedFirstPass;
	private double grossAvailQty;
	private TreeMap<String,Double> allocationByDemandId = new TreeMap<String, Double>();
	private TreeMap<String,String> icItemDescrByItemCd = new TreeMap<String, String>();
	private boolean isPastDue;
	private TreeMap<Date,Double> projectedPosition ;

	public SupplyJson(Supply supply) {
		//icItemNbrByItemCd =;
		facility =  supply.getFacility();
		apsSplyPoolCd   = supply.getApsSplyPool().getApsSplyPoolCd();
		//certCds;
		supplyTypeCd = supply.getSplyTypeId();
		availDate = supply.getAvailDate();
		manufacturerCode  = supply.getManufacturerCode();
		supplyId  = supply.getIdentifierString();
		dateOfManufacture =  supply.getDateOfManufacture();
		cntryCdOrigin = supply.getCntryCdOrigin();
		lotExpirationDate = supply.getExpireDt();
		lotNbr = supply.getLotNbr();
		minimumDemandDate = supply.getMinimumDemandDate();
		grossAvailQty = supply.getGrossAvailQty().doubleValue();
		qtyAllocatedFirstPass = supply.getQtyAllocated(AllocationMode.FIRST_PASS);
		qtyUnallocatedFirstPass =  supply.getUnallocatedQty(AllocationMode.FIRST_PASS);
		lotCost = supply.getLotCost().doubleValue();
		for (IcItemMast iim    : supply.getIcItemMastByItemCd().values()) {
			icItemDescrByItemCd.put(iim.getItemCd(),  iim.getItemDescr());
		}
		for (Allocation a : supply.getAllocations(AllocationMode.FIRST_PASS)) {
			allocationByDemandId.put(a.getDemand().getDemandIdentifier(),a.getAllocQty());
		}
		Buckets<Double> projPos = supply.getProjectedPositionBuckets();
		projectedPosition = projPos.getDateMap();
	}
	
	
	public static ArrayList<SupplyJson> toSupplyJsonList(Collection<Supply> supplies) {
		ArrayList<SupplyJson> retval = new ArrayList<>(supplies.size());
		for (Supply supply : supplies) {
			retval.add(new SupplyJson(supply));
		}
		return retval;
	}

	/**
	 * @return the icItemNbrByItemCd
	 */
	public Map<String, String> getIcItemNbrByItemCd() {
		return icItemDescrByItemCd;
	}

	/**
	 * @return the facility
	 */
	public String getFacility() {
		return facility;
	}

	/**
	 * @return the apsSplyPoolCd
	 */
	public String getApsSplyPoolCd() {
		return apsSplyPoolCd;
	}

	/**
	 * @return the apsSplySubPoolCd
	 */
	public String getApsSplySubPoolCd() {
		return apsSplySubPoolCd;
	}

	/**
	 * @return the certCds
	 */
	public Map<String, IcCertCd> getCertCds() {
		return certCds;
	}

	/**
	 * @return the supplyTypeCd
	 */
	public String getSupplyTypeCd() {
		return supplyTypeCd;
	}

	/**
	 * @return the availDate
	 */
	public Date getAvailDate() {
		return availDate;
	}

	/**
	 * @return the manufacturerCode
	 */
	public String getManufacturerCode() {
		return manufacturerCode;
	}

	/**
	 * @return the supplyId
	 */
	public String getSupplyId() {
		return supplyId;
	}

	/**
	 * @return the dateOfManufacture
	 */
	public Date getDateOfManufacture() {
		return dateOfManufacture;
	}

	/**
	 * @return the cntryCdOrigin
	 */
	public String getCntryCdOrigin() {
		return cntryCdOrigin;
	}

	/**
	 * @return the lotExpirationDate
	 */
	public Date getLotExpirationDate() {
		return lotExpirationDate;
	}

	/**
	 * @return the lotNbr
	 */
	public Integer getLotNbr() {
		return lotNbr;
	}

	/**
	 * @return the minimumDemandDate
	 */
	public Date getMinimumDemandDate() {
		return minimumDemandDate;
	}

	/**
	 * @return the qtyAllocatedFirstPass
	 */
	public double getQtyAllocatedFirstPass() {
		return qtyAllocatedFirstPass;
	}

	/**
	 * @return the qtyUnallocatedFirstPass
	 */
	public double getQtyUnallocatedFirstPass() {
		return qtyUnallocatedFirstPass;
	}

	/**
	 * @return the grossAvailQty
	 */
	public double getGrossAvailQty() {
		return grossAvailQty;
	}

	/**
	 * @return the lotCost
	 */
	public double getLotCost() {
		return lotCost;
	}

	/**
	 * @return the allocationByDemandId
	 */
	public Map<String, Double> getAllocationByDemandId() {
		return allocationByDemandId;
	}
}
