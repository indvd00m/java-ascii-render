package com.indvd00m.ascii.render.elements.line;

import com.indvd00m.ascii.render.api.IPoint;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-18 12:56:15 AM
 *
 */
class PointWithDiff implements Comparable<PointWithDiff> {

	IPoint point;
	double diff;

	public PointWithDiff(IPoint point, double diff) {
		super();
		this.point = point;
		this.diff = diff;
	}

	@Override
	public int compareTo(PointWithDiff o) {
		if (equals(o))
			return 0;
		else if (diff < o.diff)
			return -1;
		else
			return 1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((point == null) ? 0 : point.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PointWithDiff other = (PointWithDiff) obj;
		if (point == null) {
			if (other.point != null)
				return false;
		} else if (!point.equals(other.point))
			return false;
		return true;
	}

}