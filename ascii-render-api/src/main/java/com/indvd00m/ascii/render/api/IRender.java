package com.indvd00m.ascii.render.api;

/**
 * A render. Render can create and render contexts.
 * 
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-17 2:52:10 PM
 *
 */
public interface IRender {

	IContext createContext(int width, int height);

	ICanvas render(IContext context);

}
