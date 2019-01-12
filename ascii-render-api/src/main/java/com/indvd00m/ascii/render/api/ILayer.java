package com.indvd00m.ascii.render.api;

import java.util.List;

/**
 * Layer object. Layer has a fixed size and position relative to context. Layer contains list of elements.
 * 
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-17 12:32:27 PM
 *
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
