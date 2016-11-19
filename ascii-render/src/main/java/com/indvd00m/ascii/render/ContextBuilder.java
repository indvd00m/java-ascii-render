package com.indvd00m.ascii.render;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IElement;
import com.indvd00m.ascii.render.api.ILayer;
import com.indvd00m.ascii.render.api.IRegion;
import com.indvd00m.ascii.render.api.ITypedIdentified;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-18 11:59:26 PM
 *
 */
public class ContextBuilder implements IContextBuilder {

	int width;
	int height;
	List<ILayer> layers = new ArrayList<ILayer>();

	// cache
	Map<IElement, Set<ILayer>> layersByElement = new HashMap<IElement, Set<ILayer>>();
	Map<Class<IElement>, Set<IElement>> elementsByClass = new HashMap<Class<IElement>, Set<IElement>>();
	Map<Class<ITypedIdentified<?>>, Map<Integer, ITypedIdentified<?>>> identifiedByType = new HashMap<Class<ITypedIdentified<?>>, Map<Integer, ITypedIdentified<?>>>();

	public static IContextBuilder newBuilder() {
		return new ContextBuilder();
	}

	@Override
	public IContext build() {
		Context context = new Context();
		context.height = height;
		context.width = width;
		context.layers.addAll(layers);
		context.layersByElement.putAll(layersByElement);
		context.elementsByClass.putAll(elementsByClass);
		context.identifiedByType.putAll(identifiedByType);
		return context;
	}

	@Override
	public IContextBuilder width(int width) {
		this.width = width;
		return this;
	}

	@Override
	public IContextBuilder height(int height) {
		this.height = height;
		return this;
	}

	void addLayer(Layer layer) {
		layers.add(layer);

	}

	@SuppressWarnings("unchecked")
	void addElementToLayer(Layer layer, IElement element) {
		layer.elements.add(element);

		{
			Set<ILayer> set = layersByElement.get(element);
			if (set == null) {
				set = new LinkedHashSet<ILayer>();
				layersByElement.put(element, set);
			}
			set.add(layer);
		}

		{
			Set<IElement> set = elementsByClass.get(element.getClass());
			if (set == null) {
				set = new LinkedHashSet<IElement>();
				elementsByClass.put((Class<IElement>) element.getClass(), set);
			}
			set.add(element);
		}

		{
			for (Object o : new Object[] {
					layer,
					element
			}) {
				if (o instanceof ITypedIdentified) {
					ITypedIdentified<?> ti = (ITypedIdentified<?>) o;
					Class<?> type = ti.getType();
					int typedId = ti.getTypedId();
					Map<Integer, ITypedIdentified<?>> map = identifiedByType.get(type);
					if (map == null) {
						map = new HashMap<Integer, ITypedIdentified<?>>();
						identifiedByType.put((Class<ITypedIdentified<?>>) type, map);
					}
					map.put(typedId, ti);
				}
			}
		}
	}

	@Override
	public IContextBuilder layer() {
		Layer layer = new Layer(new Region(0, 0, width, height));
		addLayer(layer);
		return this;
	}

	@Override
	public IContextBuilder layer(IRegion region) {
		Layer layer = new Layer(region);
		addLayer(layer);
		return this;
	}

	@Override
	public IContextBuilder layer(IElement... elements) {
		Layer layer = new Layer(new Region(0, 0, width, height));
		addLayer(layer);
		for (IElement element : elements)
			addElementToLayer(layer, element);
		return this;
	}

	@Override
	public IContextBuilder layer(IRegion region, IElement... elements) {
		Layer layer = new Layer(region);
		addLayer(layer);
		for (IElement element : elements)
			addElementToLayer(layer, element);
		return this;
	}

	@Override
	public IContextBuilder layer(List<IElement> elements) {
		Layer layer = new Layer(new Region(0, 0, width, height));
		addLayer(layer);
		for (IElement element : elements)
			addElementToLayer(layer, element);
		return this;
	}

	@Override
	public IContextBuilder layer(IRegion region, List<IElement> elements) {
		Layer layer = new Layer(region);
		addLayer(layer);
		for (IElement element : elements)
			addElementToLayer(layer, element);
		return this;
	}

	@Override
	public IContextBuilder element(IElement element) {
		if (layers.isEmpty())
			layer();
		Layer layer = (Layer) layers.get(layers.size() - 1);
		addElementToLayer(layer, element);
		return this;
	}

	@Override
	public IContextBuilder elements(IElement... elements) {
		if (layers.isEmpty())
			layer();
		Layer layer = (Layer) layers.get(layers.size() - 1);
		for (IElement element : elements)
			addElementToLayer(layer, element);
		return this;
	}

	@Override
	public IContextBuilder elements(List<IElement> elements) {
		if (layers.isEmpty())
			layer();
		Layer layer = (Layer) layers.get(layers.size() - 1);
		for (IElement element : elements)
			addElementToLayer(layer, element);
		return this;
	}

}
