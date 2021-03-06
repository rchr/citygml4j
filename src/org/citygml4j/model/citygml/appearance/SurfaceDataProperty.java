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
package org.citygml4j.model.citygml.appearance;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.module.citygml.AppearanceModule;

public class SurfaceDataProperty extends FeatureProperty<AbstractSurfaceData> implements AppearanceModuleComponent {
	private AppearanceModule module;
	
	public SurfaceDataProperty() {
		
	}
	
	public SurfaceDataProperty(AbstractSurfaceData abstractSurfaceData) {
		super(abstractSurfaceData);
	}
	
	public SurfaceDataProperty(String href) {
		super(href);
	}
	
	public SurfaceDataProperty(AppearanceModule module) {
		this.module = module;
	}
	
	public AbstractSurfaceData getSurfaceData() {
		return super.getObject();
	}

	public boolean isSetSurfaceData() {
		return super.isSetObject();
	}

	public void setSurfaceData(AbstractSurfaceData surfaceData) {
		super.setObject(surfaceData);
	}
	
	public void unsetSurfaceData() {
		super.unsetObject();
	}
	
	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.SURFACE_DATA_PROPERTY;
	}

	public final AppearanceModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Class<AbstractSurfaceData> getAssociableClass() {
		return AbstractSurfaceData.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new SurfaceDataProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		SurfaceDataProperty copy = (target == null) ? new SurfaceDataProperty() : (SurfaceDataProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
