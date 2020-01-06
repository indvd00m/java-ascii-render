package com.indvd00m.ascii.render.elements;

import com.indvd00m.ascii.render.Canvas;
import com.indvd00m.ascii.render.Point;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IElement;
import com.indvd00m.ascii.render.api.IPoint;
import com.indvd00m.ascii.render.elements.table.CellPosition;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;

/**
 * Table with rows and columns.
 *
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 1.3.0
 */
public class Table implements IElement {

	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected int columns;
	protected int rows;
	protected List<IElement> elements;
	protected List<Boolean> highlights;

	public Table(int columns, int rows) {
		this(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, columns, rows);
	}

	public Table(int x, int y, int width, int height, int columns, int rows) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		if (columns > 0) {
			this.columns = columns;
		} else {
			this.columns = 1;
		}
		if (rows > 0) {
			this.rows = rows;
		} else {
			this.rows = 1;
		}
		int size = rows * columns;
		this.elements = new ArrayList<IElement>(size);
		this.highlights = new ArrayList<Boolean>(size);
		for (int i = 0; i < size; i++) {
			elements.add(null);
			highlights.add(Boolean.FALSE);
		}
	}

	public IElement setElement(int column, int row, IElement element) {
		return setElement(column, row, element, false);
	}

	public IElement setElement(int column, int row, IElement element, boolean highlight) {
		int index = coordToIndex(column, row);
		highlights.set(index, highlight);
		return elements.set(index, element);
	}

	public IElement getElement(int column, int row) {
		int index = coordToIndex(column, row);
		return elements.get(index);
	}

	public boolean isHighlighted(int column, int row) {
		int index = coordToIndex(column, row);
		if (index < 0 || index >= highlights.size()) {
			return false;
		}
		return highlights.get(index);
	}

	public boolean setHighlighted(int column, int row, boolean highlight) {
		int index = coordToIndex(column, row);
		return highlights.set(index, highlight);
	}

	protected int coordToIndex(int x, int y) {
		if (x <= 0 || y <= 0) {
			return -1;
		}
		if (x > columns) {
			return -1;
		}
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

		// borders
		for (int r = 0; r <= rows; r++) {
			int cellY;
			int cellHeight;
			if (r == rows) {
				cellY = y + height - 1;
				cellHeight = 0;
			} else if (rows >= height) {
				cellY = y + r;
				cellHeight = 1;
			} else {
				cellY = y + r * height / rows;
				cellHeight = y + (r + 1) * height / rows - cellY;
			}
			for (int c = 0; c <= columns; c++) {
				int cellX;
				int cellWidth;
				if (c == columns) {
					cellX = x + width - 1;
					cellWidth = 0;
				} else if (columns >= width) {
					cellX = x + c;
					cellWidth = 1;
				} else {
					cellX = x + c * width / columns;
					cellWidth = x + (c + 1) * width / columns - cellX;
				}

				EnumSet<CellPosition> highlights = getHighlightedNeighborCells(c + 1, r + 1);

				drawBorders(canvas, cellY, cellHeight, cellX, cellWidth, highlights);
				drawCellCorners(canvas, r, cellY, c, cellX, highlights);
				drawTableCorners(canvas, r, cellY, c, cellX, highlights);
				drawBorderCellCorners(canvas, r, cellY, cellHeight, c, cellX, cellWidth, highlights);
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
				drawCellContent(canvas, context, element, startX, startY, cellWidth, cellHeight);
			}
		}

		return new Point(x, y);
	}

	protected void drawCellContent(ICanvas canvas, IContext context, IElement element, int startX, int startY,
			int cellWidth, int cellHeight) {
		ICanvas elementCanvas = new Canvas(cellWidth, cellHeight);
		element.draw(elementCanvas, context);
		canvas.draw(startX, startY, elementCanvas.getText());
	}

	private void drawBorderCellCorners(ICanvas canvas, int r, int cellY, int cellHeight, int c, int cellX,
			int cellWidth, EnumSet<CellPosition> highlights) {
		if (r != 0 && r != rows) {
			if (c == 0) {
				if (containsNone(highlights, CellPosition.Up, CellPosition.Center)) {
					canvas.draw(cellX, cellY, "├");
				}
				if (containsAll(highlights, CellPosition.Up) && containsNone(highlights, CellPosition.Center)) {
					canvas.draw(cellX, cellY, "┡");
				}
				if (containsAll(highlights, CellPosition.Center) && containsNone(highlights, CellPosition.Up)) {
					canvas.draw(cellX, cellY, "┢");
				}
				if (containsAll(highlights, CellPosition.Up, CellPosition.Center)) {
					canvas.draw(cellX, cellY, "┣");
				}
			}
			if (c == columns) {
				if (containsNone(highlights, CellPosition.Left, CellPosition.UpLeft)) {
					canvas.draw(cellX + cellWidth, cellY, "┤");
				}
				if (containsAll(highlights, CellPosition.UpLeft) && containsNone(highlights, CellPosition.Left)) {
					canvas.draw(cellX + cellWidth, cellY, "┩");
				}
				if (containsAll(highlights, CellPosition.Left) && containsNone(highlights, CellPosition.UpLeft)) {
					canvas.draw(cellX + cellWidth, cellY, "┪");
				}
				if (containsAll(highlights, CellPosition.Left, CellPosition.UpLeft)) {
					canvas.draw(cellX + cellWidth, cellY, "┫");
				}
			}
		}
		if (c != 0 && c != columns) {
			if (r == 0) {
				if (containsNone(highlights, CellPosition.Center, CellPosition.Left)) {
					canvas.draw(cellX, cellY, "┬");
				}
				if (containsAll(highlights, CellPosition.Left) && containsNone(highlights, CellPosition.Center)) {
					canvas.draw(cellX, cellY, "┱");
				}
				if (containsAll(highlights, CellPosition.Center) && containsNone(highlights, CellPosition.Left)) {
					canvas.draw(cellX, cellY, "┲");
				}
				if (containsAll(highlights, CellPosition.Center, CellPosition.Left)) {
					canvas.draw(cellX, cellY, "┳");
				}
			}
			if (r == rows) {
				if (containsNone(highlights, CellPosition.Up, CellPosition.UpLeft)) {
					canvas.draw(cellX, cellY + cellHeight, "┴");
				}
				if (containsAll(highlights, CellPosition.UpLeft) && containsNone(highlights, CellPosition.Up)) {
					canvas.draw(cellX, cellY + cellHeight, "┹");
				}
				if (containsAll(highlights, CellPosition.Up) && containsNone(highlights, CellPosition.UpLeft)) {
					canvas.draw(cellX, cellY + cellHeight, "┺");
				}
				if (containsAll(highlights, CellPosition.Up, CellPosition.UpLeft)) {
					canvas.draw(cellX, cellY + cellHeight, "┻");
				}
			}
		}
	}

	private void drawTableCorners(ICanvas canvas, int r, int cellY, int c, int cellX,
			EnumSet<CellPosition> highlights) {
		if (c == 0 && r == 0) {
			if (containsAll(highlights, CellPosition.Center)) {
				canvas.draw(cellX, cellY, "┏");
			} else {
				canvas.draw(cellX, cellY, "┌");
			}
		} else if (c == columns && r == 0) {
			if (containsAll(highlights, CellPosition.Left)) {
				canvas.draw(cellX, cellY, "┓");
			} else {
				canvas.draw(cellX, cellY, "┐");
			}
		} else if (c == 0 && r == rows) {
			if (containsAll(highlights, CellPosition.Up)) {
				canvas.draw(cellX, cellY, "┗");
			} else {
				canvas.draw(cellX, cellY, "└");
			}
		} else if (c == columns && r == rows) {
			if (containsAll(highlights, CellPosition.UpLeft)) {
				canvas.draw(cellX, cellY, "┛");
			} else {
				canvas.draw(cellX, cellY, "┘");
			}
		}
	}

	private void drawCellCorners(ICanvas canvas, int r, int cellY, int c, int cellX, EnumSet<CellPosition> highlights) {
		if (r > 0 && r < rows && c > 0 && c < columns) {
			// none corners
			if (containsNone(highlights, CellPosition.Up, CellPosition.Center, CellPosition.Left,
					CellPosition.UpLeft)) {
				canvas.draw(cellX, cellY, "┼");
			}

			// one corner
			if (containsAny(highlights, CellPosition.UpLeft) &&
					containsNone(highlights, CellPosition.Up, CellPosition.Center, CellPosition.Left)) {
				canvas.draw(cellX, cellY, "╃");
			}
			if (containsAny(highlights, CellPosition.Up) &&
					containsNone(highlights, CellPosition.Center, CellPosition.Left, CellPosition.UpLeft)) {
				canvas.draw(cellX, cellY, "╄");
			}
			if (containsAny(highlights, CellPosition.Center) &&
					containsNone(highlights, CellPosition.Left, CellPosition.UpLeft, CellPosition.Up)) {
				canvas.draw(cellX, cellY, "╆");
			}
			if (containsAny(highlights, CellPosition.Left) &&
					containsNone(highlights, CellPosition.UpLeft, CellPosition.Up, CellPosition.Center)) {
				canvas.draw(cellX, cellY, "╅");
			}

			// two corners
			if (containsAll(highlights, CellPosition.UpLeft, CellPosition.Up) &&
					containsNone(highlights, CellPosition.Center, CellPosition.Left)) {
				canvas.draw(cellX, cellY, "╇");
			}
			if (containsAll(highlights, CellPosition.Up, CellPosition.Center) &&
					containsNone(highlights, CellPosition.Left, CellPosition.UpLeft)) {
				canvas.draw(cellX, cellY, "╊");
			}
			if (containsAll(highlights, CellPosition.Center, CellPosition.Left) &&
					containsNone(highlights, CellPosition.UpLeft, CellPosition.Up)) {
				canvas.draw(cellX, cellY, "╈");
			}
			if (containsAll(highlights, CellPosition.Left, CellPosition.UpLeft) &&
					containsNone(highlights, CellPosition.Up, CellPosition.Center)) {
				canvas.draw(cellX, cellY, "╉");
			}

			// three or four corners
			if (containsAll(highlights, CellPosition.Up, CellPosition.Center, CellPosition.Left)) {
				canvas.draw(cellX, cellY, "╋");
			}
			if (containsAll(highlights, CellPosition.Center, CellPosition.Left, CellPosition.UpLeft)) {
				canvas.draw(cellX, cellY, "╋");
			}
			if (containsAll(highlights, CellPosition.Left, CellPosition.UpLeft, CellPosition.Up)) {
				canvas.draw(cellX, cellY, "╋");
			}
			if (containsAll(highlights, CellPosition.UpLeft, CellPosition.Up, CellPosition.Center)) {
				canvas.draw(cellX, cellY, "╋");
			}
		}
	}

	private void drawBorders(ICanvas canvas, int cellY, int cellHeight, int cellX, int cellWidth,
			EnumSet<CellPosition> highlights) {
		if (containsAny(highlights, CellPosition.Center, CellPosition.Up)) {
			canvas.draw(cellX + 1, cellY, "━", cellWidth - 1);
		} else {
			canvas.draw(cellX + 1, cellY, "─", cellWidth - 1);
		}
		if (containsAny(highlights, CellPosition.Center, CellPosition.Left)) {
			canvas.draw(cellX, cellY + 1, "┃\n", cellHeight - 1);
		} else {
			canvas.draw(cellX, cellY + 1, "│\n", cellHeight - 1);
		}
	}

	protected <T> boolean containsAll(Collection<T> collection, T... values) {
		for (T value : values) {
			if (!collection.contains(value)) {
				return false;
			}
		}
		return true;
	}

	protected <T> boolean containsAny(Collection<T> collection, T... values) {
		for (T value : values) {
			if (collection.contains(value)) {
				return true;
			}
		}
		return false;
	}

	protected <T> boolean containsNone(Collection<T> collection, T... values) {
		return !containsAny(collection, values);
	}

	protected EnumSet<CellPosition> getHighlightedNeighborCells(int column, int row) {
		EnumSet<CellPosition> positions = EnumSet.noneOf(CellPosition.class);

		if (isHighlighted(column, row)) {
			positions.add(CellPosition.Center);
		}
		if (isHighlighted(column, row - 1)) {
			positions.add(CellPosition.Up);
		}
		if (isHighlighted(column + 1, row - 1)) {
			positions.add(CellPosition.UpRight);
		}
		if (isHighlighted(column + 1, row)) {
			positions.add(CellPosition.Right);
		}
		if (isHighlighted(column + 1, row + 1)) {
			positions.add(CellPosition.DownRight);
		}
		if (isHighlighted(column, row + 1)) {
			positions.add(CellPosition.Down);
		}
		if (isHighlighted(column - 1, row + 1)) {
			positions.add(CellPosition.DownLeft);
		}
		if (isHighlighted(column - 1, row)) {
			positions.add(CellPosition.Left);
		}
		if (isHighlighted(column - 1, row - 1)) {
			positions.add(CellPosition.UpLeft);
		}

		return positions;
	}

	@Override
	public String toString() {
		return "Table [x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + ", columns=" + columns +
				", rows=" + rows + ", elements=" + elements + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Table table = (Table) o;

		if (x != table.x) {
			return false;
		}
		if (y != table.y) {
			return false;
		}
		if (width != table.width) {
			return false;
		}
		if (height != table.height) {
			return false;
		}
		if (columns != table.columns) {
			return false;
		}
		if (rows != table.rows) {
			return false;
		}
		if (!elements.equals(table.elements)) {
			return false;
		}
		return highlights.equals(table.highlights);
	}

	@Override
	public int hashCode() {
		int result = x;
		result = 31 * result + y;
		result = 31 * result + width;
		result = 31 * result + height;
		result = 31 * result + columns;
		result = 31 * result + rows;
		result = 31 * result + elements.hashCode();
		result = 31 * result + highlights.hashCode();
		return result;
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
