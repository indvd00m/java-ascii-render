package com.indvd00m.ascii.render.elements;

import com.indvd00m.ascii.render.Point;
import com.indvd00m.ascii.render.Region;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IElement;
import com.indvd00m.ascii.render.api.IPoint;
import com.indvd00m.ascii.render.api.IRegion;

/**
 * Canvas overlay. Possibility to combine results of several renders.
 *
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 1.4.0
 */
public class Overlay implements IElement {

	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected ICanvas overlay;
	protected boolean opacity;

	public Overlay(ICanvas overlay) {
		this(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, overlay, false);
	}

	public Overlay(ICanvas overlay, boolean opacity) {
		this(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, overlay, opacity);
	}

	public Overlay(int x, int y, ICanvas overlay) {
		this(x, y, Integer.MIN_VALUE, Integer.MIN_VALUE, overlay, false);
	}

	public Overlay(int x, int y, ICanvas overlay, boolean opacity) {
		this(x, y, Integer.MIN_VALUE, Integer.MIN_VALUE, overlay, opacity);
	}

	public Overlay(int x, int y, int width, int height, ICanvas overlay) {
		this(x, y, width, height, overlay, false);
	}

	public Overlay(int x, int y, int width, int height, ICanvas overlay, boolean opacity) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.overlay = overlay;
		this.opacity = opacity;
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
			width = overlay.getWidth();
		}
		if (height == Integer.MIN_VALUE) {
			height = overlay.getHeight();
		}

		IRegion region = new Region(x, y, width, height);
		drawOver(canvas, overlay, region);

		return new Point(x, y);
	}

	protected void drawOver(ICanvas c1, ICanvas c2, IRegion region) {
		for (int c1x = region.getX(); c1x < region.getX() + region.getWidth(); c1x++) {
			for (int c1y = region.getY(); c1y < region.getY() + region.getHeight(); c1y++) {
				int c2x = c1x - region.getX();
				int c2y = c1y - region.getY();
				if (opacity || c2.isCharDrawed(c2x, c2y)) {
					char c = c2.getChar(c2x, c2y);
					c1.draw(c1x, c1y, c);
				}
			}
		}
	}

	@Override
	public String toString() {
		return "Overlay [x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + ", overlay="
				+ overlay.getText().hashCode() + ", opacity=" + opacity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((overlay == null) ? 0 : overlay.hashCode());
		result = prime * result + height;
		result = prime * result + (opacity ? 1231 : 1237);
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
		Overlay other = (Overlay) obj;
		if (overlay == null) {
			if (other.overlay != null) {
				return false;
			}
		} else if (!overlay.equals(other.overlay)) {
			return false;
		}
		if (height != other.height) {
			return false;
		}
		if (opacity != other.opacity) {
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

	public ICanvas getOverlay() {
		return overlay;
	}

	public boolean isOpacity() {
		return opacity;
	}

}
