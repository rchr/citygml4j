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
package org.citygml4j.model.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.citygml4j.model.module.citygml.CityGMLModule;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.gml.GMLModule;
import org.citygml4j.model.module.xal.XALModule;

public class ModuleContext {
	private HashMap<ModuleType, Module> modules = new  HashMap<ModuleType, Module>();
	
	public ModuleContext() {
		this(CityGMLVersion.DEFAULT);
	}
	
	public ModuleContext(CityGMLVersion version) {
		for (ModuleType type : Modules.modules.keySet())
			modules.put(type, null);
		
		for (Module module : version.getModules())
			modules.put(module.getType(), module);
	}
	
	public ModuleContext(ModuleContext moduleContext) {
		for (Module module : moduleContext.getModules())
			modules.put(module.getType(), module);
	}
	
	public Module getModule(ModuleType type) {
		return modules.get(type);
	}
	
	public boolean contains(Module module) {
		return modules.values().contains(module);
	}

	public List<Module> getModules() {
		List<Module> modules = new ArrayList<Module>();
		for (Module module : this.modules.values())
			if (module != null)
				modules.add((Module)module);
		
		return modules;
	}	
	
	public List<CityGMLModule> getCityGMLModules() {
		List<CityGMLModule> modules = new ArrayList<CityGMLModule>();
		for (Module module : this.modules.values())
			if (module instanceof CityGMLModule)
				modules.add((CityGMLModule)module);
		
		return modules;
	}
	
	public List<GMLModule> getGMLModules() {
		List<GMLModule> modules = new ArrayList<GMLModule>();
		for (Module module : this.modules.values())
			if (module instanceof GMLModule)
				modules.add((GMLModule)module);
		
		return modules;
	}
	
	public List<XALModule> getXALModules() {
		List<XALModule> modules = new ArrayList<XALModule>();
		for (Module module : this.modules.values())
			if (module instanceof XALModule)
				modules.add((XALModule)module);
		
		return modules;
	}
	
	public boolean setModule(Module module) {
		for (Module dependency : module.getDependencies())
			if (!contains(dependency))
				return false;
		
		modules.put(module.getType(), module);
		return true;
	}
	
	public void setModules(ModuleContext moduleContext) {
		modules.clear();
		
		for (Module module : moduleContext.getModules())
			modules.put(module.getType(), module);
	}
	
	public void setCityGMLVersion(CityGMLVersion version) {
		for (ModuleType type : Modules.modules.keySet())
			modules.put(type, null);
		
		for (Module module : version.getModules())
			modules.put(module.getType(), module);
	}
	
}
