package com.indvd00m.ascii.render.tests.plot.impl;

import com.indvd00m.ascii.render.api.IRegion;
import com.indvd00m.ascii.render.elements.plot.AxisLabels;
import com.indvd00m.ascii.render.elements.plot.api.IPlotPoint;

import java.util.List;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2017-Feb-04 5:41:08 AM
 */
public class AxisTestLabels extends AxisLabels {

	public AxisTestLabels(List<IPlotPoint> points, IRegion region, int countX, int countY) {
		super(points, region, countX, countY);
	}

	public AxisTestLabels(List<IPlotPoint> points, IRegion region) {
		super(points, region);
	}

}
