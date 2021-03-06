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
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;

public class GeometricComplexProperty extends GeometryProperty<AbstractGeometry> {

	public GeometricComplexProperty() {

	}

	public GeometricComplexProperty(AbstractGeometry abstractGeometry) {
		setObject(abstractGeometry);
	}

	public GeometricComplexProperty(String href) {
		super(href);
	}
	
	@Override
	public void setObject(AbstractGeometry geometry) {
		if (geometry instanceof CompositeCurve ||
				geometry instanceof CompositeSolid ||
				geometry instanceof CompositeSurface ||
				geometry instanceof GeometricComplex)		
			super.setObject(geometry);
	}

	public CompositeCurve getCompositeCurve() {
		return (super.getGeometry() instanceof CompositeCurve) ? (CompositeCurve)super.getGeometry() : null;
	}

	public CompositeSolid getCompositeSolid() {
		return (super.getGeometry() instanceof CompositeSolid) ? (CompositeSolid)super.getGeometry() : null;
	}

	public CompositeSurface getCompositeSurface() {
		return (super.getGeometry() instanceof CompositeSurface) ? (CompositeSurface)super.getGeometry() : null;
	}

	public GeometricComplex getGeometricComplex() {
		return (super.getGeometry() instanceof GeometricComplex) ? (GeometricComplex)super.getGeometry() : null;
	}

	public boolean isSetCompositeCurve() {
		return (super.getGeometry() instanceof CompositeCurve);
	}

	public boolean isSetCompositeSolid() {
		return (super.getGeometry() instanceof CompositeSolid);
	}

	public boolean isSetCompositeSurface() {
		return (super.getGeometry() instanceof CompositeSurface);
	}

	public boolean isSetGeometricComplex() {
		return (super.getGeometry() instanceof GeometricComplex);
	}

	public void setCompositeCurve(CompositeCurve compositeCurve) {
		super.setObject(compositeCurve);
	}

	public void setCompositeSolid(CompositeSolid compositeSolid) {
		super.setObject(compositeSolid);
	}

	public void setCompositeSurface(CompositeSurface compositeSurface) {
		super.setObject(compositeSurface);
	}

	public void setGeometricComplex(GeometricComplex geometricComplex) {
		super.setGeometry(geometricComplex);
	}

	public void unsetCompositeCurve() {
		super.unsetGeometry();
	}

	public void unsetCompositeSolid() {
		super.unsetGeometry();
	}

	public void unsetCompositeSurface() {
		super.unsetGeometry();
	}

	public void unsetGeometricComplex() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.GEOMETRIC_COMPLEX_PROPERTY;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new GeometricComplexProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		GeometricComplexProperty copy = (target == null) ? new GeometricComplexProperty() : (GeometricComplexProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
