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
package org.citygml4j.model.gml.valueObjects;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.base.AssociationByRepOrRef;

public class ValueProperty extends AssociationByRepOrRef<Value> {

	public ValueProperty() {

	}

	public ValueProperty(Value value) {
		super(value);
	}

	public ValueProperty(String href) {
		super(href);
	}

	public Value getValue() {
		return super.getObject();
	}

	public boolean isSetValue() {
		return super.isSetObject();
	}

	public void setValue(Value value) {
		super.setObject(value);
	}

	public void unsetValue() {
		super.unsetObject();
	}

	public GMLClass getGMLClass() {
		return GMLClass.VALUE_PROPERTY;
	}

	public Class<Value> getAssociableClass() {
		return Value.class;
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ValueProperty copy = (target == null) ? new ValueProperty() : (ValueProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ValueProperty(), copyBuilder);
	}

}
