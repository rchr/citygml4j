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
package org.citygml4j.model.gml.geometry.aggregates;

import java.util.Arrays;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.LineString;
import org.citygml4j.model.gml.geometry.primitives.LineStringProperty;

public class MultiLineString extends AbstractGeometricAggregate {
	private List<LineStringProperty> lineStringMember;		
	
	public MultiLineString() {
		
	}
	
	public MultiLineString(List<LineString> lineStrings) {
		for (LineString lineString : lineStrings)
			addLineStringMember(new LineStringProperty(lineString));
	}
	
	public MultiLineString(LineString... lineStrings) {
		this(Arrays.asList(lineStrings));
	}
	
	public void addLineStringMember(LineStringProperty lineStringMember) {
		if (this.lineStringMember == null)
			this.lineStringMember = new ChildList<LineStringProperty>(this);
		
		this.lineStringMember.add(lineStringMember);
	}

	public List<LineStringProperty> getLineStringMember() {
		if (lineStringMember == null)
			lineStringMember = new ChildList<LineStringProperty>(this);
		
		return lineStringMember;
	}

	public boolean isSetLineStringMember() {
		return lineStringMember != null && !lineStringMember.isEmpty();
	}

	public void setLineStringMember(List<LineStringProperty> lineStringMember) {
		this.lineStringMember = new ChildList<LineStringProperty>(this, lineStringMember);
	}

	public void unsetLineStringMember() {
		if (isSetLineStringMember())
			lineStringMember.clear();
		
		lineStringMember = null;
	}

	public boolean unsetLineStringMember(LineStringProperty lineStringMember) {
		return isSetLineStringMember() ? this.lineStringMember.remove(lineStringMember) : false;
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (isSetLineStringMember()) {
			for (LineStringProperty lineStringProperty : getLineStringMember())
				if (lineStringProperty.isSetLineString())
					bbox.update(lineStringProperty.getLineString().calcBoundingBox());
		}
		
		if (bbox.getLowerCorner().isEqual(Double.MAX_VALUE) && 
				bbox.getUpperCorner().isEqual(-Double.MAX_VALUE))
			return null;
		else
			return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.MULTI_LINE_STRING;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MultiLineString(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MultiLineString copy = (target == null) ? new MultiLineString() : (MultiLineString)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetLineStringMember()) {
			for (LineStringProperty part : lineStringMember) {
				LineStringProperty copyPart = (LineStringProperty)copyBuilder.copy(part);
				copy.addLineStringMember(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		return copy;
	}
	
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}

	public <T> T accept(GeometryFunctor<T> visitor) {
		return visitor.apply(this);
	}
	
	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
