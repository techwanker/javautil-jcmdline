package org.javautil.sql;

import javax.sql.DataSource;
import java.io.Closeable;
import java.io.IOException;

public class ClosesableDataSource {

	public static void close(DataSource dataSource) {
		try {
			((Closeable) dataSource).close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}