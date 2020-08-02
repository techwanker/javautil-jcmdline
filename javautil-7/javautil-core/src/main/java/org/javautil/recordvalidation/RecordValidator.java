package org.javautil.recordvalidation;

/**
 * 
 * @author jjs
 * 
 */
public interface RecordValidator {

	boolean validateRecord(int recordNumber, String input);

	RecordMessages getRecordMessages();

	void setRecordType(String recordType);

	String getRecordType();

	RecordDefinition getDefinition();

	String getText();

	void setText(String text);
}