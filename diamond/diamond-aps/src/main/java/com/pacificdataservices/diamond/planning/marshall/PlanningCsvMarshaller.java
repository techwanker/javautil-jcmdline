package com.pacificdataservices.diamond.planning.marshall;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.LinkedHashMap;

import org.javautil.hibernate.util.ModelToCsv;
import org.javautil.lang.reflect.ReflectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.diamond.planning.data.PlanningData;

import javassist.Modifier;

public class PlanningCsvMarshaller {

	private Writer writer;
	private Logger logger = LoggerFactory.getLogger(getClass());
	private ModelToCsv marshaller = new ModelToCsv();
	private boolean trace = false;

	public PlanningCsvMarshaller(Writer writer) throws IOException {
		if (writer == null) {
			throw new IllegalArgumentException("writer is null");
		}
		this.writer = writer;
		try {
			writer.write("instance\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	private void writeln(String text) throws IOException {
		if (text == null) {
			throw new IllegalArgumentException("text is null");
		}

		writer.write(text);
		writer.write("\n");
		writer.flush();
	}

	public void marshall(PlanningData pd) throws IOException {
		Field[] planningDataFields = pd.getClass().getDeclaredFields();
		for (Field field : planningDataFields) {
			if (trace) {
				logger.info("processing planning data " + field.getName());
			}
			if (Modifier.isTransient(field.getModifiers())) {
				if (trace) {
					logger.info("skipping transient " + field.getName());	
				}
				continue;
			}
			if (field.getName().startsWith("$SWITCH")) {
				if (trace) {
					logger.info("skipping");
				}
				continue;
			}
			field.setAccessible(true);
			String fieldName = field.getName();

			try {
				emitField(fieldName, pd);
			} catch (NoSuchFieldException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				//slogger.error("shit: ",e);
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

	public void emitField(String fieldName, PlanningData pd) throws NoSuchFieldException, SecurityException,
			IOException, IllegalAccessException,  InvocationTargetException {
		if (trace) {
		logger.info("field: " + fieldName);
		}
		Class clazz = pd.getClass();
		Field field = pd.getClass().getDeclaredField(fieldName);
		field.setAccessible(true);
		String fieldClassName = field.getType().getName();

		Method getter = ReflectUtils.getGetter(clazz, field);
		String heading = ":::" + fieldName + ":::" + fieldClassName + ":::";
		writeln(heading);
		
		if (getter == null) {
			if (trace) {
			logger.info("no getter for " + fieldClassName);
			}
		} else {
			@SuppressWarnings("rawtypes")
			Collection collection;
			try {
			    collection = (Collection) getter.invoke(pd);
			} catch (IllegalArgumentException e) {
				
				Class<?>[] types = getter.getParameterTypes();
				StringBuilder sb  = new StringBuilder();
				for (Class argtype : types) {
					sb.append(argtype);
					sb.append(" ");
				}
				logger.error("while processing " + fieldName + " " + getter.getName() +  " " + 
				sb.toString());
				
				e.printStackTrace();
				throw e;
			}

			if (collection == null) {
				if (trace) {
					logger.info(fieldClassName  + " is null, skipping");
				}
			} else {
				if (! collection.isEmpty()) {
					emitCollection(fieldName, collection);
				}
			}
		}
	}

	public void emitCollection(String collectionName, @SuppressWarnings("rawtypes") Collection collection)
			throws IOException {
		//logger.info("emitCollection begins");
		String headings = null;
		for (Object o : collection) {
			LinkedHashMap<String, Object> kv = marshaller.getAttributeNameValues(o);
			headings = marshaller.getAttributeNames(kv);
			break;
		}
		writeln(headings);

		for (Object o : collection) {
			Collection<Object> values = marshaller.getAttributeNameValues(o).values();
			String text = marshaller.toCsv(values);
			writeln(text);
		}
		//logger.info("emitCollection ends");
	}
}
