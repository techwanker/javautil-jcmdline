package org.javautil.sql;

public class SqlSplitterException extends RuntimeException {
	private final SqlSplitterLine line;

	private final String          message;

	SqlSplitterException(SqlSplitterLine line, String message) {
		this.line = line;
		this.message = message;
	}

	public SqlSplitterLine getLine() {
		return line;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
