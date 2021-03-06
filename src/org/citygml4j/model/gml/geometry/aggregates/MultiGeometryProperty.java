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

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.GeometryProperty;

public class MultiGeometryProperty extends GeometryProperty<AbstractGeometricAggregate> {

	public MultiGeometryProperty() {

	}

	public MultiGeometryProperty(AbstractGeometricAggregate abstractGeometricAggregate) {
		super(abstractGeometricAggregate);
	}

	public MultiGeometryProperty(String href) {
		super(href);
	}
	
	public AbstractGeometricAggregate getGeometricAggregate() {
		return super.getGeometry();
	}

	public boolean isSetGeometricAggregate() {
		return super.isSetGeometry();
	}

	public void setGeometricAggregate(AbstractGeometricAggregate geometricAggregate) {
		super.setGeometry(geometricAggregate);
	}

	public void unsetGeometricAggregate() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.MULTI_GEOMETRY_PROPERTY;
	}

	@Override
	public Class<AbstractGeometricAggregate> getAssociableClass() {
		return AbstractGeometricAggregate.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MultiGeometryProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MultiGeometryProperty copy = (target == null) ? new MultiGeometryProperty() : (MultiGeometryProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
