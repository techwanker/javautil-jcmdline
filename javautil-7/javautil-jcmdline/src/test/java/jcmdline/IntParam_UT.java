/*
 * IntParam_UT.java
 *
 * jcmdline Rel. @VERSION@ $Id: IntParam_UT.java,v 1.2 2002/12/07 14:30:49 lglawrence Exp $
 *
 * Classes:
 *   public   IntParam_UT
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

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Unit test code for IntParam
 *
 * @author          Lynne Lawrence
 * @version         jcmdline Rel. @VERSION@ $Id: IntParam_UT.java,v 1.2 2002/12/07 14:30:49 lglawrence Exp $
 */
public class IntParam_UT extends BetterTestCase {

    /**
     * indicates whether verbose debug information should be printed
     */
    private static final boolean debugMode = false;

    /**
     * constructor takes name of test method
     *
     * @param name          The name of the test method to be run.
     */
    public IntParam_UT(String name) {
        super(name);
    }

    /**
     * Test constructor taking tag, desc
     */
    public void testCtor1() {
        String tag = "count";
        String desc = "the number of times to iterate";
        IntParam p = new IntParam(tag, desc);
        assertEquals("tag not set correctly",
                     tag, p.getTag());
        assertEquals("desc not set correctly",
                     desc, p.getDesc());
        assertTrue("optional flag not set correctly",
               p.isOptional());
        assertTrue("multiValued flag not set correctly",
               !p.isMultiValued());
        assertTrue("hidden flag not set correctly",
               !p.isHidden());
    }

    /**
     * Test constructor taking tag, desc, optional
     */
    public void testCtor2() {
        String tag = "count";
        String desc = "the number of times to iterate";
        IntParam p = new IntParam(tag, desc, IntParam.OPTIONAL);
        assertEquals("tag not set correctly",
                     tag, p.getTag());
        assertEquals("desc not set correctly",
                     desc, p.getDesc());
        assertTrue("multiValued flag not set correctly",
               !p.isMultiValued());
        assertTrue("hidden flag not set correctly",
               !p.isHidden());
        assertTrue("optional flag not set correctly to IntParam.OPTIONAL",
               p.isOptional());
        p = new IntParam(tag, desc, IntParam.REQUIRED);
        assertTrue("optional flag not set correctly to IntParam.REQUIRED",
               !p.isOptional());
    }

    /**
     * Test constructor taking tag, desc, min, max
     */
    public void testCtor3() {
        String tag = "count";
        String desc = "the number of times to iterate";
        int min = 2;
        int max = 100;
        IntParam p = new IntParam(tag, desc, min, max);
        assertEquals("tag not set correctly",
                     tag, p.getTag());
        assertEquals("desc not set correctly",
                     desc, p.getDesc());
        assertTrue("optional flag not set correctly",
               p.isOptional());
        assertTrue("multiValued flag not set correctly",
               !p.isMultiValued());
        assertTrue("hidden flag not set correctly",
               !p.isHidden());
        assertEquals("min not set correctly",
                     min, p.getMin());
        assertEquals("max not set correctly",
                     max, p.getMax());
    }

    /**
     * Test constructor taking tag, desc, min, max, optional ind.
     */
    public void testCtor4() {
        String tag = "count";
        String desc = "the number of times to iterate";
        int min = 2;
        int max = 100;
        IntParam p = new IntParam(tag, desc, min, max, true);
        assertEquals("tag not set correctly",
                     tag, p.getTag());
        assertEquals("desc not set to true correctly",
                     desc, p.getDesc());
        assertTrue("optional flag not set correctly",
               p.isOptional());
        assertTrue("multiValued flag not set correctly",
               !p.isMultiValued());
        assertTrue("hidden flag not set correctly",
               !p.isHidden());
        assertEquals("min not set correctly",
                     min, p.getMin());
        assertEquals("max not set correctly",
                     max, p.getMax());
        p = new IntParam(tag, desc, min, max, false);
        assertTrue("optional flag not set to false correctly",
               !p.isOptional());
    }

    /**
     * Test constructor taking tag, desc, min, max, optional,
     * and multi-valued
     */
    public void testCtor5() {
        String tag = "count";
        String desc = "the number of times to iterate";
        int min = 2;
        int max = 100;
        IntParam p = new IntParam(tag, desc, min, max, true, true);
        assertEquals("tag not set correctly",
                     tag, p.getTag());
        assertEquals("desc not set correctly",
                     desc, p.getDesc());
        assertTrue("optional flag not set to true correctly",
               p.isOptional());
        assertTrue("multiValued flag not set to true correctly",
               p.isMultiValued());
        assertTrue("hidden flag not set correctly",
               !p.isHidden());
        assertEquals("min not set correctly",
                     min, p.getMin());
        assertEquals("max not set correctly",
                     max, p.getMax());
        p = new IntParam(tag, desc, min, max, false, false);
        assertTrue("optional flag not set to false correctly",
               !p.isOptional());
        assertTrue("multiValued flag not set to false correctly",
               !p.isMultiValued());
    }

    /**
     * Test constructor taking tag, desc, min, max, optional
     * multiValued, and hidden
     */
    public void testCtor6() {
        String tag = "count";
        String desc = "the number of times to iterate";
        int min = 1;
        int max = 100;
        IntParam p = new IntParam(tag, desc, min, max, true, true, true);
        assertEquals("tag not set correctly",
                     tag, p.getTag());
        assertEquals("desc not set correctly",
                     desc, p.getDesc());
        assertTrue("optional flag not set to true correctly",
               p.isOptional());
        assertTrue("multiValued flag not set to true correctly",
               p.isMultiValued());
        assertTrue("hidden flag not set to true correctly",
               p.isHidden());
        assertEquals("min not set correctly",
                     min, p.getMin());
        assertEquals("max not set correctly",
                     max, p.getMax());
        p = new IntParam(tag, desc, min, max, false, false, false);
        assertTrue("optional flag not set to false correctly",
               !p.isOptional());
        assertTrue("multiValued flag not set to false correctly",
               !p.isMultiValued());
        assertTrue("hidden flag not set to false correctly",
               !p.isHidden());
    }

    /**
     * Test constructor taking tag, desc, acceptableValues
     */
    public void testCtor7() {
        String tag = "count";
        String desc = "the number of times to iterate";
        int[] av = new int[] { 3, 4, 5, 6 };
        IntParam p = new IntParam(tag, desc, av);
        assertEquals("tag not set correctly",
                     tag, p.getTag());
        assertEquals("desc not set correctly",
                     desc, p.getDesc());
        assertTrue("optional flag not set correctly",
               p.isOptional());
        assertTrue("multiValued flag not set correctly",
               !p.isMultiValued());
        assertTrue("hidden flag not set correctly",
               !p.isHidden());
        assertTrue("acceptableValues not set correctly",
                   Arrays.equals(av, p.getAcceptableIntValues()));
    }

    /**
     * Test constructor taking tag, desc, acceptableValues, optional
     */
    public void testCtor8() {
        String tag = "count";
        String desc = "the number of times to iterate";
        int[] av = new int[] { 3, 4, 5, 6 };
        IntParam p = new IntParam(tag, desc, av, true);
        assertEquals("tag not set correctly",
                     tag, p.getTag());
        assertEquals("desc not set correctly",
                     desc, p.getDesc());
        assertTrue("optional flag not set to true correctly",
               p.isOptional());
        assertTrue("multiValued flag not set correctly",
               !p.isMultiValued());
        assertTrue("hidden flag not set correctly",
               !p.isHidden());
        assertTrue("acceptableValues not set correctly",
                   Arrays.equals(av, p.getAcceptableIntValues()));
        p = new IntParam(tag, desc, av, false);
        assertTrue("optional flag not set to false correctly",
               !p.isOptional());
    }

    /**
     * Test constructor taking tag, desc, acceptableValues, optional, 
     * multiValued
     */
    public void testCtor9() {
        String tag = "count";
        String desc = "the number of times to iterate";
        int[] av = new int[] { 3, 4, 5, 6 };
        IntParam p = new IntParam(tag, desc, av, true, true);
        assertEquals("tag not set correctly",
                     tag, p.getTag());
        assertEquals("desc not set correctly",
                     desc, p.getDesc());
        assertTrue("optional flag not set to true correctly",
               p.isOptional());
        assertTrue("multiValued flag not set to true correctly",
               p.isMultiValued());
        assertTrue("hidden flag not set correctly",
               !p.isHidden());
        assertTrue("acceptableValues not set correctly",
                   Arrays.equals(av, p.getAcceptableIntValues()));
        p = new IntParam(tag, desc, av, false, false);
        assertTrue("optional flag not set to false correctly",
               !p.isOptional());
        assertTrue("multiValued flag not set to false correctly",
               !p.isMultiValued());
    }

    /**
     * Test constructor taking tag, desc, acceptableValues, optional,
     * multiValued, hidden
     */
    public void testCtor10() {
        String tag = "count";
        String desc = "the number of times to iterate";
        int[] av = new int[] { 3, 4, 5, 6 };
        IntParam p = new IntParam(tag, desc, av, true, true, true);
        assertEquals("tag not set correctly",
                     tag, p.getTag());
        assertEquals("desc not set correctly",
                     desc, p.getDesc());
        assertTrue("optional flag not set to true correctly",
               p.isOptional());
        assertTrue("multiValued flag not set to true correctly",
               p.isMultiValued());
        assertTrue("hidden flag not set to true correctly",
               p.isHidden());
        assertTrue("acceptableValues not set correctly",
                   Arrays.equals(av, p.getAcceptableIntValues()));
        p = new IntParam(tag, desc, av, false, false, false);
        assertTrue("optional flag not set to false correctly",
               !p.isOptional());
        assertTrue("multiValued flag not set to false correctly",
               !p.isMultiValued());
        assertTrue("hidden flag not set to false correctly",
               !p.isHidden());
    }

    /**
     * Tests intValue() with single valued param
     */
    public void testIntValue() throws CmdLineException {
        IntParam p = new IntParam("count", "myDesc");
        p.addValue("92359");
        assertEquals("intValue() returned wrong value",
                     92359, p.intValue());
    }

    /**
     * Tests intValue() with multi valued param
     */
    public void testIntValueMulti() throws CmdLineException {
        IntParam p = new IntParam("count", "myDesc");
        p.setMultiValued(Parameter.MULTI_VALUED);
        p.addValue("92359");
        p.addValue("10286");
        assertEquals("intValue() returned wrong value for multi-valued",
                     92359, p.intValue());
    }

    /**
     * Tests intValues()
     */
    public void testIntValues() throws CmdLineException {
        IntParam p = new IntParam("count", "myDesc");
        p.setMultiValued(Parameter.MULTI_VALUED);
        p.addValue("92359");
        p.addValue("10286");
        int[] vals = p.intValues();
        assertEquals("intValues() returned array of wrong size",
                     2, vals.length);
        assertEquals("first value returned by intValues() is wrong",
                     92359, vals[0]);
        assertEquals("second value returned by intValues() is wrong",
                     10286, vals[1]);
    }

    /**
     * Test a IntParam with Min/Max values where specified value in range
     */
    public void testMinMax() throws CmdLineException {
        debug("Starting testMinMax()");
        IntParam p = new IntParam("count", "mydesc", 2, 99, true, true);
        p.addValue("2");
        p.addValue("99");
    }

    /**
     * Test a IntParam where specified value less than min allowed
     */
    public void testMin() {
        debug("Starting testMin()");
        IntParam p = new IntParam("count", "mydesc", 2, 99, true, true);
        try {
            p.addValue("1");
            fail("addValue() did not fail when adding string of length < min");
        } catch (CmdLineException e) {
            checkForMissingString(e.getMessage());
        }
    }

    /**
     * Test a IntParam where specified value greater than max allowed
     */
    public void testMax() {
        debug("Starting testMax()");
        IntParam p = new IntParam("count", "mydesc", 2, 99, true, true);
        try {
            p.addValue("100");
            fail("addValue() did not fail when adding string of length > max");
        } catch (CmdLineException e) {
            checkForMissingString(e.getMessage());
        }
    }

    /**
     * Test a multi-valued IntParam
     */
    public void testMultiValued() throws CmdLineException {
        debug("Starting testMultiValued()");
        IntParam p = new IntParam("count", "mydesc", 
                                  IntParam.OPTIONAL, IntParam.MULTI_VALUED);
        String sInt1 = "92359";
        String sInt2 = "10286";
        p.addValue(sInt1);
        p.addValue(sInt2);
        Collection vals = p.getValues();
        Iterator itr = vals.iterator();
        assertEquals("getValues() returns wrong # of values",
                     2, vals.size());
        assertEquals("first value returned by getValues() is wrong",
                     sInt1, itr.next());
        assertEquals("second value returned by getValues() is wrong",
                     sInt2, itr.next());
        
    }

    /**
     * Test a IntParam with acceptableValues where specified values valid
     */
    public void testAcceptableValues1() throws CmdLineException {
        debug("Starting testAcceptableValues1()");
        IntParam p = new IntParam("myTag", "myDesc", 
                new int[] { 2, 10 }, true, true);
        p.addValue("2");
        p.addValue("10");
    }

    /**
     * Test a IntParam with acceptableValues where specified value is an
     * empty string (should fail)
     */
    public void testAcceptableValues2() throws CmdLineException {
        debug("Starting testAcceptableValues2()");
        IntParam p = new IntParam("myTag", "myDesc", 
                new int[] { 2, 10 }, true, true);
        try {
            p.addValue("");
            fail("addValue(\"\") did not fail");
        } catch (CmdLineException e) {
            checkForMissingString(e.getMessage());
        }
    }

    /**
     * Test a IntParam with acceptableValues where specified value not
     * in valid set
     */
    public void testAcceptableValues3() {
        debug("Starting testAcceptableValues3()");
        IntParam p = new IntParam("myTag", "myDesc", 
                new int[] { 2, 10 }, true, true);
        try {
            p.addValue("1");
            fail("addValue(\"1\") did not fail");
        } catch (CmdLineException e) {
            checkForMissingString(e.getMessage());
        }
    }

    /**
     * Runs all tests using junit.textui.TestRunner
     */
    public static void main (String[] args) {
        doMain(args, IntParam_UT.class);
    }
}
