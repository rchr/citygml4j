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
package org.citygml4j.model.citygml.building;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.module.citygml.BuildingModule;

public class InteriorFurnitureProperty extends FeatureProperty<BuildingFurniture> implements BuildingModuleComponent {
	private BuildingModule module;
	
	public InteriorFurnitureProperty() {
		
	}
	
	public InteriorFurnitureProperty(BuildingFurniture buildingFurniture) {
		super(buildingFurniture);
	}
	
	public InteriorFurnitureProperty(String href) {
		super(href);
	}
	
	public InteriorFurnitureProperty(BuildingModule module) {
		this.module = module;
	}
	
	public BuildingFurniture getBuildingFurniture() {
		return super.getObject();
	}

	public boolean isSetBuildingFurniture() {
		return super.isSetObject();
	}

	public void setBuildingFurniture(BuildingFurniture buildingFurniture) {
		super.setObject(buildingFurniture);
	}

	public void unsetBuildingFurniture() {
		super.unsetObject();
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.INTERIOR_BUILDING_FURNITURE_PROPERTY;
	}

	public final BuildingModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Class<BuildingFurniture> getAssociableClass() {
		return BuildingFurniture.class;
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
