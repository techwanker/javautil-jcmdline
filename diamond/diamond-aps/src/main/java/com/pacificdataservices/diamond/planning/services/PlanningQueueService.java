package com.pacificdataservices.diamond.planning.services;

import java.util.Set;

public interface PlanningQueueService {

	// TODO have a separate deque, report items not dequeed
	Set<Integer> getItemNumbers();

}