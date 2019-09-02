package com.indvd00m.ascii.render.tests;

import com.indvd00m.ascii.render.Canvas;
import com.indvd00m.ascii.render.Point;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IPoint;
import com.indvd00m.ascii.render.elements.Dot;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 1.0.0
 */
public class TestDot {

	@Test
	public void test01() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);
		Dot d = new Dot(1, 1);
		IPoint point = d.draw(canvas, context);
		assertEquals(new Point(1, 1), point);
		String s = "";
		s += "          \n";
		s += " *        \n";
		s += "          \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test02() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);
		Dot d = new Dot();
		IPoint point = d.draw(canvas, context);
		assertEquals(new Point(5, 2), point);
		String s = "";
		s += "          \n";
		s += "          \n";
		s += "     *    \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

}
