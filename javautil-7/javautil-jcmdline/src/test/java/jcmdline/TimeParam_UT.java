/*
 * TimeParam_UT.java
 *
 * jcmdline Rel. @VERSION@ $Id: TimeParam_UT.java,v 1.2 2002/12/07 14:30:49 lglawrence Exp $
 *
 * Classes:
 *   public   TimeParam_UT
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
import java.util.Arrays;
import java.util.Date;
import static org.junit.Assert.assertArrayEquals;

/**
 * Unit test code for TimeParam.
 * <P>
 * Usage:
 * <pre>
 *   java TimeParam_UT [-log &lt;level&gt;] [testname [,testname...]]
 *   java TimeParam_UT -help
 * </pre>
 *
 * @author          Lynne Lawrence
 * @version         jcmdline Rel. @VERSION@ $Id: TimeParam_UT.java,v 1.2 2002/12/07 14:30:49 lglawrence Exp $
 */
public class TimeParam_UT extends BetterTestCase {

    private static final long MILLIS_PER_SECOND = 1000;
    private static final long MILLIS_PER_MINUTE = MILLIS_PER_SECOND * 60;
    private static final long MILLIS_PER_HOUR = MILLIS_PER_MINUTE * 60;
    private static final String tag = "startTime";
    private static final String desc = "the report's start time";
    private static final String[] acceptVals = 
        new String[] { "23:59", "00:00" };

    /**
     * constructor takes name of test method
     *
     * @param name          The name of the test method to be run.
     */
    public TimeParam_UT(String name) {
        super(name);
    }

    /**
     * Sets up data for the test
     */
    public void setUp() {
    }

    /**
     * Test ctor accepting tag, desc
     */
    public void testCtor1() {
        TimeParam tp = new TimeParam(tag, desc);
        assertEquals("tag set wrong", tag, tp.getTag());
        assertEquals("desc set wrong", desc, tp.getDesc());
        assertTrue("optional flag not set true by default", tp.isOptional());
        assertFalse("multiValued flag not set false by default", tp.isMultiValued());
        assertFalse("hidden flag not set false by default", tp.isHidden());
    }

    /**
     * Test ctor accepting tag, desc, optional
     */
    public void testCtor2() {
        TimeParam tp = new TimeParam(tag, desc, TimeParam.OPTIONAL);
        assertEquals("tag set wrong", tag, tp.getTag());
        assertEquals("desc set wrong", desc, tp.getDesc());
        assertFalse("multiValued flag not set false by default", tp.isMultiValued());
        assertFalse("hidden flag not set false by default", tp.isHidden());
        assertTrue("optional flag not set to true", tp.isOptional());

        tp = new TimeParam(tag, desc, TimeParam.REQUIRED);
        assertFalse("optional flag not set to false", tp.isOptional());
    }

    /**
     * Test ctor accepting tag, desc, optional, multi-valued
     */
    public void testCtor3() {
        TimeParam tp = 
            new TimeParam(tag, desc, TimeParam.OPTIONAL, 
                              TimeParam.MULTI_VALUED);
        assertEquals("tag set wrong", tag, tp.getTag());
        assertEquals("desc set wrong", desc, tp.getDesc());
        assertTrue("optional flag not set to true", tp.isOptional());
        assertTrue("multiValued flag not set true", tp.isMultiValued());
        assertFalse("hidden flag not set false by default", tp.isHidden());

        tp = new TimeParam(tag, desc, TimeParam.REQUIRED,
                               TimeParam.SINGLE_VALUED);
        assertFalse("optional flag not set to false", tp.isOptional());
        assertFalse("multiValued flag not set false", tp.isMultiValued());
    }

    /**
     * Test ctor accepting tag, desc, optional, multi-valued, hidden
     */
    public void testCtor4() {
        TimeParam tp = 
            new TimeParam(tag, desc, TimeParam.OPTIONAL, 
                              TimeParam.MULTI_VALUED,
                              TimeParam.HIDDEN);
        assertEquals("tag set wrong", tag, tp.getTag());
        assertEquals("desc set wrong", desc, tp.getDesc());
        assertTrue("optional flag not set to true", tp.isOptional());
        assertTrue("multiValued flag not set true", tp.isMultiValued());
        assertTrue("hidden flag not set true", tp.isHidden());

        tp = new TimeParam(tag, desc, TimeParam.REQUIRED,
                               TimeParam.SINGLE_VALUED,
                               TimeParam.PUBLIC);
        assertFalse("optional flag not set to false", tp.isOptional());
        assertFalse("multiValued flag not set false", tp.isMultiValued());
        assertFalse("hidden flag not set false", tp.isHidden());
    }

    /**
     * Test ctor accepting tag, desc, acceptableValues
     */
    public void testCtor5() {
        TimeParam tp = new TimeParam(tag, desc, acceptVals);
        assertEquals("tag set wrong", tag, tp.getTag());
        assertEquals("desc set wrong", desc, tp.getDesc());
        assertArrayEquals("acceptableValues set wrong", acceptVals, tp.getAcceptableValues());
        assertTrue("optional flag not set true by default", tp.isOptional());
        assertFalse("multiValued flag not set false by default", tp.isMultiValued());
        assertFalse("hidden flag not set false by default", tp.isHidden());
    }

    /**
     * Test ctor accepting tag, desc, acceptableValues, optional
     */
    public void testCtor6() {
        TimeParam tp = 
            new TimeParam(tag, desc, acceptVals, TimeParam.OPTIONAL);
        assertEquals("tag set wrong", tag, tp.getTag());
        assertEquals("desc set wrong", desc, tp.getDesc());
        assertTrue("optional flag not set to true", tp.isOptional());
        assertArrayEquals("acceptableValues set wrong", acceptVals, tp.getAcceptableValues());
        assertFalse("multiValued flag not set false by default", tp.isMultiValued());
        assertFalse("hidden flag not set false by default", tp.isHidden());

        tp = new TimeParam(tag, desc, acceptVals, TimeParam.REQUIRED);
        assertFalse("optional flag not set to false", tp.isOptional());
    }

    /**
     * Test ctor accepting tag, desc, acceptableValues, optional, 
     * multiValued
     */
    public void testCtor7() {
        TimeParam tp = new TimeParam(tag, desc, acceptVals, 
                                         TimeParam.OPTIONAL, 
                                         TimeParam.MULTI_VALUED);
        assertEquals("tag set wrong", tag, tp.getTag());
        assertEquals("desc set wrong", desc, tp.getDesc());
        assertTrue("optional flag not set to true", tp.isOptional());
        assertTrue("multiValued flag not set to true", tp.isMultiValued());
        assertArrayEquals("acceptableValues set wrong", acceptVals, tp.getAcceptableValues());
        assertFalse("hidden flag not set false by default", tp.isHidden());

        tp = new TimeParam(tag, desc, acceptVals, 
                             TimeParam.REQUIRED, 
                             TimeParam.SINGLE_VALUED);
        assertFalse("optional flag not set to false", tp.isOptional());
        assertFalse("multiValued flag not set to false", tp.isMultiValued());
    }

    /**
     * Test ctor accepting tag, desc, acceptableValues, optional,
     * multiValued, hidden
     */
    public void testCtor8() {
        TimeParam tp = 
            new TimeParam(tag, desc, acceptVals, 
                            TimeParam.OPTIONAL, 
                            TimeParam.MULTI_VALUED, 
                            TimeParam.HIDDEN);
        assertEquals("tag set wrong", tag, tp.getTag());
        assertEquals("desc set wrong", desc, tp.getDesc());
        assertTrue("optional flag not set to true", tp.isOptional());
        assertTrue("multiValued flag not set to true", tp.isMultiValued());
        assertTrue("hidden flag not set to true", tp.isHidden());
        assertArrayEquals("acceptableValues set wrong", acceptVals, tp.getAcceptableValues());

        tp = new TimeParam(tag, desc, acceptVals, 
                             TimeParam.REQUIRED, 
                             TimeParam.SINGLE_VALUED, 
                             TimeParam.PUBLIC);
        assertFalse("optional flag not set to false", tp.isOptional());
        assertFalse("multiValued flag not set to false", tp.isMultiValued());
        assertFalse("hidden flag not set to false", tp.isHidden());
    }

    /**
     * Tests normal constructor, set/getValue()
     */
    public void testNormal() throws Exception {
        TimeParam p = new TimeParam(tag, desc);
        String time = "20:55:34:021";
        p.setValue(time);
        assertEquals("getValue() returned wrong value",
                     time, p.getValue());
    }

    /**
     * Tests default MilliSeconds
     */
    public void testDefaultMilliSeconds() throws Exception {
        TimeParam p = new TimeParam(tag, desc);
        p.setDefaultMilliSeconds(30);
        assertEquals("getDefaultMilliSeconds() returned wrong value",
                     30, p.getDefaultMilliSeconds());
        String time = "20:55:34";
        p.setValue(time);
        assertEquals("getValue() returned wrong value",
                     time, p.getValue());
        assertEquals("getFullValue() returned wrong value",
                     time + ":030", p.getFullValue());
        boolean gotException = false;
        try {
            p.setDefaultMilliSeconds(1000);
        } catch (IllegalArgumentException e) {
            checkForMissingString(e.getMessage());
            gotException = true;
        }
        assertTrue("setDefaultMilliSeconds() did not fail with milliseconds " +
                   "set to 1000",
                   gotException);
        gotException = false;
        try {
            p.setDefaultMilliSeconds(-1);
        } catch (IllegalArgumentException e) {
            checkForMissingString(e.getMessage());
            gotException = true;
        }
        assertTrue("setDefaultMilliSeconds() did not fail with milliseconds " +
                   "set to -1",
                   gotException);
    }

    /**
     * Tests default Seconds
     */
    public void testDefaultSeconds() throws Exception {
        TimeParam p = new TimeParam(tag, desc);
        p.setDefaultSeconds(21);
        assertEquals("getDefaultSeconds() returned wrong value",
                     21, p.getDefaultSeconds());
        p.setDefaultMilliSeconds(30);
        String time = "20:55";
        p.setValue(time);
        assertEquals("getValue() returned wrong value",
                     time, p.getValue());
        assertEquals("getFullValue() returned wrong value",
                     time + ":21:030", p.getFullValue());
        boolean gotException = false;
        try {
            p.setDefaultSeconds(60);
        } catch (IllegalArgumentException e) {
            checkForMissingString(e.getMessage());
            gotException = true;
        }
        assertTrue("setDefaultSeconds() did not fail with seconds set to 60",
                   gotException);
        gotException = false;
        try {
            p.setDefaultSeconds(-1);
        } catch (IllegalArgumentException e) {
            checkForMissingString(e.getMessage());
            gotException = true;
        }
        assertTrue("setDefaultSeconds() did not fail with seconds set to -1",
                   gotException);
    }

    /**
     * Tests setValue() with invalid times.  The following times are checked:
     * <pre>
     *      100:45
     *      24:45
     *      23:60
     *      23:591
     *      23:50:60
     *      23:50:598
     *      23:50:49:1000
     *      23:50:49:9991
     * </pre>
     */
    public void testSetValueBad() {
        TimeParam p = new TimeParam(tag, desc);
        verifyBadTime(p, "100:45");
        verifyBadTime(p, "24:45");
        verifyBadTime(p, "23:60");
        verifyBadTime(p, "23:591");
        verifyBadTime(p, "23:50:60");
        verifyBadTime(p, "23:50:598");
        verifyBadTime(p, "23:50:49:1000");
        verifyBadTime(p, "23:50:49:9991");
    }

    /**
     * Verifies that the passed time value is <b>not</b> accepted by 
     * setValue().  If the time is accepted by getValue(), fail() will
     * be called and the method will not return.
     *
     * @param time          the time to be checked out
     */
    private void verifyBadTime(TimeParam p, String time) {
        boolean gotException = false;
        try {
            debug("Verifying that time \"" + time + "\" will fail");
            p.setValue(time);
        } catch (CmdLineException e) {
            checkForMissingString(e.getMessage());
            gotException = true;
        }
        assertTrue("setValue(\"" + time + "\") did not fail", gotException);
    }

    /**
     * Tests getDate()
     */
    public void testGetDate() throws Exception {
        TimeParam p = new TimeParam(tag, desc);
        SimpleDateFormat fmt = new SimpleDateFormat("MM/dd/yy HH:mm:ss:SSS");
        p.setValue("12:51");
        Date date = p.getDate(fmt.parse("12/30/02 21:56:34:123"));
        assertEquals("getDate() returned wrong date",
                     fmt.parse("12/30/02 12:51:00:000"), date);
    }

    /**
     * Tests getMilliValue() when specified time contains no
     * second or milli components
     */
    public void testGetMilliValue1() throws Exception {
        TimeParam p = new TimeParam(tag, desc);
        p.setValue("12:51");
        assertEquals("getMilliValue returns wrong value when no " +
                        "secs/millis specified",
                     12*MILLIS_PER_HOUR + 51*MILLIS_PER_MINUTE,
                     p.getMilliValue());
    }

    /**
     * Tests getMilliValue() when specified time contains no
     * milli component
     */
    public void testGetMilliValue2() throws Exception {
        TimeParam p = new TimeParam(tag, desc);
        p.setValue("12:51:34");
        assertEquals("getMilliValue returns wrong value when no " +
                        "secs specified",
                     12*MILLIS_PER_HOUR + 51*MILLIS_PER_MINUTE +
                        34*MILLIS_PER_SECOND,
                     p.getMilliValue());
    }

    /**
     * Tests getMilliValue() when specified time contains all components
     */
    public void testGetMilliValue3() throws Exception {
        TimeParam p = new TimeParam(tag, desc);
        p.setValue("12:51:34:567");
        assertEquals("getMilliValue returns wrong value when complete time " +
                        "specified",
                     12*MILLIS_PER_HOUR + 51*MILLIS_PER_MINUTE +
                        34*MILLIS_PER_SECOND + 567,
                     p.getMilliValue());
    }

    /**
     * Tests getMilliValue() when specified time contains no
     * second or milli components and the millis have been defaulted
     * with setDefaultMilliSeconds().
     */
    public void testGetMilliValue4() throws Exception {
        TimeParam p = new TimeParam(tag, desc);
        p.setDefaultMilliSeconds(234);
        p.setValue("12:51");
        assertEquals("getMilliValue returns wrong value when no " +
                        "secs/millis specified and millis defaulted",
                     12*MILLIS_PER_HOUR + 51*MILLIS_PER_MINUTE + 234,
                     p.getMilliValue());
    }

    /**
     * Tests getMilliValue() when specified time contains no
     * second or milli components and the millis and seconds have been 
     * defaulted with setDefaultMilliSeconds() and setDefaultSeconds().
     */
    public void testGetMilliValue5() throws Exception {
        TimeParam p = new TimeParam(tag, desc);
        p.setDefaultMilliSeconds(234);
        p.setDefaultSeconds(23);
        p.setValue("12:51");
        assertEquals("getMilliValue returns wrong value when no " +
                        "secs/millis specified and secs/millis defaulted",
                     12*MILLIS_PER_HOUR + 51*MILLIS_PER_MINUTE + 
                        23*MILLIS_PER_SECOND + 234,
                     p.getMilliValue());
    }

    /**
     * Tests getMilliValues() - just makes sure multiple values returned
     * in correct order, recognizing that getMilliValues() uses same calc
     * as getMilliValue().
     */
    public void testGetMilliValues() throws Exception {
        TimeParam p = new TimeParam(tag, desc, TimeParam.OPTIONAL, 
                                    TimeParam.MULTI_VALUED);
        p.addValue("12:51");
        p.addValue("10:34:24:333");
        long[] vals = p.getMilliValues();
        assertEquals("getMilliValues() returns wrong value for first value",
                     12*MILLIS_PER_HOUR + 51*MILLIS_PER_MINUTE,
                     vals[0]);
        assertEquals("getMilliValues() returns wrong value for second value",
                     10*MILLIS_PER_HOUR + 34*MILLIS_PER_MINUTE +
                        24*MILLIS_PER_SECOND + 333,
                     vals[1]);
    }

    /**
     * Undoes all that was done in setUp, clean up after test
     */
    public void tearDown() {
    }

    /**
     * Runs all tests using junit.textui.TestRunner
     */
    public static void main (String[] args) {
        doMain(args, TimeParam_UT.class);
    }
}
