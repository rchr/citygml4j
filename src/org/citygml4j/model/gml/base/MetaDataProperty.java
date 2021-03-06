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
package org.citygml4j.model.gml.base;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;

public class MetaDataProperty extends AssociationByRepOrRef<MetaData> {
	private String about;
	
	public MetaDataProperty() {
		
	}
	
	public MetaDataProperty(MetaData metaData) {
		super(metaData);
	}
	
	public MetaDataProperty(String href) {
		super(href);
	}
	
	public String getAbout() {
		return about;
	}

	public MetaData getMetaData() {
		return super.getObject();
	}

	public boolean isSetAbout() {
		return about != null;
	}

	public boolean isSetMetaData() {
		return super.isSetObject();
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public void setMetaData(MetaData metaData) {
		super.setObject(metaData);
	}

	public void unsetAbout() {
		about = null;
	}

	public void unsetMetaData() {
		super.unsetObject();
	}

	public GMLClass getGMLClass() {
		return GMLClass.META_DATA_PROPERTY;
	}
	
	public Class<MetaData> getAssociableClass() {
		return MetaData.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MetaDataProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MetaDataProperty copy = (target == null) ? new MetaDataProperty() : (MetaDataProperty)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetAbout())
			copy.setAbout(copyBuilder.copy(about));
		
		return copy;
	}

}
