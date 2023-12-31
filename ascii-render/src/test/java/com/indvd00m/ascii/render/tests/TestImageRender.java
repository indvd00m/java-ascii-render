package com.indvd00m.ascii.render.tests;

import com.indvd00m.ascii.render.ImageRender;
import com.indvd00m.ascii.render.Point;
import com.indvd00m.ascii.render.Region;
import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IImageRender;
import com.indvd00m.ascii.render.api.IRender;
import com.indvd00m.ascii.render.elements.Label;
import com.indvd00m.ascii.render.elements.Line;
import com.indvd00m.ascii.render.elements.Rectangle;
import com.indvd00m.ascii.render.elements.Table;
import com.indvd00m.ascii.render.elements.Text;
import com.indvd00m.ascii.render.elements.plot.Axis;
import com.indvd00m.ascii.render.elements.plot.AxisLabels;
import com.indvd00m.ascii.render.elements.plot.Plot;
import com.indvd00m.ascii.render.elements.plot.api.IPlotPoint;
import com.indvd00m.ascii.render.elements.plot.misc.PlotPoint;
import org.junit.Before;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.indvd00m.ascii.render.util.AsciiUtils.writeImageToPNG;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * We can not compare images with expected values pyxel by pyxel, because rendering of a font to image is platform
 * dependent operation.
 *
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 2.3.0
 */
public class TestImageRender {

	@Before
	public void setUpLocale() throws Exception {
		Locale.setDefault(Locale.ENGLISH);
	}

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
//		writeImageToPNG(image, "/tmp/ascii-image.png");
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
//		writeImageToPNG(image, "/tmp/ascii-image.png");
	}

	@Test
	public void test03() {
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();

		int width = 80;
		int height = 20;

		builder.width(width).height(height);
		{
			// title
			Label title = new Label("EXPERIMENTAL RESULT");
			builder.layer(new Region(width / 2 - title.getText().length() / 2, 0, width, height));
			builder.element(title);
		}

		{
			// info
			builder.layer(new Region(percent(width, 5), percent(height, 10), width, height));
			builder.element(new Label("Theme: Teleportation of matter through extremely dense elements"));
			builder.element(new Label("Date: 1998-11-19", 0, 2));
			builder.element(new Label("Time: 08:47", 0, 3));
			builder.element(new Label("Subject: Gordon Freeman", 0, 4));
		}

		{
			// plot
			Region region = new Region(percent(width, 5), percent(height, 40), percent(width, 50), percent(height, 60));
			builder.layer(region);
			builder.element(new Rectangle(0, 0, region.getWidth(), region.getHeight()));

			List<IPlotPoint> points = new ArrayList<IPlotPoint>();
			for (int degree = 0; degree <= 360; degree++) {
				double val = Math.cos(Math.toRadians(degree));
				IPlotPoint plotPoint = new PlotPoint(degree, val);
				points.add(plotPoint);
			}
			Region plotRegion = new Region(1, 1, region.getWidth() - 2, region.getHeight() - 2);
			builder.element(new Axis(points, plotRegion));
			builder.element(new AxisLabels(points, plotRegion, 5, region.getHeight() - 3));
			builder.element(new Plot(points, plotRegion));
		}

		{
			// text
			Region region = new Region(percent(width, 60), percent(height, 40), percent(width, 35),
					percent(height, 60));
			builder.layer(region);
			builder.element(new Text(
					"Observation of Einstein-Podolsky-Rosen Entanglement on Supraquantum Structures by Induction Through Nonlinear Transuranic Crystal of Extremely Long Wavelength (ELW) Pulse from Mode-Locked Source Array shows a very promising result."));
		}

		{
			// conclusion
			Label label = new Label("CONCLUSION: APPROVE", 0, 1);
			Region region = new Region(width - label.getText().length(), height - 2, label.getText().length(), 2);
			builder.layer(region);
			builder.element(new Line(new Point(0, 0), new Point(label.getText().length(), 0), '*'));
			builder.element(label);
		}

		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
		String e = "";
		e += "                               EXPERIMENTAL RESULT                              \n";
		e += "                                                                                \n";
		e += "    Theme: Teleportation of matter through extremely dense elements             \n";
		e += "                                                                                \n";
		e += "    Date: 1998-11-19                                                            \n";
		e += "    Time: 08:47                                                                 \n";
		e += "    Subject: Gordon Freeman                                                     \n";
		e += "                                                                                \n";
		e += "    ┌──────────────────────────────────────┐    Observation of Einstein-Podo    \n";
		e += "    │ 1.00┼****                       *****│    lsky-Rosen Entanglement on S    \n";
		e += "    │ 0.75┼   ***                   ***    │    upraquantum Structures by In    \n";
		e += "    │ 0.50┼     **                 **      │    duction Through Nonlinear Tr    \n";
		e += "    │ 0.25┼       **             **        │    ansuranic Crystal of Extreme    \n";
		e += "    │ 0.00┼        **           **         │    ly Long Wavelength (ELW) Pul    \n";
		e += "    │-0.25┼         ***       ***          │    se from Mode-Locked Source A    \n";
		e += "    │-0.50┼           *********            │    rray shows a very promising     \n";
		e += "    │-0.75┼               *                │    result.                         \n";
		e += "    │-1.00┼───────┼───────┼───────┼───────┼│                                    \n";
		e += "    │     0      90      180     270    360│                 *******************\n";
		e += "    └──────────────────────────────────────┘                 CONCLUSION: APPROVE";
		assertEquals(e, s);
		IImageRender imageRender = new ImageRender();
		BufferedImage image = imageRender.render(canvas, 360);
		assertNotNull(image);
//		writeImageToPNG(image, "/tmp/ascii-image.png");
	}

	int percent(int value, double percent) {
		return (int) (value * percent / 100d);
	}

	@Test
	public void test04() {
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(1).height(1);
		builder.element(new Label("1", 0, 0));
		ICanvas canvas = render.render(builder.build());
		String t = canvas.toString();
		String s = "";
		s += "1";
		System.out.println(t);
		assertEquals(s, t);
		IImageRender imageRender = new ImageRender();
		BufferedImage image = imageRender.render(canvas, 30);
		assertNotNull(image);
//		writeImageToPNG(image, "/tmp/ascii-image.png");
	}

	@Test
	public void test05() {
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(62).height(1);
		builder.element(new Label("1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz", 0, 0));
		ICanvas canvas = render.render(builder.build());
		String t = canvas.toString();
		String s = "";
		s += "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		System.out.println(t);
		assertEquals(s, t);
		IImageRender imageRender = new ImageRender();
		BufferedImage image = imageRender.render(canvas, 30);
		assertNotNull(image);
//		writeImageToPNG(image, "/tmp/ascii-image.png");
	}

	@Test
	public void test06() {
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(125).height(1);
		builder.element(new Label("1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz 1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz", 0, 0));
		ICanvas canvas = render.render(builder.build());
		String t = canvas.toString();
		String s = "";
		s += "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz 1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		System.out.println(t);
		assertEquals(s, t);
		IImageRender imageRender = new ImageRender();
		BufferedImage image = imageRender.render(canvas, 300);
		assertNotNull(image);
//		writeImageToPNG(image, "/tmp/ascii-image.png");
	}

	@Test
	public void test07() {
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(100).height(1);
		builder.element(new Label("1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz 1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZa", 0, 0));
		ICanvas canvas = render.render(builder.build());
		String t = canvas.toString();
		String s = "";
		s += "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz 1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZa";
		System.out.println(t);
		assertEquals(s, t);
		IImageRender imageRender = new ImageRender();
		BufferedImage image = imageRender.render(canvas, 100);
		assertNotNull(image);
//		writeImageToPNG(image, "/tmp/ascii-image.png");
	}

	@Test
	public void test08() {
		IRender render = new Render();
		ICanvas canvas;
		{
			IContextBuilder builder = render.newBuilder();
			builder.width(62).height(1);
			builder.element(new Label("1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz", 0, 0));
			canvas = render.render(builder.build());
			String t = canvas.toString();
			String s = "";
			s += "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
			System.out.println(t);
			assertEquals(s, t);
		}

		IImageRender imageRender = new ImageRender();
		BufferedImage image = imageRender.render(canvas, 30);
		assertNotNull(image);
//		writeImageToPNG(image, "/tmp/ascii-image.png");

		{
			IContextBuilder builder = render.newBuilder();
			builder.width(72).height(14);
			Table table = new Table(4, 3);
			table.setHighlighted(2, 3, true);
			builder.element(table);
			canvas = render.render(builder.build());
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
		}

		image = imageRender.render(canvas, 300);
		assertNotNull(image);
//		writeImageToPNG(image, "/tmp/ascii-image.png");
	}

}
