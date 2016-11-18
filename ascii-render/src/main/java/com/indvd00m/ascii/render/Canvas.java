package com.indvd00m.ascii.render;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.indvd00m.ascii.render.api.ICanvas;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-16 10:46:00 PM
 *
 */
public class Canvas implements ICanvas {

	int width = 80;
	int height = 20;
	List<StringBuilder> lines;
	String text;

	public Canvas(int width, int height) {
		if (width <= 0)
			throw new IllegalArgumentException();
		if (height <= 0)
			throw new IllegalArgumentException();

		this.width = width;
		this.height = height;
		lines = new ArrayList<StringBuilder>(height);
		for (int y = 0; y < height; y++) {
			StringBuilder line = new StringBuilder(width);
			String emptyLine = repeatChar(' ', width);
			line.append(emptyLine);
			lines.add(line);
		}

		updateText();
	}

	private void updateText() {
		StringBuilder sb = new StringBuilder();
		for (Iterator<StringBuilder> it = lines.iterator(); it.hasNext();) {
			StringBuilder line = it.next();
			sb.append(line);
			if (it.hasNext())
				sb.append('\n');
		}
		text = sb.toString();
	}

	private String repeatChar(char c, int count) {
		return repeatString(c + "", count);
	}

	private String repeatString(String s, int count) {
		String repeated = new String(new char[count]).replace("\0", s);
		return repeated;
	}

	@Override
	public void draw(int x, int y, String s) {
		if (x >= width)
			return;
		if (y >= height)
			return;

		if (s.matches("(?s).*[\\n\\r]+.*")) { // multilined string
			for (String line : s.split("[\\n\\r]")) {
				draw(x, y++, line);
				if (y >= height)
					break;
			}
			return;
		}

		if (y < 0)
			return;

		if (x < 0) {
			if (-x > s.length() - 1)
				s = "";
			else
				s = s.substring(-x);
		}

		if (s.length() > width - x)
			s = s.substring(0, width - x);

		if (x < 0)
			x = 0;

		StringBuilder line = lines.get(y);
		line.replace(x, x + s.length(), s);

		updateText();
	}

	@Override
	public void draw(int x, int y, String s, int count) {
		draw(x, y, repeatString(s, count));
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		return getText();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
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
		Canvas other = (Canvas) obj;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	@Override
	public void clear() {
		draw(0, 0, repeatChar(' ', width) + '\n', height);
	}

	@Override
	public char getChar(int x, int y) {
		if (x < 0 || x >= width)
			return 0;
		if (y < 0 || y >= height)
			return 0;

		StringBuilder line = lines.get(y);
		char c = line.charAt(x);
		return c;
	}

}
