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

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.Matrix;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.core.TransformationMatrix3x4;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.SRSReferenceGroup;
import org.citygml4j.model.module.citygml.AppearanceModule;

public class WorldToTexture extends TransformationMatrix3x4 implements AppearanceModuleComponent, SRSReferenceGroup {
	private Integer srsDimension;
	private String srsName;
	private List<String> axisLabels;
	private List<String> uomLabels;
	private AppearanceModule module;
	
	public WorldToTexture() {

	}
	
	public WorldToTexture(AppearanceModule module) {
		this.module = module;
	}

	public WorldToTexture(Matrix matrix) {
		super(matrix);
	}
	
	public WorldToTexture(List<Double> vals) {
		super(vals);
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.WORLD_TO_TEXTURE;
	}

	@Override
	public final AppearanceModule getCityGMLModule() {
		return module;
	}

	@Override
	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public Integer getSrsDimension() {
		return srsDimension;
	}

	public String getSrsName() {
		return srsName;
	}

	public String getInheritedSrsName() {
		if (srsName == null) {
			Child child = this;
			ModelObject parent = null;

			while ((parent = child.getParent()) != null) {
				if (parent instanceof AbstractGeometry)
					return ((AbstractGeometry)parent).getInheritedSrsName();
				else if (parent instanceof AbstractFeature) {
					AbstractFeature feature = (AbstractFeature)parent;
					if (feature.isSetBoundedBy() 
							&& feature.getBoundedBy().isSetEnvelope()
							&& feature.getBoundedBy().getEnvelope().isSetSrsName())
						return feature.getBoundedBy().getEnvelope().getSrsName();
				}

				if (parent instanceof Child)
					child = (Child)parent;
				else 
					break;
			}
		} 

		return srsName;
	}
	
	public boolean isSetSrsDimension() {
		return srsDimension != null;
	}

	public boolean isSetSrsName() {
		return srsName != null;
	}

	public void setSrsDimension(Integer srsDimension) {
		if (srsDimension > 0)
			this.srsDimension = srsDimension;
	}

	public void setSrsName(String srsName) {
		this.srsName = srsName;
	}

	public void unsetSrsDimension() {
		srsDimension = null;
	}

	public void unsetSrsName() {
		srsName = null;
	}

	public void addAxisLabel(String axisLabel) {
		if (axisLabels == null)
			axisLabels = new ArrayList<String>();
		
		axisLabels.add(axisLabel);
	}

	public void addUomLabel(String uomLabel) {
		if (uomLabels == null)
			uomLabels = new ArrayList<String>();
		
		uomLabels.add(uomLabel);
	}

	public List<String> getAxisLabels() {
		if (axisLabels == null)
			axisLabels = new ArrayList<String>();

		return axisLabels;
	}

	public List<String> getUomLabels() {
		if (uomLabels == null)
			uomLabels = new ArrayList<String>();

		return uomLabels;
	}

	public boolean isSetAxisLabels() {
		return axisLabels != null && !axisLabels.isEmpty();
	}

	public boolean isSetUomLabels() {
		return uomLabels != null && !uomLabels.isEmpty();
	}

	public void setAxisLabels(List<String> axisLabels) {
		this.axisLabels = axisLabels;
	}

	public void setUomLabels(List<String> uomLabels) {
		this.uomLabels = uomLabels;
	}

	public void unsetAxisLabels() {
		axisLabels = null;
	}

	public boolean unsetAxisLabels(String axisLabel) {
		return isSetAxisLabels() ? axisLabels.remove(axisLabel) : false;
	}

	public void unsetUomLabels() {
		uomLabels = null;
	}

	public boolean unsetUomLabels(String uomLabel) {
		return isSetUomLabels() ? uomLabels.remove(uomLabel) : false;
	}

	public GMLClass getGMLClass() {
		return GMLClass.SRS_REFERENCE_GROUP;
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new WorldToTexture(), copyBuilder);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		WorldToTexture copy = (target == null) ? new WorldToTexture() : (WorldToTexture)target;
		super.copyTo(copy, copyBuilder);

		if (isSetSrsDimension())
        	copy.setSrsDimension((Integer)copyBuilder.copy(srsDimension));
        
        if (isSetSrsName())
        	copy.setSrsName(copyBuilder.copy(srsName));
        
        if (isSetAxisLabels())
        	copy.setAxisLabels((List<String>)copyBuilder.copy(axisLabels));
        
        if (isSetUomLabels())
        	copy.setUomLabels((List<String>)copyBuilder.copy(uomLabels));
		
		return copy;
	}

}
