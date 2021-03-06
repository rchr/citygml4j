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

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.base.AssociationByRepOrRef;
import org.citygml4j.model.module.citygml.AppearanceModule;

public class TextureAssociation extends AssociationByRepOrRef<AbstractTextureParameterization> implements AppearanceModuleComponent {
	private String uri;
	private AppearanceModule module;
	
	public TextureAssociation() {
		
	}
	
	public TextureAssociation(AbstractTextureParameterization abstractTextureParameterization) {
		super(abstractTextureParameterization);
	}
	
	public TextureAssociation(String href) {
		super(href);
	}
	
	public TextureAssociation(AppearanceModule module) {
		this.module = module;
	}
	
	public AbstractTextureParameterization getTextureParameterization() {
		return super.getObject();
	}

	public String getUri() {
		return uri;
	}

	public boolean isSetTextureParameterization() {
		return super.isSetObject();
	}

	public boolean isSetUri() {
		return uri != null;
	}

	public void setTextureParameterization(AbstractTextureParameterization textureParameterization) {
		super.setObject(textureParameterization);
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public void unsetTextureParameterization() {
		super.unsetObject();
	}

	public void unsetUri() {
		uri = null;
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TEXTURE_ASSOCIATION;
	}

	public final AppearanceModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public Class<AbstractTextureParameterization> getAssociableClass() {
		return AbstractTextureParameterization.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new TextureAssociation(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		TextureAssociation copy = (target == null) ? new TextureAssociation() : (TextureAssociation)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetUri())
			copy.setUri(copyBuilder.copy(uri));
		
		return copy;
	}

}
