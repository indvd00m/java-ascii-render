package com.indvd00m.ascii.render.elements;

import com.indvd00m.ascii.render.Point;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IElement;
import com.indvd00m.ascii.render.api.IPoint;

/**
 * Multilined string. <tt>Text</tt> has a width and source string will be split in a parts by a <tt>\n</tt> symbol if length of string more than <tt>Text</tt>
 * width.
 * 
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-18 2:11:38 PM
 *
 */
public class Text implements IElement {

	String text;
	int x;
	int y;
	int width;
	int height;

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
		if (height <= 0 || width <= 0)
			return null;
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Text other = (Text) obj;
		if (height != other.height)
			return false;
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
