package com.indvd00m.ascii.render;

import com.indvd00m.ascii.render.api.IElement;
import com.indvd00m.ascii.render.api.ILayer;
import com.indvd00m.ascii.render.api.IRegion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 0.9.0
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
