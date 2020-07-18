package org.javautil.commandline.examples;

import java.util.Collection;

import org.javautil.commandline.CommandLineOptionsAndArgumentsHandler;
import org.javautil.commandline.annotations.Optional;
import org.javautil.commandline.annotations.Required;

public class TrumpCrimesArguments {

	@Required
     private Integer criminalCounts;
     
     @Optional
     private Collection<String> crimes;

	public Integer getCriminalCounts() {
		return criminalCounts;
	}

	public void setCriminalCounts(Integer criminalCounts) {
		this.criminalCounts = criminalCounts;
	}

	public Collection<String> getCrimes() {
		return crimes;
	}

	public void setCrimes(Collection<String> crimes) {
		this.crimes = crimes;
	}

	public static TrumpCrimesArguments evaluateArguments(String[] args) {
		TrumpCrimesArguments argumentBean = new TrumpCrimesArguments();

		final CommandLineOptionsAndArgumentsHandler clh = new CommandLineOptionsAndArgumentsHandler(argumentBean);
		clh.setIgnoreUnrecognizedOptions(false);
		clh.setDieOnParseError(false);
		clh.evaluateArguments(args);
		if (argumentBean.getCriminalCounts() == null) {
			throw new IllegalStateException("criminalCounts is null");
		}
//		BindsFactory bf = new BindsFactory();
//		argumentBean.setBinds(bf.getStringParamBinds(argumentBean.bindPair));
//		logger.info("binds {}", argumentBean.getBinds());
		//argumentBean.bindPair = clh.getArguments();
		return argumentBean;
	}
}
