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
package org.citygml4j.xml.io;

import java.io.File;
import java.io.InputStream;

import javax.xml.bind.ValidationEventHandler;
import javax.xml.stream.XMLInputFactory;
import javax.xml.transform.Templates;

import org.citygml4j.util.gmlid.GMLIdManager;
import org.citygml4j.xml.io.reader.CityGMLInputFilter;
import org.citygml4j.xml.io.reader.CityGMLReadException;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.writer.CityGMLWriteException;
import org.citygml4j.xml.schema.SchemaHandler;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public interface CityGMLInputFactory {
	public static final String FEATURE_READ_MODE = "org.citygml4j.featureReadMode";
	public static final String KEEP_INLINE_APPEARANCE = "org.citygml4j.keepInlineAppearance";
	public static final String PARSE_SCHEMA = "org.citygml4j.parseSchema";
	public static final String SPLIT_AT_FEATURE_PROPERTY = "org.citygml4j.splitAtFeatureProperty";
	public static final String EXCLUDE_FROM_SPLITTING = "org.citygml4j.excludeFromSplitting";
	public static final String USE_VALIDATION = "org.citygml4j.useValidation";
	public static final String FAIL_ON_MISSING_ADE_SCHEMA = "org.citygml4j.failOnMissingADESchema";
	public static final String SUPPORT_CITYGML_VERSION_0_4_0 = "org.citygml4j.supportCityGML040";
	
	public XMLInputFactory getXMLInputFactory();
	public GMLIdManager getGMLIdManager();
	public SchemaHandler getSchemaHandler();
	public ValidationEventHandler getValidationEventHandler();
	public Templates[] getTransformationTemplates();
	public Object getProperty(String name);
	public void setXMLInputFactory(XMLInputFactory xmlInputFactory);	
	public void setGMLIdManager(GMLIdManager gmlIdManager);
	public void setSchemaHandler(SchemaHandler schemaHandler);
	public void setValidationEventHandler(ValidationEventHandler validationEventHandler);
	public void setTransformationTemplates(Templates... templates) throws CityGMLWriteException;
	public void setProperty(String name, Object value);
	
	public boolean registerSchemaLocation(String namespaceURI, File schemaLocation);
	public void parseSchema(File schemaLocation) throws SAXException;
	public void parseSchema(String namespaceURI, String schemaLocation) throws SAXException;
	public void parseSchema(Element element) throws SAXException;
	
	public CityGMLReader createCityGMLReader(File file) throws CityGMLReadException;	
	public CityGMLReader createCityGMLReader(File file, String encoding) throws CityGMLReadException;
	public CityGMLReader createCityGMLReader(String systemId, InputStream in) throws CityGMLReadException;	
	public CityGMLReader createCityGMLReader(String systemId, InputStream in, String encoding) throws CityGMLReadException;

	public CityGMLReader createFilteredCityGMLReader(CityGMLReader reader, CityGMLInputFilter filter);
}
