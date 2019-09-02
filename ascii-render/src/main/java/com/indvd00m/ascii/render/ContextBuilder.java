package com.indvd00m.ascii.render;

import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IElement;
import com.indvd00m.ascii.render.api.ILayer;
import com.indvd00m.ascii.render.api.IRegion;
import com.indvd00m.ascii.render.api.ITypedIdentified;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 1.0.0
 */
public class ContextBuilder implements IContextBuilder {

	protected int width;
	protected int height;
	protected List<ILayer> layers = new ArrayList<ILayer>();

	// cache
	protected Map<IElement, Set<ILayer>> layersByElement = new HashMap<IElement, Set<ILayer>>();
	protected Map<Class<IElement>, Set<IElement>> elementsByClass = new HashMap<Class<IElement>, Set<IElement>>();
	protected Map<Class<ITypedIdentified<?>>, Map<Integer, ITypedIdentified<?>>> identifiedByType = new HashMap<Class<ITypedIdentified<?>>, Map<Integer, ITypedIdentified<?>>>();

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

		Collection<Class<?>> ancestors = getAncestors(element.getClass());
		{
			for (Class<?> clazz : ancestors) {
				Set<IElement> set = elementsByClass.get(clazz);
				if (set == null) {
					set = new LinkedHashSet<IElement>();
					elementsByClass.put((Class<IElement>) clazz, set);
				}
				set.add(element);
			}
		}

		{
			for (Class<?> clazz : ancestors) {
				if (ITypedIdentified.class.isAssignableFrom(clazz)) {
					ITypedIdentified<?> ti = (ITypedIdentified<?>) element;
					int typedId = ti.getTypedId();
					Map<Integer, ITypedIdentified<?>> map = identifiedByType.get(clazz);
					if (map == null) {
						map = new HashMap<Integer, ITypedIdentified<?>>();
						identifiedByType.put((Class<ITypedIdentified<?>>) clazz, map);
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
	public IContextBuilder layer(int x, int y, int width, int height) {
		return layer(new Region(x, y, width, height));
	}

	@Override
	public IContextBuilder layer(IElement... elements) {
		Layer layer = new Layer(new Region(0, 0, width, height));
		addLayer(layer);
		for (IElement element : elements) {
			addElementToLayer(layer, element);
		}
		return this;
	}

	@Override
	public IContextBuilder layer(IRegion region, IElement... elements) {
		Layer layer = new Layer(region);
		addLayer(layer);
		for (IElement element : elements) {
			addElementToLayer(layer, element);
		}
		return this;
	}

	@Override
	public IContextBuilder layer(int x, int y, int width, int height, IElement... elements) {
		return layer(new Region(x, y, width, height), elements);
	}

	@Override
	public IContextBuilder layer(List<IElement> elements) {
		Layer layer = new Layer(new Region(0, 0, width, height));
		addLayer(layer);
		for (IElement element : elements) {
			addElementToLayer(layer, element);
		}
		return this;
	}

	@Override
	public IContextBuilder layer(IRegion region, List<IElement> elements) {
		Layer layer = new Layer(region);
		addLayer(layer);
		for (IElement element : elements) {
			addElementToLayer(layer, element);
		}
		return this;
	}

	@Override
	public IContextBuilder layer(int x, int y, int width, int height, List<IElement> elements) {
		return layer(new Region(x, y, width, height), elements);
	}

	@Override
	public IContextBuilder opacity(boolean opacity) {
		if (layers.isEmpty()) {
			layer();
		}
		Layer layer = (Layer) layers.get(layers.size() - 1);
		layer.opacity = opacity;
		return this;
	}

	@Override
	public IContextBuilder element(IElement element) {
		if (layers.isEmpty()) {
			layer();
		}
		Layer layer = (Layer) layers.get(layers.size() - 1);
		addElementToLayer(layer, element);
		return this;
	}

	@Override
	public IContextBuilder elements(IElement... elements) {
		if (layers.isEmpty()) {
			layer();
		}
		Layer layer = (Layer) layers.get(layers.size() - 1);
		for (IElement element : elements) {
			addElementToLayer(layer, element);
		}
		return this;
	}

	@Override
	public IContextBuilder elements(List<IElement> elements) {
		if (layers.isEmpty()) {
			layer();
		}
		Layer layer = (Layer) layers.get(layers.size() - 1);
		for (IElement element : elements) {
			addElementToLayer(layer, element);
		}
		return this;
	}

	protected LinkedHashSet<Class<?>> getAncestors(Class<?> clazz) {
		LinkedHashSet<Class<?>> ancestors = new LinkedHashSet<Class<?>>();

		if (clazz == null) {
			return ancestors;
		}

		ancestors.add(clazz);
		for (Class<?> iClazz : clazz.getInterfaces()) {
			ancestors.add(iClazz);
		}

		ancestors.addAll(getAncestors(clazz.getSuperclass()));

		return ancestors;
	}

}
