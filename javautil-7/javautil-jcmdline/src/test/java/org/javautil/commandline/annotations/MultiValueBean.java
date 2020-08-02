package org.javautil.commandline.annotations;

import java.util.ArrayList;

import org.javautil.commandline.BaseArgumentBean;
import org.javautil.commandline.ParamType;

public class MultiValueBean extends BaseArgumentBean {

	@Optional
	@MultiValue(type = ParamType.STRING)
	private ArrayList<String> words;

	public ArrayList<String> getWords() {
		return words;
	}

	public void setWords(final ArrayList<String> words) {
		this.words = words;
	}

}
