package com.indvd00m.ascii.render.tests;

import com.indvd00m.ascii.render.Canvas;
import com.indvd00m.ascii.render.Point;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IPoint;
import com.indvd00m.ascii.render.elements.Line;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 0.9.0
 */
public class TestLine {

	@Test
	public void test01() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);
		Line l = new Line(new Point(0, 0), new Point(10, 5));
		IPoint point = l.draw(canvas, context);
		assertEquals(new Point(0, 0), point);
		String s = "";
		s += "●         \n";
		s += " ●●       \n";
		s += "   ●●     \n";
		s += "     ●●   \n";
		s += "       ●● ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test02() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);
		Line l = new Line(new Point(5, 0), new Point(10, 5));
		IPoint point = l.draw(canvas, context);
		assertEquals(new Point(5, 0), point);
		String s = "";
		s += "     ●    \n";
		s += "      ●   \n";
		s += "       ●  \n";
		s += "        ● \n";
		s += "         ●";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test03() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);
		Line l = new Line(new Point(9, 0), new Point(9, 4));
		IPoint point = l.draw(canvas, context);
		assertEquals(new Point(9, 0), point);
		String s = "";
		s += "         ●\n";
		s += "         ●\n";
		s += "         ●\n";
		s += "         ●\n";
		s += "         ●";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test04() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);
		Line l = new Line(new Point(9, 0), new Point(0, 0));
		IPoint point = l.draw(canvas, context);
		assertEquals(new Point(9, 0), point);
		String s = "";
		s += "●●●●●●●●●●\n";
		s += "          \n";
		s += "          \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test05() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);
		Line l = new Line(new Point(0, 0), new Point(0, 5));
		IPoint point = l.draw(canvas, context);
		assertEquals(new Point(0, 0), point);
		String s = "";
		s += "●         \n";
		s += "●         \n";
		s += "●         \n";
		s += "●         \n";
		s += "●         ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test06() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);
		Line l = new Line(new Point(0, 4), new Point(10, 4));
		IPoint point = l.draw(canvas, context);
		assertEquals(new Point(0, 4), point);
		String s = "";
		s += "          \n";
		s += "          \n";
		s += "          \n";
		s += "          \n";
		s += "●●●●●●●●●●";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test07() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(30, 30);
		Line l = new Line(new Point(3, 5), new Point(25, 20));
		IPoint point = l.draw(canvas, context);
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
		String s = "";
		s += "                              \n";
		s += "                              \n";
		s += "                              \n";
		s += "                              \n";
		s += "                              \n";
		s += "   ●                          \n";
		s += "    ●●    ●         ●         \n";
		s += "      ●   ●        ●●         \n";
		s += "       ●●●        ●  ●        \n";
		s += "         ●        ●  ●        \n";
		s += "     ●   ●●●     ●   ●        \n";
		s += "      ●● ●  ●   ●     ●       \n";
		s += "        ●●   ● ●      ●       \n";
		s += "        ● ●●  ●●       ●      \n";
		s += "        ●   ●●● ●      ●      \n";
		s += "        ●    ●●● ●●    ●      \n";
		s += "       ●    ●   ●● ●    ●     \n";
		s += "       ●   ●      ●●●●  ●     \n";
		s += "       ●   ●        ●●● ●     \n";
		s += "       ●  ●           ●●●●    \n";
		s += "      ●  ●              ●●    \n";
		s += "      ● ●                     \n";
		s += "      ●●                      \n";
		s += "      ●●                      \n";
		s += "     ●●                       \n";
		s += "     ●                        \n";
		s += "                              \n";
		s += "                              \n";
		s += "                              \n";
		s += "                              ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

}
