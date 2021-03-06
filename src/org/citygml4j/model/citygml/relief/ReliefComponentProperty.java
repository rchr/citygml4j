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
package org.citygml4j.model.citygml.relief;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.module.citygml.ReliefModule;

public class ReliefComponentProperty extends FeatureProperty<AbstractReliefComponent> implements ReliefModuleComponent {
	private ReliefModule module;
	
	public ReliefComponentProperty() {
		
	}
	
	public ReliefComponentProperty(AbstractReliefComponent abstractReliefComponent) {
		super(abstractReliefComponent);
	}
	
	public ReliefComponentProperty(String href) {
		super(href);
	}
	
	public ReliefComponentProperty(ReliefModule module) {
		this.module = module;
	}
	
	public AbstractReliefComponent getReliefComponent() {
		return super.getObject();
	}

	public boolean isSetReliefComponent() {
		return super.isSetObject();
	}

	public void setReliefComponent(AbstractReliefComponent reliefComponent) {
		super.setObject(reliefComponent);
	}

	public void unsetReliefComponent() {
		super.unsetObject();
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.RELIEF_COMPONENT_PROPERTY;
	}

	public final ReliefModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Class<AbstractReliefComponent> getAssociableClass() {
		return AbstractReliefComponent.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ReliefComponentProperty(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ReliefComponentProperty copy = (target == null) ? new ReliefComponentProperty() : (ReliefComponentProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
