package org.javautil.sql;

import org.javautil.io.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class H2ConnectionHelper {
	private final static Logger logger = LoggerFactory.getLogger(H2ConnectionHelper.class);

	public static ArrayList<String> getDatabaseFile(Connection conn) throws IOException {
		final String info = conn.toString();
		logger.info("info: " + info);
		final Pattern p = Pattern.compile(".*url=jdbc:h2:([^ ]*).*");
		final Matcher m = p.matcher(info);
		String filebase = null;
		if (m.matches()) {
			filebase = m.group(1);
		} else {
			throw new IllegalStateException();
		}
		FileUtil.basename(filebase);
		logger.info("filebase: " + filebase);

//		try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(Paths.get("target/tmp"), "*.dbf*"))
//		{
//			dirStream.forEach(path -> logger.debug(path));
//			//    files.add(path.getFileName()));
//		}
		return new ArrayList<>();

	}
}
