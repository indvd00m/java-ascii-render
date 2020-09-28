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
 * @since 0.9.0
 */
public class Render implements IRender {

	protected boolean pseudoCanvas;

	@Override
	public IContextBuilder newBuilder() {
		return ContextBuilder.newBuilder();
	}

	@Override
	public ICanvas render(IContext context) {
		final ICanvas canvas;
		if (pseudoCanvas) {
			canvas = new PseudoCanvas(context.getWidth(), context.getHeight());
		} else {
			canvas = new Canvas(context.getWidth(), context.getHeight());
		}
		for (ILayer layer : context.getLayers()) {
			IRegion region = layer.getRegion();
			ICanvas layerCanvas = new Canvas(region.getWidth(), region.getHeight());
			for (IElement element : layer.getElements()) {
				element.draw(layerCanvas, context);
			}
			drawOver(canvas, layerCanvas, layer, region);
		}
		return canvas;
	}

	protected void drawOver(ICanvas c1, ICanvas c2, ILayer layer, IRegion region) {
		boolean opacity = layer.isOpacity();
		for (int c1x = region.getX(); c1x < region.getX() + region.getWidth(); c1x++) {
			for (int c1y = region.getY(); c1y < region.getY() + region.getHeight(); c1y++) {
				int c2x = c1x - region.getX();
				int c2y = c1y - region.getY();
				if (opacity || c2.isCharDrawed(c2x, c2y)) {
					char c = c2.getChar(c2x, c2y);
					c1.draw(c1x, c1y, c);
				}
			}
		}
	}

	@Override
	public boolean isPseudoCanvas() {
		return pseudoCanvas;
	}

	@Override
	public void setPseudoCanvas(boolean pseudoCanvas) {
		this.pseudoCanvas = pseudoCanvas;
	}
}
