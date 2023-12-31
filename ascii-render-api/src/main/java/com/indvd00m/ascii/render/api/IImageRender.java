package com.indvd00m.ascii.render.api;

import java.awt.image.BufferedImage;

/**
 * An image render. Image render can create and render images from {@link ICanvas}.
 *
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 2.3.0
 */
public interface IImageRender {

	/**
	 * Render canvas to image. Width of image will be calculated
	 *
	 * @param canvas canvas of text
	 * @param height height of image in pixels
	 * @return
	 */
	BufferedImage render(ICanvas canvas, int height);

}
