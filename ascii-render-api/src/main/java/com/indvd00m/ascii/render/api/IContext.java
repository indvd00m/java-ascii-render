package com.indvd00m.ascii.render.api;

import java.util.List;

/**
 * Context object. Context contains layers which contains elements. Every layer has region, in which it will be drawn. Only content from this layer region will
 * be drawn in render. Layers contained in a particular order and will be drawn in this order.
 * 
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-17 3:46:21 PM
 *
 */
public interface IContext {

	/**
	 * @return Width of context.
	 */
	int getWidth();

	/**
	 * @return Height of context.
	 */
	int getHeight();

	/**
	 * @return Layers list.
	 */
	List<ILayer> getLayers();

	/**
	 * Create new layer and add him to context in a context region <tt>(0, 0, width, height)</tt>.
	 * 
	 * @return
	 */
	ILayer createLayer();

	/**
	 * Create new layer and add him to context in a specific region.
	 * 
	 * @param region
	 * @return
	 */
	ILayer createLayer(IRegion region);

	/**
	 * Remove layer.
	 * 
	 * @param layer
	 */
	void removeLayer(ILayer layer);

	/**
	 * Set layer index.
	 * 
	 * @param layer
	 * @param newIndex
	 * @return
	 */
	int setLayerIndex(ILayer layer, int newIndex);

}
