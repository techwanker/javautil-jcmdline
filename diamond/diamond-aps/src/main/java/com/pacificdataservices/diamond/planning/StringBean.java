package com.pacificdataservices.diamond.planning;

import org.javautil.hibernate.HibernateMarshallerFactory;

import com.google.gson.Gson;

public class StringBean {
	transient private Gson dillon = HibernateMarshallerFactory.getHibernateGsonWithProxyDateFormatter();
	public String asString(Object o) {
		return dillon.toJson(o);
	}
}
