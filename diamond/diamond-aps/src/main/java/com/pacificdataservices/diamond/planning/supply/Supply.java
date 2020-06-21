package com.pacificdataservices.diamond.planning.supply;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.javautil.core.misc.Buckets;
import org.javautil.core.misc.MultiKey;

import com.pacificdataservices.diamond.models.ApsSplyPool;
import com.pacificdataservices.diamond.models.ApsSplySubPool;
import com.pacificdataservices.diamond.models.ApsSrcRule;
import com.pacificdataservices.diamond.models.IcCertCd;
import com.pacificdataservices.diamond.models.IcItemMast;
import com.pacificdataservices.diamond.models.IcLotMast;
import com.pacificdataservices.diamond.models.IcLotMastCert;
import com.pacificdataservices.diamond.planning.Allocation;
import com.pacificdataservices.diamond.planning.AllocationMode;
import com.pacificdataservices.diamond.planning.SupplyType;
import com.pacificdataservices.diamond.planning.demand.Demand;


public interface Supply {

	public double getQtyAllocatedFirstPass();
	public double getQtyUnallocatedFirstPass();

	public void addAllocation(Allocation allocation, AllocationMode mode);

	public Date getAvailDate();

	Integer getOrgNbrMfr();
	
	void setIcItemMast(IcItemMast icItemMast);

	IcItemMast getIcItemMast();

	boolean isOnhand();

	Map<String, IcCertCd> getIcCertCds();

	ApsSrcRule getSourcingRule(Demand demand);

	String getSplyTypeId();

	boolean isWorkOrder();

	//Character getSupplyTypeCd();

	public Integer getApsSplySubPoolNbr(); 
	
	String getFacility();

	void addCertification(IcCertCd certCd);

	public String getId();

	String getCntryCdOrigin();

	Date getDateOfManufacture();

	Date LotExpirationDate();

	Date getExpireDt();

	Integer getLotNbr();

	void setIcLotMast(IcLotMast lot);
	
	ApsSplySubPool getApsSplySubPool();

	Date getAdjustedAvailDate();

	Integer getPlannedTransferNbr();

	double getAvailQty(AllocationMode mode);

	double getNetAvailableForCustomer(Object customerNumber);

	boolean isPurchaseOrder();

	String getSupplyIdentifier();

	int getCertValue();

	String getIdentifierString();

	int getItemNbr();

	void setApsSplySubPool(ApsSplySubPool apsSubPool);
	List<Allocation> getAllocations(AllocationMode mode);

	double getUnallocatedQty(AllocationMode mode);
	
	boolean isItem(int itemNbr);

	Date getMinimumDemandDate();

	double getPlannedTransferOutQty();

	Collection<IcLotMastCert>getCertifications();

	String getManufacturerCode();

	public SupplyType getSupplyType();

	public BigDecimal getGrossAvailQty();

	public void setApsSplyPool(ApsSplyPool pool);

	public ApsSplyPool getApsSplyPool();

	public BigDecimal getLotCost();

	public double getQtyAllocated(AllocationMode firstPass);
	
	public void setProjectedPositionBuckets(Buckets<Double> buckets);
	
	public Buckets<Double> getProjectedPositionBuckets();
	public Map<String,IcItemMast> getIcItemMastByItemCd(); 
	public ArrayList<String> getItemCdList();
	public MultiKey  getItemCodeMultiKey();
	//double getQtyAllocatedBucket(AllocationMode mode, Supply supply, Date onOrAfter, Date dateBefore);
	public Collection<Allocation> getAllocationsForBucket(AllocationMode firstPass, Date firstUsedBucketDate,
			Date nextBucketDate);
	public double getQtyAllocatedBucket(AllocationMode mode,  Date onOrAfter, Date dateBefore ) ;		
}
