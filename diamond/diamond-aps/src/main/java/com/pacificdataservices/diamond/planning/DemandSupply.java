package com.pacificdataservices.diamond.planning;

import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.supply.Supply;

public class DemandSupply {
	
	private Demand demand;
	private Supply supply;
	
	public DemandSupply(Demand demand, Supply supply) {
		super();
		if (demand == null) {
			throw new IllegalArgumentException("demand is null");
		}
		if (supply == null) {
			throw new IllegalArgumentException("supply is null");
		}
		this.demand = demand;
		this.supply = supply;
	}

	public Demand getDemand() {
		return demand;
	}

	public Supply getSupply() {
		return supply;
	}

	

}
