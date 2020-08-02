package org.javautil.dataset.render.typewriter;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Map;

import org.javautil.document.style.Style;

public interface TypewriterRenderer {

	TypewriterBehavior getBehavior();

	void setBehavior(TypewriterBehavior behavior);

	void nextLine();

	int getRowIndex();

	void setRowIndex(int rowIndex);

	int getColumnIndex();

	void setColumnIndex(int columnIndex);

	void skip(int numberOfCells);

	void addBlank(String styleName);

	void addData(Object data, String styleName);

	void addFormula(String formula, String styleName);

	void addStyles(Map<String, Style> styles);

	Dimension getDimension();

	Rectangle getBounds();

}
