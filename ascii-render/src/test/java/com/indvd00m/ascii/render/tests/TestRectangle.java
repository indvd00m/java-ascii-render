package com.indvd00m.ascii.render.tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import com.indvd00m.ascii.render.Canvas;
import com.indvd00m.ascii.render.Point;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IPoint;
import com.indvd00m.ascii.render.elements.Rectangle;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-17 5:15:07 PM
 *
 */
public class TestRectangle {

	@Test
	public void test() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);

		Rectangle r = new Rectangle(0, 0, 3, 4);
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

		r = new Rectangle(1, 1, 1, 1);
		point = r.draw(canvas, context);
		assertEquals(new Point(1, 1), point);
		s = "";
		s += "┌──┐      \n";
		s += "│┌┐│      \n";
		s += "│└┘│      \n";
		s += "│  │      \n";
		s += "└──┘      ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		r = new Rectangle(8, 2, 3, 3);
		point = r.draw(canvas, context);
		assertEquals(new Point(8, 2), point);
		s = "";
		s += "┌──┐      \n";
		s += "│┌┐│      \n";
		s += "│└┘│    ┌─\n";
		s += "│  │    │ \n";
		s += "└──┘    │ ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		r = new Rectangle(-2, -3, 6, 6);
		point = r.draw(canvas, context);
		assertEquals(new Point(-2, -3), point);
		s = "";
		s += "┌──┐│     \n";
		s += "│┌┐││     \n";
		s += "│└┘││   ┌─\n";
		s += "────┘   │ \n";
		s += "└──┘    │ ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

}
