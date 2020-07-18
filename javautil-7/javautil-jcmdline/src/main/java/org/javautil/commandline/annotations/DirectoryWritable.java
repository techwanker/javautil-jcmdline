package org.javautil.commandline.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



/**
 * Annotation type to indicate a directory must be writable.
 * 
 * code:
 * 
 * @DirectoryWriteable
 * private File databaseDirectory;
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface DirectoryWritable {
}
