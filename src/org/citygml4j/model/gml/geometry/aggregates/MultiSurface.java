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
package org.citygml4j.model.gml.geometry.aggregates;

import java.util.Arrays;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;
import org.citygml4j.model.gml.geometry.primitives.SurfaceArrayProperty;
import org.citygml4j.model.gml.geometry.primitives.SurfaceProperty;

public class MultiSurface extends AbstractGeometricAggregate {
	private List<SurfaceProperty> surfaceMember;
	private SurfaceArrayProperty surfaceMembers;
	
	public MultiSurface() {
		
	}
	
	public MultiSurface(List<? extends AbstractSurface> abstractSurfaces) {
		for (AbstractSurface abstractSurface : abstractSurfaces)
			addSurfaceMember(new SurfaceProperty(abstractSurface));
	}
	
	public MultiSurface(AbstractSurface... abstractSurfaces) {
		this(Arrays.asList(abstractSurfaces));
	}
	
	public void addSurfaceMember(SurfaceProperty surfaceMember) {
		if (this.surfaceMember == null)
			this.surfaceMember = new ChildList<SurfaceProperty>(this);
		
		this.surfaceMember.add(surfaceMember);
	}

	public List<SurfaceProperty> getSurfaceMember() {
		if (surfaceMember == null)
			surfaceMember = new ChildList<SurfaceProperty>(this);
		
		return surfaceMember;
	}

	public SurfaceArrayProperty getSurfaceMembers() {
		return surfaceMembers;
	}

	public boolean isSetSurfaceMember() {
		return surfaceMember != null && !surfaceMember.isEmpty();
	}

	public boolean isSetSurfaceMembers() {
		return surfaceMembers != null;
	}

	public void setSurfaceMember(List<SurfaceProperty> surfaceMember) {
		this.surfaceMember = new ChildList<SurfaceProperty>(this, surfaceMember);
	}

	public void setSurfaceMembers(SurfaceArrayProperty surfaceMembers) {
		if (surfaceMembers != null)
			surfaceMembers.setParent(this);
		
		this.surfaceMembers = surfaceMembers;
	}

	public void unsetSurfaceMember() {
		if (isSetSurfaceMember())
			surfaceMember.clear();
		
		surfaceMember = null;
	}

	public boolean unsetSurfaceMember(SurfaceProperty surfaceMember) {
		return isSetSurfaceMember() ? this.surfaceMember.remove(surfaceMember) : false;
	}

	public void unsetSurfaceMembers() {
		if (isSetSurfaceMembers())
			surfaceMembers.unsetParent();
		
		surfaceMembers = null;
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (isSetSurfaceMember()) {
			for (SurfaceProperty surfaceProperty : getSurfaceMember())
				if (surfaceProperty.isSetSurface())
					bbox.update(surfaceProperty.getSurface().calcBoundingBox());
		}

		if (isSetSurfaceMembers()) {
			SurfaceArrayProperty surfaceArrayProperty = getSurfaceMembers();

			if (surfaceArrayProperty.isSetSurface())
				for (AbstractSurface abstractSurface : surfaceArrayProperty.getSurface())
					bbox.update(abstractSurface.calcBoundingBox());
		}
		
		if (bbox.getLowerCorner().isEqual(Double.MAX_VALUE) && 
				bbox.getUpperCorner().isEqual(-Double.MAX_VALUE))
			return null;
		else
			return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.MULTI_SURFACE;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MultiSurface(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MultiSurface copy = (target == null) ? new MultiSurface() : (MultiSurface)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetSurfaceMember()) {
			for (SurfaceProperty part : surfaceMember) {
				SurfaceProperty copyPart = (SurfaceProperty)copyBuilder.copy(part);
				copy.addSurfaceMember(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetSurfaceMembers()) {
			copy.setSurfaceMembers((SurfaceArrayProperty)copyBuilder.copy(surfaceMembers));
			if (copy.getSurfaceMembers() == surfaceMembers)
				surfaceMembers.setParent(this);
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
