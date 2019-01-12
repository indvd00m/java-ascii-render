package com.indvd00m.ascii.render.elements.plot.misc;

import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IPoint;
import com.indvd00m.ascii.render.elements.Label;
import com.indvd00m.ascii.render.elements.plot.api.AxisType;

/**
 * Single axis label.
 *
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-18 10:29:54 PM
 */
public class AxisLabel extends Label {

	protected AxisType axisType;
	protected IPoint anchorPoint;

	public AxisLabel(String text, int x, int y, AxisType axisType, IPoint anchorPoint) {
		super(text, x, y, text.length());
		this.axisType = axisType;
		this.anchorPoint = anchorPoint;
	}

	@Override
	public IPoint draw(ICanvas canvas, IContext context) {
		super.draw(canvas, context);
		return anchorPoint;
	}

	public AxisType getAxisType() {
		return axisType;
	}

	public IPoint getAnchorPoint() {
		return anchorPoint;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AxisLabel [");
		if (axisType != null) {
			builder.append("axisType=");
			builder.append(axisType);
			builder.append(", ");
		}
		if (anchorPoint != null) {
			builder.append("anchorPoint=");
			builder.append(anchorPoint);
			builder.append(", ");
		}
		if (getText() != null) {
			builder.append("text=");
			builder.append(getText());
			builder.append(", ");
		}
		builder.append("x=");
		builder.append(getX());
		builder.append(", y=");
		builder.append(getY());
		builder.append(", width=");
		builder.append(getWidth());
		builder.append("]");
		return builder.toString();
	}

}
