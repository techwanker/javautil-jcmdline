/*
 * BooleanParam_UT.java
 *
 * Classes:
 *   public   BooleanParam_UT
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

/**
 * Unit test code for BooleanParam
 *
 * @author          Lynne Lawrence
 * @version         jcmdline Rel. @VERSION@ $Id: BooleanParam_UT.java,v 1.2 2002/12/07 14:30:49 lglawrence Exp $
 */
public class BooleanParam_UT extends BetterTestCase {

    /**
     * indicates whether verbose debug information should be printed
     */
    private static final boolean debugMode = false;

    /**
     * constructor takes name of test method
     *
     * @param name          The name of the test method to be run.
     */
    public BooleanParam_UT(String name) {
        super(name);
    }

    /**
     * Test constructor taking tag, desc
     */
    public void testConst1() {
        String tag = "mytag";
        String desc = "this is the desc";
        BooleanParam p = new BooleanParam(tag, desc);
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
     * Test constructor taking tag, desc, hidden
     */
    public void testConst2() {
        String tag = "mytag";
        String desc = "this is the desc";
        BooleanParam p = new BooleanParam(tag, desc, BooleanParam.HIDDEN);
        assertEquals("tag not set correctly",
                     tag, p.getTag());
        assertEquals("desc not set correctly",
                     desc, p.getDesc());
        assertTrue("multiValued flag not set correctly",
               !p.isMultiValued());
        assertTrue("optional flag not set correctly",
               p.isOptional());
        assertTrue("hidden flag not set correctly to BooleanParam.HIDDEN",
               p.isHidden());
        p = new BooleanParam(tag, desc, BooleanParam.PUBLIC);
        assertTrue("hidden flag not set correctly to BooleanParam.PUBLIC",
               !p.isHidden());
    }

    /**
     * Tests addValue()
     */
    public void testAddValue() throws CmdLineException {
        BooleanParam p = new BooleanParam("mytag", "mydesc");
        assertTrue("BooleanParam not initialized to 'false'",
               !p.isTrue());
        p.setValue("true");
        assertTrue("setValue(\"true\") failed",
               p.isTrue());

        p = new BooleanParam("mytag", "mydesc");
        try {
            p.setValue("something");
            fail("setValue(\"something\") did not fail");
        } catch (CmdLineException e) {
            debug("addValue(\"something\") error: " + e.getMessage());
        }
    }

    /**
     * Runs all tests using junit.textui.TestRunner
     */
    public static void main (String[] args) {
        doMain(args, BooleanParam_UT.class);
    }
}
