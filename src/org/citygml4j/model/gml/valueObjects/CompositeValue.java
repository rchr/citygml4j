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

import java.util.Arrays;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.base.AbstractGML;

public class CompositeValue extends AbstractGML {
	private List<ValueProperty> valueComponent;
	private ValueArrayProperty valueComponents;
	
	public CompositeValue() {
		
	}
	
	public CompositeValue(List<Value> values) {
		for (Value value : values)
			addValueComponent(new ValueProperty(value));
	}
	
	public CompositeValue(Value... values) {
		this(Arrays.asList(values));
	}

	public List<ValueProperty> getValueComponent() {
		if (valueComponent == null)
			valueComponent = new ChildList<ValueProperty>(this);
		
		return valueComponent;
	}

	public ValueArrayProperty getValueComponents() {
		return valueComponents;
	}

	public boolean isSetValueComponent() {
		return valueComponent != null && !valueComponent.isEmpty();
	}

	public boolean isSetValueComponents() {
		return valueComponents != null;
	}

	public void addValueComponent(ValueProperty valueComponent) {
		if (this.valueComponent == null)
			this.valueComponent = new ChildList<ValueProperty>(this);
		
		this.valueComponent.add(valueComponent);
	}

	public void setValueComponent(List<ValueProperty> valueComponent) {
		this.valueComponent = new ChildList<ValueProperty>(this, valueComponent);
	}

	public void setValueComponents(ValueArrayProperty valueComponents) {
		if (valueComponents != null)
			valueComponents.setParent(this);
		
		this.valueComponents = valueComponents;
	}

	public boolean unsetValueComponent(ValueProperty valueComponent) {
		return isSetValueComponent() ? this.valueComponent.remove(valueComponent) : false;
	}

	public void unsetValueComponent() {
		if (isSetValueComponent())
			valueComponent.clear();
		
		valueComponent = null;
	}

	public void unsetValueComponents() {
		if (isSetValueComponents())
			valueComponents.unsetParent();
		
		valueComponents = null;
	}

	public GMLClass getGMLClass() {
		return GMLClass.COMPOSITE_VALUE;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CompositeValue copy = (target == null) ? new CompositeValue() : (CompositeValue)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetValueComponent()) {
			for (ValueProperty part : valueComponent) {
				ValueProperty copyPart = (ValueProperty)copyBuilder.copy(part);
				copy.addValueComponent(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetValueComponents()) {
			copy.setValueComponents((ValueArrayProperty)copyBuilder.copy(valueComponents));
			if (copy.getValueComponents() == valueComponents)
				valueComponents.setParent(this);
		}
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CompositeValue(), copyBuilder);
	}
	
	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}

	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
