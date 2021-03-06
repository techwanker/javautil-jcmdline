package org.javautil.hibernate;

import java.beans.PropertyVetoException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.javautil.jdbc.metadata.PrimaryKey;
import org.javautil.jdbc.metadata.PrimaryKeys;
import org.javautil.jdbc.metadata.Table;
import org.javautil.jdbc.metadata.containers.DatabaseTables;
import org.javautil.jdbc.metadata.dao.TableDaoJdbc;
import org.javautil.sql.DataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenerateReveng {

	private final Connection    conn;
	private final String        catalog;
	private final String        schemaPattern;
	private final String        tablePattern;
	private static final Logger logger = LoggerFactory.getLogger(GenerateReveng.class);

	public GenerateReveng(Connection conn, String catalog, String schemaPattern, String tablePattern) {
		this.conn = conn;
		this.catalog = catalog;
		this.schemaPattern = schemaPattern;
		this.tablePattern = tablePattern;
	}

	public void write(Writer writer) throws SQLException, IOException {
//		public TableDaoJdbc(final Connection conn, final String schema,
//				String catalog, final String tablePattern)
		DatabaseMetaData meta = conn.getMetaData();
		logger.debug("write begins");
		TableDaoJdbc tableDao = new TableDaoJdbc(conn, catalog, schemaPattern, tablePattern);
		tableDao.process();
		DatabaseTables tables = tableDao.getDatabaseTables();
		System.out.println("tables.size: " + tables.size());
		logger.debug("tables size: {}", tables.size());
		for (Table table : tables.values()) {
			logger.debug("processing {}", table.getTableName());
			PrimaryKey pk = PrimaryKeys.getPrimaryKey(meta, catalog, schemaPattern, table.getTableName());
			// PrimaryKey pk = table.getPrimaryKey();

			if (pk == null) {
				logger.info("{} has no primary key", table.getTableName());
			} else {

				String xml = pk.toRevengXml();
				writer.write(xml);
				writer.write("\n");
			}
		}

	}

	// TODO add commandline support and add to CLI
	public static void main(String[] args) throws PropertyVetoException, SQLException, IOException {
		logger.info("starting test");
		DataSourceFactory dsf = new DataSourceFactory();
		DataSource ds = dsf.getDatasource("aerospace_oracle");
		Connection conn = ds.getConnection();
		// public GenerateReveng(Connection conn, String catalog, String schemaPattern,
		// String tablePattern) {
		GenerateReveng generator = new GenerateReveng(conn, null, "AEROSPACE", "%");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		Writer writer = new OutputStreamWriter(baos);
		generator.write(writer);
		writer.flush();
		System.out.println(baos.toString());
	}

}
