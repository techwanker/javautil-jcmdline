package org.javautil.dataset;

public interface CrosstabbedDataset {
	/**
	 * The values used to crosstab this dataset TODO may not be accurate after
	 * adornment or injection
	 * 
	 * @return the crosstabColumns
	 */
	CrosstabColumns getCrosstabColumns();

	void setCrosstabColumns(CrosstabColumns crosstabColumns);
}
