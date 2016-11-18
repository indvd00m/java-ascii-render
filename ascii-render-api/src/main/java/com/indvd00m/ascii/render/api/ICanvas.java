package com.indvd00m.ascii.render.api;

/**
 * Canvas it's a low level object, which can draw text in a particular position. Canvas has width and height and contains area of <tt>\s</tt> and <tt>\n</tt>
 * (line breaks) symbols after creating.
 * 
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-16 10:45:16 PM
 *
 */
public interface ICanvas {

	/**
	 * @return Final version of text, which contains all drawed elements.
	 */
	String getText();

	/**
	 * @return Height of canvas.
	 */
	int getHeight();

	/**
	 * @return Width of canvas.
	 */
	int getWidth();

	/**
	 * Draw string in a particular position. Coordinates <tt>x</tt> and <tt>y</tt> may be any, canvas will draw only text which gets in his region. <tt>s</tt>
	 * can contains line breaks.
	 * 
	 * @param x
	 * @param y
	 * @param s
	 */
	void draw(int x, int y, String s);

	/**
	 * Draw string <tt>count</tt> times starting from <tt>x</tt> and <tt>y</tt>. Coordinates <tt>x</tt> and <tt>y</tt> may be any, canvas will draw only text
	 * which gets in his region. <tt>s</tt> can contains line breaks.
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
	 * Gets char at a particular position. After creating canvas contains only <tt>\s</tt> symbols and line breaks <tt>\n</tt>. If coordinates do not gets in a
	 * canvas region <tt>0</tt> will be returned.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	char getChar(int x, int y);

}
