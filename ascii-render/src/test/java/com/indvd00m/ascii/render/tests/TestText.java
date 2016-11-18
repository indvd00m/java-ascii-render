package com.indvd00m.ascii.render.tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import com.indvd00m.ascii.render.Canvas;
import com.indvd00m.ascii.render.Point;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IPoint;
import com.indvd00m.ascii.render.elements.Text;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-17 5:15:07 PM
 *
 */
public class TestText {

	@Test
	public void test() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);

		Text t = new Text("Test", 1, 1, 4, 1);
		IPoint point = t.draw(canvas, context);
		assertEquals(new Point(1, 1), point);
		String s = "";
		s += "          \n";
		s += " Test     \n";
		s += "          \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.clear();
		t = new Text("Test", 1, 1, 3, 1);
		point = t.draw(canvas, context);
		assertEquals(new Point(1, 1), point);
		s = "";
		s += "          \n";
		s += " Te…      \n";
		s += "          \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.clear();
		t = new Text("Test", 1, 1, 3, 2);
		point = t.draw(canvas, context);
		assertEquals(new Point(1, 1), point);
		s = "";
		s += "          \n";
		s += " Tes      \n";
		s += " t        \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.clear();
		t = new Text("Tes\nt", 1, 1, 3, 2);
		point = t.draw(canvas, context);
		assertEquals(new Point(1, 1), point);
		s = "";
		s += "          \n";
		s += " Tes      \n";
		s += " t        \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.clear();
		t = new Text("Tes\n\nt", 1, 1, 3, 2);
		point = t.draw(canvas, context);
		assertEquals(new Point(1, 1), point);
		s = "";
		s += "          \n";
		s += " Te…      \n";
		s += "          \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.clear();
		t = new Text("Tes\n\nt", 1, 1, 3, 1);
		point = t.draw(canvas, context);
		assertEquals(new Point(1, 1), point);
		s = "";
		s += "          \n";
		s += " Te…      \n";
		s += "          \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.clear();
		t = new Text("Tes\n\nt", 1, 1, 3, 3);
		point = t.draw(canvas, context);
		assertEquals(new Point(1, 1), point);
		s = "";
		s += "          \n";
		s += " Tes      \n";
		s += "          \n";
		s += " t        \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.clear();
		t = new Text("Tes\n\nt", 1, 1, 2, 4);
		point = t.draw(canvas, context);
		assertEquals(new Point(1, 1), point);
		s = "";
		s += "          \n";
		s += " Te       \n";
		s += " s        \n";
		s += "          \n";
		s += " t        ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.clear();
		t = new Text("Tes\n\nt", 1, 1, 2, 3);
		point = t.draw(canvas, context);
		assertEquals(new Point(1, 1), point);
		s = "";
		s += "          \n";
		s += " Te       \n";
		s += " …        \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.clear();
		t = new Text("Tes\n\nt", 1, 1, 2, 1);
		point = t.draw(canvas, context);
		assertEquals(new Point(1, 1), point);
		s = "";
		s += "          \n";
		s += " T…       \n";
		s += "          \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.clear();
		t = new Text("Tes\n\nt", 1, 1, 2, 0);
		point = t.draw(canvas, context);
		assertNull(point);
		s = "";
		s += "          \n";
		s += "          \n";
		s += "          \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.clear();
		t = new Text("Tes\n\nt", 1, 1, 0, 1);
		point = t.draw(canvas, context);
		assertNull(point);
		s = "";
		s += "          \n";
		s += "          \n";
		s += "          \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

}
