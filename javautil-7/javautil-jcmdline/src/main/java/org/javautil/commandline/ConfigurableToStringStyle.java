package org.javautil.commandline;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringStyle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jjs at dbexperts dot com
 */
public class ConfigurableToStringStyle extends ToStringStyle {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5945594888222550784L;


	private boolean emitStatics = false;

	private boolean emitTransients;

	private final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * Default format for Dates with no time.
	 * 
	 * "yyyy-MM-dd"
	 */

	public static final String noTime = "yyyy-MM-dd";

	/**
	 * Default with format for Dates with time.
	 * 
	 * "yyyy-MM-dd HH:mm:ss"
	 */
	public static final String withTime = "yyyy-MM-dd HH:mm:ss";

	private SimpleDateFormat withoutTimeFormat = new SimpleDateFormat(noTime);

	private SimpleDateFormat withTimeFormat = new SimpleDateFormat(withTime);

	/*
	 * When printing a date, don't print the time if it is midnight.
	 * 
	 * default true.
	 */
	private boolean suppressTimeIfMidnight = true;

	ConfigurableToStringStyle() {
		super();
	}

	public ConfigurableToStringStyle(final ToStringStyleFlags... flags) {
		super();
		setFlags(ToStringStyleFlags.USE_SHORT_CLASS_NAME);
		setFlags(flags);
	}

	@Override
	protected void appendDetail(final StringBuffer buffer, @SuppressWarnings("unused") final String fieldName,
			Object value) {
		if (value instanceof Date) {
			value = formatDate((Date) value);
		}
		buffer.append(value);
	}
	

	/**
	 * Check if a date is midnight in the current locale (default constructor)
	 * or the Calendar specified in the constructor.
	 * 
	 * 		todo where is the test for this
	 * 
	 * @param d the date
	 * @return true if it is midnight
	 * 
	 */
	public boolean isMidnight(final Date d) {
		boolean retval;
		Calendar greg = Calendar.getInstance();

			greg.setTime(d);
			if (greg.get(Calendar.HOUR) == 0 && greg.get(Calendar.MINUTE) == 0 && greg.get(Calendar.SECOND) == 0
					&& greg.get(Calendar.MILLISECOND) == 0) {
				retval = true;
			} else {
				retval = false;
			}
		
		return retval;
	}

	protected String formatDate(final Date d) {
		String formatted = null;
		if (suppressTimeIfMidnight) {
			if (isMidnight(d)) {
				formatted = withoutTimeFormat.format(d);
			} else {
				formatted = withTimeFormat.format(d);
			}
		} else {
			formatted = withTimeFormat.format(d);
		}

		return formatted;

	}

	public boolean getEmitTransients() {

		return emitTransients;
	}

	public SimpleDateFormat getMidnightDateFormat() {
		return withoutTimeFormat;
	}

	public SimpleDateFormat getNotMidnightDateFormat() {
		return withTimeFormat;
	}

	public boolean getEmitStatics() {
		return emitStatics;
	}

	public boolean getSuppressTimeIfMidnight() {
		return suppressTimeIfMidnight;
	}

	public void setEmitStatics(final boolean emitStatics) {
		this.emitStatics = emitStatics;
	}

	public void setEmitTransients(final boolean emitTransients) {
		this.emitTransients = emitTransients;
	}

	public void setFlags(final ToStringStyleFlags... flags) {
		for (final ToStringStyleFlags flag : flags) {
			switch (flag) {
			case EMIT_FIELD_NAMES:
				super.setUseFieldNames(true);
				break;
			case DONT_EMIT_FIELD_NAMES:
				super.setUseFieldNames(false);
				break;
			case EMIT_CLASS_NAME:
				super.setUseClassName(true);
				break;
			case DONT_EMIT_CLASS_NAME:
				super.setUseClassName(false);
				break;
			case USE_SHORT_CLASS_NAME:
				super.setUseShortClassName(true);
				break;
			case DONT_USE_SHORT_CLASS_NAME:
				super.setUseShortClassName(false);
				break;
			case EMIT_IDENTITY_HASH_CODE:
				super.setUseIdentityHashCode(true);
				break;
			case DONT_EMIT_IDENTITY_HASH_CODE:
				super.setUseIdentityHashCode(false);
				break;
			case SUPPRESS_TIME:
				withTimeFormat = new SimpleDateFormat("yyyy-MM-dd");
				break;
			case USE_ISO_DATE_TIME_FORMAT:
				withTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				break;
			case SUPPRESS_TIME_IF_MIDNIGHT:
				suppressTimeIfMidnight = true;
				break;
			case EMIT_STATICS:
				emitStatics = true;
				break;
			case DONT_EMIT_STATICS:
				emitStatics = false;
				break;
			case EMIT_TRANSIENTS:
				emitTransients = true;
				break;
			case DONT_EMIT_TRANSIENTS:
				emitTransients = false;
				break;

			default:
				throw new IllegalStateException();
			}
		}
	}

	/**
	 * Set the date format to be used when time is not to be displayed.
	 * 
	 * If not called it defaults to
	 * 
	 * @param noTimeFormat there is no time format
	 */
	public void setNoTimeFormat(final SimpleDateFormat noTimeFormat) {
		this.withoutTimeFormat = noTimeFormat;
	}

	public void setWithTimeFormat(final SimpleDateFormat notMidnightDateFormat) {
		this.withTimeFormat = notMidnightDateFormat;
	}

	public void setSuppressTimeIfMidnight(final boolean suppressTimeIfMidnight) {
		this.suppressTimeIfMidnight = suppressTimeIfMidnight;
	}

}
