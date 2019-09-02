package com.indvd00m.ascii.render.elements.plot;

import com.indvd00m.ascii.render.Point;
import com.indvd00m.ascii.render.api.IElement;
import com.indvd00m.ascii.render.api.IPoint;
import com.indvd00m.ascii.render.api.IRegion;
import com.indvd00m.ascii.render.api.ITypedIdentified;
import com.indvd00m.ascii.render.elements.plot.api.IPlotPoint;
import com.indvd00m.ascii.render.elements.plot.api.IPlotPoints;
import com.indvd00m.ascii.render.elements.plot.misc.PlotPoints;

import java.util.List;

/**
 * Base class for plot elements. Every individual plot is identified by his {@link #anchorPoint} and {@link points}
 * hashCode.
 *
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 1.0.0
 */
public abstract class AbstractPlotObject<P extends AbstractPlotObject<P>> implements IElement, ITypedIdentified<P> {

	protected int typedId;
	protected List<IPlotPoint> points;
	protected IPlotPoints plotPoints;
	protected IRegion region;
	protected IPoint anchorPoint;

	public AbstractPlotObject(List<IPlotPoint> points, IRegion region) {
		super();
		this.points = points;
		this.plotPoints = new PlotPoints(points);
		this.region = region;
		this.anchorPoint = new Point(region.getX(), region.getY() + region.getHeight() - 1);
		this.typedId = generateTypedId();
	}

	protected int generateTypedId() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anchorPoint.getX();
		result = prime * result + anchorPoint.getY();
		result = prime * result + ((points == null) ? 0 : points.hashCode());
		return result;
	}

	public List<IPlotPoint> getPoints() {
		return points;
	}

	public IRegion getRegion() {
		return region;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Class<P> getType() {
		return (Class<P>) getClass();
	}

	@Override
	public int getTypedId() {
		return typedId;
	}

}