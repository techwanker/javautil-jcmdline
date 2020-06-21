package com.pacificdataservices.diamond.planning.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.javautil.java.ThreadState;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.pacificdataservices.diamond.models.ApsPlanGrp;

@Component
@Repository
@EnableAutoConfiguration
@Transactional
@EnableTransactionManagement

public class PlanningQueueServiceImpl  extends DiamondDataServices implements Runnable, PlanningQueueService {
	//private  final Logger						logger					= Logger.getLogger(this.getClass().getName());



	public static final String					revision				= "$Revision: 1.17 $";

	private boolean								turbocharged			= false;


	private boolean								batchMode				= true;
	private ArrayList<Set<Integer>>		dispatchSets			= new ArrayList<Set<Integer>>();
	private List<Integer>					prioritizedQueue;

	/**
	 * Key is itemNbr, value is priority.
	 */
	private ConcurrentHashMap<Integer, Integer>	requestQueue			= new ConcurrentHashMap<Integer, Integer>();

	private Iterator<Set<Integer>>		setIterator;
	private int								queueSize				= 0;
	private int sleepTime = 60000;

	private ThreadState requestState;

	private String name;


	public PlanningQueueServiceImpl() {
		
	}


//	public PlanningQueue(RunMode runMode) {
//		if (runMode == RunMode.BATCH) {
//			batchMode = true;
//		}
//	}


	public void dequeue(Collection<Integer> itemNumbers) {
		for (Integer itemNumber : itemNumbers) {
			requestQueue.remove(itemNumber);
		}
		logger.debug("dequeuing " + itemNumbers + " remaining " + requestQueue.size());
	}


	// TODO have a separate deque, report items not dequeed
	/* (non-Javadoc)
	 * @see com.pacificdataservices.diamond.planning.services.PlanningQueueService#getItemNumbers()
	 */
	@Override
	public synchronized Set<Integer> getItemNumbers()  {
		logger.info("enter getItemNumbers");
		Set<Integer> returnValue = null;

		if (setIterator == null) {
			logger.info("need to populate dispatch queue");
			populateRequestQueue();
			populateDispatchQueue();
			if (setIterator == null) {
				throw new IllegalStateException("setIterator is null");
			}
		}
		if (setIterator.hasNext()) {
			returnValue = setIterator.next();
			for (Integer itemNbr : returnValue) {
				requestQueue.remove(itemNbr);
			}
			if (queueSize % 100 == 0 || queueSize < 100) {
				logger.trace("queue size " + queueSize + " " + requestQueue.size());
			}
		} else {
			if (batchMode) {
				requestState = ThreadState.TERMINATE;
			} else {
				populateRequestQueue();
			}
		}
		if (returnValue != null) {
			logger.trace("dispatching" + returnValue);
		}
		logger.info("getItemNumbers returning  " + returnValue);
		return returnValue;
	}

	
//	private int getPlanGroup(int planGroupId) {
//		
//			String queryText = "from ApsPlanGrp where planGrpNbr = :planGrpNbr" ;
//			List<ApsPlanGrp> result = getSession().createQuery(queryText).setParameter("planGrpNbr",planGroupId).list();
//			if (result.size() != 1) {
//				throw new IllegalStateException("planGroupId " + planGroupId + " size " + result.size());
//			}
//			ApsPlanGrp grp = result.get(0);
//			return grp.getPlanGrpNbr();
//		}
	

	private Set<Integer> getItemsInPlanningGroupForItemNbr(int itemNbr) {
		String queryText = "from ApsPlanGrp where planGrpNbr = (select planGrpNbr from ApsPlanGrp where itemNbr = :itemNbr)" ;
		Query q = getSession().createQuery(queryText);
		q.setParameter("itemNbr",itemNbr);
		@SuppressWarnings("unchecked")
		List<ApsPlanGrp> result = q.list();
		Set<Integer> itemNbrs = new HashSet<Integer>();
		for (ApsPlanGrp rec : result) {
			itemNbrs.add(rec.getItemNbr());
		}
		return itemNbrs;
	}

//	private Set<Integer> getItemsInPlanningGroupForItem(int itemNbr) {
//		String queryText = "from ApsPlanGrp where planGrpNbr = (select plan_grp_nbr from aps_plan_grp where item_nbr = :item_nbr" ;
//		List<ApsPlanGrp> result = getSession().createQuery(queryText).setParameter("itemNbr",itemNbr).list();
//		if (result.size() < 1) {
//			throw new IllegalStateException("planGroupId " + planGroupId + " size " + result.size());
//		}
//		Set<Integer> itemNbrs = new HashSet<Integer>();
//		for (ApsPlanGrp rec : result) {
//			itemNbrs.add(rec.getItemNbr());
//		}
//		return itemNbrs;
//	}
	
	private synchronized void populateDispatchQueue() {
		logger.info("populating dispatch queue");
		dispatchSets.clear();
		int BATCH_SIZE = 20;
		HashSet<Integer> queued = new HashSet<Integer>();
		queued.addAll(prioritizedQueue);
		// queue everything in a planGroups
		for (Integer itemNbr : prioritizedQueue) {
			Set<Integer> items = getItemsInPlanningGroupForItemNbr(itemNbr);
			if (items.size() > 0) {
				for (Integer i : items) {
					queued.remove(i);
				}
				dispatchSets.add(items);
			} else {		
				items = new HashSet<Integer>();
				items.add(itemNbr);
				dispatchSets.add(items);
				queued.remove(itemNbr);
			}
		}
		//Iterator<Integer> noGroupIt = noGroups.iterator();
		// todo restore turbo chargine
		//
//		if (turbocharged) {
//			logger.info("turbocharged with BATCH_SIZE " + BATCH_SIZE);
//			while (noGroupIt.hasNext()) {
//				ArrayList<Integer> dispatchGroup = new ArrayList<Integer>();
//				int i = 0;
//				while (noGroupIt.hasNext() && i < BATCH_SIZE) {
//					i++;
//					dispatchGroup.add(noGroupIt.next());
//					//noGroupIt.remove();
//				}
//				dispatchSets.add(dispatchGroup);
//			}
//		} else {
//			while (noGroupIt.hasNext()) {
//				ArrayList<Integer> single = new ArrayList<Integer>();
//				single.add(noGroupIt.next());
//				dispatchSets.add(single);
//				//noGroupIt.remove();
//			}
//		}
		setIterator = dispatchSets.iterator();
//		logger.trace("dispatchSets size " + dispatchSets.size());
	}

	private synchronized void populateRequestQueue() {
		logger.info("populating request queue");
		String text = "select item_nbr, min(item_prty) from aps_rqst_queue group by item_nbr order by min(item_prty)";
		Query query = getSession().createSQLQuery(text);
		prioritizedQueue = new ArrayList<Integer>();
		List<Object[]>  results = query.list();
		logger.info("items in queue " +  results.size() );


		
				 
		for (Object[] row : results) {
			for (Object obj : row) {
				Number bigI = (Number) row[0];
				Integer  intItem = new Integer(bigI.intValue());
				prioritizedQueue.add(intItem);
		 }
	
			 
	
		}
	}

	/**
	 * Test to see if we have exclusive access to the resource that controls
	 * whether or not we have the right to dispatch requests (aps_ctl).
	 * 
	 * Hold a database lock on the resource, which will preclude anybody else
	 * from obtaining the lock.
	 * 
	 * @return
	 * @exception java.sql.SQLException
	 */
	private boolean testLock() throws java.sql.SQLException {
		boolean rc = true;
		// TODO restore
//		String testExclusiveText = "	LOCK TABLE aps_ctl IN exclusive MODE NOWAIT ";
//		if (testExclusiveStatement == null) {
//			testExclusiveStatement = dbc.prepareStatement(testExclusiveText);
//		}
//		try {
//			testExclusiveStatement.executeQuery();
//			testExclusiveStatement.close();
//		} catch (java.sql.SQLException e) {
//			if (e.getMessage().indexOf("ORA-00054") != -1) {
//				rc = false;
//			} else {
//				throw e;
//			}
//		}
		return rc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.diamond10.planning.dispatcher.Dispatcher#run()
	 */
	@Override
	public void run() {
		logger.info("Aps ThreadDispatcher started " + getName());
		boolean ok = true;

		while (requestState == ThreadState.RUN) {
			logger.trace("sleeping " + sleepTime);
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		logger.info("terminating dispatcher");
	}

	private String getName() {
		return name;
	}
}
