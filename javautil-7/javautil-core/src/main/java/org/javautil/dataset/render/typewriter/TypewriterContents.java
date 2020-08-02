package org.javautil.dataset.render.typewriter;

import java.io.IOException;
import java.io.OutputStream;

public interface TypewriterContents<R, C> {

	TypewriterContent<R, C> getContent(String identifier);

	void write(OutputStream outputStream) throws IOException;
}
