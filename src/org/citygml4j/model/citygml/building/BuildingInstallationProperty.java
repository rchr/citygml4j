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

public class BuildingInstallationProperty extends FeatureProperty<BuildingInstallation> implements BuildingModuleComponent {
	private BuildingModule module;
	
	public BuildingInstallationProperty() {
		
	}
	
	public BuildingInstallationProperty(BuildingInstallation buildingInstallation) {
		super(buildingInstallation);
	}
	
	public BuildingInstallationProperty(String href) {
		super(href);
	}
	
	public BuildingInstallationProperty(BuildingModule module) {
		this.module = module;
	}
	
	public BuildingInstallation getBuildingInstallation() {
		return super.getObject();
	}

	public boolean isSetBuildingInstallation() {
		return super.isSetObject();
	}

	public void setBuildingInstallation(BuildingInstallation buildingInstallation) {
		super.setObject(buildingInstallation);
	}

	public void unsetBuildingInstallation() {
		super.unsetObject();
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.BUILDING_INSTALLATION_PROPERTY;
	}

	public final BuildingModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Class<BuildingInstallation> getAssociableClass() {
		return BuildingInstallation.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new BuildingInstallationProperty(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		BuildingInstallationProperty copy = (target == null) ? new BuildingInstallationProperty() : (BuildingInstallationProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
