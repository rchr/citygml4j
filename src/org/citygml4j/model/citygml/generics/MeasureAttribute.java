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
package org.citygml4j.model.citygml.generics;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.basicTypes.Measure;
import org.citygml4j.model.module.citygml.GenericsModule;

public class MeasureAttribute extends AbstractGenericAttribute {
	private Measure value;

	public MeasureAttribute() {

	}

	public MeasureAttribute(GenericsModule module) {
		super(module);
	}

	public Measure getValue() {
		return value;
	}

	public boolean isSetValue() {
		return value != null;
	}

	public void setValue(Measure value) {
		this.value = value;
	}

	public void unsetValue() {
		value = null;
	}

	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.MEASURE_ATTRIBUTE;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MeasureAttribute(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MeasureAttribute copy = (target == null) ? new MeasureAttribute() : (MeasureAttribute)target;
		super.copyTo(copy, copyBuilder);

		if (isSetValue())
			copy.setValue((Measure)copyBuilder.copy(value));

		return copy;
	}

}
