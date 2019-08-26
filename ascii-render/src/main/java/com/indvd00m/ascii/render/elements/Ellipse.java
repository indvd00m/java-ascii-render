package com.indvd00m.ascii.render.elements;

import com.indvd00m.ascii.render.Point;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IElement;
import com.indvd00m.ascii.render.api.IPoint;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 1.0.0
 */
public class Ellipse implements IElement {

	protected int x;
	protected int y;
	protected int width;
	protected int height;

	public Ellipse() {
		super();
		this.x = Integer.MIN_VALUE;
		this.y = Integer.MIN_VALUE;
		this.width = Integer.MIN_VALUE;
		this.height = Integer.MIN_VALUE;
	}

	public Ellipse(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public IPoint draw(ICanvas canvas, IContext context) {
		int x = this.x;
		int y = this.y;
		int width = this.width;
		int height = this.height;

		if (x == Integer.MIN_VALUE) {
			x = canvas.getWidth() / 2;
		}
		if (y == Integer.MIN_VALUE) {
			y = canvas.getHeight() / 2;
		}
		if (width == Integer.MIN_VALUE) {
			width = canvas.getWidth() - 1;
		}
		if (height == Integer.MIN_VALUE) {
			height = canvas.getHeight() - 1;
		}

		double a = width / 2d;
		double b = height / 2d;
		double c = Math.sqrt(Math.abs(Math.pow(a, 2) - Math.pow(b, 2)));
		double f1x = x - c;
		double f1y = y;
		double f2x = x + c;
		double f2y = y;
		for (int x1 = (int) (x - a); x1 <= x + a; x1++) {
			for (int y1 = (int) (y - b); y1 <= y + b; y1++) {
				double d1 = Math.sqrt(Math.pow(f1x - x1, 2) + Math.pow(f1y - y1, 2));
				double d2 = Math.sqrt(Math.pow(f2x - x1, 2) + Math.pow(f2y - y1, 2));
				if (compare(d1 + d2, 2 * a, 0.5d) == 0) {
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

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + width;
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
		Ellipse other = (Ellipse) obj;
		if (height != other.height) {
			return false;
		}
		if (width != other.width) {
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
		builder.append("Ellipse [x=");
		builder.append(x);
		builder.append(", y=");
		builder.append(y);
		builder.append(", width=");
		builder.append(width);
		builder.append(", height=");
		builder.append(height);
		builder.append("]");
		return builder.toString();
	}

}
