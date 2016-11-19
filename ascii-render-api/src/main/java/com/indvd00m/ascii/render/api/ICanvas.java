package com.indvd00m.ascii.render.api;

/**
 * Canvas it's a low level object, which can draw text in a particular position. Canvas has width and height and
 * contains area of {@code \s} and {@literal \n} (line breaks) symbols after creating. Axis X directed from left to
 * right. Axis Y directed from top to bottom.
 * 
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-16 10:45:16 PM
 *
 */
public interface ICanvas {

	/**
	 * Final version of text, which contains all drawed elements.
	 * 
	 * @return
	 */
	String getText();

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
	 * Clear all region of canvas and fill it with space symbols.
	 */
	void clear();

	/**
	 * Gets char at a particular position. After creating canvas contains only {@literal \s} symbols and line breaks
	 * {@literal \n}. If coordinates do not gets in a canvas region {@literal 0} will be returned.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	char getChar(int x, int y);

}
