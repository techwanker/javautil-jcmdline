package org.javautil.file;

import java.io.IOException;

public interface FileInfoListener {
	void processFileInfo(FileInfo fileInfo) throws IOException;
}
