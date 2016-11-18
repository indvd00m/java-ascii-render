package com.indvd00m.ascii.render.api;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-16 10:45:16 PM
 *
 */
public interface ICanvas {

	String getText();

	int getHeight();

	int getWidth();

	void draw(int x, int y, String s);

	void draw(int x, int y, String s, int count);

	void clear();

	char getChar(int x, int y);

}
