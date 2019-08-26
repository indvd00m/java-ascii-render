package com.indvd00m.ascii.render.elements;

import com.indvd00m.ascii.render.Point;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IElement;
import com.indvd00m.ascii.render.api.IPoint;

/**
 * Rectangle of a particular width and height.
 *
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 0.9.0
 */
public class Rectangle implements IElement {

	protected int x;
	protected int y;
	protected int width;
	protected int height;

	public Rectangle() {
		super();
		this.x = Integer.MIN_VALUE;
		this.y = Integer.MIN_VALUE;
		this.width = Integer.MIN_VALUE;
		this.height = Integer.MIN_VALUE;
	}

	public Rectangle(int x, int y, int width, int height) {
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
			x = 0;
		}
		if (y == Integer.MIN_VALUE) {
			y = 0;
		}
		if (width == Integer.MIN_VALUE) {
			width = canvas.getWidth();
		}
		if (height == Integer.MIN_VALUE) {
			height = canvas.getHeight();
		}

		canvas.draw(x, y, "─", width);
		canvas.draw(x, y + height - 1, "─", width);
		canvas.draw(x, y, "│\n", height);
		canvas.draw(x + width - 1, y, "│\n", height);

		canvas.draw(x, y, "┌");
		canvas.draw(x + width - 1, y, "┐");
		canvas.draw(x, y + height - 1, "└");
		canvas.draw(x + width - 1, y + height - 1, "┘");

		return new Point(x, y);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Rectangle [x=");
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
		Rectangle other = (Rectangle) obj;
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

}
