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

public class MultiSolidProperty extends GeometryProperty<MultiSolid> {

	public MultiSolidProperty() {

	}

	public MultiSolidProperty(MultiSolid multiSolid) {
		super(multiSolid);
	}

	public MultiSolidProperty(String href) {
		super(href);
	}
	
	public MultiSolid getMultiSolid() {
		return super.getGeometry();
	}

	public boolean isSetMultiSolid() {
		return super.isSetGeometry();
	}

	public void setMultiSolid(MultiSolid multiSolid) {
		super.setGeometry(multiSolid);
	}

	public void unsetMultiSolid() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.MULTI_SOLID_PROPERTY;
	}

	@Override
	public Class<MultiSolid> getAssociableClass() {
		return MultiSolid.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MultiSolidProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MultiSolidProperty copy = (target == null) ? new MultiSolidProperty() : (MultiSolidProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
