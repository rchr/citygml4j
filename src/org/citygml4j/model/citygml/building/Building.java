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

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.module.citygml.BuildingModule;

public class Building extends AbstractBuilding {
	private List<ADEComponent> ade;

	public Building() {
		
	}
	
	public Building(BuildingModule module) {
		super(module);
	}
	
	public void addGenericApplicationPropertyOfBuilding(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfBuilding() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public boolean isSetGenericApplicationPropertyOfBuilding() {
		return ade != null && !ade.isEmpty();
	}

	public void setGenericApplicationPropertyOfBuilding(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void unsetGenericApplicationPropertyOfBuilding() {
		if (isSetGenericApplicationPropertyOfBuilding())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfBuilding(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfBuilding() ? this.ade.remove(ade) : false;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.BUILDING;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new Building(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Building copy = (target == null) ? new Building() : (Building)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetGenericApplicationPropertyOfBuilding()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfBuilding(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		return copy;
	}
	
	public void accept(FeatureVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(FeatureFunctor<T> visitor) {
		return visitor.apply(this);
	}
	
	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}
	
}
