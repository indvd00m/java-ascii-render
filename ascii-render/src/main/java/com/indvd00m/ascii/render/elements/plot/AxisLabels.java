package com.indvd00m.ascii.render.elements.plot;

import com.indvd00m.ascii.render.Point;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IPoint;
import com.indvd00m.ascii.render.api.IRegion;
import com.indvd00m.ascii.render.elements.plot.api.AxisType;
import com.indvd00m.ascii.render.elements.plot.api.IPlotPoint;
import com.indvd00m.ascii.render.elements.plot.misc.AxisLabel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Labels for {@link Axis}.
 *
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 1.0.0
 */
public class AxisLabels extends AbstractPlotObject<AxisLabels> {

	protected int countX = 5;
	protected int countY = 5;
	protected List<AxisLabel> labels = new ArrayList<AxisLabel>();
	protected int labelsYWidth;
	protected String decimalFractionsLabelsFormat = "%1$,.2f";

	public AxisLabels(List<IPlotPoint> points, IRegion region) {
		super(points, region);
		generateLabels();
	}

	public AxisLabels(List<IPlotPoint> points, IRegion region, String decimalFractionsLabelsFormat) {
		super(points, region);
		this.decimalFractionsLabelsFormat = decimalFractionsLabelsFormat;
		generateLabels();
	}

	public AxisLabels(List<IPlotPoint> points, IRegion region, int countX, int countY) {
		super(points, region);
		this.countX = countX;
		this.countY = countY;
		generateLabels();
	}
	
	public AxisLabels(List<IPlotPoint> points, IRegion region, int countX, int countY, String decimalFractionsLabelsFormat) {
		super(points, region);
		this.countX = countX;
		this.countY = countY;
		this.decimalFractionsLabelsFormat = decimalFractionsLabelsFormat;
		generateLabels();
	}

	@Override
	public IPoint draw(ICanvas canvas, IContext context) {
		for (AxisLabel label : labels) {
			label.draw(canvas, context);
		}
		return anchorPoint;
	}

	protected void generateLabels() {
		// TODO labels count restriction
		// TODO calculate labels count
		labels.clear();

		List<String> textsX = createTexts(AxisType.X, plotPoints.getMinX(), plotPoints.getDiffX(), countX);
		List<String> textsY = createTexts(AxisType.Y, plotPoints.getMinY(), plotPoints.getDiffY(), countY);
		labelsYWidth = getTextsYWidth(textsY);

		int width = region.getWidth();
		int height = region.getHeight();
		int startX = region.getX();
		int startY = region.getY();
		int lastX = startX + width - 1;
		int lastY = startY + height - 1;

		{
			// y labels
			Deque<String> texts = new LinkedList<String>(textsY);
			String topText = texts.pollLast();
			String bottomText = texts.pollFirst();
			double textsStep = (double) (height - 2) / (double) (texts.size() + 1);
			for (int y = startY; y < lastY; y++) {
				String text = null;
				if (y == startY) {
					text = topText;
				} else if (y == lastY - 1) {
					text = bottomText;
				} else if (y % textsStep < 1) {
					text = texts.pollLast();
				}

				if (text != null) {
					text = String.format("%" + labelsYWidth + "s", text);
					labels.add(new AxisLabel(text, startX, y, AxisType.Y, new Point(startX + labelsYWidth, y)));
				}
			}
		}

		{
			// x labels
			Deque<String> texts = new LinkedList<String>(textsX);
			String leftText = texts.pollFirst();
			String rightText = texts.pollLast();
			double textsStep = (double) (width - labelsYWidth) / (double) (texts.size() + 1);

			String text = texts.pollFirst();
			int num = 0;
			while (text != null) {
				num++;

				int position = startX + labelsYWidth + (int) (textsStep * num);
				int start = position - text.length() / 2;
				labels.add(new AxisLabel(text, start, lastY, AxisType.X, new Point(position, lastY)));

				text = texts.pollFirst();
			}

			labels.add(new AxisLabel(leftText, startX + labelsYWidth, lastY, AxisType.X,
					new Point(startX + labelsYWidth, lastY)));
			labels.add(new AxisLabel(rightText, lastX - rightText.length() + 1, lastY, AxisType.X,
					new Point(lastX, lastY)));
		}
	}

	protected List<String> createTexts(AxisType type, double minValue, double diffValues, int count) {
		List<String> texts = new ArrayList<String>(count);

		double textsStep = diffValues / (count - 1);
		for (int i = 0; i < count; i++) {
			double value = i * textsStep + minValue;
			String text = format(type, value, textsStep);
			texts.add(text);
		}
		return texts;
	}

	protected String format(AxisType type, double value, double labelsStep) {
		String label = null;
		if (labelsStep < 10d) {
			label = String.format(decimalFractionsLabelsFormat, value);
		} else {
			label = String.format("%,d", (int) value);
		}
		return label;
	}

	protected int getTextsYWidth(List<String> labelsY) {
		int labelsYWidth = 0;
		for (String yLabel : labelsY) {
			int length = yLabel.length();
			if (labelsYWidth < length) {
				labelsYWidth = length;
			}
		}
		return labelsYWidth;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AxisLabels [countX=");
		builder.append(countX);
		builder.append(", countY=");
		builder.append(countY);
		builder.append(", ");
		if (region != null) {
			builder.append("region=");
			builder.append(region);
		}
		builder.append("]");
		return builder.toString();
	}

	public List<AxisLabel> getLabels() {
		return Collections.unmodifiableList(labels);
	}

	public int getCountX() {
		return countX;
	}

	public int getCountY() {
		return countY;
	}

	public int getLabelsYWidth() {
		return labelsYWidth;
	}
}
