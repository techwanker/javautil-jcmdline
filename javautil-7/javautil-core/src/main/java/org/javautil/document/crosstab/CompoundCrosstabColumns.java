package org.javautil.document.crosstab;

import java.util.List;

/**
 * When the column identifier is compound
 * 
 * @author jjs@dbexperts.com
 * 
 */
public interface CompoundCrosstabColumns {
	List<String> getCellIdentifiers();

	List<String> getColumnIdentifiers();

	List<String> getRowIdentifiers();

	// /**
	// * Checks for internal consistency, everything required, no dupes.
	// */
	// public void validate();

}