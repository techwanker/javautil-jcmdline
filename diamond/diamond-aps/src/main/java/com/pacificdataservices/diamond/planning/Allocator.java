package com.pacificdataservices.diamond.planning;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.javautil.core.misc.Timer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.diamond.planning.data.ForecastBuckets;
import com.pacificdataservices.diamond.planning.data.NoForecastGroupException;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.demand.DemandComparator;
import com.pacificdataservices.diamond.planning.demand.DemandCustomer;
import com.pacificdataservices.diamond.planning.demand.DemandPrioritizer;
import com.pacificdataservices.diamond.planning.demand.DemandPrioritizerImpl;
import com.pacificdataservices.diamond.planning.demand.DemandType;
import com.pacificdataservices.diamond.planning.demand.DemandWorkOrder;
import com.pacificdataservices.diamond.planning.demand.ForecastGroups;
import com.pacificdataservices.diamond.planning.supply.Supply;
import com.pacificdataservices.diamond.planning.supply.SupplyOnhand;
import com.pacificdataservices.jdbc.PersistenceAction;

/**
 * <ul>
 * <li>Prioritze demands</li>
 * 
 * @author jjs
 *
 */
public class Allocator {

	private transient static Logger logger = LoggerFactory.getLogger(Allocator.class);

	private boolean debugging = logger.isDebugEnabled();
	private transient Logger analytics = LoggerFactory.getLogger(getClass());

	private PlanningData planningData;

	private List<Allocation> firstPassAllocations;

	private Map<Integer, Double> availabilityByCustomer;
	// TODO wire
	private DemandPrioritizer prioritizer = new DemandPrioritizerImpl();

	private StringBean stringBean = new StringBean();

	public Allocator(PlanningData planningData) {
		this.planningData = planningData;
	}

	public void allocate() {
		Timer allocateTimer = new Timer();
		prioritizeDemands();
		logger.debug("about to set eligible supplies");
		associateEligibleSupplies();
		logger.debug("setEligibleSupplies complete");
		// // TODO restore other modes
		// // setPreviousAllocations(); // TODO does nothing in 10.17
		// // restoreOnhandPickAllocations();
		restoreBoundAllocations();
		firstPass();
		logger.debug("Allocator.allocate us {}", allocateTimer.getElapsedMicros());

		// computeCustomerSupply();
		// demandS.setCustomerEligibleSupplies();
		// customerPrioritized();
		// TODO restore
		// if (requestToOverShip()) {
		// overship();
		// }

	}

	public TreeMap<String, Demand> prioritizeDemands() {
		logger.debug("prioritizedDemands(): prioritizing demands");

		prioritizer.prioritize(planningData);
		logger.debug("prioritizedDemands() prioritize done");
		TreeMap<String, Demand> prioritizedDemands = getPrioritizedDemands();
		planningData.setPrioritizedDemands(prioritizedDemands);
		int demandsSize = planningData.getDemands().size();
		int prioritizedSize = prioritizedDemands.size();
		if (demandsSize != prioritizedSize) {
			throw new IllegalStateException("demands.size() " + demandsSize + " prioritizedSize " + prioritizedSize);
		}
		logger.debug("prioritizeDemands(): exiting");
		return prioritizedDemands;
	}

	public void associateEligibleSupplies() {
		Timer t = new Timer();
		TreeMap<String, Demand> prioritizedDemands = planningData.getPrioritizedDemands();
		logger.debug("setEligibleSupplies(): prioritizedDemands.size(); " + prioritizedDemands.size());
		int demandNbr = 0;
		int demandCount = prioritizedDemands.size();
		for (Demand demand : prioritizedDemands.values()) {
			logger.trace("associateEligibleSupplies: setting supplies for demand #{} demand {} ", ++demandNbr, demand);
			if (demand.getApsSrcRuleSet() != null) {
				EligibleSupplies eligible = new EligibleSupplies(demand, planningData, stringBean);
				if (eligible.getPrioritizedSupply() == null) {
					throw new IllegalStateException("null prioritizedSupply for " + eligible);
				}
				demand.setEligibleSupplies(eligible);
			} else {
				logger.error("setElibleSupplies(): no ApsSrcRuleSet");
			}
		}
		long delta = t.getElapsedMicros();
		if (demandCount > 0) {
			analytics.info("associateEligibleSupplies complete for {} demands  {} micros {} micros per demand",
					demandCount, delta, delta / demandCount);
		}
	}

	public TreeMap<String, Demand> getPrioritizedDemands() {
		Timer t = new Timer();
		TreeMap<String, Demand> prioritizedDemands = planningData.getPrioritizedDemands();

		if (planningData.getPrioritizedDemands() != null) {
			logger.warn("this has already been prioritized");
		} else {
			prioritizedDemands = new TreeMap<String, Demand>();
			int i = 1;
			for (Demand demand : planningData.getDemands()) {
				// logger.debug("processing " + demand.summaryString());
				String priorityCd = demand.getPriorityCode();
				Demand existing = prioritizedDemands.get(priorityCd);
				if (existing != null) {
					String message = "duplicate priorityCd " + priorityCd + "\n" + existing.summaryString() + "\n"
							+ "\n" + demand.summaryString();
					logger.error(message);
					throw new IllegalStateException(message);
				}
				prioritizedDemands.put(priorityCd, demand);
			}

			if (logger.isDebugEnabled()) {
				logger.debug("prioritized {} resulting in {}", planningData.getDemands().size(),
						+prioritizedDemands.size());
			}
			analytics.info("getPrioritizedDemands {} micros ", t.getElapsedMicros());
			planningData.setPrioritizedDemands(prioritizedDemands);
		}
		return prioritizedDemands;
	}

	public TreeSet<Demand> getPrioritizedDemandsWithinLeadTime() {
		TreeSet<Demand> prioritizedDemandsWithinLeadTime = planningData.getPrioritizedDemandsWithinLeadTime();
		if (prioritizedDemandsWithinLeadTime == null) {
			prioritizedDemandsWithinLeadTime = new TreeSet<Demand>(new DemandComparator());

			List<Demand> demands = planningData.getDemands();
			if (demands == null) {
				throw new IllegalStateException("demands is null");
			}
			for (Demand demand : demands) {
				if (demand.isWithinLeadTime()) {
					prioritizedDemandsWithinLeadTime.add(demand);
				}
			}
			planningData.setPrioritizedDemandsWithinLeadTime(prioritizedDemandsWithinLeadTime);
		}
		return prioritizedDemandsWithinLeadTime;
	}

	public static boolean existingAllocationsToForecasts(PlanningData planningData, String stateName) {
		boolean retval = false;
		StringBuilder sb = new StringBuilder();
		sb.append(stateName + "\n");
		for (Demand dmd : planningData.getPrioritizedDemands().values()) {
			if (dmd.isForecast()) {
				if (dmd.getQuantityAllocated(AllocationMode.FIRST_PASS) > 0) {
					retval = true;
					sb.append("demand has allocations " + dmd + "\n");
					for (Allocation allocation : dmd.getAllocations(AllocationMode.FIRST_PASS)) {
						sb.append(String.format("qty %f %s", allocation.getAllocQty(), allocation.getSupply()));
						sb.append("\n");
					}
				}
			}
		}
		if (retval) {
			String message = sb.toString();
			logger.error(message);
			throw new IllegalStateException(message);
		}
		return retval;

	}

	public TreeMap<String, Integer> customerDemandForecastGroupCount(Collection<Demand> demands) {
		TreeMap<String, Integer> countByFcstGrp = new TreeMap<>();
		for (Demand demand : demands) {
			String fcstGrp = demand.getFcstGrp();
			Integer count = countByFcstGrp.get(fcstGrp);
			if (count == null) {
				countByFcstGrp.put(fcstGrp, 1);
			} else {
				countByFcstGrp.put(fcstGrp, ++count);
			}
		}
		logger.debug("count by forecast group: {}", countByFcstGrp);
		return countByFcstGrp;
	}

	/**
	 * Only allocates within lead time and restores TODO need the rest of these
	 * passes
	 * 
	 * TODO how firm are these lead times?
	 */
	public void firstPass() { // TODO opened up for test
		Timer t = new Timer(getClass(), "firstPass");
		ArrayList<Allocation> allocations = new ArrayList<Allocation>();
		TreeSet<Demand> prioritizedDemandsWithinLeadTime = getPrioritizedDemandsWithinLeadTime();
		planningData.setPrioritizedDemandsWithinLeadTime(prioritizedDemandsWithinLeadTime);
		boolean oops = existingAllocationsToForecasts(planningData, "before ConsumeSafetyStock");

		existingAllocationsToForecasts(planningData, "After consuming safety stock");
		logger.debug("firstPass() consuming forecasts =====");
		Collection<Demand> demands = planningData.getPrioritizedDemands().values();

		customerDemandForecastGroupCount(demands);
		for (Demand dmd : planningData.getPrioritizedDemands().values()) {
			if (dmd.isCustomerDemand()) {
				DemandCustomer dc = (DemandCustomer) dmd;
				if (logger.isDebugEnabled()) {
					ForecastGroups forecastGroups = planningData.getForecastGroups();
					logger.debug("ForecastGroups {}", forecastGroups.summaryInfo());
				}
				ForecastBuckets forecastBuckets = null;
				try {
					forecastBuckets = planningData.getForecastGroups().get(dmd.getFcstGrp());
				} catch (NoForecastGroupException iae) {
					logger.error("Demand:\n{}\nFcstGrp: '{}' \ncan't find Forecast Group in: {}", dmd, dmd.getFcstGrp(),
							planningData.getForecastGroups().getForecastGroupNames());
					//throw iae;
				}
				if (forecastBuckets != null) {
					forecastBuckets.consumeForecastForDemand(dc, AllocationMode.FIRST_PASS);
				}
			}
			if (dmd.isWorkOrderDemand()) {
				// TODO
			}
		}
		existingAllocationsToForecasts(planningData, "After consuming demands");

		logger.debug("==============\n===========\nAllocations after consuming {} ", oops);
		for (Demand dmd : planningData.getPrioritizedDemands().values()) {
			if (dmd.isForecast()) {
				logger.trace("about to allocate for " + dmd.toString());
			}
			dmd.allocate(AllocationMode.FIRST_PASS);
			if (dmd.isForecast()) {
				logger.trace("allocated " + dmd.toString());
			}
		}
		planningData.setAllocations(AllocationMode.FIRST_PASS, allocations);
		firstPassAllocations = getAllocations(AllocationMode.FIRST_PASS);
		t.stop();
		planningData.addTimer(t);
		// printAllocations(firstPassAllocations, "firstPass");
	}

	/**
	 */
	public void allocate(Demand demand, double quantityToAllocate, AllocationMode mode) {
		if (demand.getEligibleSupplies() == null) {
			throw new IllegalStateException("eligible supplies is null");
		}

		double allocateToThisDemand = 0;
		double openQty = demand.getUnallocatedQty(mode);

		if (quantityToAllocate > openQty) {
			allocateToThisDemand = openQty;
		} else {
			allocateToThisDemand = quantityToAllocate;
		}

		double allocThisDemand = 0.0;
		boolean dontMixLots = demand.isMixMfrLot();

		EligibleSupplies eligibles = getEligibleSupplies(demand, mode);

		for (EligibleSupply eligible : eligibles) {
			if (allocateToThisDemand <= 0) {
				break;
			}
			double availQty = 0.0;
			switch (mode) {
			case FIRST_PASS:
			case OVERSHIP:
				availQty = eligible.getSupply().getAvailQty(mode);
				break;
			case CUSTOMER_PRIORITIZED:
				availQty = planningData.getNetAvailableForCustomer(eligible.getDemand());
				break;
			default:
				throw new IllegalStateException("unsupported mode " + mode);
			}
			if (availQty > 0) {

				if (allocateToThisDemand >= availQty) {
					allocThisDemand = availQty;
					allocateToThisDemand -= availQty;
				} else {
					allocThisDemand = allocateToThisDemand;
					allocateToThisDemand -= allocThisDemand;
				}

				if (dontMixLots && demand.getDemandType().equals(DemandType.WORK_ORDER)) {
					DemandWorkOrder wo = (DemandWorkOrder) demand;
					int fullLotAllocations = (int) (allocThisDemand / wo.getComponentQtyPerUnit().doubleValue());
					double residualLotQty = allocThisDemand
							- (fullLotAllocations * wo.getComponentQtyPerUnit().doubleValue());
					allocThisDemand -= residualLotQty;
					allocateToThisDemand += residualLotQty;
				}
				if (allocThisDemand > 0) {
					new Allocation(demand, eligible.getSupply(), allocThisDemand, mode, PersistenceAction.INSERT);
					allocThisDemand = 0.0;
				}
			}
		}
	}

	private EligibleSupplies getEligibleSupplies(Demand demand, AllocationMode mode) {
		EligibleSupplies eligibles = null;
		switch (mode) {
		case FIRST_PASS:
			eligibles = demand.getEligibleSupplies();
			break;
		case CUSTOMER_PRIORITIZED:
			eligibles = planningData.getCustomerEligibleSupplies(demand.getOrgNbrCust());
			break;
		case PICK_RESTORE:
			eligibles = demand.getEligibleSupplies();
			break;
		case OVERSHIP:
			eligibles = demand.getEligibleSupplies();
			break;
		default:
			throw new IllegalStateException("unsupported mode " + mode);
		}
		return eligibles;
	}

	private double consumeSafetyStock(Set<Demand> demandsWithinLeadTime, Demand safetyStockDemand) {
		double safetyStockPending = safetyStockDemand.getPreviousAllocationQty();
		for (Demand dmd2 : demandsWithinLeadTime) {
			if (dmd2.getDemandType().equals(DemandType.CUSTOMER_ORDER)
					|| dmd2.getDemandType().equals(DemandType.WORK_ORDER)) {
				if (dmd2.getFcstGrp().equals(safetyStockDemand.getFcstGrp())) {
					if (dmd2.getPreviousAllocationQty() < dmd2.getGrossOpenQty()) {
						double qtyToAllocate = dmd2.getGrossOpenQty() - dmd2.getPreviousAllocationQty();
						if (safetyStockPending > qtyToAllocate) {
							dmd2.allocate(AllocationMode.FIRST_PASS);
							safetyStockPending -= qtyToAllocate;
						} else {
							dmd2.allocate(AllocationMode.FIRST_PASS);
							safetyStockPending -= safetyStockPending;
						}
						if (safetyStockPending <= 0) {
							break;
						}
					}
				}
			}
		}
		return safetyStockPending;
	}

	private void customerPrioritized() {

		for (Collection<DemandCustomer> customerDemands : planningData.getDemandsByCustomer().values()) {
			for (Demand demand : customerDemands) {
				if (demand.getApsSrcRuleSet() != null) {
					List<Allocation> allocations = demand.allocate(AllocationMode.CUSTOMER_PRIORITIZED);
					planningData.addCustomerPrioritizedAllocations(allocations);
				}
			}
		}
		ArrayList<Allocation> customerPrioritizedAllocations = planningData
				.getAllocations(AllocationMode.CUSTOMER_PRIORITIZED);
		if (planningData.getFirstPassAllocations().size() != customerPrioritizedAllocations.size()) {
			logger.error("while planning " + planningData.getItemNbrsAsString() + " firstPassAllocations.size()"
					+ planningData.getFirstPassAllocations().size() + " customerPrioritized "
					+ customerPrioritizedAllocations.size());
		} else {
			// logger.debug("FIRST PASS AND CUSTOMER PRIORITIZED ALLOCATIONS
			// MATCH. SIZE IS " +
			// firstPassAllocations.size());
		}
		// printAllocations(planningData.getFirstPassAllocations(),
		// "customerPrioritized");
	}

	private String printAllocations(List<Allocation> allocations, String string) {
		throw new UnsupportedOperationException();
		// StringBuilder sb = new StringBuilder();
		// sb.append(string + "\n");
		// for (Allocation allocation : allocations) {
		// sb.append(allocation.toString());
		// sb.append("\n");
		// }
		// String retval = sb.toString();
		// logger.debug("\n" + retval);
		// return sb.toString();
	}

	private void overship() {
		logger.debug("REQUEST TO OVERSHIP IS TRUE");
		createOvershipAllocations();
		boolean canOverShip = true;
		for (Collection<DemandCustomer> customerDemands : planningData.getDemandsByCustomer().values()) {
			for (Demand demand : customerDemands) {
				if (demand.getApsSrcRuleSet() != null) {
					demand.allocate(AllocationMode.OVERSHIP);
				}
			}
		}
		for (Demand demand : planningData.getPrioritizedDemands().values()) {
			/*
			 * logger.debug("CUSTOMER PRIORITIZED ALLOCATION QTY ON TIME IS " +
			 * demand.getOnTimeQty(AllocationMode.CUSTOMER_PRIORITIZED) +
			 * "  AND OVERSHIP ALLOCATION QTY ON TIME IS " +
			 * demand.getOnTimeQty(AllocationMode.OVERSHIP));
			 */
			/*
			 * if (demand.isInPick()) { if (demand.isDegraded(AllocationMode.PICK_RESTORE,
			 * AllocationMode.OVERSHIP)) { canOverShip = false; break; } } else {
			 */
			if (demand.isDegraded(AllocationMode.CUSTOMER_PRIORITIZED, AllocationMode.OVERSHIP)) {
				canOverShip = false;
				break;
			}
			// }
		}
		// printAllocations(firstPassAllocations, "overShip");
	}

	// private HashMap<Integer, TreeSet<Demand>> getDemandsByCustomer() {
	// HashMap<Integer, TreeSet<Demand>> demandsByCustomer = new
	// HashMap<Integer, TreeSet<Demand>>();
	// TreeSet<Demand> prioritizedDemands =
	// planningData.getPrioritizedDemands();
	// logger.debug("getDemandsByCustomer prioritizedDemands.size() " +
	// prioritizedDemands.size());
	// for (Demand demand : prioritizedDemands) {
	// Integer customerNumber = new
	// Integer(demand.getCustomerNumber().intValue());
	// TreeSet<Demand> customerDemands = demandsByCustomer.get(customerNumber);
	// if (customerDemands == null) {
	// customerDemands = new TreeSet<Demand>(new CustomerDemandComparator());
	// demandsByCustomer.put(customerNumber, customerDemands);
	// }
	// customerDemands.add(demand);
	// }
	// planningData.setDemandsByCustomer(demandsByCustomer);
	// return demandsByCustomer;
	// }

	public boolean isCanOverShip() {
		throw new UnsupportedOperationException(); // TODO
	}

	private boolean requestToOverShip() {
		boolean retval = false;
		for (Allocation allocation : planningData.getPreviousAllocations()) {
			if (allocation.getAllocRqstQty() != null) {
				retval = true;
				break;
			}
		}
		return retval;
	}

	public List<Allocation> getAllocations(AllocationMode mode) {
		return planningData.getAllocations(mode);
	}

	private void createOvershipAllocations() {

		ArrayList<Allocation> previousAllocations = planningData.getPreviousAllocations();
		for (Allocation generic : previousAllocations) {
			if (generic.getAllocRqstQty() != null) {
				double allocRqstQty = generic.getAllocRqstQty().doubleValue();
				// logger.debug("looking at " + generic.getAllocationType());
				if (generic.getAllocationType().equals(AllocationType.ONHAND_OO)) {
					Supply supply = generic.getSupply();
					String id = supply.getSupplyIdentifier();

					SupplyOnhand onhand = planningData.getSupplyOnhand(id);
					if (onhand == null) {
						String message = "Allocator.restoreOnhandPickAllocations could not find supply for allocKey "
								+ generic.toString();
						logger.error(message);

					} else {

						Demand dmd = generic.getDemand();
						if (dmd.isCustomerOrder()) {
							DemandCustomer dc = (DemandCustomer) dmd;
							String demandId = dc.getDmdCd();
							DemandCustomer demand = planningData.getCustomerOrderByPk(demandId);
							logger.debug("CREATING OVER SHIP ALLOCATION FOR " + demand);
							/**
							 * ignore warnings that this is never read it links back internally through the
							 * arguments
							 */
							// TODO restore
							// @SuppressWarnings("unused")
							// Allocation allocation = new Allocation(demand,
							// onhand, allocRqstQty, AllocationMode.OVERSHIP,
							// generic,
							// PersistenceAction.UPDATE);
						}
					}
				}
			}
		}

	}

	// private void computeCustomerSupply() {
	// for (Supply supply : planningData.getSupplies()) {
	// supply.getAvailabilityByCustomer();
	// }
	// }

	// /**
	// * Todo this treats every item as though it was the same
	// * @return
	// */
	// public HashMap<Integer, double[]> getAvailabilityByCustomer() {
	//
	// if (availabilityByCustomer == null) {
	// availabilityByCustomer = new HashMap<Integer, double[]>();
	// for (Allocation allocation : firstPassAllocations) {
	// Integer customer = allocation.getDemand().getCustomerNumber();
	// double[] allocated = availabilityByCustomer.get(customer);
	// if (allocated == null) {
	// allocated = new double[1];
	// availabilityByCustomer.put(customer, allocated);
	// }
	// allocated[0] += allocation.getAllocQty().doubleValue();
	// }
	// }
	// return availabilityByCustomer;
	// }
	// TODO finish this

	private void restoreBoundAllocations() {

		// ArrayList<Allocation> previousAllocations =
		// planningData.getPreviousAllocations();
		// ArrayList<Allocation> boundAllocations = new ArrayList<Allocation>();
		// for (Allocation gen : previousAllocations) {
		// if ((gen.getAllocTypeId().equals("B") ||
		// gen.getAllocTypeId().equals("R")) && gen.getQtyInPick() <= 0.0) {
		// boundAllocations.add(gen);
		// }
		// }
		// SupplyOnhand onhand = null;
		// SupplyReplen replen = null;
		// SupplyWorkOrder wo = null;
		//// ApsDmdOo demandOo = null;
		//// ApsDmdWo demandWo = null;
		//// ApsDmdSs demandSs = null;
		//// ApsDmdFc demandFc = null;
		// DemandCustomer demandCustomer = null;
		// DemandWorkOrder demandWorkOrder = null;
		// DemandSafetyStock demandSafetyStock = null;
		// DemandForecast demandForecast;
		//
		// for (Allocation generic : boundAllocations) {
		// Integer preservePk = generic.getAllocationPk();
		// switch (generic.getAllocationType()) {
		// case ONHAND_OO:
		// case ONHAND_WO:
		// case ONHAND_FC:
		// case ONHAND_SS:
		// Supply s = generic.getSupply();
		// ApsSplySubPool sub = s.getApsSplySubPool();
		// String facility = s.getFacility();
		// String supplyId = s.getId()
		// onhand = planningData
		// .getSupplyOnhand(supplyId, sub, facility,
		// planningData.getEffectiveDate());
		// if (onhand == null) {
		// String message = "Allocator.restoreBoundAllocations could not find
		// On-Hand supply for allocKey "
		// + generic.getAllocationPk();
		// logger.warn(message);
		//
		// }
		// break;
		// case REPLEN_OO:
		// case REPLEN_WO:
		// case REPLEN_FC:
		// case REPLEN_SS:
		// replen = planningData.getSupplyReplen(generic.getSupplyPk());
		// if (replen == null) {
		// String message = "Allocator.restoreBoundAllocations could not find
		// Replen supply for allocKey "
		// + generic.getAllocationPk();
		// logger.warn(message);
		//
		// }
		// break;
		// case WO_OO:
		// case WO_WO:
		// case WO_FC:
		// case WO_SS:
		// wo = planningData.getSupplyWorkOrder(generic.getSupplyPk());
		// if (wo == null) {
		// String message = "Allocator.restoreBoundAllocations could not find
		// Work Order supply for allocKey "
		// + generic.getAllocationPk();
		// logger.warn(message);
		//
		// }
		// break;
		// }
		// switch (generic.getAllocationType()) {
		// case ONHAND_OO:
		// case REPLEN_OO:
		// case WO_OO:
		// demandCustomer =
		// planningData.getCustomerDemandByPk(generic.getDemandPk());
		// break;
		// case ONHAND_WO:
		// case REPLEN_WO:
		// case WO_WO:
		// demandWorkOrder =
		// planningData.getWorkOrderByPk(generic.getDemandPk());
		// break;
		// case ONHAND_FC:
		// case REPLEN_FC:
		// case WO_FC:
		// demandSafetyStock =
		// planningData.getSafetyStockDemandByPk(generic.getDemandPk());
		// break;
		// case ONHAND_SS:
		// case REPLEN_SS:
		// case WO_SS:
		// demandForecast =
		// planningData.getForecastByDemandPk(generic.getFcItemMastNbr(),
		// generic.getFcstDt());
		// break;
		// }
		// if (onhand != null) {
		// if (demandCustomer != null) {
		// Allocation allocation = new Allocation(demandCustomer, onhand,
		// generic.getAllocationQty(),
		// AllocationMode.PICK_RESTORE, generic, PersistenceAction.UPDATE);
		// logger.debug("creating Bound Allocation for " + demandCustomer);
		// allocation.setAllocTypeId("B");
		// } else if (demandWorkOrder != null) {
		// Allocation allocation = new Allocation(demandWorkOrder, onhand,
		// generic.getAllocationQty(),
		// AllocationMode.PICK_RESTORE, generic, PersistenceAction.UPDATE);
		// allocation.setAllocTypeId("B");
		// } else if (demandSafetyStock != null) {
		// Allocation allocation = new Allocation(demandSafetyStock, onhand,
		// generic.getAllocationQty(),
		// AllocationMode.PICK_RESTORE, generic, PersistenceAction.UPDATE);
		// allocation.setAllocTypeId("B");
		// } else
		// if (demandForecast != null) {
		// Allocation allocation = new Allocation(demandForecast, onhand,
		// generic.getAllocationQty(),
		// AllocationMode.PICK_RESTORE, generic, PersistenceAction.UPDATE);
		// allocation.setAllocTypeId("B");
		// }
		//
		// } else {
		// if (replen != null) {
		// if (demandCustomer != null) {
		// Allocation allocation = new Allocation(demandCustomer, replen,
		// generic.getAllocationQty(),
		// AllocationMode.PICK_RESTORE, generic, PersistenceAction.UPDATE);
		// //allocation.setPreserve(generic.getAllocationPk());
		// allocation.setAllocTypeId("B");
		// } else if (demandWorkOrder != null) {
		// Allocation allocation = new Allocation(demandWorkOrder, replen,
		// generic.getAllocationQty(),
		// AllocationMode.PICK_RESTORE, generic,PersistenceAction.UPDATE);
		// //allocation.setPreserve(generic.getAllocationPk());
		// allocation.setAllocTypeId("B");
		// } else if (demandSafetyStock != null) {
		// Allocation allocation = new Allocation(demandSafetyStock, replen,
		// generic.getAllocationQty(),
		// AllocationMode.PICK_RESTORE, generic,PersistenceAction.UPDATE);
		// //allocation.setPreserve(generic.getAllocationPk());
		// allocation.setAllocTypeId("B");
		// } else if (demandForecast != null) {
		// Allocation allocation = new Allocation(demandForecast, replen,
		// generic.getAllocationQty(),
		// AllocationMode.PICK_RESTORE, generic, PersistenceAction.UPDATE);
		// //allocation.setPreserve(generic.getAllocationPk());
		// allocation.setAllocTypeId("B");
		// }
		// } else {
		// if (wo != null) {
		// if (demandCustomer != null) {
		// Allocation allocation = new Allocation(demandCustomer, wo,
		// generic.getAllocationQty(),
		// AllocationMode.PICK_RESTORE, generic, PersistenceAction.UPDATE);
		// allocation.setAllocTypeId("B");
		// } else if (demandWorkOrder != null) {
		// Allocation allocation = new Allocation(demandWorkOrder, wo,
		// generic.getAllocationQty(),
		// AllocationMode.PICK_RESTORE, generic, PersistenceAction.UPDATE);
		// allocation.setAllocTypeId("B");
		// } else if (demandSafetyStock != null) {
		// Allocation allocation = new Allocation(demandSafetyStock, wo,
		// generic.getAllocationQty(),
		// AllocationMode.PICK_RESTORE, generic, PersistenceAction.UPDATE);
		// allocation.setAllocTypeId("B");
		// } else if (demandForecast != null) {
		// Allocation allocation = new Allocation(demandForecast, wo,
		// generic.getAllocationQty(),
		// AllocationMode.PICK_RESTORE, generic, PersistenceAction.UPDATE);
		// allocation.setAllocTypeId("B");
		// }
		// }
		// }
		// }
		// }
	}
}
