/*
 * Concat.java
 *
 * jcmdline Rel. @VERSION@ $Id: Concat.java,v 1.2 2002/12/07 14:30:49 lglawrence Exp $
 *
 * Classes:
 *   public   Concat
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
import java.util.Iterator;

/**
 * "junk class" to test CmdLineParser with paramters used in CmdLineParser
 * javadoc.
 *
 * @author          Lynne Lawrence
 * @version         jcmdline Rel. @VERSION@ $Id: Concat.java,v 1.2 2002/12/07 14:30:49 lglawrence Exp $
 */
public class Concat {

    /**
     * this command's help text
     */
    static String helpMsg = 
        "Concat is used to concatenate the files specified by <filename> " +
        "together.  By default, the concatenated files are written to " +
        "stdout.\n\nIf the '-out' option is specified, the " +
        "concatenated files " +
        "will be written to the specified file instead of stdout.\n\nThe " +
        "'-delete' option specifies that the original files be deleted";

    /**
     * an optional 'outfile' command line option
     */
    static final FileParam outfile = new FileParam(
            "out",
            "a file to receive the concatenated files (default is stdout)");

    /**
     * an optional 'delete' command line option
     */
    static final BooleanParam delete = new BooleanParam(
            "delete",
            "specifies that all of the original files are to be deleted");

    /**
     * required, multivalued, 'filename' command line parameter
     */
    static final FileParam infiles = new FileParam(
            "filename",
            "files to be concatenated",
            FileParam.IS_FILE & FileParam.IS_READABLE,
            FileParam.REQUIRED,
            FileParam.MULTI_VALUED);

    /**
     * main - doesn't actually do anything other than process command line
     * parameters and print them out.
     *
     * @param args          command line arguments
     */
    public static void main(String[] args) {
        outfile.setOptionLabel("outfile");
        CmdLineHandler clp = new DefaultCmdLineHandler(
        // CmdLineParser clp = new CmdLineParser(
                "Concat", "concatenates the specified files",
                // "V2.3", helpMsg,
                new Parameter[] { outfile, delete },
                new Parameter[] { infiles });
        clp.parse(args);

        System.out.println("Outfile:");
        if (outfile.isSet()) {
            System.out.println("   " + outfile.getFile().getPath());
        } else {
            System.out.println("   stdout");
        }
        System.out.println("Infiles:");
        for (Iterator itr = infiles.getFiles().iterator(); itr.hasNext(); ) {
            System.out.println("   " + ((File)itr.next()).getPath());
        }
        if (delete.isTrue()) {
            System.out.println("Deleting original files");
        } else {
            System.out.println("Not deleting original files");
        }
    }
}
