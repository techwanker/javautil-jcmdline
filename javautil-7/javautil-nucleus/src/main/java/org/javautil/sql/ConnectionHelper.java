package org.javautil.sql;

import org.javautil.sql.Binds;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.sql.*;
import java.util.Map.Entry;

public class ConnectionHelper {

	public static void executeProcedure(Connection connection, final String sql, Binds binds) throws SQLException {
		final CallableStatement callableStatement = connection.prepareCall(sql);
		for (final Entry<String, Object> entry : binds.entrySet()) {
			callableStatement.setObject(entry.getKey(), entry.getValue());
		}
		callableStatement.executeUpdate();
		callableStatement.close();

	}

	public static void clobWrite(Clob clob, Writer writer) throws SQLException, IOException {
		final int length = 1024 * 1024;
		final Reader reader = clob.getCharacterStream();
		final char[] buffer = new char[length];
		int count;
		while ((count = reader.read(buffer)) != -1) {
			writer.write(buffer, 0, count);
		}
		clob.free();
		reader.close();
	}

	public static String readClob(Clob clob) throws SQLException, IOException {
		char[] clobVal = new char[(int) clob.length()];
		Reader r = clob.getCharacterStream();
		r.read(clobVal);
		return new String(clobVal);
	}

	public static int exhaustQuery(Connection conn, String sql) throws SQLException {
		final Statement s = conn.createStatement();
		final ResultSet rset = s.executeQuery(sql);
		int rowcount = 0;
		while (rset.next()) {
			rowcount++;
		}
		s.close();
		rset.close();
		return rowcount;
	}
}