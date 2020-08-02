package org.javautil.dataset.render.typewriter;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Map;

import org.javautil.document.style.Style;

public interface TypewriterContent<R, C> {

	Map<String, Style> getStylesByName();

	void setStylesByName(Map<String, Style> stylesByName);

	R getRowAt(int rowIndex, boolean createRow);

	C getCellAt(int rowIndex, int columnIndex, boolean createRow, boolean createCell);

	void setBlankCellAt(int rowIndex, int columnIndex, Style style);

	void setCellAt(int rowIndex, int columnIndex, Object data, Style style);

	void setFormulaCellAt(int rowIndex, int columnIndex, String formula, Style style);

	TypewriterRendererFactory getRendererFactory();

	Dimension getDimension();

	Rectangle getBounds();

}