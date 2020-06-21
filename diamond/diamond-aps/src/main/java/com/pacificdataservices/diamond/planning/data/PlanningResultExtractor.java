package com.pacificdataservices.diamond.planning.data;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.pacificdataservices.diamond.models.AllocOnhand;
import com.pacificdataservices.diamond.models.AllocReplen;
import com.pacificdataservices.diamond.models.AllocWo;
import com.pacificdataservices.diamond.models.ApsAllocOnhandFc;
import com.pacificdataservices.diamond.models.ApsAllocOnhandOo;
import com.pacificdataservices.diamond.models.ApsAllocOnhandSs;
import com.pacificdataservices.diamond.models.ApsAllocOnhandWo;
import com.pacificdataservices.diamond.models.ApsAllocReplenFc;
import com.pacificdataservices.diamond.models.ApsAllocReplenOo;
import com.pacificdataservices.diamond.models.ApsAllocReplenSs;
import com.pacificdataservices.diamond.models.ApsAllocReplenWo;
import com.pacificdataservices.diamond.models.ApsAllocWoFc;
import com.pacificdataservices.diamond.models.ApsAllocWoOo;
import com.pacificdataservices.diamond.models.ApsAllocWoSs;
import com.pacificdataservices.diamond.models.ApsAllocWoWo;
import com.pacificdataservices.diamond.models.ApsResultDtlDmd;
import com.pacificdataservices.diamond.planning.Allocation;
import com.pacificdataservices.diamond.planning.AllocationMode;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.demand.DemandCustomer;
import com.pacificdataservices.diamond.planning.demand.DemandForecast;
import com.pacificdataservices.diamond.planning.demand.DemandSafetyStock;
import com.pacificdataservices.diamond.planning.demand.DemandWorkOrder;
import com.pacificdataservices.diamond.planning.supply.SupplyOnhand;
import com.pacificdataservices.diamond.planning.supply.SupplyReplen;
import com.pacificdataservices.diamond.planning.supply.SupplyWorkOrder;

public class PlanningResultExtractor {

	private PlanningData pd;
	private PlanningResult pr;

	public PlanningResultExtractor(PlanningData pd) {
		this.pd = pd;
		this.pr = new PlanningResult();
	}

	public PlanningResult getPlanningResult() {
		populateAllocations();
		pr.setItemNumbers(pd.getItemNumbers());
		populateApsResultDtlDmds();
		return pr;
	}


	private void populateAllocations() {
		int id = pd.getNextAllocationNumber();
		for (Allocation a : pd.getAllocations(AllocationMode.FIRST_PASS) ) {
			Object o = getAllocationPersistenceBean(a,id++);
			switch (a.getAllocationType())  {
			case ONHAND_FC:
				pr.getApsAllocOnhandFcs().add((ApsAllocOnhandFc) o);
				break;
			case ONHAND_OO:
				pr.getApsAllocOnhandOos().add((ApsAllocOnhandOo) o);
				break;
			case ONHAND_SS:
				pr.getApsAllocOnhandSss().add((ApsAllocOnhandSs) o);
				break;
			case ONHAND_WO:
				pr.getApsAllocOnhandWos().add((ApsAllocOnhandWo) o);
				break;
			case REPLEN_FC:
				pr.getApsAllocReplenFcs().add((ApsAllocReplenFc) o);
				break;
			case REPLEN_OO:
				pr.getApsAllocReplenOos().add((ApsAllocReplenOo) o);
				break;
			case REPLEN_SS:
				pr.getApsAllocReplenSss().add((ApsAllocReplenSs) o);
				break;
			case REPLEN_WO:
				pr.getApsAllocReplenWos().add((ApsAllocReplenWo) o);
				break;
			case WO_FC:
				pr.getApsAllocWoFcs().add((ApsAllocWoFc) o);
				break;
			case WO_OO:
				pr.getApsAllocWoOos().add((ApsAllocWoOo) o);
				break;
			case WO_SS:
				pr.getApsAllocWoSss().add((ApsAllocWoSs) o);
				break;
			case WO_WO:
				pr.getApsAllocWoWos().add((ApsAllocWoWo) o);
				break;
			default:
				break;
			}		

		}

	}

	public static Object getAllocationPersistenceBean(Allocation allocation, int id) {
		Object retval =null;
		AllocOnhand ao  = null;
		AllocReplen ar = null;
		AllocWo     wo = null;
		DemandCustomer demandCustomer = null;
		DemandForecast demandForecast = null;
		DemandSafetyStock demandSafetyStock = null;
		DemandWorkOrder demandWorkOrder = null;

		switch (allocation.getAllocationType())  {
		case ONHAND_OO:
		case REPLEN_OO:
		case WO_OO:
			demandCustomer	= (DemandCustomer) allocation.getDemand();
			break;
		case ONHAND_FC:
		case REPLEN_FC:
		case WO_FC:
			demandForecast	= (DemandForecast) allocation.getDemand();
			break;
		case ONHAND_SS:
		case REPLEN_SS:
		case WO_SS:
			demandSafetyStock	= (DemandSafetyStock) allocation.getDemand();
			break;
		case ONHAND_WO:
		case REPLEN_WO:
		case WO_WO:
			demandWorkOrder	= (DemandWorkOrder) allocation.getDemand();
			break;
		}

		switch (allocation.getAllocationType())  {
		case ONHAND_FC:
			ApsAllocOnhandFc aaof = new ApsAllocOnhandFc();
			aaof.setApsAllocOnhandFcNbr(id);
			aaof.setFcFcstNbr(demandForecast.getFcFcstNbr());
			retval = ao = aaof;
			populateAllocOnhand(ao, allocation);
			break;
		case ONHAND_OO:
			ApsAllocOnhandOo aaoo = new ApsAllocOnhandOo();
			aaoo.setApsAllocOnhandOoNbr(id);
			aaoo.setOeOrdDtlNbr(demandCustomer.getOeOrdDtlNbr());
			retval = ao = aaoo;
			populateAllocOnhand(ao, allocation);
			break;
		case ONHAND_SS:
			ApsAllocOnhandSs aaos = new  ApsAllocOnhandSs();
			aaos.setApsAllocOnhandSsNbr(id);
			aaos.setFcItemMastNbr(demandSafetyStock.getFcItemMastNbr());
			retval =  ao = new ApsAllocOnhandSs();
			populateAllocOnhand(ao, allocation);
			break;
		case ONHAND_WO:
			ApsAllocOnhandWo aaow = new ApsAllocOnhandWo();
			aaow.setApsAllocOnhandWoNbr(id);
			retval = ao = new ApsAllocOnhandWo();
			populateAllocOnhand(ao, allocation);
			break;
		case REPLEN_FC:
			ApsAllocReplenFc aarf = new ApsAllocReplenFc();
			aarf.setApsAllocReplenFcNbr(id);
			aarf.setFcFcstNbr(demandForecast.getFcFcstNbr());
			retval = ar = aarf;
			populateReplen(ar,allocation);
			break;
		case REPLEN_OO:
			ApsAllocReplenOo aaro =  new ApsAllocReplenOo();
			aaro.setApsAllocReplenOoNbr(id);
			aaro.setOeOrdDtlNbr(demandCustomer.getOeOrdDtlNbr());
			retval = ar = aaro; 
			populateReplen(ar,allocation);
			break;
		case REPLEN_SS:
			ApsAllocReplenSs aass =  new ApsAllocReplenSs();
			aass.setApsAllocReplenSsNbr(id);
			retval = ar = aass;
			populateReplen(ar,allocation);
			break;
		case REPLEN_WO:
			ApsAllocReplenWo aawo =  new ApsAllocReplenWo();
			aawo.setApsAllocReplenWoNbr(id);
			retval = ar = aawo;
			populateReplen(ar,allocation);
			break;
		case WO_FC:
			ApsAllocWoFc wofc = new ApsAllocWoFc();
			wofc.setApsAllocWoFcNbr(id);
			retval = wo = wofc;
			populateWo(wo,allocation);
			break;
		case WO_OO:
			ApsAllocWoOo wooo = new ApsAllocWoOo();
			DemandCustomer dr  = (DemandCustomer) allocation.getDemand();
			wooo.setOeOrdDtlNbr(dr.getOeOrdDtlNbr());
			wooo.setApsAllocWoOoNbr(id);
			retval =  wo = wooo;
			populateWo(wo,allocation);
			break;
		case WO_SS:
			ApsAllocWoSs woss = new ApsAllocWoSs();
			woss.setApsAllocWoSsNbr(id);
			retval =  wo = woss;
			populateWo(wo,allocation);
			break;
		case WO_WO:
			ApsAllocWoWo wowo = new ApsAllocWoWo();
			wowo.setApsAllocWoWoNbr(id);
			retval =  wo = wowo;
			populateWo(wowo,allocation);
		default:
			break;


		}
		return retval;
	}


	private static void populateAllocOnhand(AllocOnhand ao, Allocation a) {

		ao.setAllocQty(new BigDecimal(a.getAllocQty()));
		ao.setAllocTypeId("U");
		SupplyOnhand s = (SupplyOnhand) a.getSupply();
		ao.setFacilityAct(s.getFacility());
		ao.setIcItemMast(s.getIcItemMast());
		ao.setLotNbr(s.getLotNbr());
		ao.setApsSplySubPoolNbr(s.getApsSplySubPoolNbr());
	}

	private static void populateReplen(AllocReplen ar, Allocation a) {
		ar.setAllocQty(new BigDecimal(a.getAllocQty()));
		ar.setAllocTypeId("U");
		SupplyReplen s = (SupplyReplen) a.getSupply();
		ar.setFacilityAct(s.getFacility());
		ar.setIcItemMast(s.getIcItemMast());
		ar.setPoLineDtlNbr(s.getPoLineDtlNbr());
		ar.setApsSplySubPoolNbr(s.getApsSplySubPoolNbr());

	}

	private static void populateWo(AllocWo wo, Allocation a) {
		wo.setAllocQty(new BigDecimal(a.getAllocQty()));
		wo.setAllocTypeId("U");
		SupplyWorkOrder s = (SupplyWorkOrder) a.getSupply();
		wo.setFacilityAct(s.getFacility());
		wo.setIcItemMast(s.getIcItemMast());
		wo.setWoHdrNbr(s.getWoHdrNbr());
		wo.setApsSplySubPoolNbr(s.getApsSplySubPoolNbr());

	}

	public void populateApsResultDtlDmds() {
		pd.populateApsResultDtlDmds();
		pr.setApsResultDtlDmds(pd.getApsResultDtlDmds());
	}
	
	
//	public void populateApsResultDtlDmds() {
//
//		int id = pd.getApsResultDtlDmdId();
//
//		ArrayList<ApsResultDtlDmd> ardds = new ArrayList<>();
//		for (Demand demand : pd.getDemands()) {
//			ApsResultDtlDmd ardd = new ApsResultDtlDmd();
//			ardd.setAvailDt(demand.getAvailDt(AllocationMode.FIRST_PASS));
//			ardd.setRqstDtAllocQty(new BigDecimal(demand.getAllocatedOnTimeQty(AllocationMode.FIRST_PASS)));
//			ardd.setApsResultDtlDmdNbr(id++);
//			ardd.setFacilityDmd(demand.getPrimarySourcingFacility());
//			ardd.setItemNbrRqst(demand.getItemNbrDmd());
//			ardd.setDmdIdentifier(demand.getDmdCd());
//			if (demand.isCustomerDemand()) {
//				DemandCustomer oo =  (DemandCustomer) demand;
//				ardd.setOeOrdDtlNbr(oo.getOeOrdDtlNbr());
//				ardd.setOrgNbrMfrRqst(oo.getOrgNbrMfrRqst());
//				ardd.setPromDtCurr(oo.getPromDtCurr());
//			}
//			if (demand.isWorkOrderDemand()) {
//				DemandWorkOrder wo = (DemandWorkOrder) demand;
//				ardd.setWoDtlNbr(wo.getWoDtlNbr());
//			}
//			if (demand.isForecastDemand()) {
//				DemandForecast fc = (DemandForecast) demand;
//				ardd.setFcFcstNbr(fc.getFcFcstNbr());
//				ardd.setFcItemMastNbr(fc.getFcItemMastNbr());
//			}
//			if (demand.isSafetyStockDemand()) {
//				DemandSafetyStock ss = (DemandSafetyStock) demand;
//				ardd.setFcItemMastNbr(ss.getFcItemMastNbr());
//			}
//			if (demand.isForecastDemand()) {
//				DemandForecast fc1 = (DemandForecast) demand;
//				ardd.setDmdQty(new BigDecimal(fc1.getUnconsumedQty(AllocationMode.FIRST_PASS)));
//			} else {
//				ardd.setDmdQty(demand.getOpenQty());
//			}
//			ardd.setDmdQtyAdj(ardd.getDmdQty());
//			ardd.setAllocQty(new BigDecimal(demand.getAllocatedQty(AllocationMode.FIRST_PASS)));
//			ardd.setRqstDt(demand.getNeedByDate());
//			ardd.setApsSrcRuleSetNbrDmd(demand.getApsSrcRuleSetNbr());
//			ardd.setOrgNbrCust(demand.getOrgNbrCust());
//			//ardd.setAvailDt(demand.getAvailDt(AllocationMode.FIRST_PASS));
//			ardds.add(ardd);
//		}
//		pr.setApsResultDtlDmds(ardds);
//		pd.setApsResultDtlDmds(ardds);
//	}

}
