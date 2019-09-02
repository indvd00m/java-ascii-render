package com.indvd00m.ascii.render.elements;

import com.indvd00m.ascii.render.Point;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IElement;
import com.indvd00m.ascii.render.api.IPoint;

import java.util.ArrayList;
import java.util.List;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 0.9.0
 */
public class Line implements IElement {

	protected IPoint start;
	protected IPoint end;
	protected char pen = '●';

	public Line(IPoint start, IPoint end) {
		super();
		this.start = start;
		this.end = end;
	}

	public Line(IPoint start, IPoint end, char pen) {
		super();
		this.start = start;
		this.end = end;
		this.pen = pen;
	}

	@Override
	public IPoint draw(ICanvas canvas, IContext context) {
		int x1 = start.getX();
		int x2 = end.getX();
		int y1 = start.getY();
		int y2 = end.getY();

		List<IPoint> points = new ArrayList<IPoint>();

		int w = x2 - x1;
		int h = y2 - y1;

		int dx1 = 0;
		int dy1 = 0;
		int dx2 = 0;
		int dy2 = 0;

		if (w < 0) {
			dx1 = -1;
		} else if (w > 0) {
			dx1 = 1;
		}

		if (h < 0) {
			dy1 = -1;
		} else if (h > 0) {
			dy1 = 1;
		}

		if (w < 0) {
			dx2 = -1;
		} else if (w > 0) {
			dx2 = 1;
		}

		int longest = Math.abs(w);
		int shortest = Math.abs(h);

		if (longest <= shortest) {
			longest = Math.abs(h);
			shortest = Math.abs(w);

			if (h < 0) {
				dy2 = -1;
			} else if (h > 0) {
				dy2 = 1;
			}
			dx2 = 0;
		}

		int numerator = longest >> 1;
		for (int i = 0, x = x1, y = y1; i <= longest; i++) {
			points.add(new Point(x, y));

			numerator += shortest;
			if (numerator >= longest) {
				numerator -= longest;
				x += dx1;
				y += dy1;
			} else {
				x += dx2;
				y += dy2;
			}
		}

		// draw
		for (IPoint point : points) {
			canvas.draw(point.getX(), point.getY(), pen);
		}

		return start;
	}

	protected int compare(double d1, double d2, double precision) {
		double diff = d1 - d2;
		if (Math.abs(diff) < precision) {
			return 0;
		}
		if (diff < 0d) {
			return -1;
		} else {
			return 1;
		}
	}

	public IPoint getStart() {
		return start;
	}

	public IPoint getEnd() {
		return end;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Line other = (Line) obj;
		if (end == null) {
			if (other.end != null) {
				return false;
			}
		} else if (!end.equals(other.end)) {
			return false;
		}
		if (start == null) {
			if (other.start != null) {
				return false;
			}
		} else if (!start.equals(other.start)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Line [");
		if (start != null) {
			builder.append("start=");
			builder.append(start);
			builder.append(", ");
		}
		if (end != null) {
			builder.append("end=");
			builder.append(end);
		}
		builder.append("]");
		return builder.toString();
	}

	public char getPen() {
		return pen;
	}

}
