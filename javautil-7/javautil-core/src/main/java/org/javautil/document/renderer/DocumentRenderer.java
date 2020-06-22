package org.javautil.document.renderer;

import java.io.IOException;

/**
 * Implementations can be implemented as stateless beans. It is up to the
 * implementor to determine if the bean is to be stateless or not. This
 * interface is primarily designed to replace the Renderer interface which is
 * explicitly not allowed to be stateless.
 * 
 */
public interface DocumentRenderer {

	/**
	 * Perform the necessary rendering
	 * 
	 * @param renderRequest this request
	 * @throws RendererException ok
	 * @throws IOException       hopefully not
	 */
	public void render(DocumentRendererRequest renderRequest) throws RendererException, IOException;

	/**
	 * Returns false if cannot render, otherwise true // * TODO jjs doesn't this
	 * duplicate capability?
	 * 
	 * @param rendererRequest the request
	 * @return can it be rendered?
	 */
	public boolean canRender(DocumentRendererRequest rendererRequest);

}
