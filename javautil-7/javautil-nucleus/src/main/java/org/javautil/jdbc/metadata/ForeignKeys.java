package org.javautil.jdbc.metadata;

import java.util.Collection;
import java.util.Iterator;

// TODO Delete 
public interface ForeignKeys {

	void addForeignKey(final ForeignKeyImpl key);

	/**
	 * @return Returns the schemaPattern.
	 */
    String getSchemaPattern();

	/**
	 * @return Returns the table.
	 */
    String getTable();

	Collection<? extends ForeignKey> getValues();

	Iterator<? extends ForeignKey> iterator();

	/**
	 * @param schemaPattern The schemaPattern to set.
	 */
    void setSchemaPattern(final String schemaPattern);

	/**
	 * @param table The table to set.
	 */
    void setTable(final String table);

}
