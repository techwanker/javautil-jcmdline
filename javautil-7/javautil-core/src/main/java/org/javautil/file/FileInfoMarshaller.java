package org.javautil.file;

import java.io.IOException;

public interface FileInfoMarshaller {

	void processFileInfo(final FileInfo fileInfo) throws IOException;

}