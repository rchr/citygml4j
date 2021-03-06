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
package org.citygml4j.model.gml.grids;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;

public class GridEnvelope implements GML, Child, Copyable {
	private List<Integer> low;
	private List<Integer> high;
	private ModelObject parent;
	
	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.GRID_ENVELOPE;
	}

	public List<Integer> getLow() {
		if (low == null)
			low = new ArrayList<Integer>();
		
		return low;
	}

	public List<Integer> getHigh() {
		if (high == null)
			high = new ArrayList<Integer>();
		
		return high;
	}

	public boolean isSetLow() {
		return low != null && !low.isEmpty();
	}

	public boolean isSetHigh() {
		return high != null && !high.isEmpty();
	}

	public void addLow(Integer low) {
		if (this.low == null)
			this.low = new ArrayList<Integer>();
		
		this.low.add(low);
	}

	public void addHigh(Integer high) {
		if (this.high == null)
			this.high = new ArrayList<Integer>();
		
		this.high.add(high);
	}

	public void setLow(List<Integer> low) {
		this.low = low;
	}

	public void setHigh(List<Integer> high) {
		this.high = high;
	}

	public void unsetLow() {
		low = null;
	}

	public void unsetHigh() {
		high = null;
	}
	
	public ModelObject getParent() {
		return parent;
	}

	public void setParent(ModelObject parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}
	
	@SuppressWarnings("unchecked")
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		GridEnvelope copy = (target == null) ? new GridEnvelope() : (GridEnvelope)target;
		
		if (isSetLow())
			copy.setLow((List<Integer>)copyBuilder.copy(low));
		
		if (isSetHigh())
			copy.setHigh((List<Integer>)copyBuilder.copy(high));
		
		copy.unsetParent();
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new GridEnvelope(), copyBuilder);
	}

}
