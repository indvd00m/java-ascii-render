package com.indvd00m.ascii.render.tests.plot.impl;

import java.util.List;

import com.indvd00m.ascii.render.api.IRegion;
import com.indvd00m.ascii.render.elements.plot.AxisLabels;
import com.indvd00m.ascii.render.elements.plot.api.IPlotPoint;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2017-Feb-04 9:11:23 AM
 *
 */
public class AxisConvertedTestLabels extends AxisLabels {

	public AxisConvertedTestLabels(List<IPlotPoint> points, IRegion region, int countX, int countY) {
		super(points, region, countX, countY);
	}

	public AxisConvertedTestLabels(List<IPlotPoint> points, IRegion region) {
		super(points, region);
	}

	@Override
	protected String format(double value, double labelsStep) {
		return super.format(value * 10, labelsStep);
	}

}
