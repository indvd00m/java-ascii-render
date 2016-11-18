package com.indvd00m.ascii.render.tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import com.indvd00m.ascii.render.Canvas;
import com.indvd00m.ascii.render.Point;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IPoint;
import com.indvd00m.ascii.render.elements.line.Line;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-17 5:15:07 PM
 *
 */
public class TestLine {

	@Test
	public void test() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);

		Line l = new Line(new Point(0, 0), new Point(10, 5));
		IPoint point = l.draw(canvas, context);
		assertEquals(new Point(0, 0), point);
		String s = "";
		s += "*         \n";
		s += "  **      \n";
		s += "    **    \n";
		s += "     ***  \n";
		s += "        **";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.clear();
		l = new Line(new Point(5, 0), new Point(10, 5));
		point = l.draw(canvas, context);
		assertEquals(new Point(5, 0), point);
		s = "";
		s += "     *    \n";
		s += "      *   \n";
		s += "       *  \n";
		s += "       ** \n";
		s += "         *";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.clear();
		l = new Line(new Point(9, 0), new Point(9, 4));
		point = l.draw(canvas, context);
		assertEquals(new Point(9, 0), point);
		s = "";
		s += "         *\n";
		s += "         *\n";
		s += "         *\n";
		s += "         *\n";
		s += "         *";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.clear();
		l = new Line(new Point(9, 0), new Point(0, 0));
		point = l.draw(canvas, context);
		assertEquals(new Point(9, 0), point);
		s = "";
		s += "**********\n";
		s += "          \n";
		s += "          \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.clear();
		l = new Line(new Point(0, 0), new Point(0, 5));
		point = l.draw(canvas, context);
		assertEquals(new Point(0, 0), point);
		s = "";
		s += "*         \n";
		s += "*         \n";
		s += "*         \n";
		s += "*         \n";
		s += "*         ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.clear();
		l = new Line(new Point(0, 4), new Point(10, 4));
		point = l.draw(canvas, context);
		assertEquals(new Point(0, 4), point);
		s = "";
		s += "          \n";
		s += "          \n";
		s += "          \n";
		s += "          \n";
		s += "**********";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas = new Canvas(30, 30);
		l = new Line(new Point(3, 5), new Point(25, 20));
		point = l.draw(canvas, context);
		assertEquals(new Point(3, 5), point);
		l = new Line(new Point(5, 10), new Point(25, 20));
		point = l.draw(canvas, context);
		assertEquals(new Point(5, 10), point);
		l = new Line(new Point(20, 6), new Point(25, 20));
		point = l.draw(canvas, context);
		assertEquals(new Point(20, 6), point);
		l = new Line(new Point(20, 6), new Point(5, 25));
		point = l.draw(canvas, context);
		assertEquals(new Point(20, 6), point);
		l = new Line(new Point(10, 6), new Point(5, 25));
		point = l.draw(canvas, context);
		assertEquals(new Point(10, 6), point);
		l = new Line(new Point(50, 50), new Point(150, 150));
		point = l.draw(canvas, context);
		assertEquals(new Point(50, 50), point);
		s = "";
		s += "                              \n";
		s += "                              \n";
		s += "                              \n";
		s += "                              \n";
		s += "                              \n";
		s += "   *                          \n";
		s += "    **    *         *         \n";
		s += "      *   *        **         \n";
		s += "       **         ** *        \n";
		s += "         *        *  *        \n";
		s += "     **  ***     *   *        \n";
		s += "       *** **   *     *       \n";
		s += "        ***  ***      *       \n";
		s += "        * *** **              \n";
		s += "        *    ** **     *      \n";
		s += "        *    *** **    *      \n";
		s += "       *    *   ** *    *     \n";
		s += "       *   *      ****  *     \n";
		s += "       *  **         ** *     \n";
		s += "       *  *            ***    \n";
		s += "      *  *               *    \n";
		s += "      * *                     \n";
		s += "      **                      \n";
		s += "      **                      \n";
		s += "     **                       \n";
		s += "     *                        \n";
		s += "                              \n";
		s += "                              \n";
		s += "                              \n";
		s += "                              ";

		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

}
