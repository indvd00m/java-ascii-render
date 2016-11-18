package com.indvd00m.ascii.render.tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import com.indvd00m.ascii.render.Canvas;
import com.indvd00m.ascii.render.Point;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IPoint;
import com.indvd00m.ascii.render.elements.Label;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-17 5:15:07 PM
 *
 */
public class TestLabel {

	@Test
	public void test() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);

		Label l = new Label("Test", 1, 1, 4);
		IPoint point = l.draw(canvas, context);
		assertEquals(new Point(1, 1), point);
		String s = "";
		s += "          \n";
		s += " Test     \n";
		s += "          \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		l = new Label("Test", 1, 2, 3);
		point = l.draw(canvas, context);
		assertEquals(new Point(1, 2), point);
		s = "";
		s += "          \n";
		s += " Test     \n";
		s += " Te…      \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		l = new Label("Test", 1, 3, 0);
		point = l.draw(canvas, context);
		assertEquals(new Point(1, 3), point);
		s = "";
		s += "          \n";
		s += " Test     \n";
		s += " Te…      \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

}
