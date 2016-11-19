package com.indvd00m.ascii.render.elements.plot.misc;

import com.indvd00m.ascii.render.elements.plot.api.IPlotPoint;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-16 10:10:19 PM
 *
 */
public class PlotPoint implements IPlotPoint {

	double x;
	double y;

	public PlotPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}

}
