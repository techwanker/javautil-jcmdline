//package com.pacificdataservices.diamond.performance;
//
//import static org.junit.Assert.assertEquals;
//
//import java.beans.PropertyVetoException;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.Writer;
//import java.lang.reflect.InvocationTargetException;
//import java.sql.SQLException;
//import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.javautil.core.misc.Timer;
//import org.javautil.io.IOUtils;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.pacificdataservices.diamond.planning.PlanningData;
//import com.pacificdataservices.diamond.planning.marshall.PlanningCsvMarshaller;
//import com.pacificdataservices.diamond.planning.marshall.PlanningDataJsonMarshaller;
//import com.pacificdataservices.diamond.planning.services.IcItemLocTimingJDBC;
//
//
//public class IcItemLocServiceJDBCTest {
//	public static final String planDataFile98565 = "src/test/resources/98565.json.plandata";
//	private final Logger logger = LoggerFactory.getLogger(getClass());
//	private Logger analytics = LoggerFactory.getLogger("analytics");
//
//	IcItemLocTimingJDBC pds = new IcItemLocTimingJDBC();
//	private PlanningData pd;
//	List<Integer> itemNbrs = null;
//	int count = 10;
//
//	//@Test
//	public void jdbc() throws IllegalAccessException, InvocationTargetException, PropertyVetoException, SQLException {
//
//		Timer get1 = new Timer();
//		final int itemNbr = 98565;
//		itemNbrs = new ArrayList<Integer>();
//		itemNbrs.add(itemNbr);
//
//		for (int i = 0; i < count; i++) {
//			pd = pds.getPlanningDataJDBC(itemNbrs);
//		}
//		long elapsedMicros = get1.getElapsedMicros();
//		logger.info("hibernate: {} ", elapsedMicros);
//	}
//
//	
//}