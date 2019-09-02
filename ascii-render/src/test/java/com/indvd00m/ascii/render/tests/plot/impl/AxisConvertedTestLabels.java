package com.indvd00m.ascii.render.tests.plot.impl;

import com.indvd00m.ascii.render.api.IRegion;
import com.indvd00m.ascii.render.elements.plot.AxisLabels;
import com.indvd00m.ascii.render.elements.plot.api.AxisType;
import com.indvd00m.ascii.render.elements.plot.api.IPlotPoint;

import java.util.List;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 1.2.0
 */
public class AxisConvertedTestLabels extends AxisLabels {

	public AxisConvertedTestLabels(List<IPlotPoint> points, IRegion region, int countX, int countY) {
		super(points, region, countX, countY);
	}

	public AxisConvertedTestLabels(List<IPlotPoint> points, IRegion region) {
		super(points, region);
	}

	@Override
	protected String format(AxisType type, double value, double labelsStep) {
		return super.format(type, value * 10, labelsStep);
	}

}
