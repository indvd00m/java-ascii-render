package com.indvd00m.ascii.render.api;

import java.util.List;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-17 12:32:27 PM
 *
 */
public interface ILayer {

	IRegion getRegion();

	List<IElement> getElements();

	void addElement(IElement element);

	void removeElement(IElement element);

	void insertElement(int index, IElement element);

}
