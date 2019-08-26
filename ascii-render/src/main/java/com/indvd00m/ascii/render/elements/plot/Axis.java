package com.indvd00m.ascii.render.elements.plot;

import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IPoint;
import com.indvd00m.ascii.render.api.IRegion;
import com.indvd00m.ascii.render.elements.plot.api.AxisType;
import com.indvd00m.ascii.render.elements.plot.api.IPlotPoint;
import com.indvd00m.ascii.render.elements.plot.misc.AxisLabel;

import java.util.List;

/**
 * Axis X and Y.
 *
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 1.0.0
 */
public class Axis extends AbstractPlotObject<Axis> {

	public Axis(List<IPlotPoint> points, IRegion region) {
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

		canvas.draw(startX, startY, "│\n", height);
		canvas.draw(startX + 1, lastY, "─", width - 1);
		canvas.draw(startX, lastY, "└");

		if (labels != null) {
			List<AxisLabel> axisLabels = labels.getLabels();
			for (AxisLabel label : axisLabels) {
				IPoint labelPoint = label.getAnchorPoint();
				IPoint point = context.transform(labelPoint, labels, this);
				if (label.getAxisType() == AxisType.X) {
					int x = point.getX();
					canvas.draw(x, lastY, "┼");
				} else if (label.getAxisType() == AxisType.Y) {
					int y = point.getY();
					canvas.draw(startX, y, "┼");
				}
			}
		}

		return anchorPoint;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Axis [");
		if (region != null) {
			builder.append("region=");
			builder.append(region);
		}
		builder.append("]");
		return builder.toString();
	}

}
