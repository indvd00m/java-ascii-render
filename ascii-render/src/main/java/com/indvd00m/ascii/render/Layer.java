package com.indvd00m.ascii.render;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.indvd00m.ascii.render.api.IElement;
import com.indvd00m.ascii.render.api.ILayer;
import com.indvd00m.ascii.render.api.IRegion;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-17 5:38:28 PM
 *
 */
public class Layer implements ILayer {

	IRegion region;
	List<IElement> elements = new ArrayList<IElement>();

	public Layer(IRegion region) {
		super();
		this.region = region;
	}

	@Override
	public IRegion getRegion() {
		return region;
	}

	@Override
	public List<IElement> getElements() {
		return Collections.unmodifiableList(elements);
	}

	@Override
	public void addElement(IElement element) {
		elements.add(element);
	}

	@Override
	public void removeElement(IElement element) {
		elements.remove(element);
	}

	@Override
	public void insertElement(int index, IElement element) {
		elements.add(index, element);
	}

}
