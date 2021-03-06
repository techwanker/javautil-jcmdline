package org.javautil.commandline.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrueCrimes {

	private transient static final Logger logger = LoggerFactory.getLogger(TrueCrimes.class);

	private final TrueCrimesArguments arguments;

	public TrueCrimes(TrueCrimesArguments arguments) {
		this.arguments = arguments;
		logger.info("crimes {}", this.arguments);
	}

	public String newsNoise() {
		String newsnoise = "a total of "  + this.arguments + " crimes";
		return newsnoise; // sucesefully read into converted Integer
	}







}
