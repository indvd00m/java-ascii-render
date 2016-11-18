package com.indvd00m.ascii.render;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.ILayer;
import com.indvd00m.ascii.render.api.IRegion;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-17 5:49:09 PM
 *
 */
public class Context implements IContext {

	int width;
	int height;
	List<ILayer> layers = new ArrayList<ILayer>();

	public Context(int width, int heifht) {
		super();
		this.width = width;
		this.height = heifht;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public List<ILayer> getLayers() {
		return Collections.unmodifiableList(layers);
	}

	@Override
	public ILayer createLayer() {
		return createLayer(new Region(0, 0, width, height));
	}

	@Override
	public ILayer createLayer(IRegion region) {
		Layer layer = new Layer(region);
		layers.add(layer);
		return layer;
	}

	@Override
	public void removeLayer(ILayer layer) {
		layers.remove(layer);
	}

	@Override
	public int setLayerIndex(ILayer layer, int newIndex) {
		int index = layers.indexOf(layer);
		if (index == -1)
			return index;
		ILayer prevLayer = layers.set(newIndex, layer);
		layers.set(index, prevLayer);
		return index;
	}

}
