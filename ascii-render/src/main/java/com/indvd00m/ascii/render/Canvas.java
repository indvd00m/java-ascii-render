package com.indvd00m.ascii.render;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IRegion;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-16 10:46:00 PM
 *
 */
public class Canvas implements ICanvas {

	final int width;
	final int height;
	final List<StringBuilder> lines;

	// cache
	String text;

	public Canvas(int width, int height) {
		if (width < 0)
			throw new IllegalArgumentException();
		if (height < 0)
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
	public void draw(int x, int y, char c) {
		draw(x, y, c + "");
	}

	@Override
	public void draw(int x, int y, char c, int count) {
		draw(x, y, c + "", count);
	}

	@Override
	public void draw(int x, int y, String s) {
		if (x >= width)
			return;
		if (y >= height)
			return;

		if (s.matches("(?s).*[\\n\\r]+.*")) { // multiline string
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
		if (count <= 0)
			return;
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

	@Override
	public char setChar(int x, int y, char c) {
		if (x < 0 || x >= width)
			return 0;
		if (y < 0 || y >= height)
			return 0;

		StringBuilder line = lines.get(y);
		char prevC = line.charAt(x);
		line.setCharAt(x, c);
		updateText();
		return prevC;
	}

	@Override
	public ICanvas trim() {
		IRegion region = getTrimmedRegion(this);
		int trimWidth = region.getWidth();
		int trimHeight = region.getHeight();
		int trimX = region.getX();
		int trimY = region.getY();
		ICanvas canvas = new Canvas(trimWidth, trimHeight);
		for (int x = 0; x < trimWidth; x++) {
			for (int y = 0; y < trimHeight; y++) {
				char c = getChar(trimX + x, trimY + y);
				canvas.setChar(x, y, c);
			}
		}
		return canvas;
	}

	protected IRegion getTrimmedRegion(ICanvas canvas) {
		int w = canvas.getWidth();
		int h = canvas.getHeight();
		int firstX = w;
		int firstY = h;
		int lastX = 0;
		int lastY = 0;
		// first x
		cycle: for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				char c = canvas.getChar(x, y);
				if (c != ' ') {
					firstX = x;
					break cycle;
				}
			}
		}
		if (firstX != w) {
			// first y
			cycle: for (int y = 0; y < h; y++) {
				for (int x = 0; x < w; x++) {
					char c = canvas.getChar(x, y);
					if (c != ' ') {
						firstY = y;
						break cycle;
					}
				}
			}
			// last x
			cycle: for (int x = w - 1; x >= 0; x--) {
				for (int y = h - 1; y >= 0; y--) {
					char c = canvas.getChar(x, y);
					if (c != ' ') {
						lastX = x;
						break cycle;
					}
				}
			}
			// last y
			cycle: for (int y = h - 1; y >= 0; y--) {
				for (int x = w - 1; x >= 0; x--) {
					char c = canvas.getChar(x, y);
					if (c != ' ') {
						lastY = y;
						break cycle;
					}
				}
			}
		}
		int regionWidth = lastX - firstX + 1;
		if (regionWidth < 0) {
			regionWidth = 0;
		}
		int regionHeight = lastY - firstY + 1;
		if (regionHeight < 0) {
			regionHeight = 0;
		}
		IRegion region = new Region(firstX, firstY, regionWidth, regionHeight);
		return region;
	}

}
