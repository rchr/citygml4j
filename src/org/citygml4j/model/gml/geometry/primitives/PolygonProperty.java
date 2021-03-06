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
package org.citygml4j.model.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.GeometryProperty;

public class PolygonProperty extends GeometryProperty<Polygon> {
	
	public PolygonProperty() {

	}

	public PolygonProperty(Polygon polygon) {
		super(polygon);
	}

	public PolygonProperty(String href) {
		super(href);
	}
	
	public Polygon getPolygon() {
		return super.getGeometry();
	}

	public boolean isSetPolygon() {
		return super.isSetGeometry();
	}

	public void setPolygon(Polygon polygon) {
		super.setGeometry(polygon);
	}

	public void unsetPolygon() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.POLYGON_PROPERTY;
	}

	@Override
	public Class<Polygon> getAssociableClass() {
		return Polygon.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new PolygonProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PolygonProperty copy = (target == null) ? new PolygonProperty() : (PolygonProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
