package org.javautil.dataset.render;

import org.javautil.document.renderer.DatasetRendererRequest;

public interface DatasetRenderer {

	void render(DatasetRendererRequest rendererRequest) throws DatasetRenderException;

}
