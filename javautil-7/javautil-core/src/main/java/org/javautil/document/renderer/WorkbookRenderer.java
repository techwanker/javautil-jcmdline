package org.javautil.document.renderer;

public interface WorkbookRenderer {

	void addSheet(String sheetName);

	String getCellAddress(int rowIndex, int columnIndex);

	String getCellRange(int rowIndexStart, int rowIndexEnd, int columnIndexStart, int columnIndexEnd);

	void setRowHeight(int rowIndex, int height);

	void setColumnWidth(int columnIndex, int width);

	void mergeCellRange(int rowIndexStart, int rowIndexEnd, int columnIndexStart, int columnIndexEnd);
}