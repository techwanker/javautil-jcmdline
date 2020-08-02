
package org.javautil.dataset;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.javautil.io.FileUtil;
import org.javautil.sql.Binds;
import org.javautil.sql.DataSourceFactory;
import org.javautil.sql.SqlStatement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.util.Map.Entry;

//import org.javautil.core.text.YamlUtils;
//import org.javautil.io.FileUtil;

public class DatasetsDefinition {

	@SerializedName("name")
	@Expose
	private String                                name;
	@SerializedName("description")
	@Expose
	private String                                description;
	@SerializedName("narrative")
	@Expose
	private String                                narrative;
	@SerializedName("connectionName")
	@Expose
	private String                                connectionName;
	private LinkedHashMap<String, ColumnMetadata> columns;
	@SerializedName("worksheets")
	@Expose
	private LinkedHashMap<String, DatasetDefinition>      datasetDefinitions = null;

	//	private Map<String, BindDefinition> bindDefinitions;
	private BindDefinitions                       bindDefinitions;
	private File                                  file;
	
	private final DataSourceFactory dsf = new DataSourceFactory();
	
	private final HashMap<String,Connection> connectionByName = new HashMap<>();
	private HashMap<String,DataSource> datasourcebyName;

	//	@SerializedName("binds")
	//	@Expose
	//	private List<Bind> binds = null;

	@SuppressWarnings("unused")
	private transient static Logger               logger     = LoggerFactory.getLogger(DatasetsDefinition.class);

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public DatasetsDefinition() {
	}

	public DatasetsDefinition(String name, String description, String narrative, String connectionName,
			LinkedHashMap<String, ColumnMetadata> columns, 
			LinkedHashMap<String, DatasetDefinition> datasetDefinitions,
			BindDefinitions bindDefinitions) {
		super();
		this.name = name;
		this.description = description;
		this.narrative = narrative;
		this.connectionName = connectionName;
		this.columns = columns;
		this.datasetDefinitions = datasetDefinitions;
		this.bindDefinitions = bindDefinitions;
	}

	public DatasetsDefinition(DatasetsDefinition wd) {
		this.name = wd.getName();
		this.description = wd.getDescription();
		this.narrative = wd.getNarrative();
		this.connectionName = wd.getConnectionName();
		
		columns  = new 	LinkedHashMap<String, ColumnMetadata>();
		for (Entry<String, ColumnMetadata> e : wd.getColumns().entrySet()) {
			ColumnMetadata cmd = new ColumnMetadata(e.getValue());
			columns.put(e.getKey(),cmd);
		}
		
		this.datasetDefinitions = wd.getDatasetDefinitions();
		this.bindDefinitions =  new BindDefinitions(wd.getBindDefinitions());
	}

	public static DatasetsDefinition getDatasetsDefinition(InputStream is) { 
		if (is == null) {
			throw new IllegalArgumentException("is is null");
		}
		Yaml yaml = new Yaml();
		DatasetsDefinition retval = yaml.loadAs(is, DatasetsDefinition.class);
		if (retval == null) {
			throw new IllegalStateException("loading inputStream {} resulted in null from yaml.loadAs"
					);
		}
		retval.populateColumnNames();
		return retval;
	}

	public static DatasetsDefinition getDatasetsDefinition(File file) 
	{
		if (file == null) {
			throw new IllegalArgumentException("file is null");
		}
		if (!file.canRead()) {
			throw new IllegalArgumentException("can't read " + file.getAbsolutePath());
		}
		FileInputStream is;
		try {
			is = new FileInputStream(file.getAbsoluteFile());
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		DatasetsDefinition retval = getDatasetsDefinition(is);
		retval.file = file;
		//	retval.populateColumnNames();
		return retval;
	}

	void populateColumnNames() {
		if (columns == null) {
			logger.warn("populateColumnNames columns is null");
		} else {
			for (Entry<String, ColumnMetadata> c : columns.entrySet()) {
				if (c == null) {
					logger.error("columns k {} v {}", c);
					throw new IllegalStateException("wutinthelivinfaq");
				}
				String k = c.getKey();
				ColumnMetadata col = c.getValue();
				if (col.getColumnName() == null) {
					col.setColumnName(k);
				}
			}
		}
	}
	
	
	private DataSource getDataSource(String name) throws PropertyVetoException {
		DataSource retval = datasourcebyName.get(name);
		if (retval == null) {
			retval = dsf.getDatasource(name);
		}
		return retval;

	}

	@SuppressWarnings("unused")
	private Connection getConnection(String name) throws SQLException, PropertyVetoException {
		Connection retval = connectionByName.get(name);
		if (retval == null) {
			DataSource ds = getDataSource(name);
			Connection conn = ds.getConnection();
			connectionByName.put(name,conn);

		}    
		return retval;
	}

	public MatrixDataset getDataSet(DatasetDefinition def, Connection conn,Binds binds) throws SQLException {
		String datasourceName = def.getDatasourceName();
				SqlStatement stmt = new SqlStatement(conn, def.getSql());
		return new MatrixDataset(stmt,binds);
	}



	public List<MatrixDataset> getDataSets(Collection<SqlStatement> statements, Binds binds) throws SQLException {
		ArrayList<MatrixDataset> datasets = new ArrayList<>();
		for (SqlStatement stmt : statements) {
			MatrixDataset matrix = stmt.getAsMatrixDataset(binds);
			datasets.add(matrix);
		}
		return datasets;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DatasetsDefinition withName(String name) {
		this.name = name;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DatasetsDefinition withDescription(String description) {
		this.description = description;
		return this;
	}

	public String getNarrative() {
		return narrative;
	}

	public void setNarrative(String narrative) {
		this.narrative = narrative;
	}

	public DatasetsDefinition withNarrative(String narrative) {
		this.narrative = narrative;
		return this;
	}

	public String getConnectionName() {
		return connectionName;
	}

	public void setConnectionName(String connectionName) {
		this.connectionName = connectionName;
	}

	public DatasetsDefinition withConnectionName(String connectionName) {
		this.connectionName = connectionName;
		return this;
	}

	public BindDefinitions getBindDefinitions() {
		return bindDefinitions;
	}

	public void setBindDefinitions(BindDefinitions bindDefinitions) {
		this.bindDefinitions = bindDefinitions;
	}

	public LinkedHashMap<String, ColumnMetadata> getColumns() {
		return columns;
	}

	public void setColumns(LinkedHashMap<String, ColumnMetadata> columns) {
		this.columns = columns;
	}


	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		DatasetsDefinition.logger = logger;
	}

	public void setDatasetDefinitions(LinkedHashMap<String, DatasetDefinition> datasetDefinitions) {
		this.datasetDefinitions = datasetDefinitions;
	}
	public LinkedHashMap<String, DatasetDefinition> getDatasetDefinitions() {
		return datasetDefinitions;
	}

	public String getFileAsString() throws IOException {
		String filePath = file.getCanonicalPath();
		return FileUtil.getAsString(filePath);
	}
	
	public void noise(String param) {
		ColumnMetadata cm = new ColumnMetadata();
		
	}
	public String toYaml() {
		return new Yaml().dump(this);
	}
}
