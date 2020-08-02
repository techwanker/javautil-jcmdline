package org.javautil.commandline.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation type to indicate a parameter should be treated as required unless
 * another parameter is specified.
 * 
 * code:
 * 
 * @RequiredUnless(property = "toad")
 * private String frog;
 * 
 * @Optional
 * private String toad;
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface RequiredUnless {
	String property();
}
