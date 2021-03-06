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
package org.citygml4j.model.citygml.waterbody;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.module.citygml.WaterBodyModule;

public abstract class AbstractWaterObject extends AbstractCityObject implements WaterBodyModuleComponent {
	private List<ADEComponent> ade;
	private WaterBodyModule module;
	
	public AbstractWaterObject() {

	}

	public AbstractWaterObject(WaterBodyModule module) {
		this.module = module;
	}
	
	public void addGenericApplicationPropertyOfWaterObject(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfWaterObject() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public boolean isSetGenericApplicationPropertyOfWaterObject() {
		return ade != null && !ade.isEmpty();
	}

	public void setGenericApplicationPropertyOfWaterObject(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void unsetGenericApplicationPropertyOfWaterObject() {
		if (isSetGenericApplicationPropertyOfWaterObject())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfWaterObject(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfWaterObject() ? this.ade.remove(ade) : false;
	}

	public final WaterBodyModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractWaterObject copy = (AbstractWaterObject)target;		
		super.copyTo(copy, copyBuilder);
		
		if (isSetGenericApplicationPropertyOfWaterObject()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfWaterObject(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		return copy;
	}

}
