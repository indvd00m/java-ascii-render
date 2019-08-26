package com.indvd00m.ascii.render.api;

/**
 * A render. Render can create and render contexts.
 *
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 0.9.0
 */
public interface IRender {

	/**
	 * New context builder.
	 *
	 * @return
	 */
	IContextBuilder newBuilder();

	/**
	 * Render context to canvas.
	 *
	 * @param context
	 * @return
	 */
	ICanvas render(IContext context);

}
