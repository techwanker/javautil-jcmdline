package com.pacificdataservices.diamond.planning;

import java.io.BufferedWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import org.javautil.properties.PropertyManager;
import org.javautil.util.Day;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.diamond.models.PoRequisition;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.services.PlanningQueueServiceImpl;

public class PlanningEngine implements Runnable {

	
	private PlanningQueueServiceImpl planningQueue;
	private RunMode runMode;
	private boolean async;
	private boolean writeLog = true;
	public static final String revision = "$Revision: 1.22 $";
	
	private int planRunNumber;

	private PlanningData planningData;
	private static Logger logger = LoggerFactory.getLogger(PlanningEngine.class.getName());
	// containers
	private HashMap<Integer, Demand> createdWorkOrdersToCover = new HashMap<Integer, Demand>();
	private int itemsRequested = 0;
	private boolean synchronous = false;
	private Collection<Integer> itemNumbers = null;
	// shared
	private BufferedWriter tracer = null;
	// private ApsShortOrLate shortfall = null;
	// private CreateWorkOrder createWorkOrder = null;
	/**
	 * TODO should be shared accross all instances
	 */
	// private ApsItemReplenPolicies replenPolicies;
	private Collection<PoRequisition> requisitions;
	// method classes
	/**
	 * TODO restore this logic
	 */
	// private PriceOrderLine priceOrderLine = null;
	// properties
	private PropertyManager properties = null;
	private boolean setAction = false;

	/**
	 * Not yet used, but will be used when request termination is supported.
	 */
	// private SynchronousRequest synchronousRequest = null;
	private String engineName;
	private Allocator allocator;
	public int allocToReplenWindow = 0;
	private String name;
	private boolean batchMode = true;
	private PlanningPersistence persistence;
	private PlanningEngine apsCtl;
	//private PropertyManager propertyManager;

	public PlanningEngine(
			PropertyManager propertyManager, 
			boolean async,
			String engineName, PlanningQueueServiceImpl threadDispatcher, RunMode runMode) {

	//	this.propertyManager = propertyManager;
		this.async = async;
		this.engineName = engineName;
		this.planningQueue = threadDispatcher;
		this.runMode = runMode;
		// TODO Auto-generated constructor stub
	}

	private void setAction(String action) {
		// to be used only with oracle connection
	}

	/**
	 * TODO set property to blow up or keep running when an otherwise unhandled
	 *       exception is encountered.
	 * TODO must delete po_requisitions
	 * TODO planning engine populate aps_rslt_dtl_sply is now a property add to
	 *       properties
	 * TODO create a dispatch group in addition to the plan group in
	 *       aps_dispatch_queue and don't put results in aps_result_dtl_supply
	 *       if not in the same plan group
	 * TODO TEST - make sure aps_result_dtl_demand and supply are properly
	 *       populated
	 * TODO make asynchronous puts do gets from dispatcher to make wait times
	 *       almost meaningful
	 * TODO make dispatcher run again by listening for requests
	 * TODO make dispatcher listen for higher priority requests
	 * TODO have dispatcher order work orders by low level code
	 * TODO make sure conn and conn don't get lower than planning engine.
	 * TODO throw with root cause - SQLExceptions don't show
	 * TODO make other cacheable objects refresh when required
	 * TODO figure out deltas on items that need to be planned when cache
	 *       changes.
	 *       <ul>
	 *       <li>need to also add allocation requests and figure out how to
	 *       override and how this affects preservation.</li>
	 *       <li>need to prioritize in order to preserve existing
	 *       allocations</li>
	 *       <li>create DiamondProperties class</li>
	 *       </ul>
	 */

	//
	// Initialization
	//
	//
	private void initialize() {
		setProperties();
		setAction("instantiating");
		// trc = new Tracer(traceDirectory + "/PlanningItem.log");
		// conn.setModule(engineName);
		logger.info("instantiating PlanningItem");

	}

	private void setProperties() {
		String className = PlanningEngine.class.getName();
//		traceDirectory = properties.getMandatoryProperty(className + ".traceDirectory.absolute");
//		traceDirectoryVirtual = properties.getMandatoryProperty(className + ".traceDirectory.virtual");
//		setAction = properties.getBooleanProperty(className + ".setAction", false);
	}

	@Override
	public void run() {
		logger.info((synchronous ? "synchronous" : "asynchronous") + " PlanningItem started " + engineName);
		boolean ok = true;
		int requestCount = 0;
		while (ok) {

			Set<Integer> itemsToPlan = planningQueue.getItemNumbers();
			if (itemsToPlan.size() > 0) {
				planItem(itemNumbers);
//				conn.commit();
			} else {
				if (batchMode) {
					logger.info("in batch mode, no request, exiting");
					ok = false;
				} else {
					// logger.info("no work");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block not going to happen
						e.printStackTrace();
					}
				}
			}
		}
	}


	/**
	 * TODO fix to create work orders
	 * TODO passing this an itemNbr is goofy By now, the items to be planned
	 *       should be in tmp_item. Steps
	 *       <ol>
	 *       <li>delete prior summary information</li>
	 *       <li>delete all allocations for this set of items not in pick or
	 *       bound or requested to be bound</lI>
	 *       <li>get ic_item_mast for plan group</li>
	 *       <li>get the supplies</li>
	 *       </ol>
	 */
	private void planItem(Collection<Integer> itemNbrs) {
		Day today = new Day();
		// logger.info("today is " + today);
		this.itemNumbers = itemNbrs;
		Collection<Allocation> allocations = null;
		do {

			createdWorkOrdersToCover.clear();
			allocator.allocate();
			
			if (allocator.isCanOverShip()) {
				allocations = planningData.getAllocations(AllocationMode.OVERSHIP);
				persistence.persist(allocations);
			} else {
				logger.debug("NO OVERSHIPMENTS. JUST REGULAR ALLOCATIONS. Inserting " + allocations.size() + " ALLOCATIONS");
				persistence.persist(allocator.getAllocations(AllocationMode.CUSTOMER_PRIORITIZED));
			}
			// TODO this is Dickies
			// requisitions = GlobalRequisition.compute(replenPolicies,
			// dmds.getDemands());
			// requisitionPersistence.insertRows(conn, requisitions,
			// requisitions.size());
		} while (generateWorkOrders());
//		if (writeLog) {
//			generateTrace();
//		}
//		try {
//			priceOrderLine.priceLines(allocations);
//		} catch (java.sql.SQLException pricingProblem) {
//			logger.warning("pricing problem trapped " + pricingProblem.getMessage());
//		}
		// logTmpItemS(engineName + "finished planning");
		// prep.dequeue();
		// dispatcher.dequeue(itemNumbers);
		// shortfall.insert(allocator.getDemandS().getPrioritizedDemands());
//
//		if (tracer != null) {
//			tracer.close();
//		}
	}

	private boolean generateWorkOrders() {
			throw new UnsupportedOperationException();
	}

	// private boolean generateWorkOrders() throws java.sql.SQLException {
	// boolean createdWorkOrder = false;
	//
	// Iterator demandsIterator = dmds.getPrioritizedDemandsIterator();
	// if (createWorkOrder == null) {
	// createWorkOrder = new CreateWorkOrder(conn);
	// }
	// while (demandsIterator.hasNext()) {
	// if (workOrdersCreated > 24) {
	// break;
	// }
	// Demand demand = (Demand) demandsIterator.next();
	//
	// if (demand.unallocatedQty(AllocationMode.CUSTOMER_PRIORITIZED) > 0) {
	// if (demand.getItemMaster().getKitFlg().equals("Y") &&
	// demand.getItemMaster().getStatId().equals("A")) {
	// if (demand.getApsSrcRuleSet().getAutoWorkOrderRule() != null) {
	// if ((createdWorkOrdersToCover.get(demand.getPrimaryKey()) != null)) {
	// logger.fine("already attempted to cover this demand");
	// } else {
	// workOrdersCreated++;
	// @SuppressWarnings("unused")
	// int woHdrNbr = createWorkOrder.create(demand, demand
	// .unallocatedQty(AllocationMode.CUSTOMER_PRIORITIZED));
	// createdWorkOrder = true;
	// createdWorkOrdersToCover.put(demand.getPrimaryKey(), demand);
	// }
	// } else {
	// logger
	// .warning("The replen sourcing rule is not a WorkOrder SupplyType, no work
	// order created for sourcing rule set"
	// + demand.getApsSrcRuleSet().getApsSrcRuleSetCd());
	// }
	// }
	// }
	// }
	// if (createdWorkOrder) {
	// logger.info("Created a work order");
	// }
	// return createdWorkOrder;
	// }

//	 private void generateTrace() throws IOException, SQLException {
//	
//	 String pathNameTrailer =
//	 FileHelper.getPathName(icItemMastS.getMinimumItemNbr()) + ".xml";
//	 String fullPathName = traceDirectory + "/" + pathNameTrailer;
//	 String virtualPath = traceDirectoryVirtual + "/" + pathNameTrailer;
//	 File fullPath = new File(fullPathName);
//	 String dirPath = fullPath.getParent();
//	 File dirMaker = new File(dirPath);
//	 dirMaker.mkdirs();
//	 planGroupSnapshot = new PlanGroupSnapshot(this);
//	 OutputFormat format = OutputFormat.createPrettyPrint();
//	
//	 FileWriter fw = new FileWriter(fullPathName);
//	 BufferedWriter fwb = new BufferedWriter(fw);
//	 XMLWriter writer = new XMLWriter(fwb, format);
//	 Document doc = planGroupSnapshot.getXmlDocument();
//	 icItemMastS.updateLogName(virtualPath);
//	 writer.write(doc);
//	 writer.close();
//	 fwb.close();
//	 }
	

//	private void deletePriorSummaryInfo() throws SQLException {
//		prep.prepApsResultDtl();
//	}

//	private void recordException(Exception e) throws java.sql.SQLException {
//		e.printStackTrace();
//		for (IcItemMast master : icItemMastS) {
//			requests.updateException(master.getItemNbr(), e.getMessage());
//		}
//	}

	// public ArrayList<Demand> getDemands() {
	// return dmds;
	// }
	/**
	 * TODO move this somewhere
	 */
	// public Collection<Certification>
	// getApplicableCertifications(Iterable<Supply> supplies) {
	// TreeSet<String> usedCertCodes = new TreeSet<String>();
	// ArrayList<Certification> usedCerts = new ArrayList<Certification>();
	// int woSupplyWithCerts = 0;
	// int ohSupplyWithCerts = 0;
	// int poSupplyWithCerts = 0;
	// int woSupply = 0;
	// int poSupply = 0;
	// int ohSupply = 0;
	// for (Supply supply : supplies) {
	// if (supply instanceof SupplyOnhand) {
	// ohSupply++;
	// }
	// if (supply instanceof SupplyWorkOrder) {
	// woSupply++;
	// }
	// if (supply instanceof SupplyReplen) {
	// poSupply++;
	// }
	// SupplyCertifications supplyCerts = supply.getCertifications();
	// if (supplyCerts == null) {
	// // logger.warning("supplyCerts is null for " + supply);
	// } else {
	// if (supply instanceof SupplyOnhand) {
	// ohSupplyWithCerts++;
	// }
	// if (supply instanceof SupplyWorkOrder) {
	// woSupplyWithCerts++;
	// }
	// if (supply instanceof SupplyReplen) {
	// poSupplyWithCerts++;
	// }
	// for (SupplyCertification supplyCert : supply.getCertifications()) {
	// usedCertCodes.add(supplyCert.getCert().getCertCd());
	// }
	// }
	// // logger.info("wo " + woSupply + " " + woSupplyWithCerts + " po " +
	// poSupply + " " + poSupplyWithCerts + " oh " + ohSupply + " " +
	// ohSupplyWithCerts);
	// }
	// for (Demand demand : apsDmdOoS) {
	// Certifications certs = demand.getCertifications();
	// if (certs != null) {
	// for (String code : certs.getCertificationCodes()) {
	// usedCertCodes.add(code);
	// }
	// }
	// }
	// for (Demand demand : apsDmdSsS) {
	// Certifications certs = demand.getCertifications();
	// if (certs != null) {
	// for (String code : certs.getCertificationCodes()) {
	// usedCertCodes.add(code);
	// }
	// }
	// }
	// for (Demand demand : apsDmdWoS) {
	// Certifications certs = demand.getCertifications();
	// if (certs != null) {
	// for (String code : certs.getCertificationCodes()) {
	// usedCertCodes.add(code);
	// }
	// }
	// }
	// for (String certCd : usedCertCodes) {
	// usedCerts.add(certCache.getForCertCode(certCd));
	// }
	// return usedCerts;
	// }

	public PropertyManager getProperties() {
		return properties;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.diamond10.planning.PlanningMgr#getIcItemMastEquivS()
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.diamond10.planning.PlanningMgr#getEffectiveDate()
	 */
	public Day getEffectiveDate() {
		Day returnValue = null;
		if (apsCtl.getEffectiveDate() == null) {

			returnValue = new Day();
		} else {
			returnValue = new Day(apsCtl.getEffectiveDate());

		}

		return returnValue;
	}

	// /* (non-Javadoc)
	// * @see
	// com.diamond10.planning.PlanningMgr#isPopulatingResultSupplyDetails()
	// */
	// public boolean isPopulatingResultSupplyDetails() {
	// boolean rc = false;
	// AppCtlS appCtlS = (AppCtlS) cache.get(AppCtlS.class.getName());
	// AppCtl appCtl = appCtlS.get("insertApsResultDtlSply");
	// if (appCtl != null && appCtl.getPropertyVal().equalsIgnoreCase("true")) {
	// rc = true;
	// }
	// return rc;
	// }

}
