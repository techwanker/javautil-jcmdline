package org.javautil.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;

public class JsonSerializerGson implements JsonSerializer {
	private static final String defaultDateFormat = "yyyy-MM-dd'T'HH:mm:ssX";
	private final Logger logger       = LoggerFactory.getLogger(getClass());
	private Gson   mapper;
	private String dateFormat = defaultDateFormat;

    private Gson   prettyMapper = new GsonBuilder().setPrettyPrinting().create();


	public JsonSerializerGson() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.javautil.core.marshall.MarshallUtils#toObjectFromJson(java.lang.String)
	 */
	@Override
	public Object toObjectFromJson(String json) {
		instantiateMapper();
		return mapper.fromJson(json, Object.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.javautil.core.marshall.MarshallUtils#toObjectFromJson(java.lang.String,
	 * java.lang.Class)
	 */
	public Object toObjectFromJson(String json, Class<?> clazz) {
		instantiateMapper();
		return mapper.fromJson(json, clazz);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.javautil.core.marshall.MarshallUtils#toMapFromJson(java.lang.String)
	 */
	@Override
	public LinkedHashMap<String, Object> toMapFromJson(String json) {
		instantiateMapper();
		return mapper.fromJson(json, LinkedHashMap.class);
	}

	@Override
	public LinkedHashMap<String, Object> toMapFromBean(Object bean) {
		String json = toJsonPretty(bean);
		return toMapFromJson(json);
	}

	public Gson getPrettyMapper() {
		if (prettyMapper == null) {
			GsonBuilder  builder = new GsonBuilder();
			builder.setDateFormat(dateFormat);
			builder.setPrettyPrinting();
			prettyMapper =  builder.create();
		}
		return prettyMapper;
	}
	@Override
	public String toJsonPretty(Object o) {
		logger.info("toJsonPretty");
		getPrettyMapper();
		String retval = prettyMapper.toJson(o);
		logger.info("pretty done");
		return retval;
	}

	@Override
	public String toJson(Object o) {
		instantiateMapper();
		return mapper.toJson(o);
	}


	@Override
	public JsonSerializer withNullValues() {
		throw new UnsupportedOperationException();
		// TODO Auto-generated method stub
		// return null;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}


	void instantiateMapper() {
		if (mapper == null) {
			GsonBuilder  builder = new GsonBuilder();
			builder.setDateFormat(dateFormat);
			mapper =  builder.create();
		}
	}
}
