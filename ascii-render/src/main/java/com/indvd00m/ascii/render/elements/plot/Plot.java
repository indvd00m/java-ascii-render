package com.indvd00m.ascii.render.elements.plot;

import java.util.List;

import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IPoint;
import com.indvd00m.ascii.render.api.IRegion;
import com.indvd00m.ascii.render.elements.plot.api.IPlotPoint;

/**
 * Plot points.
 * 
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-19 10:59:38 PM
 *
 */
public class Plot extends AbstractPlotObject<Plot> {

	public Plot(List<IPlotPoint> points, IRegion region) {
		super(points, region);
	}

	@Override
	public IPoint draw(ICanvas canvas, IContext context) {
		int width = region.getWidth();
		int height = region.getHeight();
		int startX = region.getX();
		int startY = region.getY();
		@SuppressWarnings("unused")
		int lastX = startX + width - 1;
		int lastY = startY + height - 1;

		AxisLabels labels = context.lookupTyped(AxisLabels.class, getTypedId());
		if (labels != null) {
			startX += labels.getLabelsYWidth();
			width -= labels.getLabelsYWidth();
			lastY -= 1;
			height -= 1;
		}

		Axis axis = context.lookupTyped(Axis.class, getTypedId());
		if (axis != null) {
			startX += 1;
			width -= 1;
			lastY -= 1;
			height -= 1;
		}

		List<IPlotPoint> normalized = plotPoints.normalize(width - 1, height - 1);
		for (IPlotPoint plotPoint : normalized) {
			int x = (int) (startX + plotPoint.getX());
			int y = (int) (lastY - plotPoint.getY());
			canvas.draw(x, y, "*");
		}

		return anchorPoint;
	}

}
