package com.indvd00m.ascii.render.elements;

import com.indvd00m.ascii.render.Point;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IElement;
import com.indvd00m.ascii.render.api.IPoint;

/**
 * Circle of a particular radius.
 *
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 0.9.0
 */
public class Circle implements IElement {

	protected int x;
	protected int y;
	protected int radius;

	public Circle() {
		super();
		this.x = Integer.MIN_VALUE;
		this.y = Integer.MIN_VALUE;
		this.radius = Integer.MIN_VALUE;
	}

	public Circle(int x, int y, int radius) {
		super();
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	@Override
	public IPoint draw(ICanvas canvas, IContext context) {
		int x = this.x;
		int y = this.y;
		int radius = this.radius;

		if (x == Integer.MIN_VALUE) {
			x = canvas.getWidth() / 2;
		}
		if (y == Integer.MIN_VALUE) {
			y = canvas.getHeight() / 2;
		}
		if (radius == Integer.MIN_VALUE) {
			radius = Math.min(canvas.getWidth(), canvas.getHeight()) / 2;
		}

		for (int x1 = x - radius; x1 <= x + radius; x1++) {
			for (int y1 = y - radius; y1 <= y + radius; y1++) {
				double distance = Math.sqrt(Math.pow(x - x1, 2) + Math.pow(y - y1, 2));
				if (compare(radius, distance, 0.5d) == 0) {
					canvas.draw(x1, y1, "*");
				}
			}
		}
		return new Point(x, y);
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

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getRadius() {
		return radius;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + radius;
		result = prime * result + x;
		result = prime * result + y;
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
		Circle other = (Circle) obj;
		if (radius != other.radius) {
			return false;
		}
		if (x != other.x) {
			return false;
		}
		if (y != other.y) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Circle [x=");
		builder.append(x);
		builder.append(", y=");
		builder.append(y);
		builder.append(", radius=");
		builder.append(radius);
		builder.append("]");
		return builder.toString();
	}

}
