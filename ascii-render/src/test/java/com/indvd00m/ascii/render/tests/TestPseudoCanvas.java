package com.indvd00m.ascii.render.tests;

import com.indvd00m.ascii.render.PseudoCanvas;
import com.indvd00m.ascii.render.api.ICanvas;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 2.2.0
 */
public class TestPseudoCanvas {

	@Test
	public void test01() {
		ICanvas canvas = new PseudoCanvas(2, 2);
		canvas.draw(0, 0, "  ");
		canvas.draw(0, 1, "  ");
		System.out.println(canvas.getText());
		assertEquals(" ", canvas.getText());
	}

	@Test
	public void test02() {
		ICanvas canvas = new PseudoCanvas(2, 2);
		canvas.draw(0, 0, "  ");
		canvas.draw(0, 1, " *");
		System.out.println(canvas.getText());
		assertEquals("▗", canvas.getText());
	}

	@Test
	public void test03() {
		ICanvas canvas = new PseudoCanvas(2, 2);
		canvas.draw(0, 0, "  ");
		canvas.draw(0, 1, "* ");
		System.out.println(canvas.getText());
		assertEquals("▖", canvas.getText());
	}

	@Test
	public void test04() {
		ICanvas canvas = new PseudoCanvas(2, 2);
		canvas.draw(0, 0, "  ");
		canvas.draw(0, 1, "**");
		System.out.println(canvas.getText());
		assertEquals("▄", canvas.getText());
	}

	@Test
	public void test05() {
		ICanvas canvas = new PseudoCanvas(2, 2);
		canvas.draw(0, 0, " *");
		canvas.draw(0, 1, "  ");
		System.out.println(canvas.getText());
		assertEquals("▝", canvas.getText());
	}

	@Test
	public void test06() {
		ICanvas canvas = new PseudoCanvas(2, 2);
		canvas.draw(0, 0, " *");
		canvas.draw(0, 1, " *");
		System.out.println(canvas.getText());
		assertEquals("▐", canvas.getText());
	}

	@Test
	public void test07() {
		ICanvas canvas = new PseudoCanvas(2, 2);
		canvas.draw(0, 0, " *");
		canvas.draw(0, 1, "* ");
		System.out.println(canvas.getText());
		assertEquals("▞", canvas.getText());
	}

	@Test
	public void test08() {
		ICanvas canvas = new PseudoCanvas(2, 2);
		canvas.draw(0, 0, " *");
		canvas.draw(0, 1, "**");
		System.out.println(canvas.getText());
		assertEquals("▟", canvas.getText());
	}

	@Test
	public void test09() {
		ICanvas canvas = new PseudoCanvas(2, 2);
		canvas.draw(0, 0, "* ");
		canvas.draw(0, 1, "  ");
		System.out.println(canvas.getText());
		assertEquals("▘", canvas.getText());
	}

	@Test
	public void test10() {
		ICanvas canvas = new PseudoCanvas(2, 2);
		canvas.draw(0, 0, "* ");
		canvas.draw(0, 1, " *");
		System.out.println(canvas.getText());
		assertEquals("▚", canvas.getText());
	}

	@Test
	public void test11() {
		ICanvas canvas = new PseudoCanvas(2, 2);
		canvas.draw(0, 0, "* ");
		canvas.draw(0, 1, "* ");
		System.out.println(canvas.getText());
		assertEquals("▌", canvas.getText());
	}

	@Test
	public void test12() {
		ICanvas canvas = new PseudoCanvas(2, 2);
		canvas.draw(0, 0, "* ");
		canvas.draw(0, 1, "**");
		System.out.println(canvas.getText());
		assertEquals("▙", canvas.getText());
	}

	@Test
	public void test13() {
		ICanvas canvas = new PseudoCanvas(2, 2);
		canvas.draw(0, 0, "**");
		canvas.draw(0, 1, "  ");
		System.out.println(canvas.getText());
		assertEquals("▀", canvas.getText());
	}

	@Test
	public void test14() {
		ICanvas canvas = new PseudoCanvas(2, 2);
		canvas.draw(0, 0, "**");
		canvas.draw(0, 1, " *");
		System.out.println(canvas.getText());
		assertEquals("▜", canvas.getText());
	}

	@Test
	public void test15() {
		ICanvas canvas = new PseudoCanvas(2, 2);
		canvas.draw(0, 0, "**");
		canvas.draw(0, 1, "* ");
		System.out.println(canvas.getText());
		assertEquals("▛", canvas.getText());
	}

	@Test
	public void test16() {
		ICanvas canvas = new PseudoCanvas(2, 2);
		canvas.draw(0, 0, "**");
		canvas.draw(0, 1, "**");
		System.out.println(canvas.getText());
		assertEquals("█", canvas.getText());
	}

	@Test
	public void test17() {
		ICanvas canvas = new PseudoCanvas(20, 10);
		canvas.draw(3, 3, "********");
		canvas.draw(4, 4, "********");
		canvas.draw(5, 5, "********");
		String s = "";
		s += "          \n";
		s += " ▗▄▄▄▖    \n";
		s += "  ▜███▖   \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());

		assertEquals(s, canvas.getText());
	}

	@Test
	public void test18() {
		ICanvas canvas = new PseudoCanvas(20, 10);
		canvas.draw(2, 2, "********");
		canvas.draw(3, 3, "********");
		canvas.draw(4, 4, "********");
		canvas.draw(5, 5, "********");
		String s = "";
		s += "          \n";
		s += " ▜███▖    \n";
		s += "  ▜███▖   \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());

		assertEquals(s, canvas.getText());
	}

	@Test
	public void test19() {
		ICanvas canvas = new PseudoCanvas(20, 10);
		canvas.draw(0, 0, "********************");
		canvas.draw(0, 0, "*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n");
		canvas.draw(19, 0, "*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n");
		canvas.draw(0, 9, "********************");
		String s = "";
		s += "▛▀▀▀▀▀▀▀▀▜\n";
		s += "▌        ▐\n";
		s += "▌        ▐\n";
		s += "▌        ▐\n";
		s += "▙▄▄▄▄▄▄▄▄▟";
		System.out.println(canvas.getText());

		assertEquals(s, canvas.getText());
	}

	@Test
	public void test20() {
		ICanvas canvas = new PseudoCanvas(19, 9);
		canvas.draw(0, 0, "********************");
		canvas.draw(0, 0, "*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n");
		canvas.draw(18, 0, "*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n");
		canvas.draw(0, 8, "********************");
		String s = "";
		s += "▛▀▀▀▀▀▀▀▀▌\n";
		s += "▌        ▌\n";
		s += "▌        ▌\n";
		s += "▌        ▌\n";
		s += "▀▀▀▀▀▀▀▀▀▘";
		System.out.println(canvas.getText());

		assertEquals(s, canvas.getText());
	}

	@Test
	public void test21() {
		ICanvas canvas1 = new PseudoCanvas(20, 10);
		canvas1.draw(1, 1, "1234567890");
		ICanvas canvas2 = new PseudoCanvas(20, 10);
		canvas2.draw(1, 1, "123456789*");

		assertNotEquals(canvas1, canvas2);
		assertNotEquals(canvas1.hashCode(), canvas2.hashCode());
		assertEquals(canvas1.getText(), canvas2.getText());
	}


}
