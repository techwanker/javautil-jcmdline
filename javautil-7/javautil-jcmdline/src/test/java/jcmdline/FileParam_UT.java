/*
 * FileParam_UT.java
 *
 * jcmdline Rel. @VERSION@ $Id: FileParam_UT.java,v 1.2 2002/12/07 14:30:49 lglawrence Exp $
 *
 * Classes:
 *   public   FileParam_UT
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

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Unit test code for FileParam
 *
 * @author          Lynne Lawrence
 * @version         jcmdline Rel. @VERSION@ $Id: FileParam_UT.java,v 1.2 2002/12/07 14:30:49 lglawrence Exp $
 */
public class FileParam_UT extends BetterTestCase {

    /**
     * indicates whether verbose debug information should be printed
     */
    private static final boolean debugMode = false;

    /**
     * constructor takes name of test method
     *
     * @param name          The name of the test method to be run.
     */
    public FileParam_UT(String name) {
        super(name);
    }

    /**
     * Test constructor taking tag, desc
     */
    public void testCtor1() {
        String tag = "infile";
        String desc = "description of the file param'g";
        FileParam p = new FileParam(tag, desc);
        assertEquals("tag not set correctly",
                     tag, p.getTag());
        assertEquals("desc not set correctly",
                     desc, p.getDesc());
        assertEquals("attributes not set correctly",
                     FileParam.NO_ATTRIBUTES, p.getAttributes());
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
        String tag = "infile";
        String desc = "description of the file param'g";
        FileParam p = new FileParam(tag, desc, FileParam.OPTIONAL);
        assertEquals("tag not set correctly",
                     tag, p.getTag());
        assertEquals("desc not set correctly",
                     desc, p.getDesc());
        assertEquals("attributes not set correctly",
                     FileParam.NO_ATTRIBUTES, p.getAttributes());
        assertTrue("multiValued flag not set correctly",
               !p.isMultiValued());
        assertTrue("hidden flag not set correctly",
               !p.isHidden());
        assertTrue("optional flag not set correctly to FileParam.OPTIONAL",
               p.isOptional());
        p = new FileParam(tag, desc, FileParam.REQUIRED);
        assertTrue("optional flag not set correctly to FileParam.REQUIRED",
               !p.isOptional());
    }

    /**
     * Test constructor taking tag, desc, attributes
     */
    public void testCtor3() {
        String tag = "infile";
        String desc = "description of the file param'g";
        int attr = FileParam.IS_DIR;
        FileParam p = new FileParam(tag, desc, attr);
        assertEquals("tag not set correctly",
                     tag, p.getTag());
        assertEquals("desc not set correctly",
                     desc, p.getDesc());
        assertEquals("attributes not set correctly",
                     attr, p.getAttributes());
        assertTrue("optional flag not set correctly",
               p.isOptional());
        assertTrue("multiValued flag not set correctly",
               !p.isMultiValued());
        assertTrue("hidden flag not set correctly",
               !p.isHidden());
    }

    /**
     * Test constructor taking tag, desc, attr, optional ind.
     */
    public void testCtor4() {
        String tag = "infile";
        String desc = "description of the file param'g";
        int attr = FileParam.IS_DIR;
        FileParam p = new FileParam(tag, desc, attr, true);
        assertEquals("tag not set correctly",
                     tag, p.getTag());
        assertEquals("desc not set to true correctly",
                     desc, p.getDesc());
        assertEquals("attributes not set correctly",
                     attr, p.getAttributes());
        assertTrue("optional flag not set correctly",
               p.isOptional());
        assertTrue("multiValued flag not set correctly",
               !p.isMultiValued());
        assertTrue("hidden flag not set correctly",
               !p.isHidden());
        p = new FileParam(tag, desc, attr, false);
        assertTrue("optional flag not set to false correctly",
               !p.isOptional());
    }

    /**
     * Test constructor taking tag, desc, attr, optional,
     * and multi-valued
     */
    public void testCtor5() {
        String tag = "infile";
        String desc = "description of the file param'g";
        int attr = FileParam.IS_DIR;
        FileParam p = new FileParam(tag, desc, attr, true, true);
        assertEquals("tag not set correctly",
                     tag, p.getTag());
        assertEquals("desc not set correctly",
                     desc, p.getDesc());
        assertEquals("attributes not set correctly",
                     attr, p.getAttributes());
        assertTrue("optional flag not set to true correctly",
               p.isOptional());
        assertTrue("multiValued flag not set to true correctly",
               p.isMultiValued());
        assertTrue("hidden flag not set correctly",
               !p.isHidden());
        p = new FileParam(tag, desc, attr, false, false);
        assertTrue("optional flag not set to false correctly",
               !p.isOptional());
        assertTrue("multiValued flag not set to false correctly",
               !p.isMultiValued());
    }

    /**
     * Test constructor taking tag, desc, attr, optional
     * multiValued, and hidden
     */
    public void testCtor6() {
        String tag = "infile";
        String desc = "description of the file param'g";
        int attr = FileParam.IS_DIR;
        FileParam p = new FileParam(tag, desc, attr, true, true, true);
        assertEquals("tag not set correctly",
                     tag, p.getTag());
        assertEquals("desc not set correctly",
                     desc, p.getDesc());
        assertEquals("attributes not set correctly",
                     attr, p.getAttributes());
        assertTrue("optional flag not set to true correctly",
               p.isOptional());
        assertTrue("multiValued flag not set to true correctly",
               p.isMultiValued());
        assertTrue("hidden flag not set to true correctly",
               p.isHidden());
        p = new FileParam(tag, desc, attr, false, false, false);
        assertTrue("optional flag not set to false correctly",
               !p.isOptional());
        assertTrue("multiValued flag not set to false correctly",
               !p.isMultiValued());
        assertTrue("hidden flag not set to false correctly",
               !p.isHidden());
    }

    /**
     * Tests getFile()
     */
    public void testGetFile() throws CmdLineException {
        debug("Starting testIntValue()");
        FileParam p = new FileParam("infile", "myDesc");
        File f1 = new File("myfile");
        String fn = f1.getAbsolutePath();
        p.addValue(fn);
        assertEquals("getFile() returned wrong value",
                     fn, p.getFile().getAbsolutePath());

        p = new FileParam("infile", "myDesc");
        p.setMultiValued(Parameter.MULTI_VALUED);
        File f2 = new File("otherfile");
        String fn2 = f2.getAbsolutePath();
        p.addValue(fn);
        p.addValue(fn2);
        assertEquals("getFile() returned wrong value for multi-valued",
                     fn, p.getFile().getAbsolutePath());

        p = new FileParam("infile", "myDesc");
        try {
            File f = p.getFile();
            fail("getFile() on param with no value set did not throw " +
                 "an exception");
        } catch (RuntimeException e) {
            debug("getFile() when not set errmsg: " + e.getMessage());
        }
    }

    /**
     * Tests getFiles()
     */
    public void testGetFiles() throws CmdLineException {
        FileParam p = new FileParam("infile", "myDesc");
        p.setMultiValued(Parameter.MULTI_VALUED);
        File f = new File("myfile");
        String fn = f.getAbsolutePath();
        f = new File("otherfile");
        String fn2 = f.getAbsolutePath();
        p.addValue(fn);
        p.addValue(fn2);
        ArrayList vals = new ArrayList(p.getFiles());
        ArrayList valNames = new ArrayList(2);
        for (Iterator itr = vals.iterator(); itr.hasNext(); ) {
            valNames.add(((File) itr.next()).getAbsolutePath());
        }
        assertEquals("getFiles() returned array of wrong size",
                     2, vals.size());
        assertTrue("value returned by getFiles() is missing " + fn,
               valNames.contains(fn));
        assertTrue("value returned by getFiles() is missing " + fn2,
               valNames.contains(fn2));
    }

    /**
     * Tests setAttributes()/attrSpecified()
     */
    public void testSetAttributes() {
        FileParam p = new FileParam("infile", "myDesc");
        p.setAttributes(FileParam.IS_DIR & FileParam.IS_READABLE);
        assertTrue("IS_DIR did not get set properly",
               p.attrSpecified(FileParam.IS_DIR));
        assertTrue("IS_READABLE did not get set properly",
               p.attrSpecified(FileParam.IS_READABLE));
        assertTrue("IS_WRITEABLE is set, but shouldn't be",
               !p.attrSpecified(FileParam.IS_WRITEABLE));
        assertTrue("IS_FILE is set, but shouldn't be",
               !p.attrSpecified(FileParam.IS_FILE));
        assertTrue("DOESNT_EXIST is set, but shouldn't be",
               !p.attrSpecified(FileParam.DOESNT_EXIST));
        assertTrue("EXISTS is set, but shouldn't be",
               !p.attrSpecified(FileParam.EXISTS));
    }

    /**
     * Runs all tests using junit.textui.TestRunner
     */
    public static void main (String[] args) {
        doMain(args, FileParam_UT.class);
    }
}
