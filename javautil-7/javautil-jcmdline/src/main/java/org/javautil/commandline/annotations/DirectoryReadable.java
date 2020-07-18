package org.javautil.commandline.annotations;

import java.io.File;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.javautil.poi.workbook.DirectoryWriteable;

/**
 * Annotation type to indicate a directory must be readable. By definition it
 * must exist. TODO ensure that this is true.
 * 
 * code:
 * 
 * @DirectoryReadable
 * private File databaseDirectory;
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface DirectoryReadable {
}
