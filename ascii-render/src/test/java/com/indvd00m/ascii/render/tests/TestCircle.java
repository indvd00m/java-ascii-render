package com.indvd00m.ascii.render.tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import com.indvd00m.ascii.render.Canvas;
import com.indvd00m.ascii.render.Point;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IPoint;
import com.indvd00m.ascii.render.elements.Circle;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-17 5:15:07 PM
 *
 */
public class TestCircle {

	@Test
	public void test01() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);
		Circle c = new Circle(5, 2, 2);
		IPoint point = c.draw(canvas, context);
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
		Circle c = new Circle(8, 0, 2);
		IPoint point = c.draw(canvas, context);
		assertEquals(new Point(8, 0), point);
		String s = "";
		s += "      *   \n";
		s += "      *   \n";
		s += "       ***\n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test03() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(30, 30);
		Circle c = new Circle(15, 15, 14);
		IPoint point = c.draw(canvas, context);
		assertEquals(new Point(15, 15), point);
		String s = "";
		s += "                              \n";
		s += "            *******           \n";
		s += "         ***       ***        \n";
		s += "       **             **      \n";
		s += "      **               **     \n";
		s += "     *                   *    \n";
		s += "    *                     *   \n";
		s += "   **                     **  \n";
		s += "   *                       *  \n";
		s += "  *                         * \n";
		s += "  *                         * \n";
		s += "  *                         * \n";
		s += " *                           *\n";
		s += " *                           *\n";
		s += " *                           *\n";
		s += " *                           *\n";
		s += " *                           *\n";
		s += " *                           *\n";
		s += " *                           *\n";
		s += "  *                         * \n";
		s += "  *                         * \n";
		s += "  *                         * \n";
		s += "   *                       *  \n";
		s += "   **                     **  \n";
		s += "    *                     *   \n";
		s += "     *                   *    \n";
		s += "      **               **     \n";
		s += "       **             **      \n";
		s += "         ***       ***        \n";
		s += "            *******           ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test04() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);
		Circle c = new Circle();
		IPoint point = c.draw(canvas, context);
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

}
