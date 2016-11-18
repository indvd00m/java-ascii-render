package com.indvd00m.ascii.render.tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import com.indvd00m.ascii.render.Canvas;
import com.indvd00m.ascii.render.Point;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IPoint;
import com.indvd00m.ascii.render.elements.Ellipse;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-17 5:15:07 PM
 *
 */
public class TestEllipse {

	@Test
	public void test() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);

		Ellipse e = new Ellipse(5, 2, 4, 4);
		IPoint point = e.draw(canvas, context);
		assertEquals(new Point(5, 2), point);
		String s = "";
		s += "    ***   \n";
		s += "   *   *  \n";
		s += "   *   *  \n";
		s += "   *   *  \n";
		s += "    ***   ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.clear();
		e = new Ellipse(5, 2, 8, 4);
		point = e.draw(canvas, context);
		assertEquals(new Point(5, 2), point);
		s = "";
		s += "   *****  \n";
		s += "  *     * \n";
		s += " *       *\n";
		s += "  *     * \n";
		s += "   *****  ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas = new Canvas(80, 20);
		e = new Ellipse(40, 10, 70, 16);
		point = e.draw(canvas, context);
		assertEquals(new Point(40, 10), point);
		s = "";
		s += "                                                                                \n";
		s += "                                                                                \n";
		s += "                        *********************************                       \n";
		s += "                  *********************************************                 \n";
		s += "              **********                                 **********             \n";
		s += "           ******                                               ******          \n";
		s += "         ***                                                         ***        \n";
		s += "       **                                                               **      \n";
		s += "      *                                                                   *     \n";
		s += "     *                                                                     *    \n";
		s += "     *                                                                     *    \n";
		s += "     *                                                                     *    \n";
		s += "      *                                                                   *     \n";
		s += "       **                                                               **      \n";
		s += "         ***                                                         ***        \n";
		s += "           ******                                               ******          \n";
		s += "              **********                                 **********             \n";
		s += "                  *********************************************                 \n";
		s += "                        *********************************                       \n";
		s += "                                                                                ";

		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

}
