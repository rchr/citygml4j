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
package org.citygml4j.model.module.citygml;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.model.module.Module;

public class TexturedSurfaceModule extends AbstractCityGMLModule {
	private static final List<TexturedSurfaceModule> instances = new ArrayList<TexturedSurfaceModule>();

	public static final TexturedSurfaceModule v2_0_0;
	public static final TexturedSurfaceModule v1_0_0;

	private TexturedSurfaceModule (
			CityGMLModuleType type, 
			CityGMLModuleVersion version,
			String namespaceURI, 
			String namespacePrefix, 
			String schemaLocation,
			Module... dependencies) {
		super(type, version, namespaceURI, namespacePrefix, schemaLocation, dependencies);		
		instances.add(this);
	}

	static {
		v2_0_0 = new TexturedSurfaceModule (
				CityGMLModuleType.TEXTURED_SURFACE,
				CityGMLModuleVersion.v2_0_0,
				"http://www.opengis.net/citygml/texturedsurface/2.0",
				"tex",
				"http://schemas.opengis.net/citygml/texturedsurface/2.0/texturedSurface.xsd",			
				CoreModule.v2_0_0);
		
		v1_0_0 = new TexturedSurfaceModule (
				CityGMLModuleType.TEXTURED_SURFACE,
				CityGMLModuleVersion.v1_0_0,
				"http://www.opengis.net/citygml/texturedsurface/1.0",
				"tex",
				"http://schemas.opengis.net/citygml/texturedsurface/1.0/texturedSurface.xsd",			
				CoreModule.v1_0_0);
	}

	public static List<TexturedSurfaceModule> getInstances() {
		return instances;
	}
	
	public static TexturedSurfaceModule getInstance(CityGMLModuleVersion version) {
		switch (version) {
		case v2_0_0:
			return v2_0_0;
		case v1_0_0:
			return v1_0_0;
		default:
			return null;
		}
	}

}
