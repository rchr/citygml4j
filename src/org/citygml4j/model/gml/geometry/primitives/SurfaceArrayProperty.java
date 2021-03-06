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

public class SurfaceArrayProperty extends GeometryArrayProperty<AbstractSurface> {
	
	public SurfaceArrayProperty() {

	}

	public SurfaceArrayProperty(AbstractSurface abstractSurface) {
		super(abstractSurface);
	}

	public SurfaceArrayProperty(List<AbstractSurface> abstractSurface) {
		super(abstractSurface);
	}
	
	public SurfaceArrayProperty(AbstractSurface... abstractSurface) {
		super(abstractSurface);
	}
	
	public void addSurface(AbstractSurface abstractSurface) {
		super.addGeometry(abstractSurface);
	}

	public List<? extends AbstractSurface> getSurface() {
		return super.getGeometry();
	}

	public boolean isSetSurface() {
		return super.isSetGeometry();
	}

	@SuppressWarnings("unchecked")
	public void setSurface(List<? extends AbstractSurface> abstractSurface) {
		super.setGeometry((List<AbstractSurface>)abstractSurface);
	}

	public void unsetSurface() {
		super.unsetGeometry();
	}

	public boolean unsetSurface(AbstractSurface abstractSurface) {
		return super.unsetGeometry(abstractSurface);
	}

	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.SURFACE_ARRAY_PROPERTY;
	}

	public Class<AbstractSurface> getAssociableClass() {
		return AbstractSurface.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new SurfaceArrayProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		SurfaceArrayProperty copy = (target == null) ? new SurfaceArrayProperty() : (SurfaceArrayProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
