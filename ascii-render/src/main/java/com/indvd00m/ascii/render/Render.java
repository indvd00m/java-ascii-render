package com.indvd00m.ascii.render;

import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IElement;
import com.indvd00m.ascii.render.api.ILayer;
import com.indvd00m.ascii.render.api.IRegion;
import com.indvd00m.ascii.render.api.IRender;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-17 6:02:13 PM
 *
 */
public class Render implements IRender {

	@Override
	public IContextBuilder newBuilder() {
		return ContextBuilder.newBuilder();
	}

	@Override
	public ICanvas render(IContext context) {
		ICanvas canvas = new Canvas(context.getWidth(), context.getHeight());
		for (ILayer layer : context.getLayers()) {
			IRegion region = layer.getRegion();
			ICanvas layerCanvas = new Canvas(region.getWidth(), region.getHeight());
			for (IElement element : layer.getElements()) {
				element.draw(layerCanvas, context);
			}
			drawOver(canvas, layerCanvas, region);
		}
		return canvas;
	}

	protected void drawOver(ICanvas c1, ICanvas c2, IRegion region) {
		for (int c1x = region.getX(); c1x < region.getX() + region.getWidth(); c1x++) {
			for (int c1y = region.getY(); c1y < region.getY() + region.getHeight(); c1y++) {
				int c2x = c1x - region.getX();
				int c2y = c1y - region.getY();
				char c = c2.getChar(c2x, c2y);
				if (c != 0 && c != ' ') {
					c1.draw(c1x, c1y, c + "");
				}
			}
		}
	}

}
