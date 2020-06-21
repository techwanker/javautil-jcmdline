package com.pacificdataservices.diamond.planning.demand;
//
//
//  TODO nuke ,use AbstractDemand
//
//	import java.math.BigDecimal;
//	import java.util.ArrayList;
//	import java.util.Date;
//	import java.util.Iterator;
//	import java.util.List;
//	import java.util.Set;
//
//
//	import com.pacificdataservices.diamond.hibernate.ApsDemand;
//	import com.pacificdataservices.diamond.hibernate.ApsSrcRule;
//	import com.pacificdataservices.diamond.hibernate.ApsSrcRuleSet;
//	import com.pacificdataservices.diamond.hibernate.CustomerDemand;
//import com.pacificdataservices.diamond.hibernate.FcstGrp;
//	import com.pacificdataservices.diamond.hibernate.ForecastDemand;
//	import com.pacificdataservices.diamond.hibernate.IcCertCd;
//	import com.pacificdataservices.diamond.hibernate.IcItemMast;
//	import com.pacificdataservices.diamond.hibernate.SafetyStockDemand;
//	import com.pacificdataservices.diamond.hibernate.UtFacility;
//	import com.pacificdataservices.diamond.hibernate.WorkOrderDemand;
//import com.pacificdataservices.jdbc.PersistenceAction;
//
	/**
	 * @author Jim Schmidt 
	 * @deprecated use AbstractDemand
	 */
	@Deprecated
	public class DemandImpl 
//	implements Demand 
	{
//		
//		private  Logger logger = Logger.getLogger(getClass());
//
//		/**
//		 * Supplies that are eligible for this order and available to the customer.
//		 * 
//		 * A first pass allocation determines what is available for the customer.
//		 */
//		private Set<Supply> customerEligibleSupplies = null;
//		//
//		private Set<Supply> eligibleSupplies = null;
//
//		
//		private List<Allocation> previousAllocations = new ArrayList<Allocation>();
//
//		private List<Allocation> customerAvailableAllocations = new ArrayList<Allocation>();
//
//		private List<Allocation> allocationsFirstPass = new ArrayList<Allocation>();
//
//		private List<Allocation> overshipAllocations = new ArrayList<Allocation>();
//
//		private String priorityCd;
//
//		private java.sql.Date endLeadTime;
//
//		private String priorityWithinCustomer;
//
//		private ApsDemand apsDemand;
//
//		private PlanningData planningData;
//
//		private String xmlId;
//
//		public DemandImpl(ApsDemand wrappedDemand, PlanningData planningData) {
//			this.apsDemand = wrappedDemand;
//			this.planningData = planningData;
//		}
//
//		public DemandType getDemandType() {
//			String demandTypeCd = apsDemand.getDmdTypeCd();
//			DemandType retval = null;
//			if ("OO".equals(demandTypeCd)) {
//				retval = DemandType.CUSTOMER_ORDER;
//			} else if ("WO".equals(demandTypeCd)) {
//				retval = DemandType.WORK_ORDER;
//			} else if ("FC".equals(demandTypeCd)) {
//				retval = DemandType.FORECAST;
//			} else if ("SS".equals(demandTypeCd)) {
//				retval = DemandType.SAFETY_STOCK;
//			} else {
//				throw new IllegalStateException("unknown demand type+'" + demandTypeCd + "' in " + apsDemand.toString()  );
//			}
//			return retval;
//		}
//		public List<Allocation> getPreviousAllocations() {
//			return previousAllocations;
//		}
//
//		public final double unallocatedQty(AllocationMode mode) {
//
//			double rc = -01;
//			if (apsDemand.getApsSrcRuleSet().getApsSrcRuleSetNbr() == 0) { // todo can this ever be true?  how does this become null
//				rc = 0;
//			} else {
//
//				if (apsDemand instanceof ForecastDemand) {
//
//					ForecastDemand dmd = (ForecastDemand) apsDemand;
//					rc = getUnconsumedQty(mode) - getAllocatedQty(mode);
//				} else {
//					rc = getGrossOpenQty().doubleValue() - getAllocatedQty(mode);
//				}
//				if (rc < 0) {
//					if (mode != AllocationMode.OVERSHIP) {
//						logger.warn("demand is overallocated " + this.toString());
//						rc = 0;
//					} else {
//						rc = 0;
//					}
//				}
//			}
//			return rc;
//		}
//
//		
//
//		public final void setAllocations(ArrayList<Allocation> allocations,
//				AllocationMode mode) {
//			this.allocationsFirstPass = allocations;
//		}
//
//		public final List<Allocation> getAllocations(AllocationMode mode) {
//			List<Allocation> returnValue = null;
//			switch (mode) {
//			case FIRST_PASS:
//				returnValue = allocationsFirstPass;
//				break;
//			case PICK_RESTORE:
//				returnValue = allocationsFirstPass;
//				break;
//			case CUSTOMER_PRIORITIZED:
//				returnValue = customerAvailableAllocations;
//				break;
//			case OVERSHIP:
//				returnValue = overshipAllocations;
//				break;
//			default:
//				throw new IllegalArgumentException("unsupported mode " + mode);
//			}
//			//logger.info("MODE IS " + mode + " AND RETURNS " + returnValue.size() + " ALLOCATIONS");
//			return returnValue;
//		}
//
//		/**
//		 * add this allocation to the container of allocations for this demand.
//		 * 
//		 * @param val
//		 */
//		public final void addAllocation(Allocation val, AllocationMode mode) {
//			List<Allocation> allocations = getAllocations(mode);
//			allocations.add(val);
//
//		}
//
//		/**
//		 * 
//		 * @return true if the full gross open quantity (the non adjusted open quantity) is not fully allocated.
//		 */
//		public final boolean isNotFullyAllocated(AllocationMode mode) {
//			boolean rc = false;
//			BigDecimal requestedQuantity = getGrossOpenQty();
//			double allocatedQty = getAllocatedQty(mode);
//			BigDecimal bigAlloc = new BigDecimal(allocatedQty);
//			BigDecimal diff = requestedQuantity.subtract(bigAlloc);
//			if (diff.doubleValue() > 0) {
//				rc = true;
//			}
//			return rc;
//		}
//
//		/**
//		 * @return true if the gross (non adjusted open quantity is not fully allocated or the allocation is to supply that has an
//		 *         availability date greater than the requested ship date
//		 */
//		public final boolean isAllocatedLateOrShort(AllocationMode mode) {
//			boolean rc = false;
//			try {
//				java.util.Date maxDate = getMaximumAllocationDate(mode);
//				if (maxDate == null) {
//					rc = true;
//				} else {
//					rc = getQuantityAllocated(mode) < getGrossOpenQty()
//					.doubleValue()
//					|| getMaximumAllocationDate(mode).after(
//							apsDemand.getRqstDt());
//				}
//			} catch (java.lang.NullPointerException n) {
//				if (getGrossOpenQty() == null) {
//					throw new java.lang.NullPointerException(
//							"getGrossOpenQty() is null");
//				}
//				if (apsDemand.getRqstDt() == null) {
//					throw new java.lang.NullPointerException("getRqstDt() is null");
//				}
//				throw n;
//			}
//			return rc;
//		}
//
//		public final double getQuantityAllocated(AllocationMode mode) {
//			double retval = 0.0;
//
//			for (Allocation allocation : getAllocations(mode)) {
//				retval += allocation.getAllocQty().doubleValue();
//			}
//			return retval;
//		}
//
//		//    // todo this needs a mode
//		//    public final double getAllocatedQuantity() {
//		//        double allocatedQty = 0.0;
//		//        for (Allocation allocation : firstPassAllocations()) {
//		//            allocatedQty += allocation.getAllocQty();
//		//        }
//		//        return allocatedQty;
//		//    }
//
//		public double getAllocatedOnTimeQuantity(AllocationMode mode) {
//			double allocatedOnTimeQty = 0.0;
//			for (Allocation allocation : getAllocations(mode)) {
//				if (allocation.getSupply().getApsSupply().getApsAvailDt() == null
//						|| !allocation.getSupply().getApsSupply().getApsAvailDt()
//						.after(apsDemand.getRqstDt())) {
//					allocatedOnTimeQty += allocation.getAllocQty().doubleValue();
//				}
//			}
//			return allocatedOnTimeQty;
//		}
//
////		/**
////		 * Is the manufacturer approved for the given demand. Returns true if the manufacturer associated with the given supply complies
////		 * with the requirements of the demand.
////		 * 
////		 * @param supply
////		 *            Supply
////		 * @return boolean
////		 * 
////		 */
////		public boolean isManufacturerOk(Supply supply) {
////			boolean rc = true;
//	//
////			boolean trace = false;
////			if (logger.isTraceEnabled()) {
////				logger.trace("evaluating:\n demand " + this + "\nsupply: "
////						+ supply);
////			}
////			try {
////				Integer supplyOrgNbrMfr = supply.getAllSupply().getOrgNbrMfr();
////				Integer mfrId = apsDemand.getOrgNbrMfrRqst();
////				if (mfrId != null) {
////					rc = mfrId.equals(supplyOrgNbrMfr);
////				} else {
////					if (supplyOrgNbrMfr == null) {
////						if (logger.isTraceEnabled()) {
////							logger.trace("!!!no manufacturer on supply: " + rc);
////						}
////						if (apsDemand.getOeCustMast() != null) {
//	//
////							if (Customer.hasManufacturerConstraints(apsDemand
////									.getOeCustMast(), apsDemand.getItemNbrDmd())) {
////								rc = false;
////								if (logger.isTraceEnabled()) {
////									logger
////									.trace("hasManufacturerConstraints on demand but not manufacturer on supply: "
////											+ rc);
////								}
////							}
////						} else {
////							rc = true; // hack for work orders !!
////						}
////					} else {
////						if (logger.isTraceEnabled()) {
////							logger.trace("manufacturer on supply: " + rc);
////						}
//	//
////						OeCustMast ocm = apsDemand.getOeCustMast();
////						rc = Customer.isApprovedManufacturer(ocm, apsDemand
////								.getItemNbrDmd(), apsDemand.getOrgNbrMfrRqst());
////						//   rc = Customer.isApprovedManufacturer(OeCustMast oeCustMast, Integer itemId, Integer mfrId)
////						//  rc = apsDemand.getCustomer().isApprovedManufacturer(this.getItemNumberOrdered(), supply.getOrgNbrMfr());
////					}
////				}
////			} catch (java.lang.NullPointerException n) {
//	//
////				//            if (supply.getManufacturerCode() == null) {
////				//                throw new NullPointerException("Supply.getManufacturerCd() == null " + supply.toString());
////				//            }
////				throw n;
////			}
////			if (logger.isTraceEnabled()) {
////				logger.trace("isApprovedManufacturer: " + rc);
////			}
////			return rc;
////		}
//
//		public String getPrimarySourcingFacility() {
//			String step = null;
//			try {
//				step = "ApsSrcRuleSet";
//				ApsSrcRuleSet ruleSet = apsDemand.getApsSrcRuleSet();
//				step = "ApsSrcRule";
//				ApsSrcRule rule = ruleSet.getApsSrcRuleByApsSrcRuleNbrPrimary();
//				step = "UtFacility";
//				UtFacility facility = rule.getUtFacility();
//				step = "facilityCode";
//				String facilityCode = facility.getFacility();
//				return facilityCode;
//			} catch (java.lang.NullPointerException e) {
//
//				throw new java.lang.IllegalStateException(
//						"null encountered in step " + step);
//
//			}
//
//		}
//
//		/**
//		 * This returns the maximum availability date of any supply allocated to this demand. It is possible that the item is still not
//		 * fully allocated by this date.
//		 * 
//		 * @return Date
//		 */
//		java.util.Date getMaximumAllocationDate(AllocationMode mode) {
//			java.util.Date max = null;
//			java.util.Date today = planningData.getEffectiveDate();
//			java.util.Date allocationDate = null;
//			List<Allocation> allocations = getAllocations(mode);
//
//
//			for (int i = 0; i < allocations.size(); i++) {
//				Allocation allocation = allocations.get(i);
//				Supply tmpSupply = allocation.getSupply();
//				allocationDate = tmpSupply.getApsSupply().getAvailDt();
//				if (max == null || allocationDate.after(max)) {
//					max = allocationDate;
//				}
//				if (max != null && max.before(today)) {
//					max = new java.sql.Date(today.getTime());
//				}
//
//			}
//
//			return max;
//		}
//
//		/**
//		 * 
//		 * @return double
//		 */
//		public double getAllocatedQty(AllocationMode mode) {
//			double allocatedSum = 0.0;
//			List<Allocation> allocations = getAllocations(mode);
//			for (int i = 0; i < allocations.size(); i++) {
//				Allocation allocation = allocations.get(i);
//				allocatedSum += allocation.getAllocQty();
//			}
//				return allocatedSum;
//		}
//
//		public double getLateQty(AllocationMode mode) {
//			double allocatedTimely = 0.0;
//			Supply supply = null;
//			Date availDt = null;
//			Date needByDt = null;
//			Iterator<?> it = getAllocations(mode).iterator();
//			try {
//
//				while (it.hasNext()) {
//					Allocation allocation = (Allocation) it.next();
//					supply = allocation.getSupply();
//					availDt = supply.getApsSupply().getApsAvailDt();
//					needByDt = apsDemand.getRqstDt();
//					if (availDt.after(needByDt)) {
//						allocatedTimely += allocation.getAllocQty().doubleValue();
//					}
//				}
//			} catch (java.lang.NullPointerException n) {
//				if (supply == null) {
//					throw new java.lang.NullPointerException("supply is null");
//				}
//				if (availDt == null) {
//					throw new java.lang.NullPointerException("availDt is null");
//				}
//				if (needByDt == null) {
//					throw new java.lang.NullPointerException("needByDt is null");
//				}
//				throw n;
//			}
//
//			return this.getGrossOpenQty().doubleValue() - allocatedTimely;
//		}
//
//		public double getOnTimeQty(AllocationMode mode) {
//			double allocatedTimely = 0.0;
//			//		double overShipQty = 0.0;
//			//		double rc = 0.0;
//			Supply supply = null;
//			Date availDt = null;
//			//		Date needByDt = null;
//
//			for (Allocation allocation : getAllocations(mode)) {
//
//				supply = allocation.getSupply();
//				availDt = supply.getAvailDate();
//				//	needByDt = getNeedByDate();
//				//if (!availDt.after(needByDt)) { // was causing past due demands to show up as not allocated correctly
//				if (!availDt.after(planningData.getEffectiveDate())
//						&& supply.isOnhand()) {
//					allocatedTimely += allocation.getAllocQty().doubleValue();
//					//if (allocation.getAllocRqstQty() != null) {
//					//overShipQty += allocation.getAllocRqstQty();
//					//} 
//				}
//			}
//			//        if (mode.equals(AllocationMode.CUSTOMER_PRIORITIZED) || 
//			//       		mode.equals(AllocationMode.FIRST_PASS) || 
//			//        		mode.equals(AllocationMode.PICK_RESTORE)) {
//			//        	rc = this.getGrossOpenQty().doubleValue() - allocatedTimely ;
//			//        } else {
//			//        	rc = this.getGrossOpenQty().doubleValue() + overShipQty - allocatedTimely;
//			//        }
//			//logger.info("RETURNING " + (this.getGrossOpenQty().doubleValue() - allocatedTimely));
//			//return this.getGrossOpenQty().doubleValue() - allocatedTimely;
//			return allocatedTimely;
//		}
//
//		/**
//		 * @todo must differentiate between a null availDt as everything is onhand and a null because of no allocations.
//		 */
//		public Date getAvailDt(AllocationMode mode) {
//			// Date rc = null;
//			Date maxAvailDt = null;
//			double allocatedQty = 0.0;
//			Supply supply = null;
//			Date availDt = null;
//
//			for (Allocation allocation : getAllocations(mode)) {
//				if (allocation.getSupply().isOnhand()) {
//					availDt = planningData.getEffectiveDate(); // doesn't consider transit
//				} else {
//					supply = allocation.getSupply();
//					availDt = supply.getAvailDate();
//				}
//				allocatedQty += allocation.getAllocQty().doubleValue();
//				if (maxAvailDt != null) {
//					if (availDt != null && availDt.after(maxAvailDt)) {
//						maxAvailDt = availDt;
//					}
//				} else {
//					maxAvailDt = availDt;
//				}
//			}
//
//			return maxAvailDt;
//
//		}
//
//		public boolean isSafetyStock() {
//			return (apsDemand instanceof SafetyStockDemand);
//		}
//		public boolean isCustomerOrder() {
//			return (apsDemand instanceof CustomerDemand);
//		}
//
//		public boolean isWorkOrder() {
//			return (apsDemand instanceof WorkOrderDemand);
//		}
//
//		public boolean isForecast() {
//			return (apsDemand instanceof ForecastDemand);
//		}
//
//		public Set<Supply> getEligibleSupplies() {
//			return eligibleSupplies;
//		}
//
//		public final void addPreviousAllocation(Allocation allocation) {
//			previousAllocations.add(allocation);
//		}
//
//		public java.sql.Date getEndLeadTime() {
//			return endLeadTime;
//		}
//
//		public double getPreviousAllocationQty() {
//			double previousQty = 0.0;
//			for (Allocation allocation : previousAllocations) {
//				previousQty += allocation.getAllocQty();
//			}
//			return previousQty;
//		}
//
//		public Date getPreviousMaxAvailDate() {
//			Date retval = null;
//			for (Allocation allocation : previousAllocations) {
//				if (retval == null
//						|| allocation.getSupply().getAvailDate().after(retval))
//					retval = allocation.getSupply().getAvailDate();
//			}
//			return retval;
//		}
//
//		/**
//		 * @param priorityWithinCustomer
//		 *            The priorityWithinCustomer to set.
//		 */
//		// public void setPriorityWithinCustomer(String priorityWithinCustomer) {
//		// this.priorityWithinCustomer = priorityWithinCustomer;
//		// }
//		/**
//		 * @return Returns the priorityWithinCustomer.
//		 */
//		public String getPriorityWithinCustomer() {
//			String returnValue = priorityWithinCustomer;
//			if (returnValue == null) {
//				priorityWithinCustomer = CustomerDemandPrioritizerImpl
//				.getPriorityCode(this);
//			}
//			return priorityWithinCustomer;
//		}
//
//		//
//		//	/**
//		//	 * @param shipFromFacility
//		//	 *            The shipFromFacility to set.
//		//	 */
//		//	public void setShipFromFacility(String shipFromFacility) {
//		//		this.shipFromFacility = shipFromFacility;
//		//	}
//		//
//		//	/**
//		//	 * @return Returns the shipFromFacility.
//		//	 */
//		//	public String getShipFromFacility() {
//		//		return shipFromFacility;
//		//	}
//
//		// todo make a separate DegradationEvaluator
//		// todo check was the availability to the demand degraded?
//
//		public boolean isDegraded(AllocationMode previousMode,
//				AllocationMode currentMode) {
//			boolean returnValue = true;
//			if (logger.isDebugEnabled()) {
//			logger.debug("GROSS OPEN QUANTITY IS " + getGrossOpenQty() + 
//				 " ON TIME CURRENT MODE IS " + getOnTimeQty(currentMode) +
//			 " ON TIME PREVIOUS MODE IS " + getOnTimeQty(previousMode));
//			}
//			while (true) {
//				//    	 if (! withinLeadTime) {
//				//    		 returnValue = false;
//				//    		 break;
//				//    	 }
//
//				if (getOnTimeQty(currentMode) >= getGrossOpenQty().doubleValue()) {
//					returnValue = false;
//					break;
//				}
//				if (getOnTimeQty(previousMode) > getOnTimeQty(currentMode)) {
//					returnValue = true;
//					break;
//				}
//				break;
//			}
//			//    	 ArrayList<Allocation> previous = getAllocations(previousMode);
//			//    	 ArrayList<Allocation> current  = getAllocations(currentMode);
//			//    	 TreeSet<Allocation> previousAvailability = new TreeSet<Allocation>(allocComparator);
//			//    	 TreeSet<Allocation> currentAvailability = new TreeSet<Allocation>(allocComparator);
//			////    	 Date previousMinAvailDate = null;
//			////    	 Date previousMaxAvailDate = null;
//			//         if 
//			//    		 previousAvailability.addAll(previous);
//			//    		 currentAvailability.addAll(current);
//
//			//logger.info("RETURNING " + returnValue + " FROM ISDEGRADED");
//			return returnValue;
//		}
//
//		BigDecimal getGrossOpenQty() {
//			BigDecimal grossOpenQty = apsDemand.getOpenQty();
//			return grossOpenQty;
//		}
//
//		public boolean isPreserveAllocWithinLeadTime() {
//			return true;
//		}
//
//		public boolean isInPick() {
//			boolean rc = false;
//			List<Allocation> previous = getAllocations(AllocationMode.FIRST_PASS);
//			for (Allocation allocation : previous) {
//				if (allocation.getQtyInPick() > 0.0) {
//					rc = true;
//					break;
//				}
//			}
//			return rc;
//		}
//
//		//	public Object getEligibleSupplyFilters() {
//		//		// TODO Auto-generated method stub
//		//		return null;
//		//	}
//
//		//	public List<EligibilityResults> getEligibilityResults() {
//		//		// TODO Auto-generated method stub
//		//		return null;
//		//	}
//		//
//
//			private double getUnconsumedQty(AllocationMode mode) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//
//		//    /**
//		//     */
//		//    public final void setGrossOpenQty(double qty, boolean wasNull) {
//		//        setGrossOpenQty(wasNull ? null : new Double(qty));
//		//    }
//
//		public final void setCustomerEligibleSupplies(Set<Supply> eligible) {
//			this.customerEligibleSupplies = eligible;
//		}
//
//		public final Set<Supply> getCustomerEligibleSupplies() {
//			return customerEligibleSupplies;
//		}
//
//		/**
//		 * given all supplies, determine which are eligible and return the eligible set
//		 */
//		public final void setEligibleSupplies(Set<Supply> eligible) {
//			this.eligibleSupplies = eligible;
//		}
//
//		public Date getNeedByDate() {
//			return apsDemand.getRqstDt();
//		}
//
//		public ApsDemand getApsDemand() {
//			return apsDemand;
//		}
//
//		public String getFcstGrp() {
//			return apsDemand.getFcstGrp();
//		}
//
//		public ApsSrcRuleSet getApsSrcRuleSet() {
//			return apsDemand.getApsSrcRuleSet();
//		}
//
//		public String getXmlId() {
//			// TODO Auto-generated method stub
//			return xmlId;
//		}
//
//		public void setXmlId(String string) {
//			this.xmlId = string;
//			
//		}
//
//		public String getDmdTypeCd() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		public Integer getPrimaryKey() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		public Integer getItemNumberOrdered() {
//			// TODO Auto-generated method stub
//			return apsDemand.getIcItemMast().getItemNbr();
//			//..getItemNbrDmd();
//		}
//
//		public String getDmdCd() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		public String getMfrCd() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		public String getOrgCdCust() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
////		public Integer getOrgNbrCust() {
////			// TODO Auto-generated method stub
////			return apsDemand.getOeCustMast().getOrgNbrCust();
////		}
//
//		public boolean getWithinLeadTime() {
//			// TODO Auto-generated method stub
//			return false;
//		}
//
//		public Double getOpenQty() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		public String getPriorityCode() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		public String getCntryCdOrigin() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		public String getRevLvl() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		public boolean isAllocable() {
//			// TODO Auto-generated method stub
//			return false;
//		}
//
//		public Set<Supply> getIneligibleSupplies() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		public List<IcCertCd> getIcCertCds() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		public IcItemMast getIcItemMast() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		public int getApsSrcRuleSetNbr() {
//			return apsDemand.getApsSrcRuleSet().getApsSrcRuleSetNbr();
//
//		}
//
//		@Override
//		public FcstGrp getDemandFcstGrp() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		public int getDemandPriority() {
//			// TODO Auto-generated method stub
//			return 0;
//		}
//
//}
	}