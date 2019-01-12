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

	protected IRegion region;
	protected List<IElement> elements = new ArrayList<IElement>();
	protected boolean opacity;

	Layer(IRegion region) {
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
	public boolean isOpacity() {
		return opacity;
	}

}
