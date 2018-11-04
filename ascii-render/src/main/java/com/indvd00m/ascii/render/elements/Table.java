package com.indvd00m.ascii.render.elements;

import java.util.ArrayList;
import java.util.List;

import com.indvd00m.ascii.render.Canvas;
import com.indvd00m.ascii.render.Point;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IElement;
import com.indvd00m.ascii.render.api.IPoint;

/**
 * Table with rows and columns.
 * 
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2018-Nov-17 3:23:56 PM
 *
 */
public class Table implements IElement {

	int x;
	int y;
	int width;
	int height;
	int columns;
	int rows;
	List<IElement> elements;

	public Table(int columns, int rows) {
		super();
		this.x = Integer.MIN_VALUE;
		this.y = Integer.MIN_VALUE;
		this.width = Integer.MIN_VALUE;
		this.height = Integer.MIN_VALUE;
		this.columns = columns;
		this.rows = rows;
		int size = rows * columns;
		this.elements = new ArrayList<IElement>(size);
		for (int i = 0; i < size; i++) {
			elements.add(null);
		}
	}

	public Table(int x, int y, int width, int height, int columns, int rows) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.columns = columns;
		this.rows = rows;
		int size = rows * columns;
		this.elements = new ArrayList<IElement>(size);
		for (int i = 0; i < size; i++) {
			elements.add(null);
		}
	}

	public IElement setElement(int column, int row, IElement element) {
		int index = coordToIndex(column, row);
		return elements.set(index, element);
	}

	public IElement getElement(int column, int row) {
		int index = coordToIndex(column, row);
		return elements.get(index);
	}

	protected int coordToIndex(int x, int y) {
		return (y - 1) * columns + (x - 1);
	}

	protected Point indexToCoord(int i) {
		int x = i % columns + 1;
		int y = i / columns + 1;
		return new Point(x, y);
	}

	@Override
	public IPoint draw(ICanvas canvas, IContext context) {
		int x = this.x;
		int y = this.y;
		int width = this.width;
		int height = this.height;

		if (x == Integer.MIN_VALUE)
			x = 0;
		if (y == Integer.MIN_VALUE)
			y = 0;
		if (width == Integer.MIN_VALUE)
			width = canvas.getWidth();
		if (height == Integer.MIN_VALUE)
			height = canvas.getHeight();

		// table borders
		canvas.draw(x, y, "─", width);
		canvas.draw(x, y + height - 1, "─", width);
		canvas.draw(x, y, "│\n", height);
		canvas.draw(x + width - 1, y, "│\n", height);

		canvas.draw(x, y, "┌");
		canvas.draw(x + width - 1, y, "┐");
		canvas.draw(x, y + height - 1, "└");
		canvas.draw(x + width - 1, y + height - 1, "┘");

		// cell borders
		for (int r = 1; r < rows; r++) {
			int rowX = x;
			int rowY = y + r * height / rows;
			canvas.draw(rowX + 1, rowY, "─", width - 2);
			canvas.draw(rowX, rowY, "├");
			canvas.draw(rowX + width - 1, rowY, "┤");
		}
		for (int c = 1; c < columns; c++) {
			int colX = x + c * width / columns;
			int colY = y;
			canvas.draw(colX, colY + 1, "│\n", height - 2);
			canvas.draw(colX, colY, "┬");
			canvas.draw(colX, colY + height - 1, "┴");
		}
		// intersections
		for (int r = 1; r < rows; r++) {
			for (int c = 1; c < columns; c++) {
				int cellX = x + c * width / columns;
				int cellY = y + r * height / rows;
				canvas.draw(cellX, cellY, "┼");
			}
		}
		// elements
		for (int i = 0; i < elements.size(); i++) {
			IElement element = elements.get(i);
			if (element != null) {
				Point coord = indexToCoord(i);
				int startX = x + (coord.getX() - 1) * width / columns + 1;
				int startY = y + (coord.getY() - 1) * height / rows + 1;
				int endX = x + coord.getX() * width / columns;
				int endY = y + coord.getY() * height / rows;
				if (endX == x + width) {
					endX--;
				}
				if (endY == y + height) {
					endY--;
				}
				int cellWidth = endX - startX;
				int cellHeight = endY - startY;
				ICanvas elementCanvas = new Canvas(cellWidth, cellHeight);
				element.draw(elementCanvas, context);
				canvas.draw(startX, startY, elementCanvas.getText());
			}
		}

		return new Point(x, y);
	}

	@Override
	public String toString() {
		return "Table [x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + ", columns=" + columns
				+ ", rows=" + rows + ", elements=" + elements + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + columns;
		result = prime * result + ((elements == null) ? 0 : elements.hashCode());
		result = prime * result + height;
		result = prime * result + rows;
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
		Table other = (Table) obj;
		if (columns != other.columns)
			return false;
		if (elements == null) {
			if (other.elements != null)
				return false;
		} else if (!elements.equals(other.elements))
			return false;
		if (height != other.height)
			return false;
		if (rows != other.rows)
			return false;
		if (width != other.width)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
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

	public int getColumns() {
		return columns;
	}

	public int getRows() {
		return rows;
	}

}
