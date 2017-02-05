package com.indvd00m.ascii.render.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IElement;
import com.indvd00m.ascii.render.api.IRender;
import com.indvd00m.ascii.render.elements.Dot;
import com.indvd00m.ascii.render.elements.Rectangle;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2017-Feb-04 7:18:18 AM
 *
 */
public class TestContext {

	@Test
	public void test01() {
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(20).height(10);
		Rectangle r1 = new Rectangle();
		builder.element(r1);
		Dot d1 = new Dot();
		builder.element(d1);
		IContext context = builder.build();
		assertEquals(r1, context.lookup(Rectangle.class));
		assertEquals(d1, context.lookup(Dot.class));
		assertTrue(context.lookupAll(Rectangle.class).contains(r1));
		assertTrue(context.lookupAll(Dot.class).contains(d1));
		assertTrue(context.lookupAll(IElement.class).contains(r1));
		assertTrue(context.lookupAll(IElement.class).contains(d1));
		assertFalse(context.lookupAll(IElement.class, false).contains(r1));
		assertFalse(context.lookupAll(IElement.class, false).contains(d1));
		assertEquals(2, context.lookupAll(IElement.class).size());
	}

}
