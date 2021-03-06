/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright (C) 2013 - 2015,
 * Claus Nagel <claus.nagel@gmail.com>
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 */
package org.citygml4j.model.gml.coverage;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.feature.AbstractFeature;

public abstract class AbstractCoverage extends AbstractFeature {
	private RangeSet rangeSet;
	private Integer dimension;
	
	public RangeSet getRangeSet() {
		return rangeSet;
	}
	
	public Integer getDimension() {
		return dimension;
	}

	public boolean isSetRangeSet() {
		return rangeSet != null;
	}
	
	public boolean isSetDimension() {
		return dimension != null;
	}
	
	public void setRangeSet(RangeSet rangeSet) {
		if (rangeSet != null)
			rangeSet.setParent(this);
		
		this.rangeSet = rangeSet;
	}

	public void setDimension(Integer dimension) {
		if (dimension > 0)
			this.dimension = dimension;
	}
	
	public void unsetRangeSet() {
		if (isSetRangeSet())
			rangeSet.unsetParent();
		
		rangeSet = null;
	}

	public void unsetDimension() {
		dimension = null;
	}
	
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractCoverage copy = (AbstractCoverage)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetRangeSet()) {
			copy.setRangeSet((RangeSet)copyBuilder.copy(rangeSet));
			if (copy.getRangeSet() == rangeSet)
				rangeSet.setParent(this);
		}
		
		if (isSetDimension())
			copy.setDimension((Integer)copyBuilder.copy(dimension));
		
		return copy;
	}
	
}
