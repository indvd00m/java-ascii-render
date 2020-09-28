package com.indvd00m.ascii.render.tests;

import com.indvd00m.ascii.render.Point;
import com.indvd00m.ascii.render.Region;
import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IRender;
import com.indvd00m.ascii.render.elements.Circle;
import com.indvd00m.ascii.render.elements.Dot;
import com.indvd00m.ascii.render.elements.Ellipse;
import com.indvd00m.ascii.render.elements.Label;
import com.indvd00m.ascii.render.elements.Line;
import com.indvd00m.ascii.render.elements.Overlay;
import com.indvd00m.ascii.render.elements.PseudoText;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 1.0.0
 */
public class TestReadme {

	@Before
	public void setUpLocale() throws Exception {
		Locale.setDefault(Locale.ENGLISH);
	}

	int percent(int value, double percent) {
		return (int) (value * percent / 100d);
	}

	@Test
	public void test01() {
		// TODO draw lambda

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
			// conclustion
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
	}

	@Test
	public void test02() {
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(20).height(10);
		builder.element(new Rectangle());
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
		String e = "";
		e += "┌──────────────────┐\n";
		e += "│                  │\n";
		e += "│                  │\n";
		e += "│                  │\n";
		e += "│                  │\n";
		e += "│                  │\n";
		e += "│                  │\n";
		e += "│                  │\n";
		e += "│                  │\n";
		e += "└──────────────────┘";
		assertEquals(e, s);
	}

	@Test
	public void test03() {
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(20).height(10);
		builder.element(new Rectangle());
		builder.element(new Dot());
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
		String e = "";
		e += "┌──────────────────┐\n";
		e += "│                  │\n";
		e += "│                  │\n";
		e += "│                  │\n";
		e += "│                  │\n";
		e += "│         *        │\n";
		e += "│                  │\n";
		e += "│                  │\n";
		e += "│                  │\n";
		e += "└──────────────────┘";
		assertEquals(e, s);
	}

	@Test
	public void test04() {
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(20).height(10);
		builder.element(new Rectangle());
		builder.element(new Line(new Point(2, 2), new Point(17, 7)));
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
		String e = "";
		e += "┌──────────────────┐\n";
		e += "│                  │\n";
		e += "│ ●●               │\n";
		e += "│   ●●●            │\n";
		e += "│      ●●●         │\n";
		e += "│         ●●●      │\n";
		e += "│            ●●●   │\n";
		e += "│               ●● │\n";
		e += "│                  │\n";
		e += "└──────────────────┘";
		assertEquals(e, s);
	}

	@Test
	public void test05() {
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(20).height(10);
		builder.element(new Rectangle());
		builder.element(new Circle(9, 4, 3));
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
		String e = "";
		e += "┌──────────────────┐\n";
		e += "│       ***        │\n";
		e += "│      *   *       │\n";
		e += "│     *     *      │\n";
		e += "│     *     *      │\n";
		e += "│     *     *      │\n";
		e += "│      *   *       │\n";
		e += "│       ***        │\n";
		e += "│                  │\n";
		e += "└──────────────────┘";
		assertEquals(e, s);
	}

	@Test
	public void test06() {
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(20).height(10);
		builder.element(new Rectangle());
		builder.element(new Ellipse(9, 4, 14, 6));
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
		String e = "";
		e += "┌──────────────────┐\n";
		e += "│     *******      │\n";
		e += "│   **       **    │\n";
		e += "│                  │\n";
		e += "│ *             *  │\n";
		e += "│                  │\n";
		e += "│   **       **    │\n";
		e += "│     *******      │\n";
		e += "│                  │\n";
		e += "└──────────────────┘";
		assertEquals(e, s);
	}

	@Test
	public void test07() {
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(20).height(10);
		builder.element(new Rectangle());
		builder.element(new Label("Label with long text", 1, 4, 18));
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
		String e = "";
		e += "┌──────────────────┐\n";
		e += "│                  │\n";
		e += "│                  │\n";
		e += "│                  │\n";
		e += "│Label with long t…│\n";
		e += "│                  │\n";
		e += "│                  │\n";
		e += "│                  │\n";
		e += "│                  │\n";
		e += "└──────────────────┘";
		assertEquals(e, s);
	}

	@Test
	public void test08() {
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(20).height(10);
		builder.element(new Rectangle());
		builder.element(
				new Text("Lorem Ipsum is simply dummy text of the printing and typesetting industry.", 1, 3, 18, 3));
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
		String e = "";
		e += "┌──────────────────┐\n";
		e += "│                  │\n";
		e += "│                  │\n";
		e += "│Lorem Ipsum is sim│\n";
		e += "│ply dummy text of │\n";
		e += "│the printing and …│\n";
		e += "│                  │\n";
		e += "│                  │\n";
		e += "│                  │\n";
		e += "└──────────────────┘";
		assertEquals(e, s);
	}

	@Test
	public void test09() {
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(102).height(20);
		builder.element(new PseudoText("PseudoText"));
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
		@SuppressWarnings("unused")
		String e = "";
		e += "                                                                                                      \n";
		e += "                                                                                                      \n";
		e += "                                                                                                      \n";
		e += "                                                ██                                                    \n";
		e += " ██████▒                                        ██           ██████████                         ██    \n";
		e += " ██ ░░██▒                                       ██               ██                             ██    \n";
		e += " ██   ░██                                       ██               ██                             ██    \n";
		e += " ██   ░██  ░▒████▓▒   ░▓███▒    ██    ██   ▒███▒██   ▒████░      ██       ░▓███▒   ▓██░░██▓   ███████ \n";
		e += " ██   ░██  ▓█▓░░░▒▓  ░██░░██░   ██    ██  ░██░░███  ░██░░██░     ██      ░██░░██░  ░██▓▓██░     ██    \n";
		e += " ██ ░░██▒  ██▒░      ▓█▒  ░█▓   ██    ██  ▓█▒  ▒██  ▓█▒  ▒█▓     ██      ▓█▒  ░█▓   ░████░      ██    \n";
		e += " ██████▒   ▓████▓▒   ██░  ░██   ██    ██  ██░  ░██  ██░  ░██     ██      ██░  ░██    ▒██▒       ██    \n";
		e += " ██        ░▓█████▒  ████████   ██    ██  ██░  ░██  ██░  ░██     ██      ████████    ░██░       ██    \n";
		e += " ██           ░░▓██  ██░        ██░  ░██  ██░  ░██  ██░  ░██     ██      ██░         ▓██▓       ██    \n";
		e += " ██             ░██  ▓█▒        ██░  ░██  ▓█▒  ▒██  ▓█▒  ▒█▓     ██      ▓█▒        ▒████▒      ██░   \n";
		e += " ██        █▒░░░▓█▓  ░██▒░░▒▓   ▓█▓░░███  ░██░░███  ░██░░██░     ██      ░██▒░░▒▓  ░██▒▒██░     ▓█▒░  \n";
		e += " ██        ░▓████▒░   ░▓███▓░   ░▓███░██   ▒███▒██   ▒████▒      ██       ░▓███▓░  ▓██░░██▓     ░▓███ \n";
		e += "                                                                                                      \n";
		e += "                                                                                                      \n";
		e += "                                                                                                      \n";
		e += "                                                                                                      ";
		// Do not test this, because AWT produce different environment-specific results
		// assertEquals(e, s);
	}

	@Test
	public void test10() {
		List<IPlotPoint> points = new ArrayList<IPlotPoint>();
		for (int degree = 0; degree <= 360; degree++) {
			if (degree > 75 && degree < 105) {
				continue;
			}
			if (degree > 255 && degree < 285) {
				continue;
			}
			double val = Math.tan(Math.toRadians(degree));
			IPlotPoint plotPoint = new PlotPoint(degree, val);
			points.add(plotPoint);
		}
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(80).height(20);
		builder.element(new Rectangle(0, 0, 80, 20));
		builder.layer(new Region(1, 1, 78, 18));
		builder.element(new Axis(points, new Region(0, 0, 78, 18)));
		builder.element(new AxisLabels(points, new Region(0, 0, 78, 18)));
		builder.element(new Plot(points, new Region(0, 0, 78, 18)));
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
		String expected = "";
		expected += "┌──────────────────────────────────────────────────────────────────────────────┐\n";
		expected += "│ 3.73┼              *                                  **                     │\n";
		expected += "│     │             **                                  *                      │\n";
		expected += "│     │             *                                  **                      │\n";
		expected += "│     │            *                                  **                       │\n";
		expected += "│ 1.87┼          **                                 ***                        │\n";
		expected += "│     │       ****                               ****                          │\n";
		expected += "│     │  ******                              *****                             │\n";
		expected += "│     │***                             *******                             ****│\n";
		expected += "│-0.00┼                            *****                              ******   │\n";
		expected += "│     │                         ****                               ****        │\n";
		expected += "│     │                       ***                                 **           │\n";
		expected += "│     │                      **                                  *             │\n";
		expected += "│-1.87┼                     **                                  *              │\n";
		expected += "│     │                     *                                  **              │\n";
		expected += "│     │                    **                                  *               │\n";
		expected += "│     │                                                        *               │\n";
		expected += "│-3.73┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼│\n";
		expected += "│     0                90                180               270              360│\n";
		expected += "└──────────────────────────────────────────────────────────────────────────────┘";
		assertEquals(expected, s);
	}

	@Test
	public void test11() {
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(37).height(7);
		Table table = new Table(4, 3);
		table.setElement(1, 1, new Label("1234567890"));
		table.setElement(4, 3, new Text("1234567890"), true);
		table.setHighlighted(2, 3, true);
		builder.element(table);
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
		String e = "";
		e += "┌────────┬────────┬────────┬────────┐\n";
		e += "│12345678│        │        │        │\n";
		e += "├────────┼────────┼────────┼────────┤\n";
		e += "│        │        │        │        │\n";
		e += "├────────╆━━━━━━━━╅────────╆━━━━━━━━┪\n";
		e += "│        ┃        ┃        ┃1234567…┃\n";
		e += "└────────┺━━━━━━━━┹────────┺━━━━━━━━┛";
		assertEquals(e, s);
	}

	@Test
	public void test12() {
		IRender render1 = new Render();
		IContextBuilder builder1 = render1.newBuilder();
		builder1.width(9).height(3);
		builder1.element(new Rectangle());
		builder1.element(new Text("Overlay", 1, 1, 7, 1));
		ICanvas canvas1 = render1.render(builder1.build());

		IRender render2 = new Render();
		IContextBuilder builder2 = render2.newBuilder();
		builder2.width(20).height(10);
		builder2.element(new Rectangle());
		builder2.element(
				new Text("Lorem Ipsum is simply dummy text of the printing and typesetting industry.", 1, 3, 18, 3));
		builder2.element(new Overlay(5, 3, canvas1, true));
		ICanvas canvas2 = render2.render(builder2.build());
		String s = canvas2.getText();
		System.out.println(s);
		String e = "";
		e += "┌──────────────────┐\n";
		e += "│                  │\n";
		e += "│                  │\n";
		e += "│Lore┌───────┐s sim│\n";
		e += "│ply │Overlay│t of │\n";
		e += "│the └───────┘and …│\n";
		e += "│                  │\n";
		e += "│                  │\n";
		e += "│                  │\n";
		e += "└──────────────────┘";
		assertEquals(e, s);
	}

	@Test
	public void test13() {
		{
			IRender render = new Render();
			IContextBuilder builder = render.newBuilder();
			builder.width(30).height(10);
			builder.element(new Line(new Point(0, 0), new Point(29, 9), '█'));
			ICanvas canvas = render.render(builder.build());
			String s = canvas.getText();
			System.out.println(s);
			String e = "";
			e += "██                            \n";
			e += "  ███                         \n";
			e += "     ████                     \n";
			e += "         ███                  \n";
			e += "            ███               \n";
			e += "               ███            \n";
			e += "                  ███         \n";
			e += "                     ████     \n";
			e += "                         ███  \n";
			e += "                            ██";
			assertEquals(e, s);
		}
		{
			IRender render = new Render();
			render.setPseudoCanvas(true);
			IContextBuilder builder = render.newBuilder();
			builder.width(60).height(20);
			builder.element(new Line(new Point(0, 0), new Point(59, 19)));
			ICanvas canvas = render.render(builder.build());
			String s = canvas.getText();
			System.out.println(s);
			String e = "";
			e += "▀▄▖                           \n";
			e += "  ▝▀▄▖                        \n";
			e += "     ▝▀▄▄                     \n";
			e += "         ▀▚▄                  \n";
			e += "            ▀▚▄               \n";
			e += "               ▀▚▄            \n";
			e += "                  ▀▚▄         \n";
			e += "                     ▀▀▄▖     \n";
			e += "                        ▝▀▄▖  \n";
			e += "                           ▝▀▄";
			assertEquals(e, s);
		}
	}

	@Test
	public void test14() {
		{
			IRender render = new Render();
			IContextBuilder builder = render.newBuilder();
			builder.width(60).height(10);
			builder.element(new PseudoText("PseudoText", false));
			ICanvas canvas = render.render(builder.build());
			String s = canvas.getText();
			System.out.println(s);

			String e = "";
			e += "                                                            \n";
			e += "                          █                                 \n";
			e += " ███                      █      █████                      \n";
			e += " █  █                     █        █               █        \n";
			e += " █  █ ████   ██  █  █   ███  ██    █    ██  █  █  ████      \n";
			e += " ███  █     █  █ █  █  █  █ █  █   █   █  █  ██    █        \n";
			e += " █     ███  ████ █  █  █  █ █  █   █   ████  ██    █        \n";
			e += " █       █  █    █  █  █  █ █  █   █   █     ██    █        \n";
			e += " █    ████   ███ ████   ███  ██    █    ███ █  █   ███      \n";
			e += "                                                            ";
			// Do not test this, because AWT produce different environment-specific results
			// assertEquals(e, s);
		}
		{
			IRender render = new Render();
			render.setPseudoCanvas(true);
			IContextBuilder builder = render.newBuilder();
			builder.width(120).height(20);
			builder.element(new PseudoText("PseudoText", false));
			ICanvas canvas = render.render(builder.build());
			String s = canvas.getText();
			System.out.println(s);

			String e = "";
			e += "                                                            \n";
			e += "                                                            \n";
			e += "                        ▄                                   \n";
			e += "▐▛▀▙                    █      ▀▀█▀▀            ▐▌          \n";
			e += "▐▌ ▐▌ ▗▄▄   ▄▄  ▄  ▄  ▄▖█  ▗▄▖   █   ▗▄▖  ▄▖▗▄ ▗▟▙▄         \n";
			e += "▐▌ ▟▘▐▌  ▘ ▟▘▝▙ █  █ ▟▘▝█ ▗▛ ▜▖  █  ▗▛ ▜▖ ▝██▘  ▐▌          \n";
			e += "▐▛▀▘ ▝██▙▖ █▄▄█ █  █ █  █ ▐▌ ▐▌  █  ▐▙▄▟▌  ▐▌   ▐▌          \n";
			e += "▐▌      ▜▌ █    █  █ █  █ ▐▌ ▐▌  █  ▐▌     ██   ▐▌          \n";
			e += "▐▌   ▝▄▄▞▘ ▝▙▄▞ ▜▙▞█ ▝▙▞█  ▜▄▛   █   ▜▄▄▘ ▟▌▐▙  ▝▙▄         \n";
			e += "                                                            ";
			// Do not test this, because AWT produce different environment-specific results
			// assertEquals(e, s);
		}
	}

}
