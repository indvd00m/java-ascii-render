package com.indvd00m.ascii.render.api;

import java.util.List;

/**
 * Context builder.
 * 
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-17 3:46:21 PM
 *
 */
public interface IContextBuilder {

	/**
	 * Build context.
	 * 
	 * @return
	 */
	IContext build();

	/**
	 * Width of context.
	 * 
	 * @return
	 */
	IContextBuilder width(int width);

	/**
	 * Height of context.
	 * 
	 * @return
	 */
	IContextBuilder height(int height);

	/**
	 * Create new layer and add him to context in a context region {@code (0, 0, width, height)}.
	 * 
	 * @return
	 */
	IContextBuilder layer();

	/**
	 * Create new layer and add him to context in a specific region.
	 * 
	 * @param region
	 * @return
	 */
	IContextBuilder layer(IRegion region);
	
	/**
	 * Create new layer and add him to context in a specific position.
	 * 
	 * @param region
	 * @return
	 */
	IContextBuilder layer(int x, int y, int width, int height);

	/**
	 * Create new layer and add layer to context in a context region {@code (0, 0, width, height)}.
	 * 
	 * @return
	 */
	IContextBuilder layer(IElement... elements);

	/**
	 * Create new layer with {@code elements} and add layer to context in a specific region.
	 * 
	 * @param region
	 * @return
	 */
	IContextBuilder layer(IRegion region, IElement... elements);
	
	/**
	 * Create new layer with {@code elements} and add layer to context in a specific position.
	 * 
	 * @param region
	 * @return
	 */
	IContextBuilder layer(int x, int y, int width, int height, IElement... elements);

	/**
	 * Create new layer with {@code elements} and add layer to context in a context region
	 * {@code (0, 0, width, height)}.
	 * 
	 * @return
	 */
	IContextBuilder layer(List<IElement> elements);

	/**
	 * Create new layer with {@code elements} and add layer to context in a specific region.
	 * 
	 * @param region
	 * @return
	 */
	IContextBuilder layer(IRegion region, List<IElement> elements);
	
	/**
	 * Create new layer with {@code elements} and add layer to context in a specific position.
	 * 
	 * @param region
	 * @return
	 */
	IContextBuilder layer(int x, int y, int width, int height, List<IElement> elements);


	/**
	 * Opacity of last created layer. {@code False} by default.
	 *
	 * @param opacity
	 * @return
	 */
	IContextBuilder opacity(boolean opacity);

	/**
	 * Add {@code element} to last created layer. New layer will be created, if layers count is 0.
	 * 
	 * @param element
	 * @return
	 */
	IContextBuilder element(IElement element);

	/**
	 * Add {@code elements} to last created layer. New layer will be created, if layers count is 0.
	 * 
	 * @param elements
	 * @return
	 */
	IContextBuilder elements(IElement... elements);

	/**
	 * Add {@code elements} to last created layer. New layer will be created, if layers count is 0.
	 * 
	 * @param elements
	 * @return
	 */
	IContextBuilder elements(List<IElement> elements);

}
