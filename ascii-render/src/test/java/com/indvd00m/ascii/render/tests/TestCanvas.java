package com.indvd00m.ascii.render.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.indvd00m.ascii.render.Canvas;
import com.indvd00m.ascii.render.api.ICanvas;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-17 5:15:07 PM
 *
 */
public class TestCanvas {

	@Test
	public void test() {
		ICanvas canvas = new Canvas(10, 5);
		String s = "";
		s += "          \n";
		s += "          \n";
		s += "          \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.draw(0, 1, "1");
		s = "";
		s += "          \n";
		s += "1         \n";
		s += "          \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.draw(0, 1, "123");
		s = "";
		s += "          \n";
		s += "123       \n";
		s += "          \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.draw(8, 0, "12345");
		s = "";
		s += "        12\n";
		s += "123       \n";
		s += "          \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.draw(4, 2, "line1\nline2\nline3");
		s = "";
		s += "        12\n";
		s += "123       \n";
		s += "    line1 \n";
		s += "    line2 \n";
		s += "    line3 ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.draw(6, 2, "1line\n2line\n3line");
		s = "";
		s += "        12\n";
		s += "123       \n";
		s += "    li1lin\n";
		s += "    li2lin\n";
		s += "    li3lin";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.draw(6, 4, "1line\n2line\n3line");
		s = "";
		s += "        12\n";
		s += "123       \n";
		s += "    li1lin\n";
		s += "    li2lin\n";
		s += "    li1lin";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.draw(5, 1, "1", 3);
		s = "";
		s += "        12\n";
		s += "123  111  \n";
		s += "    li1lin\n";
		s += "    li2lin\n";
		s += "    li1lin";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.draw(5, 1, "12", 3);
		s = "";
		s += "        12\n";
		s += "123  12121\n";
		s += "    li1lin\n";
		s += "    li2lin\n";
		s += "    li1lin";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
		assertEquals(0, canvas.getChar(0, -1));
		assertEquals(0, canvas.getChar(-1, 0));
		assertEquals(0, canvas.getChar(canvas.getWidth(), 0));
		assertEquals(0, canvas.getChar(0, canvas.getHeight()));
		assertEquals('1', canvas.getChar(0, 1));
		assertEquals('i', canvas.getChar(5, 2));
	}

}
