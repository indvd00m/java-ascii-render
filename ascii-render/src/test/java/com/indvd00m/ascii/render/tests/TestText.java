package com.indvd00m.ascii.render.tests;

import com.indvd00m.ascii.render.Canvas;
import com.indvd00m.ascii.render.Point;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IPoint;
import com.indvd00m.ascii.render.elements.Rectangle;
import com.indvd00m.ascii.render.elements.Text;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 1.0.0
 */
public class TestText {

	@Test
	public void test01() {
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
	}

	@Test
	public void test02() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);
		Text t = new Text("Test", 1, 1, 3, 1);
		IPoint point = t.draw(canvas, context);
		assertEquals(new Point(1, 1), point);
		String s = "";
		s += "          \n";
		s += " Te…      \n";
		s += "          \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test03() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);
		Text t = new Text("Test", 1, 1, 3, 2);
		IPoint point = t.draw(canvas, context);
		assertEquals(new Point(1, 1), point);
		String s = "";
		s += "          \n";
		s += " Tes      \n";
		s += " t        \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test04() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);
		Text t = new Text("Tes\nt", 1, 1, 3, 2);
		IPoint point = t.draw(canvas, context);
		assertEquals(new Point(1, 1), point);
		String s = "";
		s += "          \n";
		s += " Tes      \n";
		s += " t        \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test05() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);
		Text t = new Text("Tes\n\nt", 1, 1, 3, 2);
		IPoint point = t.draw(canvas, context);
		assertEquals(new Point(1, 1), point);
		String s = "";
		s += "          \n";
		s += " Te…      \n";
		s += "          \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test06() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);
		Text t = new Text("Tes\n\nt", 1, 1, 3, 1);
		IPoint point = t.draw(canvas, context);
		assertEquals(new Point(1, 1), point);
		String s = "";
		s += "          \n";
		s += " Te…      \n";
		s += "          \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test07() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);
		Text t = new Text("Tes\n\nt", 1, 1, 3, 3);
		IPoint point = t.draw(canvas, context);
		assertEquals(new Point(1, 1), point);
		String s = "";
		s += "          \n";
		s += " Tes      \n";
		s += "          \n";
		s += " t        \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test08() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);
		Text t = new Text("Tes\n\nt", 1, 1, 2, 4);
		IPoint point = t.draw(canvas, context);
		assertEquals(new Point(1, 1), point);
		String s = "";
		s += "          \n";
		s += " Te       \n";
		s += " s        \n";
		s += "          \n";
		s += " t        ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test09() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);
		Text t = new Text("Tes\n\nt", 1, 1, 2, 3);
		IPoint point = t.draw(canvas, context);
		assertEquals(new Point(1, 1), point);
		String s = "";
		s += "          \n";
		s += " Te       \n";
		s += " …        \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test10() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);
		Text t = new Text("Tes\n\nt", 1, 1, 2, 1);
		IPoint point = t.draw(canvas, context);
		assertEquals(new Point(1, 1), point);
		String s = "";
		s += "          \n";
		s += " T…       \n";
		s += "          \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test11() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);
		Text t = new Text("Tes\n\nt", 1, 1, 2, 0);
		IPoint point = t.draw(canvas, context);
		assertNull(point);
		String s = "";
		s += "          \n";
		s += "          \n";
		s += "          \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test12() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);
		Text t = new Text("Tes\n\nt", 1, 1, 0, 1);
		IPoint point = t.draw(canvas, context);
		assertNull(point);
		String s = "";
		s += "          \n";
		s += "          \n";
		s += "          \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test13() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);
		Text t = new Text("This is long text in rectangle", 2, 1, 5, 3);
		IPoint point = t.draw(canvas, context);
		new Rectangle(1, 0, 7, 5).draw(canvas, context);
		assertEquals(point, new Point(2, 1));
		String s = "";
		s += " ┌─────┐  \n";
		s += " │This │  \n";
		s += " │is lo│  \n";
		s += " │ng t…│  \n";
		s += " └─────┘  ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test14() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(30, 10);
		Text t = new Text(
				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
				5, 3, 20, 6);
		IPoint point = t.draw(canvas, context);
		new Rectangle(4, 2, 22, 8).draw(canvas, context);
		assertEquals(point, new Point(5, 3));
		String s = "";
		s += "                              \n";
		s += "                              \n";
		s += "    ┌────────────────────┐    \n";
		s += "    │Lorem Ipsum is simpl│    \n";
		s += "    │y dummy text of the │    \n";
		s += "    │printing and typeset│    \n";
		s += "    │ting industry. Lorem│    \n";
		s += "    │ Ipsum has been the │    \n";
		s += "    │industry's standard…│    \n";
		s += "    └────────────────────┘    ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test15() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);
		Text t = new Text(
				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
		IPoint point = t.draw(canvas, context);
		assertEquals(point, new Point(0, 0));
		String s = "";
		s += "Lorem Ipsu\n";
		s += "m is simpl\n";
		s += "y dummy te\n";
		s += "xt of the \n";
		s += "printing …";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

}
