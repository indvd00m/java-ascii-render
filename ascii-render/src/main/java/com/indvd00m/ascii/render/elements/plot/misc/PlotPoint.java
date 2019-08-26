package com.indvd00m.ascii.render.elements.plot.misc;

import com.indvd00m.ascii.render.elements.plot.api.IPlotPoint;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 1.0.0
 */
public class PlotPoint implements IPlotPoint {

	protected double x;
	protected double y;

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
