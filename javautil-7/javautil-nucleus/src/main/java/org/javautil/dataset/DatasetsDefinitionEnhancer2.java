//package org.javautil.dataset;
//
//import java.beans.PropertyVetoException;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.sql.DataSource;
//
//import org.javautil.io.IOUtils;
//import org.javautil.sql.Binds;
//import org.javautil.sql.DataSourceFactory;
//import org.javautil.sql.SqlStatement;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.yaml.snakeyaml.Yaml;
//import org.yaml.snakeyaml.error.YAMLException;
//import java.io.Closeable;
//
//public class DatasetsDefinitionEnhancer2 {
//
//	private Logger logger = LoggerFactory.getLogger(getClass());
//	private Connection conn;
//	private DatasetsDefinition inDefinition;
//	private Binds binds;
//	private LinkedHashMap<String,SqlStatement> sqlStatements = new LinkedHashMap<>();
//	private DatasetsDefinition outDefinition;
//	private DataSourceFactory dsf = new DataSourceFactory();
//
//	private Map<String,Connection> connectionByName = new HashMap<String, Connection>();
//	private Map<String,DataSource> datasourcebyName = new HashMap<>();
//
//	private DataSource ds;
//
//
//	private DatasetsDefinitionEnhancerArguments args;
//
//	public DatasetsDefinitionEnhancer(DatasetsDefinitionEnhancerArguments args			) { 
//		//throws JsonParseException, JsonMappingException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
//		this.args = args;
//		this.inDefinition = DatasetsDefinition.getDatasetsDefinition(args.getInfile());
//		this.outDefinition = new DatasetsDefinition(inDefinition);
//		this.binds = args.getBinds();
//	}
//
//	void msg(String text) {
//		System.out.println(text);
//	}
//
//	public void doProcess() throws IOException, SQLException, PropertyVetoException {
//		try {
//			process();
//		} finally {
//			if (ds != null) {
//				((Closeable) ds).close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//		}
//	}
//
//	public void process() throws SQLException, PropertyVetoException, IOException {
//
//	}
//
//
//	private DataSource getDataSource(String name) throws PropertyVetoException {
//		DataSource retval = datasourcebyName.get(name);
//		if (retval == null) {
//			retval = dsf.getDatasource(name);
//		}
//		return retval;
//
//	}
//
//	@SuppressWarnings("unused")
//	private Connection getConnection(String name) throws SQLException, PropertyVetoException {
//		Connection retval = connectionByName.get(name);
//		if (retval == null) {
//			DataSource ds = getDataSource(name);
//			Connection conn = ds.getConnection();
//			connectionByName.put(name,conn);
//
//		}    
//		return retval;
//	}
//
//	public MatrixDataset getDataSet(DatasetDefinition def, Connection conn,Binds binds) throws SQLException {
//		String datasourceName = def.getDatasourceName();
//
//
//				SqlStatement stmt = new SqlStatement(conn, def.getSql());
//				MatrixDataset retval = new MatrixDataset(stmt,binds);
//				return retval;
//	}
//
//
//
//	public List<MatrixDataset> getDataSets(Collection<SqlStatement> statements, Binds binds) throws SQLException {
//		ArrayList<MatrixDataset> datasets = new ArrayList<>();
//		for (SqlStatement stmt : statements) {
//			MatrixDataset matrix = stmt.getAsMatrixDataset(binds);
//			datasets.add(matrix);
//		}
//		return datasets;
//
//	}
//
//	public static void main(String[] args) throws SQLException, PropertyVetoException, IOException {
//		DatasetsDefinitionEnhancerArguments parms = DatasetsDefinitionEnhancerArguments.processArguments(args);
//		DatasetsDefinitionEnhancer enhancer = new DatasetsDefinitionEnhancer(parms);
//		enhancer.process();
//	}
//
//}