package org.javautil.dataset.render;

import org.javautil.dataset.Dataset;
import org.javautil.document.renderer.DatasetRendererRequest;

/**
 * 
 * TODO why is this a MutableDatasetRenderer and Takes a Renderer
 * 
 */
public interface MutableDatasetRendererRequest extends DatasetRendererRequest {

	@Override
	@SuppressWarnings("unchecked")
	public void setDataset(Dataset dataset);

}
