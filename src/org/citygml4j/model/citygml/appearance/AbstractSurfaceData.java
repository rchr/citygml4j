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

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.module.citygml.AppearanceModule;

public abstract class AbstractSurfaceData extends AbstractFeature implements AppearanceModuleComponent {
	private Boolean isFront;
	private List<ADEComponent> ade;
	private AppearanceModule module;

	public AbstractSurfaceData() {
		
	}
	
	public AbstractSurfaceData(AppearanceModule module) {
		this.module = module;
	}
	
	public void addGenericApplicationPropertyOfSurfaceData(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfSurfaceData() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public Boolean getIsFront() {
		if (!isSetIsFront())
			return true;
		else
			return isFront;
	}

	public boolean isSetGenericApplicationPropertyOfSurfaceData() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetIsFront() {
		return isFront != null;
	}

	public void setGenericApplicationPropertyOfSurfaceData(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setIsFront(Boolean isFront) {
		this.isFront = isFront;
	}

	public void unsetGenericApplicationPropertyOfSurfaceData() {
		if (isSetGenericApplicationPropertyOfSurfaceData())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfSurfaceData(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfSurfaceData() ? this.ade.remove(ade) : false;
	}

	public void unsetIsFront() {
		isFront = null;
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}
	
	public final AppearanceModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractSurfaceData copy = (AbstractSurfaceData)target;		
		super.copyTo(copy, copyBuilder);

		if (isSetIsFront())
			copy.setIsFront(copyBuilder.copy(isFront));

		if (isSetGenericApplicationPropertyOfSurfaceData()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfSurfaceData(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		return copy;
	}

}
