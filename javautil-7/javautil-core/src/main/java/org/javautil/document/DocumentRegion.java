package org.javautil.document;

import java.util.Map;

import org.javautil.dataset.Dataset;
import org.javautil.document.layout.LayoutConstraints;
import org.javautil.document.renderer.RenderTemplate;
import org.javautil.document.style.DocumentStyles;

public interface DocumentRegion {

	String getName();

	Map<String, Object> getParameters();

	LayoutConstraints getLayoutConstraints();

	RenderTemplate getRenderTemplate();

	@SuppressWarnings("unchecked")
    Dataset getDataset();

	DocumentStyles getDocumentStyles();
}
