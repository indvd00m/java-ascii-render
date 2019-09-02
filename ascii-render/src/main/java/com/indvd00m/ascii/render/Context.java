package com.indvd00m.ascii.render;

import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IElement;
import com.indvd00m.ascii.render.api.ILayer;
import com.indvd00m.ascii.render.api.IPoint;
import com.indvd00m.ascii.render.api.IRegion;
import com.indvd00m.ascii.render.api.ITypedIdentified;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 0.9.0
 */
public class Context implements IContext {

	protected int width;
	protected int height;
	protected List<ILayer> layers = new ArrayList<ILayer>();

	// cache
	protected Map<IElement, Set<ILayer>> layersByElement = new HashMap<IElement, Set<ILayer>>();
	protected Map<Class<IElement>, Set<IElement>> elementsByClass = new HashMap<Class<IElement>, Set<IElement>>();
	protected Map<Class<ITypedIdentified<?>>, Map<Integer, ITypedIdentified<?>>> identifiedByType = new HashMap<Class<ITypedIdentified<?>>, Map<Integer, ITypedIdentified<?>>>();

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

	@Override
	public <E extends IElement> E lookup(Class<E> clazz) {
		return lookup(clazz, true);
	}

	@Override
	public <E extends IElement> E lookup(Class<E> clazz, boolean includeSuccessors) {
		List<E> elements = lookupAll(clazz, includeSuccessors);
		if (!elements.isEmpty()) {
			return elements.get(0);
		}
		return null;
	}

	@Override
	public <E extends IElement> List<E> lookupAll(Class<E> clazz) {
		return lookupAll(clazz, true);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E extends IElement> List<E> lookupAll(Class<E> clazz, boolean includeSuccessors) {
		LinkedHashSet<IElement> set = new LinkedHashSet<IElement>();

		{
			Set<IElement> elements = elementsByClass.get(clazz);
			if (elements != null) {
				for (IElement e : elements) {
					if (includeSuccessors || clazz.equals(e.getClass())) {
						set.add(e);
					}
				}
			}
		}

		if (includeSuccessors) {
			for (Class<IElement> nextClazz : elementsByClass.keySet()) {
				if (clazz.isAssignableFrom(nextClazz)) {
					Set<IElement> elements = elementsByClass.get(nextClazz);
					if (elements != null) {
						set.addAll(elements);
					}
				}
			}
		}

		return (List<E>) new ArrayList<IElement>(set);
	}

	@Override
	public <E extends IElement> E lookup(Class<E> clazz, ILayer layer) {
		return lookup(clazz, true, layer);
	}

	@Override
	public <E extends IElement> E lookup(Class<E> clazz, boolean includeSuccessors, ILayer layer) {
		List<E> elements = lookupAll(clazz, includeSuccessors, layer);
		if (!elements.isEmpty()) {
			return elements.get(0);
		}
		return null;
	}

	@Override
	public <E extends IElement> List<E> lookupAll(Class<E> clazz, ILayer layer) {
		return lookupAll(clazz, true, layer);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E extends IElement> List<E> lookupAll(Class<E> clazz, boolean includeSuccessors, ILayer layer) {
		LinkedHashSet<IElement> set = new LinkedHashSet<IElement>();

		{
			Set<IElement> elements = elementsByClass.get(clazz);
			if (elements != null) {
				for (IElement e : elements) {
					if (includeSuccessors || clazz.equals(e.getClass())) {
						Set<ILayer> elementLayers = layersByElement.get(e);
						if (elementLayers.contains(layer)) {
							set.add(e);
						}
					}
				}
			}
		}

		if (includeSuccessors) {
			for (Class<IElement> nextClazz : elementsByClass.keySet()) {
				if (clazz.isAssignableFrom(nextClazz)) {
					Set<IElement> elements = elementsByClass.get(nextClazz);
					if (elements != null) {
						for (IElement e : elements) {
							Set<ILayer> elementLayers = layersByElement.get(e);
							if (elementLayers.contains(layer)) {
								set.add(e);
							}
						}
					}
				}
			}
		}

		return (List<E>) new ArrayList<IElement>(set);
	}

	@Override
	public ILayer lookupLayer(IElement element) {
		Set<ILayer> elementLayers = layersByElement.get(element);
		if (elementLayers != null && !elementLayers.isEmpty()) {
			return elementLayers.iterator().next();
		}
		return null;
	}

	@Override
	public List<ILayer> lookupLayers(IElement element) {
		List<ILayer> list = new ArrayList<ILayer>();

		Set<ILayer> elementLayers = layersByElement.get(element);
		if (elementLayers != null) {
			list.addAll(elementLayers);
		}

		return list;
	}

	@Override
	public <T extends ITypedIdentified<T>> T lookupTyped(Class<T> type, int typedId) {
		return lookupTyped(type, typedId, true);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends ITypedIdentified<T>> T lookupTyped(Class<T> type, int typedId, boolean includeSuccessors) {
		{
			Map<Integer, ITypedIdentified<?>> map = identifiedByType.get(type);
			if (map != null && map.containsKey(typedId)) {
				ITypedIdentified<?> ti = map.get(typedId);
				if (includeSuccessors || type.equals(ti.getClass())) {
					return (T) ti;
				}
			}
		}

		if (includeSuccessors) {
			for (Class<ITypedIdentified<?>> nextType : identifiedByType.keySet()) {
				if (type.isAssignableFrom(nextType)) {
					Map<Integer, ITypedIdentified<?>> map = identifiedByType.get(nextType);
					if (map != null && map.containsKey(typedId)) {
						ITypedIdentified<?> ti = map.get(typedId);
						return (T) ti;
					}
				}
			}
		}

		return null;
	}

	@Override
	public <T extends ITypedIdentified<T>> List<T> lookupTyped(Class<T> type) {
		return lookupTyped(type, true);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends ITypedIdentified<T>> List<T> lookupTyped(Class<T> type, boolean includeSuccessors) {
		@SuppressWarnings("rawtypes")
		LinkedHashSet set = new LinkedHashSet();

		{
			Map<Integer, ITypedIdentified<?>> map = identifiedByType.get(type);
			if (map != null) {
				for (ITypedIdentified<?> ti : map.values()) {
					if (includeSuccessors || type.equals(ti.getClass())) {
						set.add(ti);
					}
				}
			}
		}

		if (includeSuccessors) {
			for (Class<ITypedIdentified<?>> nextType : identifiedByType.keySet()) {
				if (type.isAssignableFrom(nextType)) {
					Map<Integer, ITypedIdentified<?>> map = identifiedByType.get(nextType);
					if (map != null) {
						set.addAll(map.values());
					}
				}
			}
		}

		return new ArrayList<T>(set);
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
