/*
 * PosixCmdLineParser_UT.java
 *
 * jcmdline Rel. @VERSION@ $Id: PosixCmdLineParser_UT.java,v 1.2 2002/12/07 14:30:49 lglawrence Exp $
 *
 * Classes:
 *   public   PosixCmdLineParser_UT
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Unit test code for PosixCmdLineParser.
 * <P>
 * Usage:
 * <pre>
 *   java PosixCmdLineParser_UT [-debug <n>] [testname [,testname...]]
 *   java PosixCmdLineParser_UT -help
 * </pre>
 * By default, all tests are run, and debug mode is disabled.
 *
 * @author          Lynne Lawrence
 * @version         jcmdline Rel. @VERSION@ $Id: PosixCmdLineParser_UT.java,v 1.2 2002/12/07 14:30:49 lglawrence Exp $
 */
public class PosixCmdLineParser_UT extends BetterTestCase {

    // variables new for each test
    private PosixCmdLineParser parser;
    private Parameter param1 = 
        new StringParam("param1", "this is param1");
    private Parameter param2 = 
        new StringParam("param2", "this is param2");
    private Parameter param3 = 
        new StringParam("param3", "this is param3");
    private Parameter param4 = 
        new StringParam("param4", "this is param4");
    HashMap opts;
    ArrayList args;


    /**
     * constructor takes name of test method
     *
     * @param name          The name of the test method to be run.
     */
    public PosixCmdLineParser_UT(String name) {
        super(name);
    }

    /**
     * Sets up data for the test
     */
    public void setUp() {
        parser = new PosixCmdLineParser();
        opts = new HashMap();
        opts.put(param1.getTag(), param1);
        opts.put(param2.getTag(), param2);
        args = new ArrayList();
        args.add(param3);
        args.add(param4);
    }

    /**
     * Undoes all that was done in setUp, clean up after test
     */
    public void tearDown() {
    }

    /**
     * Tests with no options and no arguments
     */
    public void testNoOptNoArg() throws Exception {
        HashMap emptyOpts = new HashMap();
        ArrayList emptyArgs = new ArrayList();
        parser.parse(new String[] {}, emptyOpts, emptyArgs);
        // try with invalid opt
        try {
            parser.parse(new String[] { "-opt", "opt value" }, 
                         emptyOpts, emptyArgs);
        } catch (Exception e) {
            checkForMissingString(e.getMessage());
        }
    }

    /**
     * Tests parse() empty cmd line and all optional parameters - should pass
     */
    public void testParseOptionalParams() throws Exception {
        parser.parse(new String[] {}, opts, args);
    }

    /**
     * Tests parse() with an argument set
     */
    public void testParseArgSet() throws Exception {
        String val = "param3 value";
        parser.parse(new String[] { val }, opts, args);
        assertEquals("Argument parameter did not get set correctly",
                     val, param3.getValue());
    }

    /**
     * Tests parse() with a multi-valued argument set
     */
    public void testParseMultiArgSet() throws Exception {
        param3.setMultiValued(Parameter.MULTI_VALUED);
        String val1 = "param3 value";
        String val2 = "second value";
        parser.parse(new String[] { val1, val2 }, opts, args);
        Collection argVals = param3.getValues();
        Iterator itr = argVals.iterator();
        assertEquals("1st value of multi-valued argument did not get set " +
                     "correctly",
                     val1, (String)itr.next());
        assertEquals("2nd value of multi-valued argument did not get set " +
                     "correctly",
                     val2, (String)itr.next());
    }

    /**
     * Tests parse() with an option set
     */
    public void testParseOptSet() throws Exception {
        String val = "param1 value";
        parser.parse(new String[] { "-param1", val }, opts, args);
        assertEquals("Option did not get set correctly",
                     val, param1.getValue());
    }

    /**
     * Tests parse() with an option set with a double dash
     */
    public void testParseOptSet2Dash() throws Exception {
        String val = "param1 value";
        parser.parse(new String[] { "--param1", val }, opts, args);
        assertEquals("Option did not get set correctly",
                     val, param1.getValue());
    }

    /**
     * Tests parse() with a multi-valued option set
     */
    public void testParseMultiOptSet() throws Exception {
        param1.setMultiValued(Parameter.MULTI_VALUED);
        String val1 = "param1 value";
        String val2 = "second value";
        parser.parse(new String[] { "-param1", val1, "-param1", val2 }, 
                     opts, args);
        Collection argVals = param1.getValues();
        Iterator itr = argVals.iterator();
        assertEquals("1st value of multi-valued option did not get set " +
                     "correctly",
                     val1, (String)itr.next());
        assertEquals("2nd value of multi-valued option did not get set " +
                     "correctly",
                     val2, (String)itr.next());
    }

    /**
     * Tests parse() with 2 options and 2 arguments set
     */
    public void testParse2Opt2ArgSet() throws Exception {
        param4.setMultiValued(Parameter.MULTI_VALUED);
        String val1 = "param1 value";
        String val2 = "param2 value";
        String val3 = "param3 value";
        String val4 = "param4 value";
        String val5 = "param4 value";
        parser.parse(new String[] { 
            "--param2", val2, "-param1", val1, val3, val4, val5 }, opts, args);
        assertEquals("param1 did not get set correctly",
                     val1, param1.getValue());
        assertEquals("param2 did not get set correctly",
                     val2, param2.getValue());
        assertEquals("param3 did not get set correctly",
                     val3, param3.getValue());
        Collection param4Vals = param4.getValues();
        Iterator itr = param4Vals.iterator();
        assertEquals("1st value of multi-valued not set correctly",
                     val4, (String)itr.next());
        assertEquals("2nd value of multi-valued not set correctly",
                     val5, (String)itr.next());
    }

    /**
     * Runs all tests using junit.textui.TestRunner
     */
    public static void main (String[] args) {
        doMain(args, PosixCmdLineParser_UT.class);
    }
}
