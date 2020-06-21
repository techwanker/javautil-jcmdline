package com.pacificdataservices.diamond.planning.marshall;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.TreeMap;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GenerateMockData {

	private Logger logger = LoggerFactory.getLogger(getClass());
	private Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private StringBuilder sb;

	void emit(String text) {
		sb.append(text);
		sb.append("\n");
	}

	public String getCollectionName(String clazzName) {
		return clazzName.substring(0, 1).toLowerCase() + clazzName.substring(1) + "s";
	}

	public String getMethodName(String clazzName) {
		return "List<" + clazzName + "> " + "get" + clazzName.substring(0, 1).toUpperCase() + clazzName.substring(1)
				+ "s() {";
	}

	public String getSetter(String fieldName) {
		return "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
	}

	public String getGetterMethodName(String fieldName) {
		return "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
	}

	public Method getGetter(@SuppressWarnings("rawtypes") Class clazz, Field field) {
		Method retval = null;
		String getterMethodName = getGetterMethodName(field.getName());
		for (Method method : clazz.getMethods()) {
			if (method.getName().equals(getterMethodName)) {
				retval = method;
				break;
			}
		}
		return retval;
	}

	void trace(String text) {
		// System.out.println(text);
	}

	public boolean skipField(Class clazz, Field field) {
		boolean retval = false;
		trace("examining field " + field.getName());

		Method getterMethod = getGetter(clazz, field);

		if (getterMethod == null) {
			trace("no getter, probably another jpa bean");
			retval = true;
		} else if (getterMethod.getAnnotation(OneToMany.class) != null) {
			trace("isOneToMany");
			retval = true;
		} else if (getterMethod.getAnnotation(ManyToOne.class) != null) {
			trace("is ManyToOne");
			retval = true;
		}
		return retval;
	}

	public String toJson(Collection<? extends Object> list) {
		sb = new StringBuilder();
		sb.append("[\n");
		for (Object o : list) {
			sb.append(toJson(o));
			sb.append("\n");
		}
		sb.append("\n]");
		return sb.toString();
	}

	public String generateCollection(Collection<? extends Object> list, @SuppressWarnings("rawtypes") Class clazz) {
		sb = new StringBuilder();
		String name = clazz.getSimpleName();
		String collectionName = getCollectionName(name);
		emit(getMethodName(name));
		emit("ArrayList<" + name + "> " + collectionName + " = new ArrayList<" + name + ">();");
		emit("    " + name + " obj = new " + name + "();\n");
		for (Object o : list) {
			generate(o, collectionName);
		}
		emit("    		return " + collectionName);
		emit("    ;");
		return sb.toString();
	}

	public String toJson(Object anObject) {
		String className = anObject.getClass().getSimpleName();
		emit("\n\n");

		Class current = anObject.getClass();

		TreeMap<String, Object> nameValue = new TreeMap<String, Object>();

		do {

			for (Field field : current.getDeclaredFields()) {
				if (skipField(current, field)) {
					trace("skipping " + field.getName());
					continue;
				}

				field.setAccessible(true); // You might want to set modifier to
											// public first.
				Object value = null;
				try {
					value = field.get(anObject);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}

				if (value != null) {
					nameValue.put(field.getName(), value);
				}

			}
			current = current.getSuperclass();
		} while (current.getSuperclass() != null);
		String json = gson.toJson(nameValue);
		return json;
	}

	public String generate(Object anObject, String collectionName) {
		String className = anObject.getClass().getSimpleName();
		emit("\n\n");

		Class current = anObject.getClass();

		do {

			for (Field field : current.getDeclaredFields()) {
				if (skipField(current, field)) {
					trace("skipping " + field.getName());
					continue;
				}

				field.setAccessible(true); // You might want to set modifier to
											// public first.
				Object value = null;
				try {
					value = field.get(anObject);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}

				String setter = getSetter(field.getName());
				if (value != null) {
					if (value instanceof String) {
						String quote = "\"";
						emit("    obj." + setter + "(" + quote + value.toString() + quote + ");");
					} else if (value instanceof Date) {
						Date d = (Date) value;
						int yr = d.getYear();
						int month = d.getMonth();
						int day = d.getDate();
						emit("    obj." + setter + "(new Day(" + yr + "," + month + "," + day + "));");
					}

					else if (value instanceof BigDecimal) {
						emit("    obj." + setter + "(new BigDecimal(" + value + "));");
					} else {
						emit("    obj." + setter + "(" + value + ");");
					}
				} else {
					emit("    //field null   " + field.getName());
				}

			}
			current = current.getSuperclass();
		} while (current.getSuperclass() != null);
		emit("   " + collectionName + ".add(obj);");
		return null;
	}
}
