/*
 * AbstractHandlerDecorator_UT.java
 *
 * jcmdline Rel. @VERSION@ $Id: AbstractHandlerDecorator_UT.java,v 1.2 2002/12/07 14:30:49 lglawrence Exp $
 *
 * Classes:
 *   public   AbstractHandlerDecorator_UT
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

import java.util.Collection;
import java.util.Iterator;

/**
 * Unit test code for AbstractHandlerDecorator.
 * <P>
 * Usage:
 * <pre>
 *   java AbstractHandlerDecorator_UT [-log <level>] [testname [,testname...]]
 *   java AbstractHandlerDecorator_UT -help
 * </pre>
 * By default, all tests are run, and debug mode is disabled.
 *
 * @author          Lynne Lawrence
 * @version         jcmdline Rel. @VERSION@ $Id: AbstractHandlerDecorator_UT.java,v 1.2 2002/12/07 14:30:49 lglawrence Exp $
 */
public class AbstractHandlerDecorator_UT extends BetterTestCase {

    /**
     * constructor takes name of test method
     *
     * @param name          The name of the test method to be run.
     */
    public AbstractHandlerDecorator_UT(String name) {
        super(name);
    }

    /**
     * Sets up data for the test
     */
    public void setUp() {
    }

    /**
     * Undoes all that was done in setUp, clean up after test
     */
    public void tearDown() {
    }

    /**
     * Tests that the custom parameter's option is retained following a
     * call to setOptions().
     */
    public void testSetOptions() {
        StringParam porig = new StringParam("param3", "param3's description");
        CmdLineHandler h = new BasicCmdLineHandler(
            "mycmd", "cmd description", new Parameter[] { porig },
            new Parameter[] {});
            
        StringParam p1 = new StringParam("param1", "param1's description");
        StringParam p2 = new StringParam("param2", "param2's description");
        StringParam p3 = new StringParam("param3", "param3's description");
        CmdLineHandler clh = new MyCLH(new StringParam[] { p1, p2 }, h);
        clh.setOptions(new Parameter[] { p3 });
        Collection opts = clh.getOptions();
        assertEquals("Wrong number of options returned after setOptions()",
                     3, opts.size());
        assertTrue("Options don't contain param1 after setOptions()",
                   opts.contains(p1));
        assertTrue("Options don't contain param2 after setOptions()",
                   opts.contains(p2));
        assertTrue("Options don't contain new option (p3) after setOptions()",
                   opts.contains(p3));
        assertFalse("Options still contain original option (porig) after " +
                "setOptions()", opts.contains(porig));
    }

    /**
     * Tests that processParsedOptions() is called with correct parse status
     */
    public void testProcessParsedOptions() {
        // test a successful parse
        CmdLineHandler h = new BasicCmdLineHandler(
            "mycmd", "cmd description", new Parameter[] { },
            new Parameter[] {});
        StringParam p1 = new StringParam("param1", "param1's description");
        CmdLineHandler clh = new MyCLH(new StringParam[] { p1 }, h);
        clh.parse(new String[] {}); 
        Collection vals = p1.getValues();
        Iterator itr = vals.iterator();
        assertEquals("processParsedOptions() was not called",
                     1, vals.size());
        assertEquals("parse value not set correctly",
                     "true", (String)itr.next());

        // test an successful parse
        h = new BasicCmdLineHandler(
            "mycmd", "cmd description", new Parameter[] { },
            new Parameter[] {});
        p1 = new StringParam("param1", "param1's description");
        clh = new MyCLH(new StringParam[] { p1 }, h);
        clh.setDieOnParseError(false);
        clh.parse(
            new String[] { "a junk argument that should cause a bad parse" }); 
        vals = p1.getValues();
        itr = vals.iterator();
        assertEquals("processParsedOptions() was not called",
                     1, vals.size());
        assertEquals("parse value not set correctly",
                     "false", (String)itr.next());
    }

    /**
     * A subclass of AbstractHandlerDecorator with which to test
     *
     * @author          Lynne Lawrence
     * @version         jcmdline Rel. @VERSION@ $Id: AbstractHandlerDecorator_UT.java,v 1.2 2002/12/07 14:30:49 lglawrence Exp $
     */
    class MyCLH extends AbstractHandlerDecorator {
        private final StringParam[] options;
        public MyCLH(StringParam[] options, CmdLineHandler handler) {
            super(handler);
            this.options = options;
            setCustomOptions(options);
        }
        public boolean processParsedOptions(boolean parseStatus) {
            String sParseStatus = (parseStatus) ? "true" : "false";
            for (int i = 0; i < options.length; i++) {
                try {
                    options[i].addValue(sParseStatus);
                } catch (Exception e) {
                    fail("oops - there must be a coding error - this should " +
                         "never happen!");
                }
            }
            return parseStatus;
        }
    }

    /**
     * Runs all tests using junit.textui.TestRunner
     */
    public static void main (String[] args) {
        doMain(args, AbstractHandlerDecorator_UT.class);
    }
}
