package org.javautil.oracle.servicerequest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;

import javax.sql.DataSource;

import org.dom4j.Element;
import org.javautil.oracle.OracleConnectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.dbexperts.jdbc.DataSources;
//import com.dbexperts.oracle.WrappedOracleConnection;
//import com.dbexperts.text.StringHelper;

/**
 * Service Request Dispatcher.
 * 
 * Usage example adapted from @see com.javautil.machine.Machine <code>
 * 

				ServiceProvider provider = new ServiceRequestDispatcher();
				DataSource ds = dataSources.get(dataSourceName);
				if (ds == null) {
					logger.error("unknown data source  '" + dataSourceName + "' unable to create service " + classname);
					continue;
				}
				provider.setDataSource(dataSources.get(dataSourceName));
				Element arguments = (Element) serviceElement.selectSingleNode("arguments");
				if (arguments != null) {
					provider.initialize(arguments);
				}
			}
			Runnable service = (Runnable) serviceInstance;
			Thread serviceThread =new Thread(service);
			services.add(serviceThread);
			serviceThread.start();
    </code>
 * 
 * @todo implement threadpools if necessary for performance
 */
public class ServiceRequestDispatcher extends Thread implements ServiceProvider

{

	public static final String PIPENAME = "pipeName";
	/** Log. */
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	private final String shortName = getClass().getSimpleName(); // StringHelper.getClassName(this.getClass().getName());
	/** Sequential request number within this instance. */
	private int serialNumber = 1;
	private ServiceRqstS providers = null;
	private ServiceRequestPipeListener listener = null;
	private DataSource dataSource;
	private Connection conn;
	private OracleConnectionUtil dbc = null;
	private String pipeName;
	// private DataSources dataSources;
	private final Integer retryConnectionSeconds = new Integer(60);

	public ServiceRequestDispatcher() {
	}

	synchronized public void exceptionHandler(final String message, final Throwable exception) {
		logger.error("message: " + message + "\n" + "Exception: " + exception + "\nException Message: "
				+ exception.getMessage());
		// + "\ntrace: \n" + LoggerHelper.getStackTrace(exception));
	}

	/**
	 * @return the dataSources todo this should go away you should have to
	 *         request a specific data source
	 */
	// public DataSources getDataSources() {
	// return dataSources;
	// }
	public String getPipeName() {
		return pipeName;
	}

	/**
	 * Specify this instance behavior.
	 * 
	 * Provided the following XML
	 * 
	 * <pipeName>LISTEN_ON_EXAMPLE</pipeName>
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void initialize(final Element arguments) {
		final Iterator<Element> it = arguments.elementIterator();
		while (it.hasNext()) {
			final Element a = it.next();
			final String name = a.getName();
			final String value = (String) a.getData();
			setNameValue(name, value);
		}
		validateState();
		if (dataSource == null) {
			throw new IllegalStateException("dataSource is null");
		}
	}

	/**
	 * @todo add support for multiple data sources for the dispatched services.
	 */
	@Override
	public void run() {
		logger.info("Service Request Dispatcher starting");

		if (listener == null) {
			listener = new ServiceRequestPipeListener(pipeName);
		}
		// if (dataSources == null) {
		// throw new IllegalStateException("dataSources is null");
		// }
		ServiceRqstBean provider = null;
		boolean ok = true;
		if (dataSource == null) {
			ok = false;
			throw new IllegalStateException("dataSource is null");
		}

		if (dbc == null) {
			ok = false;
			throw new IllegalStateException("dataSource returned null connection");

		}
		while (ok) {
			try {

				final ServiceRequestBean request = listener.get(conn);
				logger.debug("ServiceRequestDispatcher request " + request);
				// ServiceRqstLog requestLog = new
				// ServiceRqstLog(request.getServiceName(), request.getArgs());
				provider = providers.get(conn, request.getServiceName());
				logger.debug("processing request with service " + request.getServiceName());
				if (provider != null) {
					try {
						System.nanoTime();
						logger.info("start time " + System.nanoTime());
						final Class c = Class.forName(provider.getClassname());// get
																				// class
																				// def
						final ServiceRequest obj = (ServiceRequest) c.newInstance();
						// obj.setServiceRqstLog(requestLog);
						logger.debug("setting dataSource to " + dataSource);
						obj.setDataSource(dataSource);
						// obj.setPropertyManager(propertyManager);
						obj.arguments(request.getArgs());
						obj.setSerialNumber(serialNumber++);
						obj.setServiceRequestBean(request);
						// @todo ensure acknowledgement in XML that this is a
						// DataSourcesContainer
						// @tod enumerate the DataSource list that this Service
						// can have
						// if (dataSources == null) {
						// throw new
						// IllegalStateException("dataSources is null");
						// }
						// this will break many of the existing services
						// obj.setDataSources(dataSources);
						logger.debug("Starting " + obj.getClass().getName());
						final Thread t = new Thread((Runnable) obj);
						System.nanoTime();
						t.start();
						logger.debug("Service started: " + provider.getClassname());
					} catch (final java.lang.ClassNotFoundException nf) {
						logger.error("cannot find class '" + provider.getClassname() + "'");
					} catch (final java.lang.InstantiationException ie) {
						logger.error("Can't instantiate '" + request.getServiceName() + "' '" + provider.getClassname()
								+ "'\n" + ie.getMessage());
					}
				} else {
					throw new java.lang.IllegalStateException(
							"service " + request.getServiceName() + " is not resolvable");
				}
			} catch (final java.sql.SQLException s) {
				boolean databaseUnavailable = dbc.isDatabaseUnavailableException(s);
				while (databaseUnavailable) {
					try {
						Thread.sleep(retryConnectionSeconds * 1000);
					} catch (final InterruptedException e1) {
						logger.warn("interrupted");
					}
					try {
						final Connection oconn = dataSource.getConnection();
						dbc = new OracleConnectionUtil(oconn);
					} catch (final SQLException e) {
						databaseUnavailable = dbc.isDatabaseUnavailableException(e);
						// todo create DataSourceWrapper interface with
						// getName()
						logger.warn("database not available " + e.getMessage() + " will retry in "
								+ retryConnectionSeconds + " seconds");

					}

					logger.error(s.getMessage());
				}
			} catch (final Exception e) {
				exceptionHandler("ServiceRequestDispatcher " + e.getMessage(), e);
			}
		}
	}

	@Override
	public void setDataSource(final DataSource dataSource) throws SQLException {
		this.dataSource = dataSource;

		final Connection oconn = dataSource.getConnection();
		dbc = new OracleConnectionUtil(oconn);
		dbc.setModule(this.getClass().getName());

		dbc.setAction("Instantiate ServiceRqstS");
		providers = new ServiceRqstS(oconn);
	}

	/*
	 * public void stopThread() { state = STOP; }
	 */

	// /**
	// * @param dataSources the dataSources to set
	// */
	// public void setDataSources(final DataSources dataSources) {
	// this.dataSources = dataSources;
	// }

	public void setPipeName(final String pipeName) {
		this.pipeName = pipeName;
	}

	private void setNameValue(final String name, final String value) {
		if (name == null) {
			throw new IllegalArgumentException("name is null");
		}

		if (name.equalsIgnoreCase(PIPENAME)) {
			setPipeName(value);
		} else {
			logger.warn("property unknown: '" + name + "'");
		}
	}

	private void validateState() {
		if (pipeName == null) {
			throw new IllegalStateException("pipeName is null");
		}
		logger.info("listening on pipe " + pipeName + " with dataSource ");
	}
}
