package com.indvd00m.ascii.render.elements;

import com.indvd00m.ascii.render.Point;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IElement;
import com.indvd00m.ascii.render.api.IPoint;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-18 12:29:22 PM
 *
 */
public class Label implements IElement {

	String text;
	int x;
	int y;
	int width;

	public Label(String text, int x, int y, int width) {
		super();
		this.text = text;
		this.x = x;
		this.y = y;
		this.width = width;
	}

	@Override
	public IPoint draw(ICanvas canvas, IContext context) {
		String s = text.replaceAll("[\\n\\r]+", " ");
		if (s.length() > width) {
			if (width > 1) {
				s = s.substring(0, width);
				s = s.replaceAll(".$", "…");
			} else {
				s = "";
			}
		}
		canvas.draw(x, y, s);
		return new Point(x, y);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + width;
		result = prime * result + x;
		result = prime * result + y;
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
		Label other = (Label) obj;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (width != other.width)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public String getText() {
		return text;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Label [");
		if (text != null) {
			builder.append("text=");
			builder.append(text);
			builder.append(", ");
		}
		builder.append("x=");
		builder.append(x);
		builder.append(", y=");
		builder.append(y);
		builder.append(", width=");
		builder.append(width);
		builder.append("]");
		return builder.toString();
	}

}
