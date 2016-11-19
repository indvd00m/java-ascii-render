package com.indvd00m.ascii.render.elements.plot.misc;

import java.util.ArrayList;
import java.util.List;

import com.indvd00m.ascii.render.elements.plot.api.IPlotPoint;
import com.indvd00m.ascii.render.elements.plot.api.IPlotPoints;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-16 11:26:24 PM
 *
 */
public class PlotPoints implements IPlotPoints {

	List<IPlotPoint> plotPoints;
	double maxX = Double.MIN_VALUE;
	double maxY = Double.MIN_VALUE;
	double minX = Double.MAX_VALUE;
	double minY = Double.MAX_VALUE;
	double diffX;
	double diffY;

	public PlotPoints(List<IPlotPoint> plotPoints) {
		this.plotPoints = plotPoints;

		for (IPlotPoint plotPoint : plotPoints) {
			if (maxX < plotPoint.getX())
				maxX = plotPoint.getX();
			if (maxY < plotPoint.getY())
				maxY = plotPoint.getY();
			if (minX > plotPoint.getX())
				minX = plotPoint.getX();
			if (minY > plotPoint.getY())
				minY = plotPoint.getY();
		}
		diffX = maxX - minX;
		diffY = maxY - minY;
	}

	@Override
	public List<IPlotPoint> normalize(double maxX, double maxY) {
		List<IPlotPoint> normalized = new ArrayList<IPlotPoint>();
		for (IPlotPoint plotPoint : plotPoints) {
			double x = plotPoint.getX() - minX;
			double y = plotPoint.getY() - minY;
			double relativeX = x / diffX;
			double relativeY = y / diffY;
			double normalizedX = relativeX * maxX;
			double normalizedY = relativeY * maxY;
			IPlotPoint normalizedPoint = new PlotPoint(normalizedX, normalizedY);
			normalized.add(normalizedPoint);
		}
		return normalized;
	}

	@Override
	public List<IPlotPoint> getPoints() {
		return plotPoints;
	}

	@Override
	public double getMaxX() {
		return maxX;
	}

	@Override
	public double getMaxY() {
		return maxY;
	}

	@Override
	public double getMinX() {
		return minX;
	}

	@Override
	public double getMinY() {
		return minY;
	}

	@Override
	public double getDiffX() {
		return diffX;
	}

	@Override
	public double getDiffY() {
		return diffY;
	}

}
