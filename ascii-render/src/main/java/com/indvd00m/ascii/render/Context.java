package com.indvd00m.ascii.render;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IElement;
import com.indvd00m.ascii.render.api.ILayer;
import com.indvd00m.ascii.render.api.IPoint;
import com.indvd00m.ascii.render.api.IRegion;
import com.indvd00m.ascii.render.api.TypedIdentified;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-17 5:49:09 PM
 *
 */
public class Context implements IContext {

	int width;
	int height;
	List<ILayer> layers = new ArrayList<ILayer>();

	// cache
	Map<IElement, Set<ILayer>> layersByElement = new HashMap<IElement, Set<ILayer>>();
	Map<Class<IElement>, Set<IElement>> elementsByClass = new HashMap<Class<IElement>, Set<IElement>>();
	Map<Class<TypedIdentified<?>>, Map<Integer, TypedIdentified<?>>> identifiedByType = new HashMap<Class<TypedIdentified<?>>, Map<Integer, TypedIdentified<?>>>();

	Context() {

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

	@SuppressWarnings("unchecked")
	@Override
	public <E extends IElement> E lookup(Class<E> clazz) {
		Set<IElement> elements = elementsByClass.get(clazz);
		if (elements != null && !elements.isEmpty())
			return (E) elements.iterator().next();
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E extends IElement> List<E> lookupAll(Class<E> clazz) {
		List<IElement> list = new ArrayList<IElement>();

		Set<IElement> elements = elementsByClass.get(clazz);
		if (elements == null)
			list.addAll(elements);

		return (List<E>) elements;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E extends IElement> E lookup(Class<E> clazz, ILayer layer) {
		Set<IElement> elements = elementsByClass.get(clazz);
		for (IElement e : elements) {
			Set<ILayer> elementLayers = layersByElement.get(e);
			if (elementLayers.contains(layer))
				return (E) e;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E extends IElement> List<E> lookupAll(Class<E> clazz, ILayer layer) {
		List<E> list = new ArrayList<E>();

		Set<IElement> elements = elementsByClass.get(clazz);
		for (IElement e : elements) {
			Set<ILayer> elementLayers = layersByElement.get(e);
			if (elementLayers.contains(layer))
				list.add((E) e);
		}

		return list;
	}

	@Override
	public ILayer lookupLayer(IElement element) {
		Set<ILayer> elementLayers = layersByElement.get(element);
		if (elementLayers != null && !elementLayers.isEmpty())
			return elementLayers.iterator().next();
		return null;
	}

	@Override
	public List<ILayer> lookupLayers(IElement element) {
		List<ILayer> list = new ArrayList<ILayer>();

		Set<ILayer> elementLayers = layersByElement.get(element);
		if (elementLayers != null)
			list.addAll(elementLayers);

		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends TypedIdentified<T>> T lookupTyped(Class<T> type, int id) {
		Map<Integer, TypedIdentified<?>> map = identifiedByType.get(type);
		if (map != null) {
			TypedIdentified<?> ti = map.get(id);
			return (T) ti;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends TypedIdentified<T>> List<T> lookupTyped(Class<T> type) {
		@SuppressWarnings("rawtypes")
		List list = new ArrayList();

		Map<Integer, TypedIdentified<?>> map = identifiedByType.get(type);
		if (map != null) {
			list.addAll(map.values());
		}

		return list;
	}

	@Override
	public boolean contains(IElement element) {
		return layersByElement.containsKey(element);
	}

	@Override
	public IPoint transform(IPoint point, ILayer source, ILayer target) {
		IRegion sourceRegion = source.getRegion();
		IRegion targetRegion = target.getRegion();
		int px = point.getX();
		int py = point.getY();
		int sx = sourceRegion.getX();
		int sy = sourceRegion.getY();
		int tx = targetRegion.getX();
		int ty = targetRegion.getY();
		int x = sx - tx + px;
		int y = sy - ty + py;
		return new Point(x, y);
	}

	@Override
	public IPoint transform(IPoint point, IElement source, IElement target) {
		ILayer sourceLayer = lookupLayer(source);
		ILayer targetLayer = lookupLayer(target);
		return transform(point, sourceLayer, targetLayer);
	}

}
