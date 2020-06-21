package com.pacificdataservices.diamond.planning;

import java.util.Collection;

public interface PlanningPersistence {

	void persist(Collection<Allocation> allocations);

}
