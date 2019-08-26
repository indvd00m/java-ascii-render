package com.indvd00m.ascii.render;

import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IRegion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 0.9.0
 */
public class Canvas implements ICanvas {

	public static final char NULL_CHAR = '\0';

	protected final int width;
	protected final int height;
	protected final List<StringBuilder> lines;

	// cache
	protected String cachedText;
	protected String cachedLines;
	protected boolean needUpdateCache = false;

	public Canvas(int width, int height) {
		if (width < 0) {
			throw new IllegalArgumentException();
		}
		if (height < 0) {
			throw new IllegalArgumentException();
		}

		this.width = width;
		this.height = height;
		this.lines = new ArrayList<StringBuilder>(height);

		clear();
	}

	protected void updateCacheIfNeed() {
		if (needUpdateCache) {
			updateCache();
			needUpdateCache = false;
		}
	}

	protected void updateCache() {
		StringBuilder sb = new StringBuilder();
		for (Iterator<StringBuilder> it = lines.iterator(); it.hasNext(); ) {
			StringBuilder line = it.next();
			sb.append(line);
			if (it.hasNext()) {
				sb.append('\n');
			}
		}
		String text = sb.toString();
		this.cachedLines = text;
		this.cachedText = text.replace(NULL_CHAR, ' ');
	}

	protected String repeatChar(char c, int count) {
		return repeatString(c + "", count);
	}

	protected String repeatString(String s, int count) {
		String repeated = new String(new char[count]).replace(NULL_CHAR + "", s);
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
		if (x >= width) {
			return;
		}
		if (y >= height) {
			return;
		}

		if (s.matches("(?s).*[\\n\\r]+.*")) { // multiline string
			for (String line : s.split("[\\n\\r]")) {
				draw(x, y++, line);
				if (y >= height) {
					break;
				}
			}
			return;
		}

		// single line string
		if (y < 0) {
			return;
		}

		if (x < 0) {
			if (-x > s.length() - 1) {
				s = "";
			} else {
				s = s.substring(-x);
			}
		}

		if (s.length() > width - x) {
			s = s.substring(0, width - x);
		}

		if (x < 0) {
			x = 0;
		}

		StringBuilder line = lines.get(y);
		line.replace(x, x + s.length(), s);

		needUpdateCache = true;
	}

	@Override
	public void draw(int x, int y, String s, int count) {
		if (count <= 0) {
			return;
		}
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
		updateCacheIfNeed();
		return cachedText;
	}

	@Override
	public String toString() {
		return getText();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Canvas canvas = (Canvas) o;
		updateCacheIfNeed();
		canvas.updateCacheIfNeed();

		if (width != canvas.width) {
			return false;
		}
		if (height != canvas.height) {
			return false;
		}
		return cachedLines.equals(canvas.cachedLines);
	}

	@Override
	public int hashCode() {
		updateCacheIfNeed();

		int result = width;
		result = 31 * result + height;
		result = 31 * result + cachedLines.hashCode();
		return result;
	}

	@Override
	public void clear() {
		lines.clear();
		for (int y = 0; y < height; y++) {
			StringBuilder line = new StringBuilder(width);
			line.append(new char[width]);
			lines.add(line);
		}

		needUpdateCache = true;
	}

	@Override
	public char getChar(int x, int y) {
		if (x < 0 || x >= width) {
			return 0;
		}
		if (y < 0 || y >= height) {
			return 0;
		}

		StringBuilder line = lines.get(y);
		char c = line.charAt(x);
		return c;
	}

	@Override
	public char setChar(int x, int y, char c) {
		if (x < 0 || x >= width) {
			return 0;
		}
		if (y < 0 || y >= height) {
			return 0;
		}

		StringBuilder line = lines.get(y);
		char prevC = line.charAt(x);
		line.setCharAt(x, c);
		needUpdateCache = true;
		return prevC;
	}

	@Override
	public boolean isCharDrawed(int x, int y) {
		return getChar(x, y) != NULL_CHAR;
	}

	@Override
	public ICanvas trim() {
		IRegion region = getTrimmedRegion(this, ' ', NULL_CHAR);
		return subCanvas(region);
	}

	@Override
	public ICanvas trimSpaces() {
		return trim(' ');
	}

	@Override
	public ICanvas trimNulls() {
		return trim(NULL_CHAR);
	}

	@Override
	public ICanvas trim(char trimChar) {
		IRegion region = getTrimmedRegion(this, trimChar);
		return subCanvas(region);
	}

	protected IRegion getTrimmedRegion(ICanvas canvas, char trimChar) {
		int w = canvas.getWidth();
		int h = canvas.getHeight();
		int firstX = w;
		int firstY = h;
		int lastX = 0;
		int lastY = 0;
		// first x
		cycle:
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				char c = canvas.getChar(x, y);
				if (c != trimChar) {
					firstX = x;
					break cycle;
				}
			}
		}
		if (firstX != w) {
			// first y
			cycle:
			for (int y = 0; y < h; y++) {
				for (int x = 0; x < w; x++) {
					char c = canvas.getChar(x, y);
					if (c != trimChar) {
						firstY = y;
						break cycle;
					}
				}
			}
			// last x
			cycle:
			for (int x = w - 1; x >= 0; x--) {
				for (int y = h - 1; y >= 0; y--) {
					char c = canvas.getChar(x, y);
					if (c != trimChar) {
						lastX = x;
						break cycle;
					}
				}
			}
			// last y
			cycle:
			for (int y = h - 1; y >= 0; y--) {
				for (int x = w - 1; x >= 0; x--) {
					char c = canvas.getChar(x, y);
					if (c != trimChar) {
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

	protected IRegion getTrimmedRegion(ICanvas canvas, char trimChar1, char trimChar2) {
		int w = canvas.getWidth();
		int h = canvas.getHeight();
		int firstX = w;
		int firstY = h;
		int lastX = 0;
		int lastY = 0;
		// first x
		cycle:
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				char c = canvas.getChar(x, y);
				if (c != trimChar1 && c != trimChar2) {
					firstX = x;
					break cycle;
				}
			}
		}
		if (firstX != w) {
			// first y
			cycle:
			for (int y = 0; y < h; y++) {
				for (int x = 0; x < w; x++) {
					char c = canvas.getChar(x, y);
					if (c != trimChar1 && c != trimChar2) {
						firstY = y;
						break cycle;
					}
				}
			}
			// last x
			cycle:
			for (int x = w - 1; x >= 0; x--) {
				for (int y = h - 1; y >= 0; y--) {
					char c = canvas.getChar(x, y);
					if (c != trimChar1 && c != trimChar2) {
						lastX = x;
						break cycle;
					}
				}
			}
			// last y
			cycle:
			for (int y = h - 1; y >= 0; y--) {
				for (int x = w - 1; x >= 0; x--) {
					char c = canvas.getChar(x, y);
					if (c != trimChar1 && c != trimChar2) {
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

	@Override
	public ICanvas subCanvas(IRegion region) {
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

}
