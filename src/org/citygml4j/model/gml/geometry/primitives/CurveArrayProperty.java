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
package org.citygml4j.model.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.GeometryArrayProperty;

public class CurveArrayProperty extends GeometryArrayProperty<AbstractCurve> {

	public CurveArrayProperty() {

	}

	public CurveArrayProperty(AbstractCurve abstractCurve) {
		super(abstractCurve);
	}

	public CurveArrayProperty(List<AbstractCurve> abstractCurve) {
		super(abstractCurve);
	}
	
	public CurveArrayProperty(AbstractCurve... abstractCurve) {
		super(abstractCurve);
	}

	public void addCurve(AbstractCurve abstractCurve) {
		super.addGeometry(abstractCurve);
	}

	public List<? extends AbstractCurve> getCurve() {
		return super.getGeometry();
	}

	public boolean isSetCurve() {
		return super.isSetGeometry();
	}

	@SuppressWarnings("unchecked")
	public void setCurve(List<? extends AbstractCurve> abstractCurve) {
		super.setGeometry((List<AbstractCurve>)abstractCurve);
	}

	public void unsetCurve() {
		super.unsetGeometry();
	}

	public boolean unsetCurve(AbstractCurve abstractCurve) {
		return super.unsetGeometry(abstractCurve);
	}

	public ModelType getModelType() {
		return ModelType.GML;
	}

	public GMLClass getGMLClass() {
		return GMLClass.CURVE_ARRAY_PROPERTY;
	}

	public Class<AbstractCurve> getAssociableClass() {
		return AbstractCurve.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CurveArrayProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CurveArrayProperty copy = (target == null) ? new CurveArrayProperty() : (CurveArrayProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
