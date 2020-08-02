package org.javautil.commandline.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation type to indicate a parameter should be treated as argument.
 * @Optional
 * @Argument
 * @MultiValue(type = ParamType.STRING)
 * private ArrayList<String> bindPair;
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface Argument {
}
