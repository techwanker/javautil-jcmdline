package com.pacificdataservices.diamond.planning.demand;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.pacificdataservices.diamond.models.ApsSrcRuleSet;
import com.pacificdataservices.diamond.models.FcstGrp;
import com.pacificdataservices.diamond.models.IcCertCd;
import com.pacificdataservices.diamond.models.IcItemMast;
import com.pacificdataservices.diamond.models.NaOrg;
import com.pacificdataservices.diamond.models.OeCustMast;
import com.pacificdataservices.diamond.models.UtFacility;
import com.pacificdataservices.diamond.planning.Allocation;
import com.pacificdataservices.diamond.planning.AllocationMode;
import com.pacificdataservices.diamond.planning.EligibleSupplies;
import com.pacificdataservices.diamond.planning.EligibleSupply;
import com.pacificdataservices.diamond.planning.container.ApsSrcRuleSetExt;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.filter.SupplyEligibilityTest;
import com.pacificdataservices.diamond.planning.supply.Supply;
public interface Demand {
	//
	// others
	//
	void addAllocation(Allocation allocation, AllocationMode mode);
//	ArrayList<Allocation> allocate(AllocationMode firstPass);
	double getAllocatedQty(AllocationMode customerPrioritized);
	List<Allocation> getAllocations(AllocationMode mode);
	ApsSrcRuleSet getApsSrcRuleSet();
	ApsSrcRuleSetExt getApsSrcRuleSetExt();
	int getApsSrcRuleSetNbr();
	Date getAvailDt(AllocationMode customerPrioritized);
	String getCntryCdOrigin();
	List<EligibleSupply> getCustomerEligibleSupplies();
	BigDecimal getCustomerNumber();
	FcstGrp getDemandFcstGrp();
	String getDemandIdentifier();
	int getDemandPriority();
	DemandType getDemandType();
	// jpa common fields
	String getDmdCd();
	String getDmdTypeCd();
	EligibleSupplies getEligibleSupplies();
	TreeMap<String, EligibleSupply> getEligibleSuppliesByPriority();
	Object getEndLeadTime();  // TODO 
	String getFcstGrp();
	//double getGrossOpenQty();
	List<IcCertCd> getIcCertCds();
	IcItemMast getIcItemMast();
	String getIdentifier();
	String getIdentifierString();
	//List<EligibleSupply> getIneligible();
	List<Supply> getInapplicable();
	int getItemNbrDmd();
	String getMfrCd();
	Date getNeedByDate();
	OeCustMast getOeCustMast();
	double getOnTimeQty(AllocationMode customerPrioritized);
	BigDecimal getOpenQty();
	String getOrgCdCust();
	int getOrgNbrCust();
	Integer getOrgNbrMfrRqst();
	double getPreviousAllocationQty();
	String getPrimarySourcingFacility();
    String getPrioritizedSuppliesFormatted();
	String getPriorityCode();
	String getPriorityWithinCustomer();
	double getQtyAllocatedFirstPass();
	String getRevLvl();
	double getUnallocatedQty(AllocationMode mode);
	boolean getWithinLeadTime();
	boolean isCustomerDemand();
	boolean isCustomerOrder();
	boolean isDegraded(AllocationMode customerPrioritized, AllocationMode overship);
	boolean isForecast();
	boolean isForecastDemand();
	boolean isMixMfrLot();
	boolean isSafetyStockDemand();
	boolean isWithinLeadTime();
	boolean isWorkOrderDemand();
	void setApsSrcRuleSetExt(ApsSrcRuleSetExt set);
	void setApsSrcRuleSetNbr(int apsSrcRuleSetNbr);
	void setDemandFcstGrp(FcstGrp fcstGrp);
    void setDmdCd(String dmdCd);
	void setDmdTypeCd(String dmdTypeCd);
	void setEligibleSupplies(EligibleSupplies eligible);
	void setFcstGrp(String fcstGrp);
	void setIcItemMast(IcItemMast icItemMast);
	void setItemNbrDmd(int itemNbrDmd);
	void setOeCustMast(OeCustMast oeCustMast);
	void setOrgNbrCust(int orgNbrCust);
	public void setPrimarySourcingFacility(UtFacility utFacility);
	void setPriorityCode(String priorityCode);
	void setRevisionLevel(String string);
	void setRevLvl(String revLvl);
	void addIneligibleReason(Supply supply, SupplyEligibilityTest test);
	Map<Supply, Set<SupplyEligibilityTest>> getIneligibleSupplies();
	void setNaOrgMfrRqst(NaOrg mfr);
	NaOrg getNaOrgMfrRqst();
	String summaryString();
	ArrayList<Allocation> allocate(AllocationMode mode);
	Map<String, Allocation> getAllocationBySupplyXmlId();
	void setPlanningData(PlanningData planningData);
	double getGrossOpenQty();
	double getAllocatedOnTimeQty(AllocationMode customerPrioritized);
	double getQuantityUnallocated(AllocationMode customerPrioritized);
	double getQuantityAllocated(AllocationMode customerPrioritized);
	void setLotNotExpireBeforeDt(Date date);
	Date getLotNotExpireBeforeDt();
}
