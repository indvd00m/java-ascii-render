package com.indvd00m.ascii.render.api;

/**
 * If your complex graphical object consist of more than one {@link IElement}s, every of which depends each other, you
 * can extend every {@link IElement} with this interface and use {@link IContext#lookupTyped} method for searching
 * dependent objects in current context. Objects of this type must guarantee that {@link #getTypedId} is unique amongst
 * of all objects with type {@link #getType} (including successors) in current context.
 *
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-19 7:39:37 PM
 */
public interface ITypedIdentified<T> {

	/**
	 * @return Type of object.
	 */
	Class<T> getType();

	/**
	 * @return Unique value amongst of all objects with type {@link #getType}.
	 */
	int getTypedId();

}
