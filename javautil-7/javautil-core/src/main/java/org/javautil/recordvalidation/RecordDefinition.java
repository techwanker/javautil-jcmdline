package org.javautil.recordvalidation;

import java.util.Collection;

import org.javautil.field.FieldDefinition;

/**
 * 
 * @author jjs
 * 
 */
public interface RecordDefinition {

	Collection<FieldDefinition> getFields();

	FieldDefinition getField(int fieldIndex);
}