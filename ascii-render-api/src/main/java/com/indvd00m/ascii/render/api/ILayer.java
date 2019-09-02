package com.indvd00m.ascii.render.api;

import java.util.List;

/**
 * Layer object. Layer has a fixed size and position relative to context. Layer contains list of elements.
 *
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 0.9.0
 */
public interface ILayer {

	/**
	 * Region of this layer in Context coordinates.
	 *
	 * @return
	 */
	IRegion getRegion();

	/**
	 * List of elements. Elements will be drawn by render in order of this list.
	 *
	 * @return
	 */
	List<IElement> getElements();

	/**
	 * Opacity of this layer. {@code False} by default.
	 *
	 * @return
	 */
	boolean isOpacity();

}
