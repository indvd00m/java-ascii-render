package com.indvd00m.ascii.render.tests;

import com.indvd00m.ascii.render.Canvas;
import com.indvd00m.ascii.render.Point;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IPoint;
import com.indvd00m.ascii.render.elements.Ellipse;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 1.0.0
 */
public class TestEllipse {

	@Test
	public void test01() {
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
	}

	@Test
	public void test02() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);
		Ellipse e = new Ellipse(5, 2, 8, 4);
		IPoint point = e.draw(canvas, context);
		assertEquals(new Point(5, 2), point);
		String s = "";
		s += "   *****  \n";
		s += "  *     * \n";
		s += " *       *\n";
		s += "  *     * \n";
		s += "   *****  ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test03() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(80, 20);
		Ellipse e = new Ellipse(40, 10, 70, 16);
		IPoint point = e.draw(canvas, context);
		assertEquals(new Point(40, 10), point);
		String s = "";
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

	@Test
	public void test04() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);
		Ellipse e = new Ellipse();
		IPoint point = e.draw(canvas, context);
		assertEquals(new Point(5, 2), point);
		String s = "";
		s += "   *****  \n";
		s += " **     **\n";
		s += "          \n";
		s += " **     **\n";
		s += "   *****  ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

}
