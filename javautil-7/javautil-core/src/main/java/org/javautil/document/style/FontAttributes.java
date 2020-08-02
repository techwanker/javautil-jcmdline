package org.javautil.document.style;

import java.util.Set;

/**
 * Interface describing additional feature settings that can be applied to font
 * rendering in order to utilize document or format specific features. Features
 * that can be replicated across multiple document formats are not here,
 * instead, they can be found as part of the Style and StyleDefinition classes.
 * 
 */
public interface FontAttributes {

	String BOLDNESS            = "boldNess";
	/**
	 * Represents an underline style (single, double, dotted...)
	 */
    String KEY_UNDERLINE_STYLE = "underlineStyle";

	/**
	 * Determines if word wrapping style is available (true, false)
	 */
    String KEY_WORD_WRAP       = "wordWrap";

	/**
	 * Returns all attribute names currently defined
	 * 
	 * @return The keys
	 */
    Set<String> keySet();

	/**
	 * Defines an additional value for an attributeName, returning the previous set
	 * value
	 * 
	 * @param fontAttributeName  the attribute name
	 * @param fontAttributeValue the attribute value
	 * @return TODO
	 */
    String put(String fontAttributeName, String fontAttributeValue);

	/**
	 * Returns a previous set value for an attributeName
	 * 
	 * @param fontAttributeName the font attribute name
	 * @return TODO
	 */
    String get(String fontAttributeName);

	/**
	 * Copies all attributes into a new instance
	 * 
	 * @return FontAttributes
	 */
    FontAttributes copyOf();

}
