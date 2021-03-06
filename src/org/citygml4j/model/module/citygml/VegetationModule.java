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
import java.util.HashMap;
import java.util.List;

import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.vegetation.PlantCover;
import org.citygml4j.model.citygml.vegetation.SolitaryVegetationObject;
import org.citygml4j.model.module.Module;

public class VegetationModule extends AbstractCityGMLModule {
	private static final List<VegetationModule> instances = new ArrayList<VegetationModule>();

	public static final VegetationModule v2_0_0;
	public static final VegetationModule v1_0_0;

	private VegetationModule (
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
		v2_0_0 = new VegetationModule (
				CityGMLModuleType.VEGETATION,
				CityGMLModuleVersion.v2_0_0,
				"http://www.opengis.net/citygml/vegetation/2.0",
				"veg",
				"http://schemas.opengis.net/citygml/vegetation/2.0/vegetation.xsd",			
				CoreModule.v2_0_0);
		
		v1_0_0 = new VegetationModule (
				CityGMLModuleType.VEGETATION,
				CityGMLModuleVersion.v1_0_0,
				"http://www.opengis.net/citygml/vegetation/1.0",
				"veg",
				"http://schemas.opengis.net/citygml/vegetation/1.0/vegetation.xsd",			
				CoreModule.v1_0_0);

		v2_0_0.elementMap = new HashMap<String, Class<? extends CityGML>>();
		v2_0_0.elementMap.put("SolitaryVegetationObject", SolitaryVegetationObject.class);
		v2_0_0.elementMap.put("PlantCover", PlantCover.class);
		v1_0_0.elementMap = v2_0_0.elementMap;
	}

	public static List<VegetationModule> getInstances() {
		return instances;
	}
	
	public static VegetationModule getInstance(CityGMLModuleVersion version) {
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
