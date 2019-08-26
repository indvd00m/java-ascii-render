package com.indvd00m.ascii.render.tests.plot;

import com.indvd00m.ascii.render.Region;
import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IRender;
import com.indvd00m.ascii.render.elements.Rectangle;
import com.indvd00m.ascii.render.elements.plot.Axis;
import com.indvd00m.ascii.render.elements.plot.AxisLabels;
import com.indvd00m.ascii.render.elements.plot.Plot;
import com.indvd00m.ascii.render.elements.plot.api.IPlotPoint;
import com.indvd00m.ascii.render.elements.plot.misc.PlotPoint;
import com.indvd00m.ascii.render.tests.plot.impl.AxisConvertedTestLabels;
import com.indvd00m.ascii.render.tests.plot.impl.AxisTestLabels;
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
public class TestFullPlott {

	@Before
	public void setUpLocale() throws Exception {
		Locale.setDefault(Locale.ENGLISH);
	}

	@Test
	public void test01() {
		List<IPlotPoint> points = new ArrayList<IPlotPoint>();
		for (int degree = 0; degree <= 360; degree++) {
			double val = Math.sin(Math.toRadians(degree));
			IPlotPoint plotPoint = new PlotPoint(degree, val);
			points.add(plotPoint);
		}
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		Region region = new Region(0, 0, 80, 20);
		builder.width(region.getWidth()).height(region.getHeight());
		builder.element(new Axis(points, region));
		builder.element(new AxisLabels(points, region));
		builder.element(new Plot(points, region));
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
		String expected = "";
		expected += " 1.00┼            ************                                                  \n";
		expected += "     │          ***           ***                                               \n";
		expected += "     │        **                ***                                             \n";
		expected += "     │      ***                   ***                                           \n";
		expected += "     │     **                       **                                          \n";
		expected += " 0.50┼   **                          **                                         \n";
		expected += "     │  **                             **                                       \n";
		expected += "     │***                               **                                      \n";
		expected += "     │*                                  ***                                  **\n";
		expected += " 0.00┼                                     **                               *** \n";
		expected += "     │                                      **                             **   \n";
		expected += "     │                                        **                          **    \n";
		expected += "     │                                         **                       **      \n";
		expected += "     │                                          ***                   ***       \n";
		expected += "-0.50┼                                            ***                **         \n";
		expected += "     │                                              ***           ***           \n";
		expected += "     │                                                 ************             \n";
		expected += "     │                                                      *                   \n";
		expected += "-1.00┼─────────────────┼──────────────────┼──────────────────┼─────────────────┼\n";
		expected += "     0                90                 180                270              360";
		assertEquals(expected, s);
	}

	@Test
	public void test02() {
		List<IPlotPoint> points = new ArrayList<IPlotPoint>();
		for (int degree = 0; degree <= 360; degree++) {
			double val = Math.sin(Math.toRadians(degree));
			IPlotPoint plotPoint = new PlotPoint(degree, val);
			points.add(plotPoint);
		}
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(27).height(8);
		builder.element(new Rectangle(0, 0, 27, 8));
		builder.layer(new Region(1, 1, 25, 6));
		builder.element(new Axis(points, new Region(0, 0, 25, 6)));
		builder.element(new AxisLabels(points, new Region(0, 0, 25, 6)));
		builder.element(new Plot(points, new Region(0, 0, 25, 6)));
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
		String expected = "";
		expected += "┌─────────────────────────┐\n";
		expected += "│ 1.00┼ ********          │\n";
		expected += "│ 0.50┼*       **       **│\n";
		expected += "│ 0.00┼          ******** │\n";
		expected += "│-0.50┼             *     │\n";
		expected += "│-1.00┼────┼────┼────┼───┼│\n";
		expected += "│     0   90   180  270360│\n";
		expected += "└─────────────────────────┘";
		assertEquals(expected, s);
	}

	@Test
	public void test03() {
		List<IPlotPoint> points = new ArrayList<IPlotPoint>();
		for (int degree = 0; degree <= 360; degree++) {
			double val = Math.cos(Math.toRadians(degree));
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
		expected += "│ 1.00┼******                                                           *******│\n";
		expected += "│     │     ****                                                     ****      │\n";
		expected += "│     │        ***                                                 ***         │\n";
		expected += "│     │          ***                                             ***           │\n";
		expected += "│ 0.50┼            **                                           **             │\n";
		expected += "│     │              **                                       **               │\n";
		expected += "│     │               **                                     **                │\n";
		expected += "│     │                 **                                 **                  │\n";
		expected += "│ 0.00┼                  **                               **                   │\n";
		expected += "│     │                    **                           **                     │\n";
		expected += "│     │                     ***                       ***                      │\n";
		expected += "│     │                       **                     **                        │\n";
		expected += "│-0.50┼                         ***               ***                          │\n";
		expected += "│     │                           ***           ***                            │\n";
		expected += "│     │                             *************                              │\n";
		expected += "│     │                                   *                                    │\n";
		expected += "│-1.00┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼│\n";
		expected += "│     0                90                180               270              360│\n";
		expected += "└──────────────────────────────────────────────────────────────────────────────┘";
		assertEquals(expected, s);
	}

	@Test
	public void test04() {
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
	public void test05() {
		List<IPlotPoint> points = new ArrayList<IPlotPoint>();
		for (double x = 0; x < 5; x += 0.01) {
			double val = Math.exp(x);
			IPlotPoint plotPoint = new PlotPoint(x, val);
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
		expected += "│148┼                                                                        **│\n";
		expected += "│   │                                                                      **  │\n";
		expected += "│   │                                                                     **   │\n";
		expected += "│   │                                                                    **    │\n";
		expected += "│111┼                                                                   **     │\n";
		expected += "│   │                                                                 ***      │\n";
		expected += "│   │                                                               ***        │\n";
		expected += "│   │                                                              **          │\n";
		expected += "│ 74┼                                                           ***            │\n";
		expected += "│   │                                                         ***              │\n";
		expected += "│   │                                                      ****                │\n";
		expected += "│   │                                                 *****                    │\n";
		expected += "│ 37┼                                            ******                        │\n";
		expected += "│   │                                  ***********                             │\n";
		expected += "│   │***********************************                                       │\n";
		expected += "│   │*                                                                         │\n";
		expected += "│  1┼─────────────────┼──────────────────┼──────────────────┼─────────────────┼│\n";
		expected += "│   0.00            1.25               2.50               3.75             5.00│\n";
		expected += "└──────────────────────────────────────────────────────────────────────────────┘";
		assertEquals(expected, s);
	}

	@Test
	public void test06() {
		List<IPlotPoint> points = new ArrayList<IPlotPoint>();
		for (double x = 0; x < 5; x += 0.01) {
			double val = Math.exp(x);
			IPlotPoint plotPoint = new PlotPoint(x, val);
			points.add(plotPoint);
		}
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(80).height(20);
		builder.element(new Rectangle(0, 0, 80, 20));
		builder.layer(new Region(1, 1, 78, 18));
		builder.element(new Axis(points, new Region(0, 0, 78, 18)));
		builder.element(new AxisTestLabels(points, new Region(0, 0, 78, 18)));
		builder.element(new Plot(points, new Region(0, 0, 78, 18)));
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
		String expected = "";
		expected += "┌──────────────────────────────────────────────────────────────────────────────┐\n";
		expected += "│148┼                                                                        **│\n";
		expected += "│   │                                                                      **  │\n";
		expected += "│   │                                                                     **   │\n";
		expected += "│   │                                                                    **    │\n";
		expected += "│111┼                                                                   **     │\n";
		expected += "│   │                                                                 ***      │\n";
		expected += "│   │                                                               ***        │\n";
		expected += "│   │                                                              **          │\n";
		expected += "│ 74┼                                                           ***            │\n";
		expected += "│   │                                                         ***              │\n";
		expected += "│   │                                                      ****                │\n";
		expected += "│   │                                                 *****                    │\n";
		expected += "│ 37┼                                            ******                        │\n";
		expected += "│   │                                  ***********                             │\n";
		expected += "│   │***********************************                                       │\n";
		expected += "│   │*                                                                         │\n";
		expected += "│  1┼─────────────────┼──────────────────┼──────────────────┼─────────────────┼│\n";
		expected += "│   0.00            1.25               2.50               3.75             5.00│\n";
		expected += "└──────────────────────────────────────────────────────────────────────────────┘";
		assertEquals(expected, s);
	}

	@Test
	public void test07() {
		List<IPlotPoint> points = new ArrayList<IPlotPoint>();
		for (double x = 0; x < 5; x += 0.01) {
			double val = Math.exp(x);
			IPlotPoint plotPoint = new PlotPoint(x, val);
			points.add(plotPoint);
		}
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(80).height(20);
		builder.element(new Rectangle(0, 0, 80, 20));
		builder.layer(new Region(1, 1, 78, 18));
		builder.element(new Axis(points, new Region(0, 0, 78, 18)));
		builder.element(new AxisConvertedTestLabels(points, new Region(0, 0, 78, 18)));
		builder.element(new Plot(points, new Region(0, 0, 78, 18)));
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
		String expected = "";
		expected += "┌──────────────────────────────────────────────────────────────────────────────┐\n";
		expected += "│1,484┼                                                                      **│\n";
		expected += "│     │                                                                     ** │\n";
		expected += "│     │                                                                   **   │\n";
		expected += "│     │                                                                  **    │\n";
		expected += "│1,115┼                                                                 **     │\n";
		expected += "│     │                                                               ***      │\n";
		expected += "│     │                                                              **        │\n";
		expected += "│     │                                                            ***         │\n";
		expected += "│  747┼                                                          ***           │\n";
		expected += "│     │                                                       ****             │\n";
		expected += "│     │                                                    ****                │\n";
		expected += "│     │                                                *****                   │\n";
		expected += "│  378┼                                           ******                       │\n";
		expected += "│     │                                 **********                             │\n";
		expected += "│     │**********************************                                      │\n";
		expected += "│     │*                                                                       │\n";
		expected += "│   10┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼│\n";
		expected += "│     0.00            12.50             25.00             37.50           50.00│\n";
		expected += "└──────────────────────────────────────────────────────────────────────────────┘";
		assertEquals(expected, s);
	}

}
