package com.indvd00m.ascii.render.api;

/**
 * Canvas it's a low level object, which can draw text in a particular position. Canvas has width and height and
 * contains area of {@code \0} and {@code \n} (line breaks) symbols after creating. Axis X directed from left to
 * right. Axis Y directed from top to bottom.
 *
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 0.9.0
 */
public interface ICanvas {

	/**
	 * Final version of text with all drawed elements. Every {@code \0} will be replaced with {@code \s} symbol.
	 *
	 * @return
	 */
	String getText();

	/**
	 * One line of canvas, without trailed new line symbol.
	 *
	 * @param index index of line, from top to bottom
	 * @return
	 */
	String getLine(int index);

	/**
	 * Height of canvas.
	 *
	 * @return
	 */
	int getHeight();

	/**
	 * Width of canvas.
	 *
	 * @return
	 */
	int getWidth();

	/**
	 * Draw char in a particular position. Coordinates {@code x} and {@code y} may be any, canvas will draw only text
	 * which gets in his region. {@code c} can contains line break.
	 *
	 * @param x
	 * @param y
	 * @param c
	 */
	void draw(int x, int y, char c);

	/**
	 * Draw char {@code count} times starting from {@code x} and {@code y}. Coordinates {@code x} and {@code y} may be
	 * any, canvas will draw only text which gets in his region. {@code c} can contains line break.
	 *
	 * @param x
	 * @param y
	 * @param c
	 * @param count
	 */
	void draw(int x, int y, char c, int count);

	/**
	 * Draw string in a particular position. Coordinates {@code x} and {@code y} may be any, canvas will draw only text
	 * which gets in his region. {@code s} can contains line breaks.
	 *
	 * @param x
	 * @param y
	 * @param s
	 */
	void draw(int x, int y, String s);

	/**
	 * Draw string {@code count} times starting from {@code x} and {@code y}. Coordinates {@code x} and {@code y} may be
	 * any, canvas will draw only text which gets in his region. {@code s} can contains line breaks.
	 *
	 * @param x
	 * @param y
	 * @param s
	 */
	void draw(int x, int y, String s, int count);

	/**
	 * Clear all region of canvas and fill it with {@code \0} symbols.
	 */
	void clear();

	/**
	 * Gets char at a particular position. After creating canvas contains only {@code \0} symbols and line breaks
	 * {@code \n}. If coordinates do not gets in a canvas region {@code \0} will be returned.
	 *
	 * @param x
	 * @param y
	 * @return
	 */
	char getChar(int x, int y);

	/**
	 * Set char at a particular position.
	 *
	 * @param x
	 * @param y
	 * @return previous value
	 */
	char setChar(int x, int y, char c);

	/**
	 * Return {@code true} if any char except {@code \0} was drawed in this position.
	 *
	 * @param x
	 * @param y
	 * @return
	 */
	boolean isCharDrawed(int x, int y);

	/**
	 * Returns a canvas whose value is this canvas, with any leading and trailing {@code \s} and {@code \0} symbols
	 * removed.
	 *
	 * @return
	 */
	ICanvas trim();

	/**
	 * Returns a canvas whose value is this canvas, with any leading and trailing whitespace {@code \s} removed.
	 *
	 * @return
	 */
	ICanvas trimSpaces();

	/**
	 * Returns a canvas whose value is this canvas, with any leading and trailing {@code \0} symbol removed.
	 *
	 * @return
	 */
	ICanvas trimNulls();

	/**
	 * Returns a canvas whose value is this canvas, with any leading and trailing {@code trimChar} symbol removed.
	 *
	 * @return
	 */
	ICanvas trim(char trimChar);

	/**
	 * Returns a {@code ICanvas} that is a subcanvas of this canvas.
	 *
	 * @param region
	 * @return
	 */
	ICanvas subCanvas(IRegion region);

}
