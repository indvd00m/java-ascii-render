package com.indvd00m.ascii.render.elements.plot.misc;

import com.indvd00m.ascii.render.elements.plot.api.IPlotPoint;
import com.indvd00m.ascii.render.elements.plot.api.IPlotPoints;

import java.util.ArrayList;
import java.util.List;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 1.0.0
 */
public class PlotPoints implements IPlotPoints {

	protected List<IPlotPoint> plotPoints;
	protected double maxX = Double.MIN_VALUE;
	protected double maxY = Double.MIN_VALUE;
	protected double minX = Double.MAX_VALUE;
	protected double minY = Double.MAX_VALUE;
	protected double diffX;
	protected double diffY;

	public PlotPoints(List<IPlotPoint> plotPoints) {
		this.plotPoints = plotPoints;

		for (IPlotPoint plotPoint : plotPoints) {
			if (maxX < plotPoint.getX()) {
				maxX = plotPoint.getX();
			}
			if (maxY < plotPoint.getY()) {
				maxY = plotPoint.getY();
			}
			if (minX > plotPoint.getX()) {
				minX = plotPoint.getX();
			}
			if (minY > plotPoint.getY()) {
				minY = plotPoint.getY();
			}
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
