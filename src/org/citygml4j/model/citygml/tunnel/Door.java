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
package org.citygml4j.model.citygml.tunnel;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.module.citygml.TunnelModule;

public class Door extends AbstractOpening implements TunnelModuleComponent {
	private List<ADEComponent> ade;
	
	public Door() {
		
	}
	
	public Door(TunnelModule module) {
		super(module);
	}
	
	public void addGenericApplicationPropertyOfDoor(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}
	
	public List<ADEComponent> getGenericApplicationPropertyOfDoor() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}
	
	public boolean isSetGenericApplicationPropertyOfDoor() {
		return ade != null && !ade.isEmpty();
	}
	
	public void setGenericApplicationPropertyOfDoor(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}
	
	public void unsetGenericApplicationPropertyOfDoor() {
		if (isSetGenericApplicationPropertyOfDoor())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfDoor(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfDoor() ? this.ade.remove(ade) : false;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TUNNEL_DOOR;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new Door(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Door copy = (target == null) ? new Door() : (Door)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetGenericApplicationPropertyOfDoor()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfDoor(copyPart);

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
