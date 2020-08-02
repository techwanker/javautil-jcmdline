package org.javautil.lang;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BigDecimalCoercer {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	public BigDecimal coerce(Object obj) {
		BigDecimal retval = null;
		if (obj != null) {
			if (Double.class.isAssignableFrom(obj.getClass())) {
				retval = new BigDecimal((Double) obj);
			}
			else if (Float.class.isAssignableFrom(obj.getClass())) {
				retval = new BigDecimal((Float) obj);
			}
			else if (Integer.class.isAssignableFrom(obj.getClass())) {
				retval = new BigDecimal((Integer) obj);
			}
			else if (String.class.isAssignableFrom(obj.getClass())) {
				retval = new BigDecimal((String) obj);
			}
			else if (BigDecimal.class.isAssignableFrom(obj.getClass())) {
				retval = (BigDecimal) obj;
			} else {
				throw new IllegalArgumentException("unsupported class " + obj.getClass());
			}
		}

		return retval;
	}
}
