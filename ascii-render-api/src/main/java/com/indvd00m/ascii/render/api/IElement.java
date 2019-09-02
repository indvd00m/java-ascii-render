package com.indvd00m.ascii.render.api;

/**
 * Graphical element. It's may be a primitive, like {@code Line}, {@code Circle}, etc., or more complex object. Element
 * will be drawn in his layer.
 *
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 0.9.0
 */
public interface IElement {

	/**
	 * Draw element in canvas.
	 *
	 * @param canvas
	 * @param context
	 * @return Anchor point for this element in relative coordinates of his layer. If element was not be drawn, null
	 * must be returned.
	 */
	IPoint draw(ICanvas canvas, IContext context);

}
