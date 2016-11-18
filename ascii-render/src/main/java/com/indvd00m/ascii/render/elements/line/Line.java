package com.indvd00m.ascii.render.elements.line;

import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

import com.indvd00m.ascii.render.Point;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IElement;
import com.indvd00m.ascii.render.api.IPoint;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-17 9:28:30 PM
 *
 */
public class Line implements IElement {

	IPoint start;
	IPoint end;

	public Line(IPoint start, IPoint end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	public IPoint draw(ICanvas canvas, IContext context) {
		// TODO simplify line drawing
		int x1 = start.getX();
		int x2 = end.getX();
		int y1 = start.getY();
		int y2 = end.getY();

		int minX = Math.min(x1, x2);
		int maxX = Math.max(x1, x2);
		int minY = Math.min(y1, y2);
		int maxY = Math.max(y1, y2);

		int diffX = maxX - minX;
		int diffY = maxY - minY;
		int neededCount = (int) Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));

		Set<IPoint> points = new HashSet<IPoint>();

		// search exact points
		for (int x = minX; x <= maxX; x++) {
			for (int y = minY; y <= maxY; y++) {
				IPoint point = new Point(x, y);
				if (points.contains(point))
					continue;

				boolean draw = false;
				if (x2 == x1 && x2 == x && y >= minY && y <= maxY)
					draw = true;
				else if (y2 == y1 && y2 == y && x >= minX && x <= maxX)
					draw = true;

				if (draw)
					points.add(point);
			}
		}

		// search nearing points
		if (points.size() < neededCount) {
			NavigableSet<PointWithDiff> candidates = new TreeSet<PointWithDiff>();
			for (int x = minX; x <= maxX; x++) {
				for (int y = minY; y <= maxY; y++) {
					IPoint point = new Point(x, y);
					if (points.contains(point))
						continue;

					double a1 = Math.abs((double) (x - x1) / diffX);
					double a2 = Math.abs((double) (y - y1) / diffY);

					double diff = Math.abs(a1 - a2);
					PointWithDiff candidate = new PointWithDiff(point, diff);
					candidates.add(candidate);
				}
			}
			while (points.size() < neededCount) {
				PointWithDiff nextPoint = candidates.pollFirst();
				if (nextPoint == null)
					break;
				points.add(nextPoint.point);
			}
		}

		// draw
		for (IPoint point : points) {
			canvas.draw(point.getX(), point.getY(), "*");
		}

		return start;
	}

	int compare(double d1, double d2, double precision) {
		double diff = d1 - d2;
		if (Math.abs(diff) < precision)
			return 0;
		if (diff < 0d)
			return -1;
		else
			return 1;
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Line other = (Line) obj;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
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

}
