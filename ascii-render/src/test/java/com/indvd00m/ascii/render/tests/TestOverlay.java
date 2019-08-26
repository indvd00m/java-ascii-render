package com.indvd00m.ascii.render.tests;

import com.indvd00m.ascii.render.Canvas;
import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IRender;
import com.indvd00m.ascii.render.elements.Dot;
import com.indvd00m.ascii.render.elements.Overlay;
import com.indvd00m.ascii.render.elements.Rectangle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 1.4.0
 */
public class TestOverlay {

	@Test
	public void test01() {
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(21).height(10);
		builder.element(new Rectangle());

		IContext overlayContext = mock(IContext.class);
		ICanvas overlayCanvas = new Canvas(10, 5);
		Rectangle e = new Rectangle();
		e.draw(overlayCanvas, overlayContext);
		Overlay overlay = new Overlay(1, 1, 10, 5, overlayCanvas);
		builder.element(overlay);

		IContext context = builder.build();
		ICanvas canvas = render.render(context);
		String s = "";
		s += "┌───────────────────┐\n";
		s += "│┌────────┐         │\n";
		s += "││        │         │\n";
		s += "││        │         │\n";
		s += "││        │         │\n";
		s += "│└────────┘         │\n";
		s += "│                   │\n";
		s += "│                   │\n";
		s += "│                   │\n";
		s += "└───────────────────┘";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test02() {
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(21).height(10);
		builder.element(new Rectangle());

		IContext overlayContext = mock(IContext.class);
		ICanvas overlayCanvas = new Canvas(12, 7);
		Rectangle e = new Rectangle(0, 0, 10, 5);
		e.draw(overlayCanvas, overlayContext);
		Overlay overlay = new Overlay(2, 2, 10, 5, overlayCanvas);
		builder.element(overlay);

		IContext context = builder.build();
		ICanvas canvas = render.render(context);
		String s = "";
		s += "┌───────────────────┐\n";
		s += "│                   │\n";
		s += "│ ┌────────┐        │\n";
		s += "│ │        │        │\n";
		s += "│ │        │        │\n";
		s += "│ │        │        │\n";
		s += "│ └────────┘        │\n";
		s += "│                   │\n";
		s += "│                   │\n";
		s += "└───────────────────┘";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test03() {
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(21).height(10);
		builder.element(new Rectangle());

		IContext overlayContext = mock(IContext.class);
		ICanvas overlayCanvas = new Canvas(12, 7);
		Rectangle e = new Rectangle(1, 1, 10, 5);
		e.draw(overlayCanvas, overlayContext);
		overlayCanvas = overlayCanvas.trim();
		Overlay overlay = new Overlay(2, 2, 9, 4, overlayCanvas);
		builder.element(overlay);

		IContext context = builder.build();
		ICanvas canvas = render.render(context);
		String s = "";
		s += "┌───────────────────┐\n";
		s += "│                   │\n";
		s += "│ ┌────────         │\n";
		s += "│ │                 │\n";
		s += "│ │                 │\n";
		s += "│ │                 │\n";
		s += "│                   │\n";
		s += "│                   │\n";
		s += "│                   │\n";
		s += "└───────────────────┘";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test04() {
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(21).height(10);
		builder.element(new Rectangle());

		IContext overlayContext = mock(IContext.class);
		ICanvas overlayCanvas = new Canvas(12, 7);
		Rectangle e = new Rectangle(1, 1, 10, 5);
		e.draw(overlayCanvas, overlayContext);
		overlayCanvas = overlayCanvas.trim();
		Overlay overlay = new Overlay(2, 2, 20, 15, overlayCanvas);
		builder.element(overlay);

		IContext context = builder.build();
		ICanvas canvas = render.render(context);
		String s = "";
		s += "┌───────────────────┐\n";
		s += "│                   │\n";
		s += "│ ┌────────┐        │\n";
		s += "│ │        │        │\n";
		s += "│ │        │        │\n";
		s += "│ │        │        │\n";
		s += "│ └────────┘        │\n";
		s += "│                   │\n";
		s += "│                   │\n";
		s += "└───────────────────┘";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test05() {
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(21).height(10);
		builder.element(new Rectangle());

		IContext overlayContext = mock(IContext.class);
		ICanvas overlayCanvas = new Canvas(30, 30);
		Rectangle e = new Rectangle(1, 1, 10, 5);
		e.draw(overlayCanvas, overlayContext);
		overlayCanvas = overlayCanvas.trim();
		Overlay overlay = new Overlay(2, 2, 20, 15, overlayCanvas);
		builder.element(overlay);

		IContext context = builder.build();
		ICanvas canvas = render.render(context);
		String s = "";
		s += "┌───────────────────┐\n";
		s += "│                   │\n";
		s += "│ ┌────────┐        │\n";
		s += "│ │        │        │\n";
		s += "│ │        │        │\n";
		s += "│ │        │        │\n";
		s += "│ └────────┘        │\n";
		s += "│                   │\n";
		s += "│                   │\n";
		s += "└───────────────────┘";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test06() {
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(21).height(10);
		builder.element(new Rectangle());
		builder.element(new Dot(7, 4));

		IContext overlayContext = mock(IContext.class);
		ICanvas overlayCanvas = new Canvas(12, 7);
		Rectangle e = new Rectangle(0, 0, 10, 5);
		e.draw(overlayCanvas, overlayContext);
		Overlay overlay = new Overlay(2, 2, 10, 5, overlayCanvas, false);
		builder.element(overlay);

		IContext context = builder.build();
		ICanvas canvas = render.render(context);
		String s = "";
		s += "┌───────────────────┐\n";
		s += "│                   │\n";
		s += "│ ┌────────┐        │\n";
		s += "│ │        │        │\n";
		s += "│ │    *   │        │\n";
		s += "│ │        │        │\n";
		s += "│ └────────┘        │\n";
		s += "│                   │\n";
		s += "│                   │\n";
		s += "└───────────────────┘";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test07() {
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(21).height(10);
		builder.element(new Rectangle());
		builder.element(new Dot(7, 4));

		IContext overlayContext = mock(IContext.class);
		ICanvas overlayCanvas = new Canvas(12, 7);
		Rectangle e = new Rectangle(0, 0, 10, 5);
		e.draw(overlayCanvas, overlayContext);
		Overlay overlay = new Overlay(2, 2, 10, 5, overlayCanvas, true);
		builder.element(overlay);

		IContext context = builder.build();
		ICanvas canvas = render.render(context);
		String s = "";
		s += "┌───────────────────┐\n";
		s += "│                   │\n";
		s += "│ ┌────────┐        │\n";
		s += "│ │        │        │\n";
		s += "│ │        │        │\n";
		s += "│ │        │        │\n";
		s += "│ └────────┘        │\n";
		s += "│                   │\n";
		s += "│                   │\n";
		s += "└───────────────────┘";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test08() {
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(21).height(10);
		builder.element(new Rectangle());
		builder.element(new Dot(7, 4));

		IContext overlayContext = mock(IContext.class);
		ICanvas overlayCanvas = new Canvas(12, 7);
		Rectangle e = new Rectangle(0, 0, 10, 5);
		e.draw(overlayCanvas, overlayContext);
		overlayCanvas.draw(2, 2, "*");
		Overlay overlay = new Overlay(2, 2, 10, 5, overlayCanvas, true);
		builder.element(overlay);

		IContext context = builder.build();
		ICanvas canvas = render.render(context);
		String s = "";
		s += "┌───────────────────┐\n";
		s += "│                   │\n";
		s += "│ ┌────────┐        │\n";
		s += "│ │        │        │\n";
		s += "│ │ *      │        │\n";
		s += "│ │        │        │\n";
		s += "│ └────────┘        │\n";
		s += "│                   │\n";
		s += "│                   │\n";
		s += "└───────────────────┘";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

}
