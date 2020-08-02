package org.javautil.document.renderer;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import org.javautil.document.DocumentRegion;

public interface DocumentRenderStatus {

	DocumentRegion getCurrentRegion();

	void setCurrentRegion(DocumentRegion currentRegion);

	void setCurrentRegionComplete();

	boolean isRegionRendered(DocumentRegion documentRegion);

	Rectangle getRegionBounds(DocumentRegion documentRegion);

	void setTopLeftCoordinate(DocumentRegion documentRegion, Point point);

	Point getTopLeftCoordinate(DocumentRegion documentRegion);

	Point getBottomRightCoordinate(DocumentRegion documentRegion);

	void setDimension(DocumentRegion documentRegion, Dimension dimension);

	Dimension getDimension(DocumentRegion documentRegion);
}
