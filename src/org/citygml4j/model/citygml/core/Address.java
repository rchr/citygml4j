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
package org.citygml4j.model.citygml.core;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.geometry.aggregates.MultiPointProperty;
import org.citygml4j.model.module.citygml.CoreModule;

public class Address extends AbstractFeature implements CoreModuleComponent {
	private XalAddressProperty xalAddress;
	private MultiPointProperty multiPoint;
	private List<ADEComponent> ade;
	private CoreModule module;
	
	public Address() {
		
	}
	
	public Address(CoreModule module) {
		this.module = module;
	}
	
	public void addGenericApplicationPropertyOfAddress(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfAddress() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public MultiPointProperty getMultiPoint() {
		return multiPoint;
	}

	public XalAddressProperty getXalAddress() {
		return xalAddress;
	}

	public boolean isSetGenericApplicationPropertyOfAddress() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetMultiPoint() {
		return multiPoint != null;
	}

	public boolean isSetXalAddress() {
		return xalAddress != null;
	}

	public void setGenericApplicationPropertyOfAddress(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setMultiPoint(MultiPointProperty multiPoint) {
		if (multiPoint != null)
			multiPoint.setParent(this);
		
		this.multiPoint = multiPoint;
	}

	public void setXalAddress(XalAddressProperty xalAddress) {
		if (xalAddress != null)
			xalAddress.setParent(this);
		
		this.xalAddress = xalAddress;
	}

	public void unsetGenericApplicationPropertyOfAddress() {
		if (isSetGenericApplicationPropertyOfAddress())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfAddress(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfAddress() ? this.ade.remove(ade) : false;
	}

	public void unsetMultiPoint() {
		if (isSetMultiPoint())
			multiPoint.unsetParent();
		
		multiPoint = null;
	}

	public void unsetXalAddress() {
		if (isSetXalAddress())
			xalAddress.unsetParent();
		
		xalAddress = null;
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}
	
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.ADDRESS;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}
	
	public final CoreModule getCityGMLModule() {
		return module;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new Address(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Address copy = (target == null) ? new Address() : (Address)target;		
		super.copyTo(copy, copyBuilder);
		
		if (isSetXalAddress()) {
			copy.setXalAddress((XalAddressProperty)copyBuilder.copy(xalAddress));
			if (copy.getXalAddress() == xalAddress)
				xalAddress.setParent(this);
		}
		
		if (isSetMultiPoint()) {
			copy.setMultiPoint((MultiPointProperty)copyBuilder.copy(multiPoint));
			if (copy.getMultiPoint() == multiPoint)
				multiPoint.setParent(this);
		}
		
		if (isSetGenericApplicationPropertyOfAddress()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfAddress(copyPart);

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
