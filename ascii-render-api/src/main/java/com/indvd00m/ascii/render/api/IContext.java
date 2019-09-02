package com.indvd00m.ascii.render.api;

import java.util.List;

/**
 * Context object. Context contains layers which contains elements. Every layer has region, in which it will be drawn.
 * Only content from this layer region will be drawn in render. Layers contained in a particular order and will be drawn
 * in this order.
 *
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 0.9.0
 */
public interface IContext {

	/**
	 * Width of context.
	 *
	 * @return
	 */
	int getWidth();

	/**
	 * Height of context.
	 *
	 * @return
	 */
	int getHeight();

	/**
	 * Layers list.
	 *
	 * @return
	 */
	List<ILayer> getLayers();

	/**
	 * Search first element of {@code E} type (or successors of {@code E})
	 *
	 * @param clazz
	 * @return
	 */
	<E extends IElement> E lookup(Class<E> clazz);

	/**
	 * Search first element of {@code E} type (optionally including successors)
	 *
	 * @param clazz
	 * @return
	 */
	<E extends IElement> E lookup(Class<E> clazz, boolean includeSuccessors);

	/**
	 * Search all elements of {@code E} type (or successors of {@code E}). If elements not found, empty list will be
	 * returned.
	 *
	 * @param clazz
	 * @return
	 */
	<E extends IElement> List<E> lookupAll(Class<E> clazz);

	/**
	 * Search all elements of {@code E} type (optionally including successors). If elements not found, empty list will
	 * be returned.
	 *
	 * @param clazz
	 * @return
	 */
	<E extends IElement> List<E> lookupAll(Class<E> clazz, boolean includeSuccessors);

	/**
	 * Search first element of {@code E} type (or successors of {@code E}) in layer.
	 *
	 * @param clazz
	 * @param layer
	 * @return
	 */
	<E extends IElement> E lookup(Class<E> clazz, ILayer layer);

	/**
	 * Search first element of {@code E} type (optionally including successors) in layer.
	 *
	 * @param clazz
	 * @param layer
	 * @return
	 */
	<E extends IElement> E lookup(Class<E> clazz, boolean includeSuccessors, ILayer layer);

	/**
	 * Search all elements of {@code E} type (or successors of {@code E}) in layer. If elements not found, empty list
	 * will be returned.
	 *
	 * @param clazz
	 * @param layer
	 * @return
	 */
	<E extends IElement> List<E> lookupAll(Class<E> clazz, ILayer layer);

	/**
	 * Search all elements of {@code E} type (optionally including successors) in layer. If elements not found, empty
	 * list will be returned.
	 *
	 * @param clazz
	 * @param layer
	 * @return
	 */
	<E extends IElement> List<E> lookupAll(Class<E> clazz, boolean includeSuccessors, ILayer layer);

	/**
	 * Search first layer which contains {@code element}.
	 *
	 * @param element
	 * @return
	 */
	ILayer lookupLayer(IElement element);

	/**
	 * Search all layers which contains {@code element}. If layers not found, empty list will be returned.
	 *
	 * @param element
	 * @return
	 */
	List<ILayer> lookupLayers(IElement element);

	/**
	 * Search object with type {@code T} (or successors of {@code T}) and identificator {@code typedId}. See
	 * {@link ITypedIdentified}.
	 *
	 * @param type
	 * @param typedId
	 * @return
	 */
	<T extends ITypedIdentified<T>> T lookupTyped(Class<T> type, int typedId);

	/**
	 * Search object with type {@code T} (optionally including successors) and identificator {@code typedId}. See
	 * {@link ITypedIdentified}.
	 *
	 * @param type
	 * @param typedId
	 * @param includeSuccessors
	 * @return
	 * @param <T>
	 */
	<T extends ITypedIdentified<T>> T lookupTyped(Class<T> type, int typedId, boolean includeSuccessors);

	/**
	 * Search objects with type {@code T} (or successors of {@code T}). If objects not found, empty list will be
	 * returned. See {@link ITypedIdentified}.
	 *
	 * @param type
	 * @return
	 */
	<T extends ITypedIdentified<T>> List<T> lookupTyped(Class<T> type);

	/**
	 * Search objects with type {@code T} (optionally including successors). If objects not found, empty list will be
	 * returned. See {@link ITypedIdentified}.
	 *
	 * @param type
	 * @param includeSuccessors
	 * @return
	 * @param <T>
	 */
	<T extends ITypedIdentified<T>> List<T> lookupTyped(Class<T> type, boolean includeSuccessors);

	/**
	 * @param element
	 * @return true, if this context contains {@code element}.
	 */
	boolean contains(IElement element);

	/**
	 * Transform point coordinates from {@code source} coordinate system to {@code target} coordinate system.
	 *
	 * @param point
	 * @param source
	 * @param target
	 * @return
	 */
	IPoint transform(IPoint point, ILayer source, ILayer target);

	/**
	 * Transform point coordinates from {@code source} coordinate system to {@code target} coordinate system.
	 *
	 * @param point
	 * @param source
	 * @param target
	 * @return
	 */
	IPoint transform(IPoint point, IElement source, IElement target);

}
