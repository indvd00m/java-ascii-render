package com.indvd00m.ascii.render.elements;

import com.indvd00m.ascii.render.Point;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IElement;
import com.indvd00m.ascii.render.api.IPoint;

/**
 * Single dot ('*' symbol).
 *
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 1.0.0
 */
public class Dot implements IElement {

	protected int x;
	protected int y;

	public Dot() {
		super();
		this.x = Integer.MIN_VALUE;
		this.y = Integer.MIN_VALUE;
	}

	public Dot(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public IPoint draw(ICanvas canvas, IContext context) {
		int x = this.x;
		int y = this.y;

		if (x == Integer.MIN_VALUE) {
			x = canvas.getWidth() / 2;
		}
		if (y == Integer.MIN_VALUE) {
			y = canvas.getHeight() / 2;
		}

		canvas.draw(x, y, "*");
		return new Point(x, y);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Dot other = (Dot) obj;
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
		builder.append("Dot [x=");
		builder.append(x);
		builder.append(", y=");
		builder.append(y);
		builder.append("]");
		return builder.toString();
	}

}
