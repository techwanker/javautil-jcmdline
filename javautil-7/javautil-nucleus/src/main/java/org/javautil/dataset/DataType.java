package org.javautil.dataset;

import org.javautil.document.style.HorizontalAlignment;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Date;

/**
 * 
 * @author jjs@javautil.org
 * 
 */
public enum DataType {
	STRING, INTEGER, LONG, SHORT, DOUBLE, FLOAT, NUMERIC, SQLDATE, TIMESTAMP, BIG_DECIMAL, BIG_INTEGER, CLOB, VARBINARY,
	DATE, CHAR, VARCHAR, LONGVARCHAR, LONGNVARCHAR, NCHAR, NVARCHAR, NCLOB;

	public boolean isNumeric() {
		switch (this) {
		case INTEGER:
		case LONG:
		case SHORT:
		case DOUBLE:
		case FLOAT:
		case NUMERIC:
		case BIG_DECIMAL:
		case BIG_INTEGER:
			return true;
		default:
			return false;
		}
	}

	public boolean isString() {
		switch (this) {
		case STRING:
		case CLOB:
		case CHAR:
		case VARCHAR:
		case LONGVARCHAR:
		case LONGNVARCHAR:
		case NCHAR:
		case NVARCHAR:
		case NCLOB:
			return true;
		default:
			return false;
		}
	}

	/**
	 * 
	 * @param o The object
	 * @return true if the object is of a type mappable to this enumeration
	 * 
	 */
	public boolean isType(final Object o) {
		boolean retval = false;
		if (o == null) {
			retval = true;
		} else {
			switch (this) {
			case STRING:
				retval = o instanceof String;
				break;
			case INTEGER:
				retval = o instanceof Integer;
				break;
			case LONG:
				retval = o instanceof Long;
				break;
			case SHORT:
				retval = o instanceof Long;
				break;
			case DOUBLE:
				retval = o instanceof Double;
				break;
			case FLOAT:
				retval = o instanceof Float;
				break;
			case NUMERIC:
				retval = o instanceof Number;
				break;
			case TIMESTAMP:
				retval = o instanceof Date;
				break;
			case BIG_INTEGER:
				retval = o instanceof BigInteger;
				break;
			case BIG_DECIMAL:
				retval = o instanceof BigDecimal;
				break;
			case CLOB:
				retval = o instanceof String;
				break;
			case VARBINARY:
				throw new IllegalArgumentException("no binary in Dataset");

			case DATE:
				retval = o instanceof Date;
				break;
			default:
				throw new IllegalArgumentException("unsupported type " + this);
			}

		}
		return retval;
	}
	/*
	static int 	ARRAY
	static int 	BIGINT
	static int 	BINARY
	static int 	BIT
	static int 	BLOB
	static int 	BOOLEAN
	static int 	CHAR
	static int 	CLOB
	static int 	DATALINK
	static int 	DATE
	static int 	DECIMAL
	static int 	DISTINCT
	static int 	DOUBLE
	static int 	FLOAT
	static int 	INTEGER
	static int 	JAVA_OBJECT
	static int 	LONGNVARCHAR
	static int 	LONGVARBINARY
	static int 	LONGVARCHAR
	static int 	NCHAR
	static int 	NCLOB
	static int 	NULL
	static int 	NUMERIC
	static int 	NVARCHAR
	static int 	OTHER
	static int 	REAL
	static int 	REF
	static int 	REF_CURSOR
	static int 	ROWID
	static int 	SMALLINT
	static int 	SQLXML
	static int 	STRUCT
	static int 	TIME
	static int 	TIME_WITH_TIMEZONE
	static int 	TIMESTAMP
	static int 	TIMESTAMP_WITH_TIMEZONE
	static int 	TINYINT
	static int 	VARBINARY
	static int 	VARCHAR
	 */
	/*
	static int 	ARRAY
	static int 	BINARY
	static int 	BIT
	static int 	BLOB
	static int 	BOOLEAN
	static int 	DATALINK
	static int 	DISTINCT
	static int 	JAVA_OBJECT
	static int 	LONGVARBINARY
	static int 	NCHAR
	static int 	NULL
	static int 	NVARCHAR
	static int 	OTHER
	static int 	REAL
	static int 	REF
	static int 	REF_CURSOR
	static int 	ROWID
	static int 	SMALLINT
	static int 	SQLXML
	static int 	STRUCT
	static int 	TIME
	static int 	TIME_WITH_TIMEZONE
	static int 	TIMESTAMP_WITH_TIMEZONE
	static int 	TINYINT
	 */
	public static DataType getAsDataType(final int dataType) {
		DataType returnValue = null;
		switch (dataType) {
		case Types.CHAR:
		case Types.VARCHAR:
		case Types.CLOB:
		case Types.LONGVARCHAR:
		case Types.LONGNVARCHAR:
		case Types.NCHAR:
		case Types.NVARCHAR:
		case Types.NCLOB:
			returnValue = STRING;
			break;
		case Types.TIMESTAMP:
			returnValue = TIMESTAMP;
			break;
		case Types.DATE:
			returnValue = SQLDATE;
			break;
		case Types.VARBINARY:
			returnValue = VARBINARY;
			break;
			// case Types.SHORT:
			// (no database equivalent)
		case Types.SMALLINT:
		case Types.INTEGER:
			returnValue = INTEGER;
			break;
		case Types.BIGINT:
			returnValue = BIG_INTEGER;
			break;
		case Types.DECIMAL:
			returnValue = BIG_DECIMAL;
			break;
		case Types.DOUBLE:
			returnValue = DOUBLE;
			break;
		case Types.FLOAT:
			returnValue = FLOAT;
			break;
		case Types.NUMERIC:
			returnValue = NUMERIC;
			break;
		default:
			String typeName = null;
			switch(dataType) {
			case Types.ARRAY:
				typeName = "ARRAY";
				break;
			case Types.BINARY:
				typeName = "BINARY";
				break;
			case Types.BIT:
				typeName = "BIT";
				break;
			case Types.BLOB:
				typeName = "BLOB";
				break;
			case Types.BOOLEAN:
				typeName = "BOOLEAN";
				break;
			case Types.DATALINK:
				typeName = "DATALINK";
				break;
			case Types.DISTINCT:
				typeName = "DISTINCT";
				break;
			case Types.JAVA_OBJECT:
				typeName = "JAVA_OBJECT";
				break;
			case Types.LONGVARBINARY:
				typeName = "LONGVARBINARY";
				break;
			case Types.NULL:
				typeName = "NULL";
				break;
			case Types.OTHER:
				typeName = "OTHER";
				break;
			case Types.REAL:
				typeName = "REAL";
				break;
			case Types.REF:
				typeName = "REF";
				break;
			case Types.REF_CURSOR:
				typeName = "REF_CURSOR";
				break;
			case Types.ROWID:
				typeName = "ROwID";
				break;
			case Types.SMALLINT:
				typeName = "SMALLINT";
				break;
			case Types.SQLXML:
				typeName = "SQLXML";
				break;
			case Types.STRUCT:
				typeName = "STRUCT";
				break;
			case Types.TIME:
				typeName = "TIME";
				break;
			case Types.TIME_WITH_TIMEZONE:
				typeName = "TIME_WITH_TIMEZONE";
				break;
			case Types.TIMESTAMP_WITH_TIMEZONE:
				typeName = "TIMESTAMM_WITH_TIMEZONE"; 
				break;
			case Types.TINYINT:
				typeName = "TINYINT"; 
				break;
			}
			throw new java.lang.IllegalArgumentException("unknown java.sql.Type: " + dataType + " typename " + typeName);
		}

		return returnValue;
	}

	public HorizontalAlignment getDefaultHorizontalAlignment() {
		switch (this) {
		case STRING:
		case CLOB:
			return HorizontalAlignment.LEFT;
		default:
			return HorizontalAlignment.RIGHT;
		}
	}

	public static DataType getNumberType(final int columnSize, final int decimalDigits) {
		DataType returnValue;

		if (columnSize == 0 && decimalDigits == 0 || columnSize == 22) {
			returnValue = BIG_DECIMAL;
		} else if (decimalDigits != 0) {
			returnValue = DOUBLE;
		} else {
			if (columnSize < 10) {
				returnValue = INTEGER;
			} else {
				if (columnSize < 19) {
					returnValue = LONG;
				} else {
					returnValue = BIG_INTEGER;
				}
			}
		}
		return returnValue;
	}

	public int getSqlType() {
		switch (this) {
		case STRING:
			return Types.VARCHAR;
		case NUMERIC:
			return Types.NUMERIC;
		case LONG:
			return Types.NUMERIC;
		case SHORT:
			return Types.INTEGER;
		case DOUBLE:
			return Types.DOUBLE;
		case SQLDATE:
			return Types.DATE;
		case TIMESTAMP:
			return Types.TIMESTAMP;
		case INTEGER:
			return Types.INTEGER;
		case BIG_INTEGER:
			return Types.NUMERIC;
		case BIG_DECIMAL:
			return Types.NUMERIC;
		case CLOB:
			return Types.CLOB;
		case VARBINARY:
			return Types.VARBINARY;
		default:
			throw new IllegalStateException("unmapped enum value " + this);
		}
	}

	public static boolean isDateType(final DataType type) {
		return type == DataType.TIMESTAMP || type == DataType.DATE || type == DataType.SQLDATE;
	}

	// TODO this should be a case statement
	public static boolean isNumberType(final DataType type) {

		return type == DataType.BIG_DECIMAL || type == DataType.BIG_INTEGER || type == DataType.DOUBLE
				|| type == DataType.FLOAT || type == DataType.INTEGER || type == DataType.LONG || type == DataType.NUMERIC
				|| type == DataType.SHORT;
	}

	/**
	 * todo jjs I didn't write this, where are the unit tests?
	 * 
	 * todo jjs It seems that Doubles will swallow floats and Longs lower precision
	 * values
	 * 
	 * @param clazz the class
	 * @return The associated data type
	 */
	public static DataType forClass(final Class<?> clazz) {
		DataType ret = null;
		if (clazz == null) {
			throw new IllegalArgumentException("clazz is null");
		}
		if (String.class.isAssignableFrom(clazz)) {
			ret = DataType.STRING;
		} else if (Double.class.isAssignableFrom(clazz)) {
			ret = DataType.DOUBLE;
		} else if (Long.class.isAssignableFrom(clazz)) {
			ret = DataType.LONG;
		} else if (BigDecimal.class.isAssignableFrom(clazz)) {
			ret = DataType.BIG_DECIMAL;
		} else if (BigInteger.class.isAssignableFrom(clazz)) {
			ret = DataType.BIG_INTEGER;
		} else if (Boolean.class.isAssignableFrom(clazz)) {
			throw new IllegalArgumentException("boolean type is not suppported; oracle does not support it");
			// ret = DataType.BOOLEAN;
		} else if (Short.class.isAssignableFrom(clazz)) {
			ret = DataType.SHORT;
		} else if (Float.class.isAssignableFrom(clazz)) {
			ret = DataType.FLOAT;
		} else if (Integer.class.isAssignableFrom(clazz)) {
			ret = DataType.INTEGER;
		} else if (Date.class.isAssignableFrom(clazz)) {
			ret = DataType.DATE;
		} else if (Timestamp.class.isAssignableFrom(clazz)) {
			ret = DataType.TIMESTAMP;
		} else {
			throw new IllegalStateException("Unexpected class: " + clazz.getName());
		}
		return ret;
	}

	public Object coerceString(final String value) {
		Object returnValue = null;
		if (value != null) {
			switch (this) {
			case STRING:
				returnValue = value;
				break;
			case LONG:
				returnValue = Long.parseLong(value);
				break;
			case SHORT:
				returnValue = Short.parseShort(value);
				break;
			case DOUBLE:
				returnValue = Double.parseDouble(value);
				break;
			case INTEGER:
				returnValue = Integer.parseInt(value);
				break;
			case BIG_INTEGER:
				returnValue = new BigInteger(value);
				break;
			case BIG_DECIMAL:
				returnValue = new BigDecimal(value);
				break;
			case SQLDATE:
			case TIMESTAMP:
			case CLOB:
			case VARBINARY:
			default:
				throw new UnsupportedOperationException("unsupported operation for " + this + "'" + value + "'");

			}
		}
		return returnValue;
	}
}
