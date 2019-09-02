package com.indvd00m.ascii.render.tests.plot;

import com.indvd00m.ascii.render.Region;
import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IRender;
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
public class TestPlot {

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
		builder.width(12).height(7);
		builder.layer(new Region(1, 1, 10, 5));
		builder.element(new Plot(points, new Region(0, 0, 10, 5)));
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
		String expected = "";
		expected += "            \n";
		expected += " ****       \n";
		expected += " *  **      \n";
		expected += " *   **  ** \n";
		expected += "      ****  \n";
		expected += "       *    \n";
		expected += "            ";
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
		Region region = new Region(0, 0, 80, 20);
		builder.width(region.getWidth()).height(region.getHeight()).element(new Plot(points, region));
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
		String expected = "";
		expected += "              ************                                                      \n";
		expected += "           ***           ***                                                    \n";
		expected += "         ***                **                                                  \n";
		expected += "       ***                    **                                                \n";
		expected += "      **                       ***                                              \n";
		expected += "    ***                          **                                             \n";
		expected += "   **                             **                                            \n";
		expected += "  **                                **                                          \n";
		expected += "**                                   **                                         \n";
		expected += "*                                     ***                                     **\n";
		expected += "                                        **                                   ** \n";
		expected += "                                         **                                **   \n";
		expected += "                                           **                             **    \n";
		expected += "                                            **                          ***     \n";
		expected += "                                             ***                       **       \n";
		expected += "                                               **                    ***        \n";
		expected += "                                                 **                ***          \n";
		expected += "                                                   ***           ***            \n";
		expected += "                                                     ************               \n";
		expected += "                                                           *                    ";
		assertEquals(expected, s);
	}

}
