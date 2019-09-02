package com.indvd00m.ascii.render.tests;

import com.indvd00m.ascii.render.Canvas;
import com.indvd00m.ascii.render.Point;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IPoint;
import com.indvd00m.ascii.render.elements.Rectangle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 0.9.0
 */
public class TestRectangle {

	@Test
	public void test01() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);
		Rectangle r = new Rectangle(0, 0, 4, 5);
		IPoint point = r.draw(canvas, context);
		assertEquals(new Point(0, 0), point);
		String s = "";
		s += "┌──┐      \n";
		s += "│  │      \n";
		s += "│  │      \n";
		s += "│  │      \n";
		s += "└──┘      ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test02() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);
		Rectangle r = new Rectangle(1, 1, 2, 2);
		IPoint point = r.draw(canvas, context);
		assertEquals(new Point(1, 1), point);
		String s = "";
		s += "          \n";
		s += " ┌┐       \n";
		s += " └┘       \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test03() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);
		Rectangle r = new Rectangle(8, 2, 4, 4);
		IPoint point = r.draw(canvas, context);
		assertEquals(new Point(8, 2), point);
		String s = "";
		s += "          \n";
		s += "          \n";
		s += "        ┌─\n";
		s += "        │ \n";
		s += "        │ ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test04() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);
		Rectangle r = new Rectangle(-2, -3, 7, 7);
		IPoint point = r.draw(canvas, context);
		assertEquals(new Point(-2, -3), point);
		String s = "";
		s += "    │     \n";
		s += "    │     \n";
		s += "    │     \n";
		s += "────┘     \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test05() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);
		Rectangle r = new Rectangle();
		IPoint point = r.draw(canvas, context);
		assertEquals(new Point(0, 0), point);
		String s = "";
		s += "┌────────┐\n";
		s += "│        │\n";
		s += "│        │\n";
		s += "│        │\n";
		s += "└────────┘";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

}
