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
	 * @return Region of this layer in Context coordinates.
	 */
	IRegion getRegion();

	/**
	 * @return List of elements. Elements will be drawn by render in order of this list.
	 */
	List<IElement> getElements();

	/**
	 * Add element to layer.
	 * 
	 * @param element
	 */
	void addElement(IElement element);

	/**
	 * Remove element from layer.
	 * 
	 * @param element
	 */
	void removeElement(IElement element);

	/**
	 * Insert element at position.
	 * 
	 * @param index
	 * @param element
	 */
	void insertElement(int index, IElement element);

}
