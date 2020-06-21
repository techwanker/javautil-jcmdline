package com.pacificdataservices.diamond.planning;

import java.sql.SQLException;
import java.util.ArrayList;

import org.javautil.core.properties.PropertyManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.pacificdataservices.diamond.planning.services.PlanGroupPopulatorService;
import com.pacificdataservices.diamond.planning.services.PlanningEngineImpl;
import com.pacificdataservices.diamond.planning.services.PlanningQueueServiceImpl;
import com.pacificdataservices.diamond.planning.services.PrepareRunService;
import com.pacificdataservices.diamond.planning.services.RequestPopulateService;

/**
 * runs Allocation Engine<br>
 * * Arguments<br>
 *
 * Properties
 * <ul>
 * <li>username Oracle user Name</li>
 * <li>password Oracle password</li>
 * <li>hostname DNS hostname or IP with Oracle Instance</li>
 * <li>instance ORACLE SID</li>
 * <li>com.diamond9.planning.AllocationMachine.traceDirectory<br>
 * default "target/tmp"</li>
 * <li>sync number of synchronous threads</li>
 * <li>async number of synchronous threads</li>
 * <li>put putter true or false</li>
 * </ul>
 */
public class PlanningMachine implements Runnable {
	private Logger logger = LoggerFactory.getLogger(PlanningMachine.class.getName());

	private boolean initialized = false;

	private ArrayList<PlanningEngineImpl> consumers = new ArrayList<PlanningEngineImpl>();


	private RunMode runMode = null;

	@Autowired
	private PlanGroupPopulatorService planGroupPopulatorService;

	@Autowired
	private PrepareRunService prepareRunService;

	@Autowired
	private RequestPopulateService requestPopulateService;

	@Autowired
	private PlanningQueueServiceImpl threadDispatcher;

	private Integer synchronousThreads = null;

	private Integer asynchronousThreads = null;

	private RunType runType;

	private boolean batchMode = true;
	private boolean requestAll = true;

	private PropertyManager propertyManager;

	private boolean runPlanningQueue;



	public PlanningMachine() {

	}

	public PlanningMachine(PropertyManager propertyManager) {

		setProperties(propertyManager);

	}

	private void setProperties(PropertyManager properties) {
		this.propertyManager = properties;
	}

	private void loadProperties() {
		String className = getClass().getName();
		requestAll = propertyManager.getBooleanProperty(className + ".requestAll", true);
		synchronousThreads = new Integer(propertyManager.getMandatoryProperty(className + ".synchronousThreads"));
		asynchronousThreads = new Integer(propertyManager.getMandatoryProperty(className + ".asynchronousThreads"));

		runPlanningQueue = propertyManager.getBooleanProperty(className + ".requestDispatcher", true);
	}

	/**
	 * gets arguments and database connection information. !! describe contents of
	 * properties file !! putter !! number of synchronous and number of asynchronous
	 * threads starts correct number of !! should later dynamically shutdown threads
	 * and release connections
	 */

	public void run() {
		if (runMode == RunMode.BATCH) {
			prepareRunService.prepareRun(true);
		}
		if (requestAll) {
			requestPopulateService.process();
		}
		planGroupPopulatorService.process();
		if (runPlanningQueue) {
			Thread td = new Thread(threadDispatcher);
			td.setDaemon(true);
			td.setName("aps dispatcher");
			td.start();
		}
		startEngines(true, asynchronousThreads);
		startEngines(false, synchronousThreads);

		logger.info("exiting machine");
	}

	private void startEngines(boolean async, int count) {
		String enginePrefix = "APS" + (async ? "A" : "") + "synch #";
		if (async)
			for (int i = 1; i <= count; i++) {
				try {
					String engineName = enginePrefix + i;
					PlanningEngineImpl engine = new PlanningEngineImpl(propertyManager, async, engineName, threadDispatcher, runMode);
					Thread t = new Thread(engine);
					t.setName(engineName);
					t.start();
					consumers.add(engine);
				} catch (Exception e) {
					logger.error(e.getMessage(),e);
					throw new java.lang.IllegalStateException(
							"PlanningMachine problem creating  consumer" + e.getMessage());
				}
			}
	}



	
	private void setPropertiesFromDatabase() throws SQLException {
		// OracleConnection conn = (OracleConnection) dataSource.getConnection();
		// AppCtlS appCtlS = new AppCtlS();
		// appCtlS.refresh(conn);
		// conn.close();
		// logger.info(appCtlS.toString());
		// String[][] pairs = appCtlS.getPairs();
		//
		// propertyManager = new PropertyManager(pairs);
		// for (String nameValue : propertyManager.getNameValues()) {
		// logger.info(nameValue);
		// }
	}

}
