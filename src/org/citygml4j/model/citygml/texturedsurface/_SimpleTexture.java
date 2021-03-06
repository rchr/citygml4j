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
package org.citygml4j.model.citygml.texturedsurface;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.module.citygml.TexturedSurfaceModule;

public class _SimpleTexture extends _AbstractAppearance {
	private String textureMap;
	private List<Double> textureCoordinates;
	private _TextureType _textureType;
	private Boolean repeat;
	
	public _SimpleTexture() {
		
	}
	
	public _SimpleTexture(TexturedSurfaceModule module) {
		super(module);
	}
	
	public Boolean getRepeat() {
		return repeat;
	}

	public List<Double> getTextureCoordinates() {
		if (textureCoordinates == null)
			textureCoordinates = new ArrayList<Double>();
		
		return textureCoordinates;
	}

	public String getTextureMap() {
		return textureMap;
	}

	public _TextureType getTextureType() {
		return _textureType;
	}

	public boolean isSetRepeat() {
		return repeat != null;
	}

	public boolean isSetTextureCoordinates() {
		return textureCoordinates != null && !textureCoordinates.isEmpty();
	}

	public boolean isSetTextureMap() {
		return textureMap != null;
	}

	public boolean isSetTextureType() {
		return _textureType != null;
	}

	public void setRepeat(Boolean repeat) {
		this.repeat = repeat;
	}

	public void setTextureCoordinates(List<Double> textureCoordinates) {
		this.textureCoordinates = textureCoordinates;
	}

	public void setTextureMap(String textureMap) {
		this.textureMap = textureMap;
	}

	public void setTextureType(_TextureType _textureType) {
		this._textureType = _textureType;
	}

	public void unsetRepeat() {
		repeat = null;
	}

	public void unsetTextureType() {
		_textureType = null;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass._SIMPLE_TEXTURE;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new _SimpleTexture(), copyBuilder);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		_SimpleTexture copy = (target == null) ? new _SimpleTexture() : (_SimpleTexture)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetTextureMap())
			copy.setTextureMap(copyBuilder.copy(textureMap));
		
		if (isSetTextureCoordinates())
			copy.setTextureCoordinates((List<Double>)copyBuilder.copy(textureCoordinates));
		
		if (isSetTextureType())
			copy.setTextureType((_TextureType)copyBuilder.copy(_textureType));
		
		if (isSetRepeat())
			copy.setRepeat(copyBuilder.copy(repeat));
		
		return copy;
	}
	
	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
