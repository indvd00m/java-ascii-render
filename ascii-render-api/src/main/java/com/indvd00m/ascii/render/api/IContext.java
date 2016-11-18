package com.indvd00m.ascii.render.api;

import java.util.List;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-17 3:46:21 PM
 *
 */
public interface IContext {

	int getWidth();

	int getHeight();

	List<ILayer> getLayers();

	ILayer createLayer();

	ILayer createLayer(IRegion region);

	void removeLayer(ILayer layer);

	int setLayerIndex(ILayer layer, int newIndex);

}
