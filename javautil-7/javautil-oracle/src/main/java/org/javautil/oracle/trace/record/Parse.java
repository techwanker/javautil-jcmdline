/**
 * @(#) Parse.java
 */

package org.javautil.oracle.trace.record;

/**
*
*/
public class Parse extends CursorOperation {
	public Parse(final String record, final int lineNumber) {
		super(record);
		setLineNumber(lineNumber);
	}

	@Override
	public RecordType getRecordType() {
		return RecordType.PARSE;
	}
}
