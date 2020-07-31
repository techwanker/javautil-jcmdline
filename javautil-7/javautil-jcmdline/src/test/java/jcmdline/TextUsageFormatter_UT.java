/*
 * TextUsageFormatter_UT.java
 *
 * jcmdline Rel. @VERSION@ $Id: TextUsageFormatter_UT.java,v 1.2 2002/12/07 14:30:49 lglawrence Exp $
 *
 * Classes:
 *   public   TextUsageFormatter_UT
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
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Unit test code for TextUsageFormatter.
 * <P>
 * Usage:
 * <pre>
 *   java TextUsageFormatter_UT [-log <level>] [testname [,testname...]]
 *   java TextUsageFormatter_UT -help
 * </pre>
 * By default, all tests are run, and debug mode is disabled.
 *
 * @author          Lynne Lawrence
 * @version         jcmdline Rel. @VERSION@ $Id: TextUsageFormatter_UT.java,v 1.2 2002/12/07 14:30:49 lglawrence Exp $
 */
public class TextUsageFormatter_UT extends BetterTestCase {

    // static variables
    private static final String cmdName = "mycmd";
    private static final String cmdDesc = "this is the command description";

    // variables new for each test
    private final Parameter param1 =
        new StringParam("param1", "this is param1");
    private final Parameter param2 =
        new StringParam("param2", "this is param2");
    private final Parameter param3 =
        new StringParam("param3", "this is param3");
    private final Parameter param4 =
        new StringParam("param4", "this is param4");

    private HashMap opts;
    private ArrayList args;
    private TextUsageFormatter formatter;

    /**
     * constructor takes name of test method
     *
     * @param name          The name of the test method to be run.
     */
    public TextUsageFormatter_UT(String name) {
        super(name);
    }

    /**
     * Sets up data for the test
     */
    public void setUp() {
        opts = new HashMap(2);
        opts.put(param1.getTag(), param1);
        opts.put(param2.getTag(), param2);
        args = new ArrayList();
        args.add(param3);
        args.add(param4);
        formatter = new TextUsageFormatter();
    }

    /**
     * Undoes all that was done in setUp, clean up after test
     */
    public void tearDown() {
    }

    /**
     * Tests formatUsage on when the list of arguments is empty.  Just
     * tests that it won't bomb off.  To see the actual message, run with
     * "-log FINE".
     */
    public void testFormatUsageNoArgs() {
        ArrayList emptyArgs = new ArrayList();
        String s = formatter.formatUsage(
            "name", "cmd desc", opts, emptyArgs, false);
        debug("Usage with no arguments:\n" + s);
    }

    /**
     * Tests formatUsage on when the list of options is empty.  Just
     * tests that it won't bomb off.  To see the actual message, run with
     * "-log FINE".
     */
    public void testFormatUsageNoOpts() {
        HashMap emptyOpts = new HashMap();
        String s = formatter.formatUsage(
            "name", "cmd desc", emptyOpts, args, false);
        debug("Usage with no options:\n" + s);
    }

    /**
     * Tests formatUsage on when the list of options and the list of 
     * arguments are empty.  Just
     * tests that it won't bomb off.  To see the actual message, run with
     * "-log FINE".
     */
    public void testFormatUsageNoOptsNoArgs() {
        HashMap emptyOpts = new HashMap();
        ArrayList emptyArgs = new ArrayList();
        String s = formatter.formatUsage(
            "name", "cmd desc", emptyOpts, emptyArgs, false);
        debug("Usage with no options or args:\n" + s);
    }

    /**
     * Tests formatText().
     */
    public void testFormatText() {

                  //         1         2         3         4         5
                  //12345678901234567890123456789012345678901234567890
        String s = "This is a test line to use in testing formatText()";

        String ret = formatter.formatText(s, 0, 80);
        assertEquals("formatText(s, 0, 80) failed",
                     s, ret);
        ret = formatter.formatText(s, 0, 20);
        assertEquals("formatText(s, 0, 20) failed",
                     "This is a test line\nto use in testing\nformatText()",
                     ret);
        ret = formatter.formatText(s, 10, 20);
        assertEquals("formatText(s, 10, 20) failed",
                     "          This is a\n          test line\n" +
                     "          to use in\n          testing\n" +
                     "          formatText\n          ()",
                     ret);
    }

    /**
     * Tests set/getLineLength()
     */
    public void testSetLineLength() {
        int len = 50;
        formatter.setLineLength(len);
        assertEquals("getLineLength() did not return correct value",
                     len, formatter.getLineLength());
        String s = formatter.formatUsage(
            "name", "cmd desc", opts, args, false);
        debug("Usage with max line length = " + len + ":\n" + s);

        StringTokenizer st = new StringTokenizer(s, "\n");
        String usageLine;
        while (st.hasMoreTokens()) {
            usageLine = st.nextToken();
            if (usageLine.length() > len) {
                fail("Usage line contains more than " + len + " chars:\n" +
                     usageLine);
            }
        }
    }

    /**
     * Runs all tests using junit.textui.TestRunner
     */
    public static void main (String[] args) {
        doMain(args, TextUsageFormatter_UT.class);
    }
}
