package com.indvd00m.ascii.render.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.indvd00m.ascii.render.Point;
import com.indvd00m.ascii.render.Region;
import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.ILayer;
import com.indvd00m.ascii.render.api.IRender;
import com.indvd00m.ascii.render.elements.Circle;
import com.indvd00m.ascii.render.elements.Rectangle;
import com.indvd00m.ascii.render.elements.line.Line;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-17 5:15:07 PM
 *
 */
public class TestRender {

	@Test
	public void test() {
		IRender render = new Render();
		IContext context = render.createContext(80, 20);
		ILayer layer1 = context.createLayer();
		layer1.addElement(new Circle(30, 10, 8));
		layer1.addElement(new Circle(50, 10, 8));
		ILayer layer2 = context.createLayer();
		layer2.addElement(new Rectangle(22, 2, 17, 17));

		ICanvas canvas = render.render(context);
		String text = canvas.getText();
		System.out.println(text);

		context.setLayerIndex(layer2, 0);

		canvas = render.render(context);
		text = canvas.getText();
		System.out.println(text);

		ILayer layer3 = context.createLayer(new Region(5, 5, 10, 10));
		layer3.addElement(new Line(new Point(-30, -30), new Point(200, 200)));
		layer3.addElement(new Rectangle(0, 0, layer3.getRegion().getWidth(), layer3.getRegion().getHeight()));

		canvas = render.render(context);
		text = canvas.getText();
		System.out.println(text);

		ILayer layer4 = context.createLayer(new Region(6, 6, 10, 10));
		layer4.addElement(new Rectangle(0, 0, layer4.getRegion().getWidth(), layer4.getRegion().getHeight()));

		canvas = render.render(context);
		text = canvas.getText();
		System.out.println(text);

		ILayer layer5 = context.createLayer(new Region(4, 6, 10, 10));
		layer5.addElement(new Rectangle(0, 0, layer5.getRegion().getWidth(), layer5.getRegion().getHeight()));

		canvas = render.render(context);
		text = canvas.getText();
		System.out.println(text);

		ILayer layer6 = context.createLayer(new Region(4, 4, 10, 10));
		layer6.addElement(new Rectangle(0, 0, layer6.getRegion().getWidth(), layer6.getRegion().getHeight()));

		canvas = render.render(context);
		text = canvas.getText();
		System.out.println(text);

		ILayer layer7 = context.createLayer(new Region(6, 4, 10, 10));
		layer7.addElement(new Rectangle(0, 0, layer7.getRegion().getWidth(), layer7.getRegion().getHeight()));

		canvas = render.render(context);
		text = canvas.getText();
		System.out.println(text);

		for (int i = 0; i < 5; i++) {
			ILayer layer = context.createLayer(new Region(60 + i, 5 + i, 7, 7));
			layer.addElement(new Rectangle(0, 0, layer.getRegion().getWidth(), layer.getRegion().getHeight()));
		}

		canvas = render.render(context);
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
		expected += "    │││*     │││      │*             *│    *             *  ││┌─────┐           \n";
		expected += "    │││ *    │││      *               *   *               * │││┌─────┐          \n";
		expected += "    │││  *   │││      *               *   *               * ││││┌─────┐         \n";
		expected += "    │││   *  │││      *               *   *               * │││││ │││││         \n";
		expected += "    │││    **│││      *               *   *               * └││││─┘││││         \n";
		expected += "    │││    **│││      *               *   *               *  └│││──┘│││         \n";
		expected += "    └─└────────┘      │*             *│    *             *    └││───┘││         \n";
		expected += "    │└│──────│┘│      │*             *│    *             *     └│────┘│         \n";
		expected += "    └────────┘─┘      │ *           * │     *           *       └─────┘         \n";
		expected += "                      │ **         ** │     **         **                       \n";
		expected += "                      │   **     **   │       **     **                         \n";
		expected += "                      └─────*****─────┘         *****                           \n";
		expected += "                                                                                ";

		assertEquals(expected, text);
	}

}
