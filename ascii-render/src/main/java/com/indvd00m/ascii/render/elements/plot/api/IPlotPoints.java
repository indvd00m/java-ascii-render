package com.indvd00m.ascii.render.elements.plot.api;

import java.util.List;

/**
 * Additional information for list of {@link IPlotPoint}.
 *
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 1.0.0
 */
public interface IPlotPoints {

	List<IPlotPoint> getPoints();

	double getMaxX();

	double getMaxY();

	double getMinX();

	double getMinY();

	double getDiffX();

	double getDiffY();

	List<IPlotPoint> normalize(double maxX, double maxY);

}