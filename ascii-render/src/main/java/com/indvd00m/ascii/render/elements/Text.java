package com.indvd00m.ascii.render.elements;

import com.indvd00m.ascii.render.Point;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IElement;
import com.indvd00m.ascii.render.api.IPoint;

/**
 * Multiline string. {@code Text} has a width and source string will be split in a parts by a {@literal \n} symbol if
 * length of string more than {@code Text} width.
 *
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 1.0.0
 */
public class Text implements IElement {

	protected String text;
	protected int x;
	protected int y;
	protected int width;
	protected int height;

	public Text(String text) {
		super();
		this.text = text;
		this.x = Integer.MIN_VALUE;
		this.y = Integer.MIN_VALUE;
		this.width = Integer.MIN_VALUE;
		this.height = Integer.MIN_VALUE;
	}

	public Text(String text, int x, int y, int width, int height) {
		super();
		this.text = text;
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

		if (height <= 0 || width <= 0) {
			return null;
		}
		// text.replaceAll("([^\\n\\r]{" + width + "})\\s*", "$1\n").trim();
		StringBuilder sb = new StringBuilder(text);
		for (int i = 0, breaksCount = 0; i < sb.length(); i++) {
			char c = sb.charAt(i);
			if (i - width - breaksCount == breaksCount * width) {
				if (c != '\n' && c != '\r') {
					c = '\n';
					sb.insert(i, c);
				}
			}
			if (c == '\n' || c == '\r') {
				breaksCount++;
			}
			if (breaksCount > height - 1) {
				for (int j = i; j >= 0; j--) {
					char prevC = sb.charAt(j);
					if (prevC != '\n' && prevC != '\r') {
						sb.setCharAt(j, '…');
						break;
					}
				}
				sb.setLength(i + 1);
				break;
			}
		}
		canvas.draw(x, y, sb.toString());
		return new Point(x, y);
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

	public int getHeight() {
		return height;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
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
		Text other = (Text) obj;
		if (height != other.height) {
			return false;
		}
		if (text == null) {
			if (other.text != null) {
				return false;
			}
		} else if (!text.equals(other.text)) {
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
		builder.append("Text [");
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
		builder.append(", height=");
		builder.append(height);
		builder.append("]");
		return builder.toString();
	}

}
