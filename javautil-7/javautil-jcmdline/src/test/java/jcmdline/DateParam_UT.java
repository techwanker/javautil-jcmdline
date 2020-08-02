/*
 * DateParam_UT.java
 *
 * jcmdline Rel. @VERSION@ $Id: DateParam_UT.java,v 1.2 2002/12/07 14:30:49 lglawrence Exp $
 *
 * Classes:
 *   public   DateParam_UT
 *
 * ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 1.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * The Original Code is the Java jcmdline (command line management) package.
 *
 * The Initial Developer of the Original Code is Lynne Lawrence.
 * 
 * Portions created by the Initial Developer are Copyright (C) 2002
 * the Initial Developer. All Rights Reserved.
 *
 * Contributor(s):  Lynne Lawrence <lgl@visuallink.com>
 *
 * ***** END LICENSE BLOCK *****
 */

package jcmdline;

import org.junit.Assert;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.assertArrayEquals;

/**
 * Unit test code for DateParam.
 * <P>
 * Usage:
 * <pre>
 *   java DateParam_UT [-debug <n>] [testname [,testname...]]
 *   java DateParam_UT -help
 * </pre>
 * By default, all tests are run, and debug mode is disabled.
 *
 * @author          Lynne Lawrence
 * @version         jcmdline Rel. @VERSION@ $Id: DateParam_UT.java,v 1.2 2002/12/07 14:30:49 lglawrence Exp $
 */
public class DateParam_UT extends BetterTestCase {

    private static final String tag = "startDate";
    private static final String desc = "the report's start date";
    private static Date[] acceptVals;

    /**
     * a DateFormat for converting strings code in the UT
     */
    private static final SimpleDateFormat utDateFmt = new SimpleDateFormat(
        "MM/dd/yy HH:mm:ss:SSS");

    /**
     * the same parse format as the class, in this locale
     */
    private static final SimpleDateFormat dateFmt = new SimpleDateFormat(
        DateParam.getParseFormat());

    /**
     * constructor takes name of test method
     *
     * @param name          The name of the test method to be run.
     */
    public DateParam_UT(String name) {
        super(name);
    }

    /**
     * Sets up data for the test
     */
    public void setUp() throws Exception {
        Date date1 = utDateFmt.parse("9/23/59 00:00:00:000");
        Date date2 = utDateFmt.parse("9/26/89 00:00:00:000");
        acceptVals = new Date[] { date1, date2 };
    }

    /**
     * Undoes all that was done in setUp, clean up after test
     */
    public void tearDown() {
    }

    /**
     * Test ctor accepting tag, desc
     */
    public void testCtor1() {
        DateParam dp = new DateParam(tag, desc);
        assertEquals("tag set wrong", tag, dp.getTag());
        assertEquals("desc set wrong", desc, dp.getDesc());
        assertTrue("optional flag not set true by default", dp.isOptional());
        assertFalse("multiValued flag not set false by default", dp.isMultiValued());
        assertFalse("hidden flag not set false by default", dp.isHidden());
    }

    /**
     * Test ctor accepting tag, desc, optional
     */
    public void testCtor2() {
        DateParam dp = new DateParam(tag, desc, DateParam.OPTIONAL);
        assertEquals("tag set wrong", tag, dp.getTag());
        assertEquals("desc set wrong", desc, dp.getDesc());
        assertFalse("multiValued flag not set false by default", dp.isMultiValued());
        assertFalse("hidden flag not set false by default", dp.isHidden());
        assertTrue("optional flag not set to true", dp.isOptional());

        dp = new DateParam(tag, desc, DateParam.REQUIRED);
        assertFalse("optional flag not set to false", dp.isOptional());
    }

    /**
     * Test ctor accepting tag, desc, optional, multi-valued
     */
    public void testCtor3() {
        DateParam dp = 
            new DateParam(tag, desc, DateParam.OPTIONAL, 
                              DateParam.MULTI_VALUED);
        assertEquals("tag set wrong", tag, dp.getTag());
        assertEquals("desc set wrong", desc, dp.getDesc());
        assertTrue("optional flag not set to true", dp.isOptional());
        assertTrue("multiValued flag not set true", dp.isMultiValued());
        assertFalse("hidden flag not set false by default", dp.isHidden());

        dp = new DateParam(tag, desc, DateParam.REQUIRED,
                               DateParam.SINGLE_VALUED);
        assertFalse("optional flag not set to false", dp.isOptional());
        assertFalse("multiValued flag not set false", dp.isMultiValued());
    }

    /**
     * Test ctor accepting tag, desc, optional, multi-valued, hidden
     */
    public void testCtor4() {
        DateParam dp = 
            new DateParam(tag, desc, DateParam.OPTIONAL, 
                              DateParam.MULTI_VALUED,
                              DateParam.HIDDEN);
        assertEquals("tag set wrong", tag, dp.getTag());
        assertEquals("desc set wrong", desc, dp.getDesc());
        assertTrue("optional flag not set to true", dp.isOptional());
        assertTrue("multiValued flag not set true", dp.isMultiValued());
        assertTrue("hidden flag not set true", dp.isHidden());

        dp = new DateParam(tag, desc, DateParam.REQUIRED,
                               DateParam.SINGLE_VALUED,
                               DateParam.PUBLIC);
        assertFalse("optional flag not set to false", dp.isOptional());
        assertFalse("multiValued flag not set false", dp.isMultiValued());
        assertFalse("hidden flag not set false", dp.isHidden());
    }

    /**
     * Test ctor accepting tag, desc, acceptableValues
     */
    public void testCtor5() {
        DateParam dp = new DateParam(tag, desc, acceptVals);
        assertEquals("tag set wrong", tag, dp.getTag());
        assertEquals("desc set wrong", desc, dp.getDesc());
        assertArrayEquals("acceptableValues set wrong", acceptVals, dp.getAcceptableDates());
        assertTrue("optional flag not set true by default", dp.isOptional());
        assertFalse("multiValued flag not set false by default", dp.isMultiValued());
        assertFalse("hidden flag not set false by default", dp.isHidden());
    }

    /**
     * Test ctor accepting tag, desc, acceptableValues, optional
     */
    public void testCtor6() {
        DateParam dp = 
            new DateParam(tag, desc, acceptVals, DateParam.OPTIONAL);
        assertEquals("tag set wrong", tag, dp.getTag());
        assertEquals("desc set wrong", desc, dp.getDesc());
        assertTrue("optional flag not set to true", dp.isOptional());
        assertArrayEquals("acceptableValues set wrong", acceptVals, dp.getAcceptableDates());
        assertFalse("multiValued flag not set false by default", dp.isMultiValued());
        assertFalse("hidden flag not set false by default", dp.isHidden());

        dp = new DateParam(tag, desc, acceptVals, DateParam.REQUIRED);
        assertFalse("optional flag not set to false", dp.isOptional());
    }

    /**
     * Test ctor accepting tag, desc, acceptableValues, optional, 
     * multiValued
     */
    public void testCtor7() {
        DateParam dp = new DateParam(tag, desc, acceptVals, 
                                         DateParam.OPTIONAL, 
                                         DateParam.MULTI_VALUED);
        assertEquals("tag set wrong", tag, dp.getTag());
        assertEquals("desc set wrong", desc, dp.getDesc());
        assertTrue("optional flag not set to true", dp.isOptional());
        assertTrue("multiValued flag not set to true", dp.isMultiValued());
        assertArrayEquals("acceptableValues set wrong", acceptVals, dp.getAcceptableDates());
        assertFalse("hidden flag not set false by default", dp.isHidden());

        dp = new DateParam(tag, desc, acceptVals, 
                             DateParam.REQUIRED, 
                             DateParam.SINGLE_VALUED);
        assertFalse("optional flag not set to false", dp.isOptional());
        assertFalse("multiValued flag not set to false", dp.isMultiValued());
    }

    /**
     * Test ctor accepting tag, desc, acceptableValues, optional,
     * multiValued, hidden
     */
    public void testCtor8() {
        DateParam dp = 
            new DateParam(tag, desc, acceptVals, 
                            DateParam.OPTIONAL, 
                            DateParam.MULTI_VALUED, 
                            DateParam.HIDDEN);
        assertEquals("tag set wrong", tag, dp.getTag());
        assertEquals("desc set wrong", desc, dp.getDesc());
        assertTrue("optional flag not set to true", dp.isOptional());
        assertTrue("multiValued flag not set to true", dp.isMultiValued());
        assertTrue("hidden flag not set to true", dp.isHidden());
        assertArrayEquals("acceptableValues set wrong", acceptVals, dp.getAcceptableDates());

        dp = new DateParam(tag, desc, acceptVals, 
                             DateParam.REQUIRED, 
                             DateParam.SINGLE_VALUED, 
                             DateParam.PUBLIC);
        assertFalse("optional flag not set to false", dp.isOptional());
        assertFalse("multiValued flag not set to false", dp.isMultiValued());
        assertFalse("hidden flag not set to false", dp.isHidden());
    }

    /**
     * Test constructor and get/set Values
     */
    public void testNormal() throws Exception {
        DateParam p = new DateParam(tag, desc);
        Date date = utDateFmt.parse("9/23/59 00:00:00:000");
        String sParamDate = dateFmt.format(date);
        debug("testNormal: testing with " + sParamDate);
        p.setValue(sParamDate);
        assertEquals("getValue() returned wrong value",
                     sParamDate, p.getValue());
        assertEquals("getDate() returned wrong value",
                     date, p.getDate());
    }

    /**
     * Test set/getDefaultTime()
     */
    public void testDefaultTime() throws Exception {
        DateParam p = new DateParam(tag, desc);
        p.setDefaultTime(23, 59, 58, 999);
        int[] a = p.getDefaultTime();
        assertEquals("getDefaultTime() returned wrong hours",
                     23, a[0]);
        assertEquals("getDefaultTime() returned wrong minutes",
                     59, a[1]);
        assertEquals("getDefaultTime() returned wrong seconds",
                     58, a[2]);
        assertEquals("getDefaultTime() returned wrong milliseconds",
                     999, a[3]);

        Date date = utDateFmt.parse("9/23/59 23:59:58:999");
        String sParamDate = dateFmt.format(date); // should pick up just date
                                                  // portion
        debug("testDefaultTime: testing with " + sParamDate);

        p.setValue(sParamDate);
        assertEquals("getValue() returned wrong value",
                     sParamDate, p.getValue());
        assertEquals("getDate() returned wrong value",
                     date, p.getDate());
    }

    /**
     * Test bad default hours passed to setDefaultTime()
     */
    public void testBadDefaultHours() {
        DateParam p = new DateParam(tag, desc);
        boolean gotException = false;
        try {
            p.setDefaultTime(24, 59, 59, 999);
        } catch (IllegalArgumentException e) {
            checkForMissingString(e.getMessage());
            gotException = true;
        }
        assertTrue("setDefaultTime() did not fail with hour set to 24",
                   gotException);
        gotException = false;
        try {
            p.setDefaultTime(-1, 59, 59, 999);
        } catch (IllegalArgumentException e) {
            checkForMissingString(e.getMessage());
            gotException = true;
        }
        assertTrue("setDefaultTime() did not fail with hour set to -1",
                   gotException);
    }

    /**
     * Test bad default minutes passed to setDefaultTime()
     */
    public void testBadDefaultMinutes() {
        DateParam p = new DateParam(tag, desc);
        boolean gotException = false;
        try {
            p.setDefaultTime(23, 60, 59, 999);
        } catch (IllegalArgumentException e) {
            checkForMissingString(e.getMessage());
            gotException = true;
        }
        assertTrue("setDefaultTime() did not fail with minute set to 60",
                   gotException);
        gotException = false;
        try {
            p.setDefaultTime(23, -1, 59, 999);
        } catch (IllegalArgumentException e) {
            checkForMissingString(e.getMessage());
            gotException = true;
        }
        assertTrue("setDefaultTime() did not fail with minute set to -1",
                   gotException);
    }

    /**
     * Test bad default seconds passed to setDefaultTime()
     */
    public void testBadDefaultSeconds() {
        DateParam p = new DateParam(tag, desc);
        boolean gotException = false;
        try {
            p.setDefaultTime(23, 59, 60, 999);
        } catch (IllegalArgumentException e) {
            checkForMissingString(e.getMessage());
            gotException = true;
        }
        assertTrue("setDefaultTime() did not fail with second set to 60",
                   gotException);
        gotException = false;
        try {
            p.setDefaultTime(23, 59, -1, 999);
        } catch (IllegalArgumentException e) {
            checkForMissingString(e.getMessage());
            gotException = true;
        }
        assertTrue("setDefaultTime() did not fail with second set to -1",
                   gotException);
    }

    /**
     * Test bad default milliseconds passed to setDefaultTime()
     */
    public void testBadDefaultMilliSeconds() {
        DateParam p = new DateParam(tag, desc);
        boolean gotException = false;
        try {
            p.setDefaultTime(23, 59, 59, 1000);
        } catch (IllegalArgumentException e) {
            checkForMissingString(e.getMessage());
            gotException = true;
        }
        assertTrue("setDefaultTime() did not fail with millisecond set to 1000",
                   gotException);
        gotException = false;
        try {
            p.setDefaultTime(23, 59, 59, -1);
        } catch (IllegalArgumentException e) {
            checkForMissingString(e.getMessage());
            gotException = true;
        }
        assertTrue("setDefaultTime() did not fail with millisecond set to -1",
                   gotException);
    }

    /**
     * Tests set/getAcceptableValues()
     */
    public void testAcceptableValues() throws Exception {
        DateParam p = new DateParam(tag, desc);
        Date date1 = utDateFmt.parse("9/23/59 00:00:00:000");
        Date date2 = utDateFmt.parse("9/26/89 00:00:00:000");
        p.setAcceptableDates(new Date[] { date1, date2 });

        String sParamDate = dateFmt.format(date1);
        debug("set/getAcceptableValues: testing with good date " + sParamDate);
        p.setValue(sParamDate); // should not be a problem
        assertEquals("getValue() returned wrong value",
                     sParamDate, p.getValue());
        assertEquals("getDate() returned wrong value",
                     date1, p.getDate());

        Date badDate = utDateFmt.parse("9/11/01 00:00:00:000");
        sParamDate = dateFmt.format(badDate);
        debug("set/getAcceptableValues: testing with bad date " + sParamDate);
        boolean gotException = false;
        try {
            p.setValue(sParamDate);
        } catch (CmdLineException e) {
            checkForMissingString(e.getMessage());
            gotException = true;
        }
        assertTrue("setValue() did not fail with non-acceptable date",
                   gotException);
    }

    /**
     * Tests setAcceptableValues(String[]) - should throw 
     * UnsupportedOperationException
     */
    public void testSetAcceptableValuesStr() {
        DateParam dp = new DateParam(tag, desc);
        try {
            dp.setAcceptableValues(new String[] { "value1", "value2" });
        } catch (UnsupportedOperationException e) {
            return;
        }
        fail("setAcceptableValues(String[]) did not throw " +
             "UnsupportedOperationException");
    }

    /**
     * Tests setAcceptableValues(Collection) - should throw 
     * UnsupportedOperationException
     */
    public void testSetAcceptableValuesColl() {
        DateParam dp = new DateParam(tag, desc);
        try {
            dp.setAcceptableValues(new ArrayList());
        } catch (UnsupportedOperationException e) {
            return;
        }
        fail("setAcceptableValues(Collection) did not throw " +
             "UnsupportedOperationException");
    }

    /**
     * Runs all tests using junit.textui.TestRunner
     */
    public static void main (String[] args) {
        doMain(args, DateParam_UT.class);
    }
}
