package org.javautil.document.renderer;

import java.io.IOException;

public interface Renderer {

	void process() throws RendererException, IOException;

	boolean canRender(DatasetRendererRequest dexterRequest);

	void setRendererRequest(DatasetRendererRequest dexterRequest);

}
