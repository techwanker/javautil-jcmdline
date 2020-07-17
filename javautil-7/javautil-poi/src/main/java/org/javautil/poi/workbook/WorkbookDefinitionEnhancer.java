package org.javautil.poi.workbook;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import org.javautil.core.workbook.BindDefinitions;
import org.javautil.core.workbook.WorkbookDefinition;
import org.javautil.core.workbook.Worksheet;
import org.javautil.dataset.ColumnMetadata;
import org.javautil.dataset.DatasetMetadata;
import org.javautil.dataset.MatrixDataset;
import org.javautil.sql.Binds;
import org.javautil.sql.SqlStatement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class WorkbookDefinitionEnhancer {

	private Logger logger = LoggerFactory.getLogger(getClass());
	private Connection conn;
	private WorkbookDefinition workbookDefinition;
	private Binds binds;
	private LinkedHashMap<String,SqlStatement> sqlStatements = new LinkedHashMap<>();
	private WorkbookDefinition outDefinition;


	private WorkbookDefinitionEnhancerArguments args;
	public WorkbookDefinitionEnhancer(WorkbookDefinitionEnhancerArguments args			) { 
					//throws JsonParseException, JsonMappingException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		this.args = args;
		workbookDefinition = WorkbookDefinition.getWorkbookDefinition(args.getInfile());
		outDefinition = new WorkbookDefinition(workbookDefinition);
		
	}
	
	public void process() throws SQLException {
		LinkedHashMap<String, Worksheet> sheets = workbookDefinition.getWorksheets();
		for (Worksheet sheet: sheets.values()) {
			SqlStatement ss = new SqlStatement(sheet.getSql());
			sqlStatements.put(sheet.getName(),new SqlStatement(sheet.getSql()));
		}
		
		BindDefinitions allBindDefs = new BindDefinitions(workbookDefinition.getBindDefinitions(),sqlStatements);
		outDefinition.setBindDefinitions(allBindDefs);
		List<MatrixDataset> datasets = getDataSets(sqlStatements.values(),binds);
		
		for (MatrixDataset ds : datasets) {
			DatasetMetadata md = ds.getMetadata();
			ArrayList<ColumnMetadata> mdCols = md.getColumnMetadata();
		}
	}
	
	public List<MatrixDataset> getDataSets(Collection<SqlStatement> statements, Binds binds) throws SQLException {
		ArrayList<MatrixDataset> datasets = new ArrayList<>();
		for (SqlStatement stmt : statements) {
			MatrixDataset matrix = stmt.getAsMatrixDataset(binds);
			datasets.add(matrix);
		}
		return datasets;
		
	}


}
