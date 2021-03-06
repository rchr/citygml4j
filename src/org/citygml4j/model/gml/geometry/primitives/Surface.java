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

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;

public class Surface extends AbstractSurface {
	private SurfacePatchArrayProperty patches;
	
	public SurfacePatchArrayProperty getPatches() {
		return patches;
	}

	public boolean isSetPatches() {
		return patches != null;
	}

	public void setPatches(SurfacePatchArrayProperty patches) {
		if (patches != null)
			patches.setParent(this);
		
		this.patches = patches;
	}

	public void unsetPatches() {
		if (isSetPatches())
			patches.unsetParent();
		
		patches = null;
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (getPatches() != null) {
			SurfacePatchArrayProperty arrayProperty = getPatches();
			
			if (arrayProperty.isSetSurfacePatch())
				for (AbstractSurfacePatch surfacePatch : arrayProperty.getSurfacePatch())
					bbox.update(surfacePatch.calcBoundingBox());
		}
		
		if (bbox.getLowerCorner().isEqual(Double.MAX_VALUE) && 
				bbox.getUpperCorner().isEqual(-Double.MAX_VALUE))
			return null;
		else
			return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.SURFACE;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new Surface(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Surface copy = (target == null) ? new Surface() : (Surface)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetPatches()) {
			copy.setPatches((SurfacePatchArrayProperty)copyBuilder.copy(patches));
			if (copy.getPatches() == patches)
				patches.setParent(this);
		}
		
		return copy;
	}
	
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}

	public <T> T accept(GeometryFunctor<T> visitor) {
		return visitor.apply(this);
	}
	
	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
