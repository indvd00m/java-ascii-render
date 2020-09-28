package com.indvd00m.ascii.render.tests;

import com.indvd00m.ascii.render.Canvas;
import com.indvd00m.ascii.render.Point;
import com.indvd00m.ascii.render.Region;
import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IPoint;
import com.indvd00m.ascii.render.api.IRender;
import com.indvd00m.ascii.render.elements.Circle;
import com.indvd00m.ascii.render.elements.Label;
import com.indvd00m.ascii.render.elements.Line;
import com.indvd00m.ascii.render.elements.PseudoText;
import com.indvd00m.ascii.render.elements.Rectangle;
import com.indvd00m.ascii.render.elements.Table;
import com.indvd00m.ascii.render.elements.Text;
import com.indvd00m.ascii.render.elements.plot.Axis;
import com.indvd00m.ascii.render.elements.plot.AxisLabels;
import com.indvd00m.ascii.render.elements.plot.Plot;
import com.indvd00m.ascii.render.elements.plot.api.IPlotPoint;
import com.indvd00m.ascii.render.elements.plot.misc.PlotPoint;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 0.9.0
 */
public class TestRender {

	@Test
	public void test01() {
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(80).height(20);
		builder.layer(new Rectangle(22, 2, 17, 17));
		builder.layer(new Circle(30, 10, 8), new Circle(50, 10, 8));

		ICanvas canvas = render.render(builder.build());
		String text = canvas.getText();
		System.out.println(text);

		canvas = render.render(builder.build());
		text = canvas.getText();
		System.out.println(text);
		Region region = new Region(5, 5, 10, 10);
		builder.layer(region, new Line(new Point(-30, -30), new Point(200, 200)),
				new Rectangle(0, 0, region.getWidth(), region.getHeight()));

		canvas = render.render(builder.build());
		text = canvas.getText();
		System.out.println(text);

		region = new Region(6, 6, 10, 10);
		builder.layer(region, new Rectangle(0, 0, region.getWidth(), region.getHeight()));

		canvas = render.render(builder.build());
		text = canvas.getText();
		System.out.println(text);

		region = new Region(4, 6, 10, 10);
		builder.layer(region, new Rectangle(0, 0, region.getWidth(), region.getHeight()));

		canvas = render.render(builder.build());
		text = canvas.getText();
		System.out.println(text);

		region = new Region(4, 4, 10, 10);
		builder.layer(region, new Rectangle(0, 0, region.getWidth(), region.getHeight()));

		canvas = render.render(builder.build());
		text = canvas.getText();
		System.out.println(text);

		region = new Region(6, 4, 10, 10);
		builder.layer(region, new Rectangle(0, 0, region.getWidth(), region.getHeight()));

		canvas = render.render(builder.build());
		text = canvas.getText();
		System.out.println(text);

		for (int i = 0; i < 5; i++) {
			region = new Region(60 + i, 5 + i, 7, 7);
			builder.layer(region, new Rectangle(0, 0, region.getWidth(), region.getHeight()));
		}

		canvas = render.render(builder.build());
		text = canvas.getText();
		System.out.println(text);

		String expected = "";
		expected += "";
		expected += "                                                                                \n";
		expected += "                                                                                \n";
		expected += "                      ┌─────*****─────┐         *****                           \n";
		expected += "                      │   **     **   │       **     **                         \n";
		expected += "    ┌─┌────────┐      │ **         ** │     **         **                       \n";
		expected += "    │┌│──────│┐│      │ *           * │     *           *   ┌─────┐             \n";
		expected += "    │─│──────│─│      │*             *│    *             *  │┌─────┐            \n";
		expected += "    │││●     │││      │*             *│    *             *  ││┌─────┐           \n";
		expected += "    │││ ●    │││      *               *   *               * │││┌─────┐          \n";
		expected += "    │││  ●   │││      *               *   *               * ││││┌─────┐         \n";
		expected += "    │││   ●  │││      *               *   *               * │││││ │││││         \n";
		expected += "    │││    ● │││      *               *   *               * └││││─┘││││         \n";
		expected += "    │││     ●│││      *               *   *               *  └│││──┘│││         \n";
		expected += "    └─└────────┘      │*             *│    *             *    └││───┘││         \n";
		expected += "    │└│──────│┘│      │*             *│    *             *     └│────┘│         \n";
		expected += "    └────────┘─┘      │ *           * │     *           *       └─────┘         \n";
		expected += "                      │ **         ** │     **         **                       \n";
		expected += "                      │   **     **   │       **     **                         \n";
		expected += "                      └─────*****─────┘         *****                           \n";
		expected += "                                                                                ";

		assertEquals(expected, text);
	}

	@Test
	public void test02() {
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
	}

	@Test
	public void test03() {
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(10).height(1);
		builder.element(new Line(new Point(0, 0), new Point(9, 0)));
		builder.opacity(false);
		builder.element(new Label(" test ", 3, 0));
		ICanvas canvas = render.render(builder.build());
		String t = canvas.toString();
		String s = "";
		s += "●●● test ●";
		System.out.println(t);
		assertEquals(s, t);
	}

	@Test
	public void test04() {
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(10).height(1);
		builder.element(new Line(new Point(0, 0), new Point(9, 0)));
		builder.opacity(true);
		builder.element(new Label(" test ", 3, 0));
		ICanvas canvas = render.render(builder.build());
		String t = canvas.toString();
		String s = "";
		s += "●●● test ●";
		System.out.println(t);
		assertEquals(s, t);
	}

	@Test
	public void test05() {
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(10).height(1);
		builder.element(new Line(new Point(0, 0), new Point(9, 0)));
		builder.layer();
		builder.element(new Label(" test ", 3, 0));
		ICanvas canvas = render.render(builder.build());
		String t = canvas.toString();
		String s = "";
		s += "●●● test ●";
		System.out.println(t);
		assertEquals(s, t);
	}

	@Test
	public void test06() {
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(10).height(1);
		builder.element(new Line(new Point(0, 0), new Point(9, 0)));
		builder.layer();
		builder.opacity(false);
		builder.element(new Label(" test ", 3, 0));
		ICanvas canvas = render.render(builder.build());
		String t = canvas.toString();
		String s = "";
		s += "●●● test ●";
		System.out.println(t);
		assertEquals(s, t);
	}

	@Test
	public void test07() {
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(10).height(1);
		builder.element(new Line(new Point(0, 0), new Point(9, 0)));
		builder.layer();
		builder.opacity(true);
		builder.element(new Label(" test ", 3, 0));
		ICanvas canvas = render.render(builder.build());
		String t = canvas.toString();
		String s = "";
		s += "    test  ";
		System.out.println(t);
		assertEquals(s, t);
	}

	@Test
	public void test08() {
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(10).height(1);
		builder.element(new Line(new Point(0, 0), new Point(9, 0)));
		builder.layer(2, 0, 8, 1);
		builder.opacity(true);
		builder.element(new Label(" test ", 1, 0));
		ICanvas canvas = render.render(builder.build());
		String t = canvas.toString();
		String s = "";
		s += "●●  test  ";
		System.out.println(t);
		assertEquals(s, t);
	}

	@Test
	public void test09() {
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(10).height(1);
		builder.element(new Line(new Point(0, 0), new Point(9, 0)));
		builder.layer(1, 0, 9, 1);
		builder.opacity(true);
		builder.element(new Label(" test ", 2, 0));
		builder.layer();
		builder.opacity(false);
		builder.element(new Label(" 1   ", 5, 0));
		ICanvas canvas = render.render(builder.build());
		String t = canvas.toString();
		String s = "";
		s += "●   t 1   ";
		System.out.println(t);
		assertEquals(s, t);
	}

	@Test
	public void test10() {
		IRender render = new Render();
		render.setPseudoCanvas(true);
		IContextBuilder builder = render.newBuilder();
		builder.width(20).height(10);
		builder.element(new Rectangle());
		builder.element(new Line(new Point(2, 2), new Point(17, 7)));
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
		String e = "";
		e += "▛▀▀▀▀▀▀▀▀▜\n";
		e += "▌▀▄▖     ▐\n";
		e += "▌  ▝▀▄▖  ▐\n";
		e += "▌     ▝▀▄▐\n";
		e += "▙▄▄▄▄▄▄▄▄▟";
		assertEquals(e, s);
	}

	@Test
	public void test11() {
		IRender render = new Render();
		render.setPseudoCanvas(true);
		IContextBuilder builder = render.newBuilder();
		builder.width(20).height(10);
		builder.element(new Rectangle());
		builder.element(new Circle(9, 4, 3));
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
		String e = "";
		e += "▛▀▀▀█▛▀▀▀▜\n";
		e += "▌  ▞ ▝▖  ▐\n";
		e += "▌  ▌  ▌  ▐\n";
		e += "▌  ▝▄▞   ▐\n";
		e += "▙▄▄▄▄▄▄▄▄▟";
		assertEquals(e, s);
	}

	@Test
	public void test12() {
		IRender render = new Render();
		render.setPseudoCanvas(true);
		IContextBuilder builder = render.newBuilder();
		builder.width(102).height(20);
		builder.element(new PseudoText("PseudoText", false));
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
		@SuppressWarnings("unused")
		String e = "";
		e += "                                                   \n";
		e += "                        ▄                          \n";
		e += "▐▛▀▙                    █      ▀▀█▀▀            ▐▌ \n";
		e += "▐▌ ▐▌ ▗▄▄   ▄▄  ▄  ▄  ▄▖█  ▗▄▖   █   ▗▄▖  ▄▖▗▄ ▗▟▙▄\n";
		e += "▐▌ ▟▘▐▌  ▘ ▟▘▝▙ █  █ ▟▘▝█ ▗▛ ▜▖  █  ▗▛ ▜▖ ▝██▘  ▐▌ \n";
		e += "▐▛▀▘ ▝██▙▖ █▄▄█ █  █ █  █ ▐▌ ▐▌  █  ▐▙▄▟▌  ▐▌   ▐▌ \n";
		e += "▐▌      ▜▌ █    █  █ █  █ ▐▌ ▐▌  █  ▐▌     ██   ▐▌ \n";
		e += "▐▌   ▝▄▄▞▘ ▝▙▄▞ ▜▙▞█ ▝▙▞█  ▜▄▛   █   ▜▄▄▘ ▟▌▐▙  ▝▙▄\n";
		e += "                                                   \n";
		e += "                                                   ";
		// Do not test this, because AWT produce different environment-specific results
		// assertEquals(e, s);
	}

	@Test
	public void test13() {
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
		render.setPseudoCanvas(true);
		IContextBuilder builder = render.newBuilder();
		builder.width(160).height(40);
		builder.element(new Axis(points, new Region(0, 0, 160, 40)));
		builder.element(new Plot(points, new Region(0, 0, 160, 40)));
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
		String expected = "";
		expected += "▌               ▐                                       ▌                       \n";
		expected += "▌               ▞                                      ▗▘                       \n";
		expected += "▌              ▗▘                                      ▞                        \n";
		expected += "▌             ▗▌                                      ▟                         \n";
		expected += "▌            ▗▞                                      ▄▘                         \n";
		expected += "▌           ▄▛                                     ▗▟▘                          \n";
		expected += "▌         ▄▛▘                                    ▗▟▀                            \n";
		expected += "▌      ▄▄▀▘                                   ▗▄▞▀                              \n";
		expected += "▌  ▄▄▛▀▘                                  ▗▄▟▀▀                                 \n";
		expected += "▛▀▀                                  ▗▄▄▀▀▘                                  ▄▄▞\n";
		expected += "▌                                ▄▄▛▀▘                                  ▗▄▟▀▀   \n";
		expected += "▌                             ▄▞▀▘                                   ▗▄▀▀       \n";
		expected += "▌                           ▄▛▘                                    ▗▟▀          \n";
		expected += "▌                         ▗▛▘                                     ▟▀            \n";
		expected += "▌                        ▗▀                                      ▞▘             \n";
		expected += "▌                        ▛                                      ▐▘              \n";
		expected += "▌                       ▞                                      ▗▘               \n";
		expected += "▌                      ▗▘                                      ▞                \n";
		expected += "▌                      ▐                                       ▘                \n";
		expected += "▙▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▙▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄";
		assertEquals(expected, s);
	}

	@Test
	public void test14() {
		IRender render = new Render();
		render.setPseudoCanvas(true);
		IContextBuilder builder = render.newBuilder();
		builder.width(72).height(14);
		Table table = new Table(4, 3);
		table.setHighlighted(2, 3, true);
		builder.element(table);
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
		String e = "";
		e += "▛▀▀▀▀▀▀▀▀▛▀▀▀▀▀▀▀▀▛▀▀▀▀▀▀▀▀▛▀▀▀▀▀▀▀▜\n";
		e += "▌        ▌        ▌        ▌       ▐\n";
		e += "▛▀▀▀▀▀▀▀▀▛▀▀▀▀▀▀▀▀▛▀▀▀▀▀▀▀▀▛▀▀▀▀▀▀▀▜\n";
		e += "▌        ▌        ▌        ▌       ▐\n";
		e += "▙▄▄▄▄▄▄▄▄▙▄▄▄▄▄▄▄▄▙▄▄▄▄▄▄▄▄▙▄▄▄▄▄▄▄▟\n";
		e += "▌        ▌        ▌        ▌       ▐\n";
		e += "▙▄▄▄▄▄▄▄▄▙▄▄▄▄▄▄▄▄▙▄▄▄▄▄▄▄▄▙▄▄▄▄▄▄▄▟";
		assertEquals(e, s);
	}
}
