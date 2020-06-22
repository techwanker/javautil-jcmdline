package org.javautil.xml;

public class XmlTagHelper {

	public static String getTagName(String tag) {
		final StringBuilder result = new StringBuilder();

		for (int i = 0; i < tag.length(); i++) {
			char character = tag.charAt(i);

			switch (character) {
			case '<':
				result.append("&lt;");
				break;
			case '>':
				result.append("&gt;");
				break;
			case '\"':
				result.append("&quot;");
				break;
			case '\'':
				result.append("&#039;");
				break;
			case '\\':
				result.append("&#092;");
				break;
			case '&':
				result.append("&amp;");
				break;
			case ' ':
				break;
			default:
				result.append(character);
			}

			// character = iterator.next();
		}
		return result.toString();
	}
}
