package org.javautil.text;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Pattern;

import org.javautil.text.SimpleDateFormatter;

public class NamedObject {

		private final String name;
		
		private final Object object;

		public NamedObject (String name, Object object) {
			this.name = name;
			this.object = object;
		}

		public String getName() {
			return name;
		}

		public Object getObject() {
			return object;
		}
}
	
