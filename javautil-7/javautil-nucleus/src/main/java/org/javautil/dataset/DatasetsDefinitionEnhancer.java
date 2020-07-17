package org.javautil.dataset;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.javautil.io.IOUtils;
import org.javautil.sql.Binds;
import org.javautil.sql.DataSourceFactory;
import org.javautil.sql.SqlStatement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.error.YAMLException;
import java.io.Closeable;

public class DatasetsDefinitionEnhancer {

	private Logger logger = LoggerFactory.getLogger(getClass());
	private Connection conn;
	private DatasetsDefinition inDefinition;
	private Binds binds;
	private LinkedHashMap<String,SqlStatement> sqlStatements = new LinkedHashMap<>();
	private DatasetsDefinition outDefinition;
	private DataSourceFactory dsf = new DataSourceFactory();

	private Map<String,Connection> connectionByName = new HashMap<String, Connection>();
	private Map<String,DataSource> datasourcebyName = new HashMap<>();

	private DataSource ds;


	private DatasetsDefinitionEnhancerArguments args;
	public DatasetsDefinitionEnhancer(DatasetsDefinitionEnhancerArguments args			) { 
		//throws JsonParseException, JsonMappingException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		this.args = args;
		this.inDefinition = DatasetsDefinition.getDatasetsDefinition(args.getInfile());
		this.outDefinition = new DatasetsDefinition(inDefinition);
		this.binds = args.getBinds();
	}

	void msg(String text) {
		System.out.println(text);
	}

	public void doProcess() throws IOException, SQLException, PropertyVetoException {
		try {
			process();
		} finally {
			if (ds != null) {
				((Closeable) ds).close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void process() throws SQLException, PropertyVetoException, IOException {
		LinkedHashMap<String, DatasetDefinition> datasetDefs = inDefinition.getDatasetDefinitions();
		int i = 0;
		
		DataSource ds = dsf.getDatasource(args.getDatasourceName());
		Connection conn = ds.getConnection();
		for (DatasetDefinition stmt: datasetDefs.values()) {
			SqlStatement ss = new SqlStatement(conn,stmt.getSql());
			sqlStatements.put(stmt.getName(),ss);
			if (args.getVerbosity() > 1) {
				msg(String.format("%d %s", i++, stmt.getSql()));
			}
			MatrixDataset dataset = ss.getAsMatrixDataset(binds);
			MutableDatasetMetadata mdm = dataset.getMetadata();
			List<ColumnMetadata> columns = mdm.getColumnMetadata();
	//		stmt.setColumns(columns);
			for (ColumnMetadata col : columns) {
				if (col.getExcelFormat() == null) {
					col.setExcelFormat(ColumnMetadata.defaultExcelFormat(col.getDataType(), col.getPrecision(), col.getScale()));
				}
			}
		}

		BindDefinitions allBindDefs = new BindDefinitions(inDefinition.getBindDefinitions(),sqlStatements);
		outDefinition.setBindDefinitions(allBindDefs);
		if (args.getVerbosity() > 1) {
			msg("binds" + binds);
		}
		
//		List<MatrixDataset> datasets = getDataSets(sqlStatements.values(),binds);
//		for (DatasetDefinition dsdef : datasetDefs.values()) {
//			for (SqlStatement stmt : statements) {
//				MatrixDataset matrix = stmt.getAsMatrixDataset(binds);
//				datasets.add(matrix);
//			}
//			return datasets;
//		}
//		for (MatrixDataset mds : datasets) {
//			DatasetMetadata md = mds.getMetadata();
//			if (args.getVerbosity() > 0) {
//				for (ColumnMetadata cm : md.getColumnMetadata()) {
//					msg(cm.toString()); 
//				}
//			}
//		}
		Yaml yaml = new Yaml();
		String outYaml = yaml.dump(outDefinition);
		IOUtils.writeString(args.getOutfile(), outYaml);
		
	}


	private DataSource getDataSource(String name) throws PropertyVetoException {
		DataSource retval = datasourcebyName.get(name);
		if (retval == null) {
			retval = dsf.getDatasource(name);
		}
		return retval;

	}

	private Connection getConnection(String name) throws SQLException, PropertyVetoException {
		Connection retval = connectionByName.get(name);
		if (retval == null) {
			DataSource ds = getDataSource(name);
			Connection conn = ds.getConnection();
			connectionByName.put(name,conn);

		}    
		return retval;
	}

//	public MatrixDataset getDataSet(DatasetDefinition def, Connection conn, Binds binds) {
//		String datasourceName = def.getDatasourceName();
//		Connection conn =getConnection(def.getDatasourceName());
//
//				SqlStatement stmt = new SqlStatement(conn, def.getSql());
//	}



	public List<MatrixDataset> getDataSets(Collection<SqlStatement> statements, Binds binds) throws SQLException {
		ArrayList<MatrixDataset> datasets = new ArrayList<>();
		for (SqlStatement stmt : statements) {
			MatrixDataset matrix = stmt.getAsMatrixDataset(binds);
			datasets.add(matrix);
		}
		return datasets;

	}

	public static void main(String[] args) throws SQLException, PropertyVetoException, IOException {
		DatasetsDefinitionEnhancerArguments parms = DatasetsDefinitionEnhancerArguments.processArguments(args);
		DatasetsDefinitionEnhancer enhancer = new DatasetsDefinitionEnhancer(parms);
		enhancer.process();
	}

}