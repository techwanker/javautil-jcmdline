package org.javautil.document.style;

import java.awt.Color;
import java.awt.Font;

import org.javautil.lang.reflect.ReflectUtils;

/**
 * A simple implementation of Style that provides bean methods for manipulating
 * properties as described in the interface.
 * 
 */
public class StyleImpl implements Style {

	private String              name;

	private Font                font;

	private FontAttributes      fontAttributes;

	private Color               fontColor;

	private Borders             borders;

	private VerticalAlignment   verticalAlignment;

	private HorizontalAlignment horizontalAlignment;

	private Color               backgroundColor;

	private String              formatMask;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public Font getFont() {
		return font;
	}

	@Override
	public void setFont(final Font font) {
		this.font = font;
	}

	@Override
	public VerticalAlignment getVerticalAlignment() {
		return verticalAlignment;
	}

	@Override
	public void setVerticalAlignment(final VerticalAlignment verticalAlignment) {
		this.verticalAlignment = verticalAlignment;
	}

	@Override
	public HorizontalAlignment getHorizontalAlignment() {
		return horizontalAlignment;
	}

	@Override
	public void setHorizontalAlignment(final HorizontalAlignment horizontalAlignment) {
		this.horizontalAlignment = horizontalAlignment;
	}

	@Override
	public Color getBackgroundColor() {
		return backgroundColor;
	}

	@Override
	public void setBackgroundColor(final Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	@Override
	public String getFormatMask() {
		return formatMask;
	}

	@Override
	public void setFormatMask(final String formatMask) {
		this.formatMask = formatMask;
	}

	@Override
	public Color getFontColor() {
		return fontColor;
	}

	@Override
	public void setFontColor(final Color fontColor) {
		this.fontColor = fontColor;
	}

	@Override
	public FontAttributes getFontAttributes() {
		return fontAttributes;
	}

	@Override
	public void setFontAttributes(final FontAttributes fontAttributes) {
		this.fontAttributes = fontAttributes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	// this was generated by Eclipse
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((backgroundColor == null) ? 0 : backgroundColor.hashCode());
		result = prime * result + ((font == null) ? 0 : font.hashCode());
		result = prime * result + ((fontAttributes == null) ? 0 : fontAttributes.hashCode());
		result = prime * result + ((fontColor == null) ? 0 : fontColor.hashCode());
		result = prime * result + ((formatMask == null) ? 0 : formatMask.hashCode());
		result = prime * result + ((horizontalAlignment == null) ? 0 : horizontalAlignment.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((verticalAlignment == null) ? 0 : verticalAlignment.hashCode());
		result = prime * result + ((borders == null) ? 0 : borders.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	// this was generated by eclipse
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final StyleImpl other = (StyleImpl) obj;
		if (backgroundColor == null) {
			if (other.backgroundColor != null) {
				return false;
			}
		} else if (!backgroundColor.equals(other.backgroundColor)) {
			return false;
		}
		if (font == null) {
			if (other.font != null) {
				return false;
			}
		} else if (!font.equals(other.font)) {
			return false;
		}
		if (fontAttributes == null) {
			if (other.fontAttributes != null) {
				return false;
			}
		} else if (!fontAttributes.equals(other.fontAttributes)) {
			return false;
		}
		if (fontColor == null) {
			if (other.fontColor != null) {
				return false;
			}
		} else if (!fontColor.equals(other.fontColor)) {
			return false;
		}
		if (formatMask == null) {
			if (other.formatMask != null) {
				return false;
			}
		} else if (!formatMask.equals(other.formatMask)) {
			return false;
		}
		if (horizontalAlignment == null) {
			if (other.horizontalAlignment != null) {
				return false;
			}
		} else if (!horizontalAlignment.equals(other.horizontalAlignment)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (verticalAlignment == null) {
			if (other.verticalAlignment != null) {
				return false;
			}
		} else if (!verticalAlignment.equals(other.verticalAlignment)) {
			return false;
		}
		if (borders == null) {
			if (other.borders != null) {
				return false;
			}
		} else if (!borders.equals(other.borders)) {
			return false;
		}
		return true;
	}

	@Override
	public Style copyOf() {
		final StyleImpl copy = new StyleImpl();
		copy.setBackgroundColor(backgroundColor);
		copy.setFont(font);
		copy.setFontColor(fontColor);
		if (fontAttributes != null) {
			copy.setFontAttributes(fontAttributes.copyOf());
		}
		copy.setFormatMask(formatMask);
		copy.setHorizontalAlignment(horizontalAlignment);
		copy.setName(name);
		copy.setVerticalAlignment(verticalAlignment);
		if (borders != null) {
			copy.setBorders(borders.copyOf());
		}
		return copy;
	}

	@Override
	public String toString() {
		return ReflectUtils.listPropertiesAsString(this);
	}

	@Override
	public void applyAttributes(final Style style) {
		if (style.getName() != null) {
			this.name = style.getName();
		}
		if (style.getFont() != null) {
			this.font = style.getFont();
		}
		if (style.getFontAttributes() != null) {
			this.fontAttributes = style.getFontAttributes();
		}
		if (style.getFontColor() != null) {
			this.fontColor = style.getFontColor();
		}
		if (style.getVerticalAlignment() != null) {
			this.verticalAlignment = style.getVerticalAlignment();
		}
		if (style.getHorizontalAlignment() != null) {
			this.horizontalAlignment = style.getHorizontalAlignment();
		}
		if (style.getBackgroundColor() != null) {
			this.backgroundColor = style.getBackgroundColor();
		}
		if (style.getFormatMask() != null) {
			this.formatMask = style.getFormatMask();
		}
		if (style.getBorders() != null) {
			this.borders = style.getBorders();
		}
	}

	public Style getStyle(final Style... styles) {
		if (styles == null || styles.length == 0) {
			throw new IllegalArgumentException("A style must be provided");
		}
		final Style s = styles[0].copyOf();
		for (final Style style : styles) {
			s.applyAttributes(style);
		}
		return s;
	}

	@Override
	public Borders getBorders() {
		return borders;
	}

	@Override
	public void setBorders(final Borders borders) {
		this.borders = borders;
	}

}
