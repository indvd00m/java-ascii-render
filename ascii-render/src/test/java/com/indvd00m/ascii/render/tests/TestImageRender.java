package com.indvd00m.ascii.render.tests;

import com.indvd00m.ascii.render.ImageRender;
import com.indvd00m.ascii.render.Point;
import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IImageRender;
import com.indvd00m.ascii.render.api.IRender;
import com.indvd00m.ascii.render.elements.Label;
import com.indvd00m.ascii.render.elements.Line;
import com.indvd00m.ascii.render.elements.Table;
import org.junit.Test;

import java.awt.image.BufferedImage;

import static com.indvd00m.ascii.render.util.AsciiUtils.writeImageToPNG;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * We can not compare images with expected values, because rendering of a font to image is platform dependent operation.
 *
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 0.9.0
 */
public class TestImageRender {

	@Test
	public void test01() {
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(10).height(1);
		builder.element(new Line(new Point(0, 0), new Point(9, 0)));
		builder.element(new Label(" test ", 3, 0));
		ICanvas canvas = render.render(builder.build());
		String t = canvas.toString();
		String s = "";
		s += "●●● test ●";
		System.out.println(t);
		assertEquals(s, t);
		IImageRender imageRender = new ImageRender();
		BufferedImage image = imageRender.render(canvas, 245);
		assertNotNull(image);
		writeImageToPNG(image, "/tmp/ascii-image.png");
	}

	@Test
	public void test02() {
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(72).height(14);
		Table table = new Table(4, 3);
		table.setHighlighted(2, 3, true);
		builder.element(table);
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
		String e = "";
		e += "┌─────────────────┬─────────────────┬─────────────────┬────────────────┐\n";
		e += "│                 │                 │                 │                │\n";
		e += "│                 │                 │                 │                │\n";
		e += "│                 │                 │                 │                │\n";
		e += "├─────────────────┼─────────────────┼─────────────────┼────────────────┤\n";
		e += "│                 │                 │                 │                │\n";
		e += "│                 │                 │                 │                │\n";
		e += "│                 │                 │                 │                │\n";
		e += "│                 │                 │                 │                │\n";
		e += "├─────────────────╆━━━━━━━━━━━━━━━━━╅─────────────────┼────────────────┤\n";
		e += "│                 ┃                 ┃                 │                │\n";
		e += "│                 ┃                 ┃                 │                │\n";
		e += "│                 ┃                 ┃                 │                │\n";
		e += "└─────────────────┺━━━━━━━━━━━━━━━━━┹─────────────────┴────────────────┘";
		assertEquals(e, s);
		IImageRender imageRender = new ImageRender();
		BufferedImage image = imageRender.render(canvas, 245);
		assertNotNull(image);
		writeImageToPNG(image, "/tmp/ascii-image.png");
	}

}
