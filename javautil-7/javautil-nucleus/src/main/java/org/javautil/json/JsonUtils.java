package org.javautil.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.yaml.snakeyaml.Yaml;

public class JsonUtils {

	private final Yaml yaml       = new Yaml();

	private final Gson gson       = new Gson();

	private final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

	public String yamlToJson(String yamlString) {

		Object yamlObj = yaml.load(yamlString);
		return gson.toJson(yamlObj);
	}

	public String yamlToPrettyJson(String yamlString) {

		Object yamlObj = yaml.load(yamlString);
		return prettyGson.toJson(yamlObj);
	}

}
