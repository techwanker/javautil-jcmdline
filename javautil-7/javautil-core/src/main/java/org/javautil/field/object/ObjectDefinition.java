package org.javautil.field.object;

public interface ObjectDefinition {

	Object getObject(String externalRepresentation) throws ObjectParseException;

	boolean validate(String externalRepresentation);
}