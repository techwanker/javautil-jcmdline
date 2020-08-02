/**
 * 
 */
package org.javautil.util;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;


import org.javautil.text.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.Assert;

/**
 * 
 */
public class DateHelperTest {
	private final GregorianCalendar cal       = new GregorianCalendar();
	private final DateUtils         DateUtils = new DateUtils();
	private final DateFactory       dates     = new DateFactory();
	private final Logger            logger    = LoggerFactory.getLogger(getClass());
	private final DateFactory       df        = new DateFactory();

	@SuppressWarnings("deprecation")
	@Test
	public void addDaysTest() {
		final Date dt = df.getDate(2009, 1, 1);
		final int daysToAdd = 10;
		final Date newDate = org.javautil.util.DateUtils.addDays(cal, dt, daysToAdd);
		Assert.assertEquals(dt.getDate() + 10, newDate.getDate());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void addDaysTest2() {
		final Date dt = df.getDate(2009, 1, 1);
		final int daysToAdd = 20;
		final Date newDate = org.javautil.util.DateUtils.addDays(dt, daysToAdd);
		Assert.assertEquals(dt.getDate() + 20, newDate.getDate());
		Assert.assertNotSame(new Integer(dt.getDate() + 10), new Integer(newDate.getDate()));
	}

	@Test
	public void addSecondsTest() {
		final DateFactory dates = new DateFactory();
		final Date markBd = dates.getDate(1990, 04, 28);
		final int secs = 3600;
		final Date time2 = org.javautil.util.DateUtils.addSeconds(markBd, secs);
		final long markBdms = markBd.getTime();
		final long ms2 = time2.getTime();
		final long diff = (ms2 - markBdms) / 1000;
		assertEquals(secs, diff);
	}

	/**
	 * It works, but it is crazy slow, tune later
	 */
	// @Ignore
	@Test
	public void daysBetweenTest() {
		final Date startDay = dates.getDate(1900, 1, 1);
		final int max = 1000;
		final int max2 = 10;
		logger.debug("Start Day is " + startDay);
		for (int i = 0; i < max; i++) {
			if (i % 10 == 0) {
				if (logger.isDebugEnabled()) {
					logger.debug(" pct complete " + ((double) i / (double) max) * 100);
				}
			}
			final Date d1 = org.javautil.util.DateUtils.addDays(startDay, i);
			for (int j = 0; j < max2; j++) {
				final Date d2 = org.javautil.util.DateUtils.addDays(startDay, j);
				final int daysBetween = org.javautil.util.DateUtils.daysBetween(d1, d2);
				assertEquals(j - i, daysBetween);
			}
		}
	}

	@Test
	public void daysBetweenTest2() {
		final Date startDay = dates.getDate(1900, 1, 1);
		final Date endDay = org.javautil.util.DateUtils.addDays(startDay, 100);
		final int daysBetween = org.javautil.util.DateUtils.daysBetween(endDay, startDay);
		assertEquals(-100, daysBetween);
	}

	@Test
	public void testJulian() {

		final Date markBd = dates.getDate(1990, 04, 28);
		final double d = org.javautil.util.DateUtils.julianDayNumber(markBd);
		logger.debug("mark julian " + d);
	}

	@Test
	public void asLogFileComponentTest() {
		final Date dt = df.getDate(2009, 1, 1);
		final String formattedDate = org.javautil.util.DateUtils.asLogFileComponent(dt);
		logger.debug("Formatted Date is " + formattedDate);
		Assert.assertEquals(formattedDate, "2009-01-01_12-00-00");
	}

	@Test(expected = IllegalArgumentException.class)
	public void asLogFileComponentTest2() {
		org.javautil.util.DateUtils.asLogFileComponent(null);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void getDateMidnightTest() {
		final Date dt = org.javautil.util.DateUtils.getDateMidnight();
		final String formattedDate = org.javautil.util.DateUtils.asLogFileComponent(dt);
		logger.debug("Formatted Date is " + formattedDate);
		final String dateString = dt.getYear() + 1900 + "-"
		    + StringUtils.leftPadWithChar(String.valueOf((dt.getMonth() + 1)), 2, "0") + "-"
		    + StringUtils.leftPadWithChar(String.valueOf((dt.getDate())), 2, "0") + "_12-00-00";
		Assert.assertEquals(formattedDate, dateString);

	}

	@Test
	public void getDateMidnightTest2() {
		final Date dt = df.getDate(2009, 1, 1);
		final Date dtMid = org.javautil.util.DateUtils.getDateMidnight(dt);
		final String formattedDate = org.javautil.util.DateUtils.asLogFileComponent(dtMid);
		logger.debug("Formatted Date is " + formattedDate);
		Assert.assertEquals(formattedDate, "2009-01-01_12-00-00");

	}

	@Test
	public void getFirstDateInMonthTest() {
		final Date dt = df.getDate(2009, 1, 22);
		final Date firstDateInMonth = org.javautil.util.DateUtils.getFirstDateInMonth(dt);
		final String formattedDate = org.javautil.util.DateUtils.asLogFileComponent(firstDateInMonth);
		logger.debug("Formatted Date is " + formattedDate);
		Assert.assertEquals(formattedDate, "2009-01-01_12-00-00");
	}

	@Test
	public void getFirstDateNextMonthTest() {
		final Date dt = df.getDate(2009, 1, 22);
		final Date firstDateNextMonth = org.javautil.util.DateUtils.getFirstDateNextMonth(dt);
		final String formattedDate = org.javautil.util.DateUtils.asLogFileComponent(firstDateNextMonth);
		logger.debug("Formatted Date is " + formattedDate);
		Assert.assertEquals(formattedDate, "2009-02-01_12-00-00");
	}

	@Test
	public void julianDayNumberTest() {
		final Date dt = df.getDate(2009, 1, 1);
		final double julianDayNumber = org.javautil.util.DateUtils.julianDayNumber(dt);
		logger.debug("Julian Day Number is " + julianDayNumber);
		Assert.assertEquals(3148792.5, julianDayNumber, 0);
	}

	@Test
	public void toDateTest() throws ParseException {
		final String str = "01/01/2009";
		final Date dt = org.javautil.util.DateUtils.toDate(str);
		logger.debug("Date from toDate is " + dt.toString());
		final String formattedDate = org.javautil.util.DateUtils.asLogFileComponent(dt);
		logger.debug("Formatted Date is " + formattedDate);
		Assert.assertEquals(formattedDate, "2009-01-01_12-00-00");
	}

	@Test
	public void toSqlDateTest() {
		final Date dt = df.getDate(2009, 1, 1);
		final java.sql.Date sqlDate = org.javautil.util.DateUtils.toSqlDate(dt);
		final String formattedDate = org.javautil.util.DateUtils.asLogFileComponent(sqlDate);
		logger.debug("SQL Date is " + sqlDate);
		logger.debug("Formatted Date is " + formattedDate);
		Assert.assertEquals(formattedDate, "2009-01-01_12-00-00");
	}

	@Test
	public void toSqlTimestampTest() {
		final Date dt = df.getDate(2009, 1, 1);
		final java.sql.Timestamp ts = org.javautil.util.DateUtils.toSqlTimestamp(dt);
		logger.debug("Timestamp is " + ts.toString());
		Assert.assertEquals("2009-01-01 00:00:00.0", ts.toString());
	}

	@Test
	public void getDateTest() {
		final Date dt = DateUtils.getDate();
		Assert.assertNull(dt);
	}

	@Test
	public void getMessageTest() {
		final String em = DateUtils.getMessage();
		Assert.assertNull(em);
	}

	@Test
	public void monthsBetweenTest1() {
		final Date startDay = dates.getDate(2006, 1, 1);
		final Date endDay = dates.getDate(2009, 10, 1);
		final int mb = org.javautil.util.DateUtils.monthsBetween(startDay, endDay);
		logger.debug("MB is " + mb);
	}
}
