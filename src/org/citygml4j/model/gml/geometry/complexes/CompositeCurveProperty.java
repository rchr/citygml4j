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
package org.citygml4j.model.gml.geometry.complexes;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.GeometryProperty;

public class CompositeCurveProperty extends GeometryProperty<CompositeCurve> {
	
	public CompositeCurveProperty() {
		
	}
	
	public CompositeCurveProperty(CompositeCurve compositeCurve) {
		super(compositeCurve);
	}
	
	public CompositeCurveProperty(String href) {
		super(href);
	}
	
	public CompositeCurve getCompositeCurve() {
		return super.getGeometry();
	}
	
	public boolean isSetCompositeCurve() {
		return super.isSetGeometry();
	}
	
	public void setCompositeCurve(CompositeCurve compositeCurve) {
		super.setGeometry(compositeCurve);
	}
	
	public void unsetCompositeCurve() {
		super.unsetGeometry();
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.COMPOSITE_CURVE_PROPERTY;
	}
	
	@Override
	public Class<CompositeCurve> getAssociableClass() {
		return CompositeCurve.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CompositeCurveProperty(), copyBuilder);
	}
	
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CompositeCurveProperty copy = (target == null) ? new CompositeCurveProperty() : (CompositeCurveProperty)target;
		return super.copyTo(copy, copyBuilder);
	}
	
}
