package org.javautil.document.renderer;

import java.io.IOException;

import org.javautil.document.renderer.DatasetRendererRequest;
import org.javautil.document.renderer.RendererException;

public interface Renderer {

	public void process() throws RendererException, IOException;

	public boolean canRender(DatasetRendererRequest dexterRequest);

	public void setRendererRequest(DatasetRendererRequest dexterRequest);

}
