package org.javautil.text;

import java.util.Set;

public interface WordExtractor {

	void setExcludeWords(Set<String> excludeSet);

	String[] getWords(String text);

	// TODO document
    String getConcatenatedString(String[] strings);
}
