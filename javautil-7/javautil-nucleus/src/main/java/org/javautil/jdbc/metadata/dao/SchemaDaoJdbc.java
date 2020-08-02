package org.javautil.jdbc.metadata.dao;

import org.javautil.io.IOUtils;
import org.javautil.jdbc.metadata.DatabaseMetadataFactory;
import org.javautil.jdbc.metadata.Schema;
import org.javautil.jdbc.metadata.SchemaImpl;
import org.javautil.jdbc.metadata.dto.JsonSchemaTable;
import org.javautil.json.JsonSerializerJackson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * 
 * @author jjs
 * @version "$Revision: 1.2 $"
 */
public class SchemaDaoJdbc {

	private final Schema           schema       = new SchemaImpl();

	private String                 schemaName;
	private String                 tablePattern = "%";
	private final DatabaseMetaData meta;
	private final Connection       conn;
	private final String           catalog;
	private final Logger           logger       = LoggerFactory.getLogger(SchemaDaoJdbc.class);

	public SchemaDaoJdbc(final Connection conn, final String schemaName, final String catalog, final String tablePattern)
	    throws SQLException {
		if (conn == null) {
			throw new IllegalArgumentException("conn is null");
		}
		if (schemaName == null) {
			throw new IllegalArgumentException("schemaName is null");
		}
		this.conn = conn;
		meta = DatabaseMetadataFactory.getDatabaseMetadata(conn);

		this.schemaName = schemaName;
		this.catalog = catalog;
		this.tablePattern = tablePattern;
	}

	public void populateTables() throws SQLException {
		if (meta == null) {
			throw new IllegalStateException("meta is null");
		}
		if (schemaName == null) {
			throw new IllegalStateException("schemaName is null");
		}
		logger.info("schemaName: " + schemaName + " catalog: " + catalog);
		TableDaoJdbc dao = new TableDaoJdbc(conn, meta, schemaName, catalog, tablePattern);
		dao.process();
		schema.setTables(dao.getDatabaseTables());
	}

	public void setSchemaName(final String schemaName) {
		this.schemaName = schemaName;
	}

	public boolean canGetFunctions() {

		return false;
	}

	public boolean canGetPackageBodies() {
		return false;
	}

	public boolean canGetPackageSpecifications() {
		return false;
	}

	public boolean canGetProcedures() {
		return false;
	}

	public boolean canGetTriggers() {
		return false;
	}

	public boolean canGetViewSource() {
		return false;
	}

	/**
	 * @return the schema
	 */
	public Schema getSchema() {
		return schema;
	}

	public TreeMap<String, JsonSchemaTable> getJsonSchemaTablesMap() {
		TreeMap<String, JsonSchemaTable> m = new TreeMap();
		for (Entry<String, org.javautil.jdbc.metadata.Table> e : schema.getTables().entrySet()) {
			m.put(e.getKey(), new JsonSchemaTable(e.getValue()));
		}
		return m;
	}

	public String getJsonSchema() {
		JsonSerializerJackson dillon = new JsonSerializerJackson();
		return dillon.toJsonPretty(getJsonSchemaTablesMap());

	}

	public void writeJsonSchema(File f) throws IOException {
		IOUtils.writeString(f, getJsonSchema());
	}



}
