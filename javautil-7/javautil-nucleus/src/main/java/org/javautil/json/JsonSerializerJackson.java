package org.javautil.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.LinkedHashMap;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;

//https://www.baeldung.com/jackson-ignore-null-fields
// ObjectMapper.enable(SerializationFeature.INDENT_OUTPUT); 

public class JsonSerializerJackson implements JsonSerializer {
	private final ObjectMapper mapper = new ObjectMapper();

	// ObjectMapper.enable(SerializationFeature.INDENT_OUTPUT);

	public JsonSerializerJackson() {

		// mapper.setSerializationInclusion(Include.NON_NULL);
		// mapper.configure(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT,
		// true)
		// mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.javautil.core.marshall.MarshallUtils#toMap(java.lang.Object)
	 */
	@Override
	public LinkedHashMap<String, Object> toMapFromBean(Object bean) {
		return mapper.convertValue(bean, LinkedHashMap.class);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.javautil.core.marshall.MarshallUtils#toObjectFromJson(java.lang.String)
	 */
	@Override
	public Object toObjectFromJson(String json) {
		return mapper.convertValue(json, Object.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.javautil.core.marshall.MarshallUtils#toObjectFromJson(java.lang.String,
	 * java.lang.Class)
	 */
	@Override
	public Object toObjectFromJson(String json, Class<?> clazz) {
		return mapper.convertValue(json, clazz);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.javautil.core.marshall.MarshallUtils#toMapFromJson(java.lang.String)
	 */
	@Override
	public LinkedHashMap<String, Object> toMapFromJson(String json) {
		return mapper.convertValue(json, LinkedHashMap.class);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.javautil.core.marshall.MarshallUtils#toJsonPretty(java.lang.Object)
	 */
	@Override
	public String toJsonPretty(Object o) {
		// Map<String,Object> map = toMap(o);
		String retval;
		try {
			retval = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
		} catch (IOException e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return retval;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.javautil.core.marshall.MarshallUtils#withNullValues()
	 */
	@Override
	public JsonSerializer withNullValues() {
		// mapper.setSerializationInclusion(Include.ALWAYS);
		return this;
	}

	@Override
	public String toJson(Object o) {
		throw new UnsupportedOperationException();
	}

}
