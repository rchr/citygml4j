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
package org.citygml4j.model.gml.feature;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.base.AssociationByRepOrRef;

public class FeatureProperty<T extends AbstractFeature> extends AssociationByRepOrRef<T> {
	private ADEComponent genericADEComponent;
	
	public FeatureProperty() {
		
	}
	
	public FeatureProperty(T feature) {
		super(feature);
	}
	
	public FeatureProperty(String href) {
		super(href);
	}
	
	public T getFeature() {
		return super.getObject();
	}

	public boolean isSetFeature() {
		return super.isSetObject();
	}

	public void setFeature(T feature) {
		super.setObject(feature);
	}

	public void unsetFeature() {
		super.unsetObject();
	}

	public ADEComponent getGenericADEComponent() {
		return genericADEComponent;
	}

	public boolean isSetGenericADEComponent() {
		return genericADEComponent != null;
	}
	
	public void setGenericADEComponent(ADEComponent genericADEComponent) {
		if (genericADEComponent != null)
			genericADEComponent.setParent(this);
		
		this.genericADEComponent = genericADEComponent;
	}
	
	public void unsetGenericADEComponent() {
		if (isSetGenericADEComponent())
			genericADEComponent.unsetParent();
		
		genericADEComponent = null;
	}

	public GMLClass getGMLClass() {
		return GMLClass.FEATURE_PROPERTY;
	}

	@SuppressWarnings("unchecked")
	public Class<T> getAssociableClass() {
		return (Class<T>)AbstractFeature.class;
	}

	@SuppressWarnings("unchecked")
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		FeatureProperty<T> copy = (target == null) ? new FeatureProperty<T>() : (FeatureProperty<T>)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetGenericADEComponent()) {
			copy.setGenericADEComponent((ADEComponent)copyBuilder.copy(genericADEComponent));
			if (copy.getGenericADEComponent() == genericADEComponent)
				genericADEComponent.setParent(this);
		}
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new FeatureProperty<T>(), copyBuilder);
	}

}
