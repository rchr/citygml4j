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
package org.citygml4j.model.citygml.bridge;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.module.citygml.BridgeModule;

public class InteriorFurnitureProperty extends FeatureProperty<BridgeFurniture> implements BridgeModuleComponent {
	private BridgeModule module;
	
	public InteriorFurnitureProperty() {
		
	}
	
	public InteriorFurnitureProperty(BridgeFurniture bridgeFurniture) {
		super(bridgeFurniture);
	}
	
	public InteriorFurnitureProperty(String href) {
		super(href);
	}
	
	public InteriorFurnitureProperty(BridgeModule module) {
		this.module = module;
	}
	
	public BridgeFurniture getBridgeFurniture() {
		return super.getObject();
	}

	public boolean isSetBridgeFurniture() {
		return super.isSetObject();
	}

	public void setBridgeFurniture(BridgeFurniture bridgeFurniture) {
		super.setObject(bridgeFurniture);
	}

	public void unsetBridgeFurniture() {
		super.unsetObject();
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.INTERIOR_BRIDGE_FURNITURE_PROPERTY;
	}

	public final BridgeModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Class<BridgeFurniture> getAssociableClass() {
		return BridgeFurniture.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new InteriorFurnitureProperty(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		InteriorFurnitureProperty copy = (target == null) ? new InteriorFurnitureProperty() : (InteriorFurnitureProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
