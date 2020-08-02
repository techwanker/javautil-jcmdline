package org.javautil.document.style;

import java.awt.Color;
import java.awt.Font;

// TODO eliminate the interface and convert StyleImpl
/**
 * An abstraction of a cell style.
 * 
 * Initially designed as an abstract represention of the presentation
 * information for the content of a table data
 * 
 * A Style containing java.awt and non-document specific representations of
 * style components. The java.awt.Color and java.awt.Font objects are used
 * frequently because of their good out of the box support.
 * 
 */
public interface Style {

	/**
	 * Returns the name of the style, should be unique across other style instances
	 * when contained in a DocumentStyle
	 * 
	 * @return name The name
	 */
    String getName();

	/**
	 * Sets the name of the style
	 * 
	 * @param name The name of the style
	 */
    void setName(String name);

	/**
	 * Returns the platform's native font name that is used
	 * 
	 * @return font The font
	 */
    Font getFont();

	/**
	 * Sets the name of the native font to be used
	 * 
	 * @param font The font to be used
	 */
    void setFont(Font font);

	/**
	 * Returns a set of attributes to be used in conjunction with the font and
	 * fontColor when rendering the font
	 * 
	 * @return fontAttributes the fontAttributes
	 */
    FontAttributes getFontAttributes();

	/**
	 * Sets the fontAttributes
	 * 
	 * @param fontAttributes The fontAttributes
	 */
    void setFontAttributes(FontAttributes fontAttributes);

	/**
	 * Returns the color to be used when rendering the font
	 * 
	 * @return fontColor the fontColor
	 */
    Color getFontColor();

	/**
	 * Sets the color to be used when rendering the font
	 * 
	 * @param fontColor The font color
	 */
    void setFontColor(Color fontColor);

	/**
	 * Returns the vertical alignment
	 * 
	 * @return verticalAlignment
	 */
    VerticalAlignment getVerticalAlignment();

	/**
	 * Sets the vertical alignment
	 * 
	 * @param verticalAlignment The verticalAlignment
	 */
    void setVerticalAlignment(VerticalAlignment verticalAlignment);

	/**
	 * Gets the horizontal alignment
	 * 
	 * @return horizontalAlignment
	 */
    HorizontalAlignment getHorizontalAlignment();

	/**
	 * Sets the horizontal alignment
	 * 
	 * @param horizontalAlignment The horizontalAlignment
	 */
    void setHorizontalAlignment(HorizontalAlignment horizontalAlignment);

	/**
	 * Gets the borders
	 * 
	 * @return borders the borders
	 */
    Borders getBorders();

	/**
	 * Sets the borders
	 * 
	 * @param borders The borders
	 */
    void setBorders(Borders borders);

	/**
	 * Gets the background color
	 * 
	 * @return backgroundColor the backgroundColor
	 */
    Color getBackgroundColor();

	/**
	 * Sets the background color
	 * 
	 * @param color The color to set.
	 */
    void setBackgroundColor(Color color);

	/**
	 * Gets the format mask to be used when rendering
	 * 
	 * @return formatMask the formatMask
	 */
    String getFormatMask();

	/**
	 * Sets the format mask to be used when rendering
	 * 
	 * @param formatMask The formatMask
	 */
    void setFormatMask(String formatMask);

	/**
	 * Produces a new copy of the style, that return true for the equals method
	 * 
	 * @return a copy of this style
	 */
    Style copyOf();

	void applyAttributes(Style style);

}
