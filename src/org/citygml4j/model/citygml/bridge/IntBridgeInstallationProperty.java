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

public class IntBridgeInstallationProperty extends FeatureProperty<IntBridgeInstallation> implements BridgeModuleComponent {
	private BridgeModule module;
	
	public IntBridgeInstallationProperty() {
		
	}
	
	public IntBridgeInstallationProperty(IntBridgeInstallation intBridgeInstallation) {
		super(intBridgeInstallation);
	}
	
	public IntBridgeInstallationProperty(String href) {
		super(href);
	}
	
	public IntBridgeInstallationProperty(BridgeModule module) {
		this.module = module;
	}
	
	public IntBridgeInstallation getIntBridgeInstallation() {
		return super.getObject();
	}

	public boolean isSetIntBridgeInstallation() {
		return super.isSetObject();
	}

	public void setIntBridgeInstallation(IntBridgeInstallation intBridgeInstallation) {
		super.setObject(intBridgeInstallation);
	}

	public void unsetIntBridgeInstallation() {
		super.unsetObject();
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.INT_BRIDGE_INSTALLATION_PROPERTY;
	}

	public final BridgeModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Class<IntBridgeInstallation> getAssociableClass() {
		return IntBridgeInstallation.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new IntBridgeInstallationProperty(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		IntBridgeInstallationProperty copy = (target == null) ? new IntBridgeInstallationProperty() : (IntBridgeInstallationProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
