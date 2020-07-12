package org.javautil.text;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import org.javautil.core.sql.Binds;
import org.javautil.core.text.SimpleDateFormatFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jcmdline.StringParam;

public class BindsFactory {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private final static   SimpleDateFormat formatter = SimpleDateFormatFactory.getYyyyDashMmDashDd();

	private Pattern pattern = Pattern.compile ("((?:19|20)\\d\\d)[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])");

	private static final HashMap<String, Object> hardcode = new HashMap<String, Object>() {{
		put("false",Boolean.FALSE);
		put("true",Boolean.TRUE);
		put("null",null);
	}		};

	public Binds  getStringParamBinds(List<String> args)  {
		Binds binds = new Binds();
		if (args == null) { 
			logger.warn("args is null");
		} else {
			logger.info("StringParam is {} ", args.getClass().getName());
			Object o = args.get(0);
			logger.info("o is {} {}", o,o.getClass());

			for (String wtf : args) {
				logger.debug("wtf {}",wtf);
				NamedObject no = getNamedObject(wtf);
				binds.put(no.getName(),no.getObject());
			}
		}

		return binds;
	}

	public Binds  getBinds(Collection<String> args)  {
		Binds binds = new Binds();
		for (String arg : args) {
			NamedObject no = getNamedObject(arg);
			binds.put(no.getName(),no.getObject());
		}
		return binds;
	}

	public NamedObject getNamedObject (String nameValue) {
		if (nameValue == null) {
			throw new IllegalArgumentException("nameValue is null");
		}
		if (nameValue.length() < 4) {
			throw new IllegalArgumentException("nameValue must be name = and value, at least 3 characters");
		}
		int index = nameValue.indexOf("=");
		if (index == -1) {
			throw new IllegalArgumentException("nameValue must be name = and value, at least 3 characters");
		}

		String name = nameValue.substring(0,index);
		String objstr = nameValue.substring(index + 1);
		Object object = asObject(objstr);
		return new NamedObject(name,object);
	}

	public boolean isDatePattern(String str) {
		return pattern.matcher(str).matches();
	}

	public  Date asDate(String str) throws ParseException {
		Date retval = null;

		//		try {
		if (isDatePattern(str)) {
			retval = formatter.parse(str);
		}
		//			} catch (ParseException e) {
		//		((?:19|20)\d\d)[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12]
		//			}
		return retval;
	}

	public  BigDecimal asBigDecimal(String str) throws ParseException {
		BigDecimal retval = null;

		try {
			retval = new BigDecimal(str);

		} catch (NumberFormatException e) {
			//		((?:19|20)\d\d)[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12]
		}
		return retval;
	}

	public  Object asObject(String str) {
		Object retval  = null;
		if (str.startsWith("\"")){
			if (! str.endsWith("\"")) {
				throw new IllegalArgumentException("starts with \" but doesn't end with one");
			} else {
				String noquote = str.substring(1,str.length() - 1);
				return noquote;
			}
		}


		if (str.length() == 10) {
			try {
				return asDate(str);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			retval = asBigDecimal(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (retval == null) {
			retval = hardcode.get(str);
		}
		if (retval == null && ! "null".equals (str)) {
			retval = str;
		}
		return retval;
	}
}
