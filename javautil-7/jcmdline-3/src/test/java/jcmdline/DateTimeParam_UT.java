/*
 * dATEtImeParam_UT.java
 *
 * jcmdline Rel. @VERSION@ $Id: DateTimeParam_UT.java,v 1.2 2002/12/07 14:30:49 lglawrence Exp $
 *
 * Classes:
 *   public   DateTimeParam_UT
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Unit test code for DateTimeParam.
 * <P>
 * Usage:
 * <pre>
 *   java DateTimeParam_UT [-debug <n>] [testname [,testname...]]
 *   java DateTimeParam_UT -help
 * </pre>
 * By default, all tests are run, and debug mode is disabled.
 *
 * @author          Lynne Lawrence
 * @version         jcmdline Rel. @VERSION@ $Id: DateTimeParam_UT.java,v 1.2 2002/12/07 14:30:49 lglawrence Exp $
 */
public class DateTimeParam_UT extends BetterTestCase {

    private static String sDateFormat = DateTimeParam.getParseFormat();
    private static SimpleDateFormat dateFormat = 
        new SimpleDateFormat(sDateFormat);
    private static final String tag = "startDate";
    private static final String desc = 
        "the date on which the report is to start";
    private static Date[] acceptVals;

    /**
     * constructor takes name of test method
     *
     * @param name          The name of the test method to be run.
     */
    public DateTimeParam_UT(String name) {
        super(name);
    }

    /**
     * Sets up data for the test
     */
    public void setUp() {
        Date date1 = new Date();
        Date date2 = new Date(date1.getTime() + 50l);
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
        DateTimeParam dp = new DateTimeParam(tag, desc);
        assertEquals("tag set wrong", tag, dp.getTag());
        assertEquals("desc set wrong", desc, dp.getDesc());
        assertTrue("optional flag not set true by default", dp.isOptional());
        assertTrue("multiValued flag not set false by default", 
            !dp.isMultiValued());
        assertTrue("hidden flag not set false by default", !dp.isHidden());
    }

    /**
     * Test ctor accepting tag, desc, optional
     */
    public void testCtor2() {
        DateTimeParam dp = new DateTimeParam(tag, desc, DateTimeParam.OPTIONAL);
        assertEquals("tag set wrong", tag, dp.getTag());
        assertEquals("desc set wrong", desc, dp.getDesc());
        assertTrue("multiValued flag not set false by default", 
            !dp.isMultiValued());
        assertTrue("hidden flag not set false by default", 
            !dp.isHidden());
        assertTrue("optional flag not set to true", dp.isOptional());

        dp = new DateTimeParam(tag, desc, DateTimeParam.REQUIRED);
        assertTrue("optional flag not set to false", !dp.isOptional());
    }

    /**
     * Test ctor accepting tag, desc, optional, multi-valued
     */
    public void testCtor3() {
        DateTimeParam dp = 
            new DateTimeParam(tag, desc, DateTimeParam.OPTIONAL, 
                              DateTimeParam.MULTI_VALUED);
        assertEquals("tag set wrong", tag, dp.getTag());
        assertEquals("desc set wrong", desc, dp.getDesc());
        assertTrue("optional flag not set to true", dp.isOptional());
        assertTrue("multiValued flag not set true", dp.isMultiValued());
        assertTrue("hidden flag not set false by default", 
            !dp.isHidden());

        dp = new DateTimeParam(tag, desc, DateTimeParam.REQUIRED,
                               DateTimeParam.SINGLE_VALUED);
        assertTrue("optional flag not set to false", !dp.isOptional());
        assertTrue("multiValued flag not set false", !dp.isMultiValued());
    }

    /**
     * Test ctor accepting tag, desc, optional, multi-valued, hidden
     */
    public void testCtor4() {
        DateTimeParam dp = 
            new DateTimeParam(tag, desc, DateTimeParam.OPTIONAL, 
                              DateTimeParam.MULTI_VALUED,
                              DateTimeParam.HIDDEN);
        assertEquals("tag set wrong", tag, dp.getTag());
        assertEquals("desc set wrong", desc, dp.getDesc());
        assertTrue("optional flag not set to true", dp.isOptional());
        assertTrue("multiValued flag not set true", dp.isMultiValued());
        assertTrue("hidden flag not set true", dp.isHidden());

        dp = new DateTimeParam(tag, desc, DateTimeParam.REQUIRED,
                               DateTimeParam.SINGLE_VALUED,
                               DateTimeParam.PUBLIC);
        assertTrue("optional flag not set to false", !dp.isOptional());
        assertTrue("multiValued flag not set false", !dp.isMultiValued());
        assertTrue("hidden flag not set false", !dp.isHidden());
    }

    /**
     * Test ctor accepting tag, desc, acceptableValues
     */
    public void testCtor5() {
        DateTimeParam dp = new DateTimeParam(tag, desc, acceptVals);
        assertEquals("tag set wrong", tag, dp.getTag());
        assertEquals("desc set wrong", desc, dp.getDesc());
        assertTrue("acceptableValues set wrong",
                   Arrays.equals(acceptVals, dp.getAcceptableDates()));
        assertTrue("optional flag not set true by default", dp.isOptional());
        assertTrue("multiValued flag not set false by default", 
            !dp.isMultiValued());
        assertTrue("hidden flag not set false by default", !dp.isHidden());
    }

    /**
     * Test ctor accepting tag, desc, acceptableValues, optional
     */
    public void testCtor6() {
        DateTimeParam dp = 
            new DateTimeParam(tag, desc, acceptVals, DateTimeParam.OPTIONAL);
        assertEquals("tag set wrong", tag, dp.getTag());
        assertEquals("desc set wrong", desc, dp.getDesc());
        assertTrue("optional flag not set to true", dp.isOptional());
        assertTrue("acceptableValues set wrong",
                   Arrays.equals(acceptVals, dp.getAcceptableDates()));
        assertTrue("multiValued flag not set false by default", 
            !dp.isMultiValued());
        assertTrue("hidden flag not set false by default", !dp.isHidden());

        dp = new DateTimeParam(tag, desc, acceptVals, DateTimeParam.REQUIRED);
        assertTrue("optional flag not set to false", !dp.isOptional());
    }

    /**
     * Test ctor accepting tag, desc, acceptableValues, optional, 
     * multiValued
     */
    public void testCtor7() {
        DateTimeParam dp = new DateTimeParam(tag, desc, acceptVals, 
                                         DateTimeParam.OPTIONAL, 
                                         DateTimeParam.MULTI_VALUED);
        assertEquals("tag set wrong", tag, dp.getTag());
        assertEquals("desc set wrong", desc, dp.getDesc());
        assertTrue("optional flag not set to true", dp.isOptional());
        assertTrue("multiValued flag not set to true", dp.isMultiValued());
        assertTrue("acceptableValues set wrong",
                   Arrays.equals(acceptVals, dp.getAcceptableDates()));
        assertTrue("hidden flag not set false by default", !dp.isHidden());

        dp = new DateTimeParam(tag, desc, acceptVals, 
                             DateTimeParam.REQUIRED, 
                             DateTimeParam.SINGLE_VALUED);
        assertTrue("optional flag not set to false", !dp.isOptional());
        assertTrue("multiValued flag not set to false", !dp.isMultiValued());
    }

    /**
     * Test ctor accepting tag, desc, acceptableValues, optional,
     * multiValued, hidden
     */
    public void testCtor8() {
        DateTimeParam dp = 
            new DateTimeParam(tag, desc, acceptVals, 
                            DateTimeParam.OPTIONAL, 
                            DateTimeParam.MULTI_VALUED, 
                            DateTimeParam.HIDDEN);
        assertEquals("tag set wrong", tag, dp.getTag());
        assertEquals("desc set wrong", desc, dp.getDesc());
        assertTrue("optional flag not set to true", dp.isOptional());
        assertTrue("multiValued flag not set to true", dp.isMultiValued());
        assertTrue("hidden flag not set to true", dp.isHidden());
        assertTrue("acceptableValues set wrong",
                   Arrays.equals(acceptVals, dp.getAcceptableDates()));

        dp = new DateTimeParam(tag, desc, acceptVals, 
                             DateTimeParam.REQUIRED, 
                             DateTimeParam.SINGLE_VALUED, 
                             DateTimeParam.PUBLIC);
        assertTrue("optional flag not set to false", !dp.isOptional());
        assertTrue("multiValued flag not set to false", !dp.isMultiValued());
        assertTrue("hidden flag not set to false", !dp.isHidden());
    }

    /**
     * Tests setAcceptableValues(String[]) - should throw 
     * UnsupportedOperationException
     */
    public void testSetAcceptableValuesStr() {
        DateTimeParam dp = new DateTimeParam(tag, desc);
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
        DateTimeParam dp = new DateTimeParam(tag, desc);
        try {
            dp.setAcceptableValues(new ArrayList());
        } catch (UnsupportedOperationException e) {
            return;
        }
        fail("setAcceptableValues(Collection) did not throw " +
             "UnsupportedOperationException");
    }

    /**
     * Tests ctor and default seconds and millis
     */
    public void testGoodDate() throws Exception {
        DateTimeParam p = new DateTimeParam(tag, desc);
        Date currDate = new Date();
        String sDate = dateFormat.format(currDate);
        p.setValue(sDate);
        assertEquals("getDate() does not return correct date",
                     currDate, p.getDate());
        sDate = sDate.substring(0, sDate.length() - 7);
        p.setValue(sDate);
        assertEquals("getDate() does not return correct date with secs and " +
                     "millis not specified",
                     dateFormat.parse(sDate + ":00:000"), p.getDate());
        sDate = sDate + ":34";
        p.setValue(sDate);
        assertEquals("getDate() does not return correct date with secs " +
                     "not specified",
                     dateFormat.parse(sDate + ":000"), p.getDate());
    }

    /**
     * Tests set/getDefaultSeconds()
     */
    public void testSetDefaultSeconds() throws Exception {
        DateTimeParam p = new DateTimeParam(tag, desc);
        Date currDate = new Date();
        String sDate = dateFormat.format(currDate);
        p.setDefaultSeconds(30);
        assertEquals("getDefaultSeconds() returned wrong value",
                     30, p.getDefaultSeconds());

        sDate = sDate.substring(0, sDate.length() - 7);
        p.setValue(sDate);
        assertEquals("getDate() does not return correct date with secs and " +
                     "millis not specified",
                     dateFormat.parse(sDate + ":30:000"), p.getDate());
    }

    /**
     * Tests set/getDefaultMilliSeconds()
     */
    public void testSetDefaultMilliSeconds() throws Exception {
        DateTimeParam p = new DateTimeParam(tag, desc);
        Date currDate = new Date();
        String sDate = dateFormat.format(currDate);
        p.setDefaultMilliSeconds(30);
        assertEquals("getDefaultMilliSeconds() returned wrong value",
                     30, p.getDefaultMilliSeconds());

        sDate = sDate.substring(0, sDate.length() - 4);
        p.setValue(sDate);
        assertEquals("getDate() does not return correct date with secs and " +
                     "millis not specified",
                     dateFormat.parse(sDate + ":030"), p.getDate());
    }

    /**
     * Tests set/getAcceptableDates()
     */
    public void testAcceptableValues() throws Exception {

        Date date1 = new Date();
        Date date2 = new Date(date1.getTime() + 50l);
        Date date3 = new Date(date2.getTime() + 50l);

        DateTimeParam p = new DateTimeParam(tag, desc);
        Date[] dateArray = new Date[] { date1, date2 };
        p.setAcceptableDates(dateArray);
        assertTrue("getAcceptableDates() returned wrong values",
                   Arrays.equals(dateArray, p.getAcceptableDates()));

        String[] accValues = new String[] { dateFormat.format(date1),
                                            dateFormat.format(date2) };
        assertTrue("getAcceptableValues returned wrong values",
                   Arrays.equals(accValues, p.getAcceptableValues()));

        p.setValue(dateFormat.format(date2));  // should work ok

        boolean gotException = false;
        try {
            p.setValue(dateFormat.format(date3));
        } catch (CmdLineException e) {
            gotException = true;
        }
        assertTrue("Did not get exception when setting non-acceptable value",
                   gotException);
    }

    /**
     * Runs all tests using junit.textui.TestRunner
     */
    public static void main (String[] args) {
        doMain(args, DateTimeParam_UT.class);
    }
}
