package com.pacificdataservices.diamond.planning;

import com.pacificdataservices.diamond.models.ApsSrcRule;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.supply.Supply;
import com.pacificdataservices.diamond.planning.supply.priority.EligibleSupplyRanker;

/**
	 * Container for supplies which are eligible for sourcing a given demand.<br>
	 *
	 * Also wraps allocations.
	 *
	 * @author Jim Schmidt
	 */
	public class EligibleSupply {
		private transient EligibleSupplyRanker ranker = new EligibleSupplyRanker();
	    private String priority;
	    private Supply supply;
	    private transient Demand demand = null;
	    private ApsSrcRule apsSrcRule = null;
	    
	    public EligibleSupply(Supply supply, Demand demand, ApsSrcRule sourcingRule)
		  {
		        if (supply == null) {
		            throw new java.lang.IllegalArgumentException("supply may not be null");
		        }
		        if (demand == null) {
		            throw new java.lang.IllegalArgumentException("demand may not be null");
		        }
		        if (sourcingRule == null) {
		        	throw new IllegalArgumentException("sourcingRule is null");
		        }
		        this.supply = supply;
		        this.demand = demand;
		        this.apsSrcRule = sourcingRule;
		        String priority = ranker.generatePriority(this);
		        setPriority(priority);
		  }
	    
		public ApsSrcRule getApsSrcRule() {
			return apsSrcRule;
		}

		public Supply getSupply() {
	        return (supply);
	    }

	    public Demand getDemand() {
	        return demand;
	    }



//	    public void setSubstType(String val) {
//	        this.substType = val;
//	    }
//
//	    public String getSubst() {
//	        return this.substType;
//	    }

		 @Override
		public String toString()
		 {
			 StringBuffer buff = new StringBuffer();
			 buff.append("EligibleSupply \n");
			 buff.append(supply.toString());
			 buff.append("\n");
			 buff.append(demand.toString());
			 return new String(buff);

		 }


		public int getSupplyPriority() {
		
			return apsSrcRule.getSrcPrty();
		}

		public String getPriority() {
			return priority;
		}

		public void setPriority(String priority) {
			this.priority = priority;
		}

	}


