package org.javautil.document.renderer;

import org.javautil.dataset.Dataset;
public interface DatasetRendererRequest extends RendererRequest {

	@Override
    Dataset getDataset();

	void setDataset(Dataset dataset);

}
